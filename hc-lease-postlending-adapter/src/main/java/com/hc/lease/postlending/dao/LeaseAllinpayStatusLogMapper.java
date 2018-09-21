package com.hc.lease.postlending.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.postlending.model.LeaseAllinpayStatusLog;

import java.util.List;
import java.util.Map;

/**
 * 代收状态流水
 */
public interface LeaseAllinpayStatusLogMapper extends BaseDao<LeaseAllinpayStatusLog> {

    List<LeaseAllinpayStatusLog> selectByAllinpayLogId(Map<String, Object> paramsMap);

}