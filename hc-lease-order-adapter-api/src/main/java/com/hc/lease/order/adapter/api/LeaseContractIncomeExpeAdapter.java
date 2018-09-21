package com.hc.lease.order.adapter.api;

import com.hc.lease.order.model.LeaseContractIncomeExpe;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 贷后车辆管理-收入和支出Adapter
 * @author Tong
 * @version 2018-08-03
 */

public interface LeaseContractIncomeExpeAdapter extends BaseAdapter<LeaseContractIncomeExpe> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    int deleteByContractId(Map<String, Object> paramsMap) throws GMException;

    List<LeaseContractIncomeExpe> findByContractIdAndSource(Map<String, Object> paramsMap) throws GMException;

}
