package ciecc.swzf.zbasecase.service.impl;

import ciecc.swzf.common.constant.PromptMessageConsts;
import ciecc.swzf.common.constant.ZBaseCaseConsts;
import ciecc.swzf.common.dao.UserDao;
import ciecc.swzf.common.dao.ZlawPeoDao;
import ciecc.swzf.common.entity.*;
import ciecc.swzf.common.util.ConcurrentDateUtil;
import ciecc.swzf.common.util.JsonMsgUtils;
import ciecc.swzf.common.util.ReflectionUtil;
import ciecc.swzf.common.util.RegExpUtil;
import ciecc.swzf.zbasecase.dao.ZBaseCaseDao;
import ciecc.swzf.zbasecase.service.AdditionalRecodingCaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.jws.WebService;
import java.util.*;

/**
 * @author kandigx
 * @create 2017-09-13 16:40
 *
 * CaseDTO 中的属性值放到 CaseDO 中
 * 再根据 @Column 注解判断空值及长度
 *
 * 验证所有属性，一次性返回
 */
@WebService
@Component
public class AdditionalRecodingCaseServiceImpl implements AdditionalRecodingCaseService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ZlawPeoDao zlawPeoDao;

    @Autowired
    private ZBaseCaseDao zBaseCaseDao;

    @Transactional
    public synchronized String transferZBaseCase(CaseDTO baseCase) {
        //错误信息
        List<ErrorMsgVO> errorList = new ArrayList<>();

        //日期格式校验
        if (!RegExpUtil.isDateFormatter(baseCase.getReportDate()) ||
                !RegExpUtil.isDateFormatter(baseCase.getJieanDate())) {
            errorList.add(new ErrorMsgVO(PromptMessageConsts.ERROR_CODE_DATE_INCORRECT_FORMAT,
                    "ReportDate=" + baseCase.getReportDate()
                    + " JieanDate=" + baseCase.getJieanDate()));
        }

        //检查结果验证
        List<ErrorMsgVO>  checkResultErrorList = checkResultValidate(baseCase);
        if (checkResultErrorList.size() > 0){
            errorList.addAll(checkResultErrorList);
        }

        //新建执法案件，用于保存补录案件
        ZBaseCaseDO caseDO = new ZBaseCaseDO();
        //复制属性
        BeanUtils.copyProperties(baseCase, caseDO);


        //@Column 约束信息
        List<ErrorMsgVO>  columnConstraintErrorList = new ArrayList<>();
        try {
            caseDO.setReportTime(ConcurrentDateUtil.parse(baseCase.getReportDate()));
            caseDO.setJieanTime(ConcurrentDateUtil.parse(baseCase.getJieanDate()));
            //@Column 注解条件验证属性
            columnConstraintErrorList = ReflectionUtil.DOColumnConstraint(caseDO.getClass(), caseDO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (columnConstraintErrorList.size() > 0) {
            errorList.addAll(columnConstraintErrorList);
        }

        //根据 userCode 获取用户
        User user = userDao.getByUserCode(baseCase.getUserCode());
        List<String> idList = new ArrayList<>();
        if (user == null) {
            errorList.add(new ErrorMsgVO(PromptMessageConsts.ERROR_CODE_NOT_EXIST_USERCODE,
                    "userCode=" + baseCase.getUserCode()));
        } else {
            //根据 opManName 获取执法员信息，将执法员id放入 opMan
            Map<String,ZlawPeo> zlawPeoMap = zlawPeoDao.getZlawPeoMapByNameList(user.getRecordId(), Arrays.asList(baseCase.getOpManName().split(",")));
            for (Map.Entry entry : zlawPeoMap.entrySet()){
                if (entry.getValue() == null) {
                    errorList.add(new ErrorMsgVO(PromptMessageConsts.ERROR_CODE_NOT_EXIST_OPERATION_PERSON,
                            "opManName=" + entry.getKey()));
                    continue;
                }
                idList.add(((ZlawPeo) entry.getValue()).getId());
            }
        }
        //有错误直接返回
        if (errorList.size() > 0) {
            StringBuilder returnMsg = new StringBuilder();
            for (int i = 0 ; i < errorList.size(); i++){
                if (i > 0) {
                    returnMsg.append(", ");
                }
                returnMsg.append(errorList.get(i).toString());
            }
            return JsonMsgUtils.returnJsonMsg(ZBaseCaseConsts.FALSE,returnMsg.toString());
        }

        //逗号分隔符分隔id
        caseDO.setOpMan(StringUtils.arrayToDelimitedString(idList.toArray(),","));

        caseDO.setAreaCode(user.getRecordId()); //报送案件人所在地区编码

        //固定信息
        caseDO.setStatus(ZBaseCaseConsts.STATUS_CLOSED); //已结案
        caseDO.setFillType(ZBaseCaseConsts.FILL_TYPE_ADDITIONAL_RECORDING); //补录案件
        caseDO.setSysFillTime(new Date()); //系统时间
        caseDO.setIsYisong(ZBaseCaseConsts.TRANSFER_NO);//非移送案件
        caseDO.setIsDel(ZBaseCaseConsts.DELETABLE_FALSE); //未删除
        zBaseCaseDao.save(caseDO);
        return JsonMsgUtils.returnJsonMsg(ZBaseCaseConsts.TRUE,PromptMessageConsts.MSG_SAVED_SUCCESSFULLY);
    }

    /**
     * 检查结果验证
     * @param baseCase
     * @return
     */
    private List<ErrorMsgVO> checkResultValidate(CaseDTO baseCase) {
        List<ErrorMsgVO> errorList = new ArrayList<>();
        //违规
        if (ZBaseCaseConsts.CHECK_RESULT_ILLEGAL.equals(baseCase.getCheckResult())) {
            int flag = 0;
            boolean[] checkResult = {Boolean.parseBoolean(baseCase.getPunTypeFk()),
                    Boolean.parseBoolean(baseCase.getPunTypeJg()),Boolean.parseBoolean(baseCase.getPunTypeMs()),
                    Boolean.parseBoolean(baseCase.getPunTypeTc()),Boolean.parseBoolean(baseCase.getPunTypeZk())};
            //违规时，5选1必填
            for (boolean i : checkResult){
                if (i) {
                    flag++;
                }
            }
            //未选择处罚种类
            if (flag == 0) {
                errorList.add(new ErrorMsgVO(PromptMessageConsts.ERROR_CODE_CHECK_RESULT_ILLEGAL_UNCHECK,
                        "checkResult=" + baseCase.getCheckResult() ));
            }
            //处罚金额为空
            if (Boolean.parseBoolean(baseCase.getPunTypeFk()) && baseCase.getChuFaMoney() == null) {
                errorList.add(new ErrorMsgVO(PromptMessageConsts.ERROR_CODE_CHECK_RESULT_ILLEGAL_NULL_FINE,
                        "chuFaMoney=" + baseCase.getChuFaMoney()));
            }

        }else{
            //非违规时，选项清空
            baseCase.setPunTypeFk(ZBaseCaseConsts.FALSE);
            baseCase.setPunTypeJg(ZBaseCaseConsts.FALSE);
            baseCase.setPunTypeMs(ZBaseCaseConsts.FALSE);
            baseCase.setPunTypeTc(ZBaseCaseConsts.FALSE);
            baseCase.setPunTypeZk(ZBaseCaseConsts.FALSE);
            baseCase.setChuFaMoney(null);
        }
        return errorList;
    }

}
