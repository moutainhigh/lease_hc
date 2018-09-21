package com.hc.lease.order.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 租金支付表 / 融租合同-月租还款计划明细
 * Created by Administrator on 2017/8/30.
 */
public class FindByRepaymentDateVo implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "融租合同主键id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "合计、月租、滞纳金", hidden = false)
    private BigDecimal total;
    @ApiModelProperty(value = "承租人主键id", hidden = false)
    private Long lesseeId;
    @ApiModelProperty(value = "款项类型 0:月租;2:滞纳金;4:尾款/还款到最后一期的尾款;6:尾款/提前还款的尾款", hidden = false)
    private Integer type;
    @ApiModelProperty(value = "是否逾期 0是 1否", hidden = false)
    private Integer overdue;
    @ApiModelProperty(value = "逾期天数", hidden = false)
    private Integer overdueDay;

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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Long getLesseeId() {
        return lesseeId;
    }

    public void setLesseeId(Long lesseeId) {
        this.lesseeId = lesseeId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
}
