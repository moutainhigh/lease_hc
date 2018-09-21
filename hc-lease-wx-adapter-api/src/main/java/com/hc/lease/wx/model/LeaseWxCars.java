package com.hc.lease.wx.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeaseWxCars implements Serializable {

    @ApiModelProperty(value = "用于修改排序", hidden = false)
   private List<LeaseWxCar> leaseWxCars;


    public List<LeaseWxCar> getLeaseWxCars() {
        return leaseWxCars;
    }

    public void setLeaseWxCars(List<LeaseWxCar> leaseWxCars) {
        this.leaseWxCars = leaseWxCars;
    }
}