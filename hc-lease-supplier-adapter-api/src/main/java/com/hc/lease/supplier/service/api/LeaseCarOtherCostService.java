package com.hc.lease.supplier.service.api;

import com.hc.lease.supplier.model.LeaseCarOtherCost;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/9/13<br/>
 * 说明：汽车其他成本表
 */
public interface LeaseCarOtherCostService {
    /**
     * 新增数据
     * @param leaseCarOtherCost 实体类
     */
    void insertEntity(LeaseCarOtherCost leaseCarOtherCost) throws Exception;

    /**
     * 修改数据
     * @param leaseCarOtherCost 实体类
     */
    void updateEntity(LeaseCarOtherCost leaseCarOtherCost) throws Exception;

    /**
     * 查询其他成本信息
     * @param leaseCarOtherCost 查询参数
     */
    LeaseCarOtherCost selectEntity(LeaseCarOtherCost leaseCarOtherCost);
}
