package com.hc.lease.common.core.constant;

/**
 * 合同结束处置方案
 * Created by tong on 2018/8/9
 */
public enum ContractEndDealWay {

    ContractEndDealWay_0(0, DealStatus.Deal_Status_40.value(), "还款中"),
    ContractEndDealWay_1(1, DealStatus.Deal_Status_41.value(), "待过户"),
    ContractEndDealWay_2(2, DealStatus.Deal_Status_42.value(), "过户结束"),
    ContractEndDealWay_3(3, DealStatus.Deal_Status_43.value(), "待挂靠结束"),
    ContractEndDealWay_4(4, DealStatus.Deal_Status_44.value(), "提前还款结束"),
    ContractEndDealWay_5(5, DealStatus.Deal_Status_45.value(), "其他到期结束");


    private Integer value;

    private String description;

    private String dealStatus;

    private ContractEndDealWay(Integer value, String dealStatus, String description) {
        this.value = value;
        this.description = description;
        this.dealStatus = dealStatus;
    }

    public static String getDealStatusValue(Integer value) {
        for (ContractEndDealWay c : ContractEndDealWay.values()) {
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
