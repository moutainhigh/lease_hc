package com.hc.lease.baseInfo.service.api;

import com.hc.lease.baseInfo.model.LeaseRule;
import com.hc.lease.common.core.dao.BaseService;

/**
 * 规则表Service
 *
 * @author Tong
 * @version 2017-04-19
 */

public interface LeaseRuleService extends BaseService<LeaseRule> {
    /**
     * 根据规则类型查询信息
     * @param ruleType 规则类型
     */
    LeaseRule selectEntityByType(String ruleType);
}
