package com.hc.lease.supplier.adapter.api;

import com.hc.lease.supplier.model.LeaseSchemePrice;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 方案报价Adapter
 * @author Qiang
 * @version 2018-07-27
 */

public interface LeaseSchemePriceAdapter extends BaseAdapter<LeaseSchemePrice> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
