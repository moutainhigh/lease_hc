package com.hc.lease.user.adapter.api;

import com.hc.lease.user.model.LeaseAuthoRoleOrganization;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 角色-公司、部门、组中间表。用于控制角色查看指定公司、部门的数据Adapter
 * @author tong
 * @version 2018-08-27
 */

public interface LeaseAuthoRoleOrganizationAdapter extends BaseAdapter<LeaseAuthoRoleOrganization> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
