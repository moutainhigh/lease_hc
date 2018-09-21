package com.hc.lease.baseInfo.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 车辆车型-车辆颜色-价格vo
 */
public class LeaseCarModelColorPriceVo implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false, required=true)
    private Long id;

    @ApiModelProperty(value = "车辆车型主键id", hidden = false, required=true)
    private Long carModelId;

    @ApiModelProperty(value = "车辆颜色主键id", hidden = false, required=true)
    private Long carColorId;

    @ApiModelProperty(value = "价格", hidden = false, required=true)
    private BigDecimal price;

    @ApiModelProperty(value = "车辆车型名称", hidden = false, required=true)
    private String carModelName;

    @ApiModelProperty(value = "车辆颜色名称", hidden = false, required=true)
    private String carColorName;

    @ApiModelProperty(value = "分公司主键id", hidden = false)
    private Long branchCompanyId;

    @ApiModelProperty(value = "所属分公司名称", hidden = false)
    private String branchCompanyName;

    public LeaseCarModelColorPriceVo() {
    }

    public LeaseCarModelColorPriceVo(Long carModelId, Long carColorId, BigDecimal price, Long branchCompanyId) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public String getCarColorName() {
        return carColorName;
    }

    public void setCarColorName(String carColorName) {
        this.carColorName = carColorName;
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
}