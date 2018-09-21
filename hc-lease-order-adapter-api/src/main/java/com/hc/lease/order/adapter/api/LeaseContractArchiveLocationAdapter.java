package com.hc.lease.order.adapter.api;

import com.hc.lease.order.model.LeaseContractArchiveLocation;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 融租合同-归档信息Adapter
 * @author Qiang
 * @version 2017-05-23
 */

public interface LeaseContractArchiveLocationAdapter extends BaseAdapter<LeaseContractArchiveLocation> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
