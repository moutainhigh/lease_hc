package com.hc.lease.postlending.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 通联批扣
 * 用于扣款的数据
 * Created by Tong on 2018/6/25
 */
public class TransBodyInstallVo implements Serializable {
    @ApiModelProperty(value = "银行户名", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "银行卡号", hidden = false)
    private String accountNo;
    @ApiModelProperty(value = "身份证号", hidden = false)
    private String idCard;
    @ApiModelProperty(value = "金额", hidden = false)
    private BigDecimal amount;
    @ApiModelProperty(value = "金额", hidden = false)
    private BigDecimal amountOld;
    @ApiModelProperty(value = "银行编码", hidden = false)
    private String bankCode;
    @ApiModelProperty(value = "账号属性 0私人 1公司", hidden = false)
    private String accountProp;
    @ApiModelProperty(value = "货币类型", hidden = false)
    private String currency;
    @ApiModelProperty(value = "记录序号 通联批量代收、通联会原样返回", hidden = false)
    private String sn;
    @ApiModelProperty(value = "协议号", hidden = false)
    private String agrmNo;
    @ApiModelProperty(value = "手机号", hidden = false)
    private String accountPhone;
    @ApiModelProperty(value = "银行预留手机", hidden = false)
    private String bankPhone;
    @ApiModelProperty(value = "通联协议支付交易 每笔限额", hidden = false)
    private BigDecimal allinpayPriceLimit;
    @ApiModelProperty(value = "通联协议支付交易 每日限额", hidden = false)
    private BigDecimal allinpayDayPriceLimit;
    @ApiModelProperty(value = "每日笔数额度", hidden = false, required = true)
    private Integer daySumLimit;

    @ApiModelProperty(value = "总金额", hidden = false)
    private BigDecimal totlePrice;
    @ApiModelProperty(value = "创建日期/操作日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期/操作日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "批次号/批扣流水", hidden = false)
    private String batchNumber;

    @ApiModelProperty(value = "单笔或批量/0:单笔; 1:批量", hidden = false, required = true)
    private Integer singleOrBatch;

    @ApiModelProperty(value = "月租还款计划明细主键id", hidden = false)
    private Long repaymentId;

    @ApiModelProperty(value = "融租合同主键id", hidden = false)
    private Long contractId;

    @ApiModelProperty(value = "代收状态流水 类型 0:提交通联单笔扣款(代扣)的结果;1:提交通联批量扣款(代扣)的结果;2:轮询通联单笔扣款(代扣)的结果;3:轮询通联批量扣款(代扣)的结果;4:提交通联单笔扣款(协议支付)的结果;5:提交通联批量扣款(协议支付)的结果", hidden = false)
    private Integer allinpayStatusLogType;

    @ApiModelProperty(value = "是否超额拆单/0:是; 1:否", hidden = false, required = true)
    private Integer isSpilt;

    @ApiModelProperty(value = "操作来源 0:单笔; 1:批量;2:手动批扣", hidden = false)
    private Integer controllerSource;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmountOld() {
        return amountOld;
    }

    public void setAmountOld(BigDecimal amountOld) {
        this.amountOld = amountOld;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getAccountProp() {
        return accountProp;
    }

    public void setAccountProp(String accountProp) {
        this.accountProp = accountProp;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getAgrmNo() {
        return agrmNo;
    }

    public void setAgrmNo(String agrmNo) {
        this.agrmNo = agrmNo;
    }

    public String getAccountPhone() {
        return accountPhone;
    }

    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone;
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

    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
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

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Integer getSingleOrBatch() {
        return singleOrBatch;
    }

    public void setSingleOrBatch(Integer singleOrBatch) {
        this.singleOrBatch = singleOrBatch;
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

    public Integer getAllinpayStatusLogType() {
        return allinpayStatusLogType;
    }

    public void setAllinpayStatusLogType(Integer allinpayStatusLogType) {
        this.allinpayStatusLogType = allinpayStatusLogType;
    }

    public Integer getIsSpilt() {
        return isSpilt;
    }

    public void setIsSpilt(Integer isSpilt) {
        this.isSpilt = isSpilt;
    }

    public Integer getControllerSource() {
        return controllerSource;
    }

    public void setControllerSource(Integer controllerSource) {
        this.controllerSource = controllerSource;
    }

    @Override
    public String toString() {
        return "TransBodyInstallVo{" +
                "accountName='" + accountName + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", idCard='" + idCard + '\'' +
                ", amount=" + amount +
                ", amountOld=" + amountOld +
                ", bankCode='" + bankCode + '\'' +
                ", accountProp='" + accountProp + '\'' +
                ", currency='" + currency + '\'' +
                ", sn='" + sn + '\'' +
                ", agrmNo='" + agrmNo + '\'' +
                ", accountPhone='" + accountPhone + '\'' +
                ", bankPhone='" + bankPhone + '\'' +
                ", allinpayPriceLimit=" + allinpayPriceLimit +
                ", allinpayDayPriceLimit=" + allinpayDayPriceLimit +
                ", daySumLimit=" + daySumLimit +
                ", totlePrice=" + totlePrice +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", batchNumber='" + batchNumber + '\'' +
                ", singleOrBatch=" + singleOrBatch +
                ", repaymentId=" + repaymentId +
                ", contractId=" + contractId +
                ", allinpayStatusLogType=" + allinpayStatusLogType +
                ", isSpilt=" + isSpilt +
                ", controllerSource=" + controllerSource +
                '}';
    }
}
