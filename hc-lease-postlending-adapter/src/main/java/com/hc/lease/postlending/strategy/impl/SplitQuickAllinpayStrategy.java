package com.hc.lease.postlending.strategy.impl;

import com.aipg.payresp.Ret_Detail;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.*;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.vo.BatchPostlendingPaymentVo;
import com.hc.lease.postlending.adapter.api.LeaseAllinpaySplitAdapter;
import com.hc.lease.postlending.adapter.api.MonthlyPaymentAdapter;
import com.hc.lease.postlending.model.LeaseAllinpaySplit;
import com.hc.lease.postlending.model.LeaseAllinpaySplitConnect;
import com.hc.lease.postlending.service.api.LeaseAllinpaySplitConnectService;
import com.hc.lease.postlending.service.api.LeaseAllinpaySplitService;
import com.hc.lease.postlending.strategy.Context;
import com.hc.lease.postlending.strategy.Strategy;
import com.hc.lease.postlending.vo.BatchPostlendingPaymentSplitVo;
import com.hc.lease.postlending.vo.BatchStrategyVo;
import com.hc.lease.postlending.vo.TransBodyInstallVo;
import com.hc.lease.postlending.vo.TransSplitBody;
import hc.lease.common.util.DateUtils;
import hc.lease.common.util.SpringContextHolder;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * 处理单人综合扣款、通联批扣
 * 通联协议支付
 * 超额拆分交易处理
 * Created by tong on 2018/5/18.
 */
public class SplitQuickAllinpayStrategy implements Strategy {
    Integer sequenceNumberStart = 0;
    Integer sequenceNumberEnd = 0;

