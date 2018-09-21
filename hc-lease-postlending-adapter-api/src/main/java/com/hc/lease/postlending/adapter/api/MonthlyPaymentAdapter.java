package com.hc.lease.postlending.adapter.api;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.postlending.model.LeaseAllinpayBatch;
import com.hc.lease.postlending.vo.ContractAllinpayLogVo;
import com.hc.lease.postlending.vo.PostlendingPaymentParameVo;
import com.hc.lease.postlending.vo.TransBody;
import com.hc.lease.postlending.vo.TransSplitBody;

import java.util.List;
import java.util.Map;

/**
 * 贷后管理
 * Created by tong on 2017/6/10.
 */
public interface MonthlyPaymentAdapter {

    /**
     * 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 月供管理列表 / 租金支付计划表 / 还款历史
     *
     * @param paramsMap
     * @return
     */
    ResultHashMap findPostLending(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 逾期短信通知列表
     *
     * @param paramsMap
     * @return
     */
    ResultHashMap findPostLendingOverdueSms(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 初始化扣款页面的参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> getPayViewParames(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 还款历史/合同还款明细
     *
     * @return
     * @throws GMException
     */
    ResultHashMap contractAllinpayLog(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 交易查询/轮询/通联平台查询
     * 通联代扣
     *
     * @param transBody
     * @return
     * @throws GMException
     */
    ResultHashMap queryTradeNew(TransBody transBody, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 交易查询/轮询/通联平台查询
     * 通联协议支付
     *
     * @param transBody
     * @return
     * @throws GMException
     */
    ResultHashMap search(TransBody transBody, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 根据 通联 轮询回来的处理结果
     * 更新 代收流水 状态 / 更新 还款记录 状态
     *
     * @param transBody
     * @return
     * @throws GMException
     */
    ResultHashMap changeSchemeRepaymentStatus(TransBody transBody, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 需要轮询通联 的 交易流水/状态为扣款中
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    ResultHashMap findQueryTradeNew(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 定时 检测 逾期的 还款记录 并插入 逾期流水
     *
     * @return
     * @throws GMException
     */
    ResultHashMap findIsOverdue(DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 通联批扣 查询所有月供/挂靠/统计数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    ResultHashMap batchPostlendingPayment(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 处理单人综合扣款、通联批扣
     * 通联代扣
     * 通联协议支付
     *
     * @param postlendingPaymentParameVo
     * @return
     * @throws GMException
     */
    ResultHashMap dualBathPostlendingPayment(PostlendingPaymentParameVo postlendingPaymentParameVo, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 处理单人综合扣款、通联批扣
     * 通联代扣
     * 通联协议支付
     *
     * @param postlendingPaymentParameVo
     * @return
     * @throws GMException
     */
    ResultHashMap dualSinglePostlendingPayment(PostlendingPaymentParameVo postlendingPaymentParameVo, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 通联日志 / 批扣 数据
     *
     * @return
     * @throws GMException
     */
    PageInfo<LeaseAllinpayBatch> allinpayLogBatch(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 通联日志
     * 单笔
     * 查看明细
     * 因为每笔款不是即时出结果，所以代收流水的状态不是最终状态，轮询流水的状态是最终状态
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    ResultHashMap paymentLogDetail(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 融资租赁标的物
     *
     * @param paramsMap
     * @return
     */
    ResultHashMap findContractInfo(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 批扣数据用城市统计/查看统计
     *
     * @param paramsMap
     * @return
     */
    ResultHashMap allinpayBatchStatistics(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 批量补录的数据/月供
     *
     * @param paramsMap
     * @return
     */
    ResultHashMap findRepaymentExcept(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 融租合同 不用系统处理扣款的月租、滞纳金、尾款,录入的合同数据如果是不需要系统处理租金扣款，则记录，因为有些合同数据是线下处理了收款
     * 提交批量补录/处理月供、滞纳金、尾款
     *
     * @param paramsMap
     * @return
     */
    ResultHashMap repaymentExcept(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 逾期通知短信 预览
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    ResultHashMap overdueSmsPreview(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 发送逾期通知短信
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    ResultHashMap sendOverdueSms(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 根据 通联 轮询回来的处理结果
     * 更新 代收流水 状态 / 更新 支付状态汇总管理 状态
     * 扣款发送短信提醒
     *
     * @throws GMException
     */
    void dualAllinpaySendSmsInfoInstall(DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 融租合同 不用系统处理扣款的月租、滞纳金,录入的合同数据如果是不需要系统处理租金扣款，则记录，因为有些合同数据是线下处理了收款
     * 线下缴款登记
     *
     * @param paramsMap
     * @return
     */
    ResultHashMap repaymentPrivately(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 定时器触发
     * 提前扣款短信提醒
     * 还款日7天前、3天前向承租人发送
     *
     * @param paramsMap
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    ResultHashMap advanceSendRepaymentSms(Map<String, String> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 批量协议支付
     * 通联支付拆单
     *
     * @param transSplitBody
     * @return
     * @throws GMException
     */
    ResultHashMap dualBatchPostlendingPaymentSplit(TransSplitBody transSplitBody, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 通联支付拆单 单笔协议支付
     *
     * @param transSplitBody
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    ResultHashMap dualSinglePostlendingPaymentSplit(TransSplitBody transSplitBody, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 通联支付拆单
     * 单笔线下支付登记
     *
     * @param paramsMap
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    ResultHashMap repaymentPrivatelySplit(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 需要轮询通联超额拆分 的 交易流水/状态为扣款中
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    ResultHashMap findQueryTradeNewSplit(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 根据 通联 轮询回来的处理结果
     * 更新 代收流水 状态 / 更新 还款记录 状态
     *
     * @param transSplitBody
     * @return
     * @throws GMException
     */
    ResultHashMap changeSchemeRepaymentStatusSplit(TransSplitBody transSplitBody, DubboTreaceParames dubboTreaceParames) throws GMException;

    List<LeaseAllinpayBatch> allinpayLogBatchNoPage(Map<String, Object> paramsMap);

    /**
     * 定时 检测 逾期的 月租/挂靠费 并插入 逾期流水
     *
     * @param paramsMap
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    ResultHashMap batchPostlendingPaymentNoPage(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    List<ContractAllinpayLogVo> exportAllinpayLog(Map<String, Object> paramsMap);
}
