package com.hc.lease.order.adapter.api;

import com.hc.lease.order.model.LeaseUpdateMonthlyrent;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 融租合同修改租金备份Adapter
 * @author Tong
 * @version 2017-12-28
 */

public interface LeaseUpdateMonthlyrentAdapter extends BaseAdapter<LeaseUpdateMonthlyrent> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
