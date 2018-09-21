package com.hc.lease.baseInfo.vo;

import com.hc.lease.baseInfo.model.LeaseCarBrands;
import com.hc.lease.baseInfo.model.LeaseCarModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseCarModels implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseCarModel>  leaseCarModels;


    public List<LeaseCarModel> getLeaseCarModels() {
        return leaseCarModels;
    }

    public void setLeaseCarModels(List<LeaseCarModel> leaseCarModels) {
        this.leaseCarModels = leaseCarModels;
    }
}