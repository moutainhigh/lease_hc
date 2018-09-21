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
 * 定时器  检测扣款失败的代收发送短信
 * Created by tong on 2017/6/30.
 */
@Lazy(false)
@Component("sendSmsJob")
public class SendSmsJob {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MonthlyPaymentAdapter monthlyPaymentAdapter;

    /*
    //每30分钟触发一次  检测扣款失败的代收发送短信
    @Scheduled(cron = "${job.dualAllinpaySendSmsInfoInstall.corn}")
    public void dualAllinpaySendSmsInfoInstall() throws GMException {
        logger.trace("======触发=dualAllinpaySendSmsInfoInstall=====" + DateTime.now().toDate());
        DubboTreaceParames dubboTreaceParames = new DubboTreaceParames();
        dubboTreaceParames.setTreaceInterfaceName("com.hc.lease.common.thirdparty.plugin.job");//接口名称
        dubboTreaceParames.setTreaceMethodName("dualAllinpaySendSmsInfoInstall");//接口方法名称
        dubboTreaceParames.setTreaceTime(DateTime.now().toDate());//操作时间
        dubboTreaceParames.setTreaceUserId(null);//操作用户主键id
        dubboTreaceParames.setTreaceUserName(null);//操作用户名称
        dubboTreaceParames.setTreace(UUID.randomUUID().toString());//此参数用于串连服务，同一个调用过程此参数相同，方便追踪
        monthlyPaymentAdapter.dualAllinpaySendSmsInfoInstall(dubboTreaceParames);//扣款发送短信提醒
    }
    */

}
