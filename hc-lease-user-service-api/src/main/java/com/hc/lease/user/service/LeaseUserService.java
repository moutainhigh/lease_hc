package com.hc.lease.user.service;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.user.model.LeaseUser;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;
import java.util.Map;

/**
* 后台用户Service
* @author Tong
* @version 2017-06-26
*/

public interface LeaseUserService extends BaseService<LeaseUser> {

    List<LeaseUser> findByPhone(Map<String, Object> paramsMap) throws GMException;

}
