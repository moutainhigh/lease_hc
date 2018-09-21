package com.hc.lease.postlending.model;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 通联支付超额拆分交易明细 批量支付批次统计
 */
public class LeaseAllinpaySplitBatch {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "批次号/批扣流水", hidden = false)
    private String batchNumber;
    @ApiModelProperty(value = "应扣总额", hidden = false)
    private BigDecimal receivablePrice;
    @ApiModelProperty(value = "实扣总额/成功总额", hidden = false)
    private BigDecimal receiptsPrice;
    @ApiModelProperty(value = "失败总额", hidden = false)
    private BigDecimal failPrice;
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

    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

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

    public BigDecimal getFailPrice() {
        return failPrice;
    }

    public void setFailPrice(BigDecimal failPrice) {
        this.failPrice = failPrice;
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

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}