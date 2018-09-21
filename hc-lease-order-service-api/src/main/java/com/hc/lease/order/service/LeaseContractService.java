package com.hc.lease.order.service;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseContract;

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
     * 月供管理合同列表
     *
     * @param paramsMap
     * @return
     */
    PageInfo<LeaseContract> findPostLending(int pageNum, int pageSize, Map<String, Object> paramsMap);


    List<LeaseContract> findByParams(Map params);

    /**
     * 支付历史统计
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> allinpayLogStatistics(Map<String, Object> paramsMap);

    /**
     * 月供管理统计 成功
     *
     * @param paramsMap
     * @return
     */
    Integer postLendingStatisticsSuccess(Map<String, Object> paramsMap);

    /**
     * 月供管理统计 失败
     * @param paramsMap
     * @return
     */
    Integer postLendingStatisticsFail(Map<String, Object> paramsMap);

    /**
     * 月供管理统计 逾期
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
