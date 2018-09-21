package com.hc.lease.postlending.adapter.impl;

import com.allinpay.util.CheckCode;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.AllinpayStatusLogType;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.RetCode;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseSchemeRepaymentStatus;
import com.hc.lease.order.service.api.LeaseSchemeRepaymentStatusService;
import com.hc.lease.postlending.adapter.api.PostlendingUpdateCommon;
import com.hc.lease.postlending.model.*;
import com.hc.lease.postlending.service.api.*;
import com.hc.lease.postlending.vo.TransBody;
import com.hc.lease.postlending.vo.TransSplitBody;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 贷后代收
 * 根据 通联 轮询回来的处理结果 ，更新 代收流水 状态 / 更新 支付状态汇总管理 状态
 * 策略模式 公共处理
 * Created by Administrator on 2017/8/28.
 */
@Service("postlendingUpdateCommon")
public class PostlendingUpdateCommonImpl implements PostlendingUpdateCommon {

    @Autowired
    private LeaseAllinpayLogService leaseAllinpayLogService;

    @Autowired
    private LeaseAllinpayQueryLogService leaseAllinpayQueryLogService;

    @Autowired
    private LeaseAllinpayBatchService leaseAllinpayBatchService;

    @Autowired
    private LeaseSchemeRepaymentStatusService leaseSchemeRepaymentStatusService;

    @Autowired
    private LeaseAllinpayStatusLogService leaseAllinpayStatusLogService;

    @Autowired
    private LeaseAllinpaySplitService leaseAllinpaySplitService;

    @Autowired
    private LeaseAllinpaySplitLogService leaseAllinpaySplitLogService;

    @Autowired
    private LeaseAllinpaySplitQueryLogService leaseAllinpaySplitQueryLogService;

    @Autowired
    private LeaseAllinpaySplitStatusLogService leaseAllinpaySplitStatusLogService;

    @Autowired
    private LeaseAllinpaySplitBatchService leaseAllinpaySplitBatchService;

