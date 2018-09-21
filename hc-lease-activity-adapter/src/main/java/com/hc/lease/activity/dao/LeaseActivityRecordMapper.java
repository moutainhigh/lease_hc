package com.hc.lease.activity.dao;

import com.hc.lease.activity.model.LeaseActivityRecord;
import com.hc.lease.common.core.dao.BaseDao;

public interface LeaseActivityRecordMapper extends BaseDao<LeaseActivityRecord>{

    LeaseActivityRecord selectByIP(String ipAddress);
}