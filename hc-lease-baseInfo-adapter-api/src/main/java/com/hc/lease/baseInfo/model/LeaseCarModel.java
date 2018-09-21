package com.hc.lease.baseInfo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hc.lease.baseInfo.vo.LeaseCarModelColorPriceVo;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 车辆车型
 */
public class LeaseCarModel implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false, required = true)
    private Long id;

    @ApiModelProperty(value = "编号", hidden = false, required = true)
    private String number;

    @ApiModelProperty(value = "车辆系列主键id", hidden = false, required = true)
    private Long seriesId;

    @ApiModelProperty(value = "完整型号", hidden = false, required = true)
    private String completeModelName;

    @ApiModelProperty(value = "标的物类型", hidden = false, required = true)
    private String itemType;

    @ApiModelProperty(value = "年份", hidden = false, required = true)
    private String particularYear;

    @ApiModelProperty(value = "商业型号", hidden = false, required = true)
    private String businessModelName;

    @ApiModelProperty(value = "型号代码", hidden = false, required = true)
    private String modelCode;

    @ApiModelProperty(value = "燃料类型/字典表的燃料类型主键id", hidden = false, required = true)
    private Long fuelType;

    @ApiModelProperty(value = "备注", hidden = false, required = true)
    private String remarks;

    @ApiModelProperty(value = "创建日期", hidden = false, required = true)
    private Date createTime;

    @ApiModelProperty(value = "修改日期", hidden = false, required = true)
    private Date updateTime;

    @ApiModelProperty(value = "创建人主键id", hidden = false, required = true)
    private Long createBy;

    @ApiModelProperty(value = "修改人主键id", hidden = false, required = true)
    private Long updateBy;

    @ApiModelProperty(value = "排序", hidden = false, required = true)
    private Integer sort;

    @ApiModelProperty(value = "状态 0:禁用 1:启用", hidden = false, required = true)
    private Boolean isEnable;

    @ApiModelProperty(value = "排量/字典表的排量主键id", hidden = false, required = true)
    private Long dictIdOutputVolume;

    @ApiModelProperty(value = "保养规则主键id", hidden = false, required = true)
    private Long maintainRuleId;

    @ApiModelProperty(value = "车辆品牌主键id", hidden = false, required = true)
    private Long brandsId;

    @ApiModelProperty(value = "颜色/价格json格式", hidden = false, required = true)
    private String leaseCarModelColorPriceJson;//颜色/价格json格式

    @ApiModelProperty(value = "接收颜色/价格List", hidden = false, required = true)
    private List<LeaseCarModelColorPriceVo> leaseCarModelColorPriceVoList;

    @ApiModelProperty(value = "车辆车型主键id", hidden = false, required = true)
    private List<Long> ids;

    @ApiModelProperty(value = "每公里数/每月数", hidden = false, required = true)
    private String kilometreMonthsNumber;

    @ApiModelProperty(value = "车辆品牌名称", hidden = false, required = true)
    private String brandsName;

    @ApiModelProperty(value = "车辆系列名称", hidden = false, required = true)
    private String seriesName;

    @ApiModelProperty(value = "车辆颜色名称", hidden = false, required = true)
    private String colorName;

    @ApiModelProperty(value = "燃料类型名称", hidden = false, required = true)
    private String fuelTypeName;

    @ApiModelProperty(value = "排量名称", hidden = false, required = true)
    private String outputVolumeName;

    @ApiModelProperty(value = "每公里数", hidden = false, required = true)
    private Integer kilometreNumber;

    @ApiModelProperty(value = "每月数", hidden = false, required = true)
    private Integer monthsNumber;


    @ApiModelProperty(value = "车辆颜色主键id", hidden = false, required=true)
    private Long colorId;

    @ApiModelProperty(value = "市场指导价", hidden = false, required=true)
    private BigDecimal marketPrice;
    @ApiModelProperty(value = "颜色差价备注", hidden = false, required=true)
    private String colorPriceRemarks;


    @ApiModelProperty(value = "用于修改排序记录位置变化", hidden = false)
    private Integer mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Long getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Long seriesId) {
        this.seriesId = seriesId;
    }

    @NotBlank(message = "名称不能为空")
    public String getCompleteModelName() {
        return completeModelName;
    }

    public void setCompleteModelName(String completeModelName) {
        this.completeModelName = completeModelName == null ? null : completeModelName.trim();
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
        this.particularYear = particularYear == null ? null : particularYear.trim();
    }

    public String getBusinessModelName() {
        return businessModelName;
    }

    public void setBusinessModelName(String businessModelName) {
        this.businessModelName = businessModelName == null ? null : businessModelName.trim();
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode == null ? null : modelCode.trim();
    }

    public Long getFuelType() {
        return fuelType;
    }

    public void setFuelType(Long fuelType) {
        this.fuelType = fuelType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public Long getDictIdOutputVolume() {
        return dictIdOutputVolume;
    }

    public void setDictIdOutputVolume(Long dictIdOutputVolume) {
        this.dictIdOutputVolume = dictIdOutputVolume;
    }

    public Long getMaintainRuleId() {
        return maintainRuleId;
    }

    public void setMaintainRuleId(Long maintainRuleId) {
        this.maintainRuleId = maintainRuleId;
    }

    public Long getBrandsId() {
        return brandsId;
    }

    public void setBrandsId(Long brandsId) {
        this.brandsId = brandsId;
    }

    public String getLeaseCarModelColorPriceJson() {
        return leaseCarModelColorPriceJson;
    }

    public void setLeaseCarModelColorPriceJson(String leaseCarModelColorPriceJson) {
        this.leaseCarModelColorPriceJson = leaseCarModelColorPriceJson;
    }

    public List<LeaseCarModelColorPriceVo> getLeaseCarModelColorPriceVoList() {
        return leaseCarModelColorPriceVoList;
    }

    public void setLeaseCarModelColorPriceVoList(List<LeaseCarModelColorPriceVo> leaseCarModelColorPriceVoList) {
        this.leaseCarModelColorPriceVoList = leaseCarModelColorPriceVoList;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getKilometreMonthsNumber() {
        return kilometreMonthsNumber;
    }

    public void setKilometreMonthsNumber(String kilometreMonthsNumber) {
        this.kilometreMonthsNumber = kilometreMonthsNumber;
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

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getColorPriceRemarks() {
        return colorPriceRemarks;
    }

    public void setColorPriceRemarks(String colorPriceRemarks) {
        this.colorPriceRemarks = colorPriceRemarks;
    }
}