package com.hc.lease.supplier.dao;

import com.hc.lease.supplier.model.LeaseCarOtherCost;
import org.apache.ibatis.annotations.Param;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/9/8<br/>
 * 说明：汽车其他成本表
 */
public interface LeaseCarOtherCostMapper {
    /**
     * 新增数据
     * @param leaseCarOtherCost 实体类
     */
    boolean insertEntity(LeaseCarOtherCost leaseCarOtherCost);

    /**
     * 修改数据
     * @param leaseCarOtherCost 实体类
     */
    boolean updateEntity(LeaseCarOtherCost leaseCarOtherCost);

    /**
     * 查询其他成本信息
     * @param leaseCarOtherCost 查询参数
     */
    LeaseCarOtherCost selectEntity(LeaseCarOtherCost leaseCarOtherCost);
}
