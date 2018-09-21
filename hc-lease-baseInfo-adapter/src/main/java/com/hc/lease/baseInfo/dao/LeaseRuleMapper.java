package com.hc.lease.baseInfo.dao;

import com.hc.lease.baseInfo.model.LeaseRule;
import com.hc.lease.common.core.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

public interface LeaseRuleMapper extends BaseDao<LeaseRule> {
    /**
     * 根据规则类型查询信息
     * @param ruleType 规则类型
     */
    LeaseRule selectEntityByType(@Param("ruleType") String ruleType);
}