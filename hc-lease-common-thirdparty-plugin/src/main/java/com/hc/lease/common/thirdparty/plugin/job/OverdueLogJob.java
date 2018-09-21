package com.hc.lease.common.thirdparty.plugin.job;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.adapter.api.MonthlyPaymentAdapter;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 定时器  定时 检测 逾期的 还款记录 并插入 逾期流水
 * Created by tong on 2017/6/30.
 */
@Lazy(false)
@Component("overdueLogJob")
public class OverdueLogJob {

    private Logger logger = LoggerFactory.getLogger(OverdueLogJob.class);

    @Autowired
    MonthlyPaymentAdapter monthlyPaymentAdapter;

    //每天凌晨执行(23:59)  定时 检测 逾期的 还款记录 并插入 逾期流水
    @Scheduled(cron = "${job.overdueLogJob.corn}")
    public void overdueLogJobFindIsOverdueLog() throws GMException {
        logger.trace("======触发==定时器  定时 检测 逾期的 还款记录 并插入 逾期流水====" + DateTime.now().toDate());
        long time = System.currentTimeMillis();
        DubboTreaceParames dubboTreaceParames = new DubboTreaceParames();
        dubboTreaceParames.setTreaceInterfaceName("com.hc.lease.common.thirdparty.plugin.job");//接口名称
        dubboTreaceParames.setTreaceMethodName("overdueLogJobFindIsOverdueLog");//接口方法名称
        dubboTreaceParames.setTreaceTime(DateTime.now().toDate());//操作时间
        dubboTreaceParames.setTreaceUserId(null);//操作用户主键id
        dubboTreaceParames.setTreaceUserName(null);//操作用户名称
        dubboTreaceParames.setTreace(UUID.randomUUID().toString());//此参数用于串连服务，同一个调用过程此参数相同，方便追踪

        monthlyPaymentAdapter.findIsOverdue(dubboTreaceParames);
    }

}
