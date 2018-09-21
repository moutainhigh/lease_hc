package com.hc.lease.common.core.constant;

/**
 * 合同报价方案类型 0:默认套餐;1:定制套餐
 * Created by tong on 2018/8/17
 */
public enum SchemePriceType {

    SchemeType_0(0, "默认套餐"),
    SchemeType_1(1, "定制套餐");


    private Integer value;

    private String description;

    private SchemePriceType(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public static String getDealStatusValue(Integer value) {
        for (SchemePriceType c : SchemePriceType.values()) {
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
