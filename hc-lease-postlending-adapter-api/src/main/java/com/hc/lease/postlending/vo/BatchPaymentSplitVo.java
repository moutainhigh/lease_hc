package com.hc.lease.postlending.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 通联支付拆单 批量协议支付 提交的 所有月租 和 所有 滞纳金
 * Created by Tong on 2017/12/20.
 */
public class BatchPaymentSplitVo implements Serializable {
    @ApiModelProperty(value = "还款计划明细主键id", hidden = false)
    private Long repaymentId;
    @ApiModelProperty(value = "融租合同主键id", hidden = false)
    private Long contractId;

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

}
