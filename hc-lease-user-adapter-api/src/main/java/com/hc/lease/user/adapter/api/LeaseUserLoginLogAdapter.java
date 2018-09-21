package com.hc.lease.user.adapter.api;

import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.user.model.LeaseUserLoginLog;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;

import java.util.Map;

/**
 * 后台用户登录日志Adapter
 *
 * @author Tong
 * @version 2017-12-18
 */

public interface LeaseUserLoginLogAdapter extends BaseAdapter<LeaseUserLoginLog> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 根据session修改
     *
     * @param leaseUserLoginLog
     * @return
     */
    int updateBySessionCurrent(LeaseUserLoginLog leaseUserLoginLog);

    /**
     * @param leaseUserLoginLog
     * @return
     */
    ResultHashMap addSelective(LeaseUserLoginLog leaseUserLoginLog) throws GMException;

}
