package ciecc.swzf.common.entity;

/**
 * 案件基本信息 DTO 传输对象
 * 只取部分 DO 的属性，保持客户端设置属性时的简洁与明确
 * @author kandigx
 * @create 2017-09-13 10:21
 */
public class CaseDTO {

    private String userCode; //用户账号

    private String trType; //操作类型

    private String trTunitType; //被检查/被举报方类型

    private String trTunit; //被检查/被举报方单位（人）

    private String trTunitLegal; //被检查/被举报方单位（人）法定代表人

    private String trTunitAddress; //被检查/被举报方单位（人）地址

    private String trTunitCheckItem; //被检查/被举报方单位（人）检查项目/案件类型

    private String checkResult; //检查结果（0是合规，1是违规，2是整改，3是未检查成功）

    private String reportDate; //上报时间/受理时间

    private String jieanDate; //结案或移送完成时间

    private String stage; //阶段（2合规;3简易程序;4一般程序；41立案；42销案；43移案;5移交;51移送司法）

    private String punTypeJg = "false"; //处罚种类-警告

    private String punTypeFk = "false"; //处罚种类-罚款

    private String punTypeMs = "false"; //处罚种类-没收违法所得、没收非法财物

    private String punTypeTc = "false"; //处罚种类-责令停产停业

    private String punTypeZk = "false"; //处罚种类-暂扣或者吊销许可证、执照

    private Double chuFaMoney ; //处罚金额

    private String anJianShuoMing; //案件说明

    private String opManName; //办案人名称

    private String areaCode;

    public String isPunTypeJg() {
        return punTypeJg;
    }

    public String isPunTypeFk() {
        return punTypeFk;
    }

    public String isPunTypeMs() {
        return punTypeMs;
    }

    public String isPunTypeTc() {
        return punTypeTc;
    }

    public String isPunTypeZk() {
        return punTypeZk;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getTrType() {
        return trType;
    }

    public void setTrType(String trType) {
        this.trType = trType;
    }

    public String getTrTunitType() {
        return trTunitType;
    }

    public void setTrTunitType(String trTunitType) {
        this.trTunitType = trTunitType;
    }

    public String getTrTunit() {
        return trTunit;
    }

    public void setTrTunit(String trTunit) {
        this.trTunit = trTunit;
    }

    public String getTrTunitLegal() {
        return trTunitLegal;
    }

    public void setTrTunitLegal(String trTunitLegal) {
        this.trTunitLegal = trTunitLegal;
    }

    public String getTrTunitAddress() {
        return trTunitAddress;
    }

    public void setTrTunitAddress(String trTunitAddress) {
        this.trTunitAddress = trTunitAddress;
    }

    public String getTrTunitCheckItem() {
        return trTunitCheckItem;
    }

    public void setTrTunitCheckItem(String trTunitCheckItem) {
        this.trTunitCheckItem = trTunitCheckItem;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getJieanDate() {
        return jieanDate;
    }

    public void setJieanDate(String jieanDate) {
        this.jieanDate = jieanDate;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getPunTypeJg() {
        return punTypeJg;
    }

    public void setPunTypeJg(String punTypeJg) {
        this.punTypeJg = punTypeJg;
    }

    public String getPunTypeFk() {
        return punTypeFk;
    }

    public void setPunTypeFk(String punTypeFk) {
        this.punTypeFk = punTypeFk;
    }

    public String getPunTypeMs() {
        return punTypeMs;
    }

    public void setPunTypeMs(String punTypeMs) {
        this.punTypeMs = punTypeMs;
    }

    public String getPunTypeTc() {
        return punTypeTc;
    }

    public void setPunTypeTc(String punTypeTc) {
        this.punTypeTc = punTypeTc;
    }

    public String getPunTypeZk() {
        return punTypeZk;
    }

    public void setPunTypeZk(String punTypeZk) {
        this.punTypeZk = punTypeZk;
    }

    public Double getChuFaMoney() {
        return chuFaMoney;
    }

    public void setChuFaMoney(Double chuFaMoney) {
        this.chuFaMoney = chuFaMoney;
    }

    public String getAnJianShuoMing() {
        return anJianShuoMing;
    }

    public void setAnJianShuoMing(String anJianShuoMing) {
        this.anJianShuoMing = anJianShuoMing;
    }

    public String getOpManName() {
        return opManName;
    }

    public void setOpManName(String opManName) {
        this.opManName = opManName;
    }
}
