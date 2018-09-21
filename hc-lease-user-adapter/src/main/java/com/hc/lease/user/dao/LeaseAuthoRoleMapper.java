package com.hc.lease.user.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.user.model.LeaseAuthoRole;
import com.hc.lease.user.vo.AuthRoleSelectByTypeVo;

import java.util.List;
import java.util.Map;

public interface LeaseAuthoRoleMapper extends BaseDao<LeaseAuthoRole> {

    /**
     * 用类型查询
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<AuthRoleSelectByTypeVo> selectByType(Map<String, Object> paramsMap) throws GMException;

}