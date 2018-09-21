package com.hc.lease.common.core.constant;

/**
 * 方案期数类型 1为系统 2为定制
 * Created by tong on 2018/8/21
 */
public enum StagingNumberType {

    CallbackWay_1(1, "系统"),
    CallbackWay_2(2, "定制");

    private Integer value;

    private String description;

    private StagingNumberType(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public Integer value() {
        return value;
    }

    public String description() {
        return description;
    }

}
