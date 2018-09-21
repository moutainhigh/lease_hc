package com.hc.lease.postlending.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 通联批量代收批次统计
 */
public class LeaseAllinpayBatch implements Serializable {

    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;

    @ApiModelProperty(value = "批次号/批扣流水", hidden = false)
    private String batchNumber;

    @ApiModelProperty(value = "应扣总额", hidden = false)
    private BigDecimal receivablePrice;

    @ApiModelProperty(value = "实扣总额", hidden = false)
    private BigDecimal receiptsPrice;

    @ApiModelProperty(value = "数量", hidden = false)
    private Integer number;

    @ApiModelProperty(value = "成功数量", hidden = false)
    private Integer successNumber;

    @ApiModelProperty(value = "失败数量", hidden = false)
    private Integer failNumber;

    @ApiModelProperty(value = "创建日期/操作日期", hidden = false)
    private Date createTime;

    @ApiModelProperty(value = "修改日期/操作日期", hidden = false)
    private Date updateTime;

    @ApiModelProperty(value = "创建人/操作人", hidden = false)
    private Long createBy;

    @ApiModelProperty(value = "修改人/操作人", hidden = false)
    private Long updateBy;

    @ApiModelProperty(value = "操作人姓名", hidden = false)
    private String userName;

    @ApiModelProperty(value = "失败总额", hidden = false)
    private BigDecimal failPrice;

    @ApiModelProperty(value = "合同编号", hidden = false)
    private String completeContractNumber;

    @ApiModelProperty(value = "联系手机", hidden = false)
    private String phone;

    @ApiModelProperty(value = "承租人", hidden = false)
    private String accountName;

    @ApiModelProperty(value = "期数", hidden = false)
    private String period;


    @ApiModelProperty(value = "分公司", hidden = false)
    private String companyName;

    @ApiModelProperty(value = "卡号", hidden = false)
    private String backCardNumber;

    @ApiModelProperty(value = "银行", hidden = false)
    private String bankName;


    @ApiModelProperty(value = "失败原因", hidden = false)
    private String paymentResultMsg;

    @ApiModelProperty(value = "备注", hidden = false)
    private String remarks;

    @ApiModelProperty(value = "通联交易编号", hidden = false)
    private String reqSn;

    @ApiModelProperty(value = "扣款用途", hidden = false)
    private String type;


    @ApiModelProperty(value = "扣款结果", hidden = false)
    private String paymentResult;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber == null ? null : batchNumber.trim();
    }

    public BigDecimal getReceivablePrice() {
        return receivablePrice;
    }

    public void setReceivablePrice(BigDecimal receivablePrice) {
        this.receivablePrice = receivablePrice;
    }

    public BigDecimal getReceiptsPrice() {
        return receiptsPrice;
    }

    public void setReceiptsPrice(BigDecimal receiptsPrice) {
        this.receiptsPrice = receiptsPrice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSuccessNumber() {
        return successNumber;
    }

    public void setSuccessNumber(Integer successNumber) {
        this.successNumber = successNumber;
    }

    public Integer getFailNumber() {
        return failNumber;
    }

    public void setFailNumber(Integer failNumber) {
        this.failNumber = failNumber;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BigDecimal getFailPrice() {
        return failPrice;
    }

    public void setFailPrice(BigDecimal failPrice) {
        this.failPrice = failPrice;
    }

    public String getCompleteContractNumber() {
        return completeContractNumber;
    }

    public void setCompleteContractNumber(String completeContractNumber) {
        this.completeContractNumber = completeContractNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBackCardNumber() {
        return backCardNumber;
    }

    public void setBackCardNumber(String backCardNumber) {
        this.backCardNumber = backCardNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPaymentResultMsg() {
        return paymentResultMsg;
    }

    public void setPaymentResultMsg(String paymentResultMsg) {
        this.paymentResultMsg = paymentResultMsg;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getReqSn() {
        return reqSn;
    }

    public void setReqSn(String reqSn) {
        this.reqSn = reqSn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPaymentResult() {
        return paymentResult;
    }

    public void setPaymentResult(String paymentResult) {
        this.paymentResult = paymentResult;
    }
}