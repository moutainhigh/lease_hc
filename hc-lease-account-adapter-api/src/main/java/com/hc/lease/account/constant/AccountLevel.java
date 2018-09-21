package com.hc.lease.account.constant;

import lombok.Getter;

/**
 * 承租人评级
 *
 * @author xuzhencheng
 * @since 2018-01-16
 */
@Getter
public enum AccountLevel {
    /**无*/
    NULL("", "无"),
    /**A级*/
    A("A", "A级"),
    /**B级*/
    B("B", "B级"),
    /**C级*/
    C("C", "C级"),

    ///
    ;

    /**值*/
    String val;
    /**描述*/
    String desc;

    AccountLevel(String val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public static AccountLevel parse(String val) {
        if (val != null) {
            for (AccountLevel item : AccountLevel.values()) {
                if (item.getVal().equals(val)) {
                    return item;
                }
            }
        }
        return null;
    }
}
