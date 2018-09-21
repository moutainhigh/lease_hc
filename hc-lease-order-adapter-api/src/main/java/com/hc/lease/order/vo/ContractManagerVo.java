package com.hc.lease.order.vo;

import com.hc.lease.order.model.LeaseSchemeOrderAccount;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 提交 改期数、转租 VO
 * Created by tong on 2018/8/14
 */
public class ContractManagerVo implements Serializable {

    @ApiModelProperty(value = "车辆主键id", hidden = false)
    private Long carId;
    @ApiModelProperty(value = "合同主键id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "合同编号", hidden = false)
    private String completeContractNumber;
    @ApiModelProperty(value = "综合报价/客户综合报价", hidden = false)
    private BigDecimal comprehensiveQuote;
    @ApiModelProperty(value = "首期金额", hidden = false)
    private BigDecimal downPayment;
    @ApiModelProperty(value = "尾款/尾付", hidden = false)
    private BigDecimal balancePayment;
    @ApiModelProperty(value = "新旧合同差价", hidden = false)
    private BigDecimal priceDifference;
    @ApiModelProperty(value = "执行利率", hidden = false)
    private BigDecimal annualInterest;
    @ApiModelProperty(value = "分期数 主键id", hidden = false)
    private Long stagingNumberId;
    @ApiModelProperty(value = "月租", hidden = false)
    private BigDecimal monthlyRent;
    @ApiModelProperty(value = "合同起始日期", hidden = false)
    private Date leaseStartTime;
    @ApiModelProperty(value = "合同结束日期", hidden = false)
    private Date leaseEndTime;
    @ApiModelProperty(value = "扣款起始日期", hidden = false)
    private Date repaymentStartDate;
    @ApiModelProperty(value = "扣款结束日期", hidden = false)
    private Date repaymentEndDate;
    @ApiModelProperty(value = "备注", hidden = false)
    private String remarks;
    @ApiModelProperty(value = "租金总额", hidden = false)
    private BigDecimal leasePrice;
    @ApiModelProperty(value = "合同来源类型 0 原始合同 1 改期数 2 续期 3 转租", hidden = false)
    private Integer sourceType;

    //转租
    @ApiModelProperty(value = "分期数", hidden = false)
    private Integer period;
    @ApiModelProperty(value = "合同编号-年", hidden = false)
    private String contractNumberYear;
    @ApiModelProperty(value = "合同编号-号", hidden = false)
    private String contractNumber;
    @ApiModelProperty(value = "承租人实体类List", hidden = false)
    private List<LeaseSchemeOrderAccount> leaseSchemeOrderAccounts;
    @ApiModelProperty(value = "是否可以续租 0否 1是", hidden = false)
    private Integer isContinue;
    @ApiModelProperty(value = "是否可以转租 0否 1是", hidden = false)
    private Integer isTransfer;
    //转租

    @ApiModelProperty(value = "方案期数类型 1为系统 2为定制", hidden = false)
    private Integer stagingNumberType;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getContractNumberYear() {
        return contractNumberYear;
    }

    public void setContractNumberYear(String contractNumberYear) {
        this.contractNumberYear = contractNumberYear;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getCompleteContractNumber() {
        return completeContractNumber;
    }

    public void setCompleteContractNumber(String completeContractNumber) {
        this.completeContractNumber = completeContractNumber;
    }

    public BigDecimal getComprehensiveQuote() {
        return comprehensiveQuote;
    }

    public void setComprehensiveQuote(BigDecimal comprehensiveQuote) {
        this.comprehensiveQuote = comprehensiveQuote;
    }

    public BigDecimal getDownPayment() {
        return downPayment == null ? new BigDecimal(0) : downPayment;
    }

    public void setDownPayment(BigDecimal downPayment) {
        this.downPayment = downPayment;
    }

    public BigDecimal getBalancePayment() {
        return balancePayment == null ? new BigDecimal(0) : balancePayment;
    }

    public void setBalancePayment(BigDecimal balancePayment) {
        this.balancePayment = balancePayment;
    }

    public BigDecimal getPriceDifference() {
        return priceDifference;
    }

    public void setPriceDifference(BigDecimal priceDifference) {
        this.priceDifference = priceDifference;
    }

    public BigDecimal getAnnualInterest() {
        return annualInterest == null ? new BigDecimal(0) : annualInterest;
    }

    public void setAnnualInterest(BigDecimal annualInterest) {
        this.annualInterest = annualInterest;
    }

    public Long getStagingNumberId() {
        return stagingNumberId;
    }

    public void setStagingNumberId(Long stagingNumberId) {
        this.stagingNumberId = stagingNumberId;
    }

    public BigDecimal getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public Date getLeaseStartTime() {
        return leaseStartTime;
    }

    public void setLeaseStartTime(Date leaseStartTime) {
        this.leaseStartTime = leaseStartTime;
    }

    public Date getLeaseEndTime() {
        return leaseEndTime;
    }

    public void setLeaseEndTime(Date leaseEndTime) {
        this.leaseEndTime = leaseEndTime;
    }

    public Date getRepaymentStartDate() {
        return repaymentStartDate;
    }

    public void setRepaymentStartDate(Date repaymentStartDate) {
        this.repaymentStartDate = repaymentStartDate;
    }

    public Date getRepaymentEndDate() {
        return repaymentEndDate;
    }

    public void setRepaymentEndDate(Date repaymentEndDate) {
        this.repaymentEndDate = repaymentEndDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigDecimal getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(BigDecimal leasePrice) {
        this.leasePrice = leasePrice;
    }

    public List<LeaseSchemeOrderAccount> getLeaseSchemeOrderAccounts() {
        return leaseSchemeOrderAccounts;
    }

    public void setLeaseSchemeOrderAccounts(List<LeaseSchemeOrderAccount> leaseSchemeOrderAccounts) {
        this.leaseSchemeOrderAccounts = leaseSchemeOrderAccounts;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getIsContinue() {
        return isContinue;
    }

    public void setIsContinue(Integer isContinue) {
        this.isContinue = isContinue;
    }

    public Integer getIsTransfer() {
        return isTransfer;
    }

    public void setIsTransfer(Integer isTransfer) {
        this.isTransfer = isTransfer;
    }

    public Integer getStagingNumberType() {
        return stagingNumberType;
    }

    public void setStagingNumberType(Integer stagingNumberType) {
        this.stagingNumberType = stagingNumberType;
    }

    @Override
    public String toString() {
        return "ContractManagerVo{" +
                "carId=" + carId +
                ", contractId=" + contractId +
                ", completeContractNumber='" + completeContractNumber + '\'' +
                ", comprehensiveQuote=" + comprehensiveQuote +
                ", downPayment=" + downPayment +
                ", balancePayment=" + balancePayment +
                ", priceDifference=" + priceDifference +
                ", annualInterest=" + annualInterest +
                ", stagingNumberId=" + stagingNumberId +
                ", monthlyRent=" + monthlyRent +
                ", leaseStartTime=" + leaseStartTime +
                ", leaseEndTime=" + leaseEndTime +
                ", repaymentStartDate=" + repaymentStartDate +
                ", repaymentEndDate=" + repaymentEndDate +
                ", remarks='" + remarks + '\'' +
                ", leasePrice=" + leasePrice +
                ", sourceType=" + sourceType +
                ", period=" + period +
                ", contractNumberYear='" + contractNumberYear + '\'' +
                ", contractNumber='" + contractNumber + '\'' +
                ", leaseSchemeOrderAccounts=" + leaseSchemeOrderAccounts +
                ", isContinue=" + isContinue +
                ", isTransfer=" + isTransfer +
                ", stagingNumberType=" + stagingNumberType +
                '}';
    }
}
