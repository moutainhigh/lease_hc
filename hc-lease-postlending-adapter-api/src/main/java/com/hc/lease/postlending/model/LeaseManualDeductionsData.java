package com.hc.lease.postlending.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeaseManualDeductionsData implements Serializable {
    private Long id;

    private Long statistId;

    private Long repaymentId;

    private Long repaymentStatusId;

    private Long contractId;

    private String branchCompany;

    private String bankAccountName;

    private String bankPhone;

    private String reallyBankPhone;

    private String bankCode;

    private String backCardNumber;

    private String agrmNo;

    private String idCard;

    private BigDecimal totalPrice;

    private Integer overdueDay;

    private String plateNumber;

    private Date repaymentDate;

    private Date reallyRepaymentDate;

    private Integer paymentResult;

    private String paymentResultMsg;

    private String reqSn;

    private String sn;

    private Integer payWay;

    private Integer isOperation;

    private String isOperationMsg;

    private Integer isExistContract;

    private Integer isSign;

    private Integer isExcessLimit;

    private Integer isPriceErr;

    private Integer isRepaymentDateErr;

    private Integer isBankPhoneErr;

    private Date createTime;

    private Long createBy;

    private Date updateTime;

    private Long updateBy;

    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStatistId() {
        return statistId;
    }

    public void setStatistId(Long statistId) {
        this.statistId = statistId;
    }

    public Long getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Long repaymentId) {
        this.repaymentId = repaymentId;
    }

    public Long getRepaymentStatusId() {
        return repaymentStatusId;
    }

    public void setRepaymentStatusId(Long repaymentStatusId) {
        this.repaymentStatusId = repaymentStatusId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getBranchCompany() {
        return branchCompany;
    }

    public void setBranchCompany(String branchCompany) {
        this.branchCompany = branchCompany == null ? null : branchCompany.trim();
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName == null ? null : bankAccountName.trim();
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone == null ? null : bankPhone.trim();
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
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getBackCardNumber() {
        return backCardNumber;
    }

    public void setBackCardNumber(String backCardNumber) {
        this.backCardNumber = backCardNumber == null ? null : backCardNumber.trim();
    }

    public String getAgrmNo() {
        return agrmNo;
    }

    public void setAgrmNo(String agrmNo) {
        this.agrmNo = agrmNo;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
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
        this.plateNumber = plateNumber == null ? null : plateNumber.trim();
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

    public Integer getPaymentResult() {
        return paymentResult;
    }

    public void setPaymentResult(Integer paymentResult) {
        this.paymentResult = paymentResult;
    }

    public String getPaymentResultMsg() {
        return paymentResultMsg;
    }

    public void setPaymentResultMsg(String paymentResultMsg) {
        this.paymentResultMsg = paymentResultMsg == null ? null : paymentResultMsg.trim();
    }

    public String getReqSn() {
        return reqSn;
    }

    public void setReqSn(String reqSn) {
        this.reqSn = reqSn == null ? null : reqSn.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public Integer getIsOperation() {
        return isOperation;
    }

    public void setIsOperation(Integer isOperation) {
        this.isOperation = isOperation;
    }

    public String getIsOperationMsg() {
        return isOperationMsg;
    }

    public void setIsOperationMsg(String isOperationMsg) {
        this.isOperationMsg = isOperationMsg == null ? null : isOperationMsg.trim();
    }

    public Integer getIsExistContract() {
        return isExistContract;
    }

    public void setIsExistContract(Integer isExistContract) {
        this.isExistContract = isExistContract;
    }

    public Integer getIsSign() {
        return isSign;
    }

    public void setIsSign(Integer isSign) {
        this.isSign = isSign;
    }

    public Integer getIsExcessLimit() {
        return isExcessLimit;
    }

    public void setIsExcessLimit(Integer isExcessLimit) {
        this.isExcessLimit = isExcessLimit;
    }

    public Integer getIsPriceErr() {
        return isPriceErr;
    }

    public void setIsPriceErr(Integer isPriceErr) {
        this.isPriceErr = isPriceErr;
    }

    public Integer getIsRepaymentDateErr() {
        return isRepaymentDateErr;
    }

    public void setIsRepaymentDateErr(Integer isRepaymentDateErr) {
        this.isRepaymentDateErr = isRepaymentDateErr;
    }

    public Integer getIsBankPhoneErr() {
        return isBankPhoneErr;
    }

    public void setIsBankPhoneErr(Integer isBankPhoneErr) {
        this.isBankPhoneErr = isBankPhoneErr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

}