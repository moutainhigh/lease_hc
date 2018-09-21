package com.hc.lease.postlending.adapter.api;

import com.hc.lease.postlending.model.LeaseManualDeductiStatusLog;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 手动扣款支付状态流水Adapter
 * @author Tong
 * @version 2018-07-06
 */

public interface LeaseManualDeductiStatusLogAdapter extends BaseAdapter<LeaseManualDeductiStatusLog> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
