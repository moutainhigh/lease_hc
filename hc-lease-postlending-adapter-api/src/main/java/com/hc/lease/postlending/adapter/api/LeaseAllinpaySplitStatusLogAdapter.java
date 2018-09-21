package com.hc.lease.postlending.adapter.api;

import com.hc.lease.postlending.model.LeaseAllinpaySplitStatusLog;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 通联支付超额拆分交易明细 支付状态流水Adapter
 * @author Tong
 * @version 2018-06-19
 */

public interface LeaseAllinpaySplitStatusLogAdapter extends BaseAdapter<LeaseAllinpaySplitStatusLog> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
