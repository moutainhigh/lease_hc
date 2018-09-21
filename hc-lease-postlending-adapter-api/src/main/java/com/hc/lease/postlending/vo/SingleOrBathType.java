package com.hc.lease.postlending.vo;

/**
 * 单笔或批量 枚举参数
 * Created by Administrator on 2017/8/28.
 */
public enum SingleOrBathType {

    TYPE_0(0, "单笔"),
    TYPE_1(1, "批量");

    private int value;


    private String description;


    private SingleOrBathType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int value() {
        return value;
    }

    public String description() {
        return description;
    }


    public static SingleOrBathType valueOf(int value) {
        for (SingleOrBathType type : SingleOrBathType.values()) {
            if (type.value() == value) {
                return type;
            }
        }
        return null;
    }
}
