package com.aipg.quickpay;

import java.io.Serializable;

/**
 * 通联协议支付签约 类型: 0系统承租人授权、1:新增承租人授权
 *
 * @author tong
 * @date 2018/4/18
 * @Description
 */
public enum QuickSendTypeEnum implements Serializable {
    TYPE_0(0, "系统承租人签约"),
    TYPE_1(1, "新增承租人签约");

    private Integer code;
    private String name;

    QuickSendTypeEnum(Integer code, String name) {
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