    public Object pstlendingCommon(TransBody transBody, DubboTreaceParames dubboTreaceParames) throws GMException {

        try {
            //更新 支付状态汇总管理 状态
            LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus = new LeaseSchemeRepaymentStatus();
            leaseSchemeRepaymentStatus.setPaymentResult(RetCode.checkPaymentResult(transBody.getAipgrspRetCode(), transBody.getRetCode()));
            leaseSchemeRepaymentStatus.setPaymentResultMsg(transBody.getErrMsg());
            leaseSchemeRepaymentStatus.setId(transBody.getRepaymentStatusId());
            int row1 = leaseSchemeRepaymentStatusService.updateByPrimaryKeySelective(leaseSchemeRepaymentStatus);
            //更新 支付状态汇总管理 状态

            //代收流水
            Map<String, Object> paramsMap = Maps.newHashMap();
            paramsMap.put("reqSn", transBody.getReqSn());
            paramsMap.put("payType", transBody.getPayType());
            paramsMap.put("contractId", transBody.getContractId());
            paramsMap.put("repaymentStatusId", transBody.getRepaymentStatusId());
            paramsMap.put("repaymentId", transBody.getRepaymentId());
            LeaseAllinpayLog leaseAllinpayLog = leaseAllinpayLogService.findByReqSn(paramsMap, dubboTreaceParames);
            //代收流水

            Integer checkStatus = RetCode.checkStatus(transBody.getAipgrspRetCode(), transBody.getRetCode());

            //添加 通联轮询流水 状态
            LeaseAllinpayQueryLog leaseAllinpayQueryLog = new LeaseAllinpayQueryLog();
            leaseAllinpayQueryLog.setAllinpayLogId(leaseAllinpayLog.getId());//代收流水主键id
            leaseAllinpayQueryLog.setRepaymentId(transBody.getRepaymentId());//融租合同-还款计划明细主键id
            leaseAllinpayQueryLog.setRepaymentStatusId(transBody.getRepaymentStatusId());
            leaseAllinpayQueryLog.setContractId(transBody.getContractId());
            leaseAllinpayQueryLog.setStatus(checkStatus);//通联支付状态/0:已提交;1:成功;2:失败
            leaseAllinpayQueryLog.setRetCode(transBody.getRetCode());//通联支付反馈状态码
            leaseAllinpayQueryLog.setErrMsg(transBody.getErrMsg());//通联支付反馈状态描述
            leaseAllinpayQueryLog.setBackTime(DateUtil.strToDate(transBody.getFinTime()));
            leaseAllinpayQueryLog.setReqSn(transBody.getReqSn());//通联返回的 文件名/可用于通联流水查询
            leaseAllinpayQueryLog.setSn(transBody.getSn());
            paramsMap.put("allinpayLogId", leaseAllinpayLog.getId());
            List<LeaseAllinpayQueryLog> leaseAllinpayQueryLogList = leaseAllinpayQueryLogService.selectByAllinpayLogId(paramsMap, dubboTreaceParames);
            if (leaseAllinpayQueryLogList == null || leaseAllinpayQueryLogList.size() <= 0) {
                leaseAllinpayQueryLogService.insertSelective(leaseAllinpayQueryLog);
            }

            //添加 通联轮询流水 状态

            //插入 代收状态流水 数据
            LeaseAllinpayStatusLog leaseAllinpayStatusLog = new LeaseAllinpayStatusLog();
            leaseAllinpayStatusLog.setAllinpayLogId(leaseAllinpayLog.getId());//代收流水主键id
            leaseAllinpayStatusLog.setBackTime(DateUtil.stampToDate(transBody.getFinTime()));//通联支付反馈状态日期
            leaseAllinpayStatusLog.setCreateTime(DateTime.now().toDate());//
            leaseAllinpayStatusLog.setRetCode(transBody.getRetCode());//通联支付反馈状态码
            leaseAllinpayStatusLog.setErrMsg(transBody.getErrMsg());//通联支付反馈状态描述
            leaseAllinpayStatusLog.setType(leaseAllinpayLog.getSingleOrBatch() == 0 ? AllinpayStatusLogType.TYPE_2 : AllinpayStatusLogType.TYPE_3);
            leaseAllinpayStatusLog.setPaymentResult(RetCode.checkPaymentResult(transBody.getAipgrspRetCode(), transBody.getRetCode()));//支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败
            leaseAllinpayStatusLog.setPaymentResultMsg(transBody.getErrMsg());//状态结果描述  失败原因描述
            leaseAllinpayStatusLog = leaseAllinpayStatusLogService.insertSelective(leaseAllinpayStatusLog);

            //插入 代收状态流水 数据

            //更新批量扣款，因为代收的时候每笔款的结果都不是实时的，成功几笔，失败几笔都不知道，所有要在这里根据轮询的结果更新批扣的数据
            if (leaseAllinpayLog.getSingleOrBatch() == 1) {
                LeaseAllinpayBatch leaseAllinpayBatch = leaseAllinpayBatchService.selectByPrimaryKey(leaseAllinpayLog.getAllinpayBatchId());
                if (leaseAllinpayBatch == null) leaseAllinpayBatch = new LeaseAllinpayBatch();
                leaseAllinpayBatch.setId(leaseAllinpayLog.getAllinpayBatchId());
                if (checkStatus == 1) {//通联交易成功
                    leaseAllinpayBatch.setSuccessNumber(leaseAllinpayBatch.getSuccessNumber() + 1);//成功数量
                    leaseAllinpayBatch.setReceiptsPrice(leaseAllinpayBatch.getReceiptsPrice().add(leaseAllinpayLog.getRealPrice()));//实扣总额/成功总额
                } else if (checkStatus == 2) {//通联交易失败
                    leaseAllinpayBatch.setFailNumber(leaseAllinpayBatch.getFailNumber() + 1);//失败数量
                    leaseAllinpayBatch.setFailPrice(leaseAllinpayBatch.getFailPrice().add(leaseAllinpayLog.getRealPrice()));
                }
                leaseAllinpayBatch.setUpdateBy(transBody.getCreateBy());
                leaseAllinpayBatchService.updateByPrimaryKeySelective(leaseAllinpayBatch);
            }
            //更新批量扣款，因为代收的时候每笔款的结果都不是实时的，成功几笔，失败几笔都不知道，所有要在这里根据轮询的结果更新批扣的数据
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    public Object pstlendingCommonSplit(TransSplitBody transSplitBody, DubboTreaceParames dubboTreaceParames) throws GMException {

        try {
            //更新 支付状态汇总管理 状态
            LeaseAllinpaySplit leaseAllinpaySplit = new LeaseAllinpaySplit();
            leaseAllinpaySplit.setPaymentResult(RetCode.checkPaymentResult(transSplitBody.getAipgrspRetCode(), transSplitBody.getRetCode()));
            leaseAllinpaySplit.setPaymentResultMsg(transSplitBody.getErrMsg());
            leaseAllinpaySplit.setId(transSplitBody.getAllinpaySplitId());
            int row1 = leaseAllinpaySplitService.updateByPrimaryKeySelective(leaseAllinpaySplit);
            //更新 支付状态汇总管理 状态

            //超额拆分交易明细流水
            Map<String, Object> paramsMap = Maps.newHashMap();
            paramsMap.put("reqSn", transSplitBody.getReqSn());
            paramsMap.put("contractId", transSplitBody.getContractId());
            paramsMap.put("allinpaySplitId", transSplitBody.getAllinpaySplitId());
            paramsMap.put("repaymentId", transSplitBody.getRepaymentId());
            LeaseAllinpaySplitLog leaseAllinpaySplitLog = leaseAllinpaySplitLogService.findByReqSn(paramsMap, dubboTreaceParames);
            //超额拆分交易明细流水

            Integer checkStatus = CheckCode.checkPayStatus(transSplitBody.getAipgrspRetCode(), transSplitBody.getRetCode());

            //添加 通联轮询流水 状态
            LeaseAllinpaySplitQueryLog leaseAllinpaySplitQueryLog = new LeaseAllinpaySplitQueryLog();
            leaseAllinpaySplitQueryLog.setAllinpaySplitLogId(leaseAllinpaySplitLog.getId());//代收流水主键id
            leaseAllinpaySplitQueryLog.setRepaymentId(transSplitBody.getRepaymentId());//融租合同-还款计划明细主键id
            leaseAllinpaySplitQueryLog.setAllinpaySplitId(transSplitBody.getAllinpaySplitId());
            leaseAllinpaySplitQueryLog.setContractId(transSplitBody.getContractId());
            leaseAllinpaySplitQueryLog.setStatus(checkStatus);//通联支付状态/0:已提交;1:成功;2:失败
            leaseAllinpaySplitQueryLog.setRetCode(transSplitBody.getRetCode());//通联支付反馈状态码
            leaseAllinpaySplitQueryLog.setErrMsg(transSplitBody.getErrMsg());//通联支付反馈状态描述
            leaseAllinpaySplitQueryLog.setBackTime(DateUtil.strToDate(transSplitBody.getFinTime()));
            leaseAllinpaySplitQueryLog.setReqSn(transSplitBody.getReqSn());//通联返回的 文件名/可用于通联流水查询
            leaseAllinpaySplitQueryLog.setSn(transSplitBody.getSn());
            paramsMap.put("allinpaySplitLogId", leaseAllinpaySplitLog.getId());
            List<LeaseAllinpaySplitQueryLog> leaseAllinpaySplitQueryLogList = leaseAllinpaySplitQueryLogService.selectByAllinpaySplitLogId(paramsMap, dubboTreaceParames);
            if (leaseAllinpaySplitQueryLogList == null || leaseAllinpaySplitQueryLogList.size() <= 0) {
                leaseAllinpaySplitQueryLogService.insertSelective(leaseAllinpaySplitQueryLog);
            }

            //添加 通联轮询流水 状态

            //插入 代收状态流水 数据
            LeaseAllinpaySplitStatusLog leaseAllinpaySplitStatusLog = new LeaseAllinpaySplitStatusLog();
            leaseAllinpaySplitStatusLog.setAllinpaySplitLogId(leaseAllinpaySplitLog.getId());//代收流水主键id
            leaseAllinpaySplitStatusLog.setBackTime(DateUtil.stampToDate(transSplitBody.getFinTime()));//通联支付反馈状态日期
            leaseAllinpaySplitStatusLog.setCreateTime(DateTime.now().toDate());//
            leaseAllinpaySplitStatusLog.setRetCode(transSplitBody.getRetCode());//通联支付反馈状态码
            leaseAllinpaySplitStatusLog.setErrMsg(transSplitBody.getErrMsg());//通联支付反馈状态描述
            leaseAllinpaySplitStatusLog.setType(leaseAllinpaySplitLog.getSingleOrBatch() == 0 ? AllinpayStatusLogType.TYPE_2 : AllinpayStatusLogType.TYPE_3);
            leaseAllinpaySplitStatusLog.setPaymentResult(RetCode.checkPaymentResult(transSplitBody.getAipgrspRetCode(), transSplitBody.getRetCode()));//支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败
            leaseAllinpaySplitStatusLog.setPaymentResultMsg(transSplitBody.getErrMsg());//状态结果描述  失败原因描述
            leaseAllinpaySplitStatusLog = leaseAllinpaySplitStatusLogService.insertSelective(leaseAllinpaySplitStatusLog);

            //插入 代收状态流水 数据

            //更新批量扣款，因为代收的时候每笔款的结果都不是实时的，成功几笔，失败几笔都不知道，所有要在这里根据轮询的结果更新批扣的数据
            if (leaseAllinpaySplitLog.getSingleOrBatch() == 1) {
                LeaseAllinpaySplitBatch leaseAllinpaySplitBatch = leaseAllinpaySplitBatchService.selectByPrimaryKey(leaseAllinpaySplitLog.getAllinpayBatchId());
                if (leaseAllinpaySplitBatch == null) leaseAllinpaySplitBatch = new LeaseAllinpaySplitBatch();
                leaseAllinpaySplitBatch.setId(leaseAllinpaySplitLog.getAllinpayBatchId());
                if (checkStatus == 1) {//通联交易成功
                    leaseAllinpaySplitBatch.setSuccessNumber(leaseAllinpaySplitBatch.getSuccessNumber() + 1);//成功数量
                    leaseAllinpaySplitBatch.setReceiptsPrice(leaseAllinpaySplitBatch.getReceiptsPrice().add(leaseAllinpaySplitLog.getTotlePrice()));//实扣总额/成功总额
                } else if (checkStatus == 2) {//通联交易失败
                    leaseAllinpaySplitBatch.setFailNumber(leaseAllinpaySplitBatch.getFailNumber() + 1);//失败数量
                    leaseAllinpaySplitBatch.setFailPrice(leaseAllinpaySplitBatch.getFailPrice().add(leaseAllinpaySplitLog.getTotlePrice()));
                }
                leaseAllinpaySplitBatch.setUpdateBy(transSplitBody.getCreateBy());
                leaseAllinpaySplitBatchService.updateByPrimaryKeySelective(leaseAllinpaySplitBatch);
            }
            //更新批量扣款，因为代收的时候每笔款的结果都不是实时的，成功几笔，失败几笔都不知道，所有要在这里根据轮询的结果更新批扣的数据
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

}
