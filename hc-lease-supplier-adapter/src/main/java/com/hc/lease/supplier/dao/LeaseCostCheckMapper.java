package com.hc.lease.supplier.dao;

import com.hc.lease.supplier.model.LeaseCostCheck;
import org.apache.ibatis.annotations.Param;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/9/7<br/>
 * 说明：成本核对
 */
public interface LeaseCostCheckMapper {
    /**
     * 新增成本核对数据
     * @param leaseCostCheck 实体类
     */
    boolean insertEntity(LeaseCostCheck leaseCostCheck);

    /**
     * 修改成本核对数据
     * @param leaseCostCheck 实体类
     */
    boolean updateEntity(LeaseCostCheck leaseCostCheck);

    /**
     * 根据条件查询成本核对信息
     * @param leaseCostCheck 实体类
     */
    LeaseCostCheck selectEntity(LeaseCostCheck leaseCostCheck);
}
