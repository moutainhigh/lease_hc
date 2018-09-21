package com.hc.lease.common.core.constant;

/**
 * 策略模式 使用的 枚举参数
 * 通联协议支付 授权签约
 * Created by tong on 2018/4/26.
 */
public enum AccountBankCardSignStrategyType {

    TYPE_0(0, "系统承租人授权"),
    TYPE_1(1, "新增承租人授权");

    private int value;


    private String description;


    private AccountBankCardSignStrategyType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int value() {
        return value;
    }

    public String description() {
        return description;
    }


    public static AccountBankCardSignStrategyType valueOf(int value) {
        for (AccountBankCardSignStrategyType type : AccountBankCardSignStrategyType.values()) {
            if (type.value() == value) {
                return type;
            }
        }
        return null;
    }
}
