

package com.hc.lease.order.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 贷后合同管理 VO
 */
public class ContractManagerDealFindContractVo implements Serializable {
    @ApiModelProperty(value = "合同主键id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "承租人名称", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "车况 1新车 2次新车、二手车", hidden = false)
    private Integer carCondition;
    @ApiModelProperty(value = " 合同状态", hidden = false)
    private String dealStatusName;
    @ApiModelProperty(value = "承租人手机", hidden = false)
    private String accountPhone;
    @ApiModelProperty(value = "扣款日", hidden = false)
    private Date repaymentDate;
    @ApiModelProperty(value = "扣款日", hidden = false)
    private Integer payDate;
    @ApiModelProperty(value = "期数", hidden = false)
    private String totalPeriod;
    @ApiModelProperty(value = "月供", hidden = false)
    private BigDecimal monthlyRent;
    @ApiModelProperty(value = "代理商", hidden = false)
    private String agentsName;
    @ApiModelProperty(value = "身份证", hidden = false)
    private String idCard;
    @ApiModelProperty(value = "银行代码", hidden = false)
    private String bankCode;
    @ApiModelProperty(value = "承租人还款应付账号", hidden = false)
    private String backCardNumber;
    @ApiModelProperty(value = "车牌", hidden = false)
    private String plateNumber;
    @ApiModelProperty(value = "车辆主键id", hidden = false)
    private Long carId;
    @ApiModelProperty(value = "租赁起始日期", hidden = false)
    private Date leaseStartTime;
    @ApiModelProperty(value = "租赁结束日期", hidden = false)
    private Date leaseEndTime;
    @ApiModelProperty(value = "扣款起始日期", hidden = false)
    private Date payStartTime;
    @ApiModelProperty(value = "扣款结束日期", hidden = false)
    private Date payEndTime;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getCarCondition() {
        return carCondition;
    }

    public void setCarCondition(Integer carCondition) {
        this.carCondition = carCondition;
    }

    public String getDealStatusName() {
        return dealStatusName;
    }

    public void setDealStatusName(String dealStatusName) {
        this.dealStatusName = dealStatusName;
    }

    public String getAccountPhone() {
        return accountPhone;
    }

    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Integer getPayDate() {
        return payDate;
    }

    public void setPayDate(Integer payDate) {
        this.payDate = payDate;
    }

    public String getTotalPeriod() {
        return totalPeriod;
    }

    public void setTotalPeriod(String totalPeriod) {
        this.totalPeriod = totalPeriod;
    }

    public BigDecimal getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public String getAgentsName() {
        return agentsName;
    }

    public void setAgentsName(String agentsName) {
        this.agentsName = agentsName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBackCardNumber() {
        return backCardNumber;
    }

    public void setBackCardNumber(String backCardNumber) {
        this.backCardNumber = backCardNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
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

    public Date getPayStartTime() {
        return payStartTime;
    }

    public void setPayStartTime(Date payStartTime) {
        this.payStartTime = payStartTime;
    }

    public Date getPayEndTime() {
        return payEndTime;
    }

    public void setPayEndTime(Date payEndTime) {
        this.payEndTime = payEndTime;
    }

    @Override
    public String toString() {
        return "ContractManagerDealFindContractVo{" +
                "contractId=" + contractId +
                ", accountName='" + accountName + '\'' +
                ", carCondition=" + carCondition +
                ", dealStatusName='" + dealStatusName + '\'' +
                ", accountPhone='" + accountPhone + '\'' +
                ", repaymentDate=" + repaymentDate +
                ", payDate=" + payDate +
                ", totalPeriod='" + totalPeriod + '\'' +
                ", monthlyRent=" + monthlyRent +
                ", agentsName='" + agentsName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", backCardNumber='" + backCardNumber + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", carId=" + carId +
                ", leaseStartTime=" + leaseStartTime +
                ", leaseEndTime=" + leaseEndTime +
                ", payStartTime=" + payStartTime +
                ", payEndTime=" + payEndTime +
                '}';
    }
}
