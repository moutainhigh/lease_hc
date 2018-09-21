package com.hc.lease.common.core.constant;

/**
 * 收车方式
 * Created by tong on 2018/8/9
 */
public enum CallbackWay {

    CallbackWay_0(0, "客户交回"),
    CallbackWay_1(1, "赎车收回"),
    CallbackWay_2(2, "委托收回"),
    CallbackWay_3(3, "自主收回");


    private Integer value;

    private String description;

    private CallbackWay(Integer value, String description) {
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
