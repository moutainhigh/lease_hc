package com.hc.lease.baseInfo.adapter.api;

import com.hc.lease.baseInfo.model.LeaseBank;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 银行Adapter
 *
 * @author Tong
 * @version 2017-04-17
 */

public interface LeaseBankAdapter extends BaseAdapter<LeaseBank> {
    /**
     * 添加或者修改 需要的初始化参数
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    List<LeaseBank> findAllNoType(Object o);

    List<String> findAllBankName();
}
