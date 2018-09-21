package com.hc.lease.postlending.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.model.LeaseOverdueLog;

import java.util.List;
import java.util.Map;

/**
 * 逾期记录
 */
public interface LeaseOverdueLogMapper extends BaseDao<LeaseOverdueLog> {

    /**
     * @param paramsMap
     * @return
     */
    LeaseOverdueLog selectByContractIdRepaymentId(Map<String, Object> paramsMap);

    /**
     * 批量更新
     *
     * @param leaseOverdueLogList
     * @return
     */
    int updateBatch(List<LeaseOverdueLog> leaseOverdueLogList);

    /**
     * 批量新增
     *
     * @param leaseOverdueLogList
     * @return
     */
    int insertBatch(List<LeaseOverdueLog> leaseOverdueLogList);

    /**
     * 更新支付状态
     *
     * @param leaseOverdueLog
     * @return
     */
    int updateStatus(LeaseOverdueLog leaseOverdueLog);

    /**
     * 批量更新支付状态
     *
     * @param leaseOverdueLogList
     * @return
     */
    int batchUpdateStatus(List<LeaseOverdueLog> leaseOverdueLogList);

    /**
     * 合同修改同时修改 还款计划主键id
     *
     * @return
     */
    int updateRepaymentId(Map<String, Object> paramsMap) throws GMException;

}