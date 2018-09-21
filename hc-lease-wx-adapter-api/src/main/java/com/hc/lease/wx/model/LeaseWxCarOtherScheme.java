package com.hc.lease.wx.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeaseWxCarOtherScheme implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "车辆id", hidden = false)
    private Long carId;
    @ApiModelProperty(value = "首付", hidden = false)
    private BigDecimal downPayment;
    @ApiModelProperty(value = "月租", hidden = false)
    private BigDecimal monthlyRent;
    @ApiModelProperty(value = "第一年分期数", hidden = false)
    private Integer firstYearStagingNumber;
    @ApiModelProperty(value = "尾款", hidden = false)
    private BigDecimal balancePayment;
    @ApiModelProperty(value = "尾款分期", hidden = false)
    private Object balancePaymentStagingNumber;

    @ApiModelProperty(value = "尾款分期List", hidden = false)
    private List<BalancePaymentStagingNumberVo> balancePaymentStagingNumberList;


    @ApiModelProperty(value = "创建时间", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改时间", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "是否启用", hidden = false)
    private Boolean isEnable;
    @ApiModelProperty(value = "排序", hidden = false)
    private Integer sort;
    @ApiModelProperty(value = "车辆名称（显示用）", hidden = false)
    private String carName;
    @ApiModelProperty(value = "24期月供（excel导入导出使用）", hidden = false)
    private BigDecimal stagingNumber24MonthlyRent;
    @ApiModelProperty(value = "36期月供（excel导入导出使用）", hidden = false)
    private BigDecimal stagingNumber36MonthlyRent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public BigDecimal getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    public BigDecimal getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public Integer getFirstYearStagingNumber() {
        return firstYearStagingNumber;
    }

    public void setFirstYearStagingNumber(Integer firstYearStagingNumber) {
        this.firstYearStagingNumber = firstYearStagingNumber;
    }

    public BigDecimal getBalancePayment() {
        return balancePayment;
    }

    public void setBalancePayment(BigDecimal balancePayment) {
        this.balancePayment = balancePayment;
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

    public Object getBalancePaymentStagingNumber() {
        return balancePaymentStagingNumber;
    }

    public void setBalancePaymentStagingNumber(Object balancePaymentStagingNumber) {
        this.balancePaymentStagingNumber = balancePaymentStagingNumber;
    }


    public List<BalancePaymentStagingNumberVo> getBalancePaymentStagingNumberList() {
        return balancePaymentStagingNumberList;
    }

    public void setBalancePaymentStagingNumberList(List<BalancePaymentStagingNumberVo> balancePaymentStagingNumberList) {
        this.balancePaymentStagingNumberList = balancePaymentStagingNumberList;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public BigDecimal getStagingNumber24MonthlyRent() {
        return stagingNumber24MonthlyRent;
    }

    public void setStagingNumber24MonthlyRent(BigDecimal stagingNumber24MonthlyRent) {
        this.stagingNumber24MonthlyRent = stagingNumber24MonthlyRent;
    }

    public BigDecimal getStagingNumber36MonthlyRent() {
        return stagingNumber36MonthlyRent;
    }

    public void setStagingNumber36MonthlyRent(BigDecimal stagingNumber36MonthlyRent) {
        this.stagingNumber36MonthlyRent = stagingNumber36MonthlyRent;
    }
}