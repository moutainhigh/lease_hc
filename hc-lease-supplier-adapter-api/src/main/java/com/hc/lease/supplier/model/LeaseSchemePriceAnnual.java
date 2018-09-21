package com.hc.lease.supplier.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LeaseSchemePriceAnnual implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "方案报价Id", hidden = false)
    private Long schemePriceId;
    @ApiModelProperty(value = "适合区域", hidden = false)
    private String fitArea;
    @ApiModelProperty(value = "方案名称", hidden = false)
    private String schemeName;
    @ApiModelProperty(value = "分期数", hidden = false)
    private Long stagingNumberId;
    @ApiModelProperty(value = "代理结算价", hidden = false)
    private BigDecimal agentSettlementPrice;
    @ApiModelProperty(value = "月供", hidden = false)
    private BigDecimal monthlyRent;
    @ApiModelProperty(value = "首年尾付", hidden = false)
    private BigDecimal balancePayment;
    @ApiModelProperty(value = "第2年尾付", hidden = false)
    private BigDecimal balancePayment2;
    @ApiModelProperty(value = "第3年尾付", hidden = false)
    private BigDecimal balancePayment3;
    @ApiModelProperty(value = "利息及毛利", hidden = false)
    private BigDecimal interestGrossProfit;
    @ApiModelProperty(value = "返回是否被使用", hidden = false)
    private Boolean isUsed;

    @ApiModelProperty(value = "方案期数(定制)", hidden = false)
    private String  stagingNumber;
    @ApiModelProperty(value = "方案期数类型 1为系统 2为定制", hidden = false)
    private Integer stagingNumberType;

    @ApiModelProperty(value = "方案期数(显示)", hidden = false)
    private String stagingNumberName;

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



    @ApiModelProperty(value = "车型", hidden = false)
    private String completeModelName;
    @ApiModelProperty(value = "车辆系列", hidden = false)
    private String seriesName;
    @ApiModelProperty(value = "车辆品牌", hidden = false)
    private String brandsName;
    @ApiModelProperty(value = "市场指导价", hidden = false)
    private BigDecimal marketPrice;
    @ApiModelProperty(value = "颜色备注", hidden = false)
    private String colorPriceRemarks;
    @ApiModelProperty(value = "执行时间", hidden = false)
    private Date executionTime;


    public String getStagingNumber() {
        return stagingNumber;
    }

    public void setStagingNumber(String stagingNumber) {
        this.stagingNumber = stagingNumber;
    }

    public Integer getStagingNumberType() {
        return stagingNumberType;
    }

    public void setStagingNumberType(Integer stagingNumberType) {
        this.stagingNumberType = stagingNumberType;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public String getCompleteModelName() {
        return completeModelName;
    }

    public void setCompleteModelName(String completeModelName) {
        this.completeModelName = completeModelName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getBrandsName() {
        return brandsName;
    }

    public void setBrandsName(String brandsName) {
        this.brandsName = brandsName;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getColorPriceRemarks() {
        return colorPriceRemarks;
    }

    public void setColorPriceRemarks(String colorPriceRemarks) {
        this.colorPriceRemarks = colorPriceRemarks;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSchemePriceId() {
        return schemePriceId;
    }

    public void setSchemePriceId(Long schemePriceId) {
        this.schemePriceId = schemePriceId;
    }

    public String getFitArea() {
        return fitArea;
    }

    public void setFitArea(String fitArea) {
        this.fitArea = fitArea == null ? null : fitArea.trim();
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName == null ? null : schemeName.trim();
    }

    public Long getStagingNumberId() {
        return stagingNumberId;
    }

    public void setStagingNumberId(Long stagingNumberId) {
        this.stagingNumberId = stagingNumberId;
    }

    public BigDecimal getAgentSettlementPrice() {
        return agentSettlementPrice;
    }

    public void setAgentSettlementPrice(BigDecimal agentSettlementPrice) {
        this.agentSettlementPrice = agentSettlementPrice;
    }

    public BigDecimal getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public BigDecimal getBalancePayment() {
        return balancePayment;
    }

    public void setBalancePayment(BigDecimal balancePayment) {
        this.balancePayment = balancePayment;
    }

    public BigDecimal getBalancePayment2() {
        return balancePayment2;
    }

    public void setBalancePayment2(BigDecimal balancePayment2) {
        this.balancePayment2 = balancePayment2;
    }

    public BigDecimal getBalancePayment3() {
        return balancePayment3;
    }

    public void setBalancePayment3(BigDecimal balancePayment3) {
        this.balancePayment3 = balancePayment3;
    }

    public BigDecimal getInterestGrossProfit() {
        return interestGrossProfit;
    }

    public void setInterestGrossProfit(BigDecimal interestGrossProfit) {
        this.interestGrossProfit = interestGrossProfit;
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

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public String getStagingNumberName() {
        return stagingNumberName;
    }

    public void setStagingNumberName(String stagingNumberName) {
        this.stagingNumberName = stagingNumberName;
    }
}