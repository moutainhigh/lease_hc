package com.hc.lease.postlending.adapter.api;

import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.model.LeaseAllinpayBatch;

import java.util.List;
import java.util.Map;

/**
 * 通联批量代收批次统计Adapter
 *
 * @author Tong
 * @version 2017-06-09
 */

public interface LeaseAllinpayBatchAdapter extends BaseAdapter<LeaseAllinpayBatch> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    LeaseAllinpayBatch selectByBatchNumber(Map<String, Object> paramsMap);

}
