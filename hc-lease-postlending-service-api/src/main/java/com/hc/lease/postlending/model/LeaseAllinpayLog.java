package com.hc.lease.postlending.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LeaseAllinpayLog implements Serializable {

    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;

    @ApiModelProperty(value = "融租合同-还款计划明细主键id", hidden = false)
    private Long repaymentId;

    @ApiModelProperty(value = "融租合同主键id", hidden = false, required = true)
    private Long contractId;

    @ApiModelProperty(value = "支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他", hidden = false)
    private Integer payWay;

    @ApiModelProperty(value = "支付款项类型0:月供; 1:逾期滞纳金", hidden = false)
    private Integer payType;

    @ApiModelProperty(value = "是否逾期", hidden = false)
    private Boolean overdue;

    @ApiModelProperty(value = "逾期天数", hidden = false)
    private Integer overdueDay;

    @ApiModelProperty(value = "创建日期/操作日期", hidden = false)
    private Date createTime;

    @ApiModelProperty(value = "修改日期/操作日期", hidden = false)
    private Date updateTime;

    @ApiModelProperty(value = "创建人/操作人", hidden = false)
    private Long createBy;

    @ApiModelProperty(value = "修改人/操作人", hidden = false)
    private Long updateBy;

    @ApiModelProperty(value = "通联支付状态/0:已提交;1:成功;2:失败", hidden = false)
    private Integer status;

    @ApiModelProperty(value = "通联支付反馈状态码", hidden = false)
    private String retCode;

    @ApiModelProperty(value = "通联支付反馈状态描述", hidden = false)
    private String errMsg;

    @ApiModelProperty(value = "通联支付反馈状态日期", hidden = false)
    private Date backTime;

    @ApiModelProperty(value = "单笔或批量/0:单笔; 1:批量", hidden = false)
    private Integer singleOrBatch;

    @ApiModelProperty(value = "所属批量代收批次主键id", hidden = false)
    private Long allinpayBatchId;

    @ApiModelProperty(value = "合计金额", hidden = false)
    private BigDecimal totlePrice;

    @ApiModelProperty(value = "月供金额", hidden = false)
    private BigDecimal monthlyPaymentPrice;

    @ApiModelProperty(value = "逾期金额/滞纳金", hidden = false)
    private BigDecimal overduePrice;

    @ApiModelProperty(value = "备注", hidden = false)
    private String remarks;

    @ApiModelProperty(value = "通联返回的 文件名", hidden = false)
    private String reqSn;

    @ApiModelProperty(value = "记录序号 通联批量代收 每条数据的 序号", hidden = false)
    private String sn;

    @ApiModelProperty(value = "是否已经操作扣款 0未操作/1已操作", hidden = false)
    private Integer isSendPayment;
    @ApiModelProperty(value = "扣款结果  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败", hidden = false)
    private Integer paymentResult;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Long repaymentId) {
        this.repaymentId = repaymentId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Boolean getOverdue() {
        return overdue;
    }

    public void setOverdue(Boolean overdue) {
        this.overdue = overdue;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getSingleOrBatch() {
        return singleOrBatch;
    }

    public void setSingleOrBatch(Integer singleOrBatch) {
        this.singleOrBatch = singleOrBatch;
    }

    public Long getAllinpayBatchId() {
        return allinpayBatchId;
    }

    public void setAllinpayBatchId(Long allinpayBatchId) {
        this.allinpayBatchId = allinpayBatchId;
    }

    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
    }

    public BigDecimal getMonthlyPaymentPrice() {
        return monthlyPaymentPrice;
    }

    public void setMonthlyPaymentPrice(BigDecimal monthlyPaymentPrice) {
        this.monthlyPaymentPrice = monthlyPaymentPrice;
    }

    public BigDecimal getOverduePrice() {
        return overduePrice;
    }

    public void setOverduePrice(BigDecimal overduePrice) {
        this.overduePrice = overduePrice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getReqSn() {
        return reqSn;
    }

    public void setReqSn(String reqSn) {
        this.reqSn = reqSn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getIsSendPayment() {
        return isSendPayment;
    }

    public void setIsSendPayment(Integer isSendPayment) {
        this.isSendPayment = isSendPayment;
    }

    public Integer getPaymentResult() {
        return paymentResult;
    }

    public void setPaymentResult(Integer paymentResult) {
        this.paymentResult = paymentResult;
    }
}