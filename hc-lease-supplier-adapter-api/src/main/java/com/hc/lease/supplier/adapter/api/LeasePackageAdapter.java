package com.hc.lease.supplier.adapter.api;

import com.hc.lease.supplier.model.LeasePackage;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 套餐Adapter
 * @author Qiang
 * @version 2017-05-08
 */

public interface LeasePackageAdapter extends BaseAdapter<LeasePackage> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
