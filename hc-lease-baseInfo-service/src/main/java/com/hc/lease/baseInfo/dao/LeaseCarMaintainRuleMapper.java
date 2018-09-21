package com.hc.lease.baseInfo.dao;

import com.hc.lease.baseInfo.model.LeaseCarMaintainRule;
import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 保养规则
 */
public interface LeaseCarMaintainRuleMapper extends BaseDao<LeaseCarMaintainRule> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseCarMaintainRule> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}