package com.hc.lease.order.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 收车 查看数据
 * Created by tong on 2018/8/6
 */
public class FindByPrimaryKeyVo implements Serializable {
    @ApiModelProperty(value = "承租人名称", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "承租人手机、联系手机", hidden = false)
    private String accountPhone;
    @ApiModelProperty(value = "合同编号", hidden = false)
    private String completeContractNumber;
    @ApiModelProperty(value = "车牌号", hidden = false)
    private String plateNumber;
    @ApiModelProperty(value = "车架号", hidden = false)
    private String cardFrameNumber;
    @ApiModelProperty(value = "品牌名称", hidden = false)
    private String brandsName;
    @ApiModelProperty(value = "系列名称", hidden = false)
    private String seriesName;
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "收车原因", hidden = false)
    private String reason;
    @ApiModelProperty(value = "资产部收车审批意见", hidden = false)
    private String approvalOpinion;
    @ApiModelProperty(value = "备注", hidden = false)
    private String remarks;
    @ApiModelProperty(value = "收车人", hidden = false)
    private String callbackName;
    @ApiModelProperty(value = "收车时间", hidden = false)
    private Date callbackTime;
    @ApiModelProperty(value = "收车方式", hidden = false)
    private String callbackWayName;
    @ApiModelProperty(value = "最后更新", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "处置方式", hidden = false)
    private String dealWayName;
    @ApiModelProperty(value = "车辆指导价", hidden = false)
    private BigDecimal carGuidancePrice;
    @ApiModelProperty(value = "行驶证注册日期", hidden = false)
    private Date drivingLicense;
    @ApiModelProperty(value = "公里数", hidden = false)
    private Integer kilometreNumber;
    @ApiModelProperty(value = "贷款剩余本金", hidden = false)
    private BigDecimal residualPrincipal;
    @ApiModelProperty(value = "评估价", hidden = false)
    private BigDecimal evaluationPrice;
    @ApiModelProperty(value = "交强险到期日期", hidden = false)
    private Date jqInsuranceExpiredate;
    @ApiModelProperty(value = "商业险#1到期日期", hidden = false)
    private Date commercialInsuranceExpiredate;
    @ApiModelProperty(value = "商业险#2到期日期", hidden = false)
    private Date secCommercialInsuranceExpire;
    @ApiModelProperty(value = "月租", hidden = false)
    private BigDecimal monthlyRent;
    @ApiModelProperty(value = "违约金", hidden = false)
    private BigDecimal liquidatedDamages;
    @ApiModelProperty(value = "收车费", hidden = false)
    private BigDecimal callbackExpenses;
    @ApiModelProperty(value = "月租押金", hidden = false)
    private BigDecimal monthlyRentDeposit;
    @ApiModelProperty(value = "收车成本", hidden = false)
    private BigDecimal callbackCost;
    @ApiModelProperty(value = "违章处理", hidden = false)
    private BigDecimal violationExpenses;
    @ApiModelProperty(value = "处置备注", hidden = false)
    private String dealRemarks;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPhone() {
        return accountPhone;
    }

    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
    }

    public String getCompleteContractNumber() {
        return completeContractNumber;
    }

    public void setCompleteContractNumber(String completeContractNumber) {
        this.completeContractNumber = completeContractNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getCardFrameNumber() {
        return cardFrameNumber;
    }

    public void setCardFrameNumber(String cardFrameNumber) {
        this.cardFrameNumber = cardFrameNumber;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCallbackName() {
        return callbackName;
    }

    public void setCallbackName(String callbackName) {
        this.callbackName = callbackName;
    }

    public Date getCallbackTime() {
        return callbackTime;
    }

    public void setCallbackTime(Date callbackTime) {
        this.callbackTime = callbackTime;
    }

    public String getCallbackWayName() {
        return callbackWayName;
    }

    public void setCallbackWayName(String callbackWayName) {
        this.callbackWayName = callbackWayName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDealWayName() {
        return dealWayName;
    }

    public void setDealWayName(String dealWayName) {
        this.dealWayName = dealWayName;
    }

    public BigDecimal getCarGuidancePrice() {
        return carGuidancePrice;
    }

    public void setCarGuidancePrice(BigDecimal carGuidancePrice) {
        this.carGuidancePrice = carGuidancePrice;
    }

    public Date getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(Date drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public Integer getKilometreNumber() {
        return kilometreNumber;
    }

    public void setKilometreNumber(Integer kilometreNumber) {
        this.kilometreNumber = kilometreNumber;
    }

    public BigDecimal getResidualPrincipal() {
        return residualPrincipal;
    }

    public void setResidualPrincipal(BigDecimal residualPrincipal) {
        this.residualPrincipal = residualPrincipal;
    }

    public BigDecimal getEvaluationPrice() {
        return evaluationPrice;
    }

    public void setEvaluationPrice(BigDecimal evaluationPrice) {
        this.evaluationPrice = evaluationPrice;
    }

    public Date getJqInsuranceExpiredate() {
        return jqInsuranceExpiredate;
    }

    public void setJqInsuranceExpiredate(Date jqInsuranceExpiredate) {
        this.jqInsuranceExpiredate = jqInsuranceExpiredate;
    }

    public Date getCommercialInsuranceExpiredate() {
        return commercialInsuranceExpiredate;
    }

    public void setCommercialInsuranceExpiredate(Date commercialInsuranceExpiredate) {
        this.commercialInsuranceExpiredate = commercialInsuranceExpiredate;
    }

    public Date getSecCommercialInsuranceExpire() {
        return secCommercialInsuranceExpire;
    }

    public void setSecCommercialInsuranceExpire(Date secCommercialInsuranceExpire) {
        this.secCommercialInsuranceExpire = secCommercialInsuranceExpire;
    }

    public BigDecimal getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public BigDecimal getLiquidatedDamages() {
        return liquidatedDamages;
    }

    public void setLiquidatedDamages(BigDecimal liquidatedDamages) {
        this.liquidatedDamages = liquidatedDamages;
    }

    public BigDecimal getCallbackExpenses() {
        return callbackExpenses;
    }

    public void setCallbackExpenses(BigDecimal callbackExpenses) {
        this.callbackExpenses = callbackExpenses;
    }

    public BigDecimal getMonthlyRentDeposit() {
        return monthlyRentDeposit;
    }

    public void setMonthlyRentDeposit(BigDecimal monthlyRentDeposit) {
        this.monthlyRentDeposit = monthlyRentDeposit;
    }

    public BigDecimal getCallbackCost() {
        return callbackCost;
    }

    public void setCallbackCost(BigDecimal callbackCost) {
        this.callbackCost = callbackCost;
    }

    public BigDecimal getViolationExpenses() {
        return violationExpenses;
    }

    public void setViolationExpenses(BigDecimal violationExpenses) {
        this.violationExpenses = violationExpenses;
    }

    public String getDealRemarks() {
        return dealRemarks;
    }

    public void setDealRemarks(String dealRemarks) {
        this.dealRemarks = dealRemarks;
    }

    @Override
    public String toString() {
        return "FindByPrimaryKeyVo{" +
                "accountName='" + accountName + '\'' +
                ", accountPhone='" + accountPhone + '\'' +
                ", completeContractNumber='" + completeContractNumber + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", cardFrameNumber='" + cardFrameNumber + '\'' +
                ", brandsName='" + brandsName + '\'' +
                ", seriesName='" + seriesName + '\'' +
                ", id=" + id +
                ", reason='" + reason + '\'' +
                ", approvalOpinion='" + approvalOpinion + '\'' +
                ", remarks='" + remarks + '\'' +
                ", callbackName='" + callbackName + '\'' +
                ", callbackTime=" + callbackTime +
                ", callbackWayName='" + callbackWayName + '\'' +
                ", updateTime=" + updateTime +
                ", dealWayName='" + dealWayName + '\'' +
                ", carGuidancePrice=" + carGuidancePrice +
                ", drivingLicense=" + drivingLicense +
                ", kilometreNumber=" + kilometreNumber +
                ", residualPrincipal=" + residualPrincipal +
                ", evaluationPrice=" + evaluationPrice +
                ", jqInsuranceExpiredate=" + jqInsuranceExpiredate +
                ", commercialInsuranceExpiredate=" + commercialInsuranceExpiredate +
                ", secCommercialInsuranceExpire=" + secCommercialInsuranceExpire +
                ", monthlyRent=" + monthlyRent +
                ", liquidatedDamages=" + liquidatedDamages +
                ", callbackExpenses=" + callbackExpenses +
                ", monthlyRentDeposit=" + monthlyRentDeposit +
                ", callbackCost=" + callbackCost +
                ", violationExpenses=" + violationExpenses +
                ", dealRemarks='" + dealRemarks + '\'' +
                '}';
    }
}
