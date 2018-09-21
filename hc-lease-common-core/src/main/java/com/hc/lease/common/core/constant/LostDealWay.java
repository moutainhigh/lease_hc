package com.hc.lease.common.core.constant;

/**
 * 丢失处置方案
 * Created by tong on 2018/8/9
 */
public enum LostDealWay {

    LostDealWay_0(0, DealStatus.Deal_Status_20.value(), "丢失中"),
    LostDealWay_1(1, DealStatus.Deal_Status_21.value(), "找回续租"),
    LostDealWay_2(2, DealStatus.Deal_Status_22.value(), "找回断供（待转租/待转卖）"),
    LostDealWay_3(3, DealStatus.Deal_Status_23.value(), "丢失结束"),
    LostDealWay_4(4, DealStatus.Deal_Status_24.value(), "取消丢失");


    private Integer value;

    private String description;

    private String dealStatus;

    private LostDealWay(Integer value, String dealStatus, String description) {
        this.value = value;
        this.description = description;
        this.dealStatus = dealStatus;
    }

    public static String getDealStatusValue(Integer value) {
        for (LostDealWay c : LostDealWay.values()) {
            if (c.getValue() == value) {
                return c.dealStatus;
            }
        }
        return null;
    }

    public Integer value() {
        return value;
    }

    public String description() {
        return description;
    }

    public String dealStatus() {
        return dealStatus;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }
}
