package com.hc.lease.postlending.strategy.impl;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.adapter.api.PostlendingInsertCommon;
import com.hc.lease.postlending.strategy.Strategy;
import com.hc.lease.postlending.vo.BatchPostlendingPaymentSplitVo;
import com.hc.lease.postlending.vo.StrategySplitVo;
import hc.lease.common.util.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 通联支付拆单
 * 单笔协议支付
 * Created by tong on 2018/6/21
 */
public class SplitInsertStrategy implements Strategy {

    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {
        BatchPostlendingPaymentSplitVo batchPostlendingPaymentSplitVo = (BatchPostlendingPaymentSplitVo) object2;
        PostlendingInsertCommon postlendingInsertCommon = (PostlendingInsertCommon) SpringContextHolder.getBean("postlendingInsertCommon");
        StrategySplitVo strategySplitVoObj = (StrategySplitVo) object1;
        StrategySplitVo strategySplitVo = null;
        List<StrategySplitVo> strategySplitVoList = new ArrayList<StrategySplitVo>();
        strategySplitVo = new StrategySplitVo();

        strategySplitVo.setReqSn(strategySplitVoObj.getReqSn());
        strategySplitVo.setAipgrspRetCode(strategySplitVoObj.getAipgrspRetCode());//通联返回的 头部 状态码
        strategySplitVo.setAipgrspErrMsg(strategySplitVoObj.getAipgrspErrMsg());//通联返回的 头部 状态结果描述
        strategySplitVo.setRetCode(strategySplitVoObj.getRetCode());//通联返回的 明细 状态码
        strategySplitVo.setErrMsg(strategySplitVoObj.getErrMsg());//通联返回的 明细 状态结果描述
        strategySplitVo.setFinalErrMsg(strategySplitVoObj.getFinalErrMsg());//如果头部返回成功状态则使用明细的状态结果描述
        strategySplitVo.setFinalCode(strategySplitVoObj.getFinalCode());//如果头部返回成功状态则使用明细的状态码
        strategySplitVo.setBackTime(strategySplitVoObj.getBackTime());
        strategySplitVo.setPaymentResult(strategySplitVoObj.getPaymentResult());
        strategySplitVo.setSingleOrBatch(strategySplitVoObj.getSingleOrBatch());
        strategySplitVo.setCreateBy(strategySplitVoObj.getCreateBy());
        strategySplitVo.setUpdateBy(strategySplitVoObj.getUpdateBy());
        strategySplitVo.setStatus(strategySplitVoObj.getStatus());
        strategySplitVo.setAllinpayStatusLogType(strategySplitVoObj.getAllinpayStatusLogType());
        strategySplitVo.setAccountId(batchPostlendingPaymentSplitVo.getAccountId());
        strategySplitVo.setPayWay(batchPostlendingPaymentSplitVo.getPayWay());
        strategySplitVo.setContractId(batchPostlendingPaymentSplitVo.getContractId());
        strategySplitVo.setRepaymentId(batchPostlendingPaymentSplitVo.getRepaymentId());
        strategySplitVo.setAllinpaySplitId(batchPostlendingPaymentSplitVo.getId());
        strategySplitVo.setTotlePrice(batchPostlendingPaymentSplitVo.getTotlePrice());
        strategySplitVoList.add(strategySplitVo);
        postlendingInsertCommon.pstlendingCommonSplit(strategySplitVoList, dubboTreaceParames);
        return true;
    }
}