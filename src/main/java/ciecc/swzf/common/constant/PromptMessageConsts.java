package ciecc.swzf.common.constant;

/**
 * @author kandigx
 * @create 2017-09-14 16:26
 */
public class PromptMessageConsts {

    public static final String ERROR_CODE_INCOMPLETED = "Error_001"; //数据不完整，缺失字段
    public static final String ERROR_CODE_DATE_INCORRECT_FORMAT = "Error_002"; //日期格式不正确
    public static final String ERROR_CODE_LENGTH_OUT_OF_RANGE = "Error_003"; //字段长度超出标准
    public static final String ERROR_CODE_NOT_EXIST_USERCODE = "Error_004"; //填报的账号不存在
    public static final String ERROR_CODE_NOT_EXIST_OPERATION_PERSON = "Error_005"; //填报的账号所在地区不存在此办案人员
    public static final String ERROR_CODE_CHECK_RESULT_ILLEGAL_UNCHECK = "Error_006"; //检查结果为违规，但未选择处罚种类
    public static final String ERROR_CODE_CHECK_RESULT_ILLEGAL_NULL_FINE = "Error_007"; //处罚种类为罚款，但未填写罚款金额
    public static final String ERROR_CODE_VALUE_NOT_EXIST_IN_TABLE = "Error_008"; //字段值在数据库中没有找到对应的表数据
    public static final String ERROR_CODE_INDEX_OUT_OF_BOUNDS = "Error_009"; //指标项错误，不在允许范围之内

    public static final String ERROR_DESCR_INCOMPLETED = "字段为空！"; //数据不完整，缺失字段
    public static final String ERROR_DESCR_DATE_INCORRECT_FORMAT = "日期格式错误（yyyy-mm-dd）！";
    public static final String ERROR_DESCR_LENGTH_OUT_OF_RANGE = "字段长度超出标准！"; //字段长度超出标准
    public static final String ERROR_DESCR_CHECK_RESULT_ILLEGAL_UNCHECK = "检查结果为违规，但未选择处罚种类！";
    public static final String ERROR_DESCR_CHECK_RESULT_ILLEGAL_NULL_FINE = "处罚种类为罚款，但未填写罚款金额！";
    public static final String ERROR_DESCR_NOT_EXIST_USERCODE = "填报的账号不存在！";
    public static final String ERROR_DESCR_NOT_EXIST_OPERATION_PERSON = "填报的账号所在地区不存在此办案人员！请检查办案人员姓名与系统中执法员姓名是否一致！";

    public static final String MSG_SAVED_SUCCESSFULLY = "数据符合标准，保存成功！";
    public static final String MSG_SAVED_FAILED = "数据保存失败！请联系对接系统技术人员！";



}
