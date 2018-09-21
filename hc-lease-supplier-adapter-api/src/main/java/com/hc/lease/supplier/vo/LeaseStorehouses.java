package com.hc.lease.supplier.vo;

import com.hc.lease.supplier.model.LeaseCarSupplier;
import com.hc.lease.supplier.model.LeaseStorehouse;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseStorehouses implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseStorehouse> leaseStorehouses;


    public List<LeaseStorehouse> getLeaseStorehouses() {
        return leaseStorehouses;
    }

    public void setLeaseStorehouses(List<LeaseStorehouse> leaseStorehouses) {
        this.leaseStorehouses = leaseStorehouses;
    }
}