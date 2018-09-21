package com.hc.lease.supplier.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeaseCarInsurance implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "车辆主键Id", hidden = false)
    private Long carId;
    @ApiModelProperty(value = "保险公司主键Id", hidden = false)
    private Long insuranceCompanyId;
    @ApiModelProperty(value = "险种主键Id", hidden = false)
    private Long insuranceTypeId;
    @ApiModelProperty(value = "类型 0:交强险;1:商业险 2:商业险2", hidden = false)
    private Integer type;
    @ApiModelProperty(value = "年份：1：第一年 2：第二年 3：第三年", hidden = false)
    private Integer year;
    @ApiModelProperty(value = "保单号", hidden = false)
    private String insuranceNumber;
    @ApiModelProperty(value = "保费", hidden = false)
    private BigDecimal premium;
    @ApiModelProperty(value = "保费税额", hidden = false)
    private BigDecimal sumInsured;
    @ApiModelProperty(value = "不含税保费价", hidden = false)
    private BigDecimal taxAllowances;
    @ApiModelProperty(value = "保单扫描件", hidden = false)
    private String policyScannerImg;
    @ApiModelProperty(value = "保单扫描件List", hidden = false)
    private List<String> policyScannerImgs;
    @ApiModelProperty(value = "保险生效日期", hidden = false)
    private Date effectiveTime;
    @ApiModelProperty(value = "增值税发票号", hidden = false)
    private String vatInvoiceNumber;
    @ApiModelProperty(value = "普票税金额", hidden = false)
    private BigDecimal ticketTaxAmount;
    @ApiModelProperty(value = "普票税发票号", hidden = false)
    private String ticketInvoiceNumber;

    @ApiModelProperty(value = "不含增值税保单额", hidden = false)
    private BigDecimal noVatPolicyAmount;
    @ApiModelProperty(value = "不含普票税保单额", hidden = false)
    private BigDecimal noOrdinaryTaxPolicy;
    @ApiModelProperty(value = "不记名司机乘员意外险 0:有;1:无", hidden = false)
    private Integer accidentInsurance;
    @ApiModelProperty(value = "保险到期日期", hidden = false)
    private Date expireTime;
    @ApiModelProperty(value = "保险份额", hidden = false)
    private Integer portionNum;

    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    private String insuranceCompanyName;
    private String insuranceTypeName;

    @Override
    public String toString() {
        return "LeaseCarInsurance{" +
                "id=" + id +
                ", carId=" + carId +
                ", insuranceCompanyId=" + insuranceCompanyId +
                ", insuranceTypeId=" + insuranceTypeId +
                ", type=" + type +
                ", year=" + year +
                ", insuranceNumber='" + insuranceNumber + '\'' +
                ", premium=" + premium +
                ", sumInsured=" + sumInsured +
                ", taxAllowances=" + taxAllowances +
                ", policyScannerImg='" + policyScannerImg + '\'' +
                ", policyScannerImgs=" + policyScannerImgs +
                ", effectiveTime=" + effectiveTime +
                ", vatInvoiceNumber='" + vatInvoiceNumber + '\'' +
                ", ticketTaxAmount=" + ticketTaxAmount +
                ", ticketInvoiceNumber='" + ticketInvoiceNumber + '\'' +
                ", noVatPolicyAmount=" + noVatPolicyAmount +
                ", noOrdinaryTaxPolicy=" + noOrdinaryTaxPolicy +
                ", ids=" + ids +
                ", insuranceCompanyName='" + insuranceCompanyName + '\'' +
                ", insuranceTypeName='" + insuranceTypeName + '\'' +
                '}';
    }

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

    public String getVatInvoiceNumber() {
        return vatInvoiceNumber;
    }

    public void setVatInvoiceNumber(String vatInvoiceNumber) {
        this.vatInvoiceNumber = vatInvoiceNumber;
    }

    public BigDecimal getTicketTaxAmount() {
        return ticketTaxAmount;
    }

    public void setTicketTaxAmount(BigDecimal ticketTaxAmount) {
        this.ticketTaxAmount = ticketTaxAmount;
    }

    public String getTicketInvoiceNumber() {
        return ticketInvoiceNumber;
    }

    public void setTicketInvoiceNumber(String ticketInvoiceNumber) {
        this.ticketInvoiceNumber = ticketInvoiceNumber;
    }

    public BigDecimal getNoVatPolicyAmount() {
        return noVatPolicyAmount;
    }

    public void setNoVatPolicyAmount(BigDecimal noVatPolicyAmount) {
        this.noVatPolicyAmount = noVatPolicyAmount;
    }

    public BigDecimal getNoOrdinaryTaxPolicy() {
        return noOrdinaryTaxPolicy;
    }

    public void setNoOrdinaryTaxPolicy(BigDecimal noOrdinaryTaxPolicy) {
        this.noOrdinaryTaxPolicy = noOrdinaryTaxPolicy;
    }

    public Integer getAccidentInsurance() {
        return accidentInsurance;
    }

    public void setAccidentInsurance(Integer accidentInsurance) {
        this.accidentInsurance = accidentInsurance;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getPortionNum() {
        return portionNum;
    }

    public void setPortionNum(Integer portionNum) {
        this.portionNum = portionNum;
    }

    public void carInsuranceImportUpdateSet(Long id, Long insuranceCompanyId, Integer type, String insuranceNumber, BigDecimal premium, Date effectiveTime) {
        this.id = id;
        this.insuranceCompanyId = insuranceCompanyId;
        this.type = type;
        this.insuranceNumber = insuranceNumber;
        this.premium = premium;
        this.effectiveTime = effectiveTime;
    }

    public void carInsuranceImportAddSet(Long carId, Long insuranceCompanyId, Integer type, Integer year, String insuranceNumber, BigDecimal premium, Date effectiveTime) {
        this.carId = carId;
        this.insuranceCompanyId = insuranceCompanyId;
        this.type = type;
        this.year = year;
        this.insuranceNumber = insuranceNumber;
        this.premium = premium;
        this.effectiveTime = effectiveTime;
    }
}