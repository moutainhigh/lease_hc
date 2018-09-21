package com.hc.lease.postlending.service.api;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.postlending.model.LeaseAllinpayStatusLog;

import java.util.List;
import java.util.Map;

/**
 * 代收状态流水Service
 *
 * @author Tong
 * @version 2017-06-15
 */

public interface LeaseAllinpayStatusLogService extends BaseService<LeaseAllinpayStatusLog> {

    List<LeaseAllinpayStatusLog> selectByAllinpayLogId(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

}
