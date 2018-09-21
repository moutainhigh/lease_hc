package com.hc.lease.baseInfo.service.api;

import com.hc.lease.baseInfo.model.LeaseDict;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 字典表Service
 *
 * @author Tong
 * @version 2017-04-14
 */

public interface LeaseDictService extends BaseService<LeaseDict> {

    /**
     * 根据类型查询字典表数据
     *
     * @param type
     * @return
     */
    List<LeaseDict> findByType(String type);

    /**
     * 导出车辆录入模板需要的数据
     *
     * @return
     */
    List<String> findExportExcelModel(String type) throws GMException;

    /**
     * @param paramsMap
     * @return
     */
    List<LeaseDict> findByValueAndType(Map<String, Object> paramsMap);

    List<LeaseDict> findAllValid();

    List<String> findAllValidType();

    int disableByPrimaryKey(Map<String, Object> paramsMap);

    int updateDefaultSelected(Map<String, Object> paramsMap);

    void updateSort(LeaseDict leaseDict);

    Integer findMaxNumber(String type);
}
