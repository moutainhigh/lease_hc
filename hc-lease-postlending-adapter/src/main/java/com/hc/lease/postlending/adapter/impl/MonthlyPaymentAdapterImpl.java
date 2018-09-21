package com.hc.lease.postlending.adapter.impl;

import com.allinpay.model.QuickReturnMessage;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.model.LeaseBranchCompany;
import com.hc.lease.baseInfo.model.LeaseDict;
import com.hc.lease.baseInfo.model.LeaseSmsLog;
import com.hc.lease.baseInfo.service.api.LeaseBranchCompanyService;
import com.hc.lease.baseInfo.service.api.LeaseDictService;
import com.hc.lease.baseInfo.service.api.LeaseSmsLogService;
import com.hc.lease.common.allinpay.adapter.TranxAdapter;
import com.hc.lease.common.allinpay.model.ReturnMessage;
import com.hc.lease.common.core.constant.*;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.common.core.sms.SmsService;
import com.hc.lease.order.model.LeaseContract;
import com.hc.lease.order.model.LeaseContractRepaymentExcept;
import com.hc.lease.order.model.LeaseSchemeRepayment;
import com.hc.lease.order.model.LeaseSchemeRepaymentStatus;
import com.hc.lease.order.service.api.*;
import com.hc.lease.order.vo.*;
import com.hc.lease.postlending.adapter.api.MonthlyPaymentAdapter;
import com.hc.lease.postlending.model.*;
import com.hc.lease.postlending.service.api.*;
import com.hc.lease.postlending.strategy.Context;
import com.hc.lease.postlending.vo.*;
import hc.lease.common.util.ListUtil;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 贷后管理
 * Created by tong on 2017/6/10.
 */
@Service("monthlyPaymentAdapter")
public class MonthlyPaymentAdapterImpl implements MonthlyPaymentAdapter {

    private static Context context = new Context();

    //扣款日
    @Value("${repaymentDate.dayOne}")
    String dayOne;
    //扣款日
    @Value("${repaymentDate.dayTwo}")
    String dayTwo;
    //扣款日
    @Value("${repaymentDate.dayThree}")
    String dayThree;
    //通联代扣单笔限额
    @Value("${allinpay.price.limit}")
    String allinpayPriceLimit;
    @Value("${allinpay.quick.price.limit}")
    String allinpayQuickPriceLimit;

    @Autowired
    LeaseDictService leaseDictService;

    @Autowired
    TranxAdapter tranxAdapter;

    @Autowired
    LeaseSchemeRepaymentService leaseSchemeRepaymentService;

    @Autowired
    private LeaseAllinpayLogService leaseAllinpayLogService;

    @Autowired
    private LeaseAllinpayStatusLogService leaseAllinpayStatusLogService;

    @Autowired
    private LeaseAllinpayBatchService leaseAllinpayBatchService;

    @Autowired
    private LeaseContractService leaseContractService;

    @Autowired
    private LeaseContractLinkRepaymentService leaseContractLinkRepaymentService;

    @Autowired
    private LeaseContractAdvanceService leaseContractAdvanceService;

    @Autowired
    private LeaseSchemeRepaymentStatusService leaseSchemeRepaymentStatusService;

    @Autowired
    private LeaseContractRepaymentExceptService leaseContractRepaymentExceptService;

    @Autowired
    LeaseAllinpayQueryLogService leaseAllinpayQueryLogService;

    @Autowired
    LeaseAllinpayStatusSmsService leaseAllinpayStatusSmsService;

    @Autowired
    LeaseSmsLogService leaseSmsLogService;

    @Autowired
    SmsService smsService;

    @Autowired
    LeaseBranchCompanyService leaseBranchCompanyService;

    @Autowired
    LeaseOverdueLogService leaseOverdueLogService;

    @Autowired
    LeaseAllinpaySplitService leaseAllinpaySplitService;

    @Autowired
    LeaseAllinpaySplitLogService leaseAllinpaySplitLogService;

    @Autowired
    LeaseAllinpaySplitStatusLogService leaseAllinpaySplitStatusLogService;

    /**
     * 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        Map<String, Object> map = Maps.newHashMap();
        List<LeaseBranchCompany> leaseBranchCompanyist = leaseBranchCompanyService.findAll(paramsMap);//分公司
        map.put("leaseBranchCompanyist", leaseBranchCompanyist);
        return map;
    }

    /**
     * 月供管理列表 / 租金支付计划表 / 还款历史
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public ResultHashMap findPostLending(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        PageInfo<LeasePostLendingVo> page = leaseContractService.findPostLending(pageNum, pageSize, paramsMap, dubboTreaceParames);//月供管理合同列表
        List<Map<String, Object>> allContractStatusDetails = leaseContractService.selectAllContractStatusDetails(paramsMap, dubboTreaceParames);//各种款项的支付结果统计 / 如：单人综合扣款表头的统计
        List<Map<String, Object>> allContractPayWayDetails = leaseContractService.selectAllContractPayWayDetails(paramsMap, dubboTreaceParames);//各种支付方式统计 / 如：单人综合扣款表头的统计
        List<Map<String, Object>> contractStatisticsByCity = leaseContractService.findAllContractStatisticsByCity(paramsMap, dubboTreaceParames);//分公司统计
        List<Map<String, Object>> contractStatisticsByStatus = leaseContractService.findAllContractStatisticsByStatus(paramsMap, dubboTreaceParames);//合同状态统计
        Map<String, Object> backMap = Maps.newHashMap();
        backMap.put("page", page);//月供管理合同列表
        backMap.put("allContractStatusDetails", allContractStatusDetails);//所有合同的 款项 对应的 支付结果 状态 / 如：单人综合扣款表头的统计
        backMap.put("allContractPayWayDetails", allContractPayWayDetails);//所有合同的 款项 对应的 支付方式 / 如：单人综合扣款表头的统计
        backMap.put("contractStatisticsByCity", contractStatisticsByCity);//根据分公司统计所有合同
        backMap.put("contractStatisticsByStatus", contractStatisticsByStatus);//根据状态统计所有合同
        backMap.put("backDate", paramsMap.get("backDate"));
        ResultHashMap resultHashMap = new ResultHashMap(false, backMap, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;
    }

    /**
     * 初始化单笔扣款页面的参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> getPayViewParames(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        Map<String, Object> map = Maps.newHashMap();

        List<LeaseDict> leaseDictList = leaseDictService.findByType(DictType.TYPE_PAYWAY);//支付方式
        List<FindMonthVo> leaseSchemeRepaymentListMonth = leaseSchemeRepaymentService.findMonth(paramsMap, dubboTreaceParames);//融租合同的 当月月供、过期未付款的月供
        List<FindOverdueVo> leaseSchemeRepaymentListOverdue = leaseSchemeRepaymentService.findOverdue(paramsMap, dubboTreaceParames);//融租合同的 已逾期的月供还款记录/月租滞纳金
        List<FindLinkVo> leaseContractLinkRepaymentListLink = leaseContractLinkRepaymentService.findLink(paramsMap, dubboTreaceParames);//融租合同的 当月挂靠、过期未付款的挂靠
        //List<LeaseContractLinkRepayment> leaseContractLinkRepaymentListOverdue = leaseContractLinkRepaymentService.findOverdue(paramsMap);//融租合同的 已逾期的挂靠还款记录/滞纳金
        List<FindAdvanceVo> leaseContractAdvanceList = leaseContractAdvanceService.findAdvance(paramsMap, dubboTreaceParames);//融租合同的提前还款
        FindBalanceVo balancePaymentMap = leaseContractService.findBalancePayment(paramsMap, dubboTreaceParames);//尾付
        Map<String, Object> contractAccountMap = leaseContractService.findContractAccount(paramsMap, dubboTreaceParames);//融租合同承租人信息
        Map<String, Object> contractInfoMap = leaseContractService.payViewParamesContractInfo(paramsMap, dubboTreaceParames);//合同信息

        boolean month = false;
        boolean overdue = false;
        boolean contractLink = false;
        boolean contractAdvance = false;
        boolean balancePayment = false;
        if (leaseSchemeRepaymentListMonth != null) if (leaseSchemeRepaymentListMonth.size() > 0) month = true;
        if (leaseSchemeRepaymentListOverdue != null) if (leaseSchemeRepaymentListOverdue.size() > 0) overdue = true;
        //if (leaseContractLinkRepaymentListOverdue != null) if (leaseContractLinkRepaymentListOverdue.size() > 0) overdue = true;
        if (leaseContractLinkRepaymentListLink != null)
            if (leaseContractLinkRepaymentListLink.size() > 0) contractLink = true;
        if (leaseContractAdvanceList != null) if (leaseContractAdvanceList.size() > 0) contractAdvance = true;
        if (balancePaymentMap != null) if (balancePaymentMap.getIsBalancePayment() != null)
            if (balancePaymentMap.getIsBalancePayment() == 1) balancePayment = true;

        map.put("payWay", leaseDictList);//支付方式
        map.put("leaseSchemeRepaymentListMonth", leaseSchemeRepaymentListMonth);//融租合同的 当月月供、过期未付款的月供
        map.put("leaseSchemeRepaymentListOverdue", leaseSchemeRepaymentListOverdue);//融租合同的 已逾期的月供还款记录/月租滞纳金
        map.put("leaseContractLinkRepaymentListLink", leaseContractLinkRepaymentListLink);//融租合同的 当月挂靠、过期未付款的挂靠
        //map.put("leaseContractLinkRepaymentListOverdue", leaseContractLinkRepaymentListOverdue);//融租合同的 已逾期的挂靠还款记录/挂靠滞纳金
        map.put("leaseContractAdvanceList", leaseContractAdvanceList);//融租合同的提前还款
        map.put("balancePaymentMap", null);//尾付 (暂时不开放尾付扣款)
        map.put("contractAccountMap", contractAccountMap);//融租合同承租人信息
        map.put("contractInfoMap", contractInfoMap);//合同信息

        map.put("month", month);//是否有月租
        map.put("overdue", overdue);//是否有滞纳金
        map.put("contractLink", contractLink);//是否有挂靠
        map.put("contractAdvance", contractAdvance);//是否有提前还款
        map.put("balancePayment", balancePayment);//是否有尾付
        map.put("allinpayQuickPriceLimit", allinpayQuickPriceLimit);//通联协议支付单笔限额
        map.put("allinpayPriceLimit", allinpayPriceLimit);//通联代扣单笔限额

        return map;
    }

    /**
     * 批量扣款 提交批扣 / 查询需要处理的月供、滞纳金
     * 处理修改后的逾期天数，价格
     *
     * @param batchPostlendingPaymentList 查询的数据
     * @param batchPaymentVoList          提交的数据
     * @return
     * @throws GMException
     */
    public List<BatchPostlendingPaymentVo> dualRealOverduePriceBatch(List<BatchPostlendingPaymentVo> batchPostlendingPaymentList, List<BatchPaymentVo> batchPaymentVoList) throws GMException {
        List<BatchPostlendingPaymentVo> batchPostlendingPaymentListNew = null;
        if (batchPaymentVoList != null) {
            if (batchPaymentVoList.size() > 0) {
                batchPostlendingPaymentListNew = new ArrayList<BatchPostlendingPaymentVo>();
                for (int i = 0; i < batchPaymentVoList.size(); i++) {
                    BatchPaymentVo batchPaymentVo = batchPaymentVoList.get(i);
                    if (batchPostlendingPaymentList != null) {
                        if (batchPostlendingPaymentList.size() > 0) {
                            for (int j = 0; j < batchPostlendingPaymentList.size(); j++) {
                                BatchPostlendingPaymentVo batchPostlendingPaymentVo = batchPostlendingPaymentList.get(j);
                                if (batchPaymentVo.getContractId().equals(batchPostlendingPaymentVo.getContractId()) && batchPaymentVo.getRepaymentId().equals(batchPostlendingPaymentVo.getRepaymentId())) {
                                    Integer realOverdueDay = batchPaymentVo.getRealOverdueDay() == null ? 0 : batchPaymentVo.getRealOverdueDay();
                                    //用输入的逾期天数计算逾期金额
                                    BigDecimal totalOverdue = batchPostlendingPaymentVo.getOverdueRate().multiply(new BigDecimal(realOverdueDay)).multiply(batchPostlendingPaymentVo.getMonthPrice()).setScale(2, BigDecimal.ROUND_HALF_UP);
                                    //用输入的逾期天数计算逾期金额
                                    batchPostlendingPaymentVo.setRealOverdueDay(realOverdueDay);
                                    batchPostlendingPaymentVo.setRealPrice(totalOverdue);
                                    batchPostlendingPaymentListNew.add(batchPostlendingPaymentVo);
                                }
                            }
                        }
                    }
                }
            }
        }
        return batchPostlendingPaymentListNew;
    }

    /**
     * 融租合同的 已逾期的月供还款记录/月租滞纳金
     * 处理修改后的逾期天数，价格
     *
     * @param leaseSchemeRepaymentListOverdue
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<FindOverdueVo> dualRealOverduePrice(List<FindOverdueVo> leaseSchemeRepaymentListOverdue, Map<String, Object> paramsMap) throws GMException {
        List<FindOverdueVo> leaseSchemeRepaymentListOverdueNew = null;
        List<PaymentOverdueVo> paymentOverdueVoList = (List<PaymentOverdueVo>) paramsMap.get("paymentOverdueVo");
        if (paymentOverdueVoList != null) {
            if (paymentOverdueVoList.size() > 0) {
                leaseSchemeRepaymentListOverdueNew = new ArrayList<FindOverdueVo>();
                for (int i = 0; i < paymentOverdueVoList.size(); i++) {
                    PaymentOverdueVo paymentOverdueVo = paymentOverdueVoList.get(i);
                    if (leaseSchemeRepaymentListOverdue != null) {
                        if (leaseSchemeRepaymentListOverdue.size() > 0) {
                            for (int j = 0; j < leaseSchemeRepaymentListOverdue.size(); j++) {
                                FindOverdueVo findOverdueVo = leaseSchemeRepaymentListOverdue.get(j);
                                if (paymentOverdueVo.getContractId().equals(findOverdueVo.getContractId()) && paymentOverdueVo.getRepaymentId().equals(findOverdueVo.getRepaymentId())) {
                                    findOverdueVo.setRealOverdueDay(paymentOverdueVo.getRealOverdueDay());
                                    findOverdueVo.setRealPrice(paymentOverdueVo.getRealPrice());
                                    leaseSchemeRepaymentListOverdueNew.add(findOverdueVo);
                                }
                            }
                        }
                    }
                }
            }
        }
        return leaseSchemeRepaymentListOverdueNew;
    }

    /**
     * 融租合同的 已逾期的月供还款记录/月租滞纳金
     * 处理扣款提交的月租
     *
     * @param leaseSchemeRepaymentListMonth 查询的数据
     * @param paramsMap                     提交的数据
     * @return
     * @throws GMException
     */
    public List<FindMonthVo> dualRealMonthPrice(List<FindMonthVo> leaseSchemeRepaymentListMonth, Map<String, Object> paramsMap) throws GMException {
        List<FindMonthVo> leaseSchemeRepaymentListMonthNew = null;
        List<PaymentMonthVo> paymentMonthVoList = (List<PaymentMonthVo>) paramsMap.get("paymentMonthVo");//提交的数据/月供
        if (paymentMonthVoList != null) {
            if (paymentMonthVoList.size() > 0) {
                leaseSchemeRepaymentListMonthNew = new ArrayList<FindMonthVo>();
                for (int i = 0; i < paymentMonthVoList.size(); i++) {
                    PaymentMonthVo paymentMonthVo = paymentMonthVoList.get(i);
                    if (leaseSchemeRepaymentListMonth != null) {
                        if (leaseSchemeRepaymentListMonth.size() > 0) {
                            for (int j = 0; j < leaseSchemeRepaymentListMonth.size(); j++) {
                                FindMonthVo findMonthVo = leaseSchemeRepaymentListMonth.get(j);
                                if (paymentMonthVo.getContractId().equals(findMonthVo.getContractId()) && paymentMonthVo.getRepaymentId().equals(findMonthVo.getRepaymentId())) {
                                    leaseSchemeRepaymentListMonthNew.add(findMonthVo);
                                }
                            }
                        }
                    }
                }
            }
        }

        //处理逾期
        List<FindMonthVo> leaseSchemeRepaymentListMonthNew_1 = null;
        List<PaymentOverdueVo> paymentOverdueVoList = (List<PaymentOverdueVo>) paramsMap.get("paymentOverdueVo");//提交的数据/逾期
        if (paymentOverdueVoList != null) {
            if (paymentOverdueVoList.size() > 0) {
                leaseSchemeRepaymentListMonthNew_1 = new ArrayList<FindMonthVo>();
                for (int i = 0; i < paymentOverdueVoList.size(); i++) {
                    PaymentOverdueVo paymentOverdueVo = paymentOverdueVoList.get(i);
                    if (leaseSchemeRepaymentListMonthNew != null) {
                        if (leaseSchemeRepaymentListMonthNew.size() > 0) {
                            for (int j = 0; j < leaseSchemeRepaymentListMonthNew.size(); j++) {
                                FindMonthVo findMonthVo = leaseSchemeRepaymentListMonthNew.get(j);
                                if (paymentOverdueVo.getContractId().equals(findMonthVo.getContractId()) && paymentOverdueVo.getRepaymentId().equals(findMonthVo.getRepaymentId())) {
                                    findMonthVo.setRealOverdueDay(paymentOverdueVo.getRealOverdueDay());
                                    findMonthVo.setRealPrice(paymentOverdueVo.getRealPrice());
                                    leaseSchemeRepaymentListMonthNew_1.add(findMonthVo);
                                }
                            }
                        }
                    }
                }
            }
        }
        //处理逾期
        return leaseSchemeRepaymentListMonthNew_1;
    }

