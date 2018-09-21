package com.hc.lease.baseInfo.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 通联支付银行额度，包括通联代扣、通联协议支付 的限额
 */
public class LeaseBankAllinpayPriceLimit implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "银行主键Id", hidden = false)
    private Long bankId;
    @ApiModelProperty(value = "支付方式 4:通联;9:通联协议支付", hidden = false)
    private Integer payWay;
    @ApiModelProperty(value = "每笔金额额度", hidden = false)
    private BigDecimal priceLimit;
    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "每日金额额度", hidden = false)
    private BigDecimal dayPriceLimit;
    @ApiModelProperty(value = "每日笔数额度", hidden = false)
    private Integer daySumLimit;

    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    @ApiModelProperty(value = "银行编码", hidden = false)
    private String bankCode;
    @ApiModelProperty(value = "银行名称", hidden = false)
    private String bankName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public BigDecimal getPriceLimit() {
        return priceLimit;
    }

    public void setPriceLimit(BigDecimal priceLimit) {
        this.priceLimit = priceLimit;
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

    public BigDecimal getDayPriceLimit() {
        return dayPriceLimit;
    }

    public void setDayPriceLimit(BigDecimal dayPriceLimit) {
        this.dayPriceLimit = dayPriceLimit;
    }

    public Integer getDaySumLimit() {
        return daySumLimit;
    }

    public void setDaySumLimit(Integer daySumLimit) {
        this.daySumLimit = daySumLimit;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}