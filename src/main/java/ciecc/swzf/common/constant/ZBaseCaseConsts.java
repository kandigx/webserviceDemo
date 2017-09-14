package ciecc.swzf.common.constant;

/**
 * @author kandigx
 * @create 2017-09-14 13:47
 */
public class ZBaseCaseConsts {

    //操作类型(案件来源)0:执法检查，1:投诉举报，2:接转案件
    public static final String TR_TYPE_INSPECTION = "0"; //执法检查
    public static final String TR_TYPE_REPORT = "1"; //投诉举报
    public static final String TR_TYPE_RECEIVE = "2"; //接转案件

    //填报类型
    public static final String FILL_TYPE_NEW_BUILD = "0"; //新建案件
    public static final String FILL_TYPE_ADDITIONAL_RECORDING = "1"; //补录案件

    //案件所在节点
    //0案件来源;1监督检查;2合规;31行政处罚;32结案;41立案调查;42行政处罚;43结案;51移交;52结案;6完成
    public static final String STATUS_ORIGINAL = "0"; //0案件来源
    public static final String STATUS_INSPECTION = "1"; //1监督检查
    public static final String STATUS_COMPLIANCE = "2"; //2合规
    public static final String STATUS_A_PUNISHMENT = "31"; //0案件来源
    public static final String STATUS_A_CLOSED = "32"; //0案件来源
    public static final String STATUS_INVESTIGATION = "41"; //41立案调查
    public static final String STATUS_B_PUNISHMENT = "42"; //42行政处罚
    public static final String STATUS_B_CLOSED = "43"; //43结案
    public static final String STATUS_TRANSFER = "51"; //51移交
    public static final String STATUS_C_CLOSED = "52"; //52结案
    public static final String STATUS_CLOSED = "6"; //6结案

    //移送案件
    public static final String TRANSFER_NO = "0"; //0:不移送
    public static final String TRANSFER_YES = "1"; //1：移送
    public static final String TRANSFER_SPECIFIED = "2"; //2:指定办案人

    //是否删除 0:未删除 1:已删除
    public static final String DELETABLE_TRUE = "1";
    public static final String DELETABLE_FALSE = "0";




}
