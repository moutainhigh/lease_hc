package com.hc.lease.user.adapter.api;

import com.hc.lease.user.model.LeaseAuthoRole;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.user.vo.AuthRoleSelectByTypeVo;

import java.util.List;
import java.util.Map;

/**
 * 角色Adapter
 * @author tong
 * @version 2018-08-27
 */

public interface LeaseAuthoRoleAdapter extends BaseAdapter<LeaseAuthoRole> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 用类型查询
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<AuthRoleSelectByTypeVo> selectByType(Map<String, Object> paramsMap) throws GMException;

}
