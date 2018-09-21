package com.aipg.quickpay;

/**
 * 通联协议支付 银行卡 用户类型
 *
 * @author tong
 * @date 2018/4/18
 * @Description
 */
public enum AllinpayAccountTypeEnum {
    BANK_CARD("00", "银行卡"),
    BANK_BOOK("01", "存折"),
    CREDIT_CARD("02", "信用卡");

    private String code;
    private String name;

    AllinpayAccountTypeEnum(String code, String name) {
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
