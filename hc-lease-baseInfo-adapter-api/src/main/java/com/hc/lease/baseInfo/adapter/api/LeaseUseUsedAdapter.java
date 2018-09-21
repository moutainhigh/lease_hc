package com.hc.lease.baseInfo.adapter.api;

import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 使用和被使用的数据Adapter
 *
 * @author Tong
 * @version 2017-06-20
 */

public interface LeaseUseUsedAdapter extends BaseAdapter<LeaseUseUsed> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * @param paramsMap
     * @return
     */
    int deleteByUseUsed(Map<String, Object> paramsMap);

    /**
     * @param paramsMap
     * @return
     */
    List<LeaseUseUsed> selectByUsed(Map<String, Object> paramsMap);

}
