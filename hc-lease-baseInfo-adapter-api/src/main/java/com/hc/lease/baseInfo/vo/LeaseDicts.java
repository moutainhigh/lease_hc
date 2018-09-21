package com.hc.lease.baseInfo.vo;

import com.hc.lease.baseInfo.model.LeaseCarColor;
import com.hc.lease.baseInfo.model.LeaseDict;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseDicts implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseDict> leaseDicts;


    public List<LeaseDict> getLeaseDicts() {
        return leaseDicts;
    }

    public void setLeaseDicts(List<LeaseDict> leaseDicts) {
        this.leaseDicts = leaseDicts;
    }
}