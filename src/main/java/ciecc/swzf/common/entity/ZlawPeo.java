package ciecc.swzf.common.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author kandigx
 * @create 2017-09-19 9:36
 */
@Entity
@Table(name = "ZLAW_PEO")
public class ZlawPeo implements Serializable{

    @Id
    @Column(name = "ID", length = 32)
    private String id;//id;

    @Column(name = "AREA_CODE")
    private String areaCode;//地区代码;

    @Column(name = "AUD_ADVICE")
    private String audAdvice;//审核意见;

    @Column(name = "IS_DEL")
    private String isDel;//是否删除 0:未删除 1:已删除;

    @Column(name = "SYS_AUD_DEPT_CODE")
    private String sysAudDeptCode;//审核部门代码;

    @Column(name = "SYS_FILL_MAN")
    private String sysFillMan;//填写人;

    @Column(name = "SYS_FILL_COMPANY_NAME")
    private String sysFillCompanyName;//填写单位名称;

    @Column(name = "SYS_AUD_TIME")
    private Date sysAudTime;//审核时间;

    @Column(name = "REPORT_TIME")
    private Date reportTime;//上报时间;

    @Column(name = "SYS_FILL_TIME")
    private Date sysFillTime;//填写时间;

    @Column(name = "OP_MAN")
    private String opMan;//操作人;

    @Column(name = "OP_TIME")
    private Date opTime;//操作时间;

    @Column(name = "NAME")
    private String name;//姓名;

    @Column(name = "SEX")
    private String sex;//性别(0:男 1:女);

    @Column(name = "BIRTHDAY")
    private Date birthday;//出生年月;

    @Column(name = "EDUCATION")
    private String education;//学位/学历：博士/硕士/本科/大专/中专/其他;

    @Column(name = "PHONE")
    private String phone;//手机号;

    @Column(name = "EMAIL")
    private String email;//Email;

    @Column(name = "ORGANIZATION")
    private String organization;//编制情况（行政、事业、聘用）;

    @Column(name = "WORK_NATURE")
    private String workNature;//工作性质（12312呼叫中心、执法人员）;

    @Column(name = "IS_CERTIFICATE")
    private String isCertificate;//是否取得上岗证   0：是   1：否;

    @Column(name = "CERTIFICATE_NO")
    private String certificateNo;//上岗证编号;

    @Column(name = "SYS_AUD_STATUS")
    private String sysAudStatus;//审核状态;

    @Column(name = "LABEL")
    private String label;//添加级别列（存储级别表的id）;

    @Column(name = "APP_LEVEL")
    private String appLevel;//任命级别(0:队长 1:副队长 2:队员)；

    @Column(name = "IS_JOB")
    private String isJob;//在职情况(0:在职 1:离职)

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "USER_ID")
    private User user;//用户

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

    public String getAudAdvice() {
        return audAdvice;
    }

    public void setAudAdvice(String audAdvice) {
        this.audAdvice = audAdvice;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getSysAudDeptCode() {
        return sysAudDeptCode;
    }

    public void setSysAudDeptCode(String sysAudDeptCode) {
        this.sysAudDeptCode = sysAudDeptCode;
    }

    public String getSysFillMan() {
        return sysFillMan;
    }

    public void setSysFillMan(String sysFillMan) {
        this.sysFillMan = sysFillMan;
    }

    public String getSysFillCompanyName() {
        return sysFillCompanyName;
    }

    public void setSysFillCompanyName(String sysFillCompanyName) {
        this.sysFillCompanyName = sysFillCompanyName;
    }

    public Date getSysAudTime() {
        return sysAudTime;
    }

    public void setSysAudTime(Date sysAudTime) {
        this.sysAudTime = sysAudTime;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public Date getSysFillTime() {
        return sysFillTime;
    }

    public void setSysFillTime(Date sysFillTime) {
        this.sysFillTime = sysFillTime;
    }

    public String getOpMan() {
        return opMan;
    }

    public void setOpMan(String opMan) {
        this.opMan = opMan;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getWorkNature() {
        return workNature;
    }

    public void setWorkNature(String workNature) {
        this.workNature = workNature;
    }

    public String getIsCertificate() {
        return isCertificate;
    }

    public void setIsCertificate(String isCertificate) {
        this.isCertificate = isCertificate;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getSysAudStatus() {
        return sysAudStatus;
    }

    public void setSysAudStatus(String sysAudStatus) {
        this.sysAudStatus = sysAudStatus;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAppLevel() {
        return appLevel;
    }

    public void setAppLevel(String appLevel) {
        this.appLevel = appLevel;
    }

    public String getIsJob() {
        return isJob;
    }

    public void setIsJob(String isJob) {
        this.isJob = isJob;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
