package com.hc.lease.supplier.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeasePackage  implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "首期金额", hidden = false)
    private BigDecimal downPayment;
    @ApiModelProperty(value = "尾款", hidden = false)
    private BigDecimal balancePayment;
    @ApiModelProperty(value = "分期数/字典表的分期数主键id", hidden = false)
    private Integer stagingNumberId;
    @ApiModelProperty(value = "月租", hidden = false)
    private BigDecimal monthlyRent;

    @ApiModelProperty(value = "首期包含第1个月租金 0 是 1 否", hidden = false)
    private Integer stagingContainMonthlyRent;

    @ApiModelProperty(value = "客户经理/渠道备注", hidden = false)
    private String clientManagerRemarks;
    @ApiModelProperty(value = "类型 0:默认套餐;1:定制套餐", hidden = false)
    private Integer type;
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

    public BigDecimal getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    public BigDecimal getBalancePayment() {
        return balancePayment;
    }

    public void setBalancePayment(BigDecimal balancePayment) {
        this.balancePayment = balancePayment;
    }

    public BigDecimal getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public String getClientManagerRemarks() {
        return clientManagerRemarks;
    }

    public void setClientManagerRemarks(String clientManagerRemarks) {
        this.clientManagerRemarks = clientManagerRemarks == null ? null : clientManagerRemarks.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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

    public Integer getStagingNumberId() {
        return stagingNumberId;
    }

    public void setStagingNumberId(Integer stagingNumberId) {
        this.stagingNumberId = stagingNumberId;
    }

    public Integer getStagingContainMonthlyRent() {
        return stagingContainMonthlyRent;
    }

    public void setStagingContainMonthlyRent(Integer stagingContainMonthlyRent) {
        this.stagingContainMonthlyRent = stagingContainMonthlyRent;
    }
}