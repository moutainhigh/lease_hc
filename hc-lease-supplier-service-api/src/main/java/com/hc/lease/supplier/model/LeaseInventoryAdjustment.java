package com.hc.lease.supplier.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class LeaseInventoryAdjustment {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "车辆主键Id", hidden = false)
    private Long carId;
    @ApiModelProperty(value = "调库时间", hidden = false)
    private Date adjustmentTime;
    @ApiModelProperty(value = "创建时间", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改时间", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "排序", hidden = false)
    private Integer sort;
    @ApiModelProperty(value = "调出库主键id", hidden = false)
    private Long outStorehouseId;
    @ApiModelProperty(value = "目标库主键id", hidden = false)
    private Long inStorehouseId;
    @ApiModelProperty(value = "接收人主键id", hidden = false)
    private Long inAccountId;
    @ApiModelProperty(value = "调出人主键id", hidden = false)
    private Long outAccountId;
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

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getOutStorehouseId() {
        return outStorehouseId;
    }

    public void setOutStorehouseId(Long outStorehouseId) {
        this.outStorehouseId = outStorehouseId;
    }

    public Long getInStorehouseId() {
        return inStorehouseId;
    }

    public void setInStorehouseId(Long inStorehouseId) {
        this.inStorehouseId = inStorehouseId;
    }

    public Long getOutAccountId() {
        return outAccountId;
    }

    public void setOutAccountId(Long outAccountId) {
        this.outAccountId = outAccountId;
    }

    public Date getAdjustmentTime() {
        return adjustmentTime;
    }

    public void setAdjustmentTime(Date adjustmentTime) {
        this.adjustmentTime = adjustmentTime;
    }

    public Long getInAccountId() {
        return inAccountId;
    }

    public void setInAccountId(Long inAccountId) {
        this.inAccountId = inAccountId;
    }
}