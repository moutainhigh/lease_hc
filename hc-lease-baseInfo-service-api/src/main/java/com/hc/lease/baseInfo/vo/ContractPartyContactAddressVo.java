package com.hc.lease.baseInfo.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 出租人联系地址
 * Created by Tong on 2017/4/19.
 */
public class ContractPartyContactAddressVo implements Serializable {

    @ApiModelProperty(value = "详细地址", hidden = false)
    private String address;

    public ContractPartyContactAddressVo() {
    }

    public ContractPartyContactAddressVo(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
