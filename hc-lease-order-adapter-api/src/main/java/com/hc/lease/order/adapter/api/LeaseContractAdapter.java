package com.hc.lease.order.adapter.api;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.excel.poi.vo.MonthlyRentReadInfo;
import com.hc.lease.common.core.excel.poi.vo.MonthlyRentTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.model.LeaseContract;
import com.hc.lease.order.vo.*;

import java.util.List;
import java.util.Map;

/**
 * 融租合同Adapter
 *
 * @author Qiang
 * @version 2017-05-23
 */

public interface LeaseContractAdapter extends BaseAdapter<LeaseContract> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 列表页面 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParamesListPage(Map<String, Object> paramsMap) throws GMException;

    ResultHashMap insertSelectives(LeaseContractOrder leaseContractOrder) throws GMException;

    int updateByPrimaryKeySelectives(LeaseContractOrder leaseContractOrder) throws GMException;

    /**
     * 月供管理合同列表
     *
     * @param paramsMap
     * @return
     */
    PageInfo<LeasePostLendingVo> findPostLending(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);


    LeaseContract selectOrderInfo(Map<String, Object> paramsMap) throws GMException;


    Map<String, Object> exportContract(Map<String, Object> paramsMap) throws GMException;

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

    Boolean checkOrderAccount(long orderAccountId);

    MonthlyRentReadInfo updateMonthlyRent(List<MonthlyRentTemplate> monthlyRentTemplates, UserSession userSession) throws GMException;


    /**
     * 合同所有数据
     *
     * @param paramsMap
     * @return
     */
    List<FindAllContractVo> selectAll(Map<String, Object> paramsMap) throws GMException;

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
     * 提交 改期数
     *
     * @param updateContractPeriodVo
     * @param userSession
     * @return
     * @throws GMException
     */
    int updateContractPeriod(ContractManagerVo updateContractPeriodVo, UserSession userSession) throws GMException;

    /**
     * 提交 转租
     *
     * @param contractManagerVo
     * @param userSession
     * @return
     * @throws GMException
     */
    int transferContract(ContractManagerVo contractManagerVo, UserSession userSession) throws GMException;

    /**
     * 提交 续期
     *
     * @param contractManagerVo
     * @param userSession
     * @return
     * @throws GMException
     */
    int continueContract(ContractManagerVo contractManagerVo, UserSession userSession) throws GMException;

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
