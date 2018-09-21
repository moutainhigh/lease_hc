package com.hc.lease.postlending.strategy.impl;

import com.aipg.quickpay.AllinpayIdTypeEnum;
import com.allinpay.data.QuickData;
import com.allinpay.model.QuickReturnMessage;
import com.allinpay.util.CheckCode;
import com.allinpay.util.QuickCodeEnum;
import com.hc.lease.common.allinpay.adapter.TranxAdapter;
import com.hc.lease.common.core.constant.AllinpayStatusLogType;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.JDBCTpye;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.postlending.strategy.Context;
import com.hc.lease.postlending.strategy.Strategy;
import com.hc.lease.postlending.vo.BatchPostlendingPaymentSplitVo;
import com.hc.lease.postlending.vo.StrategySplitVo;
import com.hc.lease.postlending.vo.TransSplitBody;
import hc.lease.common.util.SpringContextHolder;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * 通联支付拆单
 * 单笔协议支付
 * Created by tong on 2018/6/21
 */
public class SplitAllinpayQuickStrategy implements Strategy {
    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {
        TranxAdapter tranxAdapter = (TranxAdapter) SpringContextHolder.getBean("tranxAdapter");

        Context context = (Context) object;
        TransSplitBody transSplitBody = (TransSplitBody) object1;
        BatchPostlendingPaymentSplitVo batchPostlendingPaymentSplitVo = (BatchPostlendingPaymentSplitVo) object2;

        //检测承租人信息
        if (batchPostlendingPaymentSplitVo.getBankAccountName() == null) {
            throw new GMException(GMExceptionConstant.ACCOUNT_NAME_ERROR);
        }
        if (batchPostlendingPaymentSplitVo.getBackCardNumber() == null) {
            throw new GMException(GMExceptionConstant.ACCOUNT_BACKCARDNUMBER_ERROR);
        }
        if (batchPostlendingPaymentSplitVo.getIdCard() == null) {
            throw new GMException(GMExceptionConstant.ACCOUNT_IDCARD_ERROR);
        }
        if (batchPostlendingPaymentSplitVo.getAgrmNo() == null) {
            throw new GMException(GMExceptionConstant.BANK_CARD_SIGN_ERROR);
        }
        //检测承租人信息

        //无款项需要支付
        if (batchPostlendingPaymentSplitVo == null) {
            throw new GMException(GMExceptionConstant.NO_NEED_TO_ALLINPAY);
        }
        //无款项需要支付

        //拼接协议支付接口参数
        QuickData data = new QuickData();
        data.setAccountName(batchPostlendingPaymentSplitVo.getBankAccountName());//用户名
        data.setAccountNo(batchPostlendingPaymentSplitVo.getBackCardNumber());//银行卡号
        data.setAgrmno(batchPostlendingPaymentSplitVo.getAgrmNo());//协议号
        data.setIdType(AllinpayIdTypeEnum.ID_TYPE_0.getCode());//开户证件类型
        BigDecimal totlePriceF = batchPostlendingPaymentSplitVo.getTotlePrice().multiply(new BigDecimal(100));//因为通联的金额用 分 做单位
        data.setAmount(batchPostlendingPaymentSplitVo.getTotlePrice() == null ? "0" : new BigDecimal(totlePriceF.intValue()).toString());//金额
        data.setTel(batchPostlendingPaymentSplitVo.getBankPhone());//电话
        data.setId(batchPostlendingPaymentSplitVo.getIdCard());//身份证号
        data.setBankCode(batchPostlendingPaymentSplitVo.getBankCode());//银行代码
        //拼接协议支付接口参数

        //通联协议支付
        QuickReturnMessage quickReturnMessage = tranxAdapter.pay(data);
        //通联协议支付

        StrategySplitVo strategySplitVo = new StrategySplitVo();
        strategySplitVo.setReqSn(quickReturnMessage.getReqSn());
        strategySplitVo.setAipgrspRetCode(quickReturnMessage.getAipgrspRetCode());//通联返回的 头部 状态码
        strategySplitVo.setAipgrspErrMsg(quickReturnMessage.getAipgrspErrmsg());//通联返回的 头部 状态结果描述
        strategySplitVo.setRetCode(quickReturnMessage.getRnpaRetRetCode());//通联返回的 明细 状态码
        strategySplitVo.setErrMsg(quickReturnMessage.getRnpaRetErrmsg());//通联返回的 明细 状态结果描述
        strategySplitVo.setFinalErrMsg(quickReturnMessage.getAipgrspRetCode().equals(QuickCodeEnum.REQ_CODE_0000.getCode()) ? quickReturnMessage.getRnpaRetErrmsg() : quickReturnMessage.getAipgrspErrmsg());//如果头部返回成功状态则使用明细的状态结果描述
        strategySplitVo.setFinalCode(quickReturnMessage.getAipgrspRetCode().equals(QuickCodeEnum.REQ_CODE_0000.getCode()) ? quickReturnMessage.getRnpaRetRetCode() : quickReturnMessage.getAipgrspRetCode());//如果头部返回成功状态则使用明细的状态码
        strategySplitVo.setBackTime(DateTime.now().toDate());//
        strategySplitVo.setPaymentResult(CheckCode.checkPayPaymentResult(quickReturnMessage.getAipgrspRetCode(), quickReturnMessage.getRnpaRetRetCode()));//支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败
        strategySplitVo.setSingleOrBatch(0);//单笔或批量/0:单笔; 1:批量//
        strategySplitVo.setCreateBy(transSplitBody.getCreateBy());//
        strategySplitVo.setUpdateBy(transSplitBody.getUpdateBy());//
        strategySplitVo.setStatus(CheckCode.checkPayStatus(quickReturnMessage.getAipgrspRetCode(), quickReturnMessage.getRnpaRetRetCode()));//通联支付状态/0:已提交、1扣款中;1:成功;2:失败
        strategySplitVo.setAllinpayStatusLogType(AllinpayStatusLogType.TYPE_7);

        context.deal(context, JDBCTpye.JDBC_INSERT + "SplitInsertStrategy", strategySplitVo, batchPostlendingPaymentSplitVo, null, dubboTreaceParames);//贷后代收 处理 月供 流水和状态

        ResultHashMap resultHashMap = new ResultHashMap(true, null, GMExceptionConstant.ALLINPAY_SEND_SUCCESS);
        return resultHashMap;
    }
}
