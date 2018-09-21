package com.hc.lease.baseInfo.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 车辆车型vo
 */
public class LeaseCarModelVo implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false, required=true)
    private Long id;

    @ApiModelProperty(value = "车辆品牌名称", hidden = false, required=true)
    private String brandsName;

    @ApiModelProperty(value = "车辆系列名称", hidden = false, required=true)
    private String seriesName;

    @ApiModelProperty(value = "完整型号", hidden = false, required=true)
    private String completeModelName;

    @ApiModelProperty(value = "年份", hidden = false, required=true)
    private String particularYear;

    @ApiModelProperty(value = "商业型号", hidden = false, required=true)
    private String businessModelName;

    @ApiModelProperty(value = "型号代码", hidden = false, required=true)
    private String modelCode;

    @ApiModelProperty(value = "燃料类型名称", hidden = false, required=true)
    private String fuelTypeName;

    @ApiModelProperty(value = "排量名称", hidden = false, required=true)
    private String outputVolumeName;

    @ApiModelProperty(value = "每公里数", hidden = false, required=true)
    private Integer kilometreNumber;

    @ApiModelProperty(value = "每月数", hidden = false, required=true)
    private Integer monthsNumber;

    @ApiModelProperty(value = "备注", hidden = false, required=true)
    private String remarks;

    @ApiModelProperty(value = "每公里数/每月数", hidden = false, required=true)
    private String kilometreMonthsNumber;

    @ApiModelProperty(value = "保养规则主键id", hidden = false, required=true)
    private Long kilometreMonthsId;

    private ArrayList<LeaseCarModelColorPriceVo> leaseCarModelColorPriceVoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getParticularYear() {
        return particularYear;
    }

    public void setParticularYear(String particularYear) {
        this.particularYear = particularYear;
    }

    public String getCompleteModelName() {
        return completeModelName;
    }

    public void setCompleteModelName(String completeModelName) {
        this.completeModelName = completeModelName;
    }

    public String getBusinessModelName() {
        return businessModelName;
    }

    public void setBusinessModelName(String businessModelName) {
        this.businessModelName = businessModelName;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getFuelTypeName() {
        return fuelTypeName;
    }

    public void setFuelTypeName(String fuelTypeName) {
        this.fuelTypeName = fuelTypeName;
    }

    public String getOutputVolumeName() {
        return outputVolumeName;
    }

    public void setOutputVolumeName(String outputVolumeName) {
        this.outputVolumeName = outputVolumeName;
    }

    public Integer getKilometreNumber() {
        return kilometreNumber;
    }

    public void setKilometreNumber(Integer kilometreNumber) {
        this.kilometreNumber = kilometreNumber;
    }

    public Integer getMonthsNumber() {
        return monthsNumber;
    }

    public void setMonthsNumber(Integer monthsNumber) {
        this.monthsNumber = monthsNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getKilometreMonthsNumber() {
        return kilometreMonthsNumber;
    }

    public void setKilometreMonthsNumber(String kilometreMonthsNumber) {
        this.kilometreMonthsNumber = kilometreMonthsNumber;
    }

    public Long getKilometreMonthsId() {
        return kilometreMonthsId;
    }

    public void setKilometreMonthsId(Long kilometreMonthsId) {
        this.kilometreMonthsId = kilometreMonthsId;
    }

    public ArrayList<LeaseCarModelColorPriceVo> getLeaseCarModelColorPriceVoList() {
        return leaseCarModelColorPriceVoList;
    }

    public void setLeaseCarModelColorPriceVoList(ArrayList<LeaseCarModelColorPriceVo> leaseCarModelColorPriceVoList) {
        this.leaseCarModelColorPriceVoList = leaseCarModelColorPriceVoList;
    }
}