package com.hc.lease.supplier.vo;

import com.hc.lease.supplier.model.LeaseCarSupplier;
import com.hc.lease.supplier.model.LeaseInsuranceCompany;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseInsuranceCompanys implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseInsuranceCompany> leaseInsuranceCompanies;


    public List<LeaseInsuranceCompany> getLeaseInsuranceCompanies() {
        return leaseInsuranceCompanies;
    }

    public void setLeaseInsuranceCompanies(List<LeaseInsuranceCompany> leaseInsuranceCompanies) {
        this.leaseInsuranceCompanies = leaseInsuranceCompanies;
    }
}