package com.hc.lease.postlending.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 逾期记录
 */
public class LeaseOverdueLog implements Serializable {

    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;

    @ApiModelProperty(value = "融租合同ID", hidden = false)
    private Long contractId;

    @ApiModelProperty(value = "承租人ID", hidden = false)
    private Long accountId;

    @ApiModelProperty(value = "融租合同-还款计划明细主键id", hidden = false)
    private Long repaymentId;

    @ApiModelProperty(value = "金额", hidden = false)
    private BigDecimal price;

    @ApiModelProperty(value = "逾期天数", hidden = false)
    private Integer overdueDay;

    @ApiModelProperty(value = "创建日期/操作日期", hidden = false)
    private Date createTime;

    @ApiModelProperty(value = "修改日期/操作日期", hidden = false)
    private Date updateTime;

    @ApiModelProperty(value = "是否付款", hidden = false)
    private Boolean isPay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Long repaymentId) {
        this.repaymentId = repaymentId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public Boolean getIsPay() {
        return isPay;
    }

    public void setIsPay(Boolean isPay) {
        this.isPay = isPay;
    }
}