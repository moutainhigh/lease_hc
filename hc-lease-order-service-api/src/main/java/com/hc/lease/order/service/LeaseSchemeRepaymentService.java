package com.hc.lease.order.service;

import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseSchemeRepayment;

import java.util.List;
import java.util.Map;

/**
 * 融租合同-还款Service
 *
 * @author Qiang
 * @version 2017-05-23
 */

public interface LeaseSchemeRepaymentService extends BaseService<LeaseSchemeRepayment> {

    void deleteByContractId(Long id);

    List<LeaseSchemeRepayment> selectByIsSendPayment(Integer isSendPayment);

    /**
     * 月供的还款记录
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<LeaseSchemeRepayment> findIsMonthLog(Map<String, Object> paramsMap) throws GMException;

    /**
     * 已逾期的还款记录
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<LeaseSchemeRepayment> findIsOverdueLog(Map<String, Object> paramsMap) throws GMException;

    /**
     * 批量更新
     * @param leaseSchemeRepaymentList
     */
    void batchUpdate(List<LeaseSchemeRepayment> leaseSchemeRepaymentList);

    /**
     * 检测是否是月供
     *
     * @param paramsMap
     * @return
     */
    LeaseSchemeRepayment checkIsMonth(Map<String, Object> paramsMap);

    /**
     * 检测是否是逾期
     *
     * @param paramsMap
     * @return
     */
    LeaseSchemeRepayment checkIsOverdue(Map<String, Object> paramsMap);

    /**
     *
     * @param paramsMap
     * @return
     */
    LeaseSchemeRepayment selectContract(Map<String, Object> paramsMap);

    /**
     * 查询所有月供 批量扣款明细列表
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<Map<String, Object>> findAllMonth(Map<String, Object> paramsMap) throws GMException;

    /**
     * 查询所有月供 批量扣款 统计
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> findAllMonthStatistics(Map<String, Object> paramsMap);

    /**
     * 查询所有月供 批量扣款 统计城市
     *
     * @param paramsMap
     * @return
     */
    List<LeaseSchemeRepayment> findAllMonthStatisticsByCity(Map<String, Object> paramsMap);

    /**
     * 查出 批量扣款 的数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<LeaseSchemeRepayment> batchCheckIsMonth(Map<String, Object> paramsMap) throws GMException;

}
