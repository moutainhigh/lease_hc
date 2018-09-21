package com.hc.lease.order.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeaseSchemeRepaymentStatusH implements Serializable {
    private Long id;

    private Long historyRepaymentStatusId;

    private Long repaymentId;

    private Long contractId;

    private BigDecimal totlePrice;

    private Integer payWay;

    private Integer type;

    private Integer paymentResult;

    private String paymentResultMsg;

    private String reqSn;

    private String sn;

    private Date createTime;

    private Long createBy;

    private Date updateTime;

    private Long updateBy;

    private Date historyCreateTime;

    private Long historyCreateBy;

    private Date historyUpdateTime;

    private Long historyUpdateBy;

    private Integer vsersionNumber;
    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHistoryRepaymentStatusId() {
        return historyRepaymentStatusId;
    }

    public void setHistoryRepaymentStatusId(Long historyRepaymentStatusId) {
        this.historyRepaymentStatusId = historyRepaymentStatusId;
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

    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
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
        this.paymentResultMsg = paymentResultMsg == null ? null : paymentResultMsg.trim();
    }

    public String getReqSn() {
        return reqSn;
    }

    public void setReqSn(String reqSn) {
        this.reqSn = reqSn == null ? null : reqSn.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getHistoryCreateTime() {
        return historyCreateTime;
    }

    public void setHistoryCreateTime(Date historyCreateTime) {
        this.historyCreateTime = historyCreateTime;
    }

    public Long getHistoryCreateBy() {
        return historyCreateBy;
    }

    public void setHistoryCreateBy(Long historyCreateBy) {
        this.historyCreateBy = historyCreateBy;
    }

    public Date getHistoryUpdateTime() {
        return historyUpdateTime;
    }

    public void setHistoryUpdateTime(Date historyUpdateTime) {
        this.historyUpdateTime = historyUpdateTime;
    }

    public Long getHistoryUpdateBy() {
        return historyUpdateBy;
    }

    public void setHistoryUpdateBy(Long historyUpdateBy) {
        this.historyUpdateBy = historyUpdateBy;
    }

    public Integer getVsersionNumber() {
        return vsersionNumber;
    }

    public void setVsersionNumber(Integer vsersionNumber) {
        this.vsersionNumber = vsersionNumber;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}