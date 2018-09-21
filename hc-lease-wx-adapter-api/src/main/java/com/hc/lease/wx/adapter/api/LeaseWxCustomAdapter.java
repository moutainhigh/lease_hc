package com.hc.lease.wx.adapter.api;

import com.hc.lease.wx.model.LeaseWxCustom;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 个人定制Adapter
 * @author Qiang
 * @version 2018-03-23
 */

public interface LeaseWxCustomAdapter extends BaseAdapter<LeaseWxCustom> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    int updateDealStatus(Long id, Integer deal);

    List<LeaseWxCustom> findAllNoPage(Map<String, Object> paramsMap);
}
