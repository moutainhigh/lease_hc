package com.hc.lease.postlending.strategy.impl;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.RetCode;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.adapter.api.PostlendingUpdateCommon;
import com.hc.lease.postlending.model.LeaseOverdueLog;
import com.hc.lease.postlending.service.api.LeaseOverdueLogService;
import com.hc.lease.postlending.strategy.Strategy;
import com.hc.lease.postlending.vo.TransBody;
import hc.lease.common.util.SpringContextHolder;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通联支付
 * 逾期滞纳金
 * 通联代扣 处理 逾期滞纳金 流水和状态
 * 根据 通联 轮询回来的处理结果 ，更新 代收流水 状态 / 更新 支付状态汇总管理 状态
 * Created by Administrator on 2017/8/28.
 */
public class PostlendingOverdueUpdateStrategy implements Strategy {

    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {
        PostlendingUpdateCommon postlendingUpdateCommon = (PostlendingUpdateCommon) SpringContextHolder.getBean("postlendingUpdateCommon");
        LeaseOverdueLogService leaseOverdueLogService = (LeaseOverdueLogService) SpringContextHolder.getBean("leaseOverdueLogService");
        TransBody transBody = (TransBody) object1;
        postlendingUpdateCommon.pstlendingCommon(transBody, dubboTreaceParames);

        //更新 逾期记录 支付状态
        LeaseOverdueLog leaseOverdueLog = new LeaseOverdueLog();
        leaseOverdueLog.setRepaymentId(transBody.getRepaymentId());
        leaseOverdueLog.setUpdateTime(DateTime.now().toDate());
        leaseOverdueLog.setPaymentResult(RetCode.checkPaymentResult(transBody.getAipgrspRetCode(), transBody.getRetCode()));
        leaseOverdueLog.setType(transBody.getOverdueType());
        int row3 = leaseOverdueLogService.updateStatus(leaseOverdueLog, dubboTreaceParames);
        //更新 逾期记录 支付状态

        return true;
    }
}
