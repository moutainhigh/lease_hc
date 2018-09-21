package com.hc.lease.common.core.constant;

/**
 * 贷后代收
 * 策略模式 使用的 枚举参数
 * Created by Administrator on 2017/8/28.
 */
public enum StrategyType {
    TYPE_0(0, "月供"),
    TYPE_1(1, "挂靠费"),
    TYPE_2(2, "逾期滞纳金"),
    TYPE_3(3, "提前还款/剩余本金"),
    TYPE_4(4, "尾款/还款到最后一期的尾款"),
    TYPE_5(5, "提前还款罚款"),
    TYPE_6(6, "尾款/提前还款的尾款"),
    TYPE_7(7, "其他款项");

    private int value;


    private String description;


    private StrategyType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int value() {
        return value;
    }

    public String description() {
        return description;
    }


    public static StrategyType valueOf(int value) {
        for (StrategyType type : StrategyType.values()) {
            if (type.value() == value) {
                return type;
            }
        }
        return null;
    }
}
