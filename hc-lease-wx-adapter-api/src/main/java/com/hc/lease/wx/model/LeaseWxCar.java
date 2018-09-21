package com.hc.lease.wx.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeaseWxCar implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "车辆名称", hidden = false)
    private String carName;
    @ApiModelProperty(value = "市场指导价", hidden = false)
    private BigDecimal marketPrice;
    @ApiModelProperty(value = "主图", hidden = false)
    private String mainImg;

    @ApiModelProperty(value = "缩略图", hidden = false)
    private String thumbnailImg;

    @ApiModelProperty(value = "车身结构", hidden = false)
    private String carStructure;
    @ApiModelProperty(value = "长宽高", hidden = false)
    private String longWidthHeight;
    @ApiModelProperty(value = "发动机", hidden = false)
    private String engine;
    @ApiModelProperty(value = "变速箱", hidden = false)
    private String transmission;
    @ApiModelProperty(value = "驱动方式", hidden = false)
    private String driveMode;
    @ApiModelProperty(value = "燃料方式", hidden = false)
    private String fuelMode;
    @ApiModelProperty(value = "综合油耗", hidden = false)
    private String fuel;
    @ApiModelProperty(value = "详情图片", hidden = false)
    private String detailImg;
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

    @ApiModelProperty(value = "快充时间", hidden = false)
    private Integer fastTime;
    @ApiModelProperty(value = "慢充时间", hidden = false)
    private Integer slowTime;
    @ApiModelProperty(value = "快充电量", hidden = false)
    private Integer fastChargeQuantity;
    @ApiModelProperty(value = "电动机总功率", hidden = false)
    private Integer totalPower;
    @ApiModelProperty(value = "续航里程", hidden = false)
    private Integer enduranceMileage;
    @ApiModelProperty(value = "电池容量", hidden = false)
    private Integer batteryCapacity;
    @ApiModelProperty(value = "燃料类型(1汽油 2混合动力 3新能源)", hidden = false)
    private Integer type;




    @ApiModelProperty(value = "接收的主图", hidden = false)
    private List<String> mainImgs;
    @ApiModelProperty(value = "接收的详情图", hidden = false)
    private List<String> detailImgs;
    @ApiModelProperty(value = "车辆融租方案（多个）", hidden = false)
    private List<LeaseWxCarScheme>  leaseWxCarSchemes;
    @ApiModelProperty(value = "车辆融租方案（多个）", hidden = false)
    private String  leaseWxCarSchemeJson;

    @ApiModelProperty(value = "用于修改排序记录位置变化", hidden = false)
    private Integer mark;




//1+X方案
    @ApiModelProperty(value = "首付", hidden = false)
    private BigDecimal downPayment;
    @ApiModelProperty(value = "月租", hidden = false)
    private BigDecimal monthlyRent;
    @ApiModelProperty(value = "第一年分期数", hidden = false)
    private Integer firstYearStagingNumber;
    @ApiModelProperty(value = "尾款", hidden = false)
    private BigDecimal balancePayment;
    @ApiModelProperty(value = "尾款分期List", hidden = false)
    private List<BalancePaymentStagingNumberVo> balancePaymentStagingNumberList;

    @ApiModelProperty(value = "尾款分期(显示)", hidden = false)
    private Object balancePaymentStagingNumber;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName == null ? null : carName.trim();
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg == null ? null : mainImg.trim();
    }

    public String getCarStructure() {
        return carStructure;
    }

    public void setCarStructure(String carStructure) {
        this.carStructure = carStructure == null ? null : carStructure.trim();
    }

    public String getLongWidthHeight() {
        return longWidthHeight;
    }

    public void setLongWidthHeight(String longWidthHeight) {
        this.longWidthHeight = longWidthHeight == null ? null : longWidthHeight.trim();
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine == null ? null : engine.trim();
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission == null ? null : transmission.trim();
    }

    public String getDriveMode() {
        return driveMode;
    }

    public void setDriveMode(String driveMode) {
        this.driveMode = driveMode == null ? null : driveMode.trim();
    }

    public String getFuelMode() {
        return fuelMode;
    }

    public void setFuelMode(String fuelMode) {
        this.fuelMode = fuelMode == null ? null : fuelMode.trim();
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel == null ? null : fuel.trim();
    }

    public String getDetailImg() {
        return detailImg;
    }

    public void setDetailImg(String detailImg) {
        this.detailImg = detailImg == null ? null : detailImg.trim();
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

    public List<String> getMainImgs() {
        return mainImgs;
    }

    public void setMainImgs(List<String> mainImgs) {
        this.mainImgs = mainImgs;
    }

    public List<String> getDetailImgs() {
        return detailImgs;
    }

    public void setDetailImgs(List<String> detailImgs) {
        this.detailImgs = detailImgs;
    }

    public List<LeaseWxCarScheme> getLeaseWxCarSchemes() {
        return leaseWxCarSchemes;
    }

    public void setLeaseWxCarSchemes(List<LeaseWxCarScheme> leaseWxCarSchemes) {
        this.leaseWxCarSchemes = leaseWxCarSchemes;
    }


    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getLeaseWxCarSchemeJson() {
        return leaseWxCarSchemeJson;
    }

    public void setLeaseWxCarSchemeJson(String leaseWxCarSchemeJson) {
        this.leaseWxCarSchemeJson = leaseWxCarSchemeJson;
    }

    public String getThumbnailImg() {
        return thumbnailImg;
    }

    public void setThumbnailImg(String thumbnailImg) {
        this.thumbnailImg = thumbnailImg;
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

    public List<BalancePaymentStagingNumberVo> getBalancePaymentStagingNumberList() {
        return balancePaymentStagingNumberList;
    }

    public void setBalancePaymentStagingNumberList(List<BalancePaymentStagingNumberVo> balancePaymentStagingNumberList) {
        this.balancePaymentStagingNumberList = balancePaymentStagingNumberList;
    }

    public Object getBalancePaymentStagingNumber() {
        return balancePaymentStagingNumber;
    }

    public void setBalancePaymentStagingNumber(Object balancePaymentStagingNumber) {
        this.balancePaymentStagingNumber = balancePaymentStagingNumber;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}