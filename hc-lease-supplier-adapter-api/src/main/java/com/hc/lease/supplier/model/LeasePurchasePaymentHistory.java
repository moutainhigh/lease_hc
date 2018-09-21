package com.hc.lease.supplier.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeasePurchasePaymentHistory implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "采购合同主键Id", hidden = false)
    private Long purchaseContractId;
    @ApiModelProperty(value = "购车资金类型/资金来源/字典表的抵押类型主键id", hidden = false)
    private Long buyCardCapitalTypeId;
    @ApiModelProperty(value = "购车资金类型/资金来源/字典表的抵押类型名称", hidden = false)
    private String buyCardCapitalTypeName;
    @ApiModelProperty(value = "融资方主键id", hidden = false)
    private Long carBuyFinancingerId;
    @ApiModelProperty(value = "生效日期", hidden = false)
    private Date effectiveTime;
    @ApiModelProperty(value = "合同编号", hidden = false)
    private String contractNumber;
    @ApiModelProperty(value = "首付款", hidden = false)
    private BigDecimal downPayment;
    @ApiModelProperty(value = "留购价款", hidden = false)
    private BigDecimal hirePurchase;
    @ApiModelProperty(value = "合同车价", hidden = false)
    private BigDecimal contractCarPrice;
    @ApiModelProperty(value = "租金", hidden = false)
    private BigDecimal leasePrice;
    @ApiModelProperty(value = "分期数/字典表的分期数主键id", hidden = false)
    private Long stagingNumberId;
    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "状态 0:禁用 1:启用", hidden = false)
    private Boolean isEnable;
    @ApiModelProperty(value = "排序", hidden = false)
    private Integer sort;
    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;
    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchaseContractId() {
        return purchaseContractId;
    }

    public void setPurchaseContractId(Long purchaseContractId) {
        this.purchaseContractId = purchaseContractId;
    }

    public Long getBuyCardCapitalTypeId() {
        return buyCardCapitalTypeId;
    }

    public void setBuyCardCapitalTypeId(Long buyCardCapitalTypeId) {
        this.buyCardCapitalTypeId = buyCardCapitalTypeId;
    }

    public String getBuyCardCapitalTypeName() {
        return buyCardCapitalTypeName;
    }

    public void setBuyCardCapitalTypeName(String buyCardCapitalTypeName) {
        this.buyCardCapitalTypeName = buyCardCapitalTypeName == null ? null : buyCardCapitalTypeName.trim();
    }

    public Long getCarBuyFinancingerId() {
        return carBuyFinancingerId;
    }

    public void setCarBuyFinancingerId(Long carBuyFinancingerId) {
        this.carBuyFinancingerId = carBuyFinancingerId;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber == null ? null : contractNumber.trim();
    }

    public BigDecimal getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    public BigDecimal getHirePurchase() {
        return hirePurchase;
    }

    public void setHirePurchase(BigDecimal hirePurchase) {
        this.hirePurchase = hirePurchase;
    }

    public BigDecimal getContractCarPrice() {
        return contractCarPrice;
    }

    public void setContractCarPrice(BigDecimal contractCarPrice) {
        this.contractCarPrice = contractCarPrice;
    }

    public BigDecimal getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(BigDecimal leasePrice) {
        this.leasePrice = leasePrice;
    }

    public Long getStagingNumberId() {
        return stagingNumberId;
    }

    public void setStagingNumberId(Long stagingNumberId) {
        this.stagingNumberId = stagingNumberId;
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

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}