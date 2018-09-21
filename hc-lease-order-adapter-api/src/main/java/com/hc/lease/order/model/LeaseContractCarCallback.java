package com.hc.lease.order.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 贷后车辆管理-收车
 */
public class LeaseContractCarCallback implements Serializable {
    @ApiModelProperty(value = "主键id (跟进/处置/传值)", hidden = false)
    private Long id;
    @ApiModelProperty(value = "处理编号", hidden = false)
    private Integer dualNumber;
    @ApiModelProperty(value = "融租合同主键id (跟进/处置、新增传值)", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "车辆主键id (跟进/处置、新增传值)", hidden = false)
    private Long carId;
    @ApiModelProperty(value = "收车原因 (新增传值)", hidden = false)
    private String reason;
    @ApiModelProperty(value = "资产部收车审批意见 (新增传值)", hidden = false)
    private String approvalOpinion;
    @ApiModelProperty(value = "备注 (新增传值)", hidden = false)
    private String remarks;
    @ApiModelProperty(value = "收车人 (跟进/处置/传值)", hidden = false)
    private String callbackName;
    @ApiModelProperty(value = "收车时间 (跟进/处置/传值)", hidden = false)
    private Date callbackTime;
    @ApiModelProperty(value = "收车方式 1客户交回 2赎车收回 3委托收回 4自主收回", hidden = false)
    private Integer callbackWay;
    @ApiModelProperty(value = "处置方式 1已回收待处置 2退回 3待改期数 4断供（待转租/待转卖） 5取消回收", hidden = false)
    private Integer dealWay;
    @ApiModelProperty(value = "车辆指导价 (跟进/处置/传值)", hidden = false)
    private BigDecimal carGuidancePrice;
    @ApiModelProperty(value = "行驶证注册日期 (跟进/处置/传值)", hidden = false)
    private Date drivingLicense;
    @ApiModelProperty(value = "公里数 (跟进/处置/传值)", hidden = false)
    private Integer kilometreNumber;
    @ApiModelProperty(value = "贷款剩余本金 (跟进/处置/传值)", hidden = false)
    private BigDecimal residualPrincipal;
    @ApiModelProperty(value = "评估价 (跟进/处置/传值)", hidden = false)
    private BigDecimal evaluationPrice;
    @ApiModelProperty(value = "交强险到期日期 (跟进/处置/传值)", hidden = false)
    private Date jqInsuranceExpiredate;
    @ApiModelProperty(value = "商业险#1到期日期 (跟进/处置/传值)", hidden = false)
    private Date commercialInsuranceExpiredate;
    @ApiModelProperty(value = "商业险#2到期日期 (跟进/处置/传值)", hidden = false)
    private Date secCommercialInsuranceExpire;
    @ApiModelProperty(value = "月租 (跟进/处置/传值)", hidden = false)
    private BigDecimal monthlyRent;
    @ApiModelProperty(value = "违约金 (跟进/处置/传值)", hidden = false)
    private BigDecimal liquidatedDamages;
    @ApiModelProperty(value = "收车费 (跟进/处置/传值)", hidden = false)
    private BigDecimal callbackExpenses;
    @ApiModelProperty(value = "月租押金 (跟进/处置/传值)", hidden = false)
    private BigDecimal monthlyRentDeposit;
    @ApiModelProperty(value = "收车成本 (跟进/处置/传值)", hidden = false)
    private BigDecimal callbackCost;
    @ApiModelProperty(value = "违章处理 (跟进/处置/传值)", hidden = false)
    private BigDecimal violationExpenses;
    @ApiModelProperty(value = "处置备注 (跟进/处置/传值)", hidden = false)
    private String dealRemarks;
    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDualNumber() {
        return dualNumber;
    }

    public void setDualNumber(Integer dualNumber) {
        this.dualNumber = dualNumber;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion == null ? null : approvalOpinion.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getCallbackName() {
        return callbackName;
    }

    public void setCallbackName(String callbackName) {
        this.callbackName = callbackName == null ? null : callbackName.trim();
    }

    public Date getCallbackTime() {
        return callbackTime;
    }

    public void setCallbackTime(Date callbackTime) {
        this.callbackTime = callbackTime;
    }

    public Integer getCallbackWay() {
        return callbackWay == null ? 0 : callbackWay;
    }

    public void setCallbackWay(Integer callbackWay) {
        this.callbackWay = callbackWay;
    }

    public Integer getDealWay() {
        return dealWay == null ? 0 : dealWay;
    }

    public void setDealWay(Integer dealWay) {
        this.dealWay = dealWay;
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
        this.dealRemarks = dealRemarks == null ? null : dealRemarks.trim();
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

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "LeaseContractCarCallback{" +
                "id=" + id +
                ", dualNumber='" + dualNumber + '\'' +
                ", contractId=" + contractId +
                ", carId=" + carId +
                ", reason='" + reason + '\'' +
                ", approvalOpinion='" + approvalOpinion + '\'' +
                ", remarks='" + remarks + '\'' +
                ", callbackName='" + callbackName + '\'' +
                ", callbackTime=" + callbackTime +
                ", callbackWay=" + callbackWay +
                ", dealWay=" + dealWay +
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
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", ids=" + ids +
                '}';
    }
}