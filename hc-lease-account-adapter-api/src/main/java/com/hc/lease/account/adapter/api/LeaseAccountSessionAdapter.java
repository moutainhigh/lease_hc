package com.hc.lease.account.adapter.api;

import com.hc.lease.account.model.LeaseAccountSession;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 注册用户/承租人登录状态sessionAdapter
 * @author Tong
 * @version 2017-05-24
 */

public interface LeaseAccountSessionAdapter extends BaseAdapter<LeaseAccountSession> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    LeaseAccountSession selectByDeviceId(String deviceId) throws GMException;

}
