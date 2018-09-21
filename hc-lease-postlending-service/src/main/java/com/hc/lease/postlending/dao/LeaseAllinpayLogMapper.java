package com.hc.lease.postlending.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.model.LeaseAllinpayLog;

import java.util.List;
import java.util.Map;

/**
 * 通联代收流水
 */
public interface LeaseAllinpayLogMapper extends BaseDao<LeaseAllinpayLog> {

    int updateByReqSn(LeaseAllinpayLog leaseAllinpayLog) throws GMException;

    LeaseAllinpayLog selectByReqSn(Map<String, Object> paramsMap) throws GMException;

    /**
     * 需要轮询通联 的 交易流水
     *
     * @param paramsMap
     * @return
     */
    List<LeaseAllinpayLog> findQueryTradeNew(Map<String, Object> paramsMap);

}