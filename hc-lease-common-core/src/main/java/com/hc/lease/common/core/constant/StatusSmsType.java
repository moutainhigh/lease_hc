package com.hc.lease.common.core.constant;

/**
 * 短信类型：0-0:通联轮询-扣款失败通知 ; 1-0:自动提前扣款提醒(还款日期7天前) ; 1-1:自动提前扣款提醒(还款日期3天前) ; 2-0:手动发送逾期提醒
 * Created by tong on 2017/12/8.
 */
public class StatusSmsType {
    //通联轮询-扣款失败通知
    public static final String TYPE_0_0 = "0-0";
    //自动提前扣款提醒(还款日期7天前)
    public static final String TYPE_1_0 = "1-0";
    //自动提前扣款提醒(还款日期3天前)
    public static final String TYPE_1_1 = "1-1";
    //手动发送逾期提醒
    public static final String TYPE_2_0 = "2-0";
}
