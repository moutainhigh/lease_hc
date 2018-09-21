package com.hc.lease.user.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.user.model.LeaseUser;

import java.util.List;
import java.util.Map;

/**
 * 后台用户
 */
public interface LeaseUserMapper extends BaseDao<LeaseUser> {

    List<LeaseUser> findByPhone(Map<String, Object> paramsMap) throws GMException;

}