package com.hc.lease.common.core.constant;

/**
 * 收车处置方案
 * Created by tong on 2018/8/9
 */
public enum CallbackDealWay {

    CallbackDealWay_0(0, DealStatus.Deal_Status_10.value(), CarCondition.CarCondition_1.value(), "已回收待处置"),
    CallbackDealWay_1(1, DealStatus.Deal_Status_11.value(), CarCondition.CarCondition_1.value(), "退回"),
    CallbackDealWay_2(2, DealStatus.Deal_Status_12.value(), CarCondition.CarCondition_1.value(), "待改期数"),
    CallbackDealWay_3(3, DealStatus.Deal_Status_13.value(), CarCondition.CarCondition_2.value(), "断供（待转租/待转卖）"),
    CallbackDealWay_4(4, DealStatus.Deal_Status_14.value(), CarCondition.CarCondition_1.value(), "取消回收");


    private Integer value;

    private String dealStatus;

    private Integer carCondition;

    private String description;

    private CallbackDealWay(Integer value, String dealStatus, Integer carCondition, String description) {
        this.value = value;
        this.dealStatus = dealStatus;
        this.carCondition = carCondition;
        this.description = description;
    }

    /**
     * 贷后车辆处置方案状态
     *
     * @param value
     * @return
     */
    public static String getDealStatusValue(Integer value) {
        for (CallbackDealWay c : CallbackDealWay.values()) {
            if (c.getValue() == value) {
                return c.dealStatus;
            }
        }
        return null;
    }

    /**
     * 车况 1新车 2次新车、二手车
     *
     * @param value
     * @return
     */
    public static Integer getCarConditionValue(Integer value) {
        for (CallbackDealWay c : CallbackDealWay.values()) {
            if (c.getValue() == value) {
                return c.carCondition;
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

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    public Integer getCarCondition() {
        return carCondition;
    }

    public void setCarCondition(Integer carCondition) {
        this.carCondition = carCondition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
