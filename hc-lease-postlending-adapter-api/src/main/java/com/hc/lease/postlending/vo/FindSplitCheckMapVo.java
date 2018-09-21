package com.hc.lease.postlending.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 查询拆分的的明细是否已经扣款成功
 */
public class FindSplitCheckMapVo implements Serializable {
    @ApiModelProperty(value = "款项主键id，融租合同-还款计划明细主键id", hidden = false)
    private Long repaymentId;
    @ApiModelProperty(value = "融租合同主键id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "是否成功", hidden = false)
    private Integer isAllSuccess;
    @ApiModelProperty(value = "单笔或批量/0:单笔; 1:批量/是否是批扣提交的拆分", hidden = false)
    private Integer singleOrBatch;
    @ApiModelProperty(value = "批次号/批扣流水", hidden = false)
    private String batchNumber;
    @ApiModelProperty(value = "总额", hidden = false)
    private BigDecimal totlePrice;
    @ApiModelProperty(value = "数量", hidden = false)
    private Integer number;
    @ApiModelProperty(value = "扣款提交时的支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他", hidden = false)
    private Integer payWay;

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

    public Integer getIsAllSuccess() {
        return isAllSuccess;
    }

    public void setIsAllSuccess(Integer isAllSuccess) {
        this.isAllSuccess = isAllSuccess;
    }

    public Integer getSingleOrBatch() {
        return singleOrBatch;
    }

    public void setSingleOrBatch(Integer singleOrBatch) {
        this.singleOrBatch = singleOrBatch;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    @Override
    public String toString() {
        return "FindSplitCheckMapVo{" +
                "repaymentId=" + repaymentId +
                ", contractId=" + contractId +
                ", isAllSuccess=" + isAllSuccess +
                ", singleOrBatch=" + singleOrBatch +
                ", batchNumber='" + batchNumber + '\'' +
                ", totlePrice=" + totlePrice +
                ", number=" + number +
                ", payWay=" + payWay +
                '}';
    }
}