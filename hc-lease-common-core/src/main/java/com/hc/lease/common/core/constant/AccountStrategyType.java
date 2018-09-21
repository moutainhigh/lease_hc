package com.hc.lease.common.core.constant;

/**
 * 策略模式 使用的 枚举参数
 * Created by Administrator on 2017/8/28.
 */
public enum AccountStrategyType {

    TYPE_0(0, "个人类型用户/承租人"),
    TYPE_1(1, "公司类型用户/承租人");

    private int value;


    private String description;


    private AccountStrategyType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int value() {
        return value;
    }

    public String description() {
        return description;
    }


    public static AccountStrategyType valueOf(int value) {
        for (AccountStrategyType type : AccountStrategyType.values()) {
            if (type.value() == value) {
                return type;
            }
        }
        return null;
    }
}
