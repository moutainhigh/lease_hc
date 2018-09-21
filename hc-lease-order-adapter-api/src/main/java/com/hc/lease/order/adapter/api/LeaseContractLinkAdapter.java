package com.hc.lease.order.adapter.api;

import com.hc.lease.order.model.LeaseContractLink;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 融租合同 挂靠，可能每一种款项会操作多次扣款，租期结束且融租合同贷后管理登记为挂靠Adapter
 *
 * @author Tong
 * @version 2017-08-24
 */

public interface LeaseContractLinkAdapter extends BaseAdapter<LeaseContractLink> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
