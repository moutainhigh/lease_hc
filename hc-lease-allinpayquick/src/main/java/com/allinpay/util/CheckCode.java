package com.allinpay.util;

import com.allinpay.model.QuickReturnMessage;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 通联 反馈代码/根据通联官方文档(反馈代码表)整理
 * Created by tong on 2017/6/29.
 */
public class CheckCode {

    /**
     * 根据通联反馈码 判定 银行卡通联支付签约状态
     * 状态 0:未签约 1:已签约 2签约中 3:签约失败
     *
     * @param aipgrspRetCode 通联返回的 头部 状态码
     * @param retCode        通联返回的 明细 状态码
     * @return
     */
    public static Integer checkBankPaySinStatus(String aipgrspRetCode, String retCode) {
        if (aipgrspRetCode.equals(QuickCodeEnum.REQ_CODE_0000.getCode())) {
            if (retCode.equals(QuickCodeEnum.REQ_CODE_0000.getCode())) {
                return 1;
            } else {
                return 3;
            }
        } else {
            return 3;
        }
    }

    /**
     * 根据通联反馈码 判定 通联协议支付状态
     * 1扣款中 2已扣款/成功 3:失败
     *
     * @param aipgrspRetCode 通联返回的 头部 状态码
     * @param retCode        通联返回的 明细 状态码
     * @return
     */
    public static Integer checkPayPaymentResult(String aipgrspRetCode, String retCode) {
        if (aipgrspRetCode.equals(QuickCodeEnum.HEAD_CODE_0000.getCode())) {
            if (retCode.equals(QuickCodeEnum.REQ_CODE_0000.getCode())) {//成功状态
                return 2;
            } else if (retCode.equals(QuickCodeEnum.REQ_CODE_3004.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3005.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3006.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3007.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3008.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3009.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3010.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3011.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3012.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3013.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3014.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3015.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3016.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3017.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3018.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3023.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3024.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3025.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3026.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3027.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3028.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3029.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3030.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3031.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3032.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3033.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3034.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3035.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3036.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3037.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3038.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3039.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3040.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3041.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3042.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3043.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3044.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3045.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3046.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3047.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3048.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3049.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3050.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3051.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3052.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3053.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3054.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3055.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3056.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3057.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3058.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3059.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3060.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3061.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3062.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3063.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3064.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3065.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3066.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3067.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3068.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3069.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3070.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3071.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3072.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3073.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3074.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3075.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3076.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3077.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3078.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3079.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3888.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3999.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3602.getCode())
                    ) {//失败状态
                return 3;
            } else {//中间状态
                return 1;
            }
        } else if (aipgrspRetCode.equals(QuickCodeEnum.HEAD_CODE_2007.getCode())
                || aipgrspRetCode.equals(QuickCodeEnum.HEAD_CODE_2008.getCode())
                || aipgrspRetCode.equals(QuickCodeEnum.HEAD_CODE_0001.getCode())
                || aipgrspRetCode.equals(QuickCodeEnum.HEAD_CODE_1000.getCode())
                /*|| aipgrspRetCode.equals(QuickCodeEnum.HEAD_CODE_1001.getCode())*/
                ) {//中间状态
            return 1;
        } else {//失败状态
            return 3;
        }
    }

