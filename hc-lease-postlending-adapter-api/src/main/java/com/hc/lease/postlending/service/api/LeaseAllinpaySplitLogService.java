package com.hc.lease.postlending.service.api;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.model.LeaseAllinpaySplitLog;

import java.util.Map;

/**
 * 通联支付超额拆分交易明细 支付流水Service
 *
 * @author Tong
 * @version 2018-06-19
 */

public interface LeaseAllinpaySplitLogService extends BaseService<LeaseAllinpaySplitLog> {

    /**
     * @param paramsMap
     * @return
     */
    LeaseAllinpaySplitLog findByReqSn(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 合同修改同时修改 拆单的还款计划主键id,
     *
     * @return
     */
    int updateRepaymentId(Map<String, Object> paramsMap) throws GMException;

}
