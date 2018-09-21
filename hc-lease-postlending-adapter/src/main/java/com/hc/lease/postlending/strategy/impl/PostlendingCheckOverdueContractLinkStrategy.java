package com.hc.lease.postlending.strategy.impl;

import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.PayWay;
import com.hc.lease.common.core.constant.PaymentResult;
import com.hc.lease.common.core.constant.RepaymentStatusType;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseContractLinkRepayment;
import com.hc.lease.order.model.LeaseSchemeRepaymentStatus;
import com.hc.lease.order.service.api.LeaseContractLinkRepaymentService;
import com.hc.lease.order.service.api.LeaseSchemeRepaymentStatusService;
import com.hc.lease.postlending.model.LeaseOverdueLog;
import com.hc.lease.postlending.service.api.LeaseOverdueLogService;
import com.hc.lease.postlending.strategy.Strategy;
import hc.lease.common.util.SpringContextHolder;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 贷后
 * 定时检测逾期的挂靠费并插入逾期流水
 * Created by Administrator on 2017/8/28.
 */
public class PostlendingCheckOverdueContractLinkStrategy implements Strategy {

    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {
        LeaseSchemeRepaymentStatusService leaseSchemeRepaymentStatusService = (LeaseSchemeRepaymentStatusService) SpringContextHolder.getBean("leaseSchemeRepaymentStatusService");
        LeaseContractLinkRepaymentService leaseContractLinkRepaymentService = (LeaseContractLinkRepaymentService) SpringContextHolder.getBean("leaseContractLinkRepaymentService");
        LeaseOverdueLogService leaseOverdueLogService = (LeaseOverdueLogService) SpringContextHolder.getBean("leaseOverdueLogService");

        Map<String, Object> paramsMap = Maps.newHashMap();
        Date nowDate = DateTime.now().toDate();
        List<LeaseContractLinkRepayment> leaseContractLinkRepaymentList = leaseContractLinkRepaymentService.checkOverdue(paramsMap, dubboTreaceParames);
        List<LeaseOverdueLog> leaseOverdueLogInsertBatch = new ArrayList<LeaseOverdueLog>();
        List<LeaseOverdueLog> leaseOverdueLogUpdateBatch = new ArrayList<LeaseOverdueLog>();
        if (leaseContractLinkRepaymentList != null) {
            if (leaseContractLinkRepaymentList.size() > 0) {
                for (int i = 0; i < leaseContractLinkRepaymentList.size(); i++) {
                    Long accountId = leaseContractLinkRepaymentList.get(i).getAccountId();
                    Long id = leaseContractLinkRepaymentList.get(i).getId();
                    Long contractId = leaseContractLinkRepaymentList.get(i).getContractId();
                    Date repaymentDate = leaseContractLinkRepaymentList.get(i).getRepaymentDate();
                    leaseContractLinkRepaymentList.get(i).setOverdue(0);//是否逾期 0 是 1 否

                    Integer timeDifference = Integer.parseInt(String.valueOf(DateUtil.timeDifference(repaymentDate, nowDate)));//两个日期秒数相差
                    Integer overdueDayUp = DateUtil.secondsToDate(timeDifference);//逾期天数

                    BigDecimal totlePrice = leaseContractLinkRepaymentList.get(i).getTotlePrice();
                    leaseContractLinkRepaymentList.get(i).setOverdueDay(overdueDayUp);

                    //更新/新增 逾期记录 数据
                    paramsMap.put("repaymentId", id);//款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id
                    paramsMap.put("contractId", contractId);
                    paramsMap.put("type", RepaymentStatusType.TYPE_1);//款项类型 0:月租;1:挂靠
                    LeaseOverdueLog leaseOverdueLog = leaseOverdueLogService.selectByContractIdRepaymentId(paramsMap, dubboTreaceParames);
                    BigDecimal totalOverdue = leaseOverdueLog.getOverdueRate().multiply(new BigDecimal(overdueDayUp)).multiply(totlePrice).setScale(2, BigDecimal.ROUND_HALF_UP);
                    if (leaseOverdueLog != null) {//更新
                        leaseOverdueLog.setContractId(contractId);
                        leaseOverdueLog.setRepaymentId(id);
                        leaseOverdueLog.setUpdateTime(nowDate);
                        leaseOverdueLog.setOverdueDay(overdueDayUp);
                        leaseOverdueLog.setNowTime(nowDate);
                        leaseOverdueLog.setPrice(leaseOverdueLog.getOverdueRate() == null ? new BigDecimal(0) : totalOverdue);
                        leaseOverdueLogUpdateBatch.add(leaseOverdueLog);
                    } else {//新增
                        leaseOverdueLog = new LeaseOverdueLog();
                        leaseOverdueLog.setContractId(contractId);
                        leaseOverdueLog.setRepaymentId(id);
                        leaseOverdueLog.setUpdateTime(nowDate);
                        leaseOverdueLog.setOverdueDay(overdueDayUp);
                        leaseOverdueLog.setAccountId(accountId);
                        leaseOverdueLog.setCreateTime(nowDate);
                        leaseOverdueLog.setRepaymentTime(repaymentDate);
                        leaseOverdueLog.setNowTime(nowDate);
                        leaseOverdueLog.setPaymentResult(PaymentResult.TYPE_0);//支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败
                        leaseOverdueLog.setType(RepaymentStatusType.TYPE_1);//款项类型 0:月租;1:挂靠
                        leaseOverdueLog.setPrice(leaseOverdueLog.getOverdueRate() == null ? new BigDecimal(0) : totalOverdue);
                        leaseOverdueLogInsertBatch.add(leaseOverdueLog);
                    }
                    //更新/新增 逾期记录 数据

                    //插入逾期 支付状态汇总管理
                    paramsMap.put("type", RepaymentStatusType.TYPE_2);//款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款; 5:提前还款罚款
                    LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus = leaseSchemeRepaymentStatusService.findByType(paramsMap, dubboTreaceParames);
                    if (leaseSchemeRepaymentStatus != null) {
                        leaseSchemeRepaymentStatus.setRepaymentId(id);//款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款明细主键id
                        leaseSchemeRepaymentStatus.setContractId(contractId);//融租合同主键id
                        leaseSchemeRepaymentStatus.setType(RepaymentStatusType.TYPE_2);//款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款; 5:提前还款罚款
                        leaseSchemeRepaymentStatus.setUpdateTime(DateTime.now().toDate());
                        leaseSchemeRepaymentStatus.setUpdateBy(null);
                        leaseSchemeRepaymentStatusService.updateByPrimaryKeySelective(leaseSchemeRepaymentStatus);
                    } else {
                        leaseSchemeRepaymentStatus = new LeaseSchemeRepaymentStatus();
                        leaseSchemeRepaymentStatus.setRepaymentId(id);//款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款明细主键id
                        leaseSchemeRepaymentStatus.setContractId(contractId);//融租合同主键id
                        leaseSchemeRepaymentStatus.setType(RepaymentStatusType.TYPE_2);//款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款; 5:提前还款罚款
                        leaseSchemeRepaymentStatus.setUpdateTime(DateTime.now().toDate());
                        leaseSchemeRepaymentStatus.setUpdateBy(null);
                        leaseSchemeRepaymentStatus.setCreateTime(DateTime.now().toDate());
                        leaseSchemeRepaymentStatus.setCreateBy(null);
                        leaseSchemeRepaymentStatus.setTotlePrice(leaseOverdueLog.getOverdueRate() == null ? new BigDecimal(0) : totalOverdue);
                        leaseSchemeRepaymentStatus.setPaymentResult(PaymentResult.TYPE_0);//支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败
                        leaseSchemeRepaymentStatus.setPayWay(PayWay.DEFUAL);
                        leaseSchemeRepaymentStatus = leaseSchemeRepaymentStatusService.insertSelective(leaseSchemeRepaymentStatus);
                    }
                    //插入逾期 支付状态汇总管理

                }
                leaseContractLinkRepaymentService.batchUpdate(leaseContractLinkRepaymentList);//更新 还款记录 逾期

                //更新 逾期记录 数据
                if (leaseOverdueLogUpdateBatch.size() > 0) {
                    leaseOverdueLogService.updateBatch(leaseOverdueLogUpdateBatch, dubboTreaceParames);
                }
                //更新 逾期记录 数据

                //新增 逾期记录 数据
                if (leaseOverdueLogInsertBatch.size() > 0) {
                    leaseOverdueLogService.insertBatch(leaseOverdueLogInsertBatch, dubboTreaceParames);
                }
                //新增 逾期记录 数据

            }
        }

        return true;
    }
}
