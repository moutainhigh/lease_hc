package com.hc.lease.supplier.vo;

import com.hc.lease.supplier.model.LeaseAgents;
import com.hc.lease.supplier.model.LeaseAgentsLevel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseAgentsList implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseAgents> leaseAgentses;


    public List<LeaseAgents> getLeaseAgentses() {
        return leaseAgentses;
    }

    public void setLeaseAgentses(List<LeaseAgents> leaseAgentses) {
        this.leaseAgentses = leaseAgentses;
    }
}