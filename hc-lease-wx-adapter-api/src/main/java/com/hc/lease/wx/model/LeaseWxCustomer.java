package com.hc.lease.wx.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;

import java.io.Serializable;
import java.util.Date;

public class LeaseWxCustomer implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "姓名", hidden = false)
    private String name;
    @ApiModelProperty(value = "手机号码", hidden = false)
    private String phone;
    @ApiModelProperty(value = "省份名称", hidden = false)
    private String provinceName;
    @ApiModelProperty(value = "市名称", hidden = false)
    private String cityName;
    @ApiModelProperty(value = "地区名称", hidden = false)
    private String areaName;
    @ApiModelProperty(value = "创建时间", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "用于导出excel显示处理状态", hidden = false)
    private String dealName;
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
    @ApiModelProperty(value = "微信openid", hidden = false)
    private String openid;
    @ApiModelProperty(value = "省份ID", hidden = false)
    private Long provinceId;
    @ApiModelProperty(value = "市ID", hidden = false)
    private Long cityId;
    @ApiModelProperty(value = "地区ID", hidden = false)
    private Long areaId;
    @ApiModelProperty(value = "是否处理（1 已处理 2 未处理）", hidden = false)
    private Short deal;
    @ApiModelProperty(value = "车辆ID", hidden = false)
    private Long carId;
    @ApiModelProperty(value = "期数", hidden = false)
    private Integer stagingNumber;
    @ApiModelProperty(value = "预期购买时间", hidden = false)
    private String buyTime;
    @ApiModelProperty(value = "车辆名称", hidden = false)
    private String carName;
    @ApiModelProperty(value = "备注", hidden = false)
    private String remark;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public Short getDeal() {
        return deal;
    }

    public void setDeal(Short deal) {
        this.deal = deal;
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

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Integer getStagingNumber() {
        return stagingNumber;
    }

    public void setStagingNumber(Integer stagingNumber) {
        this.stagingNumber = stagingNumber;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}