package com.hc.lease.baseInfo.vo;

import com.hc.lease.baseInfo.model.LeaseCarBrands;
import com.hc.lease.baseInfo.model.LeaseCarBuyFinancinger;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseCarBuyFinancingers implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseCarBuyFinancinger>  leaseCarBuyFinancingers;


    public List<LeaseCarBuyFinancinger> getLeaseCarBuyFinancingers() {
        return leaseCarBuyFinancingers;
    }

    public void setLeaseCarBuyFinancingers(List<LeaseCarBuyFinancinger> leaseCarBuyFinancingers) {
        this.leaseCarBuyFinancingers = leaseCarBuyFinancingers;
    }
}