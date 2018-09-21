package com.hc.lease.supplier.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeaseScheme  implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
  /*  @ApiModelProperty(value = "品牌主键Id/适用车型", hidden = false)
    private Long brandsId;
    @ApiModelProperty(value = "系列主键Id/适用车型", hidden = false)
    private Long seriesId;
    @ApiModelProperty(value = "车型主键Id/适用车型", hidden = false)
    private Long modelId;
    @ApiModelProperty(value = "颜色主键Id/适用车型", hidden = false)
    private Long colorId;*/
    @ApiModelProperty(value = "方案名称", hidden = false, required = true)
    private String schemeName;
    @ApiModelProperty(value = "分公司主键Id", hidden = false, required = true)
    private Long branchCompanyId;
    @ApiModelProperty(value = "全包价", hidden = false)
    private BigDecimal totalAmount;
    @ApiModelProperty(value = "年利率", hidden = false)
    private BigDecimal annualInterest;

    @ApiModelProperty(value = "方案可选类型/字典表的数据 ; 首款尾款绝对值  或 融资比例", hidden = false, required = true)
    private Integer schemeType;
   /* @ApiModelProperty(value = "省份ID", hidden = false)
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
    private String areaName;*/
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
    @ApiModelProperty(value = "排序", hidden = false)
    private Integer sort;
    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;
    @ApiModelProperty(value = "适用车型 是否全部 0 是 1 否", hidden = false, required = true)
    private String carAll;
    @ApiModelProperty(value = "适用地区 是否全部 0 是 1 否", hidden = false, required = true)
    private String areaAll;

    @ApiModelProperty(value = "适用车型实体类", hidden = false, required = true)
    private List<LeaseSchemeArea> leaseSchemeAreas;
    @ApiModelProperty(value = "适用车型实体类Json", hidden = false, required = true)
    private String leaseSchemeAreaJson;
    @ApiModelProperty(value = "适用地区实体类", hidden = false, required = true)
    private List<LeaseSchemeVehicle> leaseSchemeVehicles;
    @ApiModelProperty(value = "适用地区实体类Json", hidden = false, required = true)
    private String leaseSchemeVehicleJson;
    //显示要添加的
    @ApiModelProperty(value = "显示用", hidden = false, required = true)
    private BigDecimal  downPayment;
    @ApiModelProperty(value = "显示用", hidden = false, required = true)
    private BigDecimal balancePayment;
    @ApiModelProperty(value = "显示用", hidden = false, required = true)
    private BigDecimal monthlyRent;
    @ApiModelProperty(value = "显示用", hidden = false, required = true)
    private String  clientManagerRemarks;
    @ApiModelProperty(value = "显示用", hidden = false, required = true)
    private Integer type;
    @ApiModelProperty(value = "显示用", hidden = false, required = true)
    private Integer stagingContainMonthlyRent;
    @ApiModelProperty(value = "显示用", hidden = false, required = true)
    private String stagingContainMonthlyRentName;
    @ApiModelProperty(value = "显示用", hidden = false, required = true)
    private String stagingNumberName;
    @ApiModelProperty(value = "显示用", hidden = false, required = true)
    private Integer stagingNumberId;

    @ApiModelProperty(value = "显示用", hidden = false, required = true)
    private String schemeTypeName;

    @ApiModelProperty(value = "显示用", hidden = false, required = true)
    private String brandsName;
    @ApiModelProperty(value = "显示用", hidden = false, required = true)
    private String seriesName;
    @ApiModelProperty(value = "显示用", hidden = false, required = true)
    private String completeModelName;
    @ApiModelProperty(value = "显示用", hidden = false, required = true)
    private String businessModelName;
    @ApiModelProperty(value = "显示用", hidden = false, required = true)
    private String branchCompanyName;
    @ApiModelProperty(value = "显示用", hidden = false, required = true)
    private Boolean used;



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

  /*  public Long getBrandsId() {
        return brandsId;
    }

    public void setBrandsId(Long brandsId) {
        this.brandsId = brandsId;
    }

    public Long getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Long seriesId) {
        this.seriesId = seriesId;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }*/

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName == null ? null : schemeName.trim();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }


    public Integer getSchemeType() {
        return schemeType;
    }

    public void setSchemeType(Integer schemeType) {
        this.schemeType = schemeType;
    }

   /* public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
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
        this.cityName = cityName;
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
        this.areaName = areaName;
    }*/


    public List<LeaseSchemeArea> getLeaseSchemeAreas() {
        return leaseSchemeAreas;
    }

    public void setLeaseSchemeAreas(List<LeaseSchemeArea> leaseSchemeAreas) {
        this.leaseSchemeAreas = leaseSchemeAreas;
    }

    public List<LeaseSchemeVehicle> getLeaseSchemeVehicles() {
        return leaseSchemeVehicles;
    }

    public void setLeaseSchemeVehicles(List<LeaseSchemeVehicle> leaseSchemeVehicles) {
        this.leaseSchemeVehicles = leaseSchemeVehicles;
    }

    public String getCarAll() {
        return carAll;
    }

    public void setCarAll(String carAll) {
        this.carAll = carAll;
    }

    public String getAreaAll() {
        return areaAll;
    }

    public void setAreaAll(String areaAll) {
        this.areaAll = areaAll;
    }

    public String getLeaseSchemeAreaJson() {
        return leaseSchemeAreaJson;
    }

    public void setLeaseSchemeAreaJson(String leaseSchemeAreaJson) {
        this.leaseSchemeAreaJson = leaseSchemeAreaJson;
    }

    public String getLeaseSchemeVehicleJson() {
        return leaseSchemeVehicleJson;
    }

    public void setLeaseSchemeVehicleJson(String leaseSchemeVehicleJson) {
        this.leaseSchemeVehicleJson = leaseSchemeVehicleJson;
    }

    public BigDecimal getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    public BigDecimal getBalancePayment() {
        return balancePayment;
    }

    public void setBalancePayment(BigDecimal balancePayment) {
        this.balancePayment = balancePayment;
    }

    public BigDecimal getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public String getClientManagerRemarks() {
        return clientManagerRemarks;
    }

    public void setClientManagerRemarks(String clientManagerRemarks) {
        this.clientManagerRemarks = clientManagerRemarks;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStagingContainMonthlyRent() {
        return stagingContainMonthlyRent;
    }

    public void setStagingContainMonthlyRent(Integer stagingContainMonthlyRent) {
        this.stagingContainMonthlyRent = stagingContainMonthlyRent;
    }

    public String getStagingContainMonthlyRentName() {
        return stagingContainMonthlyRentName;
    }

    public void setStagingContainMonthlyRentName(String stagingContainMonthlyRentName) {
        this.stagingContainMonthlyRentName = stagingContainMonthlyRentName;
    }

    public String getStagingNumberName() {
        return stagingNumberName;
    }

    public void setStagingNumberName(String stagingNumberName) {
        this.stagingNumberName = stagingNumberName;
    }

    public String getSchemeTypeName() {
        return schemeTypeName;
    }

    public void setSchemeTypeName(String schemeTypeName) {
        this.schemeTypeName = schemeTypeName;
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

    public Integer getStagingNumberId() {
        return stagingNumberId;
    }

    public void setStagingNumberId(Integer stagingNumberId) {
        this.stagingNumberId = stagingNumberId;
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


    public BigDecimal getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(BigDecimal annualInterest) {
        this.annualInterest = annualInterest;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }
}