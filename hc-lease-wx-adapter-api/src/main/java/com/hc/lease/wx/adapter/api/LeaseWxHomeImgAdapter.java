package com.hc.lease.wx.adapter.api;

import com.hc.lease.wx.model.LeaseWxHomeImg;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.wx.model.LeaseWxHomeImgs;

import java.util.Map;

/**
 * 首页图Adapter
 * @author Qiang
 * @version 2017-11-29
 */

public interface LeaseWxHomeImgAdapter extends BaseAdapter<LeaseWxHomeImg> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    int updateSort(LeaseWxHomeImgs leaseWxHomeImgs);
}
