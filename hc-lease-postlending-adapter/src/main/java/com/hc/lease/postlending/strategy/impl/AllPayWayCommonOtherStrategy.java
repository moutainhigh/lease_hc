package com.hc.lease.postlending.strategy.impl;

import com.aipg.payresp.Ret_Detail;
import com.allinpay.util.CheckCode;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.PayWay;
import com.hc.lease.common.core.constant.PaymentResult;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.vo.BatchPostlendingPaymentVo;
import com.hc.lease.postlending.adapter.api.PostlendingInsertCommon;
import com.hc.lease.postlending.strategy.Strategy;
import com.hc.lease.postlending.vo.BatchStrategyVo;
import com.hc.lease.postlending.vo.StrategyVo;
import hc.lease.common.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理单人综合扣款、通联批扣
 * 处理其他款项
 * Created by Administrator on 2018/5/18.
 */
public class AllPayWayCommonOtherStrategy implements Strategy {

    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {
        BatchStrategyVo batchStrategyVo = (BatchStrategyVo) object1;
        BatchPostlendingPaymentVo batchPostlendingPaymentVo = (BatchPostlendingPaymentVo) object2;

        PostlendingInsertCommon postlendingInsertCommon = (PostlendingInsertCommon) SpringContextHolder.getBean("postlendingInsertCommon");

        List<Ret_Detail> retDetails = batchStrategyVo.getRetDetails();
        for (Ret_Detail lobj : retDetails) {
            String sn = batchPostlendingPaymentVo.getSn();
            if (sn.equals(lobj.getSN())) {

                List<StrategyVo> strategyVoList = new ArrayList<StrategyVo>();
                StrategyVo strategyVo = new StrategyVo();
                strategyVo.setAipgrspRetCode(batchStrategyVo.getAipgrspRetCode());//通联返回的 头部 状态码
                strategyVo.setAipgrspErrMsg(batchStrategyVo.getAipgrspErrMsg());//通联返回的 头部 状态结果描述
                strategyVo.setRetCode(lobj.getRET_CODE());//通联返回的 明细 状态码
                strategyVo.setErrMsg(lobj.getERR_MSG());//通联返回的 明细 状态结果描述
                strategyVo.setFinalErrMsg(lobj.getERR_MSG());//如果头部返回成功状态则使用明细的状态结果描述
                strategyVo.setFinalCode(lobj.getRET_CODE());//如果头部返回成功状态则使用明细的状态码
                strategyVo.setRepTime(batchStrategyVo.getRepTime());
                strategyVo.setReqSn(batchStrategyVo.getReqSn());
                strategyVo.setStatus(batchStrategyVo.getStatus());//通联支付状态/0:已提交;1:成功;2:失败
                strategyVo.setOverdueDay(batchPostlendingPaymentVo.getOverdueDay());//逾期天数
                strategyVo.setRealOverdueDay(batchPostlendingPaymentVo.getRealOverdueDay());//实际逾期天数、扣款的时候改动的实际逾期天数
                strategyVo.setTotlePrice(batchPostlendingPaymentVo.getTotal());//
                strategyVo.setRealPrice(batchPostlendingPaymentVo.getTotal());//
                strategyVo.setContractId(batchPostlendingPaymentVo.getContractId());
                strategyVo.setRepaymentId(batchPostlendingPaymentVo.getRepaymentId());//款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款主键id
                strategyVo.setPayWay(batchStrategyVo.getPayWay());//支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他;6:批量补录;7:线下缴款登记;8:未开始还款;9:通联协议支付
                strategyVo.setPayType(batchStrategyVo.getType());//款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款/还款到最后一期的尾款; 5:提前还款罚款; 6:尾款/提前还款的尾款; 7:其他款项
                strategyVo.setSn(sn);//记录序号 通联批量代收
                strategyVo.setAllinpayBatchId(batchStrategyVo.getAllinpayBatchId());//所属批量代收批次主键id
                strategyVo.setSingleOrBatch(batchStrategyVo.getSingleOrBatch());//单笔或批量/0:单笔; 1:批量
                strategyVo.setControllerSource(batchStrategyVo.getControllerSource());//操作来源 0:单笔; 1:批量;2:手动批扣

                //如果是超额拆单提交则所有数据交易处于处理中状态
                Integer paymentResult = batchStrategyVo.getIsSpilt().equals(1) ? PaymentResult.TYPE_1 : batchStrategyVo.getPayWay().equals(PayWay.ALLIPAY_QUICK) ? CheckCode.checkPayPaymentResult(batchStrategyVo.getAipgrspRetCode(), batchStrategyVo.getRetCode()) : PaymentResult.TYPE_1;
                //如果是超额拆单提交则所有数据交易处于处理中状态
                strategyVo.setPaymentResult(paymentResult);//支付状态  0:未扣款/待付款 1:扣款中 2:已扣款/成功 3:失败

                strategyVo.setAccountId(batchPostlendingPaymentVo.getAccountId());
                strategyVo.setCreateTime(batchStrategyVo.getCreateTime());
                strategyVo.setUpdateTime(batchStrategyVo.getUpdateTime());
                strategyVo.setCreateBy(batchStrategyVo.getCreateBy());
                strategyVo.setUpdateBy(batchStrategyVo.getUpdateBy());
                strategyVo.setAllinpayStatusLogType(batchStrategyVo.getAllinpayStatusLogType());
                strategyVo.setRemarks(batchPostlendingPaymentVo.getRemarks());
                strategyVoList.add(strategyVo);
                postlendingInsertCommon.pstlendingCommon(strategyVoList, dubboTreaceParames);

            }
        }

        return true;
    }
}
