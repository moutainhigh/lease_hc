package com.hc.lease.order.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.order.model.LeaseContractCarCallback;
import com.hc.lease.order.vo.FindByPrimaryKeyVo;

import java.util.Map;

public interface LeaseContractCarCallbackMapper extends BaseDao<LeaseContractCarCallback> {

    FindByPrimaryKeyVo findByPrimaryKey(Long id);

    int findMaxDualNumber(Map<String, Object> paramsMap);

}