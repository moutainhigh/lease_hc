package com.hc.lease.baseInfo.service;

import com.hc.lease.baseInfo.model.LeaseCarBuyFinancinger;
import com.hc.lease.baseInfo.model.LeaseMaintenancePartner;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 保养维护合作方Service
 * @author Tong
 * @version 2017-04-14
 */

public interface LeaseMaintenancePartnerService extends BaseService<LeaseMaintenancePartner> {

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