    @Override
    public Object deal(Object object, Object object1, Object object2, Object object3, DubboTreaceParames dubboTreaceParames) throws GMException {
        Context context = (Context) object;
        TransBodyInstallVo transBodyInstallVo = (TransBodyInstallVo) object1;//用于扣款的数据
        List<BatchPostlendingPaymentVo> needBatchPostlendingPaymentList = (List<BatchPostlendingPaymentVo>) object2;//批量扣款款项 月供、滞纳金、其他

        if (transBodyInstallVo != null) {
            if (needBatchPostlendingPaymentList != null) {
                if (needBatchPostlendingPaymentList.size() > 0) {
                    BatchStrategyVo batchStrategyVo = new BatchStrategyVo();
                    batchStrategyVo.setTotlePrice(transBodyInstallVo.getAmount());//总金额
                    batchStrategyVo.setTotalItem(needBatchPostlendingPaymentList.size());//总数量
                    batchStrategyVo.setSingleOrBatch(transBodyInstallVo.getSingleOrBatch());//单笔或批量/0:单笔; 1:批量
                    batchStrategyVo.setCreateTime(transBodyInstallVo.getCreateTime());
                    batchStrategyVo.setUpdateTime(transBodyInstallVo.getUpdateTime());
                    batchStrategyVo.setCreateBy(transBodyInstallVo.getCreateBy());
                    batchStrategyVo.setUpdateBy(transBodyInstallVo.getUpdateBy());
                    batchStrategyVo.setReqSn(null);
                    batchStrategyVo.setAipgrspRetCode(null);//通联返回的 头部 状态码
                    batchStrategyVo.setAipgrspErrMsg(null);//通联返回的 头部 状态结果描述
                    batchStrategyVo.setRetCode(null);//通联返回的 明细 状态码
                    batchStrategyVo.setErrMsg(null);//通联返回的 明细 状态结果描述/
                    batchStrategyVo.setFinalErrMsg(null);//如果头部返回成功状态则使用明细的状态结果描述/超额拆单系统处理中
                    batchStrategyVo.setFinalCode(null);//如果头部返回成功状态则使用明细的状态码
                    batchStrategyVo.setRetDetails(dualRetDetails(transBodyInstallVo.getSn()));//批量代收明细 操作结果状态
                    batchStrategyVo.setBatchNumber(transBodyInstallVo.getBatchNumber());//批次号/批扣流水
                    batchStrategyVo.setPayWay(PayWay.ALLIPAY_QUICK);
                    batchStrategyVo.setStatus(0);//通联支付状态/0:已提交、扣款中;1:成功;2:失败
                    batchStrategyVo.setIsSpilt(transBodyInstallVo.getIsSpilt());//是否超额拆单/0:是; 1:否
                    batchStrategyVo.setAllinpayStatusLogType(transBodyInstallVo.getAllinpayStatusLogType());
                    batchStrategyVo.setContractId(transBodyInstallVo.getContractId());
                    batchStrategyVo.setRepaymentId(transBodyInstallVo.getRepaymentId());
                    batchStrategyVo.setSn(transBodyInstallVo.getSn());

                    //通联批量支付批次统计 表 的数据
                    batchStrategyVo.setReceivablePrice(transBodyInstallVo.getAmountOld());//应扣总额
                    batchStrategyVo.setReceiptsPrice(batchStrategyVo.getStatus().equals(PaymentLogStatus.STATUS_1) ? transBodyInstallVo.getAmount() : new BigDecimal(0));//实扣总额
                    batchStrategyVo.setSuccessNumber(batchStrategyVo.getStatus().equals(PaymentLogStatus.STATUS_1) ? needBatchPostlendingPaymentList.size() : 0);//成功数量
                    batchStrategyVo.setFailNumber(batchStrategyVo.getStatus().equals(PaymentLogStatus.STATUS_2) ? needBatchPostlendingPaymentList.size() : 0);//失败数量
                    batchStrategyVo.setFailPrice(batchStrategyVo.getStatus().equals(PaymentLogStatus.STATUS_2) ? transBodyInstallVo.getAmount() : new BigDecimal(0));//失败总额
                    //通联批量支付批次统计 表 的数据

                    context.deal(context, batchStrategyVo.getSingleOrBatch() + JDBCTpye.JDBC_SINGLEORBATHTYPE + "AllPayWayCommon", batchStrategyVo, needBatchPostlendingPaymentList, null, dubboTreaceParames);//支付公共处理

                    //处理拆分交易
                    LeaseAllinpaySplitConnectService leaseAllinpaySplitConnectService = (LeaseAllinpaySplitConnectService) SpringContextHolder.getBean("leaseAllinpaySplitConnectService");
                    if (dualAllinpaySplitConnect(batchStrategyVo) != null) {
                        LeaseAllinpaySplitConnect leaseAllinpaySplitConnect = leaseAllinpaySplitConnectService.insertSelective(dualAllinpaySplitConnect(batchStrategyVo));
                        LeaseAllinpaySplitService leaseAllinpaySplitService = (LeaseAllinpaySplitService) SpringContextHolder.getBean("leaseAllinpaySplitService");
                        List<LeaseAllinpaySplit> leaseAllinpaySplitList = dualAllinpaySplitDay(transBodyInstallVo, batchStrategyVo, leaseAllinpaySplitConnect);
                        leaseAllinpaySplitService.insertList(leaseAllinpaySplitList);
                    }
                    //处理拆分交易

                    //处理当日的拆分明细/自动扣款
                    MonthlyPaymentAdapter monthlyPaymentAdapter = (MonthlyPaymentAdapter) SpringContextHolder.getBean("monthlyPaymentAdapter");
                    LeaseAllinpaySplitAdapter leaseAllinpaySplitAdapter = (LeaseAllinpaySplitAdapter) SpringContextHolder.getBean("leaseAllinpaySplitAdapter");
                    Map<String, Object> paramsMap = Maps.newHashMap();
                    paramsMap.put("repaymentDate", DateUtil.smartFormat(DateUtils.getDate()));//当日时间
                    List<BatchPostlendingPaymentSplitVo> batchPostlendingPaymentSplitList = leaseAllinpaySplitAdapter.findBatchSplitDual(paramsMap, dubboTreaceParames);//批量协议支付 通联支付拆单 查询需要处理的数据
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
            //根据通联支付代收 返回的处理结果更新 数据库
        }
        return null;
    }

    /**
     * 处理交易 通联返回的 明细
     * 如果通联返回的 头部 状态已经为失败状态 则需要手动处理 模拟通联返回的格式，因为通联没有返回这部分数据，但后面需用到这部分数据
     *
     * @param sn
     * @return
     */
    private List<Ret_Detail> dualRetDetails(String sn) {
        List<Ret_Detail> retDetails = new ArrayList<Ret_Detail>();
        Ret_Detail detail = new Ret_Detail();
        detail.setSN(sn);
        retDetails.add(detail);
        return retDetails;
    }

    /**
     * @param batchStrategyVo
     * @return
     * @throws GMException
     */
    public LeaseAllinpaySplitConnect dualAllinpaySplitConnect(BatchStrategyVo batchStrategyVo) throws GMException {
        LeaseAllinpaySplitConnect leaseAllinpaySplitConnect = new LeaseAllinpaySplitConnect();
        leaseAllinpaySplitConnect.setContractId(batchStrategyVo.getContractId());
        leaseAllinpaySplitConnect.setRepaymentId(batchStrategyVo.getRepaymentId());
        leaseAllinpaySplitConnect.setSingleOrBatch(batchStrategyVo.getSingleOrBatch());
        leaseAllinpaySplitConnect.setBatchNumber(batchStrategyVo.getBatchNumber());
        leaseAllinpaySplitConnect.setTotlePrice(batchStrategyVo.getTotlePrice());
        leaseAllinpaySplitConnect.setNumber(batchStrategyVo.getTotalItem());
        leaseAllinpaySplitConnect.setCreateTime(batchStrategyVo.getCreateTime());
        leaseAllinpaySplitConnect.setUpdateTime(batchStrategyVo.getUpdateTime());
        leaseAllinpaySplitConnect.setCreateBy(batchStrategyVo.getCreateBy());
        leaseAllinpaySplitConnect.setUpdateBy(batchStrategyVo.getUpdateBy());
        leaseAllinpaySplitConnect.setPayWay(batchStrategyVo.getPayWay());
        leaseAllinpaySplitConnect.setSn(batchStrategyVo.getSn());
        return leaseAllinpaySplitConnect;
    }

    /**
     * 处理拆分交易
     * 处理一笔总金额可以拆分多少明细
     *
     * @param transBodyInstallVo
     */

    public List<LeaseAllinpaySplit> dualAllinpaySplitDay(TransBodyInstallVo transBodyInstallVo, BatchStrategyVo batchStrategyVo, LeaseAllinpaySplitConnect leaseAllinpaySplitConnect) throws GMException {
        Date date = DateTime.now().toDate();
        BigDecimal amount = transBodyInstallVo.getAmount();//扣款总金额
        BigDecimal allinpayDayPriceLimit = transBodyInstallVo.getAllinpayDayPriceLimit();//通联代扣交易 每日限额
        BigDecimal allinpayPriceLimit = transBodyInstallVo.getAllinpayPriceLimit();//通联代扣交易 每笔额度
        List<LeaseAllinpaySplit> leaseAllinpaySplitList = new ArrayList<LeaseAllinpaySplit>();
        dualSequenceNumberStart(transBodyInstallVo, batchStrategyVo);//处理拆分总笔数
        if (amount.compareTo(allinpayDayPriceLimit) == 1) {//拆分多日/totlePrice > allinpayDayPriceLimit
            //处理总金额需要拆分成多少天
            BigDecimal[] results_1 = amount.divideAndRemainder(allinpayDayPriceLimit);
            Integer merchant_1 = results_1[0].setScale(0, RoundingMode.HALF_UP).intValue();//商/即是天数
            BigDecimal remainder_1 = results_1[1].setScale(2, RoundingMode.HALF_UP);//余数
            //处理总金额需要拆分成多少天
            for (int i = 1; i <= merchant_1; i++) {//循环每日
                //处理每日限额需要拆分成多少笔
                BigDecimal[] results_2 = allinpayDayPriceLimit.divideAndRemainder(allinpayPriceLimit);
                Integer merchant_2 = results_2[0].setScale(0, RoundingMode.HALF_UP).intValue();//商/即每天的必笔数
                BigDecimal remainder_2 = results_2[1].setScale(2, RoundingMode.HALF_UP);//余数
                //处理每日限额需要拆分成多少笔
                for (int j = 1; j <= merchant_2; j++) {//循环每日的每笔
                    dualAllinpaySplit(batchStrategyVo, allinpayDayPriceLimit, allinpayPriceLimit, leaseAllinpaySplitList, DateUtil.getDateYMD(date), leaseAllinpaySplitConnect);
                }
                if (remainder_2.compareTo(BigDecimal.ZERO) == 1) {//大于0
                    dualAllinpaySplit(batchStrategyVo, remainder_2, allinpayPriceLimit, leaseAllinpaySplitList, DateUtil.getDateYMD(date), leaseAllinpaySplitConnect);
                }
                date = DateUtils.dateCalculate(DateTime.now().toDate(), Calendar.DATE, i);//推算日期
            }
            if (remainder_1.compareTo(BigDecimal.ZERO) == 1) {//大于0
                dualAllinpaySplit(batchStrategyVo, remainder_1, allinpayPriceLimit, leaseAllinpaySplitList, DateUtil.getDateYMD(date), leaseAllinpaySplitConnect);
            }
        } else {//不拆分多日、只有当日多笔
            dualAllinpaySplit(batchStrategyVo, amount, allinpayPriceLimit, leaseAllinpaySplitList, DateUtil.getDateYMD(date), leaseAllinpaySplitConnect);
        }
        return leaseAllinpaySplitList;
    }

    /**
     * 处理拆分总笔数
     *
     * @param transBodyInstallVo
     * @param batchStrategyVo
     * @return
     * @throws GMException
     */
    public Integer dualSequenceNumberStart(TransBodyInstallVo transBodyInstallVo, BatchStrategyVo batchStrategyVo) throws GMException {

        BigDecimal amount = transBodyInstallVo.getAmount();//扣款总金额
        BigDecimal allinpayDayPriceLimit = transBodyInstallVo.getAllinpayDayPriceLimit();//通联代扣交易 每日限额
        BigDecimal allinpayPriceLimit = transBodyInstallVo.getAllinpayPriceLimit();//通联代扣交易 每笔限额
        if (amount.compareTo(allinpayDayPriceLimit) == 1) {//拆分多日/totlePrice > allinpayDayPriceLimit
            //处理总金额需要拆分成多少天
            BigDecimal[] results_1 = amount.divideAndRemainder(allinpayDayPriceLimit);
            Integer merchant_1 = results_1[0].setScale(0, RoundingMode.HALF_UP).intValue();//商
            BigDecimal remainder_1 = results_1[1].setScale(2, RoundingMode.HALF_UP);//余数
            //处理总金额需要拆分成多少天
            for (int i = 1; i <= merchant_1; i++) {//循环每日
                //处理每日限额需要拆分成多少笔
                BigDecimal[] results_2 = allinpayDayPriceLimit.divideAndRemainder(allinpayPriceLimit);
                Integer merchant_2 = results_2[0].setScale(0, RoundingMode.HALF_UP).intValue();//商
                BigDecimal remainder_2 = results_2[1].setScale(2, RoundingMode.HALF_UP);//余数
                //处理每日限额需要拆分成多少笔
                for (int j = 1; j <= merchant_2; j++) {//循环每日的每笔
                    sequenceNumberStart = sequenceNumberStart + 1;
                }
                if (remainder_2.compareTo(BigDecimal.ZERO) == 1) {//大于0
                    sequenceNumberStart = sequenceNumberStart + 1;
                }
            }
            if (remainder_1.compareTo(BigDecimal.ZERO) == 1) {//大于0
                sequenceNumberStart = sequenceNumberStart + 1;
            }
        } else {//不拆分多日、只有当日一笔
            sequenceNumberStart = 1;
        }
        return sequenceNumberStart;
    }

    /**
     * 处理金额需要拆分成多少笔
     *
     * @param batchStrategyVo
     * @param price_1                   银行卡扣款总金额
     * @param price_2                   限额
     * @param leaseAllinpaySplitList
     * @param date
     * @param leaseAllinpaySplitConnect
     * @return
     * @throws GMException
     */
    public List<LeaseAllinpaySplit> dualAllinpaySplit(BatchStrategyVo batchStrategyVo, BigDecimal price_1, BigDecimal price_2, List<LeaseAllinpaySplit> leaseAllinpaySplitList, Date date, LeaseAllinpaySplitConnect leaseAllinpaySplitConnect) throws GMException {
        if (price_1.compareTo(price_2) == 1) {//price_1 > price_2
            //处理总金额需要拆分成多少笔
            BigDecimal[] results_3 = price_1.divideAndRemainder(price_2);
            Integer merchant_3 = results_3[0].setScale(0, RoundingMode.HALF_UP).intValue();//商
            BigDecimal remainder_3 = results_3[1].setScale(2, RoundingMode.HALF_UP);//余数
            //处理总金额需要拆分成多少笔
            for (int i = 1; i <= merchant_3; i++) {
                LeaseAllinpaySplit leaseAllinpaySplit = dualInstallAllinpaySplit(batchStrategyVo, price_2, date, leaseAllinpaySplitConnect);
                leaseAllinpaySplitList.add(leaseAllinpaySplit);
            }
            if (remainder_3.compareTo(BigDecimal.ZERO) == 1) {//大于0
                LeaseAllinpaySplit leaseAllinpaySplit = dualInstallAllinpaySplit(batchStrategyVo, remainder_3, date, leaseAllinpaySplitConnect);
                leaseAllinpaySplitList.add(leaseAllinpaySplit);
            }
        } else {
            LeaseAllinpaySplit leaseAllinpaySplit = dualInstallAllinpaySplit(batchStrategyVo, price_1, date, leaseAllinpaySplitConnect);
            leaseAllinpaySplitList.add(leaseAllinpaySplit);
        }
        return leaseAllinpaySplitList;
    }

    /**
     * 处理拆分交易
     * 插入数据
     *
     * @param batchStrategyVo
     * @param allinpayPriceLimit
     * @param date
     * @return
     * @throws GMException
     */

    public LeaseAllinpaySplit dualInstallAllinpaySplit(BatchStrategyVo batchStrategyVo, BigDecimal allinpayPriceLimit, Date date, LeaseAllinpaySplitConnect leaseAllinpaySplitConnect) throws GMException {
        //插入通联支付超额拆分交易明细数据
        sequenceNumberEnd = sequenceNumberEnd + 1;
        LeaseAllinpaySplit leaseAllinpaySplit = new LeaseAllinpaySplit();
        leaseAllinpaySplit.setRepaymentId(batchStrategyVo.getRepaymentId());
        leaseAllinpaySplit.setContractId(batchStrategyVo.getContractId());
        leaseAllinpaySplit.setAccountId(batchStrategyVo.getAccountId());
        leaseAllinpaySplit.setSplitConnectId(leaseAllinpaySplitConnect.getId());
        leaseAllinpaySplit.setPayWay(batchStrategyVo.getPayWay());//支付方式0:pos ;1:转账 ;2:微信 ;3:支付宝;4:通联;5:其他;6:批量补录;7:线下缴款登记;8:未开始还款;9:通联协议支付
        leaseAllinpaySplit.setPaymentResult(PaymentResult.TYPE_0);//支付状态  0 未扣款/待付款 1扣款中 2已扣款/成功 3:失败
        leaseAllinpaySplit.setTotlePrice(allinpayPriceLimit);//金额
        leaseAllinpaySplit.setStatus(0);//状态 0:无操作1:挂起 2:取消挂起
        leaseAllinpaySplit.setRepaymentDate(date);//扣款日/扣款时间
        leaseAllinpaySplit.setIsOverTime(0);//是否已过扣款时间 0否 1是
        leaseAllinpaySplit.setSequenceNumberStart(sequenceNumberStart);//交易明细序号总数
        leaseAllinpaySplit.setSequenceNumberEnd(sequenceNumberEnd);//交易明细序号顺序
        leaseAllinpaySplit.setCreateTime(batchStrategyVo.getCreateTime());
        leaseAllinpaySplit.setUpdateTime(batchStrategyVo.getUpdateTime());
        leaseAllinpaySplit.setCreateBy(batchStrategyVo.getCreateBy());
        leaseAllinpaySplit.setUpdateBy(batchStrategyVo.getUpdateBy());
        leaseAllinpaySplit.setSn(batchStrategyVo.getSn());
        return leaseAllinpaySplit;
    }

}