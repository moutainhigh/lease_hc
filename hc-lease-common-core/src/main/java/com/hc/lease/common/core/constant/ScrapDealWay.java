package com.hc.lease.common.core.constant;

/**
 * 报废处置方案
 * Created by tong on 2018/8/9
 */
public enum ScrapDealWay {

    ScrapDealWay_0(0, DealStatus.Deal_Status_30.value(), "登记为报废中"),
    ScrapDealWay_1(1, DealStatus.Deal_Status_31.value(), "报废结束"),
    ScrapDealWay_2(2, DealStatus.Deal_Status_32.value(), "取消报废登记");


    private Integer value;

    private String description;

    private String dealStatus;

    private ScrapDealWay(Integer value, String dealStatus, String description) {
        this.value = value;
        this.description = description;
        this.dealStatus = dealStatus;
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
}
