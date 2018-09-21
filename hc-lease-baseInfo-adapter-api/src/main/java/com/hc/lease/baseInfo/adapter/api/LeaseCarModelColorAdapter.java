package com.hc.lease.baseInfo.adapter.api;

import com.hc.lease.baseInfo.model.LeaseCarModelColor;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 车辆车型-车辆颜色Adapter
 *
 * @author Tong
 * @version 2017-04-17
 */

public interface LeaseCarModelColorAdapter extends BaseAdapter<LeaseCarModelColor> {
    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;


    List<LeaseCarModelColor> selectCarPrice(Map<String, Object> paramsMap);

    List<LeaseCarModelColor> selectCarModelAndColor(Map<String, Object> paramsMap);

}
