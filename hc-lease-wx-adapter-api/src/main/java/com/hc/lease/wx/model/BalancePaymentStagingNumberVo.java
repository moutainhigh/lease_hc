package com.hc.lease.wx.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BalancePaymentStagingNumberVo  implements Serializable{

    @ApiModelProperty(value = "月租", hidden = false)
    private BigDecimal monthlyRent;
    @ApiModelProperty(value = "分期数", hidden = false)
    private Integer stagingNumber;

    public BigDecimal getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public Integer getStagingNumber() {
        return stagingNumber;
    }

    public void setStagingNumber(Integer stagingNumber) {
        this.stagingNumber = stagingNumber;
    }
}