package com.hc.lease.supplier.service.impl;

import com.hc.lease.supplier.dao.LeaseCostCheckMapper;
import com.hc.lease.supplier.model.LeaseCostCheck;
import com.hc.lease.supplier.service.api.LeaseCostCheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/9/7<br/>
 * 说明：成本核对表服务层
 */
@Service("leaseCostCheckService")
public class LeaseCostCheckServiceImpl implements LeaseCostCheckService {
    @Resource
    private LeaseCostCheckMapper leaseCostCheckMapper;

    @Override
    public void insertEntity(LeaseCostCheck leaseCostCheck) throws Exception {
        boolean insertState = leaseCostCheckMapper.insertEntity(leaseCostCheck);
        if (!insertState) {
            throw new Exception("新增成本核对表信息失败,参数："+leaseCostCheck.toString());
        }
    }

    @Override
    public void updateEntity(LeaseCostCheck leaseCostCheck) throws Exception {
        boolean updateState = leaseCostCheckMapper.updateEntity(leaseCostCheck);
        if (!updateState) {
            throw new Exception("修改成本核对表信息失败,参数："+leaseCostCheck.toString());
        }
    }

    @Override
    public LeaseCostCheck selectEntity(LeaseCostCheck leaseCostCheck) {
        return leaseCostCheckMapper.selectEntity(leaseCostCheck);
    }
}
