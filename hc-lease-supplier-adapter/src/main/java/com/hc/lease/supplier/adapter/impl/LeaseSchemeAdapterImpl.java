package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.model.*;
import com.hc.lease.baseInfo.service.api.*;
import com.hc.lease.common.core.constant.UseType;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.model.LeaseSchemeOrder;
import com.hc.lease.order.service.api.LeaseSchemeOrderService;
import com.hc.lease.supplier.adapter.api.LeaseSchemeAdapter;
import com.hc.lease.supplier.model.*;
import com.hc.lease.supplier.service.api.*;
import com.hc.lease.supplier.vo.LeaseSchemePackageVo;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hc.lease.common.core.constant.DictType.TYPE_SCHEMETYPE;
import static com.hc.lease.common.core.constant.DictType.TYPE_STAGING_NUMBER;


/**
 * 融租方案AdapterImpl
 *
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseSchemeAdapter")
public class LeaseSchemeAdapterImpl implements LeaseSchemeAdapter {

    @Autowired
    private LeaseSchemeService leaseSchemeService;
    @Autowired
    private LeaseSchemeCarService leaseSchemeCarService;
    @Autowired
    private LeasePackageService leasePackageService;
    @Autowired
    private LeaseSchemePackageService leaseSchemePackageService;
    @Autowired
    private LeaseDictService leaseDictService;
    @Autowired
    private LeaseCarBrandsService leaseCarBrandsService;
    @Autowired
    private LeaseCarSeriesService leaseCarSeriesService;
    @Autowired
    private LeaseCarModelService leaseCarModelService;
    @Autowired
    private LeaseAreaService leaseAreaService;
    @Autowired
    private LeaseSchemeAreaService leaseSchemeAreaService;
    @Autowired
    private LeaseSchemeVehicleService leaseSchemeVehicleService;
    @Autowired
    private LeaseBranchCompanyService leaseBranchCompanyService;

    @Autowired
    private LeaseSchemeOrderService leaseSchemeOrderService;
    @Autowired
    private LeaseRuleService leaseRuleService;
    @Autowired
    private LeaseCommonService leaseCommonService;
    @Autowired
    private LeaseUseUsedService leaseUseUsedService;
    @Autowired
    private LeasePackageBalancePaymentService leasePackageBalancePaymentService;


    /**
     * 根据名称检测数据是否存在
     *
     * @param name
     * @return
     * @throws GMException
     */
    public boolean checkByNameIsExist(String name, Long id) throws GMException {
        boolean item = false;
        Map params = Maps.newHashMap();
        params.put("name", name);
        params.put("id", id);
        List<LeaseScheme> leaseSchemeList = leaseSchemeService.findByName(params);
        if (leaseSchemeList != null) {
            if (leaseSchemeList.size() > 0) {
                item = true;
            } else {
                item = false;
            }
        } else {
            item = false;
        }
        return item;
    }

    /**
     * 检测数据是否存在
     *
     * @param
     * @return
     * @throws GMException
     */
    public Map<String, Object> checkBySchemeIsExist(Long id) throws GMException {
        List exceptionMessageList = new ArrayList();
        Map<String, Object> backMap = Maps.newHashMap();
        boolean item = false;
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);

        List<LeaseSchemeOrder> leaseSchemeOrderList = leaseSchemeOrderService.findBySchemeId(ids);
        if (leaseSchemeOrderList != null) {
            if (leaseSchemeOrderList.size() > 0) {
                item = true;
                LeaseScheme leaseScheme = leaseSchemeService.selectByPrimaryKey(id);
                Map<String, Object> exceptionMessageMap = Maps.newHashMap();
                exceptionMessageMap = new HashMap<String, Object>();
                exceptionMessageMap.put("message", leaseScheme.getSchemeName());
                exceptionMessageList.add(exceptionMessageMap);
            } else {
                item = false;
            }
        } else {
            item = false;
        }
        backMap.put("isExist", item);
        backMap.put("exceptionMessageList", exceptionMessageList);
        return backMap;
    }

    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        //paramsMap.put("model",MODEL_SCHEME);
        List<LeaseDict> schemeTypes = leaseDictService.findByType(TYPE_SCHEMETYPE);
        List<LeaseCarBrands> leaseCarBrandses = leaseCarBrandsService.findAll(null);
        List<LeaseCarSeries> leaseCarSeries = leaseCarSeriesService.findAll(null);
        List<LeaseCarModel> leaseCarModels = leaseCarModelService.findAll(null);
        List<LeaseArea> leaseAreas = leaseAreaService.findAreaByEnableAndModel(null);
        List<LeaseDict> stagingNumbers = leaseDictService.findByType(TYPE_STAGING_NUMBER);
        List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyService.findAll(null);
        List<LeaseRule> leaseRuleList = leaseRuleService.findAll(null);
        Map<String, Object> map = new HashMap();
        map.put("schemeTypeList", schemeTypes);
        map.put("leaseCarBrandseList", leaseCarBrandses);
        map.put("leaseCarSerieList", leaseCarSeries);
        map.put("leaseCarModelList", leaseCarModels);
        map.put("leaseAreaList", leaseAreas);
        map.put("stagingNumberList", stagingNumbers);
        map.put("leaseBranchCompanyList", leaseBranchCompanyList);
        map.put("leaseRuleList", leaseRuleList);
        return map;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {

        Map<String, Object> isExist = checkBySchemeIsExist(id);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }
        LeaseSchemePackage leaseSchemePackage = leaseSchemePackageService.selectBySchemeId(id);
        leasePackageService.deleteByPrimaryKey(leaseSchemePackage.getPackageId());
        leaseSchemePackageService.deleteByPrimaryKey(leaseSchemePackage.getId());
        leasePackageBalancePaymentService.deleteByPackageId(leaseSchemePackage.getPackageId());
        int row = leaseSchemeService.deleteByPrimaryKey(id);
        int i = leaseUseUsedService.deleteByUse(id, UseType.TYPE_LEASE_SCHEME);
        int row1 = leaseSchemeCarService.deleteBySchemeId(id);
        leaseSchemeVehicleService.deleteBySchemeId(id);
        leaseSchemeAreaService.deleteBySchemeId(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseSchemeService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseScheme record) throws GMException {
        record = leaseSchemeService.insert(record);


        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseScheme record) throws GMException {
        boolean bool = checkByNameIsExist(record.getSchemeName(), record.getId());
        if (bool) {
            throw new GMException(GMExceptionConstant.NAME_REPEAT);
        }
        record = leaseSchemeService.insertSelective(record);

        LeaseSchemeCar leaseSchemeCar = new LeaseSchemeCar();
        /*leaseSchemeCar.setCarId(record.getModelId());*/
        leaseSchemeCar.setSchemeId(record.getId());
        leaseSchemeCarService.insertSelective(leaseSchemeCar);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelectives(LeaseSchemePackageVo record) throws GMException {
        boolean bool = checkByNameIsExist(record.getSchemeName(), record.getId());
        if (bool) {
            throw new GMException(GMExceptionConstant.SCHEME_NAME_REPEAT);
        }
        LeaseScheme leaseScheme = new LeaseScheme();
        leaseScheme.setAreaAll(record.getAreaAll());
        leaseScheme.setCarAll(record.getCarAll());
        leaseScheme.setSchemeName(record.getSchemeName());
        leaseScheme.setSchemeType(record.getSchemeType());
        leaseScheme.setIsEnable(true);
        leaseScheme.setAnnualInterest(record.getAnnualInterest().setScale(2, RoundingMode.HALF_UP));
        leaseScheme.setBranchCompanyId(record.getBranchCompanyId());
        leaseScheme.setCreateBy(record.getCreateBy());
        leaseScheme.setBrandsId(record.getBrandsId());
        leaseScheme.setSeriesId(record.getSeriesId());
        leaseScheme.setModelId(record.getModelId());
        leaseScheme.setTotalAmount(record.getTotalAmount());
        leaseScheme.setIsType(record.getIsType());
        //leaseScheme.setLateInterestRate(record.getLateInterestRate().setScale(2, RoundingMode.HALF_UP));
        leaseScheme = leaseSchemeService.insertSelective(leaseScheme);

        leaseCommonService.insertUseUsed(leaseScheme.getId(), leaseScheme.getSchemeName(), leaseScheme.getBranchCompanyId(), leaseScheme.getBranchCompanyName(), UseType.TYPE_LEASE_SCHEME, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        if (record.getLeaseSchemeAreas().size() > 0) {
            List<LeaseSchemeArea> leaseSchemeAreaList = record.getLeaseSchemeAreas();
            for (LeaseSchemeArea leaseSchemeArea : leaseSchemeAreaList) {
                leaseSchemeArea.setSchemeId(leaseScheme.getId());
                leaseSchemeAreaService.insertSelective(leaseSchemeArea);
            }
        }

        if (record.getLeaseSchemeVehicles().size() > 0) {
            List<LeaseSchemeVehicle> leaseSchemeVehicleList = record.getLeaseSchemeVehicles();
            for (LeaseSchemeVehicle leaseSchemeVehicle : leaseSchemeVehicleList) {
                leaseSchemeVehicle.setSchemeId(leaseScheme.getId());
                leaseSchemeVehicleService.insertSelective(leaseSchemeVehicle);
            }
        }

        LeaseSchemeCar leaseSchemeCar = new LeaseSchemeCar();
       /* leaseSchemeCar.setCarId(record.getModelId());*/
        leaseSchemeCar.setSchemeId(leaseScheme.getId());
        leaseSchemeCarService.insertSelective(leaseSchemeCar);

        LeasePackage leasePackage = new LeasePackage();
        leasePackage.setStagingContainMonthlyRent(record.getStagingContainMonthlyRent());
        leasePackage.setDownPayment(record.getDownPayment());
        leasePackage.setMonthlyRent(record.getMonthlyRent());
        leasePackage.setClientManagerRemarks(record.getClientManagerRemarks());
        //leasePackage.setBalancePayment(record.getBalancePayment());
        leasePackage.setType(0);
        leasePackage.setStagingNumberId(record.getStagingNumberId());
        leasePackage.setCreateBy(record.getCreateBy());
        leasePackage = leasePackageService.insertSelective(leasePackage);

        LeaseSchemePackage leaseSchemePackage = new LeaseSchemePackage();
        leaseSchemePackage.setSchemeId(leaseScheme.getId());
        leaseSchemePackage.setPackageId(leasePackage.getId());
        leaseSchemePackageService.insertSelective(leaseSchemePackage);

        if (record.getLeasePackageBalancePayments().size() > 0) {
         List<LeasePackageBalancePayment> leasePackageBalancePayments=record.getLeasePackageBalancePayments();
            for (LeasePackageBalancePayment leasePackageBalancePayment : leasePackageBalancePayments) {
                leasePackageBalancePayment.setCreateBy(record.getCreateBy());
                leasePackageBalancePayment.setPackageId(leasePackage.getId());
                leasePackageBalancePayment.setSchemeId(leaseScheme.getId());
                leasePackageBalancePayment.setIsType(record.getIsType());
                leasePackageBalancePaymentService.insertSelective(leasePackageBalancePayment);
            }
        }

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }


    public int insertList(List<LeaseScheme> list) throws GMException {
        return 0;
    }


    public int updateByPrimaryKeySelectives(LeaseSchemePackageVo record) throws GMException {
        // int row = leaseSchemeService.updateByPrimaryKeySelective(record);
        boolean bool = checkByNameIsExist(record.getSchemeName(), record.getId());
        if (bool) {
            throw new GMException(GMExceptionConstant.NAME_REPEAT);
        }
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_SCHEME);

        LeaseScheme leaseScheme = new LeaseScheme();
        leaseScheme.setId(record.getId());
        leaseScheme.setAreaAll(record.getAreaAll());
        leaseScheme.setCarAll(record.getCarAll());
        leaseScheme.setSchemeName(record.getSchemeName());
        leaseScheme.setAnnualInterest(record.getAnnualInterest().setScale(2, RoundingMode.HALF_UP));
        //leaseScheme.setLateInterestRate(record.getLateInterestRate().setScale(2, RoundingMode.HALF_UP));
        /*leaseScheme.setSeriesId(record.getSeriesId());*/
        leaseScheme.setIsEnable(true);
        leaseScheme.setSchemeType(record.getSchemeType());
        leaseScheme.setBranchCompanyId(record.getBranchCompanyId());
        leaseScheme.setUpdateBy(record.getUpdateBy());
        leaseScheme.setBrandsId(record.getBrandsId());
        leaseScheme.setSeriesId(record.getSeriesId());
        leaseScheme.setModelId(record.getModelId());
        leaseScheme.setTotalAmount(record.getTotalAmount());
        leaseScheme.setIsType(record.getIsType());
        leaseSchemeService.updateByPrimaryKeySelective(leaseScheme);

        leaseCommonService.insertUseUsed(leaseScheme.getId(), leaseScheme.getSchemeName(), leaseScheme.getBranchCompanyId(), leaseScheme.getBranchCompanyName(), UseType.TYPE_LEASE_SCHEME, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        LeaseSchemeCar leaseSchemeCar = new LeaseSchemeCar();
       /* leaseSchemeCar.setCarId(record.getModelId());*/
        leaseSchemeCar.setSchemeId(leaseScheme.getId());
        leaseSchemeCarService.updateBySchemId(leaseSchemeCar);

        LeaseSchemePackage _leaseSchemePackage = leaseSchemePackageService.selectBySchemeId(leaseScheme.getId());

        LeasePackage leasePackage = new LeasePackage();
        leasePackage.setId(_leaseSchemePackage.getPackageId());


        leasePackage.setDownPayment(record.getDownPayment());
        leasePackage.setMonthlyRent(record.getMonthlyRent());
        leasePackage.setStagingContainMonthlyRent(record.getStagingContainMonthlyRent());
        leasePackage.setClientManagerRemarks(record.getClientManagerRemarks());
        //leasePackage.setBalancePayment(record.getBalancePayment());
        leasePackage.setType(0);
        leasePackage.setStagingNumberId(record.getStagingNumberId());
        leasePackage.setUpdateBy(record.getUpdateBy());
        int row = leasePackageService.updateByPrimaryKeySelective(leasePackage);

        leaseSchemeAreaService.deleteBySchemeId(record.getId());
        leaseSchemeVehicleService.deleteBySchemeId(record.getId());
        leasePackageBalancePaymentService.deleteByPackageId(_leaseSchemePackage.getPackageId());
        if (record.getLeaseSchemeAreas().size() > 0) {
            List<LeaseSchemeArea> leaseSchemeAreaList = record.getLeaseSchemeAreas();
            for (LeaseSchemeArea leaseSchemeArea : leaseSchemeAreaList) {
                leaseSchemeArea.setSchemeId(leaseScheme.getId());
                leaseSchemeAreaService.insertSelective(leaseSchemeArea);
            }
        }
        if (record.getLeaseSchemeVehicles().size() > 0) {
            List<LeaseSchemeVehicle> leaseSchemeVehicleList = record.getLeaseSchemeVehicles();
            for (LeaseSchemeVehicle leaseSchemeVehicle : leaseSchemeVehicleList) {
                leaseSchemeVehicle.setSchemeId(leaseScheme.getId());
                leaseSchemeVehicleService.insertSelective(leaseSchemeVehicle);
            }
        }

        if (record.getLeasePackageBalancePayments().size() > 0) {
            List<LeasePackageBalancePayment> leasePackageBalancePayments=record.getLeasePackageBalancePayments();
            for (LeasePackageBalancePayment leasePackageBalancePayment : leasePackageBalancePayments) {
                leasePackageBalancePayment.setCreateBy(record.getCreateBy());
                leasePackageBalancePayment.setPackageId(_leaseSchemePackage.getPackageId());
                leasePackageBalancePayment.setSchemeId(leaseScheme.getId());
                leasePackageBalancePayment.setIsType(record.getIsType());
                leasePackageBalancePaymentService.insertSelective(leasePackageBalancePayment);
            }
        }

        return row;
    }

    public int updateByPrimaryKey(LeaseScheme record) throws GMException {
        int row = leaseSchemeService.updateByPrimaryKey(record);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseScheme entity) throws GMException {
        return 0;
    }

   /* public int updateByPrimaryKeySelective(List<LeaseScheme> record) throws GMException {
        int row = leaseSchemeService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(List<LeaseScheme> record) throws GMException {
        int row = leaseSchemeService.updateByPrimaryKey(record);
        return row;
    }*/

    public LeaseScheme selectByPrimaryKey(Long id) throws GMException {
        LeaseScheme leaseScheme = leaseSchemeService.selectByPrimaryKey(id);
        return leaseScheme;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseScheme> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseScheme> page = leaseSchemeService.findPage(pageNum, pageSize, paramsMap);

        return page;
    }

    public List<LeaseScheme> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseScheme> leaseSchemeList = leaseSchemeService.findAll(paramsMap);
        return leaseSchemeList;
    }

}
