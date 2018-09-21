package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.poi.annotation.CostCheckExcelCol;

import java.io.Serializable;
import java.math.BigDecimal;

public class LeaseCarModelTemplate implements Serializable {

    @CostCheckExcelCol("品牌")
    private String brandName;
    @CostCheckExcelCol("系列")
    private String seriesName;
    @CostCheckExcelCol("型号")
    private String completeModelName;
    @CostCheckExcelCol("市场指导价")
    private String marketPrice;
    @CostCheckExcelCol("商业型号")
    private String businessModelName;
    @CostCheckExcelCol("标的物类型")
    private String itemType;
    @CostCheckExcelCol("年份")
    private String particularYear;
    @CostCheckExcelCol("型号代码")
    private String modelCode;
    @CostCheckExcelCol("燃料类型")
    private String fuelTypeName;
    @CostCheckExcelCol("排量")
    private BigDecimal outputVolumeName;
 /*   @CostCheckExcelCol("颜色")
    private String colorName;*/
    @CostCheckExcelCol("颜色差价备注")
    private String colorPriceRemarks;
    @CostCheckExcelCol("导入结果")
    private String updateState;

    public String getCompleteModelName() {
        return completeModelName;
    }

    public void setCompleteModelName(String completeModelName) {
        this.completeModelName = completeModelName;
    }



    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getBusinessModelName() {
        return businessModelName;
    }

    public void setBusinessModelName(String businessModelName) {
        this.businessModelName = businessModelName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getParticularYear() {
        return particularYear;
    }

    public void setParticularYear(String particularYear) {
        this.particularYear = particularYear;
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


  /*  public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }*/

    public String getColorPriceRemarks() {
        return colorPriceRemarks;
    }

    public void setColorPriceRemarks(String colorPriceRemarks) {
        this.colorPriceRemarks = colorPriceRemarks;
    }

    public String getUpdateState() {
        return updateState;
    }

    public void setUpdateState(String updateState) {
        this.updateState = updateState;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public BigDecimal getOutputVolumeName() {
        return outputVolumeName;
    }

    public void setOutputVolumeName(BigDecimal outputVolumeName) {
        this.outputVolumeName = outputVolumeName;
    }
}