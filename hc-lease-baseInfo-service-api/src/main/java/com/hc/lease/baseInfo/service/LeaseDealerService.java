package com.hc.lease.baseInfo.service;

import com.hc.lease.baseInfo.model.LeaseDealer;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 经销商Service
 *
 * @author Tong
 * @version 2017-04-14
 */

public interface LeaseDealerService extends BaseService<LeaseDealer> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseDealer> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 根据名称检测数据是否存在
     *
     * @return
     */
    List<LeaseDealer> findByName(Map params) throws GMException;

    /**
     * 根据父级主键id检测数据是否存在
     *
     * @param id
     * @return
     * @throws GMException
     */
    List<LeaseDealer> selectByParentId(Long id) throws GMException;

    /**
     * 根据级别查询
     * @param i
     * @return
     */
    List<LeaseDealer> selectByGrade(int i);
}
