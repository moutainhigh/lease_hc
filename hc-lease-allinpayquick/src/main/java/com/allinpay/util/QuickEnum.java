package com.allinpay.util;

/**
 * 协议支付业务状态码
 *
 * @author tong
 * @date 2018/4/18
 * @Description
 */
public enum QuickEnum {
    TRX_CODE_310001("310001", "协议支付签约短信触发"),
    TRX_CODE_310002("310002", "协议支付签约"),
    TRX_CODE_310003("310003", "协议支付解约"),
    TRX_CODE_310011("310011", "协议支付"),
    TRX_CODE_200004("200004", "查询结果");

    private String code;
    private String name;

    QuickEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
