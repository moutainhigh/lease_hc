package com.hc.lease.order.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseContract;

import java.util.List;
import java.util.Map;

public interface LeaseContractMapper extends BaseDao<LeaseContract> {

    List<LeaseContract> findPostLending(Map<String, Object> paramsMap);

    List<LeaseContract> findByParams(Map params);

    Map<String, Object> allinpayLogStatistics(Map<String, Object> paramsMap);

    /**
     * 月供管理统计 成功
     * @param paramsMap
     * @return
     */
    Integer postLendingStatisticsSuccess(Map<String, Object> paramsMap);

    /**
     * 月供管理统计 成功
     * @param paramsMap
     * @return
     */
    Integer postLendingStatisticsFail(Map<String, Object> paramsMap);

    /**
     * 月供管理统计 成功
     * @param paramsMap
     * @return
     */
    Integer postLendingStatisticsOverdue(Map<String, Object> paramsMap);

    /**
     * 查看融租合同
     * @param paramsMap
     * @return
     */
    LeaseContract selectOrderInfo(Map<String, Object> paramsMap) throws GMException;
}