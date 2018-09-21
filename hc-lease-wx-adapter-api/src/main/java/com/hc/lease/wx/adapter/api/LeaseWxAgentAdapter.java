package com.hc.lease.wx.adapter.api;

import com.hc.lease.wx.model.LeaseWxAgent;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 代理Adapter
 * @author Qiang
 * @version 2017-11-29
 */

public interface LeaseWxAgentAdapter extends BaseAdapter<LeaseWxAgent> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    int updateDealStatus(Long id, Integer deal);

    List<LeaseWxAgent> findAllNoPage(Map<String, Object> paramsMap);
}
