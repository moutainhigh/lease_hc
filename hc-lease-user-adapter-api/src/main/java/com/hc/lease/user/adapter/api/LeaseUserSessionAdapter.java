package com.hc.lease.user.adapter.api;

import com.hc.lease.user.model.LeaseUserSession;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 后台用户登录状态sessionAdapter
 * @author Tong
 * @version 2017-06-26
 */

public interface LeaseUserSessionAdapter extends BaseAdapter<LeaseUserSession> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    LeaseUserSession selectByDeviceId(String deviceId) throws GMException;

}
