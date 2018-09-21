package com.aipg.quickpay;

/**
 * 通联协议支付 证件类型
 *
 * @author tong
 * @date 2018/4/18
 * @Description
 */
public enum AllinpayIdTypeEnum {
    ID_TYPE_0("0", "身份证"),
    ID_TYPE_1("1", "户口簿"),
    ID_TYPE_2("2", "护照"),
    ID_TYPE_3("3", "军官证"),
    ID_TYPE_4("4", "士兵证"),
    ID_TYPE_5("5", "港澳居民来往内地通行证"),
    ID_TYPE_6("6", "台湾同胞来往内地通行证"),
    ID_TYPE_7("7", "临时身份证"),
    ID_TYPE_8("8", "外国人居留证"),
    ID_TYPE_9("9", "警官证"),
    ID_TYPE_X("X", "其他证件");

    private String code;
    private String name;

    AllinpayIdTypeEnum(String code, String name) {
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
