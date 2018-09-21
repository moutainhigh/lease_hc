package com.hc.lease.postlending.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 还款历史/合同还款明细
 * Created by Administrator on 2017/8/31.
 */
public class ContractAllinpayLogVo implements Serializable {

    @ApiModelProperty(value = "创建日期/操作日期", hidden = false)
    private String createTime;

    @ApiModelProperty(value = "扣款日", hidden = false)
    private String repaymentDate;
    @ApiModelProperty(value = "期数", hidden = false)
    private String totalPeriod;
    @ApiModelProperty(value = "扣款用途", hidden = false)
    private String payTypeName;
    @ApiModelProperty(value = "扣款方式", hidden = false)
    private String payWayName;
    @ApiModelProperty(value = "逾期天数", hidden = false)
    private Integer overdueDay;
    @ApiModelProperty(value = "支付状态/扣款结果", hidden = false)
    private String paymentResultName;
    @ApiModelProperty(value = "状态结果描述", hidden = false)
    private String errMsg;
    @ApiModelProperty(value = "合计金额/应扣款", hidden = false)
    private BigDecimal totlePrice;
    @ApiModelProperty(value = "备注", hidden = false)
    private String remarks;
    @ApiModelProperty(value = "承租人", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "分公司", hidden = false)
    private String branchCompanyName;
    @ApiModelProperty(value = "卡号", hidden = false)
    private String backCardNumber;
    @ApiModelProperty(value = "银行", hidden = false)
    private String bankName;
    @ApiModelProperty(value = "操作人", hidden = false)
    private String userName;
    @ApiModelProperty(value = "完整合同编号", hidden = false)
    private String completeContractNumber;

    @ApiModelProperty(value = "逾期天数，扣款的时候改动的实际逾期天数", hidden = false)
    private Integer realOverdueDay;
    @ApiModelProperty(value = "逾期金额，扣款的时候改动的实际逾期金额", hidden = false)
    private BigDecimal realPrice;
    @ApiModelProperty(value = "通联交易编号/文件名", hidden = false)
    private String reqSn;

    @ApiModelProperty(value = "月租", hidden = false)
    private BigDecimal monthTotlePrice;
    @ApiModelProperty(value = "滞纳金", hidden = false)
    private BigDecimal overduePrice;
    @ApiModelProperty(value = "是否线下缴款", hidden = false)
    private String isPrivatelyName;
    @ApiModelProperty(value = "联系手机", hidden = false)
    private String phone;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public String getTotalPeriod() {
        return totalPeriod;
    }

    public void setTotalPeriod(String totalPeriod) {
        this.totalPeriod = totalPeriod;
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    public String getPayWayName() {
        return payWayName;
    }

    public void setPayWayName(String payWayName) {
        this.payWayName = payWayName;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    public String getPaymentResultName() {
        return paymentResultName;
    }

    public void setPaymentResultName(String paymentResultName) {
        this.paymentResultName = paymentResultName;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBranchCompanyName() {
        return branchCompanyName;
    }

    public void setBranchCompanyName(String branchCompanyName) {
        this.branchCompanyName = branchCompanyName;
    }

    public String getBackCardNumber() {
        return backCardNumber;
    }

    public void setBackCardNumber(String backCardNumber) {
        this.backCardNumber = backCardNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompleteContractNumber() {
        return completeContractNumber;
    }

    public void setCompleteContractNumber(String completeContractNumber) {
        this.completeContractNumber = completeContractNumber;
    }

    public Integer getRealOverdueDay() {
        return realOverdueDay;
    }

    public void setRealOverdueDay(Integer realOverdueDay) {
        this.realOverdueDay = realOverdueDay;
    }

    public BigDecimal getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
    }

    public String getReqSn() {
        return reqSn;
    }

    public void setReqSn(String reqSn) {
        this.reqSn = reqSn;
    }

    public BigDecimal getMonthTotlePrice() {
        return monthTotlePrice;
    }

    public void setMonthTotlePrice(BigDecimal monthTotlePrice) {
        this.monthTotlePrice = monthTotlePrice;
    }

    public BigDecimal getOverduePrice() {
        return overduePrice;
    }

    public void setOverduePrice(BigDecimal overduePrice) {
        this.overduePrice = overduePrice;
    }

    public String getIsPrivatelyName() {
        return isPrivatelyName;
    }

    public void setIsPrivatelyName(String isPrivatelyName) {
        this.isPrivatelyName = isPrivatelyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
