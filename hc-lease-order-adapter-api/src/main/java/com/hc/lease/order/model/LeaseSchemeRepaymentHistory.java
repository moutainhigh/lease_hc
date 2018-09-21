package com.hc.lease.order.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeaseSchemeRepaymentHistory implements Serializable {
    private Long id;

    private Long historyId;

    private Long contractId;

    private Long lesseeId;

    private Long period;

    private BigDecimal returnPrincipal;

    private BigDecimal returnInterest;

    private BigDecimal total;

    private BigDecimal residualPrincipal;

    private Date repaymentDate;

    private Short overdue;

    private Integer overdueDay;

    private BigDecimal loanAmount;

    private BigDecimal annualInterest;

    private Date createTime;

    private Date updateTime;

    private Long createBy;

    private Long updateBy;

    private Date historyCreateTime;

    private Date historyUpdateTime;

    private Long historyCreateBy;

    private Long historyUpdateBy;

    private Integer sort;

    private Boolean isEnable;

    private Integer vsersionNumber;
    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getLesseeId() {
        return lesseeId;
    }

    public void setLesseeId(Long lesseeId) {
        this.lesseeId = lesseeId;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
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

    public Short getOverdue() {
        return overdue;
    }

    public void setOverdue(Short overdue) {
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

    public Date getHistoryCreateTime() {
        return historyCreateTime;
    }

    public void setHistoryCreateTime(Date historyCreateTime) {
        this.historyCreateTime = historyCreateTime;
    }

    public Date getHistoryUpdateTime() {
        return historyUpdateTime;
    }

    public void setHistoryUpdateTime(Date historyUpdateTime) {
        this.historyUpdateTime = historyUpdateTime;
    }

    public Long getHistoryCreateBy() {
        return historyCreateBy;
    }

    public void setHistoryCreateBy(Long historyCreateBy) {
        this.historyCreateBy = historyCreateBy;
    }

    public Long getHistoryUpdateBy() {
        return historyUpdateBy;
    }

    public void setHistoryUpdateBy(Long historyUpdateBy) {
        this.historyUpdateBy = historyUpdateBy;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getVsersionNumber() {
        return vsersionNumber;
    }

    public void setVsersionNumber(Integer vsersionNumber) {
        this.vsersionNumber = vsersionNumber;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}