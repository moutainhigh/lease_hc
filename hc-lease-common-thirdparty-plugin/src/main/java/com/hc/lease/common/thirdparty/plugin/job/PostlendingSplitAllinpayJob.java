package com.hc.lease.common.thirdparty.plugin.job;

import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.postlending.adapter.api.LeaseAllinpaySplitAdapter;
import com.hc.lease.postlending.adapter.api.MonthlyPaymentAdapter;
import com.hc.lease.postlending.vo.BatchPostlendingPaymentSplitVo;
import com.hc.lease.postlending.vo.TransSplitBody;
import hc.lease.common.util.DateUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 定时器 当日需要系统自动提交通联扣款的支付
 * Created by tong on 2018/6/26
 */
@Lazy(false)
@Component("postlendingSplitAllinpayJob")
public class PostlendingSplitAllinpayJob {

    private Logger logger = LoggerFactory.getLogger(PostlendingSplitAllinpayJob.class);

    @Autowired
    MonthlyPaymentAdapter monthlyPaymentAdapter;

    @Autowired
    LeaseAllinpaySplitAdapter leaseAllinpaySplitAdapter;

    //每日10点触发一次  轮询通联交易结果
    @Scheduled(cron = "${job.splitAllinpay.corn}")
    public void splitAllinpay() throws GMException {
        logger.trace("======定时器 当日需要系统自动提交通联扣款的支付=====");
        DubboTreaceParames dubboTreaceParames = new DubboTreaceParames();
        dubboTreaceParames.setTreaceInterfaceName("com.hc.lease.common.thirdparty.plugin.job.PostlendingSplitAllinpayJob");//接口名称
        dubboTreaceParames.setTreaceMethodName("splitAllinpay");//接口方法名称
        dubboTreaceParames.setTreaceTime(DateTime.now().toDate());//操作时间
        dubboTreaceParames.setTreaceUserId(null);//操作用户主键id
        dubboTreaceParames.setTreaceUserName(null);//操作用户名称
        dubboTreaceParames.setTreace(UUID.randomUUID().toString());//此参数用于串连服务，同一个调用过程此参数相同，方便追踪

        //处理当日的拆分明细/自动扣款
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("repaymentDate", DateUtil.smartFormat(DateUtils.getDate()));//当日时间
        paramsMap.put("status", 1);//状态 0:无操作1:挂起 2:取消挂起
        List<BatchPostlendingPaymentSplitVo> batchPostlendingPaymentSplitList = leaseAllinpaySplitAdapter.findBatchSplitDual(paramsMap, dubboTreaceParames);//批量协议支付 通联支付拆单 查询需要处理的数据/挂起的数据不处理
        if (batchPostlendingPaymentSplitList != null) {
            if (batchPostlendingPaymentSplitList.size() > 0) {
                TransSplitBody transSplitBody = new TransSplitBody();
                for (int i = 0; i < batchPostlendingPaymentSplitList.size(); i++) {
                    BatchPostlendingPaymentSplitVo batchPostlendingPaymentSplitVo = batchPostlendingPaymentSplitList.get(i);
                    transSplitBody.setAllinpaySplitId(batchPostlendingPaymentSplitVo.getId());
                    ResultHashMap resultHashMap = monthlyPaymentAdapter.dualSinglePostlendingPaymentSplit(transSplitBody, dubboTreaceParames);
                }
            }
        }
        //处理当日的拆分明细/自动扣款

    }

}
