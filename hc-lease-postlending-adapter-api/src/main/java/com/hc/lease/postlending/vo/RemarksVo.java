package com.hc.lease.postlending.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 扣款提交的备注
 * Created by tong on 2018/5/15.
 */
public class RemarksVo implements Serializable {
    @ApiModelProperty(value = "款项主键id，融租合同-还款计划明细主键id", hidden = false)
    private Long repaymentId;
    @ApiModelProperty(value = "融租合同主键id", hidden = false)
    private Long contractId;

    @ApiModelProperty(value = "备注", hidden = false)
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
