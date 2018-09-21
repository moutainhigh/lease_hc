package com.hc.lease.postlending.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.model.LeaseAllinpaySplitLog;

import java.util.Map;

/**
 * 通联支付超额拆分交易明细 支付流水
 */
public interface LeaseAllinpaySplitLogMapper extends BaseDao<LeaseAllinpaySplitLog> {

    /**
     * @param paramsMap
     * @return
     */
    LeaseAllinpaySplitLog findByReqSn(Map<String, Object> paramsMap);

    /**
     * 合同修改同时修改 拆单的还款计划主键id,
     *
     * @return
     */
    int updateRepaymentId(Map<String, Object> paramsMap) throws GMException;

}