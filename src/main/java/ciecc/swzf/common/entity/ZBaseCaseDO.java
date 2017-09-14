package ciecc.swzf.common.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 案件基本信息 DO
 * @author kandigx
 * @create 2017-09-13 10:21
 */
@Entity
@Table(name = "ZBASE_CASE")
public class ZBaseCaseDO implements Serializable {

    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Id
    @Column(name = "ID", length = 32)
    private String id;

    @Column(name = "AREA_CODE", length = 6)
    private String areaCode;

    @Column(name = "IS_DEL", length = 1)
    private String isDel; //是否删除 0:未删除 1:已删除

    @Column(name = "OP_MAN", length = 2000)
    private String opMan; //办案人（组成员默认）存放把办案人id，逗号分隔

    @Column(name = "REPORT_TIME", nullable = false)
    private Date reportTime; //上报时间/受理时间

    @Column(name = "STAGE", length = 2, nullable = false)
    private String stage; //阶段（2合规;3简易程序;4一般程序；41立案；42销案；43移案;5移交;51移送司法）

    @Column(name = "STATUS", length = 2)
    private String status; //节点状态，用于标注案件所在节点（0案件来源;1监督检查;2合规;31行政处罚;32结案;41立案调查;42行政处罚;43结案;51移交;52结案;6完成）

    @Column(name = "SYS_FILL_COMPANY_NAME") //默认长度255
    private String sysFillCompanyName; //填写单位名称

    @Column(name = "SYS_FILL_MAN")
    private String sysFillMan; //填写人

    @Column(name = "SYS_FILL_TIME")
    private Date sysFillTime; //填写时间

    @Column(name = "TR_CASE_ADDRESS")
    private String trCaseAddress; //案件发生地点

    @Column(name = "TR_CASE_DATE")
    private Date trCaseDate; //案件发生日期/时间

    @Column(name = "TR_CASE_TYPE", length = 1)
    private String trCaseType;

    @Column(name = "TR_RUNIT")
    private String trRunit; //投诉举报单位（人）

    @Column(name = "TR_RUNIT_ADDRESS")
    private String trRunitAddress; //投诉举报单位（人）地址

    @Column(name = "TR_RUNIT_EMAIL")
    private String trRunitEmail; //投诉举报单位（人）电子邮件

    @Column(name = "TR_RUNIT_NAME")
    private String trRunitName; //投诉举报单位（人）单位名称

    @Column(name = "TR_RUNIT_PHONE")
    private String trRunitPhone; //投诉举报单位（人）电话

    @Column(name = "TR_RUNIT_TYPE", length = 1)
    private String trRunitType; //投诉举报单位（人）类型

    @Column(name = "TR_TUNIT", nullable = false)
    private String trTunit; //被检查/被举报方单位（人）

    @Column(name = "TR_TUNIT_ADDRESS", nullable = false)
    private String trTunitAddress; //被检查/被举报方单位（人）地址

    @Column(name = "TR_TUNIT_CHARGE")
    private String trTunitCharge; //被检查/被举报方单位（人）负责人

    @Column(name = "TR_TUNIT_CHECK_ITEM", length = 2, nullable = false)
    private String trTunitCheckItem; //被检查/被举报方单位（人）检查项目/案件类型

    @Column(name = "TR_TUNIT_LEGAL", nullable = false)
    private String trTunitLegal; //被检查/被举报方单位（人）法定代表人

    @Column(name = "TR_TUNIT_LICENSE_NO")
    private String trTunitLicenseNo; //被检查单位（人）营业执照编号

    @Column(name = "TR_TUNIT_PHONE")
    private String trTunitPhone; //被检查/被举报方单位（人）电话

    @Column(name = "TR_TUNIT_TYPE", length = 1, nullable = false)
    private String trTunitType; //被检查/被举报方类型

    @Column(name = "TR_TYPE", length = 1, nullable = false)
    private String trType; //操作类型

