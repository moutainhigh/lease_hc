package com.hc.lease.common.core.constant;

/**
 * 通联支付 交易代码/根据通联官方文档整理
 * Created by tong on 2017/6/12.
 */
public class TranxCode {

    //批量代收
    public static final String BATCHTRANX_DS = "100001";

    //批量代付
    public static final String BATCHTRANX_DF = "100002";

    //实时单笔代收
    public static final String SINGLETRANX_DS = "100011";

    //实时单笔代付
    public static final String SINGLETRANX_DF = "100014";

    //单笔实时身份验证
    public static final String SINGLEACCTVERIFY = "211004";

    //交易结果查询
    public static final String QUERYTRADENEW = "200004";

    //批量账户验证
    public static final String BATCHACCTVERIFY = "211000";

    //国民身份验证
    public static final String IDVERIFY = "220001";

    //国民身份验证查询
    public static final String IDVERIFYQ = "220003";

}
