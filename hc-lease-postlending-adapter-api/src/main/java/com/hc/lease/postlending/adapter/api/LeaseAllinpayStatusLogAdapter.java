package com.hc.lease.postlending.adapter.api;

import com.hc.lease.postlending.model.LeaseAllinpayStatusLog;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 代收状态流水Adapter
 * @author Tong
 * @version 2017-06-15
 */

public interface LeaseAllinpayStatusLogAdapter extends BaseAdapter<LeaseAllinpayStatusLog> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
