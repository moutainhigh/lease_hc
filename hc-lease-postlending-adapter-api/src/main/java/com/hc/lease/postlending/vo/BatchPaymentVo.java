package com.hc.lease.postlending.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 通联批扣提交的 所有月租 和 所有 滞纳金
 * Created by Tong on 2017/12/20.
 */
public class BatchPaymentVo implements Serializable {
    @ApiModelProperty(value = "还款计划明细主键id", hidden = false)
    private Long repaymentId;
    @ApiModelProperty(value = "融租合同主键id", hidden = false)
    private Long contractId;

    @ApiModelProperty(value = "逾期天数，扣款的时候改动的实际逾期天数", hidden = false)
    private Integer realOverdueDay;
    @ApiModelProperty(value = "逾期金额，扣款的时候改动的实际逾期金额", hidden = false)
    private BigDecimal realPrice;

    @ApiModelProperty(value = "其他金额，扣款的时候输入的其他金额", hidden = false)
    private BigDecimal other;
    @ApiModelProperty(value = "备注，扣款的时候输入的备注", hidden = false)
    private String remarks;

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

    public BigDecimal getOther() {
        return other;
    }

    public void setOther(BigDecimal other) {
        this.other = other;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
