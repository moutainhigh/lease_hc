package com.hc.lease.baseInfo.vo;

import com.hc.lease.baseInfo.model.LeaseArchiveLocation;
import com.hc.lease.baseInfo.model.LeaseMaintenancePartner;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseMaintenancePartners implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseMaintenancePartner> leaseMaintenancePartners;

    public List<LeaseMaintenancePartner> getLeaseMaintenancePartners() {
        return leaseMaintenancePartners;
    }

    public void setLeaseMaintenancePartners(List<LeaseMaintenancePartner> leaseMaintenancePartners) {
        this.leaseMaintenancePartners = leaseMaintenancePartners;
    }
}