package com.hc.lease.baseInfo.vo;

import com.hc.lease.baseInfo.model.LeaseCompanyHeader;
import com.hc.lease.baseInfo.model.LeaseMaintenancePartner;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseCompanyHeaders implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseCompanyHeader> leaseCompanyHeaders;

    public List<LeaseCompanyHeader> getLeaseCompanyHeaders() {
        return leaseCompanyHeaders;
    }

    public void setLeaseCompanyHeaders(List<LeaseCompanyHeader> leaseCompanyHeaders) {
        this.leaseCompanyHeaders = leaseCompanyHeaders;
    }
}