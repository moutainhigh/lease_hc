package com.hc.lease.activity.adapter.api;

import com.hc.lease.activity.model.LeaseActivityRecord;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 活动访问记录Adapter
 * @author Qiang
 * @version 2018-01-08
 */

public interface LeaseActivityRecordAdapter extends BaseAdapter<LeaseActivityRecord> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;


    LeaseActivityRecord selectByIP(String ipAddress);

    List<LeaseActivityRecord> findAllNoPage(Object o);
}
