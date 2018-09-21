

package com.hc.lease.order.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 贷前直租合同-次新车处置 合同数据列表 续期、转租 VO
 */
public class ContractDQZZManagerFindContractVo implements Serializable {
    @ApiModelProperty(value = "承租人主键id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "承租人名称", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "新合同号", hidden = false)
    private String completeContractNumber;
    @ApiModelProperty(value = "新合同创建日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "合同号/旧合同号", hidden = false)
    private String oldCompleteContractNumber;
    @ApiModelProperty(value = " 合同状态", hidden = false)
    private String dealStatusName;
    @ApiModelProperty(value = "断供日期", hidden = false)
    private Date contractStopTime;
    @ApiModelProperty(value = "联系手机/承租人手机", hidden = false)
    private String accountPhone;
    @ApiModelProperty(value = "扣款日", hidden = false)
    private Date repaymentDate;
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
    @ApiModelProperty(value = "租赁起始日期", hidden = false)
    private Date leaseStartTime;
    @ApiModelProperty(value = "租赁结束日期", hidden = false)
    private Date leaseEndTime;
    @ApiModelProperty(value = "扣款起始日期", hidden = false)
    private Date payStartTime;
    @ApiModelProperty(value = "扣款结束日期", hidden = false)
    private Date payEndTime;
    @ApiModelProperty(value = "车况 1新车 2次新车、二手车", hidden = false)
    private Integer carCondition;
    @ApiModelProperty(value = "备注", hidden = false)
    private String remarks;
    @ApiModelProperty(value = "是否可以续租 0否 1是", hidden = false)
    private Integer isContinue;
    @ApiModelProperty(value = "是否可以转租 0否 1是", hidden = false)
    private Integer isTransfer;
    @ApiModelProperty(value = "扣款日", hidden = false)
    private Integer payDate;

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

    public String getCompleteContractNumber() {
        return completeContractNumber;
    }

    public void setCompleteContractNumber(String completeContractNumber) {
        this.completeContractNumber = completeContractNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOldCompleteContractNumber() {
        return oldCompleteContractNumber;
    }

    public void setOldCompleteContractNumber(String oldCompleteContractNumber) {
        this.oldCompleteContractNumber = oldCompleteContractNumber;
    }

    public String getDealStatusName() {
        return dealStatusName;
    }

    public void setDealStatusName(String dealStatusName) {
        this.dealStatusName = dealStatusName;
    }

    public Date getContractStopTime() {
        return contractStopTime;
    }

    public void setContractStopTime(Date contractStopTime) {
        this.contractStopTime = contractStopTime;
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

    public Integer getCarCondition() {
        return carCondition;
    }

    public void setCarCondition(Integer carCondition) {
        this.carCondition = carCondition;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public Integer getPayDate() {
        return payDate;
    }

    public void setPayDate(Integer payDate) {
        this.payDate = payDate;
    }

    @Override
    public String toString() {
        return "ContractDQZZManagerFindContractVo{" +
                "contractId=" + contractId +
                ", accountName='" + accountName + '\'' +
                ", completeContractNumber='" + completeContractNumber + '\'' +
                ", createTime=" + createTime +
                ", oldCompleteContractNumber='" + oldCompleteContractNumber + '\'' +
                ", dealStatusName='" + dealStatusName + '\'' +
                ", contractStopTime=" + contractStopTime +
                ", accountPhone='" + accountPhone + '\'' +
                ", repaymentDate=" + repaymentDate +
                ", totalPeriod='" + totalPeriod + '\'' +
                ", monthlyRent=" + monthlyRent +
                ", agentsName='" + agentsName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", backCardNumber='" + backCardNumber + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", leaseStartTime=" + leaseStartTime +
                ", leaseEndTime=" + leaseEndTime +
                ", payStartTime=" + payStartTime +
                ", payEndTime=" + payEndTime +
                ", carCondition=" + carCondition +
                ", remarks='" + remarks + '\'' +
                ", isContinue=" + isContinue +
                ", isTransfer=" + isTransfer +
                ", payDate=" + payDate +
                '}';
    }
}
