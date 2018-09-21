package com.hc.lease.common.thirdparty.plugin.job;

import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.adapter.api.LeaseAllinpaySplitAdapter;
import hc.lease.common.util.DateUtils;
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
 * 定时器 定时处理拆分明细 是否已过自动扣款时间 0否 1是
 * Created by tong on 2018/6/21
 */
@Lazy(false)
@Component("ostlendingSplitStatusJob")
public class PostlendingSplitIsOverTimeJob {

    private Logger logger = LoggerFactory.getLogger(PostlendingSplitIsOverTimeJob.class);

    @Autowired
    LeaseAllinpaySplitAdapter leaseAllinpaySplitAdapter;

    //每日10点触发一次  轮询通联交易结果
    @Scheduled(cron = "${job.splitIsOverTime.corn}")
    public void splitIsOverTime() throws GMException {
        logger.trace("======定时器 定时处理拆分明细状态、挂起=====");
        DubboTreaceParames dubboTreaceParames = new DubboTreaceParames();
        dubboTreaceParames.setTreaceInterfaceName("com.hc.lease.common.thirdparty.plugin.job.PostlendingSplitStatusJob");//接口名称
        dubboTreaceParames.setTreaceMethodName("splitIsOverTime");//接口方法名称
        dubboTreaceParames.setTreaceTime(DateTime.now().toDate());//操作时间
        dubboTreaceParames.setTreaceUserId(null);//操作用户主键id
        dubboTreaceParames.setTreaceUserName(null);//操作用户名称
        dubboTreaceParames.setTreace(UUID.randomUUID().toString());//此参数用于串连服务，同一个调用过程此参数相同，方便追踪

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("repaymentDate", DateUtil.smartFormat(DateUtils.getDate()));//当日时间
        leaseAllinpaySplitAdapter.changeIsOverTime(paramsMap);

    }

}
