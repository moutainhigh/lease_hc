package com.hc.lease.supplier.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hc.lease.supplier.model.LeaseSchemeArea;
import com.hc.lease.supplier.model.LeaseSchemeVehicle;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/12.
 */
public class LeaseSchemePackageVo implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
   /* @ApiModelProperty(value = "品牌主键Id/适用车型", hidden = false)
    private Long brandsId;
    @ApiModelProperty(value = "系列主键Id/适用车型", hidden = false)
    private Long seriesId;
    @ApiModelProperty(value = "车型主键Id/适用车型", hidden = false)
    private Long modelId;
    @ApiModelProperty(value = "颜色主键Id/适用车型", hidden = false)
    private Long colorId;*/
    @ApiModelProperty(value = "方案名称", hidden = false)
    private String schemeName;
    @ApiModelProperty(value = "分公司主键Id", hidden = false, required = true)
    private Long branchCompanyId;
    @ApiModelProperty(value = "全包价", hidden = false)
    private BigDecimal totalAmount;
    @ApiModelProperty(value = "年利率", hidden = false)
    private BigDecimal annualInterest;
    @ApiModelProperty(value = "方案可选类型/字典表的数据 ; 首款尾款绝对值  或 融资比例", hidden = false)
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

    @ApiModelProperty(value = "首期包含第1个月租金 0 是 1 否", hidden = false)
    private Integer stagingContainMonthlyRent;

    @ApiModelProperty(value = "首期金额", hidden = false)
    private BigDecimal downPayment;
    @ApiModelProperty(value = "尾款", hidden = false)
    private BigDecimal balancePayment;
    @ApiModelProperty(value = "分期数/字典表的分期数主键id", hidden = false)
    private Integer stagingNumberId;
    @ApiModelProperty(value = "月租", hidden = false)
    private BigDecimal monthlyRent;
    @ApiModelProperty(value = "客户经理/渠道备注", hidden = false)
    private String clientManagerRemarks;
    @ApiModelProperty(value = "类型 0:默认套餐;1:定制套餐", hidden = false)
    private Integer type;
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

    @ApiModelProperty(value = "适用车型 是否全部 0 是 1 否", hidden = false)
    private String carAll;
    @ApiModelProperty(value = "适用地区 是否全部 0 是 1 否", hidden = false)
    private String areaAll;

    @ApiModelProperty(value = "适用车型实体类", hidden = false)
    private List<LeaseSchemeArea> leaseSchemeAreas;
    @ApiModelProperty(value = "适用地区实体类", hidden = false)
    private List<LeaseSchemeVehicle> leaseSchemeVehicles;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



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
        this.clientManagerRemarks = clientManagerRemarks == null ? null : clientManagerRemarks.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStagingNumberId() {
        return stagingNumberId;
    }

    public void setStagingNumberId(Integer stagingNumberId) {
        this.stagingNumberId = stagingNumberId;
    }

    public Integer getSchemeType() {
        return schemeType;
    }

    public void setSchemeType(Integer schemeType) {
        this.schemeType = schemeType;
    }


    public Integer getStagingContainMonthlyRent() {
        return stagingContainMonthlyRent;
    }

    public void setStagingContainMonthlyRent(Integer stagingContainMonthlyRent) {
        this.stagingContainMonthlyRent = stagingContainMonthlyRent;
    }


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

    public Long getBranchCompanyId() {
        return branchCompanyId;
    }

    public void setBranchCompanyId(Long branchCompanyId) {
        this.branchCompanyId = branchCompanyId;
    }

    public BigDecimal getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(BigDecimal annualInterest) {
        this.annualInterest = annualInterest;
    }
}
