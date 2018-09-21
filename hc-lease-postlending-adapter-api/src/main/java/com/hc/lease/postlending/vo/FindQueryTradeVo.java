package com.hc.lease.postlending.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class FindQueryTradeVo implements Serializable {
    private Long id;
    private Long statistId;
    private Long repaymentId;
    private Long contractId;
    private Integer paymentResult;
    private String reqSn;
    private String sn;
    private Integer payWay;
    private Integer status;
    private Long payLogId;
    @ApiModelProperty(value = "总金额", hidden = false)
    private BigDecimal totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStatistId() {
        return statistId;
    }

    public void setStatistId(Long statistId) {
        this.statistId = statistId;
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

    public Integer getPaymentResult() {
        return paymentResult;
    }

    public void setPaymentResult(Integer paymentResult) {
        this.paymentResult = paymentResult;
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

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getPayLogId() {
        return payLogId;
    }

    public void setPayLogId(Long payLogId) {
        this.payLogId = payLogId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "FindQueryTradeVo{" +
                "id=" + id +
                ", statistId=" + statistId +
                ", repaymentId=" + repaymentId +
                ", contractId=" + contractId +
                ", paymentResult=" + paymentResult +
                ", reqSn='" + reqSn + '\'' +
                ", sn='" + sn + '\'' +
                ", payWay=" + payWay +
                ", status=" + status +
                ", payLogId=" + payLogId +
                ", totalPrice=" + totalPrice +
                '}';
    }
}