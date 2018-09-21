package com.hc.lease.postlending.service.api;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.model.LeaseOverdueLog;

import java.util.List;
import java.util.Map;

/**
 * 逾期记录Service
 *
 * @author Tong
 * @version 2017-06-09
 */

public interface LeaseOverdueLogService extends BaseService<LeaseOverdueLog> {

    /**
     * @param paramsMap
     * @return
     */
    LeaseOverdueLog selectByContractIdRepaymentId(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 批量更新
     *
     * @param leaseOverdueLogList
     * @return
     */
    int updateBatch(List<LeaseOverdueLog> leaseOverdueLogList, DubboTreaceParames dubboTreaceParames);

    /**
     * 批量新增
     *
     * @param leaseOverdueLogList
     * @return
     */
    int insertBatch(List<LeaseOverdueLog> leaseOverdueLogList, DubboTreaceParames dubboTreaceParames);

    /**
     * 更新支付状态
     *
     * @param leaseOverdueLog
     * @return
     */
    int updateStatus(LeaseOverdueLog leaseOverdueLog, DubboTreaceParames dubboTreaceParames);

    /**
     * 批量更新支付状态
     *
     * @param leaseOverdueLogList
     * @return
     */
    int batchUpdateStatus(List<LeaseOverdueLog> leaseOverdueLogList, DubboTreaceParames dubboTreaceParames);

    /**
     * 合同修改同时修改 还款计划主键id
     *
     * @return
     */
    int updateRepaymentId(Map<String, Object> paramsMap) throws GMException;

}
