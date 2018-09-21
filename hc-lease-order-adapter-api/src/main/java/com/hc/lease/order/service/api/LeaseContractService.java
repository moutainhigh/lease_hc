package com.hc.lease.order.service.api;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseContract;
import com.hc.lease.order.vo.*;

import java.util.List;
import java.util.Map;

/**
 * 融租合同Service
 *
 * @author Qiang
 * @version 2017-05-23
 */

public interface LeaseContractService extends BaseService<LeaseContract> {

    /**
     * 月供管理列表 / 租金支付计划表 / 还款历史
     *
     * @param paramsMap
     * @return
     */
    PageInfo<LeasePostLendingVo> findPostLending(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 逾期短信通知列表
     *
     * @param paramsMap
     * @return
     */
    PageInfo<LeasePostLendingVo> findPostLendingOverdueSms(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    List<LeaseContract> findByParams(Map params);

    /**
     * 查看融租合同
     *
     * @param paramsMap
     * @return
     */
    LeaseContract selectOrderInfo(Map<String, Object> paramsMap) throws GMException;

    /**
     * 合同的尾付
     *
     * @param paramsMap
     * @return
     */
    FindBalanceVo findBalancePayment(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 融租合同承租人信息
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> findContractAccount(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 初始化单笔扣款页面的参数/合同信息
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> payViewParamesContractInfo(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 融资租赁标的物
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> findContractInfo(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    LeaseContract selectBySchemeOrderId(Long schemeOrderId);

    /**
     * 各种款项的支付结果统计 / 如：单人综合扣款表头的统计
     *
     * @param paramsMap
     * @return
     */
    List<Map<String, Object>> selectAllContractStatusDetails(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 各种支付方式统计 / 如：单人综合扣款表头的统计
     *
     * @param paramsMap
     * @return
     */
    List<Map<String, Object>> selectAllContractPayWayDetails(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 所有合同的 款项 对应的 支付结果 状态 / 如：逾期短信通知
     *
     * @param paramsMap
     * @return
     */
    List<Map<String, Object>> selectAllContractStatusDetailsOverdueSms(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 分公司统计
     *
     * @param paramsMap
     * @return
     */
    List<Map<String, Object>> findAllContractStatisticsByCity(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 根据分公司统计所有合同 / 如：逾期短信通知
     *
     * @param paramsMap
     * @return
     */
    List<Map<String, Object>> findAllContractStatisticsByCityOverdueSms(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 合同状态统计
     *
     * @param paramsMap
     * @return
     */
    List<Map<String, Object>> findAllContractStatisticsByStatus(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 根据状态统计所有合同 / 如：逾期短信通知
     *
     * @param paramsMap
     * @return
     */
    List<Map<String, Object>> findAllContractStatisticsByStatusOverdueSms(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    LeaseContract findByCompleteContractNumber(String contractNumber);

    /**
     * 合同所有数据
     *
     * @param paramsMap
     * @return
     */
    List<FindAllContractVo> selectAll(Map<String, Object> paramsMap) throws GMException;

    void updateSaleChannelId(Map<String, Object> maps);

    /**
     * 收车、丢失、报废 新增的页面 合同数据列表
     *
     * @param paramsMap
     * @return
     */
    List<CarManagerFindContractVo> carManagerFindContract(Map<String, Object> paramsMap) throws GMException;

    /**
     * 贷后车辆管理-跟进/处理 合同数据
     *
     * @param paramsMap
     * @return
     */
    CarManagerDealFindContractVo carManagerDealFindContract(Map<String, Object> paramsMap) throws GMException;

    /**
     * 修改 车辆贷后的 处理方案为断供， 则把合同状态改为断供
     *
     * @param leaseContract
     * @return
     * @throws GMException
     */
    int updateDealStatus(LeaseContract leaseContract) throws GMException;

    /**
     * 修改 车辆贷后的 处理方案， 还原合同状态
     *
     * @param leaseContract
     * @return
     * @throws GMException
     */
    int updateDealStatusAndStatusBack(LeaseContract leaseContract) throws GMException;

    /**
     * 贷后直租合同 数据列表/改期数
     *
     * @param paramsMap
     * @return
     */
    PageInfo contractManagerFindContractUpdatePeriod(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 贷后直租合同 数据列表/结束处置
     *
     * @param paramsMap
     * @return
     */
    PageInfo contractManagerFindContractDealEnd(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 贷前直租合同-次新车处置 合同数据列表 / 续期
     *
     * @param paramsMap
     * @return
     */
    PageInfo contractDQZZManagerFindContractContinue(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 贷前直租合同-次新车处置 合同数据列表 / 转租
     *
     * @param paramsMap
     * @return
     */
    PageInfo contractDQZZManagerFindContractTransfer(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;


    /**
     * 还款历史 查看里面的统计部分
     *
     * @param paramsMap
     * @return
     */
    FindAllinpayLogStatisticsVo findAllinpayLogStatistics(Map<String, Object> paramsMap) throws GMException;

}
