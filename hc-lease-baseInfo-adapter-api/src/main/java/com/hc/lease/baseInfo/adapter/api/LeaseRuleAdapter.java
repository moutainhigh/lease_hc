package com.hc.lease.baseInfo.adapter.api;

import com.hc.lease.baseInfo.model.LeaseRule;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;

import java.util.Map;

/**
 * 规则表Adapter
 *
 * @author Tong
 * @version 2017-04-19
 */

public interface LeaseRuleAdapter extends BaseAdapter<LeaseRule> {
    /**
     * 添加或者修改 需要的初始化参数
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;
    /**
     * 根据规则类型查询信息
     * @param ruleType 规则类型
     */
    LeaseRule selectEntityByType(String ruleType);
}
