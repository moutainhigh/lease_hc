package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.poi.annotation.CostCheckExcelCol;
import lombok.Data;

import java.io.Serializable;

/**
 * 创建人：tong<br/>
 * 创建时间：2018/1/10<br/>
 * 说明：小程序车辆EXCEL导入模板
 */
@Data
@CostCheckExcelCol("车辆数据EXCEL导入")
public class WxCarTemplate implements Serializable {

    @CostCheckExcelCol("车辆名称")
    private String carName;
    @CostCheckExcelCol("燃料类型")
    private String typeName;
    @CostCheckExcelCol("市场指导价")
    private String marketPrice;
    @CostCheckExcelCol("车身结构")
    private String carStructure;
    @CostCheckExcelCol("长/宽/高")
    private String longWidthHeight;
    @CostCheckExcelCol("发动机")
    private String engine;
    @CostCheckExcelCol("变速箱")
    private String transmission;
    @CostCheckExcelCol("驱动方式")
    private String driveMode;
    @CostCheckExcelCol("燃料方式")
    private String fuelMode;
    @CostCheckExcelCol("综合油耗")
    private String fuel;
    @CostCheckExcelCol("快充时间")
    private Integer fastTime;
    @CostCheckExcelCol("慢充时间")
    private Integer slowTime;
    @CostCheckExcelCol("快充电量")
    private Integer fastChargeQuantity;
    @CostCheckExcelCol("电动机总功率")
    private Integer totalPower;
    @CostCheckExcelCol("续航里程")
    private Integer enduranceMileage;
    @CostCheckExcelCol("电池容量")
    private Integer batteryCapacity;
    @CostCheckExcelCol("导入结果")
    private String updateState;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getCarStructure() {
        return carStructure;
    }

    public void setCarStructure(String carStructure) {
        this.carStructure = carStructure;
    }

    public String getLongWidthHeight() {
        return longWidthHeight;
    }

    public void setLongWidthHeight(String longWidthHeight) {
        this.longWidthHeight = longWidthHeight;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getDriveMode() {
        return driveMode;
    }

    public void setDriveMode(String driveMode) {
        this.driveMode = driveMode;
    }

    public String getFuelMode() {
        return fuelMode;
    }

    public void setFuelMode(String fuelMode) {
        this.fuelMode = fuelMode;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getUpdateState() {
        return updateState;
    }

    public void setUpdateState(String updateState) {
        this.updateState = updateState;
    }


    public Integer getFastTime() {
        return fastTime;
    }

    public void setFastTime(Integer fastTime) {
        this.fastTime = fastTime;
    }

    public Integer getSlowTime() {
        return slowTime;
    }

    public void setSlowTime(Integer slowTime) {
        this.slowTime = slowTime;
    }

    public Integer getFastChargeQuantity() {
        return fastChargeQuantity;
    }

    public void setFastChargeQuantity(Integer fastChargeQuantity) {
        this.fastChargeQuantity = fastChargeQuantity;
    }

    public Integer getTotalPower() {
        return totalPower;
    }

    public void setTotalPower(Integer totalPower) {
        this.totalPower = totalPower;
    }

    public Integer getEnduranceMileage() {
        return enduranceMileage;
    }

    public void setEnduranceMileage(Integer enduranceMileage) {
        this.enduranceMileage = enduranceMileage;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
