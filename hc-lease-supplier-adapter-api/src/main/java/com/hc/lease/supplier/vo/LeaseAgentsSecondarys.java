package com.hc.lease.supplier.vo;

import com.hc.lease.supplier.model.LeaseAgentsLevel;
import com.hc.lease.supplier.model.LeaseAgentsSecondary;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseAgentsSecondarys implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseAgentsSecondary> leaseAgentsSecondaries;


    public List<LeaseAgentsSecondary> getLeaseAgentsSecondaries() {
        return leaseAgentsSecondaries;
    }

    public void setLeaseAgentsSecondaries(List<LeaseAgentsSecondary> leaseAgentsSecondaries) {
        this.leaseAgentsSecondaries = leaseAgentsSecondaries;
    }
}