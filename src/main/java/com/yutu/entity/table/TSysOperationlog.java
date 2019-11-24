package com.yutu.entity.table;

import java.util.Date;

public class TSysOperationlog {
    private String uuid;

    private String operateDb;

    private String operateDt;

    private String operateType;

    private String operatePrimarykey;

    private String operatePerson;

    private Date operateDatetime;

    private String logType;

    private String operateContent;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getOperateDb() {
        return operateDb;
    }

    public void setOperateDb(String operateDb) {
        this.operateDb = operateDb == null ? null : operateDb.trim();
    }

    public String getOperateDt() {
        return operateDt;
    }

    public void setOperateDt(String operateDt) {
        this.operateDt = operateDt == null ? null : operateDt.trim();
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
    }

    public String getOperatePrimarykey() {
        return operatePrimarykey;
    }

    public void setOperatePrimarykey(String operatePrimarykey) {
        this.operatePrimarykey = operatePrimarykey == null ? null : operatePrimarykey.trim();
    }

    public String getOperatePerson() {
        return operatePerson;
    }

    public void setOperatePerson(String operatePerson) {
        this.operatePerson = operatePerson == null ? null : operatePerson.trim();
    }

    public Date getOperateDatetime() {
        return operateDatetime;
    }

    public void setOperateDatetime(Date operateDatetime) {
        this.operateDatetime = operateDatetime;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    public String getOperateContent() {
        return operateContent;
    }

    public void setOperateContent(String operateContent) {
        this.operateContent = operateContent == null ? null : operateContent.trim();
    }
}