package com.hc.lease.order.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * //批量扣款款项 月供、滞纳金、其他
 * Created by Administrator on 2017/8/30.
 */
public class BatchPostlendingPaymentVo implements Serializable {
    @ApiModelProperty(value = "款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款主键id'", hidden = false)
    private Long id;
    @ApiModelProperty(value = "融租合同主键id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "公司主键id", hidden = false)
    private Long branchCompanyId;
    @ApiModelProperty(value = "支付状态汇总管理主键id", hidden = false)
    private Long repaymentStatusId;
    @ApiModelProperty(value = "月租还款计划明细主键id", hidden = false)
    private Long repaymentId;
    @ApiModelProperty(value = "合同状态 0:还款中 1: 已结束 2:挂靠中", hidden = false)
    private Integer status;
    @ApiModelProperty(value = "分公司名称", hidden = false)
    private String companyName;
    @ApiModelProperty(value = "承租人主键id", hidden = false)
    private Long accountId;
    @ApiModelProperty(value = "承租人身份证号", hidden = false)
    private String idCard;
    @ApiModelProperty(value = "承租人姓名", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "银行户名", hidden = false)
    private String bankAccountName;
    @ApiModelProperty(value = "承租人姓名", hidden = false)
    private String accountRealName;
    @ApiModelProperty(value = "合计", hidden = false)
    private BigDecimal total;
    @ApiModelProperty(value = "银行卡号", hidden = false)
    private String backCardNumber;
    @ApiModelProperty(value = "银行名称", hidden = false)
    private String bankName;
    @ApiModelProperty(value = "银行编号", hidden = false)
    private String bankCode;
    @ApiModelProperty(value = "支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败", hidden = false)
    private Integer paymentResult;
    @ApiModelProperty(value = "省份名称", hidden = false)
    private String provinceName;
    @ApiModelProperty(value = "城市名称", hidden = false)
    private String cityName;
    @ApiModelProperty(value = "记录序号 通联批量代收", hidden = false)
    private String sn;
    @ApiModelProperty(value = "款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款/还款到最后一期的尾款; 5:提前还款罚款; 6:尾款/提前还款的尾款; 7:其他款项", hidden = false)
    private Integer type;
    @ApiModelProperty(value = "完整合同编号", hidden = false)
    private String completeContractNumber;
    @ApiModelProperty(value = "分期数", hidden = false)
    private String totalPeriod;
    @ApiModelProperty(value = "用户类型：0:个人;1:公司", hidden = false)
    private Integer accountType;
    @ApiModelProperty(value = "逾期天数", hidden = false)
    private Integer overdueDay;
    @ApiModelProperty(value = "滞纳金", hidden = false)
    private BigDecimal overduePrice;
    @ApiModelProperty(value = "最后扣款结果", hidden = false)
    private String paymentResultMsg;

    @ApiModelProperty(value = "逾期天数，扣款的时候改动的实际逾期天数", hidden = false)
    private Integer realOverdueDay;
    @ApiModelProperty(value = "逾期金额，扣款的时候改动的实际逾期金额", hidden = false)
    private BigDecimal realPrice;

    @ApiModelProperty(value = "滞纳金日息利率", hidden = false)
    private BigDecimal overdueRate;

    @ApiModelProperty(value = "逾期金额+月供", hidden = false)
    private BigDecimal totalPrice;

    @ApiModelProperty(value = "月供", hidden = false)
    private BigDecimal monthPrice;

    @ApiModelProperty(value = "承租人手机号", hidden = false)
    private String accountPhone;
    @ApiModelProperty(value = "扣款日", hidden = false)
    private String repaymentDate;
    @ApiModelProperty(value = "车牌号码", hidden = false)
    private String plateNumber;
    @ApiModelProperty(value = "合同开始日期", hidden = false)
    private String leaseStartTime;
    @ApiModelProperty(value = "合同结束日期", hidden = false)
    private String leaseEndTime;
    @ApiModelProperty(value = "扣款日", hidden = false)
    private Integer payDate;
    @ApiModelProperty(value = "支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他;6:批量补录;7:线下缴款登记;8:未开始还款;9:通联协议支付", hidden = false)
    private Integer payWay;
    @ApiModelProperty(value = "支付方式", hidden = false)
    private String payWayName;
    @ApiModelProperty(value = "支付限额", hidden = false)
    private BigDecimal priceLimit;
    @ApiModelProperty(value = "通联协议支付交易 每笔限额", hidden = false)
    private BigDecimal allinpayPriceLimit;
    @ApiModelProperty(value = "通联协议支付交易 每日限额", hidden = false)
    private BigDecimal allinpayDayPriceLimit;
    @ApiModelProperty(value = "每日笔数额度", hidden = false)
    private Integer daySumLimit;
    @ApiModelProperty(value = "协议签约 0:否1:是", hidden = false)
    private Integer isSign;
    @ApiModelProperty(value = "协议号", hidden = false)
    private String agrmNo;
    @ApiModelProperty(value = "备注", hidden = false)
    private String remarks;
    @ApiModelProperty(value = "是否超限 0:否1:是", hidden = false)
    private Integer isOverLimit;
    @ApiModelProperty(value = "银行预留手机号", hidden = false)
    private String bankPhone;

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

    public Long getBranchCompanyId() {
        return branchCompanyId;
    }

    public void setBranchCompanyId(Long branchCompanyId) {
        this.branchCompanyId = branchCompanyId;
    }

    public Long getRepaymentStatusId() {
        return repaymentStatusId;
    }

    public void setRepaymentStatusId(Long repaymentStatusId) {
        this.repaymentStatusId = repaymentStatusId;
    }

    public Long getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Long repaymentId) {
        this.repaymentId = repaymentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public String getAccountRealName() {
        return accountRealName;
    }

    public void setAccountRealName(String accountRealName) {
        this.accountRealName = accountRealName;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public Integer getPaymentResult() {
        return paymentResult;
    }

    public void setPaymentResult(Integer paymentResult) {
        this.paymentResult = paymentResult;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCompleteContractNumber() {
        return completeContractNumber;
    }

    public void setCompleteContractNumber(String completeContractNumber) {
        this.completeContractNumber = completeContractNumber;
    }

    public String getTotalPeriod() {
        return totalPeriod;
    }

    public void setTotalPeriod(String totalPeriod) {
        this.totalPeriod = totalPeriod;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
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

    public String getPaymentResultMsg() {
        return paymentResultMsg;
    }

    public void setPaymentResultMsg(String paymentResultMsg) {
        this.paymentResultMsg = paymentResultMsg;
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

    public BigDecimal getOverdueRate() {
        return overdueRate;
    }

    public void setOverdueRate(BigDecimal overdueRate) {
        this.overdueRate = overdueRate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getMonthPrice() {
        return monthPrice;
    }

    public void setMonthPrice(BigDecimal monthPrice) {
        this.monthPrice = monthPrice;
    }

    public String getAccountPhone() {
        return accountPhone;
    }

    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
    }

    public String getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
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

    public Integer getPayDate() {
        return payDate;
    }

    public void setPayDate(Integer payDate) {
        this.payDate = payDate;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public String getPayWayName() {
        return payWayName;
    }

    public void setPayWayName(String payWayName) {
        this.payWayName = payWayName;
    }

    public BigDecimal getPriceLimit() {
        return priceLimit;
    }

    public void setPriceLimit(BigDecimal priceLimit) {
        this.priceLimit = priceLimit;
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

    public Integer getDaySumLimit() {
        return daySumLimit;
    }

    public void setDaySumLimit(Integer daySumLimit) {
        this.daySumLimit = daySumLimit;
    }

    public Integer getIsSign() {
        return isSign;
    }

    public void setIsSign(Integer isSign) {
        this.isSign = isSign;
    }

    public String getAgrmNo() {
        return agrmNo;
    }

    public void setAgrmNo(String agrmNo) {
        this.agrmNo = agrmNo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getIsOverLimit() {
        return isOverLimit;
    }

    public void setIsOverLimit(Integer isOverLimit) {
        this.isOverLimit = isOverLimit;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone;
    }

}
