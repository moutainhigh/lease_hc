package com.hc.lease.postlending.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 扣款改动的逾期天数
 * Created by Administrator on 2017/8/30.
 */
public class PaymentOverdueVo implements Serializable {
    @ApiModelProperty(value = "款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款主键id", hidden = false)
    private Long repaymentId;
    @ApiModelProperty(value = "融租合同主键id", hidden = false)
    private Long contractId;

    @ApiModelProperty(value = "逾期天数，扣款的时候改动的实际逾期天数", hidden = false)
    private Integer realOverdueDay;
    @ApiModelProperty(value = "逾期金额，扣款的时候改动的实际逾期金额", hidden = false)
    private BigDecimal realPrice;

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

    @Override
    public String toString() {
        return "PaymentOverdueVo{" +
                "repaymentId=" + repaymentId +
                ", contractId=" + contractId +
                ", realOverdueDay=" + realOverdueDay +
                ", realPrice=" + realPrice +
                '}';
    }
}
