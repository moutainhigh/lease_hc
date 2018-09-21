package com.hc.lease.baseInfo.service;

import com.hc.lease.baseInfo.model.LeaseArchiveLocation;
import com.hc.lease.baseInfo.model.LeaseMaintenancePartner;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 归档位置Service
 * @author Tong
 * @version 2017-04-14
 */

public interface LeaseArchiveLocationService extends BaseService<LeaseArchiveLocation> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseArchiveLocation> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 根据名称检测数据是否存在
     *
     * @return
     */
    List<LeaseArchiveLocation> findByName(Map params) throws GMException;

}
