package com.hc.lease.postlending.adapter.impl;

import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseSchemeRepaymentStatus;
import com.hc.lease.order.service.api.LeaseSchemeRepaymentStatusService;
import com.hc.lease.postlending.adapter.api.PostlendingInsertCommon;
import com.hc.lease.postlending.model.*;
import com.hc.lease.postlending.service.api.*;
import com.hc.lease.postlending.vo.RemarksVo;
import com.hc.lease.postlending.vo.StrategySplitVo;
import com.hc.lease.postlending.vo.StrategyVo;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 贷后
 * 通联支付
 * 代收、协议支付
 * 策略模式 公共处理
 * Created by tong on 2017/8/28.
 */
@Service("postlendingInsertCommon")
public class PostlendingInsertCommonImpl implements PostlendingInsertCommon {
    @Autowired
    private LeaseAllinpayLogService leaseAllinpayLogService;
    @Autowired
    private LeaseAllinpayStatusLogService leaseAllinpayStatusLogService;
    @Autowired
    private LeaseSchemeRepaymentStatusService leaseSchemeRepaymentStatusService;

    @Autowired
    private LeaseAllinpaySplitLogService leaseAllinpaySplitLogService;
    @Autowired
    private LeaseAllinpaySplitStatusLogService leaseAllinpaySplitStatusLogService;
    @Autowired
    private LeaseAllinpaySplitService leaseAllinpaySplitService;

