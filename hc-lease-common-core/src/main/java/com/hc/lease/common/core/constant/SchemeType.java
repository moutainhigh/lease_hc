package com.hc.lease.common.core.constant;

/**
 * 方案报价类型
 * Created by tong on 2018/8/9
 */
public enum SchemeType {

    SchemeType_0(0, "分期"),
    SchemeType_1(1, "1+X"),
    SchemeType_2(2, "年度尾款"),
    SchemeType_3(3, "纯租");


    private Integer value;

    private String description;

    private SchemeType(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public static String getDealStatusValue(Integer value) {
        for (SchemeType c : SchemeType.values()) {
            if (c.getValue() == value) {
                return c.description;
            }
        }
        return null;
    }

    public Integer value() {
        return value;
    }

    public String description() {
        return description;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
