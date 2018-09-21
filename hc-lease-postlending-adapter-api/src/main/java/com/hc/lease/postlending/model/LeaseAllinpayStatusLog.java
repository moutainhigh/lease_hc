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

    @ApiModelProperty(value = "类型 0:提交通联单笔扣款的结果;1:提交通联批量扣款的结果;2:轮询通联的结果", hidden = false)
    private Integer type;

    @ApiModelProperty(value = "支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败", hidden = false)
    private Integer paymentResult;

    @ApiModelProperty(value = "状态结果描述  失败原因描述", hidden = false)
    private String paymentResultMsg;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPaymentResult() {
        return paymentResult;
    }

    public void setPaymentResult(Integer paymentResult) {
        this.paymentResult = paymentResult;
    }

    public String getPaymentResultMsg() {
        return paymentResultMsg;
    }

    public void setPaymentResultMsg(String paymentResultMsg) {
        this.paymentResultMsg = paymentResultMsg;
    }
}