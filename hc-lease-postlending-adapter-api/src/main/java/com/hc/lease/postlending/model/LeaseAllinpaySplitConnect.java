package com.hc.lease.postlending.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 通联支付（协议支付、代扣），已经超额的还款计划明细则被记录
 */
public class LeaseAllinpaySplitConnect implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "款项主键id，融租合同-还款计划明细主键id", hidden = false)
    private Long repaymentId;
    @ApiModelProperty(value = "融租合同主键id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "创建日期/操作日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期/操作日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人/操作人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人/操作人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;
    @ApiModelProperty(value = "单笔或批量/0:单笔; 1:批量/是否是批扣提交的拆分", hidden = false)
    private Integer singleOrBatch;
    @ApiModelProperty(value = "扣款提交时的批次号/批扣流水", hidden = false)
    private String batchNumber;
    @ApiModelProperty(value = "总额", hidden = false)
    private BigDecimal totlePrice;
    @ApiModelProperty(value = "数量", hidden = false)
    private Integer number;
    @ApiModelProperty(value = "扣款提交时的支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他", hidden = false)
    private Integer payWay;
    @ApiModelProperty(value = "扣款提交时的记录序号 通联批量代收 每笔金额的 序号/可以看作Sn相同的是同一笔交易操作", hidden = false)
    private String sn;

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

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

}