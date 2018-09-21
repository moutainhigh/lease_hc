package com.hc.lease.common.thirdparty.plugin.job;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.adapter.api.LeaseContractLinkRepaymentAdapter;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时 插入融租合同 的  挂靠还款明细
 * Created by tong on 2017/6/30.
 */
@Lazy(false)
@Component("contractLinkRepaymentJob")
public class ContractLinkRepaymentJob {

    private Logger logger = LoggerFactory.getLogger(ContractLinkRepaymentJob.class);

    @Autowired
    LeaseContractLinkRepaymentAdapter leaseContractLinkRepaymentAdapter;

    //每月1号凌晨执行(00:00)  定时 插入融租合同 的  挂靠还款明细
    @Scheduled(cron = "${job.timeInsert.corn}")
    public void timeInsert() throws GMException {
        logger.trace("======触发==定时器  定时 定时 插入融租合同 的  挂靠还款明细====" + DateTime.now().toDate());
        leaseContractLinkRepaymentAdapter.timeInsert();
    }

}
