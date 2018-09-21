package com.hc.lease.postlending.strategy.impl;

import com.aipg.payreq.Trans_Detail;
import com.aipg.payresp.Ret_Detail;
import com.aipg.quickpay.AllinpayIdTypeEnum;
import com.allinpay.util.QuickCodeEnum;
import com.hc.lease.common.allinpay.adapter.TranxAdapter;
import com.hc.lease.common.allinpay.model.ReturnMessage;
import com.hc.lease.common.core.constant.*;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.vo.BatchPostlendingPaymentVo;
import com.hc.lease.postlending.strategy.Context;
import com.hc.lease.postlending.strategy.Strategy;
import com.hc.lease.postlending.vo.BatchStrategyVo;
import com.hc.lease.postlending.vo.PostlendingPaymentParameVo;
import com.hc.lease.postlending.vo.TransBodyInstallVo;
import hc.lease.common.util.SpringContextHolder;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 处理单人综合扣款、通联批扣
 * 通联代扣
 * Created by tong on 2018/5/17.
 */
public class PostlendingAllinpayStrategy implements Strategy {

    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {

        TranxAdapter tranxAdapter = (TranxAdapter) SpringContextHolder.getBean("tranxAdapter");
        Context context = (Context) object;

        List<BatchPostlendingPaymentVo> batchPostlendingPaymentList = (List<BatchPostlendingPaymentVo>) object2;
        PostlendingPaymentParameVo postlendingPaymentParameVo = (PostlendingPaymentParameVo) object1;
        Map<String, TransBodyInstallVo> transBodyInstallVoAll = postlendingPaymentParameVo.getBatchMapAll();//所有承租人的扣款数据

        ////////////////////////拼接批扣接口参数////////////////////////
        //////封装扣款项目///////
        List<Ret_Detail> retDetails = new ArrayList<Ret_Detail>();
        List<Trans_Detail> transList = new ArrayList<Trans_Detail>();
        Trans_Detail trans_detai = null;
        if (transBodyInstallVoAll != null) {
            for (String key : transBodyInstallVoAll.keySet()) {
                TransBodyInstallVo transBodyInstallVo = transBodyInstallVoAll.get(key);

                trans_detai = new Trans_Detail();
                trans_detai.setACCOUNT_NAME(transBodyInstallVo.getAccountName());//银行户名
                trans_detai.setACCOUNT_NO(transBodyInstallVo.getAccountNo());//银行卡号
                trans_detai.setID_TYPE(AllinpayIdTypeEnum.ID_TYPE_0.getCode());//开户证件类型:0：身份证,1: 户口簿，2：护照,3.军官证,4.士兵证，5. 港澳居民来往内地通行证,6. 台湾同胞来往内地通行证,7. 临时身份证,8. 外国人居留证,9.警官,X.其他证件
                trans_detai.setID(transBodyInstallVo.getIdCard());//身份证号
                BigDecimal totlePriceF = transBodyInstallVo.getAmount().multiply(new BigDecimal(100));//因为通联的金额用 分 做单位
                trans_detai.setAMOUNT(String.valueOf(totlePriceF.intValue()));
                trans_detai.setBANK_CODE(transBodyInstallVo.getBankCode());//银行代码
                trans_detai.setACCOUNT_PROP(transBodyInstallVo.getAccountProp());
                trans_detai.setCURRENCY(transBodyInstallVo.getCurrency());
                trans_detai.setSN(transBodyInstallVo.getSn());
                transList.add(trans_detai);

                Ret_Detail retDetail = new Ret_Detail();
                retDetail.setSN(transBodyInstallVo.getSn());
                retDetails.add(retDetail);

            }
            //////封装扣款项目///////
            postlendingPaymentParameVo.setTrxCode(TranxCode.BATCHTRANX_DS);//交易代码
            postlendingPaymentParameVo.setBusiCode(BusiCode.BATCHTRANX_SINGLETRANX_DS_DS_BATCH);//业务代码
            BigDecimal totlePrice = postlendingPaymentParameVo.getTotalPrice();
            postlendingPaymentParameVo.setTotalPrice(new BigDecimal(totlePrice.multiply(new BigDecimal(100)).intValue()));//总金额，因为通联的金额用 分 做单位
            postlendingPaymentParameVo.setNumber(transBodyInstallVoAll.size());//总笔数对应扣款数量、提供给通联接口的参数
            postlendingPaymentParameVo.setTransList(transList);
            ////////////////////////拼接批扣接口参数////////////////////////

            //通联支付 批量代收
            ReturnMessage returnMessage = tranxAdapter.batchTranx(postlendingPaymentParameVo, dubboTreaceParames);
            //通联支付 批量代收
            //根据通联支付代收 返回的处理结果更新 数据库
            if (returnMessage != null) {
                Date newDate = DateTime.now().toDate();
                BatchStrategyVo batchStrategyVo = new BatchStrategyVo();
                batchStrategyVo.setTotlePrice(totlePrice);//总金额
                batchStrategyVo.setTotalItem(batchPostlendingPaymentList.size());//
                batchStrategyVo.setSingleOrBatch(postlendingPaymentParameVo.getSingleOrBatch());//单笔或批量/0:单笔; 1:批量
                batchStrategyVo.setCreateTime(newDate);
                batchStrategyVo.setUpdateTime(newDate);
                batchStrategyVo.setCreateBy(postlendingPaymentParameVo.getCreateBy());
                batchStrategyVo.setUpdateBy(postlendingPaymentParameVo.getUpdateBy());
                batchStrategyVo.setReqSn(returnMessage.getReqSn());
                batchStrategyVo.setAipgrspRetCode(returnMessage.getAipgrspRetCode());//通联返回的 头部 状态码
                batchStrategyVo.setAipgrspErrMsg(returnMessage.getAipgrspErrmsg());//通联返回的 头部 状态结果描述

                batchStrategyVo.setRetDetails(returnMessage.getAipgrspRetCode().equals(QuickCodeEnum.REQ_CODE_0000.getCode()) ? returnMessage.getRetDetails() : dualRetDetails(returnMessage, retDetails));//批量代收明细 操作结果状态
                batchStrategyVo.setBatchNumber(postlendingPaymentParameVo.getBatchNumber());
                batchStrategyVo.setPayWay(PayWay.ALLIPAY);
                batchStrategyVo.setStatus(0);//通联支付状态/0:已提交;1:成功;2:失败
                batchStrategyVo.setIsSpilt(0);//是否超额拆单/0:是; 1:否
                batchStrategyVo.setAllinpayStatusLogType(AllinpayStatusLogType.TYPE_1);

                batchStrategyVo.setReceivablePrice(totlePrice);
                batchStrategyVo.setReceiptsPrice(new BigDecimal(0));
                batchStrategyVo.setSuccessNumber(0);
                batchStrategyVo.setFailNumber(0);
                batchStrategyVo.setFailPrice(new BigDecimal(0));

                context.deal(context, batchStrategyVo.getSingleOrBatch() + JDBCTpye.JDBC_SINGLEORBATHTYPE + "AllPayWayCommon", batchStrategyVo, batchPostlendingPaymentList, null, dubboTreaceParames);//支付公共处理
            }
            //根据通联支付代收 返回的处理结果更新 数据库
        }
        ResultHashMap resultHashMap = new ResultHashMap(true, null, GMExceptionConstant.ALLINPAY_SEND_SUCCESS);
        return resultHashMap;
    }

    /**
     * 处理交易 通联返回的 明细
     * 如果通联返回的 头部 状态已经为失败状态 则需要手动处理 模拟通联返回的格式，因为通联没有返回这部分数据，但后面需用到这部分数据
     *
     * @param returnMessage 通联返回的数据
     * @param retDetails    通联的明细数据
     */
    private List<Ret_Detail> dualRetDetails(ReturnMessage returnMessage, List<Ret_Detail> retDetails) {
        if (!returnMessage.getAipgrspRetCode().equals(QuickCodeEnum.REQ_CODE_0000.getCode())) {
            if (retDetails != null) {
                if (retDetails.size() > 0) {
                    for (int i = 0; i < retDetails.size(); i++) {
                        retDetails.get(i).setRET_CODE(returnMessage.getAipgrspRetCode());
                        retDetails.get(i).setERR_MSG(returnMessage.getAipgrspErrmsg());
                    }
                }
            }
        }
        return retDetails;
    }

}