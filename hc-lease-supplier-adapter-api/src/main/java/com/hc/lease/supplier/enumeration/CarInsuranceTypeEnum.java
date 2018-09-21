package com.hc.lease.supplier.enumeration;

import lombok.Getter;

/**
 * 车辆保险类型
 * Created by LJ on 2018/4/17
 */
@Getter
public enum CarInsuranceTypeEnum {

    /**
     * 交强险
     */
    trafficCompelInsurance(0, "交强险"),

    /**
     * 商业险
     */
    businessInsurance(1, "商业险"),;

    private Integer value;

    private String name;

    CarInsuranceTypeEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
}
