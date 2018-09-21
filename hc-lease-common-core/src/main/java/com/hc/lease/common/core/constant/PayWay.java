package com.hc.lease.common.core.constant;

/**
 * 支付方式
 * Created by tong on 2017/6/12.
 */
public class PayWay {
    //pos
    public static final Integer POS = 0;
    //转账
    public static final Integer TRANSFER = 1;
    //微信
    public static final Integer WECHAT = 2;
    //支付宝
    public static final Integer ALIPAY = 3;
    //通联代扣
    public static final Integer ALLIPAY = 4;
    //其他
    public static final Integer OTHER = 5;
    //批量补录
    public static final Integer BATCH = 6;
    //线下缴款登记
    public static final Integer PRIVATELY = 7;
    //默认、未支付无支付方式
    public static final Integer DEFUAL = 8;
    //通联协议支付
    public static final Integer ALLIPAY_QUICK = 9;
}
