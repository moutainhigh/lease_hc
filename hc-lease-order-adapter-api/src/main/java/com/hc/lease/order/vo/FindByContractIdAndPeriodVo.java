package com.hc.lease.order.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 融租合同的提前还款
 * Created by Administrator on 2017/8/30.
 */
public class FindByContractIdAndPeriodVo implements Serializable {
    private Long historyRepaymentStatusId;
    private Long repaymentId;
    private Long contractId;
    private BigDecimal totlePrice;
    private Long historyId;
    private Integer payWay;
    private Integer type;
    private Integer paymentResult;
    private String paymentResultMsg;
    private String reqSn;
    private String sn;
    private Date historyCreateTime;
    private Long historyCreateBy;
    private Date historyUpdateTime;
    private Long historyUpdateBy;
    private Integer period;
    private Integer overdue;
    private Integer overdueDay;

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

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
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
        this.paymentResultMsg = paymentResultMsg;
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

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getOverdue() {
        return overdue;
    }

    public void setOverdue(Integer overdue) {
        this.overdue = overdue;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

}
