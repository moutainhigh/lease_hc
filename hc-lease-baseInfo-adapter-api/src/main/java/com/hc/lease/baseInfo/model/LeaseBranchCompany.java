package com.hc.lease.baseInfo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hc.lease.supplier.model.LeaseStorehouse;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class LeaseBranchCompany implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "编号", hidden = false)
    private String number;
    @ApiModelProperty(value = "公司名称", hidden = false)
    private String name;
    @ApiModelProperty(value = "省份ID", hidden = false)
    private Long provinceId;
    @ApiModelProperty(value = "省份名称", hidden = false)
    private String provinceName;
    @ApiModelProperty(value = "城市ID", hidden = false)
    private Long cityId;
    @ApiModelProperty(value = "城市名称", hidden = false)
    private String cityName;
    @ApiModelProperty(value = "区域ID", hidden = false)
    private Long areaId;
    @ApiModelProperty(value = "区域名称", hidden = false)
    private String areaName;
    @ApiModelProperty(value = "详细地址", hidden = false)
    private String address;
    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "状态 0:禁用 1:启用", hidden = false)
    private Boolean isEnable;
    @ApiModelProperty(value = "联系人", hidden = false)
    private String contacts;
    @ApiModelProperty(value = "电话", hidden = false)
    private String contactPhone;
    @ApiModelProperty(value = "公司编号", hidden = false)
    private String companyCode;
    @ApiModelProperty(value = "父级ID", hidden = false)
    private Long parentId;
    @ApiModelProperty(value = "排序", hidden = false)
    private Integer sort;
    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    @ApiModelProperty(value = "出租人完整名称", hidden = false)
    private String lessorFullName;
    @ApiModelProperty(value = "出租人简称", hidden = false)
    private String lessorShortName;


    @ApiModelProperty(value = "组织机构代码", hidden = false)
    private String organizationNumber;
    @ApiModelProperty(value = "手机", hidden = false)
    private String phone;
    @ApiModelProperty(value = "备注", hidden = false)
    private String remarks;

    @ApiModelProperty(value = "用于修改排序记录位置变化", hidden = false)
    private Integer mark;






    private List<LeaseStorehouse>  leaseStorehouseList;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

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

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }


    public List<LeaseStorehouse> getLeaseStorehouseList() {
        return leaseStorehouseList;
    }

    public void setLeaseStorehouseList(List<LeaseStorehouse> leaseStorehouseList) {
        this.leaseStorehouseList = leaseStorehouseList;
    }

    public String getLessorFullName() {
        return lessorFullName;
    }

    public void setLessorFullName(String lessorFullName) {
        this.lessorFullName = lessorFullName;
    }

    public String getLessorShortName() {
        return lessorShortName;
    }

    public void setLessorShortName(String lessorShortName) {
        this.lessorShortName = lessorShortName;
    }

    public String getOrganizationNumber() {
        return organizationNumber;
    }

    public void setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}