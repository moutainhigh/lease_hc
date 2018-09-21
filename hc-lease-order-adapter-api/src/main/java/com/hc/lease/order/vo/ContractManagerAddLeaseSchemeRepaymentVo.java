package com.hc.lease.order.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * 贷后直租合同改期数 生成还款计划表 VO
 * Created by tong on 2018/8/16
 */
public class ContractManagerAddLeaseSchemeRepaymentVo implements Serializable {

    @ApiModelProperty(value = "融租合同 提前还款主键id", hidden = false)
    BigDecimal price;
    @ApiModelProperty(value = "租赁起始日期", hidden = false)
    private Date leaseStartTime;
    @ApiModelProperty(value = "客户综合报价", hidden = false)
    private BigDecimal comprehensiveQuote;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "融租合同主键id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "年利率", hidden = false)
    private BigDecimal annualInterest;
    @ApiModelProperty(value = "承租人主键id", hidden = false)
    private Long lesseeId;
    @ApiModelProperty(value = "每月偿还本金", hidden = false)
    Map<Integer, BigDecimal> mapPrincipal;
    @ApiModelProperty(value = "每月偿还利息", hidden = false)
    Map<Integer, BigDecimal> mapInterest;
    @ApiModelProperty(value = "本息", hidden = false)
    double perMonthPrincipalInterest;
    @ApiModelProperty(value = "日期", hidden = false)
    Calendar calendar;
    @ApiModelProperty(value = "分期数", hidden = false)
    private Integer period;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getLeaseStartTime() {
        return leaseStartTime;
    }

    public void setLeaseStartTime(Date leaseStartTime) {
        this.leaseStartTime = leaseStartTime;
    }

    public BigDecimal getComprehensiveQuote() {
        return comprehensiveQuote;
    }

    public void setComprehensiveQuote(BigDecimal comprehensiveQuote) {
        this.comprehensiveQuote = comprehensiveQuote;
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

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public BigDecimal getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(BigDecimal annualInterest) {
        this.annualInterest = annualInterest;
    }

    public Long getLesseeId() {
        return lesseeId;
    }

    public void setLesseeId(Long lesseeId) {
        this.lesseeId = lesseeId;
    }

    public Map<Integer, BigDecimal> getMapPrincipal() {
        return mapPrincipal;
    }

    public void setMapPrincipal(Map<Integer, BigDecimal> mapPrincipal) {
        this.mapPrincipal = mapPrincipal;
    }

    public Map<Integer, BigDecimal> getMapInterest() {
        return mapInterest;
    }

    public void setMapInterest(Map<Integer, BigDecimal> mapInterest) {
        this.mapInterest = mapInterest;
    }

    public double getPerMonthPrincipalInterest() {
        return perMonthPrincipalInterest;
    }

    public void setPerMonthPrincipalInterest(double perMonthPrincipalInterest) {
        this.perMonthPrincipalInterest = perMonthPrincipalInterest;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "ContractManagerAddLeaseSchemeRepaymentVo{" +
                "price=" + price +
                ", leaseStartTime=" + leaseStartTime +
                ", comprehensiveQuote=" + comprehensiveQuote +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", contractId=" + contractId +
                ", annualInterest=" + annualInterest +
                ", lesseeId=" + lesseeId +
                ", mapPrincipal=" + mapPrincipal +
                ", mapInterest=" + mapInterest +
                ", perMonthPrincipalInterest=" + perMonthPrincipalInterest +
                ", calendar=" + calendar +
                ", period=" + period +
                '}';
    }
}
