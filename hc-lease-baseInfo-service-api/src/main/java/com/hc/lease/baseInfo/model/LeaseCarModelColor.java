package com.hc.lease.baseInfo.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 车辆车型-车辆颜色
 */
public class LeaseCarModelColor implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;

    @ApiModelProperty(value = "车型主键id", hidden = false)
    private Long carModelId;

    @ApiModelProperty(value = "所属分公司主键id", hidden = false)
    private Long branchCompanyId;

    @ApiModelProperty(value = "所属分公司名称", hidden = false)
    private String branchCompanyName;

    @ApiModelProperty(value = "主键id", hidden = false)
    private BigDecimal price;

    @ApiModelProperty(value = "颜色主键id", hidden = false)
    private Long carColorId;

    @ApiModelProperty(value = "价格", hidden = false)
    private List<Long> ids;

    public LeaseCarModelColor() {
    }

    public LeaseCarModelColor(Long carModelId, Long carColorId, BigDecimal price, Long branchCompanyId) {
        this.carModelId = carModelId;
        this.carColorId = carColorId;
        this.price = price;
        this.branchCompanyId = branchCompanyId;
    }

    public LeaseCarModelColor(Long id, Long carModelId, Long carColorId, BigDecimal price, Long branchCompanyId) {
        this.id = id;
        this.carModelId = carModelId;
        this.carColorId = carColorId;
        this.price = price;
        this.branchCompanyId = branchCompanyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(Long carModelId) {
        this.carModelId = carModelId;
    }

    public Long getCarColorId() {
        return carColorId;
    }

    public void setCarColorId(Long carColorId) {
        this.carColorId = carColorId;
    }

    public Long getBranchCompanyId() {
        return branchCompanyId;
    }

    public void setBranchCompanyId(Long branchCompanyId) {
        this.branchCompanyId = branchCompanyId;
    }

    public String getBranchCompanyName() {
        return branchCompanyName;
    }

    public void setBranchCompanyName(String branchCompanyName) {
        this.branchCompanyName = branchCompanyName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}