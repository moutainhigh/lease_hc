package com.hc.lease.common.core.constant;

/**
 * 收入和支出 类型
 * Created by tong on 2018/4/10.
 */
public enum IncomeExpeType {

    IN(0, "收入"),
    OUT(1, "支出、成本");

    private Integer value;

    private String description;

    private IncomeExpeType(Integer value, String description) {
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
