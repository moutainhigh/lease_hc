package com.hc.lease.baseInfo.vo;

import com.hc.lease.baseInfo.model.LeaseBranchCompany;
import com.hc.lease.supplier.model.LeaseCarSupplier;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseBranchCompanys implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseBranchCompany> leaseBranchCompanies;


    public List<LeaseBranchCompany> getLeaseBranchCompanies() {
        return leaseBranchCompanies;
    }

    public void setLeaseBranchCompanies(List<LeaseBranchCompany> leaseBranchCompanies) {
        this.leaseBranchCompanies = leaseBranchCompanies;
    }
}