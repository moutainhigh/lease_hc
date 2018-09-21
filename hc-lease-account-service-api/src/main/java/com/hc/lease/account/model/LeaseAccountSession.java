package com.hc.lease.account.model;

import io.swagger.annotations.ApiModelProperty;

import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 注册用户/承租人登录状态session
 */
public class LeaseAccountSession implements Serializable{
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;

    @ApiModelProperty(value = "登录设备ID", hidden = false)
    private String deviceId;

    @ApiModelProperty(value = "用户主键id", hidden = false)
    private Long accountId;

    @ApiModelProperty(value = "手机号(账号)", hidden = false)
    private String phone;

    @ApiModelProperty(value = "真实姓名", hidden = false)
    private String realName;

    @ApiModelProperty(value = "当前token", hidden = false)
    private String sessionCurrent;

    @ApiModelProperty(value = "验证码", hidden = false)
    private String sessionCode;

    @ApiModelProperty(value = "最近登录时间", hidden = false)
    private Date sessionLoginTime;

    @ApiModelProperty(value = "token有效时间", hidden = false)
    private Date sessionLimitTime;

    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}