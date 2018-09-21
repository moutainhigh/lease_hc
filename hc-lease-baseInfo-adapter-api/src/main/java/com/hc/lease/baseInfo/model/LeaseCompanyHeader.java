package com.hc.lease.baseInfo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 合同方-公司抬头
 */
public class LeaseCompanyHeader implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;

    @ApiModelProperty(value = "名称", hidden = false)
    private String name;

    @ApiModelProperty(value = "编号", hidden = false)
    private Integer number;

    @ApiModelProperty(value = "省份主键id", hidden = false)
    private Long provinceId;

    @ApiModelProperty(value = "省份名称", hidden = false)
    private String provinceName;

    @ApiModelProperty(value = "城市主键id", hidden = false)
    private Long cityId;

    @ApiModelProperty(value = "城市名称", hidden = false)
    private String cityName;

    @ApiModelProperty(value = "区域主键id", hidden = false)
    private Long areaId;

    @ApiModelProperty(value = "区域主键id", hidden = false)
    private String areaName;

    @ApiModelProperty(value = "详细地址", hidden = false)
    private String address;

    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;

    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;

    @ApiModelProperty(value = "创建人主键id", hidden = false)
    private Long createBy;

    @ApiModelProperty(value = "修改人主键id", hidden = false)
    private Long updateBy;

    @ApiModelProperty(value = "排序", hidden = false)
    private Integer sort;

    @ApiModelProperty(value = "状态 0:禁用 1:启用", hidden = false)
    private Boolean isEnable;

    @ApiModelProperty(value = "联系人", hidden = false)
    private String contacts;

    @ApiModelProperty(value = "联系方式", hidden = false)
    private String contactInformation;

    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    @ApiModelProperty(value = "用于修改排序记录位置变化", hidden = false)
    private Integer mark;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotBlank(message = "名称不能为空")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation == null ? null : contactInformation.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}