package com.hc.lease.postlending.strategy.impl;

import com.aipg.payresp.Ret_Detail;
import com.allinpay.util.CheckCode;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.PayWay;
import com.hc.lease.common.core.constant.PaymentResult;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.adapter.api.PostlendingInsertCommon;
import com.hc.lease.postlending.strategy.Strategy;
import com.hc.lease.postlending.vo.BatchPostlendingPaymentSplitVo;
import com.hc.lease.postlending.vo.BatchStrategySplitVo;
import com.hc.lease.postlending.vo.StrategySplitVo;
import hc.lease.common.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 通联支付拆单
 * 批量协议支付
 * Created by Administrator on 2018/6/21
 */
public class SplitBatchStrategy implements Strategy {

    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {

        BatchStrategySplitVo batchStrategySplitVo = (BatchStrategySplitVo) object1;
        BatchPostlendingPaymentSplitVo batchPostlendingPaymentSplitVo = (BatchPostlendingPaymentSplitVo) object2;

        PostlendingInsertCommon postlendingInsertCommon = (PostlendingInsertCommon) SpringContextHolder.getBean("postlendingInsertCommon");

        List<Ret_Detail> retDetails = batchStrategySplitVo.getRetDetails();
        for (Ret_Detail lobj : retDetails) {
            List<StrategySplitVo> strategySplitVoList = new ArrayList<StrategySplitVo>();
            StrategySplitVo strategySplitVo = new StrategySplitVo();
            strategySplitVo.setAllinpaySplitId(batchPostlendingPaymentSplitVo.getId());//通联支付超额拆分交易明细主键id
            strategySplitVo.setAipgrspRetCode(batchStrategySplitVo.getAipgrspRetCode());//通联返回的 头部 状态码
            strategySplitVo.setAipgrspErrMsg(batchStrategySplitVo.getAipgrspErrMsg());//通联返回的 头部 状态结果描述
            strategySplitVo.setRetCode(lobj.getRET_CODE());//通联返回的 明细 状态码
            strategySplitVo.setErrMsg(lobj.getERR_MSG());//通联返回的 明细 状态结果描述
            strategySplitVo.setFinalErrMsg(lobj.getERR_MSG());//如果头部返回成功状态则使用明细的状态结果描述
            strategySplitVo.setFinalCode(lobj.getRET_CODE());//如果头部返回成功状态则使用明细的状态码
            strategySplitVo.setRepTime(batchStrategySplitVo.getRepTime());
            strategySplitVo.setReqSn(batchStrategySplitVo.getReqSn());
            strategySplitVo.setStatus(batchStrategySplitVo.getStatus());//通联支付状态/0:已提交;1:成功;2:失败
            strategySplitVo.setTotlePrice(batchPostlendingPaymentSplitVo.getTotlePrice());//
            strategySplitVo.setContractId(batchPostlendingPaymentSplitVo.getContractId());
            strategySplitVo.setRepaymentId(batchPostlendingPaymentSplitVo.getRepaymentId());//款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款主键id
            strategySplitVo.setPayWay(batchPostlendingPaymentSplitVo.getPayWay());//支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他;6:批量补录;7:线下缴款登记;8:未开始还款;9:通联协议支付
            strategySplitVo.setAllinpayBatchId(batchStrategySplitVo.getAllinpayBatchId());//所属批量代收批次主键id
            strategySplitVo.setSingleOrBatch(batchStrategySplitVo.getSingleOrBatch());//单笔或批量/0:单笔; 1:批量
            strategySplitVo.setPaymentResult(batchPostlendingPaymentSplitVo.getPayWay().equals(PayWay.ALLIPAY_QUICK) ? CheckCode.checkPayPaymentResult(batchStrategySplitVo.getAipgrspRetCode(), batchStrategySplitVo.getRetCode()) : PaymentResult.TYPE_1);//支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败
            strategySplitVo.setAccountId(batchPostlendingPaymentSplitVo.getAccountId());
            strategySplitVo.setCreateBy(batchStrategySplitVo.getCreateBy());
            strategySplitVo.setUpdateBy(batchStrategySplitVo.getUpdateBy());
            strategySplitVo.setAllinpayStatusLogType(batchStrategySplitVo.getAllinpayStatusLogType());
            strategySplitVoList.add(strategySplitVo);
            postlendingInsertCommon.pstlendingCommonSplit(strategySplitVoList, dubboTreaceParames);
        }

        return true;
    }
}
