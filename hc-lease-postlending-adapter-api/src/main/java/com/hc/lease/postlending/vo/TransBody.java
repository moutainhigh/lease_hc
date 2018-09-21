package com.hc.lease.postlending.vo;

import com.aipg.payreq.Trans_Detail;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @ApiModelProperty(value = "银行预留手机号", hidden = false, required = true)
    private String bankPhone;

    @ApiModelProperty(value = "身份证", hidden = false, required = true)
    private String idCard;

    @ApiModelProperty(value = "银行代码，存折必须填写", hidden = false, required = true)
    private String bankCode;

    @ApiModelProperty(value = "银行名称", hidden = false, required = true)
    private String bankName;

    @ApiModelProperty(value = "是否逾期", hidden = false, required = true)
    private Boolean overdue;

    @ApiModelProperty(value = "逾期天数 (需提供：单人综合扣款)", hidden = false, required = true)
    private Integer overdueDay;

    @ApiModelProperty(value = "逾期金额 (需提供：单人综合扣款)", hidden = false, required = true)
    private BigDecimal overduePrice;

    @ApiModelProperty(value = "月供金额", hidden = false, required = true)
    private BigDecimal monthlyPaymentPrice;

    @ApiModelProperty(value = "合计金额", hidden = false, required = true)
    private BigDecimal totlePrice;

    @ApiModelProperty(value = "总笔数", hidden = false, required = true)
    private Integer totalItem;

    @ApiModelProperty(value = "支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他;6:批量补录;7:线下缴款登记;8:未开始还款;9:通联协议支付", hidden = false, required = true)
    private Integer payWay;

    @ApiModelProperty(value = "款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款; 5:提前还款罚款", hidden = false, required = true)
    private Integer payType;

    @ApiModelProperty(value = "月供月份/融租合同-还款主键id (需提供：单人综合扣款)", hidden = false, required = true)
    private Long repaymentId;

    @ApiModelProperty(value = "支付状态汇总管理主键id (需提供：单人综合扣款)", hidden = false, required = true)
    private Long repaymentStatusId;

    @ApiModelProperty(value = "融租合同主键id (需提供：单人综合扣款)", hidden = false, required = true)
    private Long contractId;

    @ApiModelProperty(value = "备注 单人综合扣款", hidden = false, required = true)
    private String remarks;

    @ApiModelProperty(value = "商户自定义的用户号，可当作备注字段使用", hidden = false, required = true)
    private String custUserid;

    @ApiModelProperty(value = "交易代码", hidden = false, required = true)
    private String trxCode;

    @ApiModelProperty(value = "业务代码", hidden = false, required = true)
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

    @ApiModelProperty(value = "通联代扣交易 每笔额度", hidden = false, required = true)
    BigDecimal allinpayPriceLimit;

    @ApiModelProperty(value = "通联代扣交易 每日限额", hidden = false, required = true)
    BigDecimal allinpayDayPriceLimit;

    @ApiModelProperty(value = "批量扣款 所有合同主键ID (需提供：提交批量代收 / 提交批扣,)", hidden = false, required = true)
    List<Long> contractIds;

    @ApiModelProperty(value = "批量扣款 所有还款记录主键id", hidden = false, required = true)
    List<Long> repaymentIds;

    @ApiModelProperty(value = "批量扣款 每笔明细", hidden = false, required = true)
    private List<Trans_Detail> transList;

    @ApiModelProperty(value = "代收流水主键id", hidden = false)
    private Long allinpayLogId;

    @ApiModelProperty(value = "还款日 (需提供：提交批量代收 / 提交批扣,)", hidden = false, required = true)
    private String repaymentDateStr;

    @ApiModelProperty(value = "还款日 (需提供：提交批量代收 / 提交批扣,)", hidden = false, required = true)
    private Date repaymentDate;

    @ApiModelProperty(value = "提前还款小计 (需提供：单人综合扣款)", hidden = false, required = true)
    private BigDecimal advancePrice;

    @ApiModelProperty(value = "还款日 (需提供：提交批量代收 / 提交批扣,)", hidden = false, required = true)
    private Integer repaymentInteger;

    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;

    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;

    @ApiModelProperty(value = "扣款提交的改动的逾期天数 (需提供：单人综合扣款)", hidden = false)
    private List<PaymentOverdueVo> paymentOverdueVo;

    @ApiModelProperty(value = "扣款提交的月租 (需提供：单人综合扣款)", hidden = false)
    private List<PaymentMonthVo> paymentMonthVo;

    @ApiModelProperty(value = "扣款提交的挂靠 (需提供：单人综合扣款)", hidden = false)
    private List<PaymentLinkVo> paymentLinkVo;

    @ApiModelProperty(value = "扣款改动的提前还款 (需提供：单人综合扣款)", hidden = false)
    private List<PaymentAdvanceVo> paymentAdvanceVo;

    @ApiModelProperty(value = "扣款改动的尾付 (需提供：单人综合扣款)", hidden = false)
    private List<PaymentBalanceVo> paymentBalanceVo;

    @ApiModelProperty(value = "是支付尾付 0:否 1:是 (需提供：单人综合扣款)", hidden = false, required = true)
    private Integer isBalancePayment;

    @ApiModelProperty(value = "款项类型 0:月租;1:挂靠", hidden = false)
    private Integer overdueType;

    @ApiModelProperty(value = "批量扣款提交的数据 所有月租、滞纳金、其他金额 (需提供：批量扣款)", hidden = false)
    private List<BatchPaymentVo> batchPaymentVo;

    @ApiModelProperty(value = "协议号 (需提供：通联协议支付)", hidden = false)
    private String agrmno;

    @ApiModelProperty(value = "扣款提交的其他款项金额 (需提供：单人综合扣款)", hidden = false)
    private List<OtherVo> otherVo;

    @ApiModelProperty(value = "备注 (需提供：单人综合扣款)", hidden = false)
    private List<RemarksVo> remarksVo;

    @ApiModelProperty(value = "批扣、不需要代收的合同集合，防止其他用户同时操作了同一条合同扣款则不需要再操作次条合同扣款", hidden = false)
    List<Long> noDualList;

    @ApiModelProperty(value = "批扣、同一个承租人银行卡的款项处理成一条之后的数据集合", hidden = false)
    Map<String, TransBodyInstallVo> batchMapAll;

    @ApiModelProperty(value = "批次号/批扣流水", hidden = false)
    private String batchNumber;

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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public List<Long> getContractIds() {
        return contractIds;
    }

    public void setContractIds(List<Long> contractIds) {
        this.contractIds = contractIds;
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

    public Long getAllinpayLogId() {
        return allinpayLogId;
    }

    public void setAllinpayLogId(Long allinpayLogId) {
        this.allinpayLogId = allinpayLogId;
    }

    public String getRepaymentDateStr() {
        return repaymentDateStr;
    }

    public void setRepaymentDateStr(String repaymentDateStr) {
        this.repaymentDateStr = repaymentDateStr;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public BigDecimal getAdvancePrice() {
        return advancePrice;
    }

    public void setAdvancePrice(BigDecimal advancePrice) {
        this.advancePrice = advancePrice;
    }

    public Integer getRepaymentInteger() {
        return repaymentInteger;
    }

    public void setRepaymentInteger(Integer repaymentInteger) {
        this.repaymentInteger = repaymentInteger;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public List<PaymentOverdueVo> getPaymentOverdueVo() {
        return paymentOverdueVo;
    }

    public void setPaymentOverdueVo(List<PaymentOverdueVo> paymentOverdueVo) {
        this.paymentOverdueVo = paymentOverdueVo;
    }

    public List<PaymentMonthVo> getPaymentMonthVo() {
        return paymentMonthVo;
    }

    public void setPaymentMonthVo(List<PaymentMonthVo> paymentMonthVo) {
        this.paymentMonthVo = paymentMonthVo;
    }

    public List<PaymentLinkVo> getPaymentLinkVo() {
        return paymentLinkVo;
    }

    public void setPaymentLinkVo(List<PaymentLinkVo> paymentLinkVo) {
        this.paymentLinkVo = paymentLinkVo;
    }

    public List<PaymentAdvanceVo> getPaymentAdvanceVo() {
        return paymentAdvanceVo;
    }

    public void setPaymentAdvanceVo(List<PaymentAdvanceVo> paymentAdvanceVo) {
        this.paymentAdvanceVo = paymentAdvanceVo;
    }

    public List<PaymentBalanceVo> getPaymentBalanceVo() {
        return paymentBalanceVo;
    }

    public void setPaymentBalanceVo(List<PaymentBalanceVo> paymentBalanceVo) {
        this.paymentBalanceVo = paymentBalanceVo;
    }

    public Integer getIsBalancePayment() {
        return isBalancePayment;
    }

    public void setIsBalancePayment(Integer isBalancePayment) {
        this.isBalancePayment = isBalancePayment;
    }

    public Integer getOverdueType() {
        return overdueType;
    }

    public void setOverdueType(Integer overdueType) {
        this.overdueType = overdueType;
    }

    public List<BatchPaymentVo> getBatchPaymentVo() {
        return batchPaymentVo;
    }

    public void setBatchPaymentVo(List<BatchPaymentVo> batchPaymentVo) {
        this.batchPaymentVo = batchPaymentVo;
    }

    public String getAgrmno() {
        return agrmno;
    }

    public void setAgrmno(String agrmno) {
        this.agrmno = agrmno;
    }

    public List<OtherVo> getOtherVo() {
        return otherVo;
    }

    public void setOtherVo(List<OtherVo> otherVo) {
        this.otherVo = otherVo;
    }

    public List<RemarksVo> getRemarksVo() {
        return remarksVo;
    }

    public void setRemarksVo(List<RemarksVo> remarksVo) {
        this.remarksVo = remarksVo;
    }

    public List<Long> getNoDualList() {
        return noDualList;
    }

    public void setNoDualList(List<Long> noDualList) {
        this.noDualList = noDualList;
    }

    public Map<String, TransBodyInstallVo> getBatchMapAll() {
        return batchMapAll;
    }

    public void setBatchMapAll(Map<String, TransBodyInstallVo> batchMapAll) {
        this.batchMapAll = batchMapAll;
    }

    public BigDecimal getAllinpayPriceLimit() {
        return allinpayPriceLimit;
    }

    public void setAllinpayPriceLimit(BigDecimal allinpayPriceLimit) {
        this.allinpayPriceLimit = allinpayPriceLimit;
    }

    public BigDecimal getAllinpayDayPriceLimit() {
        return allinpayDayPriceLimit;
    }

    public void setAllinpayDayPriceLimit(BigDecimal allinpayDayPriceLimit) {
        this.allinpayDayPriceLimit = allinpayDayPriceLimit;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    @Override
    public String toString() {
        return "TransBody{" +
                "accountId=" + accountId +
                ", bankAccountName='" + bankAccountName + '\'' +
                ", bankAccountNo='" + bankAccountNo + '\'' +
                ", phone='" + phone + '\'' +
                ", bankPhone='" + bankPhone + '\'' +
                ", idCard='" + idCard + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", bankName='" + bankName + '\'' +
                ", overdue=" + overdue +
                ", overdueDay=" + overdueDay +
                ", overduePrice=" + overduePrice +
                ", monthlyPaymentPrice=" + monthlyPaymentPrice +
                ", totlePrice=" + totlePrice +
                ", totalItem=" + totalItem +
                ", payWay=" + payWay +
                ", payType=" + payType +
                ", repaymentId=" + repaymentId +
                ", repaymentStatusId=" + repaymentStatusId +
                ", contractId=" + contractId +
                ", remarks='" + remarks + '\'' +
                ", custUserid='" + custUserid + '\'' +
                ", trxCode='" + trxCode + '\'' +
                ", busiCode='" + busiCode + '\'' +
                ", reqSn='" + reqSn + '\'' +
                ", sn='" + sn + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", singleOrBatch=" + singleOrBatch +
                ", aipgrspRetCode='" + aipgrspRetCode + '\'' +
                ", aipgrspErrMsg='" + aipgrspErrMsg + '\'' +
                ", retCode='" + retCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", finTime='" + finTime + '\'' +
                ", allinpayPriceLimit='" + allinpayPriceLimit + '\'' +
                ", allinpayDayPriceLimit='" + allinpayDayPriceLimit + '\'' +
                ", contractIds=" + contractIds +
                ", repaymentIds=" + repaymentIds +
                ", transList=" + transList +
                ", allinpayLogId=" + allinpayLogId +
                ", repaymentDateStr='" + repaymentDateStr + '\'' +
                ", repaymentDate=" + repaymentDate +
                ", advancePrice=" + advancePrice +
                ", repaymentInteger=" + repaymentInteger +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", paymentOverdueVo=" + paymentOverdueVo +
                ", paymentMonthVo=" + paymentMonthVo +
                ", paymentLinkVo=" + paymentLinkVo +
                ", paymentAdvanceVo=" + paymentAdvanceVo +
                ", paymentBalanceVo=" + paymentBalanceVo +
                ", isBalancePayment=" + isBalancePayment +
                ", overdueType=" + overdueType +
                ", batchPaymentVo=" + batchPaymentVo +
                ", agrmno='" + agrmno + '\'' +
                ", otherVo=" + otherVo +
                ", remarksVo=" + remarksVo +
                ", noDualList=" + noDualList +
                ", batchMapAll=" + batchMapAll +
                ", batchNumber='" + batchNumber + '\'' +
                '}';
    }
}
