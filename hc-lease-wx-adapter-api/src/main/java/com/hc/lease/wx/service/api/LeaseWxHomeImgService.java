package com.hc.lease.wx.service.api;

import com.hc.lease.wx.model.LeaseWxHomeImg;
import com.hc.lease.common.core.dao.BaseService;

/**
* 首页图Service
* @author Qiang
* @version 2017-11-29
*/

public interface LeaseWxHomeImgService extends BaseService<LeaseWxHomeImg> {

    int updateSort(LeaseWxHomeImg leaseWxHomeImg);
}
