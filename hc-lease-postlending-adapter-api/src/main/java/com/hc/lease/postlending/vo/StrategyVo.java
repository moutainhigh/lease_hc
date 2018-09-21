package com.hc.lease.postlending.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 贷后 单人综合扣款 策略模式 参数封装
 * Created by tong on 2017/8/28.
 */
public class StrategyVo implements Serializable {


    @ApiModelProperty(value = "月供月份/融租合同-还款主键id (需提供：单人综合扣款)", hidden = false, required = true)
    private Long repaymentId;

    @ApiModelProperty(value = "融租合同主键id (需提供：单人综合扣款)", hidden = false, required = true)
    private Long contractId;

    @ApiModelProperty(value = "合计金额", hidden = false, required = true)
    private BigDecimal totlePrice;

    @ApiModelProperty(value = "逾期天数 (需提供：单人综合扣款)", hidden = false, required = true)
    private Integer overdueDay;

    @ApiModelProperty(value = "备注 单人综合扣款、批量扣款", hidden = false, required = true)
    private String remarks;

    @ApiModelProperty(value = "支付款项类型", hidden = false, required = true)
    private Integer payType;

    @ApiModelProperty(value = "交易流水号 (需提供：交易查询/轮询,)", hidden = false, required = true)
    private String reqSn;

    @ApiModelProperty(value = "通联返回的 头部 状态码", hidden = false, required = true)
    private String aipgrspRetCode;

    @ApiModelProperty(value = "通联返回的 头部 状态结果描述", hidden = false, required = true)
    private String aipgrspErrMsg;

    @ApiModelProperty(value = "通联返回的 明细 状态码", hidden = false, required = true)
    private String retCode;

    @ApiModelProperty(value = "通联返回的 明细 状态结果描述", hidden = false, required = true)
    private String errMsg;

    @ApiModelProperty(value = "通联返回的 最终 状态码/结合 头部 和 明细 状态判断", hidden = false, required = true)
    private String finalCode;

    @ApiModelProperty(value = "通联返回的 最终 状态结果描述/结合 头部 和 明细 状态判断", hidden = false, required = true)
    private String finalErrMsg;

    @ApiModelProperty(value = "通联返回的 操作日期", hidden = false, required = true)
    private String repTime;

    @ApiModelProperty(value = "单笔或批量/0:单笔; 1:批量", hidden = false, required = true)
    private Integer singleOrBatch;

    @ApiModelProperty(value = "支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他;6:批量补录;7:线下缴款登记;8:未开始还款;9:通联协议支付", hidden = false, required = true)
    private Integer payWay;

    @ApiModelProperty(value = "通联支付反馈状态日期", hidden = false)
    private Date backTime;

    @ApiModelProperty(value = "通联支付状态/0:已提交;1:成功;2:失败", hidden = false)
    private Integer status;

    @ApiModelProperty(value = "交易代码", hidden = false, required = true)
    private String trxCode;

    @ApiModelProperty(value = "交易代码", hidden = false, required = true)
    private String busiCode;

    @ApiModelProperty(value = "记录序号 通联批量代收", hidden = false)
    private String sn;

    @ApiModelProperty(value = "通联批量代收批次统计主键id", hidden = false)
    private Long allinpayBatchId;

    @ApiModelProperty(value = "支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败", hidden = false)
    private Integer paymentResult;

    @ApiModelProperty(value = "提前还款小计 (需提供：单人综合扣款)", hidden = false, required = true)
    private BigDecimal advancePrice;

    @ApiModelProperty(value = "是否逾期", hidden = false, required = true)
    private Boolean overdue;

