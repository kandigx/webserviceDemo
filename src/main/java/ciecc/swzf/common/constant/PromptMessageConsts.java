package ciecc.swzf.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kandigx
 * @create 2017-09-14 16:26
 */
public class PromptMessageConsts {

    public static final String ERROR_CODE_INCOMPLETED = "error_001"; //数据不完整，缺失字段
    public static final String ERROR_CODE_DATE_INCORRECT_FORMAT = "error_002"; //日期格式不正确
    public static final String ERROR_CODE_LENGTH_OUT_OF_RANGE = "error_003"; //字段长度超出标准
    public static final String ERROR_CODE_NOT_EXIST_USERCODE = "error_004"; //填报的账号不存在
    public static final String ERROR_CODE_NOT_EXIST_OPERATION_PERSON = "error_005"; //填报的账号所在地区不存在此办案人员
    public static final String ERROR_CODE_CHECK_RESULT_ILLEGAL_UNCHECK = "error_006"; //检查结果为违规，但未选择处罚种类
    public static final String ERROR_CODE_CHECK_RESULT_ILLEGAL_NULL_FINE = "error_007"; //处罚种类为罚款，但未填写罚款金额
    public static final String ERROR_CODE_VALUE_NOT_EXIST_IN_TABLE = "error_008"; //字段值在数据库中没有找到对应的表数据
    public static final String ERROR_CODE_INDEX_OUT_OF_BOUNDS = "error_009"; //指标项错误，不在允许范围之内

    public static final String ERROR_DESCR_INCOMPLETED = "字段为空！"; //数据不完整，缺失字段
    public static final String ERROR_DESCR_DATE_INCORRECT_FORMAT = "日期格式错误（yyyy-mm-dd）！";
    public static final String ERROR_DESCR_LENGTH_OUT_OF_RANGE = "字段长度超出标准！"; //字段长度超出标准
    public static final String ERROR_DESCR_NOT_EXIST_USERCODE = "填报的账号不存在！";
    public static final String ERROR_DESCR_NOT_EXIST_OPERATION_PERSON = "填报的账号所在地区不存在此办案人员！请检查办案人员姓名与系统中执法员姓名是否一致！";
    public static final String ERROR_DESCR_CHECK_RESULT_ILLEGAL_UNCHECK = "检查结果为违规，但未选择处罚种类！";
    public static final String ERROR_DESCR_CHECK_RESULT_ILLEGAL_NULL_FINE = "处罚种类为罚款，但未填写罚款金额！";

    public static final String MSG_SAVED_SUCCESSFULLY = "数据符合标准，保存成功！";
    public static final String MSG_SAVED_FAILED = "数据保存失败！请联系对接系统技术人员！";

    public static Map<String,String> getErrorMsgMap(){
        Map<String, String> map = new HashMap<>();
        map.put(ERROR_CODE_INCOMPLETED,ERROR_DESCR_INCOMPLETED);
        map.put(ERROR_CODE_DATE_INCORRECT_FORMAT,ERROR_DESCR_DATE_INCORRECT_FORMAT);
        map.put(ERROR_CODE_LENGTH_OUT_OF_RANGE,ERROR_CODE_LENGTH_OUT_OF_RANGE);
        map.put(ERROR_CODE_NOT_EXIST_USERCODE,ERROR_DESCR_INCOMPLETED);
        map.put(ERROR_CODE_NOT_EXIST_OPERATION_PERSON,ERROR_DESCR_NOT_EXIST_OPERATION_PERSON);
        map.put(ERROR_CODE_CHECK_RESULT_ILLEGAL_UNCHECK,ERROR_DESCR_CHECK_RESULT_ILLEGAL_UNCHECK);
        map.put(ERROR_CODE_CHECK_RESULT_ILLEGAL_NULL_FINE,ERROR_DESCR_CHECK_RESULT_ILLEGAL_NULL_FINE);
        return map;
    }



}
