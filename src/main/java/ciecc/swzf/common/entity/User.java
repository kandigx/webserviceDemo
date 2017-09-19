package ciecc.swzf.common.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author kandigx
 * @create 2017-09-19 9:35
 */
@Entity
@Table(name = "RBAC_USER")
public class User implements Serializable{

    @Id
    @Column(name = "userid", length = 50)
    private String userId;

    @Column(name = "username", length = 200)
    private String username;

    @Column(name = "userpassword")
    private String password;

    @Column(name = "USERCODE")
    private String usercode;

    @Column(name = "PHONE")
    private String phone;// 联系人电话

    @Column(name = "REGDATE")
    private Date regDate;

    @Column(name = "USERTYPE")
    private String usertype;

    @Column(name = "RECORD_ID")
    private String recordId;

    @Column(name = "IS_DIS", length = 50)
    private String isDis;

    @Column(name = "IS_DEL", length = 50)
    private String isDel;

    @Column(name = "PWD")
    private String pwd;

    @ManyToOne(targetEntity = ZlawPeo.class)
    @JoinColumn(name = "ZLAW_PEO_ID")
    private ZlawPeo zlawPeo;//执法人员

    @Column(name = "USERCODE_U")
    private String usercodeU;

    @Column(name = "UN_USER_TYPE")
    private String unUserType;

    @Column(name = "SYS_CODE")
    private String sysCode;

    @Column(name = "CAS_USERTYPE")
    private String casUsertype;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getIsDis() {
        return isDis;
    }

    public void setIsDis(String isDis) {
        this.isDis = isDis;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public ZlawPeo getZlawPeo() {
        return zlawPeo;
    }

    public void setZlawPeo(ZlawPeo zlawPeo) {
        this.zlawPeo = zlawPeo;
    }

    public String getUsercodeU() {
        return usercodeU;
    }

    public void setUsercodeU(String usercodeU) {
        this.usercodeU = usercodeU;
    }

    public String getUnUserType() {
        return unUserType;
    }

    public void setUnUserType(String unUserType) {
        this.unUserType = unUserType;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getCasUsertype() {
        return casUsertype;
    }

    public void setCasUsertype(String casUsertype) {
        this.casUsertype = casUsertype;
    }
}
