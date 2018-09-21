package com.hc.lease.supplier.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeaseSchemePrice  implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "车辆品牌Id", hidden = false)
    private Long brandsId;
    @ApiModelProperty(value = "车辆系列Id", hidden = false)
    private Long seriesId;
    @ApiModelProperty(value = "车辆车型Id", hidden = false)
    private Long modelId;
    @ApiModelProperty(value = "执行时间", hidden = false)
    private Date executionTime;
    @ApiModelProperty(value = "市场指导价", hidden = false)
    private BigDecimal marketPrice;
    @ApiModelProperty(value = "开票价", hidden = false)
    private BigDecimal ticketPrice;
    @ApiModelProperty(value = "裸车报价", hidden = false)
    private BigDecimal bareCarQuotes;
    @ApiModelProperty(value = "购置税", hidden = false)
    private BigDecimal purchaseTax;
    @ApiModelProperty(value = "首年保险费", hidden = false)
    private BigDecimal firstYearPremium;
    @ApiModelProperty(value = "GPS费用", hidden = false)
    private BigDecimal gpsCost;
    @ApiModelProperty(value = "上牌费", hidden = false)
    private BigDecimal onPlateCost;
    @ApiModelProperty(value = "客户总综合报价", hidden = false)
    private BigDecimal customerComprehensiveQuote;
    @ApiModelProperty(value = "执行利率", hidden = false)
    private BigDecimal annualInterest;
    @ApiModelProperty(value = "颜色差价备注", hidden = false)
    private String colorPriceRemarks;

    @ApiModelProperty(value = "类型 0:默认套餐;1:定制套餐", hidden = false)
    private Integer type;
    @ApiModelProperty(value = "利润点数", hidden = false)
    private BigDecimal profitPoints;
    @ApiModelProperty(value = "采购差价", hidden = false)
    private BigDecimal purchaseDifference;
    @ApiModelProperty(value = "优惠参数", hidden = false)
    private BigDecimal preferentialParameters;


    @ApiModelProperty(value = "接收的1+X方案", hidden = false)
    private List<LeaseSchemePrice1x> leaseSchemePrice1xs;

    @ApiModelProperty(value = "接收的年度尾款方案", hidden = false)
    private List<LeaseSchemePriceAnnual> leaseSchemePriceAnnuals;

    @ApiModelProperty(value = "接收的分期方案", hidden = false)
    private List<LeaseSchemePriceStages> leaseSchemePriceStages;

    @ApiModelProperty(value = "接收的纯租方案", hidden = false)
    private List<LeaseSchemePriceRent> leaseSchemePriceRents;



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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public BigDecimal getBareCarQuotes() {
        return bareCarQuotes;
    }

    public void setBareCarQuotes(BigDecimal bareCarQuotes) {
        this.bareCarQuotes = bareCarQuotes;
    }

    public BigDecimal getPurchaseTax() {
        return purchaseTax;
    }

    public void setPurchaseTax(BigDecimal purchaseTax) {
        this.purchaseTax = purchaseTax;
    }

    public BigDecimal getFirstYearPremium() {
        return firstYearPremium;
    }

    public void setFirstYearPremium(BigDecimal firstYearPremium) {
        this.firstYearPremium = firstYearPremium;
    }

    public BigDecimal getGpsCost() {
        return gpsCost;
    }

    public void setGpsCost(BigDecimal gpsCost) {
        this.gpsCost = gpsCost;
    }

    public BigDecimal getOnPlateCost() {
        return onPlateCost;
    }

    public void setOnPlateCost(BigDecimal onPlateCost) {
        this.onPlateCost = onPlateCost;
    }

    public BigDecimal getCustomerComprehensiveQuote() {
        return customerComprehensiveQuote;
    }

    public void setCustomerComprehensiveQuote(BigDecimal customerComprehensiveQuote) {
        this.customerComprehensiveQuote = customerComprehensiveQuote;
    }

    public BigDecimal getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(BigDecimal annualInterest) {
        this.annualInterest = annualInterest;
    }

    public String getColorPriceRemarks() {
        return colorPriceRemarks;
    }

    public void setColorPriceRemarks(String colorPriceRemarks) {
        this.colorPriceRemarks = colorPriceRemarks == null ? null : colorPriceRemarks.trim();
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

    public List<LeaseSchemePrice1x> getLeaseSchemePrice1xs() {
        return leaseSchemePrice1xs;
    }

    public void setLeaseSchemePrice1xs(List<LeaseSchemePrice1x> leaseSchemePrice1xs) {
        this.leaseSchemePrice1xs = leaseSchemePrice1xs;
    }

    public List<LeaseSchemePriceAnnual> getLeaseSchemePriceAnnuals() {
        return leaseSchemePriceAnnuals;
    }

    public void setLeaseSchemePriceAnnuals(List<LeaseSchemePriceAnnual> leaseSchemePriceAnnuals) {
        this.leaseSchemePriceAnnuals = leaseSchemePriceAnnuals;
    }

    public List<LeaseSchemePriceStages> getLeaseSchemePriceStages() {
        return leaseSchemePriceStages;
    }

    public void setLeaseSchemePriceStages(List<LeaseSchemePriceStages> leaseSchemePriceStages) {
        this.leaseSchemePriceStages = leaseSchemePriceStages;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<LeaseSchemePriceRent> getLeaseSchemePriceRents() {
        return leaseSchemePriceRents;
    }

    public void setLeaseSchemePriceRents(List<LeaseSchemePriceRent> leaseSchemePriceRents) {
        this.leaseSchemePriceRents = leaseSchemePriceRents;
    }

    public BigDecimal getProfitPoints() {
        return profitPoints;
    }

    public void setProfitPoints(BigDecimal profitPoints) {
        this.profitPoints = profitPoints;
    }

    public BigDecimal getPurchaseDifference() {
        return purchaseDifference;
    }

    public void setPurchaseDifference(BigDecimal purchaseDifference) {
        this.purchaseDifference = purchaseDifference;
    }

    public BigDecimal getPreferentialParameters() {
        return preferentialParameters;
    }

    public void setPreferentialParameters(BigDecimal preferentialParameters) {
        this.preferentialParameters = preferentialParameters;
    }
}