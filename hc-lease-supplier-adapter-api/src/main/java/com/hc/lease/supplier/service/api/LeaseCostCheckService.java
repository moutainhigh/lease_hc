package com.hc.lease.supplier.service.api;

import com.hc.lease.supplier.model.LeaseCostCheck;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/9/7<br/>
 * 说明：成本核对表服务层
 */
public interface LeaseCostCheckService {
    /**
     * 新增成本核对数据
     * @param leaseCostCheck 实体类
     */
    void insertEntity(LeaseCostCheck leaseCostCheck) throws Exception;

    /**
     * 修改成本核对数据
     * @param leaseCostCheck 实体类
     */
    void updateEntity(LeaseCostCheck leaseCostCheck) throws Exception;

    /**
     * 根据条件查询成本核对信息
     * @param leaseCostCheck 实体类
     */
    LeaseCostCheck selectEntity(LeaseCostCheck leaseCostCheck);
}
