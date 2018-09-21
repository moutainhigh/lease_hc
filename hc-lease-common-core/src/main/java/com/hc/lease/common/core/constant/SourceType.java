package com.hc.lease.common.core.constant;

/**
 * 合同来源类型 0 原始合同 1 改期数 2 续期 3 转租
 * Created by tong on 2018/8/9
 */
public enum SourceType {

    SchemeType_0(0, "原始合同"),
    SchemeType_1(1, "改期数"),
    SchemeType_2(2, "续期"),
    SchemeType_3(3, "转租");


    private Integer value;

    private String description;

    private SourceType(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public static String getDealStatusValue(Integer value) {
        for (SourceType c : SourceType.values()) {
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
