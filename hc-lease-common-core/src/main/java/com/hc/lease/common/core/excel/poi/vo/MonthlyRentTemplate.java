package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.poi.annotation.CostCheckExcelCol;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 创建人：强<br/>
 * 创建时间：2017/12/26<br/>
 * 说明：
 */
@Data
@CostCheckExcelCol("融租合同核对")
public class MonthlyRentTemplate implements Serializable {


    @CostCheckExcelCol("合同编号")
    private String contractNumber;
    @CostCheckExcelCol("承租人")
    private String account;
    @CostCheckExcelCol("手机")
    private String phone;
    @CostCheckExcelCol("扣款日")
    private Integer payDate;
    @CostCheckExcelCol("期数")
    private Integer period;
    @CostCheckExcelCol("月租/挂靠")
    private BigDecimal monthlyRent;
    @CostCheckExcelCol("代理商")
    private String agentsName;
    @CostCheckExcelCol("身份证号码")
    private String idCard;
    @CostCheckExcelCol("银行代码")
    private String bankCode;
    @CostCheckExcelCol("承租人还款银行账号")
    private String accountBank;
    @CostCheckExcelCol("车牌")
    private String plateNumber;
    @CostCheckExcelCol("租赁起始日期")
    private Date leaseStartTime;
    @CostCheckExcelCol("租赁结束日期")
    private Date leaseEndTime;
    @CostCheckExcelCol("租赁结束日期")
    private String businessLicenseNumber;

    @CostCheckExcelCol("导入结果(非填项)")
    private String updateState;

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPayDate() {
        return payDate;
    }

    public void setPayDate(Integer payDate) {
        this.payDate = payDate;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public BigDecimal getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
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

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
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

    @Override
    public String toString() {
        return "MonthlyRentTemplate{" +
                "contractNumber='" + contractNumber + '\'' +
                ", account='" + account + '\'' +
                ", phone='" + phone + '\'' +
                ", payDate=" + payDate +
                ", period=" + period +
                ", monthlyRent=" + monthlyRent +
                ", idCard='" + idCard + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", accountBank='" + accountBank + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", leaseStartTime=" + leaseStartTime +
                ", leaseEndTime=" + leaseEndTime +
                '}';
    }

    public String getUpdateState() {
        return updateState;
    }

    public void setUpdateState(String updateState) {
        this.updateState = updateState;
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
