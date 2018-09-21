package com.hc.lease.common.thirdparty.plugin.job;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.adapter.api.LeaseSchemeRepaymentStatusAdapter;
import com.hc.lease.order.model.LeaseSchemeRepaymentStatus;
import com.hc.lease.postlending.adapter.api.LeaseAllinpayBatchAdapter;
import com.hc.lease.postlending.adapter.api.LeaseAllinpaySplitConnectAdapter;
import com.hc.lease.postlending.vo.FindSplitCheckMapVo;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 定时器 检测拆分明细扣款结果，还款计划明细全部成功扣款则更新状态
 * Created by tong on 2018/6/21
 */
@Lazy(false)
@Component("postlendingSplitCheckJob")
public class PostlendingSplitCheckJob {

    private Logger logger = LoggerFactory.getLogger(PostlendingSplitCheckJob.class);

    @Autowired
    LeaseAllinpaySplitConnectAdapter leaseAllinpaySplitConnectAdapter;

    @Autowired
    LeaseSchemeRepaymentStatusAdapter leaseSchemeRepaymentStatusAdapter;

    //每3分钟触发一次  轮询通联交易结果
    @Scheduled(cron = "${job.queryTradeNewSplitCheck.corn}")
    public void postlendingJobQueryTradeNewSplitCheck() throws GMException {
        logger.trace("======定时器 定时轮询通联超额拆分交易结果，还款计划明细全部成功扣款则更新状态=====");
        DubboTreaceParames dubboTreaceParames = new DubboTreaceParames();
        dubboTreaceParames.setTreaceInterfaceName("com.hc.lease.common.thirdparty.plugin.job.PostlendingSplitCheckJob");//接口名称
        dubboTreaceParames.setTreaceMethodName("postlendingJobQueryTradeNewSplitCheck");//接口方法名称
        dubboTreaceParames.setTreaceTime(DateTime.now().toDate());//操作时间
        dubboTreaceParames.setTreaceUserId(null);//操作用户主键id
        dubboTreaceParames.setTreaceUserName(null);//操作用户名称
        dubboTreaceParames.setTreace(UUID.randomUUID().toString());//此参数用于串连服务，同一个调用过程此参数相同，方便追踪

        List<FindSplitCheckMapVo> findSplitCheckMapVoList = leaseAllinpaySplitConnectAdapter.findSplitCheck(null);//查询拆分的的明细全部扣款成功的数据
        if (findSplitCheckMapVoList != null) {
            if (findSplitCheckMapVoList.size() > 0) {
                List<LeaseSchemeRepaymentStatus> leaseSchemeRepaymentStatusList = new ArrayList<LeaseSchemeRepaymentStatus>();
                for (int i = 0; i < findSplitCheckMapVoList.size(); i++) {
                    LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus = new LeaseSchemeRepaymentStatus();
                    FindSplitCheckMapVo findSplitCheckMapVo = findSplitCheckMapVoList.get(i);
                    leaseSchemeRepaymentStatus.setRepaymentId(findSplitCheckMapVo.getRepaymentId());
                    leaseSchemeRepaymentStatus.setContractId(findSplitCheckMapVo.getContractId());
                    leaseSchemeRepaymentStatus.setPaymentResult(2);
                    leaseSchemeRepaymentStatus.setPaymentResultMsg("处理成功");
                    leaseSchemeRepaymentStatusList.add(leaseSchemeRepaymentStatus);
                }
                leaseSchemeRepaymentStatusAdapter.batchUpdateBySplitCheck(leaseSchemeRepaymentStatusList);
            }
        }
    }

}
