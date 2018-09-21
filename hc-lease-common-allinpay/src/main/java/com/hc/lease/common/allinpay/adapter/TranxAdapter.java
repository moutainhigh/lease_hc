package com.hc.lease.common.allinpay.adapter;

import com.allinpay.data.QuickData;
import com.allinpay.model.QuickReturnMessage;
import com.hc.lease.common.allinpay.model.ReturnMessage;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.vo.PostlendingPaymentParameVo;
import com.hc.lease.postlending.vo.TransBody;

/**
 * 通联支付
 * Created by tong on 2017/6/2.
 */
public interface TranxAdapter {

    /**
     * 批量代收
     * 100001批量代收 100002批量代付 100011单笔实时代收 100014单笔实时代付
     *
     * @param postlendingPaymentParameVo
     * @return
     * @throws GMException
     */
    ReturnMessage batchTranx(PostlendingPaymentParameVo postlendingPaymentParameVo, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 实时单笔代收付，100011是实时代笔代收，100014是实时单笔代付
     *
     * @param transBody
     * @return
     * @throws GMException
     */
    ReturnMessage singleTranx(TransBody transBody, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 单笔实时身份验证/账户实名验证(四要素)
     *
     * @return
     * @throws GMException
     */
    ReturnMessage singleAcctVerify(TransBody transBody) throws GMException;

    /**
     * 批量账户验证
     *
     * @return
     */
    ReturnMessage batchAcctVerify(TransBody transBody) throws GMException;

    /**
     * 交易查询/轮询/通联平台查询
     *
     * @param transBody
     * @return
     * @throws GMException
     */
    ReturnMessage queryTradeNew(TransBody transBody, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 国民身份验证
     *
     * @return
     */
    ReturnMessage idVerify(TransBody transBody) throws GMException;

    /**
     * 国民身份验证查询
     *
     * @return
     */
    ReturnMessage idVerifyQ(TransBody transBody) throws GMException;

    /**
     * 协议支付签约短信触发
     *
     * @param data
     */
    QuickReturnMessage sendMessage(QuickData data) throws GMException;

    /**
     * 协议支付签约
     *
     * @param data
     */
    QuickReturnMessage sign(QuickData data) throws GMException;

    /**
     * 协议支付
     *
     * @param quickData
     * @return
     * @throws GMException
     */
    QuickReturnMessage pay(QuickData quickData) throws GMException;

    /**
     * 交易查询/轮询/通联平台查询
     * 通联协议支付
     *
     * @param sn
     * @return
     * @throws GMException
     */
    QuickReturnMessage search(String sn, DubboTreaceParames dubboTreaceParames) throws GMException;

}
