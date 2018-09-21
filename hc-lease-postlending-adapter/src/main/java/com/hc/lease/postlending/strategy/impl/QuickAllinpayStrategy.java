package com.hc.lease.postlending.strategy.impl;

import com.aipg.payresp.Ret_Detail;
import com.aipg.quickpay.AllinpayIdTypeEnum;
import com.allinpay.data.QuickData;
import com.allinpay.model.QuickReturnMessage;
import com.allinpay.util.CheckCode;
import com.allinpay.util.QuickCodeEnum;
import com.hc.lease.common.allinpay.adapter.TranxAdapter;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.JDBCTpye;
import com.hc.lease.common.core.constant.PayWay;
import com.hc.lease.common.core.constant.PaymentLogStatus;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.vo.BatchPostlendingPaymentVo;
import com.hc.lease.postlending.strategy.Context;
import com.hc.lease.postlending.strategy.Strategy;
import com.hc.lease.postlending.vo.BatchStrategyVo;
import com.hc.lease.postlending.vo.TransBodyInstallVo;
import hc.lease.common.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理单人综合扣款、通联批扣
 * 通联协议支付
 * <p>
 * Created by tong on 2018/5/18.
 */
public class QuickAllinpayStrategy implements Strategy {

    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {
        TranxAdapter tranxAdapter = (TranxAdapter) SpringContextHolder.getBean("tranxAdapter");
        Context context = (Context) object;
        TransBodyInstallVo transBodyInstallVo = (TransBodyInstallVo) object1;//用于扣款的数据
        List<BatchPostlendingPaymentVo> needBatchPostlendingPaymentList = (List<BatchPostlendingPaymentVo>) object2;//批量扣款款项 月供、滞纳金、其他

        if (transBodyInstallVo != null) {
            if (needBatchPostlendingPaymentList != null) {
                if (needBatchPostlendingPaymentList.size() > 0) {
                    //拼接协议支付接口参数
                    QuickData data = new QuickData();
                    data.setAccountName(transBodyInstallVo.getAccountName());//银行户名
                    data.setAgrmno(transBodyInstallVo.getAgrmNo());//协议号
                    data.setAccountNo(transBodyInstallVo.getAccountNo());//银行卡号
                    data.setIdType(AllinpayIdTypeEnum.ID_TYPE_0.getCode());//开户证件类型
                    BigDecimal totlePriceF = transBodyInstallVo.getAmount().multiply(new BigDecimal(100));//因为通联的金额用 分 做单位
                    data.setAmount(String.valueOf(totlePriceF.intValue()));//金额
                    data.setTel(transBodyInstallVo.getBankPhone());//电话
                    data.setId(transBodyInstallVo.getIdCard());//身份证号
                    data.setBankCode(transBodyInstallVo.getBankCode());//银行代码
                    //拼接协议支付接口参数

                    QuickReturnMessage quickReturnMessage = tranxAdapter.pay(data);//提交通联协议支付交易

                    //根据通联支付代收 返回的处理结果更新 数据库
                    if (quickReturnMessage != null) {
                        BatchStrategyVo batchStrategyVo = new BatchStrategyVo();
                        batchStrategyVo.setTotalItem(needBatchPostlendingPaymentList.size());//总数量
                        batchStrategyVo.setSingleOrBatch(transBodyInstallVo.getSingleOrBatch());//单笔或批量/0:单笔; 1:批量
                        batchStrategyVo.setCreateTime(transBodyInstallVo.getCreateTime());
                        batchStrategyVo.setUpdateTime(transBodyInstallVo.getUpdateTime());
                        batchStrategyVo.setCreateBy(transBodyInstallVo.getCreateBy());
                        batchStrategyVo.setUpdateBy(transBodyInstallVo.getUpdateBy());
                        batchStrategyVo.setReqSn(quickReturnMessage.getReqSn());
                        batchStrategyVo.setAipgrspRetCode(quickReturnMessage.getAipgrspRetCode());//通联返回的 头部 状态码
                        batchStrategyVo.setAipgrspErrMsg(quickReturnMessage.getAipgrspErrmsg());//通联返回的 头部 状态结果描述
                        batchStrategyVo.setRetCode(quickReturnMessage.getRnpaRetRetCode());//通联返回的 明细 状态码
                        batchStrategyVo.setErrMsg(quickReturnMessage.getRnpaRetErrmsg());//通联返回的 明细 状态结果描述
                        batchStrategyVo.setFinalErrMsg(quickReturnMessage.getAipgrspRetCode().equals(QuickCodeEnum.HEAD_CODE_0000.getCode()) ? quickReturnMessage.getRnpaRetErrmsg() : quickReturnMessage.getAipgrspErrmsg());//如果头部返回成功状态则使用明细的状态结果描述
                        batchStrategyVo.setFinalCode(quickReturnMessage.getAipgrspRetCode().equals(QuickCodeEnum.HEAD_CODE_0000.getCode()) ? quickReturnMessage.getRnpaRetRetCode() : quickReturnMessage.getAipgrspRetCode());//如果头部返回成功状态则使用明细的状态码
                        batchStrategyVo.setRetDetails(dualRetDetails(quickReturnMessage, transBodyInstallVo));//批量代收明细 操作结果状态
                        batchStrategyVo.setBatchNumber(transBodyInstallVo.getBatchNumber());//批次号/批扣流水
                        batchStrategyVo.setPayWay(PayWay.ALLIPAY_QUICK);
                        batchStrategyVo.setStatus(CheckCode.checkPayStatus(quickReturnMessage.getAipgrspRetCode(), quickReturnMessage.getRnpaRetRetCode()));//通联支付状态/0:已提交、扣款中;1:成功;2:失败
                        batchStrategyVo.setAllinpayStatusLogType(transBodyInstallVo.getAllinpayStatusLogType());
                        batchStrategyVo.setIsSpilt(transBodyInstallVo.getIsSpilt());
                        batchStrategyVo.setSn(transBodyInstallVo.getSn());

                        //通联批量支付批次统计 表 的数据
                        batchStrategyVo.setReceivablePrice(transBodyInstallVo.getAmountOld());//应扣总额
                        batchStrategyVo.setReceiptsPrice(batchStrategyVo.getStatus().equals(PaymentLogStatus.STATUS_1) ? transBodyInstallVo.getAmount() : new BigDecimal(0));//实扣总额
                        batchStrategyVo.setSuccessNumber(batchStrategyVo.getStatus().equals(PaymentLogStatus.STATUS_1) ? needBatchPostlendingPaymentList.size() : 0);//成功数量
                        batchStrategyVo.setFailNumber(batchStrategyVo.getStatus().equals(PaymentLogStatus.STATUS_2) ? needBatchPostlendingPaymentList.size() : 0);//失败数量
                        batchStrategyVo.setFailPrice(batchStrategyVo.getStatus().equals(PaymentLogStatus.STATUS_2) ? transBodyInstallVo.getAmount() : new BigDecimal(0));//失败总额
                        //通联批量支付批次统计 表 的数据
                        context.deal(context, batchStrategyVo.getSingleOrBatch() + JDBCTpye.JDBC_SINGLEORBATHTYPE + "AllPayWayCommon", batchStrategyVo, needBatchPostlendingPaymentList, null, dubboTreaceParames);//支付公共处理
                    }
                }
            }
            //根据通联支付代收 返回的处理结果更新 数据库
        }
        return null;
    }

    /**
     * 处理交易 通联返回的 明细
     * 如果通联返回的 头部 状态已经为失败状态 则需要手动处理 模拟通联返回的格式，因为通联没有返回这部分数据，但后面需用到这部分数据
     *
     * @param quickReturnMessage
     * @param transBodyInstallVo
     * @return
     */
    private List<Ret_Detail> dualRetDetails(QuickReturnMessage quickReturnMessage, TransBodyInstallVo transBodyInstallVo) {
        List<Ret_Detail> retDetails = new ArrayList<Ret_Detail>();
        Ret_Detail detail = new Ret_Detail();
        if (quickReturnMessage.getAipgrspRetCode().equals(QuickCodeEnum.REQ_CODE_0000.getCode())) {
            detail.setRET_CODE(quickReturnMessage.getRnpaRetRetCode());
            detail.setERR_MSG(quickReturnMessage.getRnpaRetErrmsg());
        } else {
            detail.setRET_CODE(quickReturnMessage.getAipgrspRetCode());
            detail.setERR_MSG(quickReturnMessage.getAipgrspErrmsg());
        }
        detail.setSN(transBodyInstallVo.getSn());
        retDetails.add(detail);
        return retDetails;
    }


}