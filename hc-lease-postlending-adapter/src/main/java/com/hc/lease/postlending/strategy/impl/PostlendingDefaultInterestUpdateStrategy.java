package com.hc.lease.postlending.strategy.impl;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.RetCode;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseContractAdvance;
import com.hc.lease.order.service.api.LeaseContractAdvanceService;
import com.hc.lease.postlending.adapter.api.PostlendingUpdateCommon;
import com.hc.lease.postlending.strategy.Strategy;
import com.hc.lease.postlending.vo.TransBody;
import hc.lease.common.util.SpringContextHolder;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通联支付
 * 提前还款罚款
 * 贷后代通联代扣收 处理 提前还款罚款 流水和状态
 * 根据 通联 轮询回来的处理结果 ，更新 代收流水 状态 / 更新 支付状态汇总管理 状态
 * Created by Administrator on 2017/8/28.
 */
public class PostlendingDefaultInterestUpdateStrategy implements Strategy {

    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {
        PostlendingUpdateCommon postlendingUpdateCommon = (PostlendingUpdateCommon) SpringContextHolder.getBean("postlendingUpdateCommon");
        LeaseContractAdvanceService leaseContractAdvanceService = (LeaseContractAdvanceService) SpringContextHolder.getBean("leaseContractAdvanceService");
        TransBody transBody = (TransBody) object1;
        postlendingUpdateCommon.pstlendingCommon(transBody, dubboTreaceParames);

        LeaseContractAdvance leaseContractAdvance = new LeaseContractAdvance();
        leaseContractAdvance.setPaymentResult(RetCode.checkPaymentResult(transBody.getAipgrspRetCode(), transBody.getRetCode()));//支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败
        leaseContractAdvance.setPaymentResultMsg(transBody.getErrMsg());
        leaseContractAdvance.setReqSn(transBody.getReqSn());
        leaseContractAdvance.setUpdateTime(DateTime.now().toDate());
        leaseContractAdvance.setId(transBody.getRepaymentId());
        leaseContractAdvanceService.updateByPrimaryKeySelective(leaseContractAdvance);
        return true;
    }
}
