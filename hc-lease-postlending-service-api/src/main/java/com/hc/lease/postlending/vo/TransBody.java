package com.hc.lease.postlending.vo;

import com.aipg.payreq.Trans_Detail;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 接收 支付参数封装
 * Created by tong on 2017/6/10.
 */
public class TransBody implements Serializable {

    @ApiModelProperty(value = "用户主键id", hidden = false, required = true)
    private Long accountId;

    @ApiModelProperty(value = "银行卡或存折上的所有人姓名", hidden = false, required = true)
    private String bankAccountName;

    @ApiModelProperty(value = "银行卡或存折号码", hidden = false, required = true)
    private String bankAccountNo;

    @ApiModelProperty(value = "用户手机号", hidden = false, required = true)
    private String phone;

    @ApiModelProperty(value = "银行代码，存折必须填写", hidden = false, required = true)
    private String bankCode;

    @ApiModelProperty(value = "银行名称", hidden = false, required = true)
    private String bankName;

    @ApiModelProperty(value = "是否逾期", hidden = false, required = true)
    private Boolean overdue;

    @ApiModelProperty(value = "逾期天数 (需提供：单笔月供+滞纳金)", hidden = false, required = true)
    private Integer overdueDay;

    @ApiModelProperty(value = "逾期金额 (需提供：单笔月供+滞纳金)", hidden = false, required = true)
    private BigDecimal overduePrice;

    @ApiModelProperty(value = "月供金额", hidden = false, required = true)
    private BigDecimal monthlyPaymentPrice;

    @ApiModelProperty(value = "合计金额", hidden = false, required = true)
    private BigDecimal totlePrice;

    @ApiModelProperty(value = "总笔数", hidden = false, required = true)
    private Integer totalItem;

    @ApiModelProperty(value = "支付方式", hidden = false, required = true)
    private Integer payWay;

    @ApiModelProperty(value = "支付款项类型", hidden = false, required = true)
    private Integer payType;

    @ApiModelProperty(value = "月供月份/融租合同-还款主键id (需提供：单笔月供，单笔月供+滞纳金)", hidden = false, required = true)
    private Long repaymentId;

    @ApiModelProperty(value = "融租合同主键id (需提供：单笔月供，单笔月供+滞纳金)", hidden = false, required = true)
    private Long contractId;

    @ApiModelProperty(value = "备注 (需提供：单笔月供，单笔月供+滞纳金)", hidden = false, required = true)
    private String remarks;

    @ApiModelProperty(value = "商户自定义的用户号，可当作备注字段使用", hidden = false, required = true)
    private String custUserid;

    @ApiModelProperty(value = "交易代码", hidden = false, required = true)
    private String trxCode;

    @ApiModelProperty(value = "交易代码", hidden = false, required = true)
    private String busiCode;

    @ApiModelProperty(value = "交易流水号 (需提供：交易查询/轮询,)", hidden = false, required = true)
    private String reqSn;

    @ApiModelProperty(value = "记录序号 通联批量代收 每条数据的 序号", hidden = false, required = true)
    private String sn;

    @ApiModelProperty(value = "开始时间 YYYYMMDDHHmmss (需提供：交易查询/轮询,)", hidden = false, required = true)
    private String startDate;

    @ApiModelProperty(value = "结束时间 YYYYMMDDHHmmss (需提供：交易查询/轮询,)", hidden = false, required = true)
    private String endDate;

    @ApiModelProperty(value = "单笔或批量/0:单笔; 1:批量", hidden = false, required = true)
    private Integer singleOrBatch;


    @ApiModelProperty(value = "提交通联状态", hidden = false, required = true)
    private String aipgrspRetCode;
    @ApiModelProperty(value = "提交通联状态描述", hidden = false, required = true)
    private String aipgrspErrMsg;
    @ApiModelProperty(value = "通联交易处理结果编码", hidden = false, required = true)
    private String retCode;
    @ApiModelProperty(value = "通联交易处理结果描述", hidden = false, required = true)
    private String errMsg;
    @ApiModelProperty(value = "通联交易处理结果完成时间", hidden = false, required = true)
    private String finTime;

    @ApiModelProperty(value = "批量扣款 所有还款记录主键id", hidden = false, required = true)
    List<Long> repaymentIds;
    @ApiModelProperty(value = "批量扣款 每笔明细", hidden = false, required = true)
    private List<Trans_Detail> transList;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Boolean getOverdue() {
        return overdue;
    }

    public void setOverdue(Boolean overdue) {
        this.overdue = overdue;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    public BigDecimal getOverduePrice() {
        return overduePrice;
    }

    public void setOverduePrice(BigDecimal overduePrice) {
        this.overduePrice = overduePrice;
    }

    public BigDecimal getMonthlyPaymentPrice() {
        return monthlyPaymentPrice;
    }

    public void setMonthlyPaymentPrice(BigDecimal monthlyPaymentPrice) {
        this.monthlyPaymentPrice = monthlyPaymentPrice;
    }

    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
    }

    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCustUserid() {
        return custUserid;
    }

    public void setCustUserid(String custUserid) {
        this.custUserid = custUserid;
    }

    public String getTrxCode() {
        return trxCode;
    }

    public void setTrxCode(String trxCode) {
        this.trxCode = trxCode;
    }

    public String getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode;
    }

    public String getReqSn() {
        return reqSn;
    }

    public void setReqSn(String reqSn) {
        this.reqSn = reqSn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getSingleOrBatch() {
        return singleOrBatch;
    }

    public void setSingleOrBatch(Integer singleOrBatch) {
        this.singleOrBatch = singleOrBatch;
    }

    public String getAipgrspRetCode() {
        return aipgrspRetCode;
    }

    public void setAipgrspRetCode(String aipgrspRetCode) {
        this.aipgrspRetCode = aipgrspRetCode;
    }

    public String getAipgrspErrMsg() {
        return aipgrspErrMsg;
    }

    public void setAipgrspErrMsg(String aipgrspErrMsg) {
        this.aipgrspErrMsg = aipgrspErrMsg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getFinTime() {
        return finTime;
    }

    public void setFinTime(String finTime) {
        this.finTime = finTime;
    }

    public List<Long> getRepaymentIds() {
        return repaymentIds;
    }

    public void setRepaymentIds(List<Long> repaymentIds) {
        this.repaymentIds = repaymentIds;
    }

    public List<Trans_Detail> getTransList() {
        return transList;
    }

    public void setTransList(List<Trans_Detail> transList) {
        this.transList = transList;
    }
}
