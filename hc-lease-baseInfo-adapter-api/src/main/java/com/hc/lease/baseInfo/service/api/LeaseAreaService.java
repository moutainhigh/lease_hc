package com.hc.lease.baseInfo.service.api;

import com.hc.lease.baseInfo.model.LeaseArea;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 地区Service
 *
 * @author Tong
 * @version 2017-04-26
 */

public interface LeaseAreaService extends BaseService<LeaseArea> {
    List<LeaseArea> findAreaByEnableAndModel(Map<String, Object> paramsMap) throws GMException;

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseArea> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    LeaseArea findByName(Map<String, Object> param);
}
