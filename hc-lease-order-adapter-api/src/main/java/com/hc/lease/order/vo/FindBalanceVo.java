package com.hc.lease.order.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 融租合同的尾付
 * Created by Administrator on 2017/9/28.
 */
public class FindBalanceVo implements Serializable {

    @ApiModelProperty(value = "融租合同 提前还款主键id", hidden = false)
    private Long repaymentId;
    @ApiModelProperty(value = "融租合同主键id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "尾款金额", hidden = false)
    private BigDecimal balancePayment;
    @ApiModelProperty(value = "是否有尾付 0:否 1:是", hidden = false)
    private Integer isBalancePayment;
    @ApiModelProperty(value = "款项类型 0:月供; 1:逾期滞纳金;  2: 挂靠费; 3:提前还款/剩余本金; 4:尾款/还款到最后一期的尾款; 5:提前还款罚款; 6:尾款/提前还款的尾款", hidden = false)
    private Integer type;

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

    public BigDecimal getBalancePayment() {
        return balancePayment;
    }

    public void setBalancePayment(BigDecimal balancePayment) {
        this.balancePayment = balancePayment;
    }

    public Integer getIsBalancePayment() {
        return isBalancePayment;
    }

    public void setIsBalancePayment(Integer isBalancePayment) {
        this.isBalancePayment = isBalancePayment;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
