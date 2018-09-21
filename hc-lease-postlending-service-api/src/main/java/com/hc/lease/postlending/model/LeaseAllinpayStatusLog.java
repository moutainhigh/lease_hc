package com.hc.lease.postlending.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 代收状态流水
 */
public class LeaseAllinpayStatusLog implements Serializable {

    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;

    @ApiModelProperty(value = "代收流水主键id", hidden = false)
    private Long allinpayLogId;

    @ApiModelProperty(value = "创建日期/操作日期", hidden = false)
    private Date createTime;

    @ApiModelProperty(value = "创建人/操作人", hidden = false)
    private Long createBy;

    @ApiModelProperty(value = "通联支付反馈状态码", hidden = false)
    private String retCode;

    @ApiModelProperty(value = "通联支付反馈状态描述", hidden = false)
    private String errMsg;

    @ApiModelProperty(value = "通联支付反馈状态日期", hidden = false)
    private Date backTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAllinpayLogId() {
        return allinpayLogId;
    }

    public void setAllinpayLogId(Long allinpayLogId) {
        this.allinpayLogId = allinpayLogId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode == null ? null : retCode.trim();
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg == null ? null : errMsg.trim();
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }
}