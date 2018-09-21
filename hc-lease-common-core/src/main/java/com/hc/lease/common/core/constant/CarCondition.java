package com.hc.lease.common.core.constant;

/**
 * 车况 1新车 2次新车、二手车
 * Created by tong on 2018/8/10
 */
public enum CarCondition {

    CarCondition_1(1, "新车"),
    CarCondition_2(2, "次新车");


    private Integer value;

    private String description;

    private CarCondition(Integer value, String description) {
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
