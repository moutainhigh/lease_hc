package com.hc.lease.wx.adapter.api;

import com.hc.lease.wx.model.LeaseWxSms;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 小程序短信参数配置Adapter
 * @author Qiang
 * @version 2018-03-23
 */

public interface LeaseWxSmsAdapter extends BaseAdapter<LeaseWxSms> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