    @Column(name = "TR_UNIT_DATE")
    private Date trUnitDate; //投诉举报日期/时间

    @Column(name = "TR_UNIT_MESSAGE", length = 3900)
    private String trUnitMessage; //投诉举报内容

    @Column(name = "IS_YISONG", length = 1)
    private String isYisong; //1：移送;2:指定办案人

    @Column(name = "AREA_CODE_OLD", length = 6)
    private String areaCodeOld; //移送前地区

    @Column(name = "AREA_CODE_NEW", length = 6)
    private String areaCodeNew; //移送后地区

    @Column(name = "IS_YISONG_NODE", length = 2)
    private String isYisongNode; //移送书的节点（因有3个节点可能导致移送，故需记录）

    @Column(name = "IS_BYISONG", length = 100)
    private String isByisong; //被移送案件的ID

    @Column(name = "JIEAN_TIME", nullable = false)
    private Date jieanTime; //结案或移送完成时间

    @Column(name = "OP_MAN_NAME", length = 3000)
    private String opManName; //办案人名称

    @Column(name = "CHECK_RESULT", length = 1, nullable = false)
    private String checkResult; //检查结果（0是合规，1是违规，2是整改，3是未检查成功）

    @Column(name = "CHU_FA_MONEY", length = 20, precision = 4)
    private Double chuFaMoney; //处罚金额

    @Column(name = "AN_JIAN_SHUO_MING", length = 4000, nullable = false)
    private String anJianShuoMing; //案件说明

    @Column(name = "PUN_TYPE_JG", length = 5)
    private String punTypeJg; //处罚种类-警告

    @Column(name = "PUN_TYPE_FK", length = 5)
    private String punTypeFk; //处罚种类-罚款

    @Column(name = "PUN_TYPE_MS", length = 5)
    private String punTypeMs; //处罚种类-没收违法所得、没收非法财物

    @Column(name = "PUN_TYPE_TC", length = 5)
    private String punTypeTc; //处罚种类-责令停产停业

    @Column(name = "PUN_TYPE_ZK", length = 5)
    private String punTypeZk; //处罚种类-暂扣或者吊销许可证、执照

    @Column(name = "FILL_TYPE", length = 1)
    private String fillType; //填报类型(0：新建执法任务  1：补录案件)

    @Transient
    private String userCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getOpMan() {
        return opMan;
    }

