package com.hc.lease.baseInfo.adapter.api;

import com.hc.lease.baseInfo.model.LeaseDealer;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;

import java.util.Map;

/**
 * 经销商Adapter
 *
 * @author Tong
 * @version 2017-04-17
 */

public interface LeaseDealerAdapter extends BaseAdapter<LeaseDealer> {
    /**
     * 添加或者修改 需要的初始化参数
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    ResultHashMap insertSelective(LeaseDealer leaseDealer, UserSession userSession)throws GMException;

    int updateByPrimaryKeySelective(LeaseDealer leaseDealer, UserSession userSession)throws GMException;

    int disableByPrimaryKey(Map<String, Object> params)throws GMException;
}
