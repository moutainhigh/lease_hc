package com.hc.lease.baseInfo.adapter.api;

import com.hc.lease.baseInfo.model.LeaseCarMaintainRule;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;

import java.util.Map;

/**
 * 保养规则Adapter
 *
 * @author Tong
 * @version 2017-04-17
 */

public interface LeaseCarMaintainRuleAdapter extends BaseAdapter<LeaseCarMaintainRule> {
    /**
     * 添加或者修改 需要的初始化参数
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    ResultHashMap insertSelective(LeaseCarMaintainRule leaseCarMaintainRule, UserSession userSession) throws GMException;

    int updateByPrimaryKeySelective(LeaseCarMaintainRule leaseCarMaintainRule, UserSession userSession)throws GMException;

    int disableByPrimaryKey(Map<String, Object> params)throws GMException;
}
