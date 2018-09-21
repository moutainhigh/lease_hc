package com.hc.lease.supplier.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeasePurchaseContract implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "购车资金类型/资金来源/字典表的抵押类型主键id", hidden = false)
    private Long buyCardCapitalTypeId;
    @ApiModelProperty(value = "购车资金类型/资金来源/字典表的抵押类型名称", hidden = false)
    private String buyCardCapitalTypeName;
    @ApiModelProperty(value = "合同编号", hidden = false)
    private String contractNumber;
    @ApiModelProperty(value = "融资方主键id", hidden = false)
    private Long carBuyFinancingerId;
    @ApiModelProperty(value = "公司合同方主键id", hidden = false)
    private Long companyHeaderId;
    @ApiModelProperty(value = "生效日期", hidden = false)
    private Date effectiveTime;
    @ApiModelProperty(value = "车辆供应商主键Id", hidden = false)
    private Long carSupplierId;
    @ApiModelProperty(value = "品牌主键Id", hidden = false)
    private Long brandsId;
    @ApiModelProperty(value = "系列主键Id", hidden = false)
    private Long seriesId;
    @ApiModelProperty(value = "车型主键Id", hidden = false)
    private Long modelId;
    @ApiModelProperty(value = "总数量", hidden = false)
    private Integer totleAmount;
    @ApiModelProperty(value = "单价", hidden = false)
    private BigDecimal unitPrice;
    @ApiModelProperty(value = "订金", hidden = false)
    private BigDecimal subscriptionPrice;
    @ApiModelProperty(value = "总金额", hidden = false)
    private BigDecimal totlePrice;
    @ApiModelProperty(value = "备注", hidden = false)
    private String remarks;
    @ApiModelProperty(value = "采购合同扫描件", hidden = false)
    private String scannerImg;
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

    private List<String> scannerImgs;

    private String carBuyFinancingerName;
    private String companyHeaderName;
    private String brandsName;
    private String seriesName;
    private String completeModelName;
    private String carSupplierName;
    private String modelName;

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

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber == null ? null : contractNumber.trim();
    }

    public Long getCarBuyFinancingerId() {
        return carBuyFinancingerId;
    }

    public void setCarBuyFinancingerId(Long carBuyFinancingerId) {
        this.carBuyFinancingerId = carBuyFinancingerId;
    }

    public Long getCompanyHeaderId() {
        return companyHeaderId;
    }

    public void setCompanyHeaderId(Long companyHeaderId) {
        this.companyHeaderId = companyHeaderId;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Long getCarSupplierId() {
        return carSupplierId;
    }

    public void setCarSupplierId(Long carSupplierId) {
        this.carSupplierId = carSupplierId;
    }

    public Long getBrandsId() {
        return brandsId;
    }

    public void setBrandsId(Long brandsId) {
        this.brandsId = brandsId;
    }

    public Long getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Long seriesId) {
        this.seriesId = seriesId;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Integer getTotleAmount() {
        return totleAmount;
    }

    public void setTotleAmount(Integer totleAmount) {
        this.totleAmount = totleAmount;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getSubscriptionPrice() {
        return subscriptionPrice;
    }

    public void setSubscriptionPrice(BigDecimal subscriptionPrice) {
        this.subscriptionPrice = subscriptionPrice;
    }

    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getScannerImg() {
        return scannerImg;
    }

    public void setScannerImg(String scannerImg) {
        this.scannerImg = scannerImg == null ? null : scannerImg.trim();
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

    public String getCarBuyFinancingerName() {
        return carBuyFinancingerName;
    }

    public void setCarBuyFinancingerName(String carBuyFinancingerName) {
        this.carBuyFinancingerName = carBuyFinancingerName;
    }

    public String getCompanyHeaderName() {
        return companyHeaderName;
    }

    public void setCompanyHeaderName(String companyHeaderName) {
        this.companyHeaderName = companyHeaderName;
    }

    public String getBrandsName() {
        return brandsName;
    }

    public void setBrandsName(String brandsName) {
        this.brandsName = brandsName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getCompleteModelName() {
        return completeModelName;
    }

    public void setCompleteModelName(String completeModelName) {
        this.completeModelName = completeModelName;
    }

    public String getCarSupplierName() {
        return carSupplierName;
    }

    public void setCarSupplierName(String carSupplierName) {
        this.carSupplierName = carSupplierName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public List<String> getScannerImgs() {
        return scannerImgs;
    }

    public void setScannerImgs(List<String> scannerImgs) {
        this.scannerImgs = scannerImgs;
    }
}