    /**
     * 融租合同的 已逾期的月供还款记录/月租滞纳金
     * 处理扣款提交的挂靠
     *
     * @param leaseContractLinkRepaymentListLink
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<FindLinkVo> dualRealLinkPrice(List<FindLinkVo> leaseContractLinkRepaymentListLink, Map<String, Object> paramsMap) throws GMException {
        List<FindLinkVo> leaseContractLinkRepaymentListLinkNew = null;
        List<PaymentLinkVo> paymentLinkVoList = (List<PaymentLinkVo>) paramsMap.get("paymentLinkVo");
        if (paymentLinkVoList != null) {
            if (paymentLinkVoList.size() > 0) {
                leaseContractLinkRepaymentListLinkNew = new ArrayList<FindLinkVo>();
                for (int i = 0; i < paymentLinkVoList.size(); i++) {
                    PaymentLinkVo paymentLinkVo = paymentLinkVoList.get(i);
                    if (leaseContractLinkRepaymentListLink != null) {
                        if (leaseContractLinkRepaymentListLink.size() > 0) {
                            for (int j = 0; j < leaseContractLinkRepaymentListLink.size(); j++) {
                                FindLinkVo findLinkVo = leaseContractLinkRepaymentListLink.get(j);
                                if (paymentLinkVo.getContractId().equals(findLinkVo.getContractId()) && paymentLinkVo.getRepaymentId().equals(findLinkVo.getRepaymentId())) {
                                    leaseContractLinkRepaymentListLinkNew.add(findLinkVo);
                                }
                            }
                        }
                    }
                }
            }
        }
        return leaseContractLinkRepaymentListLinkNew;
    }

    /**
     * 融租合同的 已逾期的月供还款记录/月租滞纳金
     * 处理扣款提交的提前还款
     *
     * @param leaseContractAdvanceList
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<FindAdvanceVo> dualRealAdvancePrice(List<FindAdvanceVo> leaseContractAdvanceList, Map<String, Object> paramsMap) throws GMException {
        List<FindAdvanceVo> leaseContractAdvanceListNew = null;
        List<PaymentAdvanceVo> paymentLinkVoList = (List<PaymentAdvanceVo>) paramsMap.get("paymentAdvanceVo");
        if (paymentLinkVoList != null) {
            if (paymentLinkVoList.size() > 0) {
                leaseContractAdvanceListNew = new ArrayList<FindAdvanceVo>();
                for (int i = 0; i < paymentLinkVoList.size(); i++) {
                    PaymentAdvanceVo paymentAdvanceVo = paymentLinkVoList.get(i);
                    if (leaseContractAdvanceList != null) {
                        if (leaseContractAdvanceList.size() > 0) {
                            for (int j = 0; j < leaseContractAdvanceList.size(); j++) {
                                FindAdvanceVo findAdvanceVo = leaseContractAdvanceList.get(j);
                                if (paymentAdvanceVo.getContractId().equals(findAdvanceVo.getContractId()) && paymentAdvanceVo.getRepaymentId().equals(findAdvanceVo.getRepaymentId())) {
                                    findAdvanceVo.setAdvancePrice(paymentAdvanceVo.getRealPrice());
                                    leaseContractAdvanceListNew.add(findAdvanceVo);
                                }
                            }
                        }
                    }
                }
            }
        }
        return leaseContractAdvanceListNew;
    }

    /**
     * 融租合同的 已逾期的月供还款记录/月租滞纳金
     * 处理扣款提交的尾付
     *
     * @param balancePaymentMap
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public FindBalanceVo dualRealBalancePrice(FindBalanceVo balancePaymentMap, Map<String, Object> paramsMap) throws GMException {
        FindBalanceVo leaseContractAdvanceListNew = null;
        List<PaymentBalanceVo> paymentBalanceVoList = (List<PaymentBalanceVo>) paramsMap.get("paymentBalanceVo");
        if (paymentBalanceVoList != null) {
            if (paymentBalanceVoList.size() > 0) {
                leaseContractAdvanceListNew = new FindBalanceVo();
                for (int i = 0; i < paymentBalanceVoList.size(); i++) {
                    PaymentBalanceVo paymentBalanceVo = paymentBalanceVoList.get(i);
                    if (balancePaymentMap != null) {
                        if (paymentBalanceVo.getContractId().equals(balancePaymentMap.getContractId()) && paymentBalanceVo.getRepaymentId().equals(balancePaymentMap.getRepaymentId())) {
                            leaseContractAdvanceListNew = balancePaymentMap;
                        }
                    }
                }
            }
        }
        return leaseContractAdvanceListNew;
    }

    /**
     * 通联支付 单人综合扣款
     * 扣款发送短信提醒
     *
     * @throws GMException
     */
    public void dualSingleSendSmsInfoInstall(Map<String, Object> payViewParamesMap, TransBody transBody, DubboTreaceParames dubboTreaceParames) throws GMException {

        boolean month = (Boolean) payViewParamesMap.get("month");//是否有月租
        boolean overdue = (Boolean) payViewParamesMap.get("overdue");//是否有滞纳金
        boolean contractLink = (Boolean) payViewParamesMap.get("contractLink");//是否有挂靠
        boolean contractAdvance = (Boolean) payViewParamesMap.get("contractAdvance");//是否有提前还款
        boolean balancePayment = (Boolean) payViewParamesMap.get("balancePayment");//是否有尾付

        List<FindMonthVo> leaseSchemeRepaymentListMonth = (List<FindMonthVo>) payViewParamesMap.get("leaseSchemeRepaymentListMonth");//融租合同的 当月月供、过期未付款的月供
        List<FindOverdueVo> leaseSchemeRepaymentListOverdue = (List<FindOverdueVo>) payViewParamesMap.get("leaseSchemeRepaymentListOverdue");//融租合同的 已逾期的月供还款记录/月租滞纳金
        List<FindLinkVo> leaseContractLinkRepaymentListLink = (List<FindLinkVo>) payViewParamesMap.get("leaseContractLinkRepaymentListLink");//融租合同的 当月挂靠、过期未付款的挂靠
        List<FindAdvanceVo> leaseContractAdvanceList = (List<FindAdvanceVo>) payViewParamesMap.get("leaseContractAdvanceList");//融租合同的提前还款
        FindBalanceVo balancePaymentMap = (FindBalanceVo) payViewParamesMap.get("balancePaymentMap");//尾付

        LeaseAllinpayStatusSms leaseAllinpayStatusSms = null;
        LeaseSmsLog leaseSmsLog = null;

        ///没有承租人数据或者没有扣款项则不用发送短信
        Map<String, Object> contractAccountMap = (Map<String, Object>) payViewParamesMap.get("contractAccountMap");//融租合同承租人信息
        if (contractAccountMap == null || contractAccountMap.size() <= 0) {
            return;
        }
        if ((leaseSchemeRepaymentListMonth.size() <= 0
                && leaseSchemeRepaymentListOverdue.size() <= 0
                && leaseContractLinkRepaymentListLink.size() <= 0
                && leaseContractAdvanceList.size() <= 0
                && balancePaymentMap == null)
                || transBody.getTotlePrice() == null
                || transBody.getTotlePrice().equals(BigDecimal.ZERO))
            return;
        ///没有承租人数据或者没有扣款项则不用发送短信

        ///组装 扣款发送短信提醒 数据
        Map<String, Object> sendInfoMap = Maps.newHashMap();
        StringBuffer smsTextAll = null;
        smsTextAll = new StringBuffer("(扣款提醒) 尊敬的" + contractAccountMap.get("accountName") + "客户您好!");
        //smsTextAll.append("您在我司租赁汽车费用扣款如下:");
        smsTextAll.append("合同编号：").append(contractAccountMap.get("completeContractNumber"));

        BigDecimal monthlyRent = (BigDecimal) contractAccountMap.get("monthlyRent");//合同月租
        BigDecimal overdueRate = new BigDecimal((String) contractAccountMap.get("overdueRate"));//逾期日息

        //月供
        if (month) {
            BigDecimal total = new BigDecimal(0);
            //smsTextAll.append("月供");
            smsTextAll.append("month");
            for (int i = 0; i < leaseSchemeRepaymentListMonth.size(); i++) {
                FindMonthVo leaseSchemeRepayment = leaseSchemeRepaymentListMonth.get(i);
                total = total.add(leaseSchemeRepayment.getTotal());
            }
            smsTextAll.append(total.toString()).append(";");
        }

        //挂靠费
        if (contractLink) {
            BigDecimal total = new BigDecimal(0);
            //smsTextAll.append("挂靠费");
            smsTextAll.append("link");
            for (int i = 0; i < leaseContractLinkRepaymentListLink.size(); i++) {
                FindLinkVo leaseContractLinkRepayment = leaseContractLinkRepaymentListLink.get(i);
                total = total.add(leaseContractLinkRepayment.getTotlePrice());
            }
            smsTextAll.append(total.toString()).append(";");
        }

        //逾期滞纳金
        if (overdue) {
            BigDecimal total = new BigDecimal(0);
            //smsTextAll.append("逾期滞纳金");
            smsTextAll.append("overdue");
            /*
            BigDecimal totalOverdue = overdueRate.multiply(new BigDecimal(transBody.getOverdueDay())).multiply(monthlyRent).setScale(2, BigDecimal.ROUND_HALF_UP);
            total = total.add(totalOverdue);
            */
            for (int i = 0; i < leaseSchemeRepaymentListOverdue.size(); i++) {
                FindOverdueVo leaseSchemeRepayment = leaseSchemeRepaymentListOverdue.get(i);
                total = total.add(leaseSchemeRepayment.getRealPrice());
            }
            smsTextAll.append(total.toString()).append(";");
        }

        //尾款
        if (balancePayment) {
            BigDecimal total = new BigDecimal(0);
            //smsTextAll.append("尾款");
            smsTextAll.append("balance");
            BigDecimal balance = balancePaymentMap.getBalancePayment();
            total = total.add(balancePaymentMap.getBalancePayment());
            smsTextAll.append(total.toString()).append(";");
        }

        //提前还款
        if (contractAdvance) {
            BigDecimal total = new BigDecimal(0);
            //smsTextAll.append("提前还款本金+罚款");
            smsTextAll.append("advance");
            for (int i = 0; i < leaseContractAdvanceList.size(); i++) {
                FindAdvanceVo findAdvanceVo = leaseContractAdvanceList.get(i);
                total = total.add(findAdvanceVo.getAdvancePrice());
            }
            //total = total.add(transBody.getAdvancePrice());
            smsTextAll.append(total.toString()).append(";");
        }
        sendInfoMap.put((String) contractAccountMap.get("accountPhone"), smsTextAll);

        Map<String, Object> contentMap = null;
        //发送短信
        if (sendInfoMap != null) {
            if (sendInfoMap.size() > 0) {
                contentMap = smsService.changeSchemeRepaymentStatusSendSms(sendInfoMap, dubboTreaceParames);
            }
        }
        //发送短信

        //解析短信报文内容
        Integer status = smsService.dualSmsContent(contentMap, dubboTreaceParames);
        //解析短信报文内容

        leaseSmsLog = new LeaseSmsLog();
        leaseSmsLog.setCreateTime(DateTime.now().toDate());//发送时间
        leaseSmsLog.setCreateBy(transBody.getCreateBy());
        leaseSmsLog.setName((String) contractAccountMap.get("accountName"));//接收人姓名
        leaseSmsLog.setPhone((String) contractAccountMap.get("accountPhone"));//接收手机号
        leaseSmsLog.setMessage(smsTextAll.toString());//发送内容
        leaseSmsLog.setStatus(status);
        leaseSmsLog.setType(0);
        leaseSmsLog = leaseSmsLogService.insert(leaseSmsLog);

        leaseAllinpayStatusSms = new LeaseAllinpayStatusSms();
        leaseAllinpayStatusSms.setCreateTime(DateTime.now().toDate());
        leaseAllinpayStatusSms.setSmsId(leaseSmsLog.getId());
        leaseAllinpayStatusSms.setUpdateTime(DateTime.now().toDate());
        leaseAllinpayStatusSms.setCreateBy(transBody.getCreateBy());
        leaseAllinpayStatusSmsService.insertSelective(leaseAllinpayStatusSms);
        ///组装 扣款发送短信提醒 数据

    }

