package com.hc.lease.supplier.vo;

import com.hc.lease.supplier.model.LeaseAgentsLevel;
import com.hc.lease.supplier.model.LeaseCarSupplier;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseAgentsLevels implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseAgentsLevel> leaseAgentsLevels;


    public List<LeaseAgentsLevel> getLeaseAgentsLevels() {
        return leaseAgentsLevels;
    }

    public void setLeaseAgentsLevels(List<LeaseAgentsLevel> leaseAgentsLevels) {
        this.leaseAgentsLevels = leaseAgentsLevels;
    }
}