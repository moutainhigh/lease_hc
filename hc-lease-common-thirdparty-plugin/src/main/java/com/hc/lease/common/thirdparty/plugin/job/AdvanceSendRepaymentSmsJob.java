package com.hc.lease.common.thirdparty.plugin.job;

import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.StatusSmsType;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.adapter.api.MonthlyPaymentAdapter;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

/**
 * 定时器
 * 发送提前扣款短信提醒
 * 还款日7天前、3天前向承租人发送
 *
 * Created by tong on 2017/12/8.
 */
@Lazy(false)
@Component("advanceSendRepaymentSmsJob")
public class AdvanceSendRepaymentSmsJob {

    private Logger logger = LoggerFactory.getLogger(AdvanceSendRepaymentSmsJob.class);

    //每天执行(08:00) 发送提前扣款短信提醒
    @Scheduled(cron = "${job.advanceSendRepaymentSmsJob.corn}")
    public void advanceSendRepaymentSmsJob() throws GMException {
        logger.trace("======触发==定时器  提前扣款短信提醒====" + DateTime.now().toDate());
        long time = System.currentTimeMillis();
        DubboTreaceParames dubboTreaceParames = new DubboTreaceParames();
        dubboTreaceParames.setTreaceInterfaceName("com.hc.lease.common.thirdparty.plugin.job");//接口名称
        dubboTreaceParames.setTreaceMethodName("advanceSendRepaymentSmsJob");//接口方法名称
        dubboTreaceParames.setTreaceTime(DateTime.now().toDate());//操作时间
        dubboTreaceParames.setTreaceUserId(null);//操作用户主键id
        dubboTreaceParames.setTreaceUserName(null);//操作用户名称
        dubboTreaceParames.setTreace(UUID.randomUUID().toString());//此参数用于串连服务，同一个调用过程此参数相同，方便追踪

    }

}
