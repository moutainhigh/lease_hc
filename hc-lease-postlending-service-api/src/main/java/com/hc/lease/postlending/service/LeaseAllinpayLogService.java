package com.hc.lease.postlending.service;

import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.model.LeaseAllinpayLog;

import java.util.List;
import java.util.Map;

/**
* 通联代收流水Service
* @author Tong
* @version 2017-06-09
*/

public interface LeaseAllinpayLogService extends BaseService<LeaseAllinpayLog> {

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
