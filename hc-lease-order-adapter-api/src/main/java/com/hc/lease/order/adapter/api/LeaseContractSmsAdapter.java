package com.hc.lease.order.adapter.api;

import com.hc.lease.order.model.LeaseContractSms;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 短信日志-融租合同Adapter
 * @author Qiang
 * @version 2017-08-31
 */

public interface LeaseContractSmsAdapter extends BaseAdapter<LeaseContractSms> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
