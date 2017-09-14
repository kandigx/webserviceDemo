package ciecc.swzf.common.constant;

/**
 * @author kandigx
 * @create 2017-09-14 16:26
 */
public class ErrorConsts {

    public static final String ERROR_INCOMPLETED = "001"; //数据不完整，缺失字段
    public static final String ERROR_INDEX_OUT_OF_BOUNDS = "002"; //指标项错误，不在允许范围之内
    public static final String ERROR_LENGTH_OUT_OF_RANGE = "003"; //字段长度超出标准
    public static final String ERROR_VALUE_NOT_EXIST_IN_TABLE = "004"; //字段值在数据库中没有找到对应的表数据
    public static final String ERROR_NOT_IN_THE_CORRECT_FORMAT = "004"; //格式不正确

}
