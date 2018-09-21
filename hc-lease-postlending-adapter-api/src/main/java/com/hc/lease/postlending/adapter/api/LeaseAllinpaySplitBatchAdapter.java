package com.hc.lease.postlending.adapter.api;

import com.hc.lease.postlending.model.LeaseAllinpayBatch;
import com.hc.lease.postlending.model.LeaseAllinpaySplitBatch;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 通联支付超额拆分交易明细 批量支付批次统计Adapter
 * @author Tong
 * @version 2018-06-19
 */

public interface LeaseAllinpaySplitBatchAdapter extends BaseAdapter<LeaseAllinpaySplitBatch> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    LeaseAllinpaySplitBatch selectByBatchNumber(Map<String, Object> paramsMap);

}
