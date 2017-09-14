package ciecc.swzf.zbasecase.service.impl;

import ciecc.swzf.common.constant.ZBaseCaseConsts;
import ciecc.swzf.common.entity.ZBaseCaseDO;
import ciecc.swzf.common.util.ReflectionUtil;
import ciecc.swzf.zbasecase.dao.ZBaseCaseDao;
import ciecc.swzf.zbasecase.service.ZBaseCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import java.util.Date;

/**
 * @author kandigx
 * @create 2017-09-13 16:40
 */
@WebService
@Component
public class ZBaseCaseServiceImpl implements ZBaseCaseService {

    @Autowired
    private ZBaseCaseDao zBaseCaseDao;

    @Transactional
    public synchronized String transferZBaseCase(ZBaseCaseDO baseCase) {
        String msg = "数据验证中...";

        //数据约束验证
        msg = ReflectionUtil.DOConstraint(baseCase,baseCase.getClass());


        baseCase.setSysFillTime(new Date());
        baseCase.setFillType(ZBaseCaseConsts.FILL_TYPE_ADDITIONAL_RECORDING); //补录案件
        baseCase.setStatus(ZBaseCaseConsts.STATUS_CLOSED); //已结案
        baseCase.setAreaCode("350100"); //报送案件人所在地区编码
        baseCase.setIsYisong(ZBaseCaseConsts.TRANSFER_NO);//非移送案件
        baseCase.setIsDel(ZBaseCaseConsts.DELETABLE_FALSE); //未删除


        zBaseCaseDao.save(baseCase);
        return msg;
    }
}
