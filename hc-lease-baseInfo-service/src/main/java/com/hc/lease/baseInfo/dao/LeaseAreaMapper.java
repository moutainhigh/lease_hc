package com.hc.lease.baseInfo.dao;

import com.hc.lease.baseInfo.model.LeaseArchiveLocation;
import com.hc.lease.baseInfo.model.LeaseArea;
import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 地区
 */
public interface LeaseAreaMapper extends BaseDao<LeaseArea> {
    List<LeaseArea> findAreaByEnableAndModel(Map<String, Object> paramsMap) throws GMException;

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseArea> insertViewParames(Map<String, Object> paramsMap);

}