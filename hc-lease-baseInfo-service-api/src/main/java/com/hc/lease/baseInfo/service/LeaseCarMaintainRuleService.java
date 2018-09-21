package com.hc.lease.baseInfo.service;

import com.hc.lease.baseInfo.model.LeaseCarMaintainRule;
import com.hc.lease.baseInfo.model.LeaseCarSeries;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 保养规则Service
 *
 * @author Tong
 * @version 2017-04-14
 */

public interface LeaseCarMaintainRuleService extends BaseService<LeaseCarMaintainRule> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseCarMaintainRule> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
