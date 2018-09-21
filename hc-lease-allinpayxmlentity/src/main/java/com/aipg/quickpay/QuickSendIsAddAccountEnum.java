package com.aipg.quickpay;

import java.io.Serializable;

/**
 * 通联协议支付签约 成为承租人：1:是;0:否
 *
 * @author tong
 * @date 2018/4/18
 * @Description
 */
public enum QuickSendIsAddAccountEnum implements Serializable {
    TYPE_0(0, "否"),
    TYPE_1(1, "是");

    private Integer code;
    private String name;

    QuickSendIsAddAccountEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
