package com.hc.lease.common.core.constant;

/**
 * 代收状态流水 类型 0:提交通联单笔扣款的结果;1:提交通联批量扣款的结果;2:轮询通联单笔扣款的结果;3:轮询通联批量扣款的结果
 * Created by tong on 2017/11/3.
 */
public class AllinpayStatusLogType {
    //提交通联单笔扣款(代扣)的结果
    public static final Integer TYPE_0 = 0;
    //提交通联批量扣款(代扣)的结果
    public static final Integer TYPE_1 = 1;
    //轮询通联单笔扣款(代扣)的结果
    public static final Integer TYPE_2 = 2;
    //轮询通联批量扣款(代扣)的结果
    public static final Integer TYPE_3 = 3;
    //提交通联单笔扣款(协议支付)的结果
    public static final Integer TYPE_4 = 4;
    //提交通联批量扣款(协议支付)的结果
    public static final Integer TYPE_5 = 5;

    //提交通联支付拆单 批量协议支付(协议支付)的结果
    public static final Integer TYPE_6 = 6;

    //提交通联支付拆单 单笔协议支付(协议支付)的结果
    public static final Integer TYPE_7 = 7;

    //线下等级
    public static final Integer TYPE_8 = 8;

    //手动扣款(协议支付)的结果
    public static final Integer TYPE_9 = 9;

}
