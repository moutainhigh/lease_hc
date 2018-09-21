package com.hc.lease.user.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class LeaseUserSession implements Serializable{
    private Long id;

    private String deviceId;

    private Long userId;

    private String phone;

    private String realName;

    private String sessionCurrent;

    private String sessionCode;

    private Date sessionLoginTime;

    private Date sessionLimitTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getSessionCurrent() {
        return sessionCurrent;
    }

    public void setSessionCurrent(String sessionCurrent) {
        this.sessionCurrent = sessionCurrent == null ? null : sessionCurrent.trim();
    }

    public String getSessionCode() {
        return sessionCode;
    }

    public void setSessionCode(String sessionCode) {
        this.sessionCode = sessionCode == null ? null : sessionCode.trim();
    }

    public Date getSessionLoginTime() {
        return sessionLoginTime;
    }

    public void setSessionLoginTime(Date sessionLoginTime) {
        this.sessionLoginTime = sessionLoginTime;
    }

    public Date getSessionLimitTime() {
        return sessionLimitTime;
    }

    public void setSessionLimitTime(Date sessionLimitTime) {
        this.sessionLimitTime = sessionLimitTime;
    }
}