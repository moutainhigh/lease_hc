package com.hc.lease.common.core.constant;

/**
 * 收入和支出 类型
 * Created by tong on 2018/4/10.
 */
public enum IncomeExpeSource {

    LOST(1, "丢失"),
    SCRAP(2, "报废"),
    DEAL_END(3, "结束处置");

    private Integer value;

    private String description;

    private IncomeExpeSource(Integer value, String description) {
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
