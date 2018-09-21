package com.hc.lease.wx.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseWxHomeImgs implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseWxHomeImg> leaseWxHomeImgs;


    public List<LeaseWxHomeImg> getLeaseWxHomeImgs() {
        return leaseWxHomeImgs;
    }

    public void setLeaseWxHomeImgs(List<LeaseWxHomeImg> leaseWxHomeImgs) {
        this.leaseWxHomeImgs = leaseWxHomeImgs;
    }
}