package com.hc.lease.postlending.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 通联支付超额拆分交易明细
 */
public class AllinpaySplitFindPageVo implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "款项主键id，融租合同-还款计划明细主键id", hidden = false)
    private Long repaymentId;
    @ApiModelProperty(value = "融租合同主键id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "承租人主键id", hidden = false)
    private Long accountId;
    @ApiModelProperty(value = "记录通联支付超额的还款计划明细主键id", hidden = false)
    private Long splitConnectId;
    @ApiModelProperty(value = "支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他;6:批量补录;7:线下缴款登记;8:未开始还款;9:通联协议支付", hidden = false)
    private Integer payWay;
    @ApiModelProperty(value = "支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败", hidden = false)
    private Integer paymentResult;
    @ApiModelProperty(value = "状态结果描述  失败原因描述", hidden = false)
    private String paymentResultMsg;
    @ApiModelProperty(value = "状态 0:无操作1:挂起 2:取消挂起", hidden = false)
    private Integer status;
    @ApiModelProperty(value = "是否已过扣款时间 0否 1是", hidden = false)
    private Integer isOverTime;

    @ApiModelProperty(value = "承租人", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "扣款日", hidden = false)
    private String repaymentDate;
    @ApiModelProperty(value = "拆单", hidden = false)
    private String sequenceNumber;
    @ApiModelProperty(value = "状态", hidden = false)
    private String paymentResultName;
    @ApiModelProperty(value = "扣款额", hidden = false)
    private BigDecimal price;
    @ApiModelProperty(value = "扣款额", hidden = false)
    private BigDecimal totlePrice;
    @ApiModelProperty(value = "月租/挂靠费", hidden = false)
    private BigDecimal monthPrice;
    @ApiModelProperty(value = "滞纳金", hidden = false)
    private BigDecimal overduePrice;
    @ApiModelProperty(value = "其他", hidden = false)
    private BigDecimal otherPrice;
    @ApiModelProperty(value = "期数", hidden = false)
    private String totalPeriod;
    @ApiModelProperty(value = "协议签约 0否 1是", hidden = false)
    private Integer isSign;
    @ApiModelProperty(value = "手机", hidden = false)
    private String accountPhone;
    @ApiModelProperty(value = "支付方式", hidden = false)
    private String payWayName;
    @ApiModelProperty(value = "合同号", hidden = false)
    private String completeContractNumber;
    @ApiModelProperty(value = "逾期天数", hidden = false)
    private Integer overdueDay;
    @ApiModelProperty(value = "身份证号码", hidden = false)
    private String idCard;
    @ApiModelProperty(value = "银行代码", hidden = false)
    private String bankCode;
    @ApiModelProperty(value = "银行名称", hidden = false)
    private String bankName;
    @ApiModelProperty(value = "承租人还款银行账号", hidden = false)
    private String backCardNumber;
    @ApiModelProperty(value = "车牌", hidden = false)
    private String plateNumber;
    @ApiModelProperty(value = "合同起始日期", hidden = false)
    private String leaseStartTime;
    @ApiModelProperty(value = "合同结束日期", hidden = false)
    private String leaseEndTime;
    @ApiModelProperty(value = "通联返回的 文件名/可用于通联流水查询/最后一次操作的文件名，有可能一个款项操作了多次", hidden = false)
    private String reqSn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        this.paymentResultMsg = paymentResultMsg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsOverTime() {
        return isOverTime;
    }

    public void setIsOverTime(Integer isOverTime) {
        this.isOverTime = isOverTime;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getPaymentResultName() {
        return paymentResultName;
    }

    public void setPaymentResultName(String paymentResultName) {
        this.paymentResultName = paymentResultName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
    }

    public BigDecimal getMonthPrice() {
        return monthPrice;
    }

    public void setMonthPrice(BigDecimal monthPrice) {
        this.monthPrice = monthPrice;
    }

    public BigDecimal getOverduePrice() {
        return overduePrice;
    }

    public void setOverduePrice(BigDecimal overduePrice) {
        this.overduePrice = overduePrice;
    }

    public BigDecimal getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(BigDecimal otherPrice) {
        this.otherPrice = otherPrice;
    }

    public String getTotalPeriod() {
        return totalPeriod;
    }

    public void setTotalPeriod(String totalPeriod) {
        this.totalPeriod = totalPeriod;
    }

    public Integer getIsSign() {
        return isSign;
    }

    public void setIsSign(Integer isSign) {
        this.isSign = isSign;
    }

    public String getAccountPhone() {
        return accountPhone;
    }

    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
    }

    public String getPayWayName() {
        return payWayName;
    }

    public void setPayWayName(String payWayName) {
        this.payWayName = payWayName;
    }

    public String getCompleteContractNumber() {
        return completeContractNumber;
    }

    public void setCompleteContractNumber(String completeContractNumber) {
        this.completeContractNumber = completeContractNumber;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public String getBackCardNumber() {
        return backCardNumber;
    }

    public void setBackCardNumber(String backCardNumber) {
        this.backCardNumber = backCardNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getLeaseStartTime() {
        return leaseStartTime;
    }

    public void setLeaseStartTime(String leaseStartTime) {
        this.leaseStartTime = leaseStartTime;
    }

    public String getLeaseEndTime() {
        return leaseEndTime;
    }

    public void setLeaseEndTime(String leaseEndTime) {
        this.leaseEndTime = leaseEndTime;
    }

    public String getReqSn() {
        return reqSn;
    }

    public void setReqSn(String reqSn) {
        this.reqSn = reqSn;
    }
}