package com.hc.lease.supplier.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeaseCarInsurance  implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "车辆主键Id", hidden = false)
    private Long carId;
    @ApiModelProperty(value = "保险公司主键Id", hidden = false)
    private Long insuranceCompanyId;
    @ApiModelProperty(value = "险种主键Id", hidden = false)
    private Long insuranceTypeId;
    @ApiModelProperty(value = "类型 0:交强险;1:商业险", hidden = false)
    private Integer type;
    @ApiModelProperty(value = "年份：1：第一年 2：第二年 3：第三年", hidden = false)
    private Integer year;
    @ApiModelProperty(value = "保单号", hidden = false)
    private String insuranceNumber;
    @ApiModelProperty(value = "保费", hidden = false)
    private BigDecimal premium;
    @ApiModelProperty(value = "保额", hidden = false)
    private BigDecimal sumInsured;
    @ApiModelProperty(value = "免税额", hidden = false)
    private BigDecimal taxAllowances;
    @ApiModelProperty(value = "保单扫描件", hidden = false)
    private String policyScannerImg;
    @ApiModelProperty(value = "保单扫描件List", hidden = false)
    private List<String> policyScannerImgs;
    @ApiModelProperty(value = "保险生效日期", hidden = false)
    private Date effectiveTime;
    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    private String insuranceCompanyName;
    private String insuranceTypeName;


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

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getInsuranceCompanyId() {
        return insuranceCompanyId;
    }

    public void setInsuranceCompanyId(Long insuranceCompanyId) {
        this.insuranceCompanyId = insuranceCompanyId;
    }

    public Long getInsuranceTypeId() {
        return insuranceTypeId;
    }

    public void setInsuranceTypeId(Long insuranceTypeId) {
        this.insuranceTypeId = insuranceTypeId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber == null ? null : insuranceNumber.trim();
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    public String getPolicyScannerImg() {
        return policyScannerImg;
    }

    public void setPolicyScannerImg(String policyScannerImg) {
        this.policyScannerImg = policyScannerImg == null ? null : policyScannerImg.trim();
    }
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public List<String> getPolicyScannerImgs() {
        return policyScannerImgs;
    }

    public void setPolicyScannerImgs(List<String> policyScannerImgs) {
        this.policyScannerImgs = policyScannerImgs;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }

    public String getInsuranceTypeName() {
        return insuranceTypeName;
    }

    public void setInsuranceTypeName(String insuranceTypeName) {
        this.insuranceTypeName = insuranceTypeName;
    }

    public BigDecimal getTaxAllowances() {
        return taxAllowances;
    }

    public void setTaxAllowances(BigDecimal taxAllowances) {
        this.taxAllowances = taxAllowances;
    }
}