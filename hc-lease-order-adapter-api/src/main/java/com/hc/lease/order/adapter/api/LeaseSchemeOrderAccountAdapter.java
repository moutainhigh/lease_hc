package com.hc.lease.order.adapter.api;

import com.hc.lease.order.model.LeaseSchemeOrderAccount;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 融租方案申请订单-承租人Adapter
 * @author Qiang
 * @version 2017-05-23
 */

public interface LeaseSchemeOrderAccountAdapter extends BaseAdapter<LeaseSchemeOrderAccount> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    List<LeaseSchemeOrderAccount> selectBySchemeOrderId(long schemeOrderId);

}
