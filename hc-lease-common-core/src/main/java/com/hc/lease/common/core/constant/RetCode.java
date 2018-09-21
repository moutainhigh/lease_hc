package com.hc.lease.common.core.constant;

/**
 * 通联 反馈代码/根据通联官方文档(反馈代码表)整理
 * 除了中间状态和成功状态 之外都是 失败状态
 * Created by tong on 2017/6/29.
 */
public class RetCode {

    /////////////////////成功状态//////////////////////
    //处理成功
    public static final String QUERYTRADENEW_AIPGRSPRETCODE_0000 = "0000";

    //已发送银行（代表交易成功）
    public static final String QUERYTRADENEW_AIPGRSPRETCODE_4000 = "4000";
    /////////////////////成功状态//////////////////////


    /////////////////////中间状态//////////////////////
    //系统正在对数据处理
    public static final String QUERYTRADENEW_AIPGRSPRETCODE_2000 = "2000";

    //等待商户审核
    public static final String QUERYTRADENEW_AIPGRSPRETCODE_2001 = "2001";

    //等待受理
    public static final String QUERYTRADENEW_AIPGRSPRETCODE_2003 = "2003";

    //等待复核
    public static final String QUERYTRADENEW_AIPGRSPRETCODE_2005 = "2005";

    //提交银行处理
    public static final String QUERYTRADENEW_AIPGRSPRETCODE_2007 = "2007";

    //实时交易超时
    public static final String QUERYTRADENEW_AIPGRSPRETCODE_2008 = "2008";

    //不确定交易结果，待核对
    public static final String QUERYTRADENEW_AIPGRSPRETCODE_0003 = "0003";
    /////////////////////中间状态//////////////////////


    /////////////////////////////////////////////////////////////以上是INFO节点里面的RETCODE//////以下是交易明细节点的RETCODE//////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////成功状态//////////////////////
    //处理成功
    public static final String QUERYTRADENEW_RETCODE_0000 = "0000";

    //已发送银行（代表交易成功）
    public static final String QUERYTRADENEW_RETCODE_4000 = "4000";
    /////////////////////成功状态//////////////////////


    /////////////////////中间状态//////////////////////
    //提交中间状态
    public static final String QUERYTRADENEW_RETCODE_0014 = "0014";
    /////////////////////中间状态//////////////////////

    /////////////////////通联单笔实时银行身份验证//////////////////////
    //处理成功
    public static final String VALIDRET_RETCODE_0000 = "0000";
    //卡号所属银行与发卡行不一致
    public static final String VALIDRET_RETCODE_3999 = "3999";
    //账号户名不符
    public static final String VALIDRET_RETCODE_3031 = "3031";
    //证件类型和证件号错误
    public static final String VALIDRET_RETCODE_3063 = "3063";
    //无效卡号
    public static final String VALIDRET_RETCODE_3004 = "3004";
    /////////////////////中间状态//////////////////////


    /**
     * 根据通联反馈码 判定支付状态
     * 0:已提交;1:成功;2:失败
     *
     * @param aipgrspRetCode
     * @return
     */
    public static Integer checkStatus(String aipgrspRetCode, String retCode) {
        if (aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_0000) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_4000)) {
            if (retCode.equals(QUERYTRADENEW_RETCODE_0000) || retCode.equals(QUERYTRADENEW_RETCODE_4000)) {
                return 1;
            } else if (retCode.equals(QUERYTRADENEW_RETCODE_0014)) {
                return 0;
            }
        } else if (aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2000) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2001) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2003) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2005) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2007) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2008) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_0003)) {
            return 0;
        }
        return 2;
    }

    /**
     * 根据通联反馈码 判定支付状态
     * 扣款结果  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败
     *
     * @param aipgrspRetCode
     * @return
     */
    public static Integer checkPaymentResult(String aipgrspRetCode, String retCode) {
        if (aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_0000) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_4000)) {
            if (retCode.equals(QUERYTRADENEW_RETCODE_0000) || retCode.equals(QUERYTRADENEW_RETCODE_4000)) {
                return 2;
            } else if (retCode.equals(QUERYTRADENEW_RETCODE_0014)) {
                return 1;
            }
        } else if (aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2000) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2001) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2003) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2005) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2007) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2008) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_0003)) {
            return 1;
        }
        return 3;
    }

    /**
     * 根据通联反馈码 判定 逾期记录 是否付款
     * 是否付款
     *
     * @param aipgrspRetCode
     * @param retCode
     * @return
     */
    public static boolean checkIsPay(String aipgrspRetCode, String retCode) {
        if (aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_0000) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_4000)) {
            if (retCode.equals(QUERYTRADENEW_RETCODE_0000) || retCode.equals(QUERYTRADENEW_RETCODE_4000)) {
                return true;
            } else if (retCode.equals(QUERYTRADENEW_RETCODE_0014)) {
                return false;
            }
        } else if (aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2000) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2001) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2003) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2005) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2007) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2008) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_0003)) {
            return false;
        }
        return false;
    }

    /**
     * 根据通联反馈码 判定 合同状态
     * 合同状态 0:还款中 1:挂靠中 2:已结束
     *
     * @param aipgrspRetCode
     * @param retCode
     * @return
     */
    public static Integer checkContractStatus(String aipgrspRetCode, String retCode) {
        if (aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_0000) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_4000)) {
            if (retCode.equals(QUERYTRADENEW_RETCODE_0000) || retCode.equals(QUERYTRADENEW_RETCODE_4000)) {
                return 2;
            } else if (retCode.equals(QUERYTRADENEW_RETCODE_0014)) {
                return 0;
            }
        } else if (aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2000) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2001) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2003) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2005) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2007) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_2008) || aipgrspRetCode.equals(QUERYTRADENEW_AIPGRSPRETCODE_0003)) {
            return 0;
        }
        return 0;
    }

}
