package com.hc.lease.postlending.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FindNeedPayVo implements Serializable {
    private Long id;

    private Long statistId;

    private Long repaymentId;

    private Long repaymentStatusId;

    private Long contractId;

    private String branchCompany;

    private String bankAccountName;

    private String bankPhone;

    private String bankCode;

    private String backCardNumber;

    private String idCard;

    private BigDecimal totalPrice;

    private Integer overdueDay;

    private String plateNumber;

    private Date repaymentDate;

    private Integer paymentResult;

    private Integer isOperation;

    private String isOperationMsg;

    private Integer isExistContract;

    private Integer isSign;

    private Integer isExcessLimit;

    private Integer isPriceErr;

    private Integer isRepaymentDateErr;

    private Integer isBankPhoneErr;

    private String agrmNo;

    private Date createTime;

    private Long createBy;

    private String sn;

    private Long updateBy;

    private String paymentResultMsg;

    private String reqSn;

    private Date updateTime;

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

    public Integer getPaymentResult() {
        return paymentResult;
    }

    public void setPaymentResult(Integer paymentResult) {
        this.paymentResult = paymentResult;
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
        this.isOperationMsg = isOperationMsg;
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

    public String getAgrmNo() {
        return agrmNo;
    }

    public void setAgrmNo(String agrmNo) {
        this.agrmNo = agrmNo;
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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public String getPaymentResultMsg() {
        return paymentResultMsg;
    }

    public void setPaymentResultMsg(String paymentResultMsg) {
        this.paymentResultMsg = paymentResultMsg;
    }

    public String getReqSn() {
        return reqSn;
    }

    public void setReqSn(String reqSn) {
        this.reqSn = reqSn;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "FindNeedPayVo{" +
                "id=" + id +
                ", statistId=" + statistId +
                ", repaymentId=" + repaymentId +
                ", repaymentStatusId=" + repaymentStatusId +
                ", contractId=" + contractId +
                ", branchCompany='" + branchCompany + '\'' +
                ", bankAccountName='" + bankAccountName + '\'' +
                ", bankPhone='" + bankPhone + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", backCardNumber='" + backCardNumber + '\'' +
                ", idCard='" + idCard + '\'' +
                ", totalPrice=" + totalPrice +
                ", overdueDay=" + overdueDay +
                ", plateNumber='" + plateNumber + '\'' +
                ", repaymentDate=" + repaymentDate +
                ", paymentResult=" + paymentResult +
                ", isOperation=" + isOperation +
                ", isOperationMsg='" + isOperationMsg + '\'' +
                ", isExistContract=" + isExistContract +
                ", isSign=" + isSign +
                ", isExcessLimit=" + isExcessLimit +
                ", isPriceErr=" + isPriceErr +
                ", isRepaymentDateErr=" + isRepaymentDateErr +
                ", isBankPhoneErr=" + isBankPhoneErr +
                ", agrmNo='" + agrmNo + '\'' +
                ", createTime=" + createTime +
                ", createBy=" + createBy +
                ", sn='" + sn + '\'' +
                ", updateBy=" + updateBy +
                ", paymentResultMsg='" + paymentResultMsg + '\'' +
                ", reqSn='" + reqSn + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}