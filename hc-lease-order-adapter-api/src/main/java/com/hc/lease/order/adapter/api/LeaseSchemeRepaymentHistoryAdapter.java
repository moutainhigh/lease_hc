package com.hc.lease.order.adapter.api;

import com.hc.lease.order.model.LeaseSchemeRepaymentHistory;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 根据融租合同数据生成月租还款计划明细 历史Adapter
 * @author Tong
 * @version 2018-07-19
 */

public interface LeaseSchemeRepaymentHistoryAdapter extends BaseAdapter<LeaseSchemeRepaymentHistory> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