    /**
     * 批量扣款
     * 通联代收、通联协议支付
     * 组装扣款数据
     * 处理各种类型的款项 汇总成一条所属 还款计划明细
     *
     * @param postlendingPaymentParameVo
     * @param batchPostlendingPaymentList 通联代扣的数据
     * @return
     * @throws GMException
     */
    public PostlendingPaymentParameVo batchTransBodyInstall(PostlendingPaymentParameVo postlendingPaymentParameVo, List<BatchPostlendingPaymentVo> batchPostlendingPaymentList) throws GMException {

        ////////////////组装通联支付 批量扣款参数////////////////
        //处理可以批扣的月供/滞纳金
        List<BatchPostlendingPaymentVo> batchPostlendingPaymentListNeed = getNeedBatchPostlendingPayment(batchPostlendingPaymentList, postlendingPaymentParameVo);//处理需要提交批扣的月供/滞纳金
        //处理可以批扣的月供/滞纳金
        if (batchPostlendingPaymentListNeed != null) {
            if (batchPostlendingPaymentListNeed.size() > 0) {
                batchPostlendingPaymentList = batchPostlendingPaymentListNeed;
                Map<String, TransBodyInstallVo> batchMapAll = Maps.newHashMap();//所有承租人的扣款数据

                BigDecimal totalPrice = new BigDecimal(0);
                for (int i = 0; i < batchPostlendingPaymentList.size(); i++) {
                    BatchPostlendingPaymentVo batchPostlendingPaymentVo = batchPostlendingPaymentList.get(i);
                    //检测是否需要代收、提交过来的合同跟后台查出来的是否匹配
                    if (ListUtil.containsList(postlendingPaymentParameVo.getContractIds(), batchPostlendingPaymentVo.getContractId().toString())) {

                        //////////////////处理属于同一个还款计划明细的款项//////////////////
                        BigDecimal total = batchPostlendingPaymentVo.getTotal();//月供金额、滞纳金、其他金额
                        BigDecimal totalOld = batchPostlendingPaymentVo.getTotal();//月供金额、滞纳金、其他金额
                        //如果是逾期则滞纳金为重新计算的金额
                        if (batchPostlendingPaymentVo.getType().equals(RepaymentStatusType.TYPE_2)) {
                            total = batchPostlendingPaymentVo.getRealPrice();
                        }
                        String sn = String.valueOf(System.currentTimeMillis()) + "-000" + i;//记录序号 通联批量扣款、通联会原样返回
                        String mapKey = batchPostlendingPaymentVo.getContractId() + "-" + batchPostlendingPaymentVo.getRepaymentId();//合同主键和还款计划明细主键组合做Map的键
                        if (batchMapAll != null) {
                            TransBodyInstallVo transBodyInstallVo = (TransBodyInstallVo) batchMapAll.get(mapKey);
                            if (transBodyInstallVo != null) {
                                transBodyInstallVo.setAmount(transBodyInstallVo.getAmount().add(total));//实际金额/修改逾期天数计算的金额
                                transBodyInstallVo.setAmountOld(transBodyInstallVo.getAmountOld().add(totalOld));//金额
                                batchPostlendingPaymentVo.setSn(transBodyInstallVo.getSn());
                            } else {
                                transBodyInstallVo = new TransBodyInstallVo();
                                transBodyInstallVo.setAccountName(batchPostlendingPaymentVo.getBankAccountName());//用户名
                                transBodyInstallVo.setAccountNo(batchPostlendingPaymentVo.getBackCardNumber());//银行卡号
                                transBodyInstallVo.setIdCard(batchPostlendingPaymentVo.getIdCard());//身份证号
                                transBodyInstallVo.setAmount(total == null ? new BigDecimal(0) : total);//实际金额/修改逾期天数计算的金额
                                transBodyInstallVo.setAmountOld(totalOld == null ? new BigDecimal(0) : totalOld);//金额
                                transBodyInstallVo.setBankCode(batchPostlendingPaymentVo.getBankCode());//银行代码
                                transBodyInstallVo.setAccountProp(AccountProp.ACCOUNTPROP_0);//
                                transBodyInstallVo.setCurrency(Currency.CURRENCY_CNY);//
                                transBodyInstallVo.setSn(sn);
                                transBodyInstallVo.setAgrmNo(batchPostlendingPaymentVo.getAgrmNo());//协议号
                                transBodyInstallVo.setAccountPhone(batchPostlendingPaymentVo.getAccountPhone());//承租人银行电话
                                transBodyInstallVo.setAllinpayPriceLimit(batchPostlendingPaymentVo.getPriceLimit());//通联代扣交易 每笔限额
                                transBodyInstallVo.setAllinpayDayPriceLimit(batchPostlendingPaymentVo.getAllinpayDayPriceLimit());//通联协议支付交易 每日限额
                                transBodyInstallVo.setDaySumLimit(batchPostlendingPaymentVo.getDaySumLimit());
                                transBodyInstallVo.setContractId(batchPostlendingPaymentVo.getContractId());
                                transBodyInstallVo.setRepaymentId(batchPostlendingPaymentVo.getRepaymentId());
                                batchPostlendingPaymentVo.setSn(sn);
                            }
                            batchMapAll.put(mapKey, transBodyInstallVo);
                        } else {
                            TransBodyInstallVo transBodyInstallVo = new TransBodyInstallVo();
                            transBodyInstallVo.setAccountName(batchPostlendingPaymentVo.getBankAccountName());//用户名
                            transBodyInstallVo.setAccountNo(batchPostlendingPaymentVo.getBackCardNumber());//银行卡号
                            transBodyInstallVo.setIdCard(batchPostlendingPaymentVo.getIdCard());//身份证号
                            transBodyInstallVo.setAmount(total == null ? new BigDecimal(0) : total);//实际金额/修改逾期天数计算的金额
                            transBodyInstallVo.setAmountOld(totalOld == null ? new BigDecimal(0) : totalOld);//金额
                            transBodyInstallVo.setBankCode(batchPostlendingPaymentVo.getBankCode());//银行代码
                            transBodyInstallVo.setAccountProp(AccountProp.ACCOUNTPROP_0);//
                            transBodyInstallVo.setCurrency(Currency.CURRENCY_CNY);//
                            transBodyInstallVo.setSn(sn);
                            transBodyInstallVo.setAgrmNo(batchPostlendingPaymentVo.getAgrmNo());//协议号
                            transBodyInstallVo.setAccountPhone(batchPostlendingPaymentVo.getAccountPhone());//承租人银行电话
                            transBodyInstallVo.setAllinpayPriceLimit(batchPostlendingPaymentVo.getPriceLimit());//通联代扣交易 每笔限额
                            transBodyInstallVo.setAllinpayDayPriceLimit(batchPostlendingPaymentVo.getAllinpayDayPriceLimit());//通联协议支付交易 每日限额
                            transBodyInstallVo.setDaySumLimit(batchPostlendingPaymentVo.getDaySumLimit());
                            transBodyInstallVo.setContractId(batchPostlendingPaymentVo.getContractId());
                            transBodyInstallVo.setRepaymentId(batchPostlendingPaymentVo.getRepaymentId());
                            batchPostlendingPaymentVo.setSn(sn);
                            batchMapAll.put(mapKey, transBodyInstallVo);
                        }
                        //////////////////处理属于同一个还款计划明细的款项//////////////////

                        totalPrice = totalPrice.add(total);

                    }
                }
                postlendingPaymentParameVo.setTotalPrice(totalPrice);
                postlendingPaymentParameVo.setBatchMapAll(batchMapAll);//所有承租人的扣款数据
            }
        }
        ////////////////组装通联支付 批量扣款参数////////////////
        return postlendingPaymentParameVo;
    }

    /**
     * 批量协议支付
     * 通联支付拆单
     * 组装扣款数据
     *
     * @param transSplitBody
     * @param batchPostlendingPaymentSplitList 查询的数据
     * @return
     * @throws GMException
     */
    public List<BatchPostlendingPaymentSplitVo> batchTransBodyInstallSplit(TransSplitBody transSplitBody, List<BatchPostlendingPaymentSplitVo> batchPostlendingPaymentSplitList) throws GMException {

        ////////////////组装扣款数据////////////////
        Map<String, Object> backNeedMap = getNeedBatchSplit(batchPostlendingPaymentSplitList, transSplitBody);//处理需要提交批扣的月供/滞纳金
        List<Map<String, Object>> batchPostlendingPaymentListSplitVoNoNeed = (List<Map<String, Object>>) backNeedMap.get("batchPostlendingPaymentListSplitVoNoNeed");//不需要处理的数据
        List<BatchPostlendingPaymentSplitVo> batchPostlendingPaymentSplitVoListNeed = (List<BatchPostlendingPaymentSplitVo>) backNeedMap.get("batchPostlendingPaymentSplitVoListNeed");//需要处理的数据
        List<BatchPostlendingPaymentSplitVo> needList = new ArrayList<BatchPostlendingPaymentSplitVo>();
        if (batchPostlendingPaymentSplitVoListNeed != null) {
            if (batchPostlendingPaymentSplitVoListNeed.size() > 0) {
                batchPostlendingPaymentSplitList = batchPostlendingPaymentSplitVoListNeed;
                for (int i = 0; i < batchPostlendingPaymentSplitList.size(); i++) {
                    BatchPostlendingPaymentSplitVo batchPostlendingPaymentSplitVo = batchPostlendingPaymentSplitList.get(i);
                    //检测是否需要代收、提交过来的数据跟后台查出来的是否匹配
                    if (ListUtil.containsList(transSplitBody.getAllinpaySplitIds(), batchPostlendingPaymentSplitVo.getId().toString())) {
                        needList.add(batchPostlendingPaymentSplitVo);
                    }
                }
            }
        }
        ////////////////组装扣款数据////////////////
        return needList;
    }

    /**
     * 检测批扣符合通联支付
     * 是否超限额、承租人数据是否符合
     *
     * @param batchPostlendingPaymentList 通联代扣的数据
     */
    public void checkBatch(List<BatchPostlendingPaymentVo> batchPostlendingPaymentList, List<BatchPostlendingPaymentVo> batchPostlendinQuickPaymentList) throws GMException {
        if (batchPostlendingPaymentList == null && batchPostlendinQuickPaymentList == null)
            throw new GMException(GMExceptionConstant.NO_NEED_TO_ALLINPAY);
        if (batchPostlendingPaymentList.size() <= 0 && batchPostlendinQuickPaymentList.size() <= 0)
            throw new GMException(GMExceptionConstant.NO_NEED_TO_ALLINPAY);
    }

    /**
     * 检测批扣符合通联支付
     *
     * @param batchPostlendingPaymentSplitList
     * @param batchPostlendingPaymentSplitQuickList
     * @throws GMException
     */
    public void checkBatchSplit(List<BatchPostlendingPaymentSplitVo> batchPostlendingPaymentSplitList, List<BatchPostlendingPaymentSplitVo> batchPostlendingPaymentSplitQuickList) throws GMException {
        if (batchPostlendingPaymentSplitList == null && batchPostlendingPaymentSplitQuickList == null)
            throw new GMException(GMExceptionConstant.NO_NEED_TO_ALLINPAY);
        if (batchPostlendingPaymentSplitList.size() <= 0 && batchPostlendingPaymentSplitQuickList.size() <= 0)
            throw new GMException(GMExceptionConstant.NO_NEED_TO_ALLINPAY);
    }

