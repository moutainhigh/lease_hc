

package com.hc.lease.order.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 合同所有数据 VO
 */
public class FindAllContractVo implements Serializable{
    @ApiModelProperty(value = "承租人名称", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "承租人手机", hidden = false)
    private String accountPhone;
    @ApiModelProperty(value = "扣款日", hidden = false)
    private Integer payDate;
    @ApiModelProperty(value = "月供", hidden = false)
    private BigDecimal monthlyRent;
    @ApiModelProperty(value = "期数", hidden = false)
    private Integer period;
    @ApiModelProperty(value = "身份证号码", hidden = false)
    private String idCard;
    @ApiModelProperty(value = "银行代码", hidden = false)
    private String bankCode;
    @ApiModelProperty(value = "承租人还款银行账号", hidden = false)
    private String backCardNumber;
    @ApiModelProperty(value = "车牌号码", hidden = false)
    private String plateNumber;
    @ApiModelProperty(value = "合同开始日期", hidden = false)
    private String leaseStartTime;
    @ApiModelProperty(value = "合同结束日期", hidden = false)
    private String leaseEndTime;
    @ApiModelProperty(value = "合同编号", hidden = false)
    private String completeContractNumber;
    @ApiModelProperty(value = "分公司名称", hidden = false)
    private String branchCompanyName;
    @ApiModelProperty(value = "营业执照号/统一社会信用代码", hidden = false)
    private String businessLicenseNumber;
    @ApiModelProperty(value = "代理商名称", hidden = false)
    private String agentsName;

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

    public Integer getPayDate() {
        return payDate;
    }

    public void setPayDate(Integer payDate) {
        this.payDate = payDate;
    }

    public BigDecimal getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
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

    public String getLeaseStartTime() {
        return leaseStartTime;
    }

    public void setLeaseStartTime(String leaseStartTime) {
        this.leaseStartTime = leaseStartTime;
    }

    public String getLeaseEndTime() {
        return leaseEndTime;
    }

    public void setLeaseEndTime(String leaseEndTime) {
        this.leaseEndTime = leaseEndTime;
    }

    public String getCompleteContractNumber() {
        return completeContractNumber;
    }

    public void setCompleteContractNumber(String completeContractNumber) {
        this.completeContractNumber = completeContractNumber;
    }

    public String getBranchCompanyName() {
        return branchCompanyName;
    }

    public void setBranchCompanyName(String branchCompanyName) {
        this.branchCompanyName = branchCompanyName;
    }

    public String getBusinessLicenseNumber() {
        return businessLicenseNumber;
    }

    public void setBusinessLicenseNumber(String businessLicenseNumber) {
        this.businessLicenseNumber = businessLicenseNumber;
    }

    public String getAgentsName() {
        return agentsName;
    }

    public void setAgentsName(String agentsName) {
        this.agentsName = agentsName;
    }
}
