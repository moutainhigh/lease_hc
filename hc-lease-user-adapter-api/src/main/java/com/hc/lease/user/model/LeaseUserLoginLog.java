package com.hc.lease.user.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 后台用户登录日志
 */
public class LeaseUserLoginLog implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;

    @ApiModelProperty(value = "登录设备ID", hidden = false)
    private String deviceId;

    @ApiModelProperty(value = "登录账号", hidden = false)
    private String phone;

    @ApiModelProperty(value = "用户主键id", hidden = false)
    private Long userId;

    @ApiModelProperty(value = "登录时间", hidden = false)
    private Date loginInTime;

    @ApiModelProperty(value = "退出登录时间", hidden = false)
    private Date loginOutTime;

    @ApiModelProperty(value = "登录IP", hidden = false)
    private String loginIp;

    @ApiModelProperty(value = "登录结果", hidden = false)
    private String loginError;

    @ApiModelProperty(value = "当前token", hidden = false)
    private String sessionCurrent;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getLoginInTime() {
        return loginInTime;
    }

    public void setLoginInTime(Date loginInTime) {
        this.loginInTime = loginInTime;
    }

    public Date getLoginOutTime() {
        return loginOutTime;
    }

    public void setLoginOutTime(Date loginOutTime) {
        this.loginOutTime = loginOutTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public String getLoginError() {
        return loginError;
    }

    public void setLoginError(String loginError) {
        this.loginError = loginError == null ? null : loginError.trim();
    }

    public String getSessionCurrent() {
        return sessionCurrent;
    }

    public void setSessionCurrent(String sessionCurrent) {
        this.sessionCurrent = sessionCurrent == null ? null : sessionCurrent.trim();
    }
}