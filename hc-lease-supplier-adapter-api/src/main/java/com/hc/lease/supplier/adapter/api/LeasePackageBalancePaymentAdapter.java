package com.hc.lease.supplier.adapter.api;

import com.hc.lease.supplier.model.LeasePackageBalancePayment;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 融租方案-尾款Adapter
 * @author Qiang
 * @version 2017-11-02
 */

public interface LeasePackageBalancePaymentAdapter extends BaseAdapter<LeasePackageBalancePayment> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