    /**
     * 根据通联反馈码 判定 通联协议支付状态
     * 0:已提交、扣款中;1:成功;2:失败
     *
     * @param aipgrspRetCode 通联返回的 头部 状态码
     * @param retCode        通联返回的 明细 状态码
     * @return
     */
    public static Integer checkPayStatus(String aipgrspRetCode, String retCode) {
        if (aipgrspRetCode.equals(QuickCodeEnum.HEAD_CODE_0000.getCode())) {
            if (retCode.equals(QuickCodeEnum.REQ_CODE_0000.getCode())) {//成功状态
                return 1;
            } else if (retCode.equals(QuickCodeEnum.REQ_CODE_3004.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3005.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3006.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3007.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3008.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3009.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3010.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3011.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3012.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3013.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3014.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3015.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3016.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3017.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3018.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3023.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3024.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3025.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3026.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3027.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3028.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3029.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3030.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3031.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3032.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3033.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3034.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3035.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3036.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3037.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3038.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3039.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3040.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3041.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3042.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3043.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3044.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3045.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3046.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3047.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3048.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3049.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3050.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3051.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3052.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3053.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3054.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3055.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3056.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3057.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3058.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3059.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3060.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3061.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3062.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3063.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3064.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3065.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3066.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3067.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3068.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3069.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3070.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3071.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3072.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3073.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3074.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3075.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3076.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3077.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3078.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3079.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3888.getCode())
                    || retCode.equals(QuickCodeEnum.REQ_CODE_3999.getCode())) {
                return 2;//失败状态
            } else {//中间状态
                return 0;
            }
        } else if (aipgrspRetCode.equals(QuickCodeEnum.HEAD_CODE_2007.getCode())
                || aipgrspRetCode.equals(QuickCodeEnum.HEAD_CODE_2008.getCode())
                || aipgrspRetCode.equals(QuickCodeEnum.HEAD_CODE_0001.getCode())
                || aipgrspRetCode.equals(QuickCodeEnum.HEAD_CODE_1000.getCode())
                /*|| aipgrspRetCode.equals(QuickCodeEnum.HEAD_CODE_1001.getCode())*/
                ) { //中间状态
            return 0;

        } else {//失败状态
            return 2;
        }
    }

    /**
     * 银行卡通联支付签约
     * 根据通联反馈码 判定 通联处理结果
     *
     * @param quickReturnMessage
     * @throws GMException
     */
    public static void checkBankPaySin(QuickReturnMessage quickReturnMessage) throws GMException {
        String aipgrspRetCode = quickReturnMessage.getAipgrspRetCode();//通联返回的 头部 状态码
        String aipgrspErrmsg = quickReturnMessage.getAipgrspErrmsg();
        String retCode = quickReturnMessage.getRnpaRetRetCode();//通联返回的 明细 状态码
        String rnpaRetErrmsg = quickReturnMessage.getRnpaRetErrmsg();
        if (!aipgrspRetCode.equals(QuickCodeEnum.REQ_CODE_0000.getCode())) {
            GMExceptionConstant.ALLINPAY_SIGN_ERROR.setErrMsg(aipgrspErrmsg);
            throw new GMException(GMExceptionConstant.ALLINPAY_SIGN_ERROR);
        }
        if (!retCode.equals(QuickCodeEnum.REQ_CODE_0000.getCode())) {
            GMExceptionConstant.ALLINPAY_SIGN_ERROR.setErrMsg(rnpaRetErrmsg);
            throw new GMException(GMExceptionConstant.ALLINPAY_SIGN_ERROR);
        }
    }

    /**
     * 银行卡通联支付签约
     * 根据通联反馈码 判定 通联处理结果
     * 返回结果
     *
     * @param quickReturnMessage
     * @throws GMException
     */
    public static ResultHashMap checkBankPaySinBack(QuickReturnMessage quickReturnMessage) throws GMException {
        String aipgrspRetCode = quickReturnMessage.getAipgrspRetCode();//通联返回的 头部 状态码
        String aipgrspErrmsg = quickReturnMessage.getAipgrspErrmsg();
        String retCode = quickReturnMessage.getRnpaRetRetCode();//通联返回的 明细 状态码
        String rnpaRetErrmsg = quickReturnMessage.getRnpaRetErrmsg();
        if (!aipgrspRetCode.equals(QuickCodeEnum.REQ_CODE_0000.getCode())) {
            GMExceptionConstant.ALLINPAY_SIGN_ERROR.setErrMsg(aipgrspErrmsg);
            ResultHashMap resultHashMap = new ResultHashMap(true, null, GMExceptionConstant.ALLINPAY_SIGN_ERROR);
            return resultHashMap;
        }
        if (!retCode.equals(QuickCodeEnum.REQ_CODE_0000.getCode())) {
            GMExceptionConstant.ALLINPAY_SIGN_ERROR.setErrMsg(rnpaRetErrmsg);
            ResultHashMap resultHashMap = new ResultHashMap(true, null, GMExceptionConstant.ALLINPAY_SIGN_ERROR);
            return resultHashMap;
        }
        ResultHashMap resultHashMap = new ResultHashMap(false, null, GMExceptionConstant.ALLINPAY_SIGN_SUCCESS);
        return resultHashMap;
    }

}
