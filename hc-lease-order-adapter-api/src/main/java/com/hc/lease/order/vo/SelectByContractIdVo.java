package com.hc.lease.order.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 租金支付表 / 融租合同-月租还款计划明细
 * Created by Administrator on 2017/8/30.
 */
public class SelectByContractIdVo implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "分期数", hidden = false)
    private Integer period;
    @ApiModelProperty(value = "归还本金", hidden = false)
    private BigDecimal returnPrincipal;
    @ApiModelProperty(value = "归还利息", hidden = false)
    private BigDecimal returnInterest;
    @ApiModelProperty(value = "合计、月租", hidden = false)
    private BigDecimal total;
    @ApiModelProperty(value = "剩余本金", hidden = false)
    private BigDecimal residualPrincipal;
    @ApiModelProperty(value = "还款日期", hidden = false)
    private Date repaymentDate;
    @ApiModelProperty(value = "是否逾期 0是 1否", hidden = false)
    private Integer overdue;
    @ApiModelProperty(value = "逾期天数", hidden = false)
    private Integer overdueDay;
    @ApiModelProperty(value = "贷款金额", hidden = false)
    private BigDecimal loanAmount;
    @ApiModelProperty(value = "年利率", hidden = false)
    private BigDecimal annualInterest;
    @ApiModelProperty(value = "尾付", hidden = false)
    private BigDecimal balancePayment;
    @ApiModelProperty(value = "应收", hidden = false)
    private BigDecimal receivableTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public BigDecimal getReturnPrincipal() {
        return returnPrincipal;
    }

    public void setReturnPrincipal(BigDecimal returnPrincipal) {
        this.returnPrincipal = returnPrincipal;
    }

    public BigDecimal getReturnInterest() {
        return returnInterest;
    }

    public void setReturnInterest(BigDecimal returnInterest) {
        this.returnInterest = returnInterest;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getResidualPrincipal() {
        return residualPrincipal;
    }

    public void setResidualPrincipal(BigDecimal residualPrincipal) {
        this.residualPrincipal = residualPrincipal;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Integer getOverdue() {
        return overdue;
    }

    public void setOverdue(Integer overdue) {
        this.overdue = overdue;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(BigDecimal annualInterest) {
        this.annualInterest = annualInterest;
    }

    public BigDecimal getBalancePayment() {
        return balancePayment;
    }

    public void setBalancePayment(BigDecimal balancePayment) {
        this.balancePayment = balancePayment;
    }

    public BigDecimal getReceivableTotal() {
        return receivableTotal;
    }

    public void setReceivableTotal(BigDecimal receivableTotal) {
        this.receivableTotal = receivableTotal;
    }
}
