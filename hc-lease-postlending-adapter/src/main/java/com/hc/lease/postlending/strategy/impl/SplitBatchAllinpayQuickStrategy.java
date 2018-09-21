package com.hc.lease.postlending.strategy.impl;

import com.aipg.payresp.Ret_Detail;
import com.aipg.quickpay.AllinpayIdTypeEnum;
import com.allinpay.data.QuickData;
import com.allinpay.model.QuickReturnMessage;
import com.allinpay.util.CheckCode;
import com.allinpay.util.QuickCodeEnum;
import com.hc.lease.common.allinpay.adapter.TranxAdapter;
import com.hc.lease.common.core.constant.*;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.postlending.strategy.Context;
import com.hc.lease.postlending.strategy.Strategy;
import com.hc.lease.postlending.vo.BatchPostlendingPaymentSplitVo;
import com.hc.lease.postlending.vo.BatchStrategySplitVo;
import com.hc.lease.postlending.vo.TransSplitBody;
import hc.lease.common.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 通联支付拆单
 * 批量协议支付
 * Created by tong on 2018/6/21
 */
public class SplitBatchAllinpayQuickStrategy implements Strategy {

    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {
        TranxAdapter tranxAdapter = (TranxAdapter) SpringContextHolder.getBean("tranxAdapter");
        Context context = (Context) object;
        TransSplitBody transSplitBody = (TransSplitBody) object1;
        List<BatchPostlendingPaymentSplitVo> needList = (List<BatchPostlendingPaymentSplitVo>) object2;
        if (needList == null) throw new GMException(GMExceptionConstant.NO_NEED_TO_ALLINPAY);
        if (needList.size() <= 0) throw new GMException(GMExceptionConstant.NO_NEED_TO_ALLINPAY);
        String sn = String.valueOf(System.currentTimeMillis()) + "-000";//记录序号 通联批量代收、通联会原样返回
        for (int i = 0; i < needList.size(); i++) {
            BatchPostlendingPaymentSplitVo batchPostlendingPaymentSplitVo = needList.get(i);

            //拼接协议支付接口参数
            QuickData data = new QuickData();
            data.setAccountName(batchPostlendingPaymentSplitVo.getAccountName());//银行户名
            data.setAccountNo(batchPostlendingPaymentSplitVo.getBackCardNumber());//银行卡号
            data.setAgrmno(batchPostlendingPaymentSplitVo.getAgrmNo());//协议号
            data.setIdType(AllinpayIdTypeEnum.ID_TYPE_0.getCode());//开户证件类型
            BigDecimal totlePriceF = batchPostlendingPaymentSplitVo.getTotlePrice().multiply(new BigDecimal(100));//因为通联的金额用 分 做单位
            data.setAmount(String.valueOf(totlePriceF.intValue()));//金额
            data.setTel(batchPostlendingPaymentSplitVo.getBankPhone());//电话
            data.setId(batchPostlendingPaymentSplitVo.getIdCard());//身份证号
            data.setBankCode(batchPostlendingPaymentSplitVo.getBankCode());//银行代码
            //拼接协议支付接口参数

            //通联协议支付
            QuickReturnMessage quickReturnMessage = tranxAdapter.pay(data);
            //通联协议支付

            //根据通联支付代收 返回的处理结果更新 数据库
            if (quickReturnMessage != null) {

                BatchStrategySplitVo batchStrategySplitVo = new BatchStrategySplitVo();
                batchStrategySplitVo.setTotlePrice(batchPostlendingPaymentSplitVo.getTotlePrice());//总金额
                batchStrategySplitVo.setTotalItem(needList.size());//总数量
                batchStrategySplitVo.setSingleOrBatch(1);//单笔或批量/0:单笔; 1:批量
                batchStrategySplitVo.setCreateBy(transSplitBody.getCreateBy());
                batchStrategySplitVo.setUpdateBy(transSplitBody.getUpdateBy());
                batchStrategySplitVo.setReqSn(quickReturnMessage.getReqSn());
                batchStrategySplitVo.setAipgrspRetCode(quickReturnMessage.getAipgrspRetCode());//通联返回的 头部 状态码
                batchStrategySplitVo.setAipgrspErrMsg(quickReturnMessage.getAipgrspErrmsg());//通联返回的 头部 状态结果描述
                batchStrategySplitVo.setRetCode(quickReturnMessage.getRnpaRetRetCode());//通联返回的 明细 状态码
                batchStrategySplitVo.setErrMsg(quickReturnMessage.getRnpaRetErrmsg());//通联返回的 明细 状态结果描述
                batchStrategySplitVo.setFinalErrMsg(quickReturnMessage.getAipgrspRetCode().equals(QuickCodeEnum.HEAD_CODE_0000.getCode()) ? quickReturnMessage.getRnpaRetErrmsg() : quickReturnMessage.getAipgrspErrmsg());//如果头部返回成功状态则使用明细的状态结果描述
                batchStrategySplitVo.setFinalCode(quickReturnMessage.getAipgrspRetCode().equals(QuickCodeEnum.HEAD_CODE_0000.getCode()) ? quickReturnMessage.getRnpaRetRetCode() : quickReturnMessage.getAipgrspRetCode());//如果头部返回成功状态则使用明细的状态码
                batchStrategySplitVo.setRetDetails(dualRetDetails(quickReturnMessage, sn));//批量代收明细 操作结果状态
                batchStrategySplitVo.setBatchNumber(transSplitBody.getBatchNumber());//批次号/批扣流水
                batchStrategySplitVo.setPayWay(PayWay.ALLIPAY_QUICK);
                batchStrategySplitVo.setStatus(CheckCode.checkPayStatus(quickReturnMessage.getAipgrspRetCode(), quickReturnMessage.getRnpaRetRetCode()));//通联支付状态/0:已提交、扣款中;1:成功;2:失败
                batchStrategySplitVo.setAllinpayStatusLogType(AllinpayStatusLogType.TYPE_6);

                BigDecimal price = batchPostlendingPaymentSplitVo.getTotlePrice();
                batchStrategySplitVo.setReceivablePrice(price);//应扣总额
                batchStrategySplitVo.setReceiptsPrice(batchStrategySplitVo.getStatus().equals(PaymentLogStatus.STATUS_1) ? price : new BigDecimal(0));//实扣总额
                batchStrategySplitVo.setSuccessNumber(batchStrategySplitVo.getStatus().equals(PaymentLogStatus.STATUS_1) ? needList.size() : 0);//成功数量
                batchStrategySplitVo.setFailNumber(batchStrategySplitVo.getStatus().equals(PaymentLogStatus.STATUS_2) ? needList.size() : 0);//失败数量
                batchStrategySplitVo.setFailPrice(batchStrategySplitVo.getStatus().equals(PaymentLogStatus.STATUS_2) ? price : new BigDecimal(0));//失败总额

                context.deal(context, JDBCTpye.JDBC_INSERT + "SplitBatchCommonStrategy", batchStrategySplitVo, batchPostlendingPaymentSplitVo, null, dubboTreaceParames);//提交批扣的公共处理
            }
        }

        return null;
    }

    /**
     * 处理交易 通联返回的 明细
     * 如果通联返回的 头部 状态已经为失败状态 则需要手动处理 模拟通联返回的格式，因为通联没有返回这部分数据，但后面需用到这部分数据
     *
     * @param quickReturnMessage
     * @param sn
     * @return
     */
    private List<Ret_Detail> dualRetDetails(QuickReturnMessage quickReturnMessage, String sn) {
        List<Ret_Detail> retDetails = new ArrayList<Ret_Detail>();
        Ret_Detail detail = new Ret_Detail();
        if (quickReturnMessage.getAipgrspRetCode().equals(QuickCodeEnum.REQ_CODE_0000.getCode())) {
            detail.setRET_CODE(quickReturnMessage.getRnpaRetRetCode());
            detail.setERR_MSG(quickReturnMessage.getRnpaRetErrmsg());
        } else {
            detail.setRET_CODE(quickReturnMessage.getAipgrspRetCode());
            detail.setERR_MSG(quickReturnMessage.getAipgrspErrmsg());
        }
        detail.setSN(sn);
        retDetails.add(detail);
        return retDetails;
    }

}