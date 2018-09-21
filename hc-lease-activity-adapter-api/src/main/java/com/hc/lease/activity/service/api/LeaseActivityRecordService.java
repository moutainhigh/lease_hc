package com.hc.lease.activity.service.api;

import com.hc.lease.activity.model.LeaseActivityRecord;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;

/**
* 活动记录Service
* @author Qiang
* @version 2018-01-08
*/

public interface LeaseActivityRecordService extends BaseService<LeaseActivityRecord> {


    LeaseActivityRecord selectByIP(String ipAddress);

    List<LeaseActivityRecord> findAllNoPage(Object o);
}