    public Object pstlendingCommon(List<StrategyVo> strategyVoList, DubboTreaceParames dubboTreaceParames) throws GMException {
        try {
            Map<String, Object> paramsMap = Maps.newHashMap();
            for (int i = 0; i < strategyVoList.size(); i++) {
                StrategyVo strategyVo = strategyVoList.get(i);
                //支付状态汇总管理
                paramsMap.put("repaymentId", strategyVo.getRepaymentId());
                paramsMap.put("contractId", strategyVo.getContractId());
                paramsMap.put("type", strategyVo.getPayType());
                LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus = leaseSchemeRepaymentStatusService.findByType(paramsMap, dubboTreaceParames);//查询某个合同某一期的某种款项的数据
                if (leaseSchemeRepaymentStatus != null) {
                    leaseSchemeRepaymentStatus.setContractId(strategyVo.getContractId());//融租合同主键id
                    leaseSchemeRepaymentStatus.setRepaymentId(strategyVo.getRepaymentId());//款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款明细主键id
                    leaseSchemeRepaymentStatus.setTotlePrice(strategyVo.getRealPrice());//金额
                    leaseSchemeRepaymentStatus.setPayWay(strategyVo.getPayWay());//支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他
                    leaseSchemeRepaymentStatus.setType(strategyVo.getPayType());//款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款/还款到最后一期的尾款; 5:提前还款罚款; 6:尾款/提前还款的尾款; 7:其他款项
                    leaseSchemeRepaymentStatus.setSn(strategyVo.getSn());
                    leaseSchemeRepaymentStatus.setPaymentResult(strategyVo.getPaymentResult());//支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败
                    leaseSchemeRepaymentStatus.setUpdateBy(strategyVo.getUpdateBy());
                    leaseSchemeRepaymentStatus.setPaymentResultMsg(strategyVo.getFinalErrMsg());//通联返回的 明细 状态结果描述
                    leaseSchemeRepaymentStatus.setReqSn(strategyVo.getReqSn());
                    leaseSchemeRepaymentStatus.setUpdateTime(strategyVo.getUpdateTime());
                    leaseSchemeRepaymentStatusService.updateByPrimaryKeySelective(leaseSchemeRepaymentStatus);
                } else {
                    leaseSchemeRepaymentStatus = new LeaseSchemeRepaymentStatus();
                    leaseSchemeRepaymentStatus.setContractId(strategyVo.getContractId());//融租合同主键id
                    leaseSchemeRepaymentStatus.setRepaymentId(strategyVo.getRepaymentId());//款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款明细主键id
                    leaseSchemeRepaymentStatus.setTotlePrice(strategyVo.getRealPrice());//金额
                    leaseSchemeRepaymentStatus.setPayWay(strategyVo.getPayWay());//支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他
                    leaseSchemeRepaymentStatus.setType(strategyVo.getPayType());//款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款/还款到最后一期的尾款; 5:提前还款罚款; 6:尾款/提前还款的尾款; 7:其他款项
                    leaseSchemeRepaymentStatus.setSn(strategyVo.getSn());
                    leaseSchemeRepaymentStatus.setPaymentResult(strategyVo.getPaymentResult());//支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败
                    leaseSchemeRepaymentStatus.setCreateBy(strategyVo.getCreateBy());
                    leaseSchemeRepaymentStatus.setUpdateBy(strategyVo.getUpdateBy());
                    leaseSchemeRepaymentStatus.setPaymentResultMsg(strategyVo.getFinalErrMsg());//通联返回的 明细 状态结果描述
                    leaseSchemeRepaymentStatus.setReqSn(strategyVo.getReqSn());
                    leaseSchemeRepaymentStatus.setUpdateTime(strategyVo.getUpdateTime());
                    leaseSchemeRepaymentStatus.setCreateTime(strategyVo.getCreateTime());
                    leaseSchemeRepaymentStatus = leaseSchemeRepaymentStatusService.insertSelective(leaseSchemeRepaymentStatus);
                }
                //支付状态汇总管理

                //插入 代收流水 数据
                LeaseAllinpayLog leaseAllinpayLog = new LeaseAllinpayLog();
                leaseAllinpayLog.setTotlePrice(strategyVo.getTotlePrice());//合计金额
                leaseAllinpayLog.setRealPrice(strategyVo.getRealPrice());//实际逾期金额、单笔扣款的时候改动的实际逾期金额
                leaseAllinpayLog.setContractId(strategyVo.getContractId());
                leaseAllinpayLog.setRepaymentId(strategyVo.getRepaymentId());//融租合同-还款计划明细主键id
                leaseAllinpayLog.setPayWay(strategyVo.getPayWay());//支付方式 通联
                leaseAllinpayLog.setPayType(strategyVo.getPayType());//款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款/还款到最后一期的尾款; 5:提前还款罚款; 6:尾款/提前还款的尾款; 7:其他款项
                leaseAllinpayLog.setSn(strategyVo.getSn());
                leaseAllinpayLog.setAllinpayBatchId(strategyVo.getAllinpayBatchId());//通联批量代收批次统计主键id
                leaseAllinpayLog.setSingleOrBatch(strategyVo.getSingleOrBatch());//单笔或批量/0:单笔; 1:批量
                leaseAllinpayLog.setAccountId(strategyVo.getAccountId());
                leaseAllinpayLog.setCreateBy(strategyVo.getCreateBy());
                leaseAllinpayLog.setCreateTime(strategyVo.getCreateTime());
                leaseAllinpayLog.setUpdateBy(strategyVo.getUpdateBy());
                leaseAllinpayLog.setCreateTime(strategyVo.getCreateTime());
                leaseAllinpayLog.setUpdateTime(strategyVo.getUpdateTime());
                leaseAllinpayLog.setRepaymentStatusId(leaseSchemeRepaymentStatus.getId());
                leaseAllinpayLog.setRemarks(strategyVo.getSingleOrBatch() == 0 ? installRemark(strategyVo) : strategyVo.getRemarks());//备注
                leaseAllinpayLog.setOverdue(strategyVo.getOverdue() == null ? false : strategyVo.getOverdue());//是否逾期
                leaseAllinpayLog.setOverdueDay(strategyVo.getOverdueDay());//逾期天数
                leaseAllinpayLog.setRealOverdueDay(strategyVo.getRealOverdueDay());//实际逾期天数、单笔扣款的时候改动的实际逾期天数
                leaseAllinpayLog.setReqSn(strategyVo.getReqSn());//通联返回的 文件名/可用于通联流水查询
                leaseAllinpayLog.setRetCode(strategyVo.getFinalCode());//通联返回的 最终 状态码/结合 头部 和 明细 状态判断
                leaseAllinpayLog.setErrMsg(strategyVo.getFinalErrMsg());//通联返回的 最终 状态结果描述/结合 头部 和 明细 状态判断
                leaseAllinpayLog.setBackTime(DateUtil.stampToDate(strategyVo.getRepTime()));//通联支付反馈状态日期
                leaseAllinpayLog.setStatus(strategyVo.getStatus());//通联支付状态/0:已提交;1:成功;2:失败
                leaseAllinpayLog.setControllerSource(strategyVo.getControllerSource());
                leaseAllinpayLog = leaseAllinpayLogService.insertSelective(leaseAllinpayLog);
                //插入 代收流水 数据

                //插入 代收状态流水 数据
                LeaseAllinpayStatusLog leaseAllinpayStatusLog = new LeaseAllinpayStatusLog();
                leaseAllinpayStatusLog.setAllinpayLogId(leaseAllinpayLog.getId());//代收流水主键id
                leaseAllinpayStatusLog.setBackTime(strategyVo.getCreateTime());//通联支付反馈状态日期
                leaseAllinpayStatusLog.setCreateTime(strategyVo.getCreateTime());//
                leaseAllinpayStatusLog.setRetCode(strategyVo.getFinalCode());//通联返回的 明细 状态码
                leaseAllinpayStatusLog.setErrMsg(strategyVo.getFinalErrMsg());//通联返回的 明细 状态结果描述
                leaseAllinpayStatusLog.setCreateBy(strategyVo.getCreateBy());
                leaseAllinpayStatusLog.setType(strategyVo.getAllinpayStatusLogType());
                leaseAllinpayStatusLog.setPaymentResult(strategyVo.getPaymentResult());//支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败
                leaseAllinpayStatusLog.setPaymentResultMsg(strategyVo.getFinalErrMsg());//通联返回的 明细 状态结果描述
                leaseAllinpayStatusLog = leaseAllinpayStatusLogService.insertSelective(leaseAllinpayStatusLog);
                //插入 代收状态流水 数据

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 批量协议支付
     * 通联支付拆单
     *
     * @param strategySplitVoList
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    @Override
    public Object pstlendingCommonSplit(List<StrategySplitVo> strategySplitVoList, DubboTreaceParames dubboTreaceParames) throws GMException {
        try {
            Map<String, Object> paramsMap = Maps.newHashMap();
            Date dateTime = DateTime.now().toDate();
            for (int i = 0; i < strategySplitVoList.size(); i++) {
                StrategySplitVo strategySplitVo = strategySplitVoList.get(i);

                LeaseAllinpaySplit leaseAllinpaySplit = new LeaseAllinpaySplit();
                leaseAllinpaySplit.setId(strategySplitVo.getAllinpaySplitId());
                leaseAllinpaySplit.setContractId(strategySplitVo.getContractId());//融租合同主键id
                leaseAllinpaySplit.setRepaymentId(strategySplitVo.getRepaymentId());//款项主键id，融租合同-还款计划明细主键id / 融租合同-挂靠还款明细主键id / 融租合同 提前还款明细主键id
                leaseAllinpaySplit.setTotlePrice(strategySplitVo.getTotlePrice());//金额
                leaseAllinpaySplit.setPayWay(strategySplitVo.getPayWay());//支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他
                leaseAllinpaySplit.setSn(strategySplitVo.getSn());
                leaseAllinpaySplit.setPaymentResult(strategySplitVo.getPaymentResult());//支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败
                leaseAllinpaySplit.setUpdateBy(strategySplitVo.getUpdateBy());
                leaseAllinpaySplit.setPaymentResultMsg(strategySplitVo.getFinalErrMsg());//通联返回的 明细 状态结果描述
                leaseAllinpaySplit.setReqSn(strategySplitVo.getReqSn());
                leaseAllinpaySplit.setUpdateTime(dateTime);
                leaseAllinpaySplitService.updateByPrimaryKeySelective(leaseAllinpaySplit);

                //插入 代收流水 数据
                LeaseAllinpaySplitLog leaseAllinpaySplitLog = new LeaseAllinpaySplitLog();
                leaseAllinpaySplitLog.setTotlePrice(strategySplitVo.getTotlePrice());//合计金额
                leaseAllinpaySplitLog.setContractId(strategySplitVo.getContractId());
                leaseAllinpaySplitLog.setRepaymentId(strategySplitVo.getRepaymentId());//融租合同-还款计划明细主键id
                leaseAllinpaySplitLog.setPayWay(strategySplitVo.getPayWay());//支付方式 通联
                leaseAllinpaySplitLog.setSn(strategySplitVo.getSn());
                leaseAllinpaySplitLog.setAllinpayBatchId(strategySplitVo.getAllinpayBatchId());//通联批量代收批次统计主键id
                leaseAllinpaySplitLog.setSingleOrBatch(strategySplitVo.getSingleOrBatch());//单笔或批量/0:单笔; 1:批量
                leaseAllinpaySplitLog.setCreateBy(strategySplitVo.getCreateBy());
                leaseAllinpaySplitLog.setUpdateBy(strategySplitVo.getUpdateBy());
                leaseAllinpaySplitLog.setCreateTime(dateTime);
                leaseAllinpaySplitLog.setUpdateTime(dateTime);
                leaseAllinpaySplitLog.setAllinpaySplitId(strategySplitVo.getAllinpaySplitId());
                leaseAllinpaySplitLog.setReqSn(strategySplitVo.getReqSn());//通联返回的 文件名/可用于通联流水查询
                leaseAllinpaySplitLog.setRetCode(strategySplitVo.getFinalCode());//通联返回的 最终 状态码/结合 头部 和 明细 状态判断
                leaseAllinpaySplitLog.setErrMsg(strategySplitVo.getFinalErrMsg());//通联返回的 最终 状态结果描述/结合 头部 和 明细 状态判断
                leaseAllinpaySplitLog.setBackTime(DateUtil.stampToDate(strategySplitVo.getRepTime()));//通联支付反馈状态日期
                leaseAllinpaySplitLog.setStatus(strategySplitVo.getStatus());//通联支付状态/0:已提交;1:成功;2:失败
                leaseAllinpaySplitLog = leaseAllinpaySplitLogService.insertSelective(leaseAllinpaySplitLog);
                //插入 代收流水 数据

                //插入 代收状态流水 数据
                LeaseAllinpaySplitStatusLog leaseAllinpaySplitStatusLog = new LeaseAllinpaySplitStatusLog();
                leaseAllinpaySplitStatusLog.setAllinpaySplitLogId(leaseAllinpaySplitLog.getId());//代收流水主键id
                leaseAllinpaySplitStatusLog.setBackTime(dateTime);//通联支付反馈状态日期
                leaseAllinpaySplitStatusLog.setCreateTime(dateTime);//
                leaseAllinpaySplitStatusLog.setRetCode(strategySplitVo.getFinalCode());//通联返回的 明细 状态码
                leaseAllinpaySplitStatusLog.setErrMsg(strategySplitVo.getFinalErrMsg());//通联返回的 明细 状态结果描述
                leaseAllinpaySplitStatusLog.setCreateBy(strategySplitVo.getCreateBy());
                leaseAllinpaySplitStatusLog.setType(strategySplitVo.getAllinpayStatusLogType());
                leaseAllinpaySplitStatusLog.setPaymentResult(strategySplitVo.getPaymentResult());//支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败
                leaseAllinpaySplitStatusLog.setPaymentResultMsg(strategySplitVo.getFinalErrMsg());//通联返回的 明细 状态结果描述
                leaseAllinpaySplitStatusLog = leaseAllinpaySplitStatusLogService.insertSelective(leaseAllinpaySplitStatusLog);
                //插入 代收状态流水 数据

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 单笔综合扣款
     * 处理备注数据
     *
     * @param strategyVo
     * @return
     */
    public String installRemark(StrategyVo strategyVo) {
        Long contractId = strategyVo.getContractId();
        Long repaymentId = strategyVo.getRepaymentId();
        List<RemarksVo> remarksVoList = strategyVo.getRemarksVo();
        String remarks = null;
        if (remarksVoList != null) {
            if (remarksVoList.size() > 0) {
                for (int i = 0; i < remarksVoList.size(); i++) {
                    RemarksVo remarksVo = remarksVoList.get(i);
                    Long contractId_1 = remarksVo.getContractId();
                    Long repaymentId_1 = remarksVo.getRepaymentId();
                    if (contractId.equals(contractId_1) && repaymentId.equals(repaymentId_1)) {
                        remarks = remarksVo.getRemarks();
                        break;
                    }
                }
            }
        }
        return remarks;
    }

}