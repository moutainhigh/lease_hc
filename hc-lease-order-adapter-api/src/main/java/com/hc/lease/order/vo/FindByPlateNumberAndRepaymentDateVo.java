package com.hc.lease.order.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 车牌号和扣款日期查询还款计划
 * Created by Administrator on 2018/7/9
 */
public class FindByPlateNumberAndRepaymentDateVo implements Serializable {
    @ApiModelProperty(value = "合同主键id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "银行卡号", hidden = false)
    private String backCardNumber;
    @ApiModelProperty(value = "银行预留手机号", hidden = false)
    private String bankPhone;
    @ApiModelProperty(value = "每笔限额", hidden = false)
    private BigDecimal priceLimit;
    @ApiModelProperty(value = "每日限额", hidden = false)
    private BigDecimal dayPriceLimit;
    @ApiModelProperty(value = "每日笔数额度", hidden = false)
    private Integer daySumLimit;
    @ApiModelProperty(value = "是否签约 0否 1是", hidden = false)
    private Integer isSign;
    @ApiModelProperty(value = "签约协议号", hidden = false)
    private String agrmNo;
    @ApiModelProperty(value = "还款计划主键id", hidden = false)
    private Long repaymentId;
    @ApiModelProperty(value = "支付状态汇总管理 月租主键id", hidden = false)
    private Long repaymentStatusId0;
    @ApiModelProperty(value = "支付状态汇总管理 滞纳金主键id", hidden = false)
    private Long repaymentStatusId2;
    @ApiModelProperty(value = "支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败", hidden = false)
    private Long paymentResult0;
    @ApiModelProperty(value = "支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败", hidden = false)
    private Long paymentResult2;
    @ApiModelProperty(value = "月租金额", hidden = false)
    private BigDecimal totlePrice0;
    @ApiModelProperty(value = "滞纳金金额", hidden = false)
    private BigDecimal totlePrice2;
    @ApiModelProperty(value = "扣款日期", hidden = false)
    private Date repaymentDate;
    @ApiModelProperty(value = "滞纳金日息利率", hidden = false)
    private BigDecimal overdueRate;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
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

    public BigDecimal getPriceLimit() {
        return priceLimit;
    }

    public void setPriceLimit(BigDecimal priceLimit) {
        this.priceLimit = priceLimit;
    }

    public BigDecimal getDayPriceLimit() {
        return dayPriceLimit;
    }

    public void setDayPriceLimit(BigDecimal dayPriceLimit) {
        this.dayPriceLimit = dayPriceLimit;
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

    public Long getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Long repaymentId) {
        this.repaymentId = repaymentId;
    }

    public Long getRepaymentStatusId0() {
        return repaymentStatusId0;
    }

    public void setRepaymentStatusId0(Long repaymentStatusId0) {
        this.repaymentStatusId0 = repaymentStatusId0;
    }

    public Long getRepaymentStatusId2() {
        return repaymentStatusId2;
    }

    public void setRepaymentStatusId2(Long repaymentStatusId2) {
        this.repaymentStatusId2 = repaymentStatusId2;
    }

    public Long getPaymentResult0() {
        return paymentResult0;
    }

    public void setPaymentResult0(Long paymentResult0) {
        this.paymentResult0 = paymentResult0;
    }

    public Long getPaymentResult2() {
        return paymentResult2;
    }

    public void setPaymentResult2(Long paymentResult2) {
        this.paymentResult2 = paymentResult2;
    }

    public BigDecimal getTotlePrice0() {
        return totlePrice0;
    }

    public void setTotlePrice0(BigDecimal totlePrice0) {
        this.totlePrice0 = totlePrice0;
    }

    public BigDecimal getTotlePrice2() {
        return totlePrice2;
    }

    public void setTotlePrice2(BigDecimal totlePrice2) {
        this.totlePrice2 = totlePrice2;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public BigDecimal getOverdueRate() {
        return overdueRate;
    }

    public void setOverdueRate(BigDecimal overdueRate) {
        this.overdueRate = overdueRate;
    }

}
