package com.hc.lease.order.adapter.api;

import com.hc.lease.order.model.LeaseContractCarCallback;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.vo.FindByPrimaryKeyVo;

import java.util.Map;

/**
 * 贷后车辆管理-收车Adapter
 * @author Tong
 * @version 2018-08-03
 */

public interface LeaseContractCarCallbackAdapter extends BaseAdapter<LeaseContractCarCallback> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    FindByPrimaryKeyVo findByPrimaryKey(Long id);

    int findMaxDualNumber(Map<String, Object> paramsMap) throws GMException;

}
