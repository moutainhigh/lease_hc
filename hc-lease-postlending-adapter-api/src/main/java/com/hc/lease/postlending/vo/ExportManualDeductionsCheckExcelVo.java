package com.hc.lease.postlending.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ExportManualDeductionsCheckExcelVo implements Serializable {
    private String branchCompany;
    private String bankAccountName;
    private String bankPhone;
    private String reallyBankPhone;
    private String bankCode;
    private String backCardNumber;
    private String idCard;
    private BigDecimal totalPrice;
    private Integer overdueDay;
    private String plateNumber;
    private Date repaymentDate;
    private Date reallyRepaymentDate;
    private String paymentResultName;
    private String paymentResultMsg;
    private String isOperationName;
    private String isOperationMsg;
    private String isExistContractName;
    private String isSignName;
    private String isExcessLimitName;
    private String isPriceErrName;
    private String isRepaymentDateErrName;
    private String isBankPhoneErrName;

    public String getBranchCompany() {
        return branchCompany;
    }

    public void setBranchCompany(String branchCompany) {
        this.branchCompany = branchCompany;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone;
    }

    public String getReallyBankPhone() {
        return reallyBankPhone;
    }

    public void setReallyBankPhone(String reallyBankPhone) {
        this.reallyBankPhone = reallyBankPhone;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Date getReallyRepaymentDate() {
        return reallyRepaymentDate;
    }

    public void setReallyRepaymentDate(Date reallyRepaymentDate) {
        this.reallyRepaymentDate = reallyRepaymentDate;
    }

    public String getPaymentResultName() {
        return paymentResultName;
    }

    public void setPaymentResultName(String paymentResultName) {
        this.paymentResultName = paymentResultName;
    }

    public String getPaymentResultMsg() {
        return paymentResultMsg;
    }

    public void setPaymentResultMsg(String paymentResultMsg) {
        this.paymentResultMsg = paymentResultMsg;
    }

    public String getIsOperationName() {
        return isOperationName;
    }

    public void setIsOperationName(String isOperationName) {
        this.isOperationName = isOperationName;
    }

    public String getIsOperationMsg() {
        return isOperationMsg;
    }

    public void setIsOperationMsg(String isOperationMsg) {
        this.isOperationMsg = isOperationMsg;
    }

    public String getIsExistContractName() {
        return isExistContractName;
    }

    public void setIsExistContractName(String isExistContractName) {
        this.isExistContractName = isExistContractName;
    }

    public String getIsSignName() {
        return isSignName;
    }

    public void setIsSignName(String isSignName) {
        this.isSignName = isSignName;
    }

    public String getIsExcessLimitName() {
        return isExcessLimitName;
    }

    public void setIsExcessLimitName(String isExcessLimitName) {
        this.isExcessLimitName = isExcessLimitName;
    }

    public String getIsPriceErrName() {
        return isPriceErrName;
    }

    public void setIsPriceErrName(String isPriceErrName) {
        this.isPriceErrName = isPriceErrName;
    }

    public String getIsRepaymentDateErrName() {
        return isRepaymentDateErrName;
    }

    public void setIsRepaymentDateErrName(String isRepaymentDateErrName) {
        this.isRepaymentDateErrName = isRepaymentDateErrName;
    }

    public String getIsBankPhoneErrName() {
        return isBankPhoneErrName;
    }

    public void setIsBankPhoneErrName(String isBankPhoneErrName) {
        this.isBankPhoneErrName = isBankPhoneErrName;
    }

}