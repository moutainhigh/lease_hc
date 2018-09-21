package com.hc.lease.wx.adapter.api;

import com.hc.lease.wx.model.LeaseWxBuyDescription;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 购买说明Adapter
 * @author Qiang
 * @version 2017-11-30
 */

public interface LeaseWxBuyDescriptionAdapter extends BaseAdapter<LeaseWxBuyDescription> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