    public void setOpMan(String opMan) {
        this.opMan = opMan;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSysFillCompanyName() {
        return sysFillCompanyName;
    }

    public void setSysFillCompanyName(String sysFillCompanyName) {
        this.sysFillCompanyName = sysFillCompanyName;
    }

    public String getSysFillMan() {
        return sysFillMan;
    }

    public void setSysFillMan(String sysFillMan) {
        this.sysFillMan = sysFillMan;
    }

    public Date getSysFillTime() {
        return sysFillTime;
    }

    public void setSysFillTime(Date sysFillTime) {
        this.sysFillTime = sysFillTime;
    }

    public String getTrCaseAddress() {
        return trCaseAddress;
    }

    public void setTrCaseAddress(String trCaseAddress) {
        this.trCaseAddress = trCaseAddress;
    }

    public Date getTrCaseDate() {
        return trCaseDate;
    }

    public void setTrCaseDate(Date trCaseDate) {
        this.trCaseDate = trCaseDate;
    }

    public String getTrCaseType() {
        return trCaseType;
    }

    public void setTrCaseType(String trCaseType) {
        this.trCaseType = trCaseType;
    }

    public String getTrRunit() {
        return trRunit;
    }

    public void setTrRunit(String trRunit) {
        this.trRunit = trRunit;
    }

    public String getTrRunitAddress() {
        return trRunitAddress;
    }

    public void setTrRunitAddress(String trRunitAddress) {
        this.trRunitAddress = trRunitAddress;
    }

    public String getTrRunitEmail() {
        return trRunitEmail;
    }

    public void setTrRunitEmail(String trRunitEmail) {
        this.trRunitEmail = trRunitEmail;
    }

    public String getTrRunitName() {
        return trRunitName;
    }

    public void setTrRunitName(String trRunitName) {
        this.trRunitName = trRunitName;
    }

    public String getTrRunitPhone() {
        return trRunitPhone;
    }

    public void setTrRunitPhone(String trRunitPhone) {
        this.trRunitPhone = trRunitPhone;
    }

    public String getTrRunitType() {
        return trRunitType;
    }

    public void setTrRunitType(String trRunitType) {
        this.trRunitType = trRunitType;
    }

    public String getTrTunit() {
        return trTunit;
    }

    public void setTrTunit(String trTunit) {
        this.trTunit = trTunit;
    }

    public String getTrTunitAddress() {
        return trTunitAddress;
    }

    public void setTrTunitAddress(String trTunitAddress) {
        this.trTunitAddress = trTunitAddress;
    }

    public String getTrTunitCharge() {
        return trTunitCharge;
    }

    public void setTrTunitCharge(String trTunitCharge) {
        this.trTunitCharge = trTunitCharge;
    }

    public String getTrTunitCheckItem() {
        return trTunitCheckItem;
    }

    public void setTrTunitCheckItem(String trTunitCheckItem) {
        this.trTunitCheckItem = trTunitCheckItem;
    }

    public String getTrTunitLegal() {
        return trTunitLegal;
    }

    public void setTrTunitLegal(String trTunitLegal) {
        this.trTunitLegal = trTunitLegal;
    }

    public String getTrTunitLicenseNo() {
        return trTunitLicenseNo;
    }

    public void setTrTunitLicenseNo(String trTunitLicenseNo) {
        this.trTunitLicenseNo = trTunitLicenseNo;
    }

    public String getTrTunitPhone() {
        return trTunitPhone;
    }

    public void setTrTunitPhone(String trTunitPhone) {
        this.trTunitPhone = trTunitPhone;
    }

    public String getTrTunitType() {
        return trTunitType;
    }

    public void setTrTunitType(String trTunitType) {
        this.trTunitType = trTunitType;
    }

    public String getTrType() {
        return trType;
    }

    public void setTrType(String trType) {
        this.trType = trType;
    }

    public Date getTrUnitDate() {
        return trUnitDate;
    }

    public void setTrUnitDate(Date trUnitDate) {
        this.trUnitDate = trUnitDate;
    }

    public String getTrUnitMessage() {
        return trUnitMessage;
    }

    public void setTrUnitMessage(String trUnitMessage) {
        this.trUnitMessage = trUnitMessage;
    }

    public String getIsYisong() {
        return isYisong;
    }

    public void setIsYisong(String isYisong) {
        this.isYisong = isYisong;
    }

    public String getAreaCodeOld() {
        return areaCodeOld;
    }

    public void setAreaCodeOld(String areaCodeOld) {
        this.areaCodeOld = areaCodeOld;
    }

    public String getAreaCodeNew() {
        return areaCodeNew;
    }

    public void setAreaCodeNew(String areaCodeNew) {
        this.areaCodeNew = areaCodeNew;
    }

    public String getIsYisongNode() {
        return isYisongNode;
    }

    public void setIsYisongNode(String isYisongNode) {
        this.isYisongNode = isYisongNode;
    }

    public String getIsByisong() {
        return isByisong;
    }

    public void setIsByisong(String isByisong) {
        this.isByisong = isByisong;
    }

    public Date getJieanTime() {
        return jieanTime;
    }

    public void setJieanTime(Date jieanTime) {
        this.jieanTime = jieanTime;
    }

    public String getOpManName() {
        return opManName;
    }

    public void setOpManName(String opManName) {
        this.opManName = opManName;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
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

    public String getFillType() {
        return fillType;
    }

    public void setFillType(String fillType) {
        this.fillType = fillType;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
