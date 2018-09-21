package com.hc.lease.baseInfo.vo;

import com.hc.lease.baseInfo.model.LeaseBranchCompany;
import com.hc.lease.baseInfo.model.LeaseCarColor;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseCarColors implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseCarColor> leaseCarColors;


    public List<LeaseCarColor> getLeaseCarColors() {
        return leaseCarColors;
    }

    public void setLeaseCarColors(List<LeaseCarColor> leaseCarColors) {
        this.leaseCarColors = leaseCarColors;
    }
}