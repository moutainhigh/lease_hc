package com.hc.lease.postlending.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 批量协议支付
 * 通联支付拆单
 * Created by Administrator on 2018/6/21
 */
public class BatchPostlendingPaymentSplitVo implements Serializable {
    @ApiModelProperty(value = "通联支付超额拆分交易明细主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "融租合同主键id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "月租还款计划明细主键id", hidden = false)
    private Long repaymentId;
    @ApiModelProperty(value = "承租人主键id", hidden = false)
    private Long accountId;
    @ApiModelProperty(value = "记录通联支付超额的还款计划明细主键id", hidden = false)
    private Long splitConnectId;
    @ApiModelProperty(value = "支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他;6:批量补录;7:线下缴款登记;8:未开始还款;9:通联协议支付", hidden = false)
    private Integer payWay;
    @ApiModelProperty(value = "合计", hidden = false)
    private BigDecimal totlePrice;
    @ApiModelProperty(value = "承租人身份证号", hidden = false)
    private String idCard;
    @ApiModelProperty(value = "银行名称", hidden = false)
    private String bankName;
    @ApiModelProperty(value = "银行编号", hidden = false)
    private String bankCode;
    @ApiModelProperty(value = "协议号", hidden = false)
    private String agrmNo;
    @ApiModelProperty(value = "银行卡号", hidden = false)
    private String backCardNumber;
    @ApiModelProperty(value = "银行预留手机号", hidden = false)
    private String bankPhone;
    @ApiModelProperty(value = "承租人姓名", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "银行户名", hidden = false)
    private String bankAccountName;
    @ApiModelProperty(value = "协议签约 0:否1:是", hidden = false)
    private Integer isSign;
    @ApiModelProperty(value = "完整合同编号", hidden = false)
    private String completeContractNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Long repaymentId) {
        this.repaymentId = repaymentId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getSplitConnectId() {
        return splitConnectId;
    }

    public void setSplitConnectId(Long splitConnectId) {
        this.splitConnectId = splitConnectId;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getAgrmNo() {
        return agrmNo;
    }

    public void setAgrmNo(String agrmNo) {
        this.agrmNo = agrmNo;
    }

    public String getBackCardNumber() {
        return backCardNumber;
    }

    public void setBackCardNumber(String backCardNumber) {
        this.backCardNumber = backCardNumber;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public Integer getIsSign() {
        return isSign;
    }

    public void setIsSign(Integer isSign) {
        this.isSign = isSign;
    }

    public String getCompleteContractNumber() {
        return completeContractNumber;
    }

    public void setCompleteContractNumber(String completeContractNumber) {
        this.completeContractNumber = completeContractNumber;
    }

}
