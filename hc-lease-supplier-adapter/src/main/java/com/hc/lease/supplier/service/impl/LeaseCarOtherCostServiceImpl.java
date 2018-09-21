package com.hc.lease.supplier.service.impl;

import com.hc.lease.supplier.dao.LeaseCarOtherCostMapper;
import com.hc.lease.supplier.model.LeaseCarOtherCost;
import com.hc.lease.supplier.service.api.LeaseCarOtherCostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/9/13<br/>
 * 说明：汽车其他成本表
 */
@Service("leaseCarOtherCostService")
public class LeaseCarOtherCostServiceImpl implements LeaseCarOtherCostService {
    @Resource
    private LeaseCarOtherCostMapper leaseCarOtherCostMapper;

    @Override
    public void insertEntity(LeaseCarOtherCost leaseCarOtherCost) throws Exception {
        boolean insertState = leaseCarOtherCostMapper.insertEntity(leaseCarOtherCost);
        if (!insertState) {
            throw new Exception("新增汽车其他成本表信息失败，参数="+leaseCarOtherCost.toString());
        }
    }

    @Override
    public void updateEntity(LeaseCarOtherCost leaseCarOtherCost) throws Exception {
        boolean updateState = leaseCarOtherCostMapper.updateEntity(leaseCarOtherCost);
        if (!updateState) {
            throw new Exception("修改汽车其他成本表信息失败，参数="+leaseCarOtherCost.toString());
        }
    }

    @Override
    public LeaseCarOtherCost selectEntity(LeaseCarOtherCost leaseCarOtherCost) {
        return leaseCarOtherCostMapper.selectEntity(leaseCarOtherCost);
    }
}
