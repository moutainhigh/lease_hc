package com.hc.lease.supplier.adapter.api;

import com.hc.lease.supplier.model.LeaseAgentsLevel;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.vo.LeaseAgentsLevels;

import java.util.List;
import java.util.Map;

/**
 * 一级区域Adapter
 * @author Qiang
 * @version 2017-12-15
 */

public interface LeaseAgentsLevelAdapter extends BaseAdapter<LeaseAgentsLevel> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

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

    int updateSort(LeaseAgentsLevels leaseAgentsLevels);
}
