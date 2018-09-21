package com.hc.lease.supplier.vo;

import com.hc.lease.supplier.model.LeaseInsuranceCompany;
import com.hc.lease.supplier.model.LeaseInsuranceType;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseInsuranceTypes implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseInsuranceType> leaseInsuranceTypes;


    public List<LeaseInsuranceType> getLeaseInsuranceTypes() {
        return leaseInsuranceTypes;
    }

    public void setLeaseInsuranceTypes(List<LeaseInsuranceType> leaseInsuranceTypes) {
        this.leaseInsuranceTypes = leaseInsuranceTypes;
    }
}