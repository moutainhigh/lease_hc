package com.hc.lease.baseInfo.dao;

import com.hc.lease.baseInfo.model.LeaseArchiveLocation;
import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 归档位置
 */
public interface LeaseArchiveLocationMapper extends BaseDao<LeaseArchiveLocation> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseArchiveLocation> insertViewParames(Map<String, Object> paramsMap);

    /**
     * 根据名称检测数据是否存在
     *
     * @return
     */
    List<LeaseArchiveLocation> findByName(Map params) throws GMException;

    int disableByPrimaryKey(Map<String, Object> params);

    void updateSort(Map<String, Object> paramsMap);

    int updateDefaultSelected(Map<String, Object> paramsMap);

    Integer findMaxNumber();
}