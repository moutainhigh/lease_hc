package com.hc.lease.common.core.constant;

/**
 * 贷后车辆处置方案状态
 * Created by tong on 2018/8/9
 */
public enum DealStatus {
    //合同
    Deal_Status_00("0-0", "还款中"),
    Deal_Status_01("0-1", "挂靠中"),
    Deal_Status_02("0-2", "已结束"),
    Deal_Status_03("0-3", "未开始还款"),
    Deal_Status_04("0-4", "提前还款"),

    //收车
    Deal_Status_10("1-0", "已回收待处置"),
    Deal_Status_11("1-1", "退回"),
    Deal_Status_12("1-2", "待改期数"),
    Deal_Status_13("1-3", "断供（待转租/待转卖）"),
    Deal_Status_14("1-4", "取消回收"),

    //丢失
    Deal_Status_20("2-0", "丢失中"),
    Deal_Status_21("2-1", "找回续租"),
    Deal_Status_22("2-2", "找回断供（待转租/待转卖）"),
    Deal_Status_23("2-3", "丢失结束"),
    Deal_Status_24("2-4", "取消丢失"),

    //报废
    Deal_Status_30("3-0", "登记为报废中"),
    Deal_Status_31("3-1", "报废结束"),
    Deal_Status_32("3-2", "取消报废登记"),

    //结束处置
    Deal_Status_40("4-0", "还款中"),
    Deal_Status_41("4-1", "待过户"),
    Deal_Status_42("4-2", "过户结束"),
    Deal_Status_43("4-3", "待挂靠结束"),
    Deal_Status_44("4-4", "提前还款结束"),
    Deal_Status_45("4-5", "其他到期结束"),

    //改期数
    Deal_Status_60("6-0", "改期数"),

    //续期
    Deal_Status_70("7-0", "续期"),

    //转租
    Deal_Status_80("8-0", "转租");

    private String value;

    private String description;

    private DealStatus(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String value() {
        return value;
    }

    public String description() {
        return description;
    }

}
