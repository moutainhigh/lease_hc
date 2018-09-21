package com.hc.lease.order.adapter.api;

import com.hc.lease.baseInfo.model.LeaseContractBaseinfo;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseContractBaseinfoUse;

import java.util.Map;

/**
 * 融租合同基础数据Adapter
 *
 * @author Tong
 * @version 2017-04-17
 */

public interface LeaseContractBaseinfoUseAdapter extends BaseAdapter<LeaseContractBaseinfoUse> {
    /**
     * 添加或者修改 需要的初始化参数
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;
}
