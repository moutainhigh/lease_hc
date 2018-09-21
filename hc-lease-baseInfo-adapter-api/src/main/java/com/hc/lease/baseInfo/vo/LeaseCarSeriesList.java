package com.hc.lease.baseInfo.vo;

import com.hc.lease.baseInfo.model.LeaseCarBrands;
import com.hc.lease.baseInfo.model.LeaseCarSeries;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseCarSeriesList implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseCarSeries>  leaseCarSeriesList;


    public List<LeaseCarSeries> getLeaseCarSeriesList() {
        return leaseCarSeriesList;
    }

    public void setLeaseCarSeriesList(List<LeaseCarSeries> leaseCarSeriesList) {
        this.leaseCarSeriesList = leaseCarSeriesList;
    }
}