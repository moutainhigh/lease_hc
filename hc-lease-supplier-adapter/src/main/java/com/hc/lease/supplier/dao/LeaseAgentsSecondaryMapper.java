package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeaseAgentsSecondary;

import java.util.List;
import java.util.Map;

public interface LeaseAgentsSecondaryMapper extends BaseDao<LeaseAgentsSecondary> {

    List<LeaseAgentsSecondary> selectByLevelId(Long id);

    void deleteByLevelId(Long id);

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
    List<LeaseAgentsSecondary> findByName(Map<String, Object> paramsMap);

    int disableByPrimaryKey(Map<String, Object> paramsMap);

    void updateSort(Map<String, Object> paramsMap);
}