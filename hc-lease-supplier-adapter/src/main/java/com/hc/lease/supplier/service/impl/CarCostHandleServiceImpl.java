package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.excel.poi.vo.CostCheckReadInfo;
import com.hc.lease.common.core.excel.poi.vo.CostCheckTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.util.BigDecimalUtil;
import com.hc.lease.supplier.enumeration.PublicStatusEnum;
import com.hc.lease.supplier.model.LeaseCar;
import com.hc.lease.supplier.model.LeaseCarInsurance;
import com.hc.lease.supplier.model.LeaseCarOtherCost;
import com.hc.lease.supplier.model.LeaseCostCheck;
import com.hc.lease.supplier.service.api.CarCostHandleService;
import com.hc.lease.supplier.service.api.LeaseCarInsuranceService;
import com.hc.lease.supplier.service.api.LeaseCarOtherCostService;
import com.hc.lease.supplier.service.api.LeaseCarService;
import com.hc.lease.supplier.service.api.LeaseCostCheckService;
import com.hc.lease.supplier.vo.CostCheckInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/9/7<br/>
 * 说明：汽车成本处理
 */
@Service("carCostHandleService")
public class CarCostHandleServiceImpl implements CarCostHandleService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private LeaseCarService leaseCarService;
    @Resource
    private LeaseCarInsuranceService leaseCarInsuranceService;
    @Resource
    private LeaseCostCheckService leaseCostCheckService;
    @Resource
    private LeaseCarOtherCostService leaseCarOtherCostService;

    @Override
    public PageInfo<LeaseCar> costCheckShow(Map<String, Object> paramsMap) throws GMException {
        return leaseCarService.findPage(1,5,paramsMap);
    }

    @Override
    public void updateCostCheck(LeaseCar leaseCar) throws Exception {
        LeaseCostCheck leaseCostCheck = leaseCar.getLeaseCostCheck();
        Long carId = leaseCar.getId();
        // 车
        if (PublicStatusEnum.S.getStringValue().equals(leaseCostCheck.getCarCheckState())) {
            boolean updateState = updateLeaseCar(leaseCar);
            if (!updateState) {
                throw new Exception("修改车辆信息失败");
            }
        }
        // 保险和车船税
        if (PublicStatusEnum.S.getStringValue().equals(leaseCostCheck.getInsuranceCheckState())) {
            List<LeaseCarInsurance> leaseCarInsurances = leaseCar.getLaseCarInsurances();
            if (leaseCarInsurances.size() > 0 ) {
                for (LeaseCarInsurance leaseCarInsurance : leaseCarInsurances) {
                    if (leaseCarInsurance == null) {
                        continue;
                    }
                    // 判断该车辆的保险类型是否存在
                    LeaseCarInsurance queryEntity = new LeaseCarInsurance();
                    queryEntity.setCarId(carId);
                    queryEntity.setType(leaseCarInsurance.getType());
                    queryEntity.setYear(leaseCarInsurance.getYear());
                    List<LeaseCarInsurance> list = leaseCarInsuranceService.selectEntity(queryEntity);
                    if (list.size() > 0) {
                        leaseCarInsuranceService.updateEntity(leaseCarInsurance);
                    } else {
                        leaseCarInsurance.setCarId(carId);
                        leaseCarInsuranceService.insertSelective(leaseCarInsurance);
                    }
                }
                boolean updateState = updateLeaseCar(leaseCar);
                if (!updateState) {
                    throw new Exception("修改车辆信息失败");
                }
            }
        }
        // 购置税
        if (PublicStatusEnum.S.getStringValue().equals(leaseCostCheck.getPurchaseTaxCheckState())) {
            boolean updateState = updateLeaseCar(leaseCar);
            if (!updateState) {
                throw new Exception("修改车辆信息失败");
            }
        }
        // 其他成本
        if (PublicStatusEnum.S.getStringValue().equals(leaseCostCheck.getOtherCostState())) {
            // 判断车辆其他成本信息是否存在
            LeaseCarOtherCost leaseCarOtherCost = new LeaseCarOtherCost();
            leaseCarOtherCost.setCarId(carId);
            leaseCarOtherCost = leaseCarOtherCostService.selectEntity(leaseCarOtherCost);
            if (leaseCarOtherCost == null) {
                leaseCar.getLeaseCarOtherCost().setCarId(carId);
                leaseCarOtherCostService.insertEntity(leaseCar.getLeaseCarOtherCost());
            } else {
                leaseCarOtherCostService.updateEntity(leaseCar.getLeaseCarOtherCost());
            }
        }
        // 修改核对状态
        LeaseCostCheck leaseCostCheckTwo = leaseCar.getLeaseCostCheck();
        leaseCostCheckTwo.setCarId(carId);
        leaseCostCheckTwo = leaseCostCheckService.selectEntity(leaseCostCheckTwo);
        leaseCostCheck = leaseCostCheck.paramCheck(leaseCostCheck);
        if (leaseCostCheckTwo == null) {
            leaseCostCheck.setCarId(carId);
            leaseCostCheckService.insertEntity(leaseCostCheck);
        } else {
            leaseCostCheckService.updateEntity(leaseCostCheck);
        }
    }

    @Override
    public void updateCarCheckInfo(CostCheckInfo costCheckInfo) throws Exception {
        LeaseCar leaseCar = new LeaseCar();
        leaseCar.setId(costCheckInfo.getCarId());
        leaseCar.setInvoicedCarPrice(costCheckInfo.getInvoicedCarPrice());
        leaseCar.setInvoiceNumber(costCheckInfo.getInvoiceNumber());
        leaseCar.setPurchaseTax(costCheckInfo.getPurchaseTax());
        if (PublicStatusEnum.S.getStringValue().equals(costCheckInfo.getPurchaseTaxCheckState()) || PublicStatusEnum.S.getStringValue().equals(costCheckInfo.getCarCheckState())) {
            boolean updateState = updateLeaseCar(leaseCar);
            if (!updateState) {
                throw new Exception("修改车辆信息失败");
            }
        }
        updateCostCheckState(costCheckInfo);
    }

    @Override
    public CostCheckReadInfo updateCostCheckInfo(List<CostCheckTemplate> costCheckTemplates, BigDecimal ruleValue) throws Exception {
        CostCheckReadInfo costCheckReadInfo = new CostCheckReadInfo();
        int successNum = 0;
        int failNum = 0;
        for (CostCheckTemplate costCheckTemplate : costCheckTemplates) {
            // 判断含税车价是否小于等于零
            if (BigDecimalUtil.isUse(costCheckTemplate.getInvoicedCarPrice() == null ? BigDecimal.ZERO : costCheckTemplate.getInvoicedCarPrice())) {
                failNum ++;
                costCheckTemplate.setUpdateState("含税车价不能为空或小于等于0");
                System.out.println("含税车价为："+costCheckTemplate.getInvoicedCarPrice());
                continue;
            }
            LeaseCar leaseCar = new LeaseCar();
            leaseCar.setCardFrameNumber(costCheckTemplate.getCardFrameNumber());
            LeaseCar leaseCars = leaseCarService.selectEntity(leaseCar);
            if (leaseCars == null) {
                failNum ++;
                costCheckTemplate.setUpdateState("车架号不存在");
                System.out.println("车辆信息为空，车架号为="+leaseCar.getCardFrameNumber());
                continue;
            }
            leaseCar.setId(leaseCars.getId());
            leaseCar.setInvoicedCarPrice(costCheckTemplate.getInvoicedCarPrice());
            if (!StringUtils.isEmpty(costCheckTemplate.getInvoiceNumber())) {
                leaseCar.setInvoiceNumber(costCheckTemplate.getInvoiceNumber());
            }
            if (!BigDecimalUtil.isUse(costCheckTemplate.getPurchaseTax() == null ? BigDecimal.ZERO : costCheckTemplate.getPurchaseTax())) {
                leaseCar.setPurchaseTax(costCheckTemplate.getPurchaseTax());
            }

            boolean updateState = false;
            try {
                updateState = updateLeaseCar(leaseCar);
            } catch (Exception e) {
                logger.info("修改成本核对信息失败！车辆信息id="+leaseCar.getId());
            }
            if (!updateState) {
                failNum ++;
                costCheckTemplate.setUpdateState("失败");
            } else {
                successNum ++;
                costCheckTemplate.setUpdateState("成功");
                CostCheckInfo costCheckInfo = new CostCheckInfo();
                costCheckInfo.setCarId(leaseCar.getId());
                costCheckInfo.setCarCheckState(PublicStatusEnum.S.getStringValue());
                if (!BigDecimalUtil.isUse(costCheckTemplate.getPurchaseTax() == null ? BigDecimal.ZERO : costCheckTemplate.getPurchaseTax())) {
                    costCheckInfo.setPurchaseTaxCheckState(PublicStatusEnum.S.getStringValue());
                }
                try {
                    updateCostCheckState(costCheckInfo);
                } catch (Exception e) {
                    logger.info("修改成本核对信息失败！车辆信息id="+leaseCar.getId());
                }
            }
        }
        costCheckReadInfo.setCostCheckTemplates(costCheckTemplates);
        costCheckReadInfo.setSuccessNum(successNum);
        costCheckReadInfo.setFailNum(failNum);
        return costCheckReadInfo;
    }

    /**
     * 修改成本核对车信息
     * @param leaseCar 修改参数
     */
    private boolean updateLeaseCar(LeaseCar leaseCar) throws Exception {
        LeaseCar updateLeaseCar = new LeaseCar();
        // 车信息主键id
        updateLeaseCar.setId(leaseCar.getId());
        // 含税车价
        updateLeaseCar.setInvoicedCarPrice(leaseCar.getInvoicedCarPrice() != null ? leaseCar.getInvoicedCarPrice() : null);
        // 不含税车价
        updateLeaseCar.setPrice(leaseCar.getPrice() != null ? leaseCar.getPrice() : null);
        // 车价税额
        updateLeaseCar.setInvoicingTax(leaseCar.getInvoicingTax() != null ? leaseCar.getInvoicingTax() : null);
        // 车发票号
        updateLeaseCar.setInvoiceNumber(StringUtils.isEmpty(leaseCar.getInvoiceNumber()) ? null : leaseCar.getInvoiceNumber());
        // 车船税
        updateLeaseCar.setVehicleVesselTax(leaseCar.getVehicleVesselTax() != null ? leaseCar.getVehicleVesselTax() : null);
        // 购置税
        updateLeaseCar.setPurchaseTax(leaseCar.getPurchaseTax() != null ? leaseCar.getPurchaseTax() : null);
        // 含税GPS价格
        updateLeaseCar.setGpsCost(leaseCar.getGpsCost() != null ? leaseCar.getGpsCost() : null);
        // 其他不含税成本
        updateLeaseCar.setOtherCost(leaseCar.getOtherCost() != null ? leaseCar.getOtherCost() : null);
        return leaseCarService.updateEntityById(updateLeaseCar);
    }

    /**
     * 修改或新增成本核对结果信息
     * @param costCheckInfo 成本核对信息
     */
    private void updateCostCheckState(CostCheckInfo costCheckInfo) throws Exception {
        LeaseCostCheck leaseCostCheck = new LeaseCostCheck();
        leaseCostCheck.setCarId(costCheckInfo.getCarId());
        leaseCostCheck = leaseCostCheckService.selectEntity(leaseCostCheck);

        LeaseCostCheck leaseCostCheckTwo = new LeaseCostCheck();
        leaseCostCheckTwo.setCarId(costCheckInfo.getCarId());
        leaseCostCheckTwo.setCarCheckState(StringUtils.isEmpty(costCheckInfo.getCarCheckState()) ? "F" : costCheckInfo.getCarCheckState());
        leaseCostCheckTwo.setPurchaseTaxCheckState(StringUtils.isEmpty(costCheckInfo.getPurchaseTaxCheckState()) ? "F" : costCheckInfo.getPurchaseTaxCheckState());
        if (leaseCostCheck == null) {
            leaseCostCheckService.insertEntity(leaseCostCheckTwo);
        } else {
            leaseCostCheckTwo.setLeaseCostCheckId(leaseCostCheck.getLeaseCostCheckId());
            leaseCostCheckService.updateEntity(leaseCostCheckTwo);
        }
    }
}
