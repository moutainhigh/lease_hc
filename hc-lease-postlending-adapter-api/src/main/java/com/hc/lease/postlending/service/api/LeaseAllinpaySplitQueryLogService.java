package com.hc.lease.postlending.service.api;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.model.LeaseAllinpaySplitQueryLog;

import java.util.List;
import java.util.Map;

/**
 * 通联支付超额拆分交易明细 通联轮询流水Service
 *
 * @author Tong
 * @version 2018-06-19
 */

public interface LeaseAllinpaySplitQueryLogService extends BaseService<LeaseAllinpaySplitQueryLog> {

    /**
     * @param paramsMap
     * @return
     */
    List<LeaseAllinpaySplitQueryLog> selectByAllinpaySplitLogId(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 合同修改同时修改 拆单的还款计划主键id,
     *
     * @return
     */
    int updateRepaymentId(Map<String, Object> paramsMap) throws GMException;

}
