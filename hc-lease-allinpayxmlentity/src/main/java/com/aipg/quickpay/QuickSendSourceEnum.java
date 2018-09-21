package com.aipg.quickpay;

import java.io.Serializable;

/**
 * 通联协议支付签约 操作来源: 0系统承租人授权、1:新增承租人授权
 *
 * @author tong
 * @date 2018/4/18
 * @Description
 */
public enum QuickSendSourceEnum implements Serializable {
    SOURCE_0(0, "后台系统操作"),
    SOURCE_1(1, "小程序网页操作");

    private Integer code;
    private String name;

    QuickSendSourceEnum(Integer code, String name) {
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
