package com.hc.lease.user.service.api;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.user.model.LeaseAuthoRole;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.user.vo.AuthRoleSelectByTypeVo;

import java.util.List;
import java.util.Map;

/**
* 角色Service
* @author tong
* @version 2018-08-27
*/

public interface LeaseAuthoRoleService extends BaseService<LeaseAuthoRole> {

    /**
     * 用类型查询
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<AuthRoleSelectByTypeVo> selectByType(Map<String, Object> paramsMap) throws GMException;

}