    @ApiModelProperty(value = "承租人主键id", hidden = false)
    private Long accountId;
    @ApiModelProperty(value = "创建日期/操作日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期/操作日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;

    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;

    @ApiModelProperty(value = "逾期天数，扣款的时候改动的实际逾期天数", hidden = false)
    private Integer realOverdueDay;
    @ApiModelProperty(value = "逾期金额，扣款的时候改动的实际逾期金额", hidden = false)
    private BigDecimal realPrice;

    @ApiModelProperty(value = "代收状态流水 类型 0:提交通联单笔扣款(代扣)的结果;1:提交通联批量扣款(代扣)的结果;2:轮询通联单笔扣款(代扣)的结果;3:轮询通联批量扣款(代扣)的结果;4:提交通联单笔扣款(协议支付)的结果;5:提交通联批量扣款(协议支付)的结果", hidden = false)
    private Integer allinpayStatusLogType;

    @ApiModelProperty(value = "备注", hidden = false)
    private List<RemarksVo> remarksVo;

    @ApiModelProperty(value = "操作来源 0:单笔; 1:批量;2:手动批扣", hidden = false)
    private Integer controllerSource;

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

    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getReqSn() {
        return reqSn;
    }

    public void setReqSn(String reqSn) {
        this.reqSn = reqSn;
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

    public String getFinalCode() {
        return finalCode;
    }

    public void setFinalCode(String finalCode) {
        this.finalCode = finalCode;
    }

    public String getFinalErrMsg() {
        return finalErrMsg;
    }

    public void setFinalErrMsg(String finalErrMsg) {
        this.finalErrMsg = finalErrMsg;
    }

    public String getRepTime() {
        return repTime;
    }

    public void setRepTime(String repTime) {
        this.repTime = repTime;
    }

    public Integer getSingleOrBatch() {
        return singleOrBatch;
    }

    public void setSingleOrBatch(Integer singleOrBatch) {
        this.singleOrBatch = singleOrBatch;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Long getAllinpayBatchId() {
        return allinpayBatchId;
    }

    public void setAllinpayBatchId(Long allinpayBatchId) {
        this.allinpayBatchId = allinpayBatchId;
    }

    public Integer getPaymentResult() {
        return paymentResult;
    }

    public void setPaymentResult(Integer paymentResult) {
        this.paymentResult = paymentResult;
    }

    public BigDecimal getAdvancePrice() {
        return advancePrice;
    }

    public void setAdvancePrice(BigDecimal advancePrice) {
        this.advancePrice = advancePrice;
    }

    public Boolean getOverdue() {
        return overdue;
    }

    public void setOverdue(Boolean overdue) {
        this.overdue = overdue;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public Integer getAllinpayStatusLogType() {
        return allinpayStatusLogType;
    }

    public void setAllinpayStatusLogType(Integer allinpayStatusLogType) {
        this.allinpayStatusLogType = allinpayStatusLogType;
    }

    public List<RemarksVo> getRemarksVo() {
        return remarksVo;
    }

    public void setRemarksVo(List<RemarksVo> remarksVo) {
        this.remarksVo = remarksVo;
    }

    public Integer getControllerSource() {
        return controllerSource;
    }

    public void setControllerSource(Integer controllerSource) {
        this.controllerSource = controllerSource;
    }

    @Override
    public String toString() {
        return "StrategyVo{" +
                "repaymentId=" + repaymentId +
                ", contractId=" + contractId +
                ", totlePrice=" + totlePrice +
                ", overdueDay=" + overdueDay +
                ", remarks='" + remarks + '\'' +
                ", payType=" + payType +
                ", reqSn='" + reqSn + '\'' +
                ", aipgrspRetCode='" + aipgrspRetCode + '\'' +
                ", aipgrspErrMsg='" + aipgrspErrMsg + '\'' +
                ", retCode='" + retCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", finalCode='" + finalCode + '\'' +
                ", finalErrMsg='" + finalErrMsg + '\'' +
                ", repTime='" + repTime + '\'' +
                ", singleOrBatch=" + singleOrBatch +
                ", payWay=" + payWay +
                ", backTime=" + backTime +
                ", status=" + status +
                ", trxCode='" + trxCode + '\'' +
                ", busiCode='" + busiCode + '\'' +
                ", sn='" + sn + '\'' +
                ", allinpayBatchId=" + allinpayBatchId +
                ", paymentResult=" + paymentResult +
                ", advancePrice=" + advancePrice +
                ", overdue=" + overdue +
                ", accountId=" + accountId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", realOverdueDay=" + realOverdueDay +
                ", realPrice=" + realPrice +
                ", allinpayStatusLogType=" + allinpayStatusLogType +
                ", remarksVo=" + remarksVo +
                ", controllerSource=" + controllerSource +
                '}';
    }
}
