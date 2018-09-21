package com.hc.lease.supplier.vo;

import com.hc.lease.supplier.model.LeaseCarSupplier;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseCarSuppliers implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseCarSupplier> leaseCarSuppliers;


    public List<LeaseCarSupplier> getLeaseCarSuppliers() {
        return leaseCarSuppliers;
    }

    public void setLeaseCarSuppliers(List<LeaseCarSupplier> leaseCarSuppliers) {
        this.leaseCarSuppliers = leaseCarSuppliers;
    }
}