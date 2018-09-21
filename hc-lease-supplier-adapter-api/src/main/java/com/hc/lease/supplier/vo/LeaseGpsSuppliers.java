package com.hc.lease.supplier.vo;

import com.hc.lease.supplier.model.LeaseCarSupplier;
import com.hc.lease.supplier.model.LeaseGpsSupplier;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseGpsSuppliers implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseGpsSupplier> leaseGpsSuppliers;


    public List<LeaseGpsSupplier> getLeaseGpsSuppliers() {
        return leaseGpsSuppliers;
    }

    public void setLeaseGpsSuppliers(List<LeaseGpsSupplier> leaseGpsSuppliers) {
        this.leaseGpsSuppliers = leaseGpsSuppliers;
    }
}