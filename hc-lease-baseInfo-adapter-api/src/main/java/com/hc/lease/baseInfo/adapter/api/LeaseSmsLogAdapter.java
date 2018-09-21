package com.hc.lease.baseInfo.adapter.api;

import com.hc.lease.baseInfo.model.LeaseSmsLog;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 短信日志Adapter
 * @author Qiang
 * @version 2017-08-30
 */

public interface LeaseSmsLogAdapter extends BaseAdapter<LeaseSmsLog> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
