package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.excel.poi.vo.CostCheckReadInfo;
import com.hc.lease.common.core.excel.poi.vo.CostCheckTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.adapter.api.CarCostHandleAdapter;
import com.hc.lease.supplier.model.LeaseCar;
import com.hc.lease.supplier.service.api.CarCostHandleService;
import com.hc.lease.supplier.vo.CostCheckInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/9/12<br/>
 * 说明：汽车成本处理
 */
@Service("carCostHandleAdapter")
public class CarCostHandleAdapterImpl implements CarCostHandleAdapter {
    @Resource
    private CarCostHandleService carCostHandleService;

    @Override
    public PageInfo<LeaseCar> costCheckShow(Map<String, Object> paramsMap) throws GMException {
        return carCostHandleService.costCheckShow(paramsMap);
    }

    @Override
    public void updateCostCheck(LeaseCar leaseCar) throws Exception {
        carCostHandleService.updateCostCheck(leaseCar);
    }

    @Override
    public void updateCarCheckInfo(CostCheckInfo costCheckInfo) throws Exception {
        carCostHandleService.updateCarCheckInfo(costCheckInfo);
    }

    @Override
    public CostCheckReadInfo updateCostCheckInfo(List<CostCheckTemplate> costCheckTemplates, BigDecimal ruleValue) throws Exception {
        return carCostHandleService.updateCostCheckInfo(costCheckTemplates, ruleValue);
    }
}
