package com.hc.lease.postlending.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 接收 支付参数封装
 * Created by tong on 2017/6/10.
 */
public class TransReceiveVo implements Serializable {

    @ApiModelProperty(value = "批量扣款 所有合同主键ID (需提供：提交批量代收 / 提交批扣,)", hidden = false, required = true)
    List<Long> contractIds;
    @ApiModelProperty(value = "还款日 (需提供：提交批量代收 / 提交批扣,)", hidden = false, required = true)
    private Integer repaymentDate;
    @ApiModelProperty(value = "支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他;6:批量补录;7:线下缴款登记;8:未开始还款;9:通联协议支付", hidden = false, required = true)
    private Integer payWay;
    @ApiModelProperty(value = "融租合同主键id (需提供：单人综合扣款)", hidden = false, required = true)
    private Long contractId;
    @ApiModelProperty(value = "月供月份/融租合同-还款主键id (需提供：单人综合扣款)", hidden = false, required = true)
    private Long repaymentId;
    @ApiModelProperty(value = "备注 单人综合扣款", hidden = false, required = true)
    private String remarks;
    @ApiModelProperty(value = "提前还款小计 (需提供：单人综合扣款)", hidden = false, required = true)
    private BigDecimal advancePrice;
    @ApiModelProperty(value = "逾期天数 (需提供：单人综合扣款)", hidden = false, required = true)
    private Integer overdueDay;
    @ApiModelProperty(value = "交易流水号 (需提供：交易查询/轮询,)", hidden = false, required = true)
    private String reqSn;
    @ApiModelProperty(value = "记录序号 通联批量代收 每条数据的 序号", hidden = false, required = true)
    private String sn;
    @ApiModelProperty(value = "支付状态汇总管理主键id (需提供：单人综合扣款)", hidden = false, required = true)
    private Long repaymentStatusId;
    @ApiModelProperty(value = "款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款; 5:提前还款罚款", hidden = false, required = true)
    private Integer payType;
    @ApiModelProperty(value = "代收流水主键id", hidden = false)
    private Long allinpayLogId;

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

    @ApiModelProperty(value = "所有还款明细主键ID (需提供：线下缴款登记,)", hidden = false, required = true)
    List<Long> repaymentIds;

    @ApiModelProperty(value = "通联批扣提交的 所有月租 和 所有 滞纳金 (需提供：通联批扣)", hidden = false)
    private List<BatchPaymentVo> batchPaymentVo;

    @ApiModelProperty(value = "扣款提交的其他款项金额 (需提供：单人综合扣款)", hidden = false)
    private List<OtherVo> otherVo;

    @ApiModelProperty(value = "备注 (需提供：单人综合扣款)", hidden = false)
    private List<RemarksVo> remarksVo;

    public List<Long> getContractIds() {
        return contractIds;
    }

    public void setContractIds(List<Long> contractIds) {
        this.contractIds = contractIds;
    }

    public Integer getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Integer repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigDecimal getAdvancePrice() {
        return advancePrice;
    }

    public void setAdvancePrice(BigDecimal advancePrice) {
        this.advancePrice = advancePrice;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
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

    public Long getRepaymentStatusId() {
        return repaymentStatusId;
    }

    public void setRepaymentStatusId(Long repaymentStatusId) {
        this.repaymentStatusId = repaymentStatusId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Long getAllinpayLogId() {
        return allinpayLogId;
    }

    public void setAllinpayLogId(Long allinpayLogId) {
        this.allinpayLogId = allinpayLogId;
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

    public List<Long> getRepaymentIds() {
        return repaymentIds;
    }

    public void setRepaymentIds(List<Long> repaymentIds) {
        this.repaymentIds = repaymentIds;
    }

    public List<BatchPaymentVo> getBatchPaymentVo() {
        return batchPaymentVo;
    }

    public void setBatchPaymentVo(List<BatchPaymentVo> batchPaymentVo) {
        this.batchPaymentVo = batchPaymentVo;
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

    @Override
    public String toString() {
        return "TransReceiveVo{" +
                "contractIds=" + contractIds +
                ", repaymentDate=" + repaymentDate +
                ", payWay=" + payWay +
                ", contractId=" + contractId +
                ", repaymentId=" + repaymentId +
                ", remarks='" + remarks + '\'' +
                ", advancePrice=" + advancePrice +
                ", overdueDay=" + overdueDay +
                ", reqSn='" + reqSn + '\'' +
                ", sn='" + sn + '\'' +
                ", repaymentStatusId=" + repaymentStatusId +
                ", payType=" + payType +
                ", allinpayLogId=" + allinpayLogId +
                ", paymentOverdueVo=" + paymentOverdueVo +
                ", paymentMonthVo=" + paymentMonthVo +
                ", paymentLinkVo=" + paymentLinkVo +
                ", paymentAdvanceVo=" + paymentAdvanceVo +
                ", paymentBalanceVo=" + paymentBalanceVo +
                ", isBalancePayment=" + isBalancePayment +
                ", repaymentIds=" + repaymentIds +
                ", batchPaymentVo=" + batchPaymentVo +
                ", otherVo=" + otherVo +
                ", remarksVo=" + remarksVo +
                '}';
    }
}
