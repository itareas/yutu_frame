package com.yutu.entity.table;

import java.util.Date;

public class TSysLandinglog {
    private String uuid;

    private String loginUserid;

    private String loginAccount;

    private String loginIp;

    private String loginSessionid;

    private Date loginDate;

    private String loginType;

    private Integer loginResult;

    private String loginAppname;

    private String loginAddress;

    private String loginRemarks;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getLoginUserid() {
        return loginUserid;
    }

    public void setLoginUserid(String loginUserid) {
        this.loginUserid = loginUserid == null ? null : loginUserid.trim();
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount == null ? null : loginAccount.trim();
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public String getLoginSessionid() {
        return loginSessionid;
    }

    public void setLoginSessionid(String loginSessionid) {
        this.loginSessionid = loginSessionid == null ? null : loginSessionid.trim();
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType == null ? null : loginType.trim();
    }

    public Integer getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(Integer loginResult) {
        this.loginResult = loginResult;
    }

    public String getLoginAppname() {
        return loginAppname;
    }

    public void setLoginAppname(String loginAppname) {
        this.loginAppname = loginAppname == null ? null : loginAppname.trim();
    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress == null ? null : loginAddress.trim();
    }

    public String getLoginRemarks() {
        return loginRemarks;
    }

    public void setLoginRemarks(String loginRemarks) {
        this.loginRemarks = loginRemarks == null ? null : loginRemarks.trim();
    }
}