package com.hc.lease.supplier.service.api;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeaseAgentsLevel;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;
import java.util.Map;

/**
* 一级区域Service
* @author Qiang
* @version 2017-12-15
*/

public interface LeaseAgentsLevelService extends BaseService<LeaseAgentsLevel> {

    /**
     * 导入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(Map params) throws GMException;

    /**
     * @param paramsMap
     * @return
     */
    List<LeaseAgentsLevel> findByName(Map<String, Object> paramsMap);

    int disableByPrimaryKey(Map<String, Object> paramsMap);

    void updateSort(LeaseAgentsLevel leaseAgentsLevel);
}
