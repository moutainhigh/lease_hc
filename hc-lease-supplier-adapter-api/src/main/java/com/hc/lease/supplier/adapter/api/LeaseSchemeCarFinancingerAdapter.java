package com.hc.lease.supplier.adapter.api;

import com.hc.lease.supplier.model.LeaseSchemeCarFinancinger;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 车辆与融租方Adapter
 * @author Qiang
 * @version 2017-08-18
 */

public interface LeaseSchemeCarFinancingerAdapter extends BaseAdapter<LeaseSchemeCarFinancinger> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    int deleteByCarId(Long carId);

}