    /**
     * 需要轮询通联 的 交易流水/状态为扣款中
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public ResultHashMap findQueryTradeNew(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<FindQueryTradeNewVo> leaseSchemeRepaymentStatusList = leaseSchemeRepaymentStatusService.findQueryTradeNew(paramsMap, dubboTreaceParames);
        ResultHashMap resultHashMap = new ResultHashMap(false, leaseSchemeRepaymentStatusList, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;
    }

    /**
     * 交易查询/轮询/通联平台查询
     * 通联代扣
     *
     * @param transBody
     * @return
     * @throws GMException
     */
    public ResultHashMap queryTradeNew(TransBody transBody, DubboTreaceParames dubboTreaceParames) throws GMException {
        ReturnMessage returnMessage = tranxAdapter.queryTradeNew(transBody, dubboTreaceParames);
        ResultHashMap resultHashMap = new ResultHashMap(false, returnMessage, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;
    }

    /**
     * 交易查询/轮询/通联平台查询
     * 通联协议支付
     *
     * @param transBody
     * @return
     * @throws GMException
     */
    public ResultHashMap search(TransBody transBody, DubboTreaceParames dubboTreaceParames) throws GMException {
        QuickReturnMessage quickReturnMessage = tranxAdapter.search(transBody.getReqSn(), dubboTreaceParames);
        ResultHashMap resultHashMap = new ResultHashMap(false, quickReturnMessage, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;
    }

    /**
     * 根据 通联 轮询回来的处理结果
     * 更新 代收流水 状态 / 更新 支付状态汇总管理 状态
     *
     * @param transBody
     * @return
     * @throws GMException
     */
    public ResultHashMap changeSchemeRepaymentStatus(TransBody transBody, DubboTreaceParames dubboTreaceParames) throws GMException {

        Map<String, Object> paramsMap = Maps.newHashMap();
        context.deal(context, transBody.getPayType() + JDBCTpye.JDBC_UPDATE, transBody, null, null, dubboTreaceParames);

        //更新 合同状态 0:还款中 1:挂靠中 2:已结束 3：未还款
        paramsMap.put("id", transBody.getRepaymentId());
        paramsMap.put("contractId", transBody.getContractId());
        //LeaseSchemeRepayment leaseSchemeRepaymentB = leaseSchemeRepaymentService.selectContract(paramsMap);
        Boolean contractStatus = leaseSchemeRepaymentStatusService.findByContractidAndStatus(paramsMap, dubboTreaceParames);//合同是否未还款完毕
        LeaseContract leaseContract = leaseContractService.selectByPrimaryKey(transBody.getContractId());
        //挂靠中则不用修改状态
        if (leaseContract.getStatus() != ContractStatus.STATUS_1) {
            //合同是否未还款完毕
            if (contractStatus) {
                leaseContract.setId(transBody.getContractId());
                leaseContract.setStatus(ContractStatus.STATUS_2);//合同状态 0:还款中 1:挂靠中 2:已结束 3：未还款
                leaseContractService.updateByPrimaryKeySelective(leaseContract);
            } else {
                leaseContract.setStatus(ContractStatus.STATUS_0);//合同状态 0:还款中 1:挂靠中 2:已结束 3：未还款
                leaseContractService.updateByPrimaryKeySelective(leaseContract);
            }
        }

        //更新 合同状态 0:还款中 1:挂靠中 2:已结束 3：未还款

        ResultHashMap resultHashMap = new ResultHashMap(false, null, GMExceptionConstant.SUCCESS_UPDATE);
        return resultHashMap;

    }


    /**
     * 根据 通联 轮询回来的处理结果
     * 更新 代收流水 状态 / 更新 支付状态汇总管理 状态
     * 扣款发送短信提醒
     * 失败通知
     *
     * @throws GMException
     */
    public void dualAllinpaySendSmsInfoInstall(DubboTreaceParames dubboTreaceParames) throws GMException {
        List<FindSuccessNoSendSmsVo> findSuccessNoSendSmsList = leaseAllinpayQueryLogService.findSuccessNoSendSms(null);//未发送短信提醒的 通联轮询流水
        //////
        if (findSuccessNoSendSmsList != null) {
            //////
            if (findSuccessNoSendSmsList.size() > 0) {
                LeaseAllinpayStatusSms leaseAllinpayStatusSms = null;
                LeaseSmsLog leaseSmsLog = null;
                List<LeaseAllinpayStatusSms> list = new ArrayList<LeaseAllinpayStatusSms>();
                StringBuffer smsTextAll = null;
                ///组装 扣款发送短信提醒 数据
                Map<String, Object> sendInfoMap = Maps.newHashMap();
                for (int i = 0; i < findSuccessNoSendSmsList.size(); i++) {
                    FindSuccessNoSendSmsVo findSuccessNoSendSmsVo = findSuccessNoSendSmsList.get(i);
                    Long accountId = findSuccessNoSendSmsVo.getAccountId();
                    String accountName = findSuccessNoSendSmsVo.getAccountName();
                    String phone = findSuccessNoSendSmsVo.getPhone();
                    String backCardNumber = findSuccessNoSendSmsVo.getBackCardNumber();
                    Long repaymentId = findSuccessNoSendSmsVo.getRepaymentId();
                    Integer payType = findSuccessNoSendSmsVo.getPayType();
                    String payTypeName = findSuccessNoSendSmsVo.getPayTypeName();
                    Date repaymentDate = findSuccessNoSendSmsVo.getRepaymentDate();
                    BigDecimal totlePrice = findSuccessNoSendSmsVo.getTotlePrice();
                    String retCode = findSuccessNoSendSmsVo.getRetCode();
                    String errorMsg = findSuccessNoSendSmsVo.getErrMsg();
                    String completeContractNumber = findSuccessNoSendSmsVo.getCompleteContractNumber();
                    //扣款失败才发送短信提醒
                    if (!retCode.equals(RetCode.QUERYTRADENEW_RETCODE_0000)) {

                        /*
                        smsTextAll = new StringBuffer("（还款失败通知）尊敬的" + accountName + "");
                        String cardN = null;
                        if (backCardNumber != null) {
                            if (backCardNumber.length() > 4) {
                                cardN = backCardNumber.substring(backCardNumber.length() - 4, backCardNumber.length());
                            }
                        }
                        smsTextAll.append("您的（尾数" + cardN + "）自动还款失败，为免逾期，请联系我司及时还款。服务热线020-81234568");
                        StringBuffer smsTextItem = null;
                        if (sendInfoMap.get("phone") == null) {
                                smsTextItem = new StringBuffer("合同编号：").append(completeContractNumber);
                                smsTextItem = smsTextItem.append(payTypeName);
                                smsTextItem = smsTextItem.append(totlePrice.toString());
                                smsTextItem = smsTextAll.append(smsTextItem).append(";");
                            sendInfoMap.put(phone, smsTextAll);
                        } else {
                                smsTextItem = (StringBuffer) sendInfoMap.get(phone);
                                smsTextItem = smsTextItem.append(payTypeName);
                                smsTextItem = smsTextItem.append(totlePrice.toString());
                                smsTextItem = smsTextItem.append(";");
                            sendInfoMap.put(phone, smsTextAll);
                        }
                        */

                        smsTextAll = new StringBuffer("尊敬的客户，您因【" + errorMsg + "】自动还款不成功，为免过期，请联系我司及时还款。服务热线13610008836");
                        sendInfoMap.put(phone, smsTextAll);

                        //发送短信
                        Map<String, Object> contentMap = null;
                        if (sendInfoMap != null) {
                            if (sendInfoMap.size() > 0) {
                                contentMap = smsService.changeSchemeRepaymentStatusSendSms(sendInfoMap, dubboTreaceParames);
                            }
                        }
                        //发送短信
                        //解析短信报文内容
                        Integer status = smsService.dualSmsContent(contentMap, dubboTreaceParames);
                        //解析短信报文内容
                        leaseSmsLog = new LeaseSmsLog();
                        leaseSmsLog.setCreateTime(DateTime.now().toDate());//发送时间
                        leaseSmsLog.setCreateBy(null);
                        leaseSmsLog.setName(accountName);//接收人姓名
                        leaseSmsLog.setPhone(phone);//接收手机号
                        leaseSmsLog.setMessage(smsTextAll.toString());//发送内容
                        leaseSmsLog.setStatus(status);
                        leaseSmsLog.setType(0);
                        leaseSmsLog = leaseSmsLogService.insert(leaseSmsLog);
                        leaseAllinpayStatusSms = new LeaseAllinpayStatusSms();
                        leaseAllinpayStatusSms.setCreateTime(DateTime.now().toDate());
                        leaseAllinpayStatusSms.setQueryLogId(findSuccessNoSendSmsVo.getId());
                        leaseAllinpayStatusSms.setSmsId(leaseSmsLog.getId());
                        leaseAllinpayStatusSms.setUpdateTime(DateTime.now().toDate());
                        leaseAllinpayStatusSms.setCreateBy(null);
                        leaseAllinpayStatusSms.setType(StatusSmsType.TYPE_0_0);//短信类型：0-0:通联轮询-扣款失败通知 ; 1-0:自动提前扣款提醒(还款日期7天前) ; 1-1:自动提前扣款提醒(还款日期3天前) ; 2-0:手动发送逾期提醒
                        list.add(leaseAllinpayStatusSms);
                    }
                }
                if (list != null) {
                    if (list.size() > 0) {
                        leaseAllinpayStatusSmsService.insertList(list);
                    }
                }
                ///组装 扣款发送短信提醒 数据
            }
            //////
        }
        //////
    }

    /**
     * 定时 检测 逾期的 月租/挂靠费 并插入 逾期流水
     *
     * @return
     * @throws GMException
     */
    public ResultHashMap findIsOverdue(DubboTreaceParames dubboTreaceParames) throws GMException {
        context.deal(context, RepaymentStatusType.TYPE_0 + JDBCTpye.JDBC_OTHER, null, dubboTreaceParames, null, dubboTreaceParames);//定时 检测 逾期的 月租 并插入 逾期流水
        context.deal(context, RepaymentStatusType.TYPE_1 + JDBCTpye.JDBC_OTHER, null, dubboTreaceParames, null, dubboTreaceParames);//定时 检测 逾期的 挂靠费 并插入 逾期流水
        ResultHashMap resultHashMap = new ResultHashMap(false, null, GMExceptionConstant.SUCCESS_UPDATE);
        return resultHashMap;
    }

    /**
     * 批量扣款
     * 查询所有月供/滞纳金/挂靠/统计数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public ResultHashMap batchPostlendingPayment(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {

        List<FindAllMonthStaticsticsByCityVo> allMonthStatisticsByCity = leaseSchemeRepaymentService.findAllMonthStatisticsByCity(paramsMap, dubboTreaceParames);//根据分公司统计所有月供 批量扣款
        Map<String, Object> allMonthStatistics = leaseSchemeRepaymentService.findAllMonthStatistics(paramsMap, dubboTreaceParames);//查询所有月供 批量扣款 总计
        PageInfo<BatchPostlendingPaymentVo> page = leaseSchemeRepaymentService.findBatchPostlendingPayment(pageNum, pageSize, paramsMap, dubboTreaceParames);//批量扣款 查询所有月供/挂靠 / 查看明细

        Map<String, Object> backMap = Maps.newHashMap();
        backMap.put("allMonthStatisticsByCity", allMonthStatisticsByCity);//查询所有月供 批量扣款 统计城市
        backMap.put("allMonthStatistics", allMonthStatistics);//查询所有月供 批量扣款 总计
        backMap.put("page", page);//批量扣款 查询所有月供/挂靠 / 查看明细

        ResultHashMap resultHashMap = new ResultHashMap(false, backMap, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;
    }

    /**
     * 批量扣款无分页
     * 查询所有月供/滞纳金/挂靠/统计数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */

    public ResultHashMap batchPostlendingPaymentNoPage(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {

        List<FindAllMonthStaticsticsByCityVo> allMonthStatisticsByCity = leaseSchemeRepaymentService.findAllMonthStatisticsByCity(paramsMap, dubboTreaceParames);//根据分公司统计所有月供 批量扣款
        Map<String, Object> allMonthStatistics = leaseSchemeRepaymentService.findAllMonthStatistics(paramsMap, dubboTreaceParames);//查询所有月供 批量扣款 总计
        //List<BatchPostlendingPaymentVo> page= leaseSchemeRepaymentService.batchPostlendingPaymentNoPage(paramsMap,dubboTreaceParames);
        Map<String, Object> backMap = Maps.newHashMap();
        backMap.put("allMonthStatisticsByCity", allMonthStatisticsByCity);//查询所有月供 批量扣款 统计城市
        backMap.put("allMonthStatistics", allMonthStatistics);//查询所有月供 批量扣款 总计
        //backMap.put("page", page);//批量扣款 查询所有月供/挂靠 / 查看明细
        ResultHashMap resultHashMap = new ResultHashMap(false, backMap, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;
    }


    /**
     * 处理单人综合扣款
     * 通联代扣
     * 通联协议支付
     *
     * @param postlendingPaymentParameVo
     * @return
     * @throws GMException
     */
    public ResultHashMap dualSinglePostlendingPayment(PostlendingPaymentParameVo postlendingPaymentParameVo, DubboTreaceParames dubboTreaceParames) throws GMException {

        Map<String, Object> paramsMap = dualSingleCommonPostlendingPayment(postlendingPaymentParameVo, dubboTreaceParames);//公共处理需要扣款的数据/批扣
        List<BatchPostlendingPaymentVo> batchPostlendingPaymentList = (List<BatchPostlendingPaymentVo>) paramsMap.get("batchPostlendingPaymentList");

        ResultHashMap resultHashMap = null;
        postlendingPaymentParameVo.setAllinpayPriceLimit(new BigDecimal(allinpayPriceLimit));//通联代扣限额

        postlendingPaymentParameVo.setControllerSource(ControllerSourceType.TYPE_0);
        if (batchPostlendingPaymentList != null && batchPostlendingPaymentList.size() > 0) {
            if (postlendingPaymentParameVo.getPayWay().equals(PayWay.ALLIPAY)) {//通联代扣
                PostlendingPaymentParameVo postlendingPaymentParameVo_1 = postlendingPaymentParameVo;
                postlendingPaymentParameVo_1 = batchTransBodyInstall(postlendingPaymentParameVo, batchPostlendingPaymentList);//组装扣款数据
                resultHashMap = (ResultHashMap) context.deal(context, JDBCTpye.JDBC_INSERT + "PostlendingAllinpay", postlendingPaymentParameVo_1, batchPostlendingPaymentList, null, dubboTreaceParames);
            }
            if (postlendingPaymentParameVo.getPayWay().equals(PayWay.ALLIPAY_QUICK)) {//通联协议支付
                PostlendingPaymentParameVo postlendingPaymentParameVo_2 = postlendingPaymentParameVo;
                postlendingPaymentParameVo_2 = batchTransBodyInstall(postlendingPaymentParameVo, batchPostlendingPaymentList);//组装扣款数据
                resultHashMap = (ResultHashMap) context.deal(context, JDBCTpye.JDBC_INSERT + "QuickAllinpayCommon", postlendingPaymentParameVo_2, batchPostlendingPaymentList, null, dubboTreaceParames);
            }
        }

        return resultHashMap;
    }

    /**
     * 处理通联批扣
     * 通联代扣
     * 通联协议支付
     *
     * @param postlendingPaymentParameVo
     * @return
     * @throws GMException
     */
    public ResultHashMap dualBathPostlendingPayment(PostlendingPaymentParameVo postlendingPaymentParameVo, DubboTreaceParames dubboTreaceParames) throws GMException {

        Map<String, Object> paramsMap = dualBatchCommonPostlendingPayment(postlendingPaymentParameVo, dubboTreaceParames);//公共处理需要扣款的数据/批扣
        List<BatchPostlendingPaymentVo> batchPostlendingPaymentList = (List<BatchPostlendingPaymentVo>) paramsMap.get("batchPostlendingPaymentList");
        List<BatchPostlendingPaymentVo> batchPostlendinQuickPaymentList = (List<BatchPostlendingPaymentVo>) paramsMap.get("batchPostlendinQuickPaymentList");

        ResultHashMap resultHashMap = null;
        postlendingPaymentParameVo.setAllinpayPriceLimit(new BigDecimal(allinpayPriceLimit));//通联代扣限额
        postlendingPaymentParameVo.setControllerSource(ControllerSourceType.TYPE_1);
        if (batchPostlendingPaymentList != null && batchPostlendingPaymentList.size() > 0) {//通联代扣
            PostlendingPaymentParameVo postlendingPaymentParameVo_1 = postlendingPaymentParameVo;
            postlendingPaymentParameVo_1 = batchTransBodyInstall(postlendingPaymentParameVo, batchPostlendingPaymentList);//组装扣款数据
            resultHashMap = (ResultHashMap) context.deal(context, JDBCTpye.JDBC_INSERT + "PostlendingAllinpay", postlendingPaymentParameVo_1, batchPostlendingPaymentList, null, dubboTreaceParames);
        }
        if (batchPostlendinQuickPaymentList != null && batchPostlendinQuickPaymentList.size() > 0) {//通联协议支付
            PostlendingPaymentParameVo postlendingPaymentParameVo_2 = postlendingPaymentParameVo;
            postlendingPaymentParameVo_2 = batchTransBodyInstall(postlendingPaymentParameVo, batchPostlendinQuickPaymentList);//组装扣款数据
            resultHashMap = (ResultHashMap) context.deal(context, JDBCTpye.JDBC_INSERT + "QuickAllinpayCommon", postlendingPaymentParameVo_2, batchPostlendinQuickPaymentList, null, dubboTreaceParames);
        }

        return resultHashMap;
    }

    /**
     * 公共处理需要扣款的数据/单人综合扣款
     *
     * @param postlendingPaymentParameVo
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    public Map<String, Object> dualSingleCommonPostlendingPayment(PostlendingPaymentParameVo postlendingPaymentParameVo, DubboTreaceParames dubboTreaceParames) throws GMException {
        Map<String, Object> paramsMap = Maps.newHashMap();
        List<BatchPaymentVo> batchPaymentVoList = postlendingPaymentParameVo.getBatchPaymentVo();//批量扣款提交的数据 所有月租、滞纳金、其他金额
        if (batchPaymentVoList == null || batchPaymentVoList.size() <= 0) {
            throw new GMException(GMExceptionConstant.NO_NEED_TO_ALLINPAY);
        }
        //拼接查询条件
        List<Long> repaymentIds = new ArrayList<Long>();
        List<Long> contractIds = new ArrayList<Long>();
        for (int i = 0; i < batchPaymentVoList.size(); i++) {
            BatchPaymentVo batchPaymentVo = batchPaymentVoList.get(i);
            repaymentIds.add(batchPaymentVo.getRepaymentId());
            contractIds.add(batchPaymentVo.getContractId());
        }
        //拼接查询条件
        postlendingPaymentParameVo.setContractIds(contractIds);//次参数用作匹配查出来的数据和提交的数据
        ////////////////////////////处理需要扣款的数据////////////////////////////
        /////查询需要扣款的数据/////
        paramsMap.put("repaymentIds", repaymentIds);
        paramsMap.put("contractIds", contractIds);
        List<BatchPostlendingPaymentVo> batchPostlendingPaymentList = leaseSchemeRepaymentService.findBatchPostlendingPaymentDual(paramsMap, dubboTreaceParames);//提交批扣查询需要处理的月供、滞纳金，代扣的数据
        batchPostlendingPaymentList = dualRealOverduePriceBatch(batchPostlendingPaymentList, batchPaymentVoList);//处理修改后的逾期天数、价格
        /////查询需要扣款的数据/////
        /////在批量扣款提交的数据提取出其他金额/////
        List<BatchPostlendingPaymentVo> batchPostlendinOtherPaymentList = dualBatchPostlendingPaymentOther(batchPostlendingPaymentList, batchPaymentVoList);//代扣的数据
        /////在批量扣款提交的数据提取出其他金额/////
        /////处理好的其他金额加入需要扣款的数据/////
        if (batchPostlendingPaymentList != null && batchPostlendinOtherPaymentList != null) {
            if (batchPostlendinOtherPaymentList.size() > 0 && batchPostlendinOtherPaymentList.size() > 0) {
                batchPostlendingPaymentList.addAll(batchPostlendinOtherPaymentList);
            }
        }
        /////处理好的其他金额加入需要扣款的数据/////
        /////批量扣款提交的数据处理备注/////
        batchPostlendingPaymentList = dualBatchPostlendingPaymentRemarks(batchPostlendingPaymentList, batchPaymentVoList);//代扣的数据
        /////批量扣款提交的数据处理备注/////
        ////////////////////////////处理需要扣款的数据////////////////////////////

        //检测是否有数据
        if (batchPostlendingPaymentList == null) throw new GMException(GMExceptionConstant.NO_NEED_TO_ALLINPAY);
        if (batchPostlendingPaymentList.size() <= 0) throw new GMException(GMExceptionConstant.NO_NEED_TO_ALLINPAY);
        //检测是否有数据

        paramsMap.put("batchPostlendingPaymentList", batchPostlendingPaymentList);
        return paramsMap;
    }

    /**
     * 公共处理需要扣款的数据/批扣
     *
     * @param postlendingPaymentParameVo
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    public Map<String, Object> dualBatchCommonPostlendingPayment(PostlendingPaymentParameVo postlendingPaymentParameVo, DubboTreaceParames dubboTreaceParames) throws GMException {
        Map<String, Object> paramsMap = Maps.newHashMap();
        List<BatchPaymentVo> batchPaymentVoList = postlendingPaymentParameVo.getBatchPaymentVo();//批量扣款提交的数据 所有月租、滞纳金、其他金额
        if (batchPaymentVoList == null || batchPaymentVoList.size() <= 0) {
            throw new GMException(GMExceptionConstant.NO_NEED_TO_ALLINPAY);
        }

        //拼接查询条件
        List<Long> repaymentIds = new ArrayList<Long>();
        List<Long> contractIds = new ArrayList<Long>();
        for (int i = 0; i < batchPaymentVoList.size(); i++) {
            BatchPaymentVo batchPaymentVo = batchPaymentVoList.get(i);
            repaymentIds.add(batchPaymentVo.getRepaymentId());
            contractIds.add(batchPaymentVo.getContractId());
        }
        //拼接查询条件
        postlendingPaymentParameVo.setContractIds(contractIds);//次参数用作匹配查出来的数据和提交的数据

        ////////////////////////////处理需要扣款的数据////////////////////////////

        /////查询需要扣款的数据/////
        paramsMap.put("repaymentIds", repaymentIds);
        paramsMap.put("contractIds", contractIds);
        paramsMap.put("payWay", 4);//扣款方式未代扣
        List<BatchPostlendingPaymentVo> batchPostlendingPaymentList = leaseSchemeRepaymentService.findBatchPostlendingPaymentDual(paramsMap, dubboTreaceParames);//提交批扣查询需要处理的月供、滞纳金，代扣的数据
        batchPostlendingPaymentList = dualRealOverduePriceBatch(batchPostlendingPaymentList, batchPaymentVoList);//处理修改后的逾期天数、价格
        paramsMap.put("payWay", 9);//扣款方式未协议支付
        List<BatchPostlendingPaymentVo> batchPostlendinQuickPaymentList = leaseSchemeRepaymentService.findBatchPostlendingPaymentDual(paramsMap, dubboTreaceParames);//提交批扣查询需要处理的月供、滞纳金，协议支付的数据
        batchPostlendinQuickPaymentList = dualRealOverduePriceBatch(batchPostlendinQuickPaymentList, batchPaymentVoList);//处理修改后的逾期天数、价格
        /////查询需要扣款的数据/////

        /////在批量扣款提交的数据提取出其他金额/////
        List<BatchPostlendingPaymentVo> batchPostlendinOtherPaymentList = dualBatchPostlendingPaymentOther(batchPostlendingPaymentList, batchPaymentVoList);//代扣的数据
        List<BatchPostlendingPaymentVo> batchPostlendinOtherQuickPaymentList = dualBatchPostlendingPaymentOther(batchPostlendinQuickPaymentList, batchPaymentVoList);//协议支付的数据
        /////在批量扣款提交的数据提取出其他金额/////

        /////处理好的其他金额加入需要扣款的数据/////
        if (batchPostlendingPaymentList != null && batchPostlendinOtherPaymentList != null) {
            if (batchPostlendinOtherPaymentList.size() > 0 && batchPostlendinOtherPaymentList.size() > 0) {
                batchPostlendingPaymentList.addAll(batchPostlendinOtherPaymentList);
            }
        }
        if (batchPostlendinQuickPaymentList != null && batchPostlendinOtherQuickPaymentList != null) {
            if (batchPostlendinQuickPaymentList.size() > 0 && batchPostlendinOtherQuickPaymentList.size() > 0) {
                batchPostlendinQuickPaymentList.addAll(batchPostlendinOtherQuickPaymentList);
            }
        }
        /////处理好的其他金额加入需要扣款的数据/////

        /////批量扣款提交的数据处理备注/////
        batchPostlendingPaymentList = dualBatchPostlendingPaymentRemarks(batchPostlendingPaymentList, batchPaymentVoList);//代扣的数据
        batchPostlendinQuickPaymentList = dualBatchPostlendingPaymentRemarks(batchPostlendinQuickPaymentList, batchPaymentVoList);//协议支付的数据
        /////批量扣款提交的数据处理备注/////

        ////////////////////////////处理需要扣款的数据////////////////////////////

        //检测是否有数据
        checkBatch(batchPostlendingPaymentList, batchPostlendinQuickPaymentList);
        //检测是否有数据

        paramsMap.put("batchPostlendingPaymentList", batchPostlendingPaymentList);
        paramsMap.put("batchPostlendinQuickPaymentList", batchPostlendinQuickPaymentList);
        return paramsMap;
    }

    /**
     * 在批量扣款提交的数据提取出其他金额
     *
     * @param batchPostlendingPaymentList 查询的数据
     * @param batchPaymentVoList          提交的数据
     */
    public List<BatchPostlendingPaymentVo> dualBatchPostlendingPaymentOther(List<BatchPostlendingPaymentVo> batchPostlendingPaymentList, List<BatchPaymentVo> batchPaymentVoList) {
        List<BatchPostlendingPaymentVo> otherList = new ArrayList<BatchPostlendingPaymentVo>();
        if (batchPostlendingPaymentList != null) {
            if (batchPostlendingPaymentList.size() > 0) {
                BatchPostlendingPaymentVo batchPostlendingPaymentOtherVo = null;
                for (int i = 0; i < batchPostlendingPaymentList.size(); i++) {
                    BatchPostlendingPaymentVo batchPostlendingPaymentVo = batchPostlendingPaymentList.get(i);
                    Long contractId = batchPostlendingPaymentVo.getContractId();
                    Long repaymentId = batchPostlendingPaymentVo.getRepaymentId();
                    if (batchPostlendingPaymentVo.getType().equals(RepaymentStatusType.TYPE_0)) {
                        for (int j = 0; j < batchPaymentVoList.size(); j++) {
                            batchPostlendingPaymentOtherVo = new BatchPostlendingPaymentVo();
                            BatchPaymentVo batchPaymentVo = batchPaymentVoList.get(j);
                            Long contractId_1 = batchPaymentVo.getContractId();
                            Long repaymentId_1 = batchPaymentVo.getRepaymentId();
                            if (contractId.equals(contractId_1) && repaymentId.equals(repaymentId_1)) {
                                if (batchPaymentVo.getOther() != null) {
                                    if (batchPaymentVo.getOther().compareTo(BigDecimal.ZERO) != 0 && batchPaymentVo.getOther().compareTo(BigDecimal.ZERO) != -1) {
                                        batchPostlendingPaymentOtherVo.setContractId(contractId_1);
                                        batchPostlendingPaymentOtherVo.setRepaymentId(repaymentId_1);
                                        batchPostlendingPaymentOtherVo.setCompleteContractNumber(batchPostlendingPaymentVo.getCompleteContractNumber());
                                        batchPostlendingPaymentOtherVo.setTotalPeriod(batchPostlendingPaymentVo.getTotalPeriod());
                                        batchPostlendingPaymentOtherVo.setStatus(batchPostlendingPaymentVo.getStatus());
                                        batchPostlendingPaymentOtherVo.setCompanyName(batchPostlendingPaymentVo.getCompanyName());
                                        batchPostlendingPaymentOtherVo.setAccountId(batchPostlendingPaymentVo.getAccountId());
                                        batchPostlendingPaymentOtherVo.setAccountName(batchPostlendingPaymentVo.getAccountName());
                                        batchPostlendingPaymentOtherVo.setAccountType(batchPostlendingPaymentVo.getAccountType());
                                        batchPostlendingPaymentOtherVo.setBankAccountName(batchPostlendingPaymentVo.getBankAccountName());
                                        batchPostlendingPaymentOtherVo.setBackCardNumber(batchPostlendingPaymentVo.getBackCardNumber());
                                        batchPostlendingPaymentOtherVo.setIdCard(batchPostlendingPaymentVo.getIdCard());
                                        batchPostlendingPaymentOtherVo.setBankName(batchPostlendingPaymentVo.getBankName());
                                        batchPostlendingPaymentOtherVo.setBankCode(batchPostlendingPaymentVo.getBankCode());
                                        batchPostlendingPaymentOtherVo.setType(RepaymentStatusType.TYPE_7);
                                        batchPostlendingPaymentOtherVo.setTotal(batchPaymentVo.getOther());
                                        batchPostlendingPaymentOtherVo.setPriceLimit(batchPostlendingPaymentVo.getPriceLimit());
                                        batchPostlendingPaymentOtherVo.setPayWay(batchPostlendingPaymentVo.getPayWay());
                                        otherList.add(batchPostlendingPaymentOtherVo);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return otherList;
    }

    /**
     * 在批量扣款提交的数据处理备注
     *
     * @param batchPostlendingPaymentList 查询的数据
     * @param batchPaymentVoList          提交的数据
     */
    public List<BatchPostlendingPaymentVo> dualBatchPostlendingPaymentRemarks(List<BatchPostlendingPaymentVo> batchPostlendingPaymentList, List<BatchPaymentVo> batchPaymentVoList) {
        List<BatchPostlendingPaymentVo> remarksList = new ArrayList<BatchPostlendingPaymentVo>();
        if (batchPostlendingPaymentList != null) {
            if (batchPostlendingPaymentList.size() > 0) {
                for (int i = 0; i < batchPostlendingPaymentList.size(); i++) {
                    BatchPostlendingPaymentVo batchPostlendingPaymentVo = batchPostlendingPaymentList.get(i);
                    Long contractId = batchPostlendingPaymentVo.getContractId();
                    Long repaymentId = batchPostlendingPaymentVo.getRepaymentId();
                    for (int j = 0; j < batchPaymentVoList.size(); j++) {
                        BatchPaymentVo batchPaymentVo = batchPaymentVoList.get(j);
                        Long contractId_1 = batchPaymentVo.getContractId();
                        Long repaymentId_1 = batchPaymentVo.getRepaymentId();
                        if (contractId.equals(contractId_1) && repaymentId.equals(repaymentId_1)) {
                            if (StringUtils.isNoneEmpty(batchPaymentVo.getRemarks())) {
                                batchPostlendingPaymentVo.setRemarks(batchPaymentVo.getRemarks());
                            }
                        }
                    }
                }
            }
        }
        return batchPostlendingPaymentList;
    }

    /**
     * 处理需要的批量协议支付
     * 假如承租人的身份证，银行卡号，银行编号，姓名跟通联的账户不匹配则无需扣款
     * 卡号所属银行与发卡行不一致
     * 账号户名不符
     * 证件类型和证件号错误
     * 无效卡号
     *
     * @param batchPostlendingPaymentSplitVoList
     * @param transSplitBody
     * @return
     * @throws GMException
     */
    public Map<String, Object> getNeedBatchSplit(List<BatchPostlendingPaymentSplitVo> batchPostlendingPaymentSplitVoList, TransSplitBody transSplitBody) throws GMException {
        List<BatchPostlendingPaymentSplitVo> batchPostlendingPaymentSplitVoListNeed = new ArrayList<BatchPostlendingPaymentSplitVo>();//可以批扣的月供/滞纳金
        List<Map<String, Object>> batchPostlendingPaymentListSplitVoNoNeed = new ArrayList<Map<String, Object>>();//不可以批扣的月供/滞纳金
        Map<String, Object> backNeedMap = Maps.newHashMap();
        for (int i = 0; i < batchPostlendingPaymentSplitVoList.size(); i++) {
            BatchPostlendingPaymentSplitVo batchPostlendingPaymentSplitVo = batchPostlendingPaymentSplitVoList.get(i);
            //检测是否需要代收、提交过来的合同跟后台查出来的是否匹配
            if (ListUtil.containsList(transSplitBody.getAllinpaySplitIds(), batchPostlendingPaymentSplitVo.getId().toString())) {
                Map<String, Object> paramesMap = Maps.newHashMap();
                if (batchPostlendingPaymentSplitVo.getAccountName() == null || batchPostlendingPaymentSplitVo.getBackCardNumber() == null || batchPostlendingPaymentSplitVo.getIdCard() == null) {
                    //检测承租人信息
                    if (batchPostlendingPaymentSplitVo.getBankAccountName() == null) {
                        paramesMap.put("completeContractNumber", batchPostlendingPaymentSplitVo.getCompleteContractNumber());
                        paramesMap.put("errMsg", GMExceptionConstant.ACCOUNT_NAME_ERROR);
                    } else if (batchPostlendingPaymentSplitVo.getBackCardNumber() == null) {
                        paramesMap.put("completeContractNumber", batchPostlendingPaymentSplitVo.getCompleteContractNumber());
                        paramesMap.put("errMsg", GMExceptionConstant.ACCOUNT_BACKCARDNUMBER_ERROR);
                    } else if (batchPostlendingPaymentSplitVo.getIdCard() == null) {
                        paramesMap.put("completeContractNumber", batchPostlendingPaymentSplitVo.getCompleteContractNumber());
                        paramesMap.put("errMsg", GMExceptionConstant.ACCOUNT_IDCARD_ERROR);
                    }
                    //检测承租人信息
                    batchPostlendingPaymentListSplitVoNoNeed.add(paramesMap);
                } else {
                    batchPostlendingPaymentSplitVoListNeed.add(batchPostlendingPaymentSplitVo);
                }
            }
        }
        backNeedMap.put("batchPostlendingPaymentListSplitVoNoNeed", batchPostlendingPaymentListSplitVoNoNeed);
        backNeedMap.put("batchPostlendingPaymentSplitVoListNeed", batchPostlendingPaymentSplitVoListNeed);
        return backNeedMap;
    }

    /**
     * 处理需要提交批扣的月供/滞纳金
     * 假如承租人的身份证，银行卡号，银行编号，姓名跟通联的账户不匹配则无需扣款
     * 卡号所属银行与发卡行不一致
     * 账号户名不符
     * 证件类型和证件号错误
     * 无效卡号
     *
     * @param batchPostlendingPaymentList
     * @param postlendingPaymentParameVo
     * @return
     * @throws GMException
     */
    public List<BatchPostlendingPaymentVo> getNeedBatchPostlendingPayment(List<BatchPostlendingPaymentVo> batchPostlendingPaymentList, PostlendingPaymentParameVo postlendingPaymentParameVo) throws GMException {
        List<BatchPostlendingPaymentVo> batchPostlendingPaymentListNeed = new ArrayList<BatchPostlendingPaymentVo>();//可以批扣的月供/滞纳金
        for (int i = 0; i < batchPostlendingPaymentList.size(); i++) {
            BatchPostlendingPaymentVo batchPostlendingPaymentVo = batchPostlendingPaymentList.get(i);
            //检测是否需要代收、提交过来的合同跟后台查出来的是否匹配
            if (ListUtil.containsList(postlendingPaymentParameVo.getContractIds(), batchPostlendingPaymentVo.getContractId().toString())) {
                Map<String, Object> paramesMap = Maps.newHashMap();
                if (batchPostlendingPaymentVo.getAccountName() == null || batchPostlendingPaymentVo.getBackCardNumber() == null || batchPostlendingPaymentVo.getIdCard() == null) {
                    //检测承租人信息
                    if (batchPostlendingPaymentVo.getBankAccountName() == null) {
                        paramesMap.put("completeContractNumber", batchPostlendingPaymentVo.getCompleteContractNumber());
                        paramesMap.put("errMsg", GMExceptionConstant.ACCOUNT_NAME_ERROR);
                    } else if (batchPostlendingPaymentVo.getBackCardNumber() == null) {
                        paramesMap.put("completeContractNumber", batchPostlendingPaymentVo.getCompleteContractNumber());
                        paramesMap.put("errMsg", GMExceptionConstant.ACCOUNT_BACKCARDNUMBER_ERROR);
                    } else if (batchPostlendingPaymentVo.getIdCard() == null) {
                        paramesMap.put("completeContractNumber", batchPostlendingPaymentVo.getCompleteContractNumber());
                        paramesMap.put("errMsg", GMExceptionConstant.ACCOUNT_IDCARD_ERROR);
                    }
                    //检测承租人信息
                } else {
                    batchPostlendingPaymentListNeed.add(batchPostlendingPaymentVo);
                }
            }
        }
        return batchPostlendingPaymentListNeed;
    }

    /**
     * 融资租赁标的物及租金支付表
     *
     * @param paramsMap
     * @return
     */
    public ResultHashMap findContractInfo(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        Map<String, Object> contractInfo = leaseContractService.findContractInfo(paramsMap, dubboTreaceParames);//标的物
        List<SelectByContractIdVo> leaseSchemeRepaymentList = leaseSchemeRepaymentService.findByContractId(paramsMap, dubboTreaceParames);//租金支付表 / 融租合同-月租还款计划明细
        Map<String, Object> backMap = Maps.newHashMap();
        backMap.put("contractInfo", contractInfo);//标的物
        backMap.put("leaseSchemeRepaymentList", leaseSchemeRepaymentList);//租金支付表 / 融租合同-月租还款计划明细
        ResultHashMap resultHashMap = new ResultHashMap(false, backMap, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;
    }

    /**
     * 还款历史/合同还款明细
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public ResultHashMap contractAllinpayLog(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<ContractAllinpayLogVo> leaseAllinpayLog = leaseAllinpayLogService.findByContractId(paramsMap, dubboTreaceParames);//支付历史
        FindAllinpayLogStatisticsVo findAllinpayLogStatisticsVo = leaseContractService.findAllinpayLogStatistics(paramsMap);//还款历史 查看里面的统计部分
        paramsMap = Maps.newHashMap();
        paramsMap.put("leaseAllinpayLog", leaseAllinpayLog);
        paramsMap.put("findAllinpayLogStatisticsVo", findAllinpayLogStatisticsVo);
        ResultHashMap resultHashMap = new ResultHashMap(false, paramsMap, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;
    }

    /**
     * 通联日志 / 批扣 数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public PageInfo<LeaseAllinpayBatch>     allinpayLogBatch(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        PageInfo<LeaseAllinpayBatch> leaseAllinpayBatchPage = leaseAllinpayBatchService.findPage(pageNum, pageSize, paramsMap);
        return leaseAllinpayBatchPage;
    }

    /**
     * 通联日志
     * 单笔
     * 查看明细
     * 因为每笔款不是即时出结果，所以代收流水的状态不是最终状态，轮询流水的状态是最终状态，
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public ResultHashMap paymentLogDetail(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<ContractAllinpayLogVo> leaseAllinpayBatchList = leaseAllinpayLogService.paymentLogDetail(paramsMap, dubboTreaceParames);
        ResultHashMap resultHashMap = new ResultHashMap(false, leaseAllinpayBatchList, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;
    }

    /**
     * 批扣数据用城市统计/查看统计
     *
     * @param paramsMap
     * @return
     */
    public ResultHashMap allinpayBatchStatistics(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        Map<String, Object> backMap = Maps.newHashMap();
        List<Map<String, Object>> leaseAllinpayLogList = leaseAllinpayLogService.allinpayBatchStatisticsByCity(paramsMap, dubboTreaceParames);//批扣数据用城市统计
        Map<String, Object> leaseAllinpayLog = leaseAllinpayLogService.allinpayBatchStatistics(paramsMap, dubboTreaceParames);//查看统计/总计
        backMap.put("leaseAllinpayLogList", ListUtil.objectIsNullToList(leaseAllinpayLogList));
        backMap.put("leaseAllinpayLog", ListUtil.objectIsNullToMap(leaseAllinpayLog));
        ResultHashMap resultHashMap = new ResultHashMap(false, backMap, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;
    }

    /**
     * 融租合同 不用系统处理扣款的月租、滞纳金、尾款,录入的合同数据如果是不需要系统处理租金扣款，则记录，因为有些合同数据是线下处理了收款
     * 批量补录的数据
     *
     * @param paramsMap
     * @return
     */
    public ResultHashMap findRepaymentExcept(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<Map<String, Object>> Object = leaseSchemeRepaymentService.findRepaymentExcept(paramsMap, dubboTreaceParames);
        ResultHashMap resultHashMap = new ResultHashMap(false, Object, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;
    }

    /**
     * 融租合同 不用系统处理扣款的月租、滞纳金、尾款,录入的合同数据如果是不需要系统处理租金扣款，则记录，因为有些合同数据是线下处理了收款
     * 提交批量补录/处理月供、滞纳金、尾款
     *
     * @param paramsMap
     * @return
     */
    public ResultHashMap repaymentExcept(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {

        List<String> list = (List<String>) paramsMap.get("repaymentDate");
        Long userId = (Long) paramsMap.get("userI");
        List<FindByRepaymentDateVo> leaseSchemeRepaymentList = leaseSchemeRepaymentService.findByRepaymentDate(list, dubboTreaceParames);//查询某个扣款日的合同还款明细数据/月租、滞纳金、尾款

        if (leaseSchemeRepaymentList != null) {
            if (leaseSchemeRepaymentList.size() > 0) {
                ArrayList<LeaseContractRepaymentExcept> listRepaymentExcept = new ArrayList<LeaseContractRepaymentExcept>();//不用系统处理扣款的月租
                ArrayList<LeaseSchemeRepaymentStatus> listRepaymentStatusList = new ArrayList<LeaseSchemeRepaymentStatus>();
                List<LeaseOverdueLog> leaseOverdueLogList = new ArrayList<LeaseOverdueLog>();
                LeaseOverdueLog leaseOverdueLog = null;
                LeaseContractRepaymentExcept leaseContractRepaymentExcept = null;
                LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus = null;
                for (int i = 0; i < leaseSchemeRepaymentList.size(); i++) {

                    //不用系统处理扣款的月租
                    leaseContractRepaymentExcept = new LeaseContractRepaymentExcept();
                    FindByRepaymentDateVo findByRepaymentDateVo = leaseSchemeRepaymentList.get(i);
                    Long repaymentId = findByRepaymentDateVo.getId();
                    Long contractId = findByRepaymentDateVo.getContractId();
                    Long accountId = findByRepaymentDateVo.getLesseeId();
                    leaseContractRepaymentExcept.setRepaymentId(repaymentId);
                    leaseContractRepaymentExcept.setContractId(contractId);
                    leaseContractRepaymentExcept.setCreateTime(DateTime.now().toDate());
                    leaseContractRepaymentExcept.setUpdateTime(DateTime.now().toDate());
                    leaseContractRepaymentExcept.setType(findByRepaymentDateVo.getType());
                    listRepaymentExcept.add(leaseContractRepaymentExcept);
                    //不用系统处理扣款的月租

                    //批量更新 支付状态汇总管理
                    paramsMap.put("repaymentId", repaymentId);
                    paramsMap.put("contractId", contractId);
                    paramsMap.put("type", findByRepaymentDateVo.getType());
                    leaseSchemeRepaymentStatus = leaseSchemeRepaymentStatusService.selectByContract(paramsMap, dubboTreaceParames);//查询月供、滞纳金的支付状态
                    //leaseSchemeRepaymentStatus = new LeaseSchemeRepaymentStatus();
                    leaseSchemeRepaymentStatus.setRepaymentId(repaymentId);
                    leaseSchemeRepaymentStatus.setContractId(contractId);
                    leaseSchemeRepaymentStatus.setType(findByRepaymentDateVo.getType());//款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款/还款到最后一期的尾款; 5:提前还款罚款; 6:尾款/提前还款的尾款
                    leaseSchemeRepaymentStatus.setPaymentResult(PaymentResult.TYPE_2);
                    leaseSchemeRepaymentStatus.setPaymentResultMsg("批量补录");
                    leaseSchemeRepaymentStatus.setPayWay(PayWay.BATCH);//
                    leaseSchemeRepaymentStatus.setUpdateTime(DateTime.now().toDate());
                    leaseSchemeRepaymentStatus.setUpdateBy(userId);
                    listRepaymentStatusList.add(leaseSchemeRepaymentStatus);
                    //批量更新 支付状态汇总管理

                    //更新 逾期记录 支付状态
                    if (findByRepaymentDateVo.getType() == 2) {
                        leaseOverdueLog = new LeaseOverdueLog();
                        leaseOverdueLog.setRepaymentId(repaymentId);
                        leaseOverdueLog.setContractId(contractId);
                        leaseOverdueLog.setUpdateTime(DateTime.now().toDate());
                        leaseOverdueLog.setPaymentResult(PaymentResult.TYPE_2);
                        leaseOverdueLog.setType(RepaymentStatusType.TYPE_0);
                        leaseOverdueLogList.add(leaseOverdueLog);
                    }
                    //更新 逾期记录 支付状态

                    //插入 代收流水 数据
                    LeaseAllinpayLog leaseAllinpayLog = new LeaseAllinpayLog();
                    leaseAllinpayLog.setRepaymentId(repaymentId);//融租合同-还款计划明细主键id
                    leaseAllinpayLog.setRepaymentStatusId(leaseSchemeRepaymentStatus.getId());
                    leaseAllinpayLog.setContractId(contractId);
                    leaseAllinpayLog.setTotlePrice(findByRepaymentDateVo.getTotal());//合计金额
                    leaseAllinpayLog.setRealPrice(findByRepaymentDateVo.getTotal());
                    leaseAllinpayLog.setSingleOrBatch(0);//单笔或批量/0:单笔; 1:批量
                    leaseAllinpayLog.setPayType(findByRepaymentDateVo.getType());//支付款项类型 0:月供; 1:逾期滞纳金;  2: 挂靠费; 3:提前还款/剩余本金; 4:尾款; 5:提前还款罚款
                    leaseAllinpayLog.setOverdue(findByRepaymentDateVo.getOverdue() == 0 ? true : false);//是否逾期
                    leaseAllinpayLog.setOverdueDay(findByRepaymentDateVo.getOverdueDay());//逾期天数
                    leaseAllinpayLog.setRealOverdueDay(findByRepaymentDateVo.getOverdueDay());//实际逾期天数、扣款的时候改动的实际逾期天数
                    leaseAllinpayLog.setStatus(1);//通联支付状态/0:已提交;1:成功;2:失败
                    leaseAllinpayLog.setPayWay(PayWay.BATCH);//
                    leaseAllinpayLog.setAccountId(accountId);
                    leaseAllinpayLog.setCreateBy((Long) paramsMap.get("userId"));
                    leaseAllinpayLog.setUpdateBy((Long) paramsMap.get("userId"));
                    leaseAllinpayLog.setUpdateTime(DateTime.now().toDate());
                    leaseAllinpayLog.setRemarks("批量补录");
                    leaseAllinpayLog = leaseAllinpayLogService.insertSelective(leaseAllinpayLog);
                    //插入 代收流水 数据

                    //插入 代收状态流水 数据
                    LeaseAllinpayStatusLog leaseAllinpayStatusLog = new LeaseAllinpayStatusLog();
                    leaseAllinpayStatusLog.setAllinpayLogId(leaseAllinpayLog.getId());//代收流水主键id
                    leaseAllinpayStatusLog.setCreateTime(DateTime.now().toDate());//
                    leaseAllinpayStatusLog.setCreateBy((Long) paramsMap.get("userId"));
                    leaseAllinpayStatusLog = leaseAllinpayStatusLogService.insertSelective(leaseAllinpayStatusLog);
                    //插入 代收状态流水 数据

                }

                //批量插入融租合同 不用系统处理扣款的月租
                if (listRepaymentExcept.size() > 0) {
                    leaseContractRepaymentExceptService.insertList(listRepaymentExcept);
                }
                //批量插入融租合同 不用系统处理扣款的月租

                //批量更新 支付状态汇总管理
                if (listRepaymentStatusList.size() > 0) {
                    leaseSchemeRepaymentStatusService.batchUpdateByContract(listRepaymentStatusList, dubboTreaceParames);
                }
                //批量更新 支付状态汇总管理

                //批量更新 逾期记录支付状态
                if (leaseOverdueLogList.size() > 0) {
                    leaseOverdueLogService.batchUpdateStatus(leaseOverdueLogList, dubboTreaceParames);
                }
                //批量更新 逾期记录支付状态

                //更新 合同状态 0:还款中 1:挂靠中 2:已结束 3：未还款
                if (listRepaymentStatusList.size() > 0) {
                    for (int i = 0; i < listRepaymentStatusList.size(); i++) {
                        LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus1 = listRepaymentStatusList.get(i);
                        //paramsMap.put("id", leaseSchemeRepaymentStatus1.getRepaymentId());
                        paramsMap.put("contractId", leaseSchemeRepaymentStatus1.getContractId());
                        //LeaseSchemeRepayment leaseSchemeRepaymentB = leaseSchemeRepaymentService.selectContract(paramsMap);
                        Boolean contractStatus = leaseSchemeRepaymentStatusService.findByContractidAndStatus(paramsMap, dubboTreaceParames);//合同是否还款完毕
                        LeaseContract leaseContract = leaseContractService.selectByPrimaryKey(leaseSchemeRepaymentStatus1.getContractId());
                        if (leaseContract != null) {
                            //挂靠中则不用修改状态
                            if (leaseContract.getStatus() != ContractStatus.STATUS_1) {
                                //合同是否未还款完毕
                                if (contractStatus) {
                                    leaseContract.setId(leaseSchemeRepaymentStatus1.getContractId());
                                    leaseContract.setStatus(ContractStatus.STATUS_2);//合同状态 0:还款中 1:挂靠中 2:已结束 3：未还款
                                    leaseContractService.updateByPrimaryKeySelective(leaseContract);
                                } else {
                                    leaseContract.setStatus(ContractStatus.STATUS_0);//合同状态 0:还款中 1:挂靠中 2:已结束 3：未还款
                                    leaseContractService.updateByPrimaryKeySelective(leaseContract);
                                }
                            }
                        }
                    }
                }
                //更新 合同状态 0:还款中 1:挂靠中 2:已结束 3：未还款

            }
        }

        ResultHashMap resultHashMap = new ResultHashMap(false, null, GMExceptionConstant.DUAL_SUCCESS);
        return resultHashMap;
    }

    /**
     * 逾期短信通知列表
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public ResultHashMap findPostLendingOverdueSms(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {

        PageInfo<LeasePostLendingVo> page = leaseContractService.findPostLendingOverdueSms(pageNum, pageSize, paramsMap, dubboTreaceParames);//月供管理合同列表
        /*
        List<Map<String, Object>> allContractStatusDetails = leaseContractService.selectAllContractStatusDetailsOverdueSms(paramsMap, dubboTreaceParames);//所有合同的 款项 对应的 支付结果 状态
        List<Map<String, Object>> contractStatisticsByCity = leaseContractService.findAllContractStatisticsByCityOverdueSms(paramsMap, dubboTreaceParames);//根据分公司统计所有合同
        List<Map<String, Object>> contractStatisticsByStatus = leaseContractService.findAllContractStatisticsByStatusOverdueSms(paramsMap, dubboTreaceParames);//根据状态统计所有合同
        */
        Map<String, Object> backMap = Maps.newHashMap();
        backMap.put("page", page);//月供管理合同列表
        /*
        backMap.put("allContractStatusDetails", allContractStatusDetails);//所有合同的 款项 对应的 支付结果 状态 / 如：单人综合扣款表头的统计
        backMap.put("contractStatisticsByCity", contractStatisticsByCity);//根据分公司统计所有合同
        backMap.put("contractStatisticsByStatus", contractStatisticsByStatus);//根据状态统计所有合同
        */
        backMap.put("backDate", paramsMap.get("backDate"));
        ResultHashMap resultHashMap = new ResultHashMap(false, backMap, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;
    }

    /**
     * 逾期通知短信 预览
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public ResultHashMap overdueSmsPreview(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<FindMonthVo> leaseSchemeRepaymentListMonth = leaseSchemeRepaymentService.findCurrentMonth(paramsMap, dubboTreaceParames);//融租合同的 当月月供
        List<FindOverdueVo> leaseSchemeRepaymentListOverdue = leaseSchemeRepaymentService.findCurrentOverdue(paramsMap, dubboTreaceParames);//融租合同的 当月已逾期的月租还款记录
        Map<String, Object> contractAccountMap = leaseContractService.findContractAccount(paramsMap, dubboTreaceParames);//融租合同承租人信息

        if (leaseSchemeRepaymentListMonth == null || leaseSchemeRepaymentListMonth.size() <= 0) {
            throw new GMException(GMExceptionConstant.NO_SMS_SEND);
        }

        if (leaseSchemeRepaymentListOverdue == null || leaseSchemeRepaymentListOverdue.size() <= 0) {
            throw new GMException(GMExceptionConstant.NO_SMS_SEND);
        }

        if (contractAccountMap == null || contractAccountMap.size() <= 0 || contractAccountMap.get("accountPhone") == null) {
            throw new GMException(GMExceptionConstant.NO_SMS_SEND);
        }

        StringBuffer smsTextAll = null;
        if (leaseSchemeRepaymentListMonth != null) {
            if (leaseSchemeRepaymentListMonth.size() > 0) {
                //组装短信内容
                smsTextAll = new StringBuffer("尊敬的客户,你的");
                BigDecimal total = new BigDecimal(0);
                for (int i = 0; i < leaseSchemeRepaymentListMonth.size(); i++) {
                    FindMonthVo findMonthVo = leaseSchemeRepaymentListMonth.get(i);
                    if (leaseSchemeRepaymentListOverdue != null) {
                        if (leaseSchemeRepaymentListOverdue.size() > 0) {
                            for (int j = 0; j < leaseSchemeRepaymentListOverdue.size(); j++) {
                                FindOverdueVo findOverdueVo = leaseSchemeRepaymentListOverdue.get(j);
                                if (findMonthVo.getContractId().equals(findOverdueVo.getContractId()) && findMonthVo.getRepaymentId().equals(findOverdueVo.getRepaymentId())) {
                                    smsTextAll = smsTextAll.append(DateUtil.getDateYmChina(findMonthVo.getRepaymentDate()));
                                    total = total.add(findMonthVo.getTotal().add(findOverdueVo.getPrice()));//月租加逾期
                                }
                            }
                        }
                    }
                }
                smsTextAll = smsTextAll.append("的月租还没缴纳");
                smsTextAll = smsTextAll.append("，截至到" + DateUtil.getDateMdChina(DateTime.now().toDate()));
                smsTextAll = smsTextAll.append("，月租加逾期利息合计" + total + "元");
                smsTextAll = smsTextAll.append("，请尽快安排支付。服务热线13610008836");
            }
        }
        Map backMap = Maps.newHashMap();
        backMap.put("smsTextAll", smsTextAll);
        ResultHashMap resultHashMap = new ResultHashMap(false, backMap, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;
    }

    /**
     * 发送逾期通知短信
     *
     * @param paramsMap
     * @return
     */
    public ResultHashMap sendOverdueSms(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<FindMonthVo> leaseSchemeRepaymentListMonth = leaseSchemeRepaymentService.findCurrentMonth(paramsMap, dubboTreaceParames);//融租合同的 当月月供、过期未付款的月供
        List<FindOverdueVo> leaseSchemeRepaymentListOverdue = leaseSchemeRepaymentService.findCurrentOverdue(paramsMap, dubboTreaceParames);//融租合同的 已逾期的月供还款记录/月租滞纳金
        Map<String, Object> contractAccountMap = leaseContractService.findContractAccount(paramsMap, dubboTreaceParames);//融租合同承租人信息
        if (leaseSchemeRepaymentListMonth == null || leaseSchemeRepaymentListMonth.size() <= 0) {
            throw new GMException(GMExceptionConstant.NO_SMS_SEND);
        }

        if (contractAccountMap == null || contractAccountMap.size() <= 0 || contractAccountMap.get("accountPhone") == null) {
            throw new GMException(GMExceptionConstant.NO_SMS_SEND);
        }

        if (leaseSchemeRepaymentListMonth != null) {
            if (leaseSchemeRepaymentListMonth.size() > 0) {
                //组装短信内容
                StringBuffer smsTextAll = null;
                smsTextAll = new StringBuffer("尊敬的客户，你的");
                BigDecimal total = new BigDecimal(0);
                for (int i = 0; i < leaseSchemeRepaymentListMonth.size(); i++) {
                    FindMonthVo findMonthVo = leaseSchemeRepaymentListMonth.get(i);
                    if (leaseSchemeRepaymentListOverdue != null) {
                        if (leaseSchemeRepaymentListOverdue.size() > 0) {
                            for (int j = 0; j < leaseSchemeRepaymentListOverdue.size(); j++) {
                                FindOverdueVo findOverdueVo = leaseSchemeRepaymentListOverdue.get(j);
                                if (findMonthVo.getContractId().equals(findOverdueVo.getContractId()) && findMonthVo.getRepaymentId().equals(findOverdueVo.getRepaymentId())) {
                                    smsTextAll = smsTextAll.append(DateUtil.getDateYmChina(findMonthVo.getRepaymentDate()));
                                    total = total.add(findMonthVo.getTotal().add(findOverdueVo.getPrice()));//月租加逾期
                                }
                            }
                        }
                    }
                }
                smsTextAll = smsTextAll.append("的月租还没缴纳");
                smsTextAll = smsTextAll.append("，截至到" + DateUtil.getDateMdChina(DateTime.now().toDate()));
                smsTextAll = smsTextAll.append("，月租加逾期利息合计" + total + "元");
                smsTextAll = smsTextAll.append("，请尽快安排支付。服务热线13610008836");
                Map<String, Object> sendInfoMap = Maps.newHashMap();
                sendInfoMap.put(contractAccountMap.get("accountPhone").toString(), smsTextAll);
                //组装短信内容

                Map<String, Object> contentMap = null;
                //发送短信
                if (sendInfoMap != null) {
                    if (sendInfoMap.size() > 0) {
                        contentMap = smsService.changeSchemeRepaymentStatusSendSms(sendInfoMap, dubboTreaceParames);
                    }
                }
                //发送短信

                //解析短信报文内容
                Integer status = smsService.dualSmsContent(contentMap, dubboTreaceParames);
                //解析短信报文内容

                LeaseSmsLog leaseSmsLog = new LeaseSmsLog();
                leaseSmsLog.setCreateTime(DateTime.now().toDate());//发送时间
                leaseSmsLog.setCreateBy((Long) paramsMap.get("userId"));
                leaseSmsLog.setName((String) contractAccountMap.get("accountName"));//接收人姓名
                leaseSmsLog.setPhone((String) contractAccountMap.get("accountPhone"));//接收手机号
                leaseSmsLog.setMessage(smsTextAll.toString());//发送内容
                leaseSmsLog.setStatus(status);
                leaseSmsLog.setType(1);
                leaseSmsLog = leaseSmsLogService.insert(leaseSmsLog);

                LeaseAllinpayStatusSms leaseAllinpayStatusSms = new LeaseAllinpayStatusSms();
                leaseAllinpayStatusSms.setCreateTime(DateTime.now().toDate());
                leaseAllinpayStatusSms.setSmsId(leaseSmsLog.getId());
                leaseAllinpayStatusSms.setUpdateTime(DateTime.now().toDate());
                leaseAllinpayStatusSms.setCreateBy((Long) paramsMap.get("userId"));
                leaseAllinpayStatusSms.setType(StatusSmsType.TYPE_2_0);//短信类型：0-0:通联轮询-扣款失败通知 ; 1-0:自动提前扣款提醒(还款日期7天前) ; 1-1:自动提前扣款提醒(还款日期3天前) ; 2-0:手动发送逾期提醒
                leaseAllinpayStatusSmsService.insertSelective(leaseAllinpayStatusSms);
                ///组装 扣款发送短信提醒 数据

            }
        }
        ResultHashMap resultHashMap = new ResultHashMap(true, null, GMExceptionConstant.SMS_SEND_SUCCESS);
        return resultHashMap;
    }


    /**
     * 融租合同 不用系统处理扣款的月租、滞纳金、挂靠费,录入的合同数据如果是不需要系统处理租金扣款，则记录，因为有些合同数据是线下处理了收款
     * 线下缴款登记
     *
     * @param paramsMap
     * @return
     */
    public ResultHashMap repaymentPrivately(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {

        List<Long> list = (List<Long>) paramsMap.get("repaymentId");
        Long userId = (Long) paramsMap.get("userI");
        List<FindByRepaymentDateVo> leaseSchemeRepaymentList = leaseSchemeRepaymentService.findByRepaymentId(list, dubboTreaceParames);//查询某个扣款日的合同还款明细数据/月租、滞纳金、挂靠费

        if (leaseSchemeRepaymentList != null) {
            if (leaseSchemeRepaymentList.size() > 0) {
                ArrayList<LeaseSchemeRepaymentStatus> listRepaymentStatusList = new ArrayList<LeaseSchemeRepaymentStatus>();
                List<LeaseOverdueLog> leaseOverdueLogList = new ArrayList<LeaseOverdueLog>();
                LeaseOverdueLog leaseOverdueLog = null;
                LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus = null;
                for (int i = 0; i < leaseSchemeRepaymentList.size(); i++) {

                    FindByRepaymentDateVo findByRepaymentDateVo = leaseSchemeRepaymentList.get(i);
                    Long repaymentId = findByRepaymentDateVo.getId();
                    Long contractId = findByRepaymentDateVo.getContractId();
                    Long accountId = findByRepaymentDateVo.getLesseeId();

                    //批量更新 支付状态汇总管理
                    paramsMap.put("repaymentId", repaymentId);
                    paramsMap.put("contractId", contractId);
                    paramsMap.put("type", findByRepaymentDateVo.getType());
                    leaseSchemeRepaymentStatus = leaseSchemeRepaymentStatusService.selectByContract(paramsMap, dubboTreaceParames);//查询月供、滞纳金、挂靠费的支付状态
                    //leaseSchemeRepaymentStatus = new LeaseSchemeRepaymentStatus();
                    leaseSchemeRepaymentStatus.setRepaymentId(repaymentId);
                    leaseSchemeRepaymentStatus.setContractId(contractId);
                    leaseSchemeRepaymentStatus.setType(findByRepaymentDateVo.getType());//款项类型 0:月供; 1:挂靠费;  2: 逾期滞纳金; 3:提前还款/剩余本金; 4:尾款/还款到最后一期的尾款; 5:提前还款罚款; 6:尾款/提前还款的尾款
                    leaseSchemeRepaymentStatus.setPaymentResult(PaymentResult.TYPE_2);
                    leaseSchemeRepaymentStatus.setPaymentResultMsg(null);
                    leaseSchemeRepaymentStatus.setPayWay(PayWay.PRIVATELY);//支付方式
                    leaseSchemeRepaymentStatus.setUpdateTime(DateTime.now().toDate());
                    leaseSchemeRepaymentStatus.setUpdateBy(userId);
                    listRepaymentStatusList.add(leaseSchemeRepaymentStatus);
                    //批量更新 支付状态汇总管理

                    //更新 逾期记录 支付状态
                    if (findByRepaymentDateVo.getType() == 2) {
                        leaseOverdueLog = new LeaseOverdueLog();
                        leaseOverdueLog.setRepaymentId(repaymentId);
                        leaseOverdueLog.setContractId(contractId);
                        leaseOverdueLog.setUpdateTime(DateTime.now().toDate());
                        leaseOverdueLog.setPaymentResult(PaymentResult.TYPE_2);
                        leaseOverdueLog.setType(RepaymentStatusType.TYPE_0);
                        leaseOverdueLogList.add(leaseOverdueLog);
                    }
                    //更新 逾期记录 支付状态

                    //插入 代收流水 数据
                    LeaseAllinpayLog leaseAllinpayLog = new LeaseAllinpayLog();
                    leaseAllinpayLog.setRepaymentId(repaymentId);//融租合同-还款计划明细主键id
                    leaseAllinpayLog.setRepaymentStatusId(leaseSchemeRepaymentStatus.getId());
                    leaseAllinpayLog.setContractId(contractId);
                    leaseAllinpayLog.setTotlePrice(findByRepaymentDateVo.getTotal());//合计金额
                    leaseAllinpayLog.setRealPrice(findByRepaymentDateVo.getTotal());
                    leaseAllinpayLog.setSingleOrBatch(0);//单笔或批量/0:单笔; 1:批量
                    leaseAllinpayLog.setPayType(findByRepaymentDateVo.getType());//支付款项类型 0:月供; 1:逾期滞纳金;  2: 挂靠费; 3:提前还款/剩余本金; 4:尾款; 5:提前还款罚款
                    leaseAllinpayLog.setOverdue(findByRepaymentDateVo.getOverdue() == 1 ? true : false);//是否逾期
                    leaseAllinpayLog.setOverdueDay(findByRepaymentDateVo.getOverdueDay());//逾期天数
                    leaseAllinpayLog.setRealOverdueDay(findByRepaymentDateVo.getOverdueDay());//实际逾期天数、扣款的时候改动的实际逾期天数
                    leaseAllinpayLog.setStatus(1);//通联支付状态/0:已提交;1:成功;2:失败
                    leaseAllinpayLog.setPayWay(PayWay.PRIVATELY);//
                    leaseAllinpayLog.setAccountId(accountId);
                    leaseAllinpayLog.setCreateBy(userId);
                    leaseAllinpayLog.setUpdateBy(userId);
                    leaseAllinpayLog.setUpdateTime(DateTime.now().toDate());
                    leaseAllinpayLog.setRemarks("线下缴款登记");
                    leaseAllinpayLog = leaseAllinpayLogService.insertSelective(leaseAllinpayLog);
                    //插入 代收流水 数据

                    //插入 代收状态流水 数据
                    LeaseAllinpayStatusLog leaseAllinpayStatusLog = new LeaseAllinpayStatusLog();
                    leaseAllinpayStatusLog.setAllinpayLogId(leaseAllinpayLog.getId());//代收流水主键id
                    leaseAllinpayStatusLog.setCreateTime(DateTime.now().toDate());//
                    leaseAllinpayStatusLog.setCreateBy(userId);
                    leaseAllinpayStatusLog.setPaymentResult(PaymentResult.TYPE_2);
                    leaseAllinpayStatusLog.setType(AllinpayStatusLogType.TYPE_8);
                    leaseAllinpayStatusLog = leaseAllinpayStatusLogService.insertSelective(leaseAllinpayStatusLog);
                    //插入 代收状态流水 数据

                }

                //批量更新 支付状态汇总管理
                if (listRepaymentStatusList.size() > 0) {
                    leaseSchemeRepaymentStatusService.batchUpdateByContract(listRepaymentStatusList, dubboTreaceParames);
                }
                //批量更新 支付状态汇总管理

                //批量更新 逾期记录支付状态
                if (leaseOverdueLogList.size() > 0) {
                    leaseOverdueLogService.batchUpdateStatus(leaseOverdueLogList, dubboTreaceParames);
                }
                //批量更新 逾期记录支付状态

                //更新 合同状态 0:还款中 1:挂靠中 2:已结束 3：未还款
                if (listRepaymentStatusList.size() > 0) {
                    for (int i = 0; i < listRepaymentStatusList.size(); i++) {
                        LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus1 = listRepaymentStatusList.get(i);
                        //paramsMap.put("id", leaseSchemeRepaymentStatus1.getRepaymentId());
                        paramsMap.put("contractId", leaseSchemeRepaymentStatus1.getContractId());
                        //LeaseSchemeRepayment leaseSchemeRepaymentB = leaseSchemeRepaymentService.selectContract(paramsMap);
                        Boolean contractStatus = leaseSchemeRepaymentStatusService.findByContractidAndStatus(paramsMap, dubboTreaceParames);//合同是否还款完毕
                        LeaseContract leaseContract = leaseContractService.selectByPrimaryKey(leaseSchemeRepaymentStatus1.getContractId());
                        //挂靠中则不用修改状态
                        if (leaseContract.getStatus() != ContractStatus.STATUS_1) {
                            //合同是否未还款完毕
                            if (contractStatus) {
                                leaseContract.setId(leaseSchemeRepaymentStatus1.getContractId());
                                leaseContract.setStatus(ContractStatus.STATUS_2);//合同状态 0:还款中 1:挂靠中 2:已结束 3：未还款
                                leaseContractService.updateByPrimaryKeySelective(leaseContract);
                            } else {
                                leaseContract.setStatus(ContractStatus.STATUS_0);//合同状态 0:还款中 1:挂靠中 2:已结束 3：未还款
                                leaseContractService.updateByPrimaryKeySelective(leaseContract);
                            }
                        }
                    }
                }
                //更新 合同状态 0:还款中 1:挂靠中 2:已结束 3：未还款

            }
        }

        ResultHashMap resultHashMap = new ResultHashMap(false, null, GMExceptionConstant.DUAL_SUCCESS);
        return resultHashMap;
    }

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
    public ResultHashMap advanceSendRepaymentSms(Map<String, String> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<LeaseSchemeRepayment> leaseSchemeRepaymentList = leaseSchemeRepaymentService.advanceSendRepaymentSms(paramsMap, dubboTreaceParames);
        sendAdvanceRepaymentSms(paramsMap, leaseSchemeRepaymentList, dubboTreaceParames);
        ResultHashMap resultHashMap = new ResultHashMap(false, null, GMExceptionConstant.DUAL_SUCCESS);
        return resultHashMap;
    }

    /**
     * 定时器触发
     * 发送提前扣款短信提醒
     * 还款日7天前、3天前向承租人发送
     *
     * @param leaseSchemeRepaymentList
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    public ResultHashMap sendAdvanceRepaymentSms(Map<String, String> paramsMap, List<LeaseSchemeRepayment> leaseSchemeRepaymentList, DubboTreaceParames dubboTreaceParames) throws GMException {

        if (leaseSchemeRepaymentList != null) {
            if (leaseSchemeRepaymentList.size() > 0) {
                //组装短信内容
                for (int i = 0; i < leaseSchemeRepaymentList.size(); i++) {
                    StringBuffer smsTextAll = new StringBuffer("尊敬的客户");
                    ////////
                    LeaseSchemeRepayment leaseSchemeRepayment = leaseSchemeRepaymentList.get(i);
                    smsTextAll = smsTextAll.append("，您的月租" + leaseSchemeRepayment.getTotal() + "元");
                    smsTextAll = smsTextAll.append("，缴费日期为" + DateUtil.getDateYmdChina(leaseSchemeRepayment.getRepaymentDate()));
                    smsTextAll = smsTextAll.append("，请确保账户余额充足。服务热线13610008836");
                    Map<String, Object> sendInfoMap = Maps.newHashMap();
                    sendInfoMap.put(leaseSchemeRepayment.getPhone(), smsTextAll);
                    //组装短信内容
                    Map<String, Object> contentMap = null;
                    //发送短信
                    if (sendInfoMap != null) {
                        if (sendInfoMap.size() > 0) {
                            contentMap = smsService.changeSchemeRepaymentStatusSendSms(sendInfoMap, dubboTreaceParames);
                        }
                    }
                    //发送短信

                    //解析短信报文内容
                    Integer status = smsService.dualSmsContent(contentMap, dubboTreaceParames);
                    //解析短信报文内容

                    Date date = DateTime.now().toDate();
                    LeaseSmsLog leaseSmsLog = new LeaseSmsLog();
                    leaseSmsLog.setCreateTime(date);//发送时间
                    leaseSmsLog.setCreateBy(null);
                    leaseSmsLog.setName(leaseSchemeRepayment.getAccountName());//接收人姓名
                    leaseSmsLog.setPhone(leaseSchemeRepayment.getPhone());//接收手机号
                    leaseSmsLog.setMessage(smsTextAll.toString());//发送内容
                    leaseSmsLog.setStatus(status);
                    leaseSmsLog.setType(1);
                    leaseSmsLog = leaseSmsLogService.insert(leaseSmsLog);

                    LeaseAllinpayStatusSms leaseAllinpayStatusSms = new LeaseAllinpayStatusSms();
                    leaseAllinpayStatusSms.setUsedId(leaseSchemeRepayment.getId());
                    leaseAllinpayStatusSms.setCreateTime(date);
                    leaseAllinpayStatusSms.setSmsId(leaseSmsLog.getId());
                    leaseAllinpayStatusSms.setUpdateTime(date);
                    leaseAllinpayStatusSms.setCreateBy(null);
                    leaseAllinpayStatusSms.setType(paramsMap.get("type").substring(1, paramsMap.get("type").length() - 1));//短信类型：0-0:通联轮询-扣款失败通知 ; 1-0:自动提前扣款提醒(还款日期7天前) ; 1-1:自动提前扣款提醒(还款日期3天前) ; 2-0:手动发送逾期提醒
                    leaseAllinpayStatusSmsService.insertSelective(leaseAllinpayStatusSms);
                    ////////
                }
                ///组装 扣款发送短信提醒 数据
            }
        }
        ResultHashMap resultHashMap = new ResultHashMap(true, null, GMExceptionConstant.SMS_SEND_SUCCESS);
        return resultHashMap;
    }


    /**
     * 批量协议支付
     * 通联支付拆单
     *
     * @param transSplitBody
     * @return
     * @throws GMException
     */
    public ResultHashMap dualBatchPostlendingPaymentSplit(TransSplitBody transSplitBody, DubboTreaceParames dubboTreaceParames) throws GMException {
        Map<String, Object> paramsMap = Maps.newHashMap();
        List<Long> allinpaySplitIds = transSplitBody.getAllinpaySplitIds();//
        if (allinpaySplitIds == null || allinpaySplitIds.size() <= 0) {
            throw new GMException(GMExceptionConstant.NO_NEED_TO_ALLINPAY);
        }

        ////////////////////////////处理需要扣款的数据////////////////////////////

        /////查询需要扣款的数据/////
        paramsMap.put("allinpaySplitIds", allinpaySplitIds);
        paramsMap.put("payWay", 4);//扣款方式未代扣
        List<BatchPostlendingPaymentSplitVo> batchPostlendingPaymentSplitList = leaseAllinpaySplitService.findBatchSplitDual(paramsMap, dubboTreaceParames);//批量协议支付 通联支付拆单 查询需要处理的数据
        paramsMap.put("payWay", 9);//扣款方式未协议支付
        List<BatchPostlendingPaymentSplitVo> batchPostlendingPaymentSplitQuickList = leaseAllinpaySplitService.findBatchSplitDual(paramsMap, dubboTreaceParames);//批量协议支付 通联支付拆单 查询需要处理的数据
        /////查询需要扣款的数据/////

        ////////////////////////////处理需要扣款的数据////////////////////////////

        //检测是否有数据
        checkBatchSplit(batchPostlendingPaymentSplitList, batchPostlendingPaymentSplitQuickList);

        //检测是否有数据
        ////////////////////////////处理通联支付////////////////////////////

        String batchNumber = "PK" + String.valueOf(System.currentTimeMillis());//批次号/批扣流水
        if (batchPostlendingPaymentSplitList != null && batchPostlendingPaymentSplitList.size() > 0) {
            ////////通联代扣////////
            TransSplitBody transSplitBody_1 = transSplitBody;
            transSplitBody_1.setBatchNumber(batchNumber);
            List<BatchPostlendingPaymentSplitVo> needList = batchTransBodyInstallSplit(transSplitBody_1, batchPostlendingPaymentSplitList);//组装扣款数据
            //context.deal(context, JDBCTpye.JDBC_INSERT + "BatchAllinpaySplit", transSplitBody_1, needList, dubboTreaceParames);
            ////////通联代扣////////
        }
        if (batchPostlendingPaymentSplitQuickList != null && batchPostlendingPaymentSplitQuickList.size() > 0) {
            ////////通联协议支付////////
            TransSplitBody transSplitBody_2 = transSplitBody;
            transSplitBody_2.setBatchNumber(batchNumber);
            List<BatchPostlendingPaymentSplitVo> needList = batchTransBodyInstallSplit(transSplitBody_2, batchPostlendingPaymentSplitQuickList);//组装扣款数据
            context.deal(context, JDBCTpye.JDBC_INSERT + "SplitBatchAllinpayQuickStrategy", transSplitBody_2, needList, null, dubboTreaceParames);
            ////////通联协议支付////////
        }

        ////////////////////////////处理通联支付////////////////////////////


        ResultHashMap resultHashMap = new ResultHashMap(false, null, GMExceptionConstant.ALLINPAY_SEND_SUCCESS);
        return resultHashMap;
    }

    /**
     * 通联支付拆单 单笔协议支付
     *
     * @param transSplitBody
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    @Override
    public ResultHashMap dualSinglePostlendingPaymentSplit(TransSplitBody transSplitBody, DubboTreaceParames dubboTreaceParames) throws GMException {
        Map<String, Object> paramsMap = Maps.newHashMap();
        BatchPostlendingPaymentSplitVo batchPostlendingPaymentSplitVo = leaseAllinpaySplitService.selectDualSinglePostlendingPaymentSplit(transSplitBody.getAllinpaySplitId());
        ResultHashMap resultHashMap = null;
        resultHashMap = (ResultHashMap) context.deal(context, JDBCTpye.JDBC_INSERT + "SplitAllinpayQuickStrategy", transSplitBody, batchPostlendingPaymentSplitVo, null, dubboTreaceParames);//通联协议支付、快捷支付
        return resultHashMap;
    }

    /**
     * 通联支付拆单
     * 单笔线下支付登记
     *
     * @param paramsMap
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    public ResultHashMap repaymentPrivatelySplit(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {

        Long userId = (Long) paramsMap.get("userI");
        List<BatchPostlendingPaymentSplitVo> batchPostlendingPaymentSplitVoList = leaseAllinpaySplitService.findBatchSplitDual(paramsMap, dubboTreaceParames);//

        if (batchPostlendingPaymentSplitVoList != null) {
            if (batchPostlendingPaymentSplitVoList.size() > 0) {
                ArrayList<LeaseAllinpaySplit> leaseAllinpaySplitList = new ArrayList<LeaseAllinpaySplit>();
                List<LeaseOverdueLog> leaseOverdueLogList = new ArrayList<LeaseOverdueLog>();
                LeaseOverdueLog leaseOverdueLog = null;
                LeaseAllinpaySplit leaseAllinpaySplit = null;
                LeaseAllinpaySplitLog leaseAllinpaySplitLog = null;
                LeaseAllinpaySplitStatusLog leaseAllinpaySplitStatusLog = null;
                for (int i = 0; i < batchPostlendingPaymentSplitVoList.size(); i++) {
                    leaseAllinpaySplit = new LeaseAllinpaySplit();
                    BatchPostlendingPaymentSplitVo batchPostlendingPaymentSplitVo = batchPostlendingPaymentSplitVoList.get(i);
                    leaseAllinpaySplit.setId(batchPostlendingPaymentSplitVo.getId());
                    leaseAllinpaySplit.setPaymentResult(PaymentResult.TYPE_2);
                    leaseAllinpaySplit.setPaymentResultMsg("");
                    leaseAllinpaySplit.setPayWay(PayWay.PRIVATELY);//支付方式
                    leaseAllinpaySplit.setUpdateTime(DateTime.now().toDate());
                    leaseAllinpaySplit.setUpdateBy(userId);
                    leaseAllinpaySplitList.add(leaseAllinpaySplit);
                    //批量更新 支付状态汇总管理

                    //插入 代收流水 数据
                    leaseAllinpaySplitLog = new LeaseAllinpaySplitLog();
                    leaseAllinpaySplitLog.setRepaymentId(batchPostlendingPaymentSplitVo.getRepaymentId());//融租合同-还款计划明细主键id
                    leaseAllinpaySplitLog.setContractId(batchPostlendingPaymentSplitVo.getContractId());
                    leaseAllinpaySplitLog.setAllinpaySplitId(batchPostlendingPaymentSplitVo.getId());
                    leaseAllinpaySplitLog.setTotlePrice(batchPostlendingPaymentSplitVo.getTotlePrice());//合计金额
                    leaseAllinpaySplitLog.setSingleOrBatch(0);//单笔或批量/0:单笔; 1:批量
                    leaseAllinpaySplitLog.setStatus(1);//通联支付状态/0:已提交;1:成功;2:失败
                    leaseAllinpaySplitLog.setPayWay(PayWay.PRIVATELY);//
                    leaseAllinpaySplitLog.setCreateBy((Long) paramsMap.get("userId"));
                    leaseAllinpaySplitLog.setUpdateBy((Long) paramsMap.get("userId"));
                    leaseAllinpaySplitLog.setUpdateTime(DateTime.now().toDate());
                    leaseAllinpaySplitLog.setRemarks("线下缴款登记");
                    leaseAllinpaySplitLog = leaseAllinpaySplitLogService.insertSelective(leaseAllinpaySplitLog);
                    //插入 代收流水 数据

                    //插入 代收状态流水 数据
                    leaseAllinpaySplitStatusLog = new LeaseAllinpaySplitStatusLog();
                    leaseAllinpaySplitStatusLog.setAllinpaySplitLogId(leaseAllinpaySplitLog.getId());//代收流水主键id
                    leaseAllinpaySplitStatusLog.setCreateTime(DateTime.now().toDate());//
                    leaseAllinpaySplitStatusLog.setCreateBy(userId);
                    leaseAllinpaySplitStatusLog.setPaymentResult(PaymentResult.TYPE_2);
                    leaseAllinpaySplitStatusLog.setType(AllinpayStatusLogType.TYPE_8);
                    leaseAllinpaySplitStatusLog = leaseAllinpaySplitStatusLogService.insertSelective(leaseAllinpaySplitStatusLog);
                    //插入 代收状态流水 数据

                }

                //批量更新 支付状态汇总管理
                if (leaseAllinpaySplitList.size() > 0) {
                    leaseAllinpaySplitService.batchUpdateByContract(leaseAllinpaySplitList, dubboTreaceParames);
                }
                //批量更新 支付状态汇总管理

            }
        }

        ResultHashMap resultHashMap = new ResultHashMap(false, null, GMExceptionConstant.DUAL_SUCCESS);
        return resultHashMap;
    }

    /**
     * 需要轮询通联超额拆分 的 交易流水/状态为扣款中
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public ResultHashMap findQueryTradeNewSplit(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<FindQueryTradeNewSplitVo> leaseAllinpaySplitList = leaseAllinpaySplitService.findQueryTradeNewSplit(paramsMap, dubboTreaceParames);
        ResultHashMap resultHashMap = new ResultHashMap(false, leaseAllinpaySplitList, GMExceptionConstant.DATA_LOAD_SUCCESS);
        return resultHashMap;
    }

    /**
     * 根据 通联 轮询回来的处理结果
     * 更新 代收流水 状态 / 更新 超额拆分交易明细 状态
     *
     * @param transSplitBody
     * @return
     * @throws GMException
     */
    public ResultHashMap changeSchemeRepaymentStatusSplit(TransSplitBody transSplitBody, DubboTreaceParames dubboTreaceParames) throws GMException {
        Map<String, Object> paramsMap = Maps.newHashMap();
        context.deal(context, JDBCTpye.JDBC_UPDATE + "SplitUpdateStrategy", transSplitBody, null, null, dubboTreaceParames);
        ResultHashMap resultHashMap = new ResultHashMap(false, null, GMExceptionConstant.SUCCESS_UPDATE);
        return resultHashMap;

    }

    public List<LeaseAllinpayBatch> allinpayLogBatchNoPage(Map<String, Object> paramsMap) {
        List<LeaseAllinpayBatch> leaseAllinpayBatchPage = leaseAllinpayBatchService.findNoPage(paramsMap);
        return leaseAllinpayBatchPage;
    }

    public List<ContractAllinpayLogVo> exportAllinpayLog(Map<String, Object> paramsMap) {
        List<ContractAllinpayLogVo> contractAllinpayLogVos = leaseAllinpayLogService.exportAllinpayLog(paramsMap);
        return contractAllinpayLogVos;
    }

}
