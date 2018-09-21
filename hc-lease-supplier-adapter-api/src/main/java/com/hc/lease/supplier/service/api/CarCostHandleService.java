package com.hc.lease.supplier.service.api;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.excel.poi.vo.CostCheckReadInfo;
import com.hc.lease.common.core.excel.poi.vo.CostCheckTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeaseCar;
import com.hc.lease.supplier.vo.CostCheckInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/9/7<br/>
 * 说明：汽车成本处理
 */
public interface CarCostHandleService {
    /**
     * 成本核对展示
     * @param paramsMap carId 车辆信息主键id
     */
    PageInfo<LeaseCar> costCheckShow(Map<String, Object> paramsMap) throws GMException;

    /**
     * 成本核对修改
     * @param leaseCar 修改参数
     */
    void updateCostCheck(LeaseCar leaseCar) throws Exception;

    /**
     * 修改车辆核对信息
     * @param costCheckInfo 成本核对信息
     */
    void updateCarCheckInfo(CostCheckInfo costCheckInfo) throws Exception;

    /**
     * 更新成本核对信息
     */
    CostCheckReadInfo updateCostCheckInfo(List<CostCheckTemplate> costCheckTemplates, BigDecimal ruleValue) throws Exception;
}
