package com.hc.lease.supplier.enumeration;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/9/12<br/>
 * 说明：公用状态
 */
public enum  PublicStatusEnum {
    /**
     * 是
     */
    S("S","是"),
    /**
     * 否
     */
    F("F","否"),
    ;
    private String stringValue;
    private String chineseName;

    PublicStatusEnum(String stringValue, String chineseName) {
        this.stringValue = stringValue;
        this.chineseName = chineseName;
    }

    public String getStringValue() {
        return stringValue;
    }

    public String getChineseName() {
        return chineseName;
    }
}
