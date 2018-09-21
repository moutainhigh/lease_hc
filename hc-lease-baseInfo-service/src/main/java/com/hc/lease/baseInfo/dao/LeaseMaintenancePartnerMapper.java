package com.hc.lease.baseInfo.dao;

import com.hc.lease.baseInfo.model.LeaseDealer;
import com.hc.lease.baseInfo.model.LeaseMaintenancePartner;
import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

public interface LeaseMaintenancePartnerMapper extends BaseDao<LeaseMaintenancePartner> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseMaintenancePartner> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 根据名称检测数据是否存在
     *
     * @return
     */
    List<LeaseMaintenancePartner> findByName(Map params) throws GMException;

}