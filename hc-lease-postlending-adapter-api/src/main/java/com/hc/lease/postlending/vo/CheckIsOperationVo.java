package com.hc.lease.postlending.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 手动扣款检测能否操作VO
 */
public class CheckIsOperationVo implements Serializable {

    Integer isExistContract;
    Integer isSign;
    Integer isExcessLimit;
    Integer isBankPhoneErr;
    Integer isPriceErr;
    Integer isRepaymentDateErr;
    Long repaymentId;
    Long contractId;
    Integer isOperation;
    String isOperationMsg;

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

    public Integer getIsBankPhoneErr() {
        return isBankPhoneErr;
    }

    public void setIsBankPhoneErr(Integer isBankPhoneErr) {
        this.isBankPhoneErr = isBankPhoneErr;
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

    public Long getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Long repaymentId) {
        this.repaymentId = repaymentId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
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

    @Override
    public String toString() {
        return "CheckIsOperationVo{" +
                "isExistContract=" + isExistContract +
                ", isSign=" + isSign +
                ", isExcessLimit=" + isExcessLimit +
                ", isBankPhoneErr=" + isBankPhoneErr +
                ", isPriceErr=" + isPriceErr +
                ", isRepaymentDateErr=" + isRepaymentDateErr +
                ", repaymentId=" + repaymentId +
                ", contractId=" + contractId +
                ", isOperation=" + isOperation +
                ", isOperationMsg='" + isOperationMsg + '\'' +
                '}';
    }
}