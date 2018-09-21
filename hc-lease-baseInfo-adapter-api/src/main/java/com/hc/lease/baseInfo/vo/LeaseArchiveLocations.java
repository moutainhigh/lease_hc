package com.hc.lease.baseInfo.vo;

import com.hc.lease.baseInfo.model.LeaseArchiveLocation;
import com.hc.lease.baseInfo.model.LeaseCarColor;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseArchiveLocations implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseArchiveLocation> leaseArchiveLocations;

    public List<LeaseArchiveLocation> getLeaseArchiveLocations() {
        return leaseArchiveLocations;
    }

    public void setLeaseArchiveLocations(List<LeaseArchiveLocation> leaseArchiveLocations) {
        this.leaseArchiveLocations = leaseArchiveLocations;
    }
}