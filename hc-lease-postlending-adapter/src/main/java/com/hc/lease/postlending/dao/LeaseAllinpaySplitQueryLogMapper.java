package com.hc.lease.postlending.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.model.LeaseAllinpaySplitQueryLog;

import java.util.List;
import java.util.Map;

/**
 * 通联支付超额拆分交易明细 通联轮询流水
 */
public interface LeaseAllinpaySplitQueryLogMapper extends BaseDao<LeaseAllinpaySplitQueryLog> {

    /**
     * @param paramsMap
     * @return
     */
    List<LeaseAllinpaySplitQueryLog> selectByAllinpaySplitLogId(Map<String, Object> paramsMap);

    /**
     * 合同修改同时修改 拆单的还款计划主键id,
     *
     * @return
     */
    int updateRepaymentId(Map<String, Object> paramsMap) throws GMException;

}