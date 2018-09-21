package com.hc.lease.baseInfo.vo;

import com.hc.lease.baseInfo.model.LeaseBranchCompany;
import com.hc.lease.baseInfo.model.LeaseCarBrands;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseCarBrandses implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseCarBrands>  leaseCarBrandses;


    public List<LeaseCarBrands> getLeaseCarBrandses() {
        return leaseCarBrandses;
    }

    public void setLeaseCarBrandses(List<LeaseCarBrands> leaseCarBrandses) {
        this.leaseCarBrandses = leaseCarBrandses;
    }
}