package com.hc.lease.supplier.adapter.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.model.*;
import com.hc.lease.baseInfo.service.api.*;
import com.hc.lease.common.core.constant.UseType;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.excel.poi.vo.CarImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseCarTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.common.core.file.UploadFileUtil;
import com.hc.lease.common.core.file.UploadService;
import com.hc.lease.supplier.adapter.api.LeaseCarAdapter;
import com.hc.lease.supplier.model.*;
import com.hc.lease.supplier.service.api.*;
import com.hc.lease.supplier.vo.LeaseCarExport;
import hc.lease.common.util.ListUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import static com.hc.lease.common.core.constant.DictType.*;

/**
 * 车辆信息AdapterImpl
 *
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseCarAdapter")
public class LeaseCarAdapterImpl implements LeaseCarAdapter {

    @Autowired
    private LeaseCarService leaseCarService;
    @Autowired
    private LeaseCarInsuranceService leaseCarInsuranceService;
    @Autowired
    private LeaseCarColorService leaseCarColorService;
    @Autowired
    private LeaseDictService leaseDictService;
    @Autowired
    private LeaseGpsSupplierService leaseGpsSupplierService;
    @Autowired
    private LeasePurchaseContractService leasePurchaseContractService;
    @Autowired
    private LeaseBranchCompanyService leaseBranchCompanyService;
    @Autowired
    private LeaseCarBuyFinancingerService leaseCarBuyFinancingerService;
    @Autowired
    private LeaseStorehouseService leaseStorehouseService;
    @Autowired
    private LeaseDealerService leaseDealerService;
    @Autowired
    private LeaseCarSupplierService leaseCarSupplierService;
    @Autowired
    private LeaseRuleService leaseRuleService;
    @Autowired
    private LeaseInsuranceCompanyService leaseInsuranceCompanyService;
    @Autowired
    private LeaseCompanyHeaderService leaseCompanyHeaderService;
    @Autowired
    private LeaseCarDictAccessoryService leaseCarDictAccessoryService;
    @Autowired
    private LeaseCarBrandsService leaseCarBrandsService;
    @Autowired
    private LeaseCarModelService leaseCarModelService;
    @Autowired
    private LeaseCarSeriesService leaseCarSeriesService;
    @Autowired
    private LeaseSchemeService leaseSchemeService;
    @Autowired
    private LeaseCommonService leaseCommonService;
    @Autowired
    private LeaseUseUsedService leaseUseUsedService;
    @Autowired
    private LeaseCarModelColorService leaseCarModelColorService;
    @Autowired
    private LeaseInsuranceTypeService leaseInsuranceTypeService;
    @Autowired
    private LeaseSchemeCarFinancingerService leaseSchemeCarFinancingerService;

    @Value("${img.url}")
    String imgUrl;

    @Value("${img.maxSize}")
    private String maxSize;//文件大小限制范围

    @Value("${img.fileImgFolder}")
    private String fileImgFolder;//图片存放文件夹路径根目录

    @Value("${supplier.img.fileImgFolder}")
    private String supplierFileImgFolder;//图片存放文件夹路径


    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarModelColor> leaseCarModelColorList = leaseCarModelColorService.selectColor();
        List<LeaseDict> leaseDictList = leaseDictService.findByType(TYPE_CARACCESSORY);
        List<LeaseGpsSupplier> leaseGpsSupplierList = leaseGpsSupplierService.findAll(null);
        List<LeasePurchaseContract> leasePurchaseContractList = leasePurchaseContractService.selectByLeaseCar(null);
        List<LeaseDict> leaseMortgageTypeList = leaseDictService.findByType(TYPE_MORTGAGETYPE);
        List<LeaseDict> leaseBuyCardCapitalTypeList = leaseDictService.findByType(TYPE_BUYCARDCAPITALTYPE);
        List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyService.findAll(null);
        List<LeaseCarBuyFinancinger> leaseCarBuyFinancingerList = leaseCarBuyFinancingerService.findAll(null);
        List<LeaseDealer> leaseDealerList = leaseDealerService.findAll(null);
        List<LeaseCarSupplier> leaseCarSupplierList = leaseCarSupplierService.findAll(null);//车辆供应商
        List<LeaseRule> leaseRules = leaseRuleService.findAll(null);
        List<LeaseInsuranceCompany> leaseInsuranceCompanyList = leaseInsuranceCompanyService.findAll(null);
        List<LeaseCompanyHeader> leaseCompanyHeaderList = leaseCompanyHeaderService.findAll(null);
        List<LeaseInsuranceType> insuranceTypeList = leaseInsuranceTypeService.findAll(null);

        List<LeaseCarColor> leaseCarColorList = leaseCarColorService.insertViewParames(paramsMap);

        //公司仓库
        Map<String, Object> company = Maps.newHashMap();
        company.put("belongType", 0);
        List<LeaseStorehouse> leaseCompanyStorehouseList = leaseStorehouseService.findAll(company);
        Map<String, Object> dealer = Maps.newHashMap();
        dealer.put("belongType", 1);
        List<LeaseStorehouse> leaseDealerStorehouseList = leaseStorehouseService.findAll(dealer);

        Map<String, Object> dealerTwo = Maps.newHashMap();
        dealerTwo.put("belongType", 2);
        List<LeaseStorehouse> leaseTwoDealerStorehouseList = leaseStorehouseService.findAll(dealerTwo);

        //预览计算器初始化
        List<LeaseCarBrands> leaseCarBrandses = leaseCarBrandsService.findAll(null);
        List<LeaseCarSeries> leaseCarSeries = leaseCarSeriesService.findAll(null);
        List<LeaseCarModel> leaseCarModels = leaseCarModelService.findAll(null);
        List<LeaseScheme> leaseSchemeList = leaseSchemeService.findAllNoPage();
        Map<String, Object> map = Maps.newHashMap();
        map.put("leaseCarModelColorList", leaseCarModelColorList);
        map.put("leaseCarBrandseList", leaseCarBrandses);
        map.put("leaseCarSerieList", leaseCarSeries);
        map.put("leaseCarModelList", leaseCarModels);
        map.put("leaseSchemeList", leaseSchemeList);
        map.put("leaseCarAccessoryList", leaseDictList);
        map.put("leaseGpsSupplierList", leaseGpsSupplierList);
        map.put("leasePurchaseContractList", leasePurchaseContractList);
        map.put("leaseMortgageTypeList", leaseMortgageTypeList);
        map.put("leaseBuyCardCapitalTypeList", leaseBuyCardCapitalTypeList);
        map.put("leaseBranchCompanyList", leaseBranchCompanyList);
        map.put("leaseCarBuyFinancingerList", leaseCarBuyFinancingerList);
        map.put("leaseCompanyStorehouseList", leaseCompanyStorehouseList);
        map.put("leaseDealerStorehouseList", leaseDealerStorehouseList);
        map.put("leaseTwoDealerStorehouseList", leaseTwoDealerStorehouseList);
        map.put("leaseDealerList", leaseDealerList);
        map.put("leaseCarSupplierList", leaseCarSupplierList);
        map.put("leaseRuleList", leaseRules);
        map.put("leaseInsuranceCompanyList", leaseInsuranceCompanyList);
        map.put("leaseCompanyHeaderList", leaseCompanyHeaderList);
        map.put("leaseInsuranceTypeList", insuranceTypeList);
        map.put("leaseCarColorList", leaseCarColorList);
        return map;
    }

    /**
     * 列表页面 需要的初始化参数
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public Map<String, Object> insertViewParamesListPage(Map<String, Object> paramsMap) throws GMException {
        List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyService.findAll(null);//分公司
        List<LeaseCarSupplier> leaseCarSupplierList = leaseCarSupplierService.findAll(null);//车辆供应商
        List<LeaseCarBrands> leaseCarBrandses = leaseCarBrandsService.findAll(null);//品牌
        List<LeaseCarSeries> leaseCarSeries = leaseCarSeriesService.findAll(null);//系列
        List<LeaseCarModel> leaseCarModels = leaseCarModelService.findAll(null);//车型
        Map<String, Object> map = Maps.newHashMap();
        map.put("leaseBranchCompanyList", leaseBranchCompanyList);//分公司
        map.put("leaseCarSupplierList", leaseCarSupplierList);//车辆供应商
        map.put("leaseCarBrandseList", leaseCarBrandses);//品牌
        map.put("leaseCarSerieList", leaseCarSeries);//系列
        map.put("leaseCarModelList", leaseCarModels);//车型
        return map;
    }

    /**
     * 检测数据是否存在
     *
     * @param paramsKey
     * @param paramsValue
     * @param id
     * @return
     * @throws GMException
     */
    public boolean checkByParams(String paramsKey, String paramsValue, Long id) throws GMException {
        boolean item = false;
        Map params = Maps.newHashMap();
        params.put(paramsKey, paramsValue);
        params.put("id", id);
        List<LeaseCar> leasCarList = leaseCarService.findByParams(params);
        if (leasCarList != null) {
            if (leasCarList.size() > 0) {
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
     * @param id
     * @return
     * @throws GMException
     */
    public Map<String, Object> checkByCarIsExist(Long id) throws GMException {
        List exceptionMessageList = new ArrayList();
        Map<String, Object> backMap = Maps.newHashMap();
        boolean item = false;
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("usedId", id);
        paramsMap.put("usedType", UsedType.TYPE_LEASE_CAR);
        List<LeaseUseUsed> leaseUseUsedList = leaseCommonService.selectByUsed(paramsMap);
        //List<LeaseCar> leaseCarList = leaseCarService.findByGpsSupplierId(ids);
        if (leaseUseUsedList != null) {
            if (leaseUseUsedList.size() > 0) {
                item = true;
                LeaseCar leaseCar = leaseCarService.selectByPrimaryKey(id);
                Map<String, Object> exceptionMessageMap = Maps.newHashMap();
                exceptionMessageMap = new HashMap<String, Object>();
                exceptionMessageMap.put("message", leaseCar.getPlateNumber());
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

    public List<LeaseCar> selectAllCarNoPage(Map<String, Object> paramsMap) {
        List<LeaseCar> leaseCarList = leaseCarService.selectAllCarNoPage(paramsMap);

        return leaseCarList;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        Map<String, Object> isExist = checkByCarIsExist(id);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }
        leaseCarDictAccessoryService.deleteByCarId(id);
        leaseCarInsuranceService.deleteByCarId(id);
        leaseUseUsedService.deleteByUse(id, UseType.TYPE_LEASE_CAR);
        int row = leaseCarService.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseCarService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseCar record) throws GMException {

        //检测车牌号是否存在
        if (StringUtils.isNotEmpty(record.getPlateNumber())) {
            boolean plateNumberIsExist = checkByParams("plateNumber", record.getPlateNumber(), record.getId());
            if (plateNumberIsExist) {
                throw new GMException(GMExceptionConstant.PLATENUMBER_REPEAT);
            }
        }

        //检测发动机号是否存在
        boolean engineNumberIsExist = checkByParams("engineNumber", record.getEngineNumber(), record.getId());
        if (engineNumberIsExist) {
            throw new GMException(GMExceptionConstant.ENGINENUMBER_REPEAT);
        }

        //检测车架号是否存在
        boolean cardFrameNumberIsExist = checkByParams("cardFrameNumber", record.getCardFrameNumber(), record.getId());
        if (cardFrameNumberIsExist) {
            throw new GMException(GMExceptionConstant.CARDFRAMENUMBER_REPEAT);
        }

        record = leaseCarService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), null, record.getModelId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_CAR_MODEL);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), null, record.getCarBuyFinancingerId(), record.getCarBuyFinancingerName(), UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_CAR_BUY_FINANCINGER);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), null, record.getDealerId(), record.getDealerName(), UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_DEALER);

        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    /**
     * 新增车辆
     *
     * @param record
     * @return
     * @throws GMException
     */
    public ResultHashMap insertSelective(LeaseCar record) throws GMException {

        //检测车牌号是否存在
        if (StringUtils.isNotEmpty(record.getPlateNumber())) {
            boolean plateNumberIsExist = checkByParams("plateNumber", record.getPlateNumber(), record.getId());
            if (plateNumberIsExist) {
                Map backMap = Maps.newHashMap();
                backMap.put("key", "plateNumber");
                throw new GMException(GMExceptionConstant.PLATENUMBER_REPEAT, backMap);
            }
        }
        //检测车牌号是否存在

        //检测发动机号是否存在
        boolean engineNumberIsExist = checkByParams("engineNumber", record.getEngineNumber(), record.getId());
        if (engineNumberIsExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "engineNumber");
            throw new GMException(GMExceptionConstant.ENGINENUMBER_REPEAT, backMap);
        }
        //检测发动机号是否存在

        //检测车架号是否存在
        boolean cardFrameNumberIsExist = checkByParams("cardFrameNumber", record.getCardFrameNumber(), record.getId());
        if (cardFrameNumberIsExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "cardFrameNumber");
            throw new GMException(GMExceptionConstant.CARDFRAMENUMBER_REPEAT, backMap);
        }
        //检测车架号是否存在

        if (record.getRegistrationNumberImgs().size() > 0) {
            String filePath = UploadFileUtil.dualImgs(record.getRegistrationNumberImgs(), maxSize, fileImgFolder, supplierFileImgFolder, imgUrl);
            record.setRegistrationNumberImg(filePath);
        }
        record = leaseCarService.insertSelective(record);

        //车辆-购车融资方 （一对多）
        LeaseSchemeCarFinancinger leaseSchemeCarFinancinger = new LeaseSchemeCarFinancinger();
        leaseSchemeCarFinancinger.setCarId(record.getId());
        leaseSchemeCarFinancinger.setCarBuyFinancingerId(record.getCarBuyFinancingerId());
        leaseSchemeCarFinancinger.setIsEnable(true);
        leaseSchemeCarFinancingerService.insertSelective(leaseSchemeCarFinancinger);
        //车辆-购车融资方 （一对多）

        //车辆保险信息
        List<LeaseCarInsurance> laseCarInsurances = record.getLaseCarInsurances();
        if (laseCarInsurances != null && laseCarInsurances.size() > 0) {
            for (LeaseCarInsurance laseCarInsurance : laseCarInsurances) {
                laseCarInsurance.setCarId(record.getId());
                /*if (laseCarInsurance.getPolicyScannerImgs().size() > 0) {
                    String filePath = UploadFileUtil.dualImgs(laseCarInsurance.getPolicyScannerImgs(), maxSize, fileImgFolder, supplierFileImgFolder, imgUrl);
                    laseCarInsurance.setPolicyScannerImg(filePath);
                }*/
                LeaseCarInsurance carInsurance = leaseCarInsuranceService.insertSelective(laseCarInsurance);
                leaseCommonService.insertUseUsed(record.getId(), null, carInsurance.getInsuranceCompanyId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_INSURANCE_COMPANY);
                leaseCommonService.insertUseUsed(record.getId(), null, carInsurance.getInsuranceTypeId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_INSURANCE_TYPE);
            }
        }
        //车辆保险信息

        //车辆信息-车辆-随车物料
        List<LeaseCarDictAccessory> leaseCarDictAccessories = record.getLeaseCarDictAccessories();
        if (leaseCarDictAccessories.size() > 0) {
            for (LeaseCarDictAccessory leaseCarDictAccessory : leaseCarDictAccessories) {
                leaseCarDictAccessory.setCarId(record.getId());
                LeaseCarDictAccessory carDictAccessory = leaseCarDictAccessoryService.insertSelective(leaseCarDictAccessory);
            }
        }
        //车辆信息-车辆-随车物料

        Object object = ListUtil.objectIsNullToMap(null);
        //插入使用和被使用的数据/车型
        leaseCommonService.insertUseUsed(record.getId(), null, record.getModelId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_CAR_MODEL);
        //插入使用和被使用的数据/购车融资方
        leaseCommonService.insertUseUsed(record.getId(), null, record.getCarBuyFinancingerId(), record.getCarBuyFinancingerName(), UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_CAR_BUY_FINANCINGER);
        //插入使用和被使用的数据/经销商
        leaseCommonService.insertUseUsed(record.getId(), null, record.getDealerId(), record.getDealerName(), UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_DEALER);
        //插入使用和被使用的数据/分公司
        leaseCommonService.insertUseUsed(record.getId(), null, record.getBranchCompanyId(), record.getBranchCompanyName(), UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_BRANCH_COMPANY);
        //插入使用和被使用的数据/采购合同
        leaseCommonService.insertUseUsed(record.getId(), null, record.getContractId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_PURCHASE_CONTRACT);
        //插入使用和被使用的数据/颜色
        leaseCommonService.insertUseUsed(record.getId(), null, record.getColorId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_CAR_COLOR);
        //插入使用和被使用的数据/GPS供应商
        leaseCommonService.insertUseUsed(record.getId(), null, record.getGpsSupplierId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_GPS_SUPPLIER);
        //插入使用和被使用的数据/仓库
        leaseCommonService.insertUseUsed(record.getId(), null, record.getStorehouseId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_STOREHOUSE);
        //插入使用和被使用的数据/合同方
        leaseCommonService.insertUseUsed(record.getId(), null, record.getBelongerCompanyHeaderId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_COMPANY_HEADER);

        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int insertList(List<LeaseCar> list) throws GMException {
        return 0;
    }

   /* public int insert(List<LeaseCar> record) throws GMException {
        int row = leaseCarService.insert(record);
        return row;
    }

    public int insertSelective(List<LeaseCar> record) throws GMException {
        int row = leaseCarService.insertSelective(record);
        return row;
    }*/

    public int updateByPrimaryKeySelective(LeaseCar record) throws GMException {

        //检测车牌号是否存在
        if (StringUtils.isNotEmpty(record.getPlateNumber())) {
            boolean plateNumberIsExist = checkByParams("plateNumber", record.getPlateNumber(), record.getId());
            if (plateNumberIsExist) {
                Map backMap = Maps.newHashMap();
                backMap.put("key", "plateNumber");
                throw new GMException(GMExceptionConstant.PLATENUMBER_REPEAT, backMap);
            }
        }
        //检测发动机号是否存在
        boolean engineNumberIsExist = checkByParams("engineNumber", record.getEngineNumber(), record.getId());
        if (engineNumberIsExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "engineNumber");
            throw new GMException(GMExceptionConstant.ENGINENUMBER_REPEAT, backMap);
        }

        //检测车架号是否存在
        boolean cardFrameNumberIsExist = checkByParams("cardFrameNumber", record.getCardFrameNumber(), record.getId());
        if (cardFrameNumberIsExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "cardFrameNumber");
            throw new GMException(GMExceptionConstant.CARDFRAMENUMBER_REPEAT, backMap);
        }
        if (record.getRegistrationNumberImgs().size() > 0) {
            String filePath = UploadFileUtil.dualImgs(record.getRegistrationNumberImgs(), maxSize, fileImgFolder, supplierFileImgFolder, imgUrl);
            record.setRegistrationNumberImg(filePath);
        }

        int row = leaseCarService.updateByPrimaryKeySelective(record);

        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_CAR);
        //先删除保险信息
        leaseCarInsuranceService.deleteByCarId(record.getId());
        //保险信息
        List<LeaseCarInsurance> laseCarInsurances = record.getLaseCarInsurances();
        if (laseCarInsurances.size() > 0) {
            for (LeaseCarInsurance laseCarInsurance : laseCarInsurances) {
                laseCarInsurance.setCarId(record.getId());
               /* if (laseCarInsurance.getPolicyScannerImgs().size() > 0) {
                    String filePath = UploadFileUtil.dualImgs(laseCarInsurance.getPolicyScannerImgs(), maxSize, fileImgFolder, supplierFileImgFolder, imgUrl);
                    laseCarInsurance.setPolicyScannerImg(filePath);
                }*/
                LeaseCarInsurance carInsurance = leaseCarInsuranceService.insertSelective(laseCarInsurance);
                leaseCommonService.insertUseUsed(record.getId(), null, carInsurance.getInsuranceCompanyId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_INSURANCE_COMPANY);
                leaseCommonService.insertUseUsed(record.getId(), null, carInsurance.getInsuranceTypeId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_INSURANCE_TYPE);
            }
        }

        leaseCarDictAccessoryService.deleteByCarId(record.getId());
        List<LeaseCarDictAccessory> leaseCarDictAccessories = record.getLeaseCarDictAccessories();
        if (leaseCarDictAccessories.size() > 0) {
            for (LeaseCarDictAccessory leaseCarDictAccessory : leaseCarDictAccessories) {
                leaseCarDictAccessory.setCarId(record.getId());
                leaseCarDictAccessoryService.insertSelective(leaseCarDictAccessory);
            }
        }

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), null, record.getModelId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_CAR_MODEL);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), null, record.getCarBuyFinancingerId(), record.getCarBuyFinancingerName(), UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_CAR_BUY_FINANCINGER);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), null, record.getDealerId(), record.getDealerName(), UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_DEALER);

        leaseCommonService.insertUseUsed(record.getId(), null, record.getBranchCompanyId(), record.getBranchCompanyName(), UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_BRANCH_COMPANY);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getContractId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_PURCHASE_CONTRACT);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getColorId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_CAR_COLOR);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getGpsSupplierId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_GPS_SUPPLIER);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getStorehouseId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_STOREHOUSE);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getBelongerCompanyHeaderId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_COMPANY_HEADER);

        return row;
    }

    /**
     * 修改车辆
     *
     * @param record
     * @return
     * @throws GMException
     */
    public int updateByPrimaryKey(LeaseCar record) throws GMException {

        //检测车牌号是否存在
        if (StringUtils.isNotEmpty(record.getPlateNumber())) {
            boolean plateNumberIsExist = checkByParams("plateNumber", record.getPlateNumber(), record.getId());
            if (plateNumberIsExist) {
                Map backMap = Maps.newHashMap();
                backMap.put("key", "plateNumber");
                throw new GMException(GMExceptionConstant.PLATENUMBER_REPEAT, backMap);
            }
        }
        //检测发动机号是否存在
        boolean engineNumberIsExist = checkByParams("engineNumber", record.getEngineNumber(), record.getId());
        if (engineNumberIsExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "engineNumber");
            throw new GMException(GMExceptionConstant.ENGINENUMBER_REPEAT, backMap);
        }

        //检测车架号是否存在
        boolean cardFrameNumberIsExist = checkByParams("cardFrameNumber", record.getCardFrameNumber(), record.getId());
        if (cardFrameNumberIsExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "cardFrameNumber");
            throw new GMException(GMExceptionConstant.CARDFRAMENUMBER_REPEAT, backMap);
        }

        List<LeaseSchemeCarFinancinger> leaseSchemeCarFinancinger = leaseSchemeCarFinancingerService.findByCarId(record.getId());
        int carSize = leaseSchemeCarFinancinger.size();
        int i = 0;
        for (LeaseSchemeCarFinancinger schemeCarFinancinger : leaseSchemeCarFinancinger) {
            if (schemeCarFinancinger.getCarBuyFinancingerId() != record.getCarBuyFinancingerId()) {
                i++;
            }
        }
        if (carSize == i) {
            for (LeaseSchemeCarFinancinger schemeCarFinancinger : leaseSchemeCarFinancinger) {
                //修改原来的融资方为不启用
                LeaseSchemeCarFinancinger leaseSchemeFinancinger = new LeaseSchemeCarFinancinger();
                leaseSchemeFinancinger.setIsEnable(false);
                leaseSchemeFinancinger.setId(schemeCarFinancinger.getId());
                leaseSchemeCarFinancingerService.updateByPrimaryKeySelective(leaseSchemeFinancinger);
            }
            //车辆与融资方 （一对多）
            LeaseSchemeCarFinancinger _leaseSchemeCarFinancinger = new LeaseSchemeCarFinancinger();
            _leaseSchemeCarFinancinger.setCarId(record.getId());
            _leaseSchemeCarFinancinger.setCarBuyFinancingerId(record.getCarBuyFinancingerId());
            _leaseSchemeCarFinancinger.setIsEnable(true);
            leaseSchemeCarFinancingerService.insertSelective(_leaseSchemeCarFinancinger);
        }

        if (record.getRegistrationNumberImgs().size() > 0) {
            String filePath = UploadFileUtil.dualImgs(record.getRegistrationNumberImgs(), maxSize, fileImgFolder, supplierFileImgFolder, imgUrl);
            record.setRegistrationNumberImg(filePath);
        }

        int row = leaseCarService.updateByPrimaryKey(record);

        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_CAR);

        //先删除保险信息
        leaseCarInsuranceService.deleteByCarId(record.getId());
        //保险信息
        List<LeaseCarInsurance> laseCarInsurances = record.getLaseCarInsurances();
        if (laseCarInsurances.size() > 0) {
            for (LeaseCarInsurance laseCarInsurance : laseCarInsurances) {
                laseCarInsurance.setCarId(record.getId());
               /* if (laseCarInsurance.getPolicyScannerImgs().size() > 0) {
                    String filePath = UploadFileUtil.dualImgs(laseCarInsurance.getPolicyScannerImgs(), maxSize, fileImgFolder, supplierFileImgFolder, imgUrl);
                    laseCarInsurance.setPolicyScannerImg(filePath);
                }*/
                LeaseCarInsurance carInsurance = leaseCarInsuranceService.insertSelective(laseCarInsurance);
                leaseCommonService.insertUseUsed(record.getId(), null, carInsurance.getInsuranceCompanyId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_INSURANCE_COMPANY);
                leaseCommonService.insertUseUsed(record.getId(), null, carInsurance.getInsuranceTypeId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_INSURANCE_TYPE);
            }
        }

        leaseCarDictAccessoryService.deleteByCarId(record.getId());
        List<LeaseCarDictAccessory> leaseCarDictAccessories = record.getLeaseCarDictAccessories();
        if (leaseCarDictAccessories.size() > 0) {
            for (LeaseCarDictAccessory leaseCarDictAccessory : leaseCarDictAccessories) {
                leaseCarDictAccessory.setCarId(record.getId());
                leaseCarDictAccessoryService.insertSelective(leaseCarDictAccessory);
            }
        }

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), null, record.getModelId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_CAR_MODEL);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), null, record.getCarBuyFinancingerId(), record.getCarBuyFinancingerName(), UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_CAR_BUY_FINANCINGER);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), null, record.getDealerId(), record.getDealerName(), UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_DEALER);

        leaseCommonService.insertUseUsed(record.getId(), null, record.getBranchCompanyId(), record.getBranchCompanyName(), UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_BRANCH_COMPANY);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getContractId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_PURCHASE_CONTRACT);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getColorId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_CAR_COLOR);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getGpsSupplierId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_GPS_SUPPLIER);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getStorehouseId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_STOREHOUSE);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getBelongerCompanyHeaderId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_COMPANY_HEADER);

        return row;
    }


    public LeaseCar selectByPrimaryKey(Long id) throws GMException {
        LeaseCar leaseCar = leaseCarService.selectByPrimaryKey(id);
        return leaseCar;

    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseCar> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        //paramsMap.put("imgUrl", imgUrl);
        PageInfo<LeaseCar> page = leaseCarService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseCar> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCar> leaseCarList = leaseCarService.findAll(paramsMap);
        return leaseCarList;
    }

    /**
     * 车辆数据导入
     * 检测车牌号、检测发动机号、检测车架号存在则修改
     * 检测车牌号、检测发动机号、检测车架号不存在则新增
     *
     * @param leaseCarTemplateList
     * @param userSession
     * @return
     * @throws GMException
     */
    @Override
    public CarImportExcelBackInfo importExcelCar(List<LeaseCarTemplate> leaseCarTemplateList, UserSession userSession) throws GMException {
        userSession = new UserSession();
        userSession.setUserId(1l);
        CarImportExcelBackInfo carImportExcelBackInfo = null;
        if (leaseCarTemplateList != null) {
            if (leaseCarTemplateList.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                List<Map> backInfoList = new ArrayList<Map>();
                for (int i = 0; i < leaseCarTemplateList.size(); i++) {
                    LeaseCarTemplate leaseCarTemplate = leaseCarTemplateList.get(i);

                    boolean plateNumberIsExist = checkByParams("plateNumber", leaseCarTemplate.getPlateNumber(), null);
                    boolean engineNumberIsExist = checkByParams("engineNumber", leaseCarTemplate.getEngineNumber(), null);
                    boolean cardFrameNumberIsExist = checkByParams("cardFrameNumber", leaseCarTemplate.getCardFrameNumber(), null);

                    String purchaseContractNnumber = leaseCarTemplate.getPurchaseContractNnumber();//采购合同编号
                    String carSupplierName = leaseCarTemplate.getCarSupplierName();//供应商名称
                    String supplierinternalNumber = leaseCarTemplate.getSupplierinternalNumber();//供应商编号
                    String companyHeaderName = leaseCarTemplate.getCompanyHeaderName();//公司合同方名称
                    String carBrandsName = leaseCarTemplate.getCarBrandsName();//品牌名称
                    String carSeriesName = leaseCarTemplate.getCarSeriesName();//系列名称
                    String carModelName = leaseCarTemplate.getCarModelName();//车型名称
                    String carColorName = leaseCarTemplate.getCarColorName();//颜色名称
                    String engineNumber = leaseCarTemplate.getEngineNumber();//发动机号
                    String cardFrameNumber = leaseCarTemplate.getCardFrameNumber();//车架号
                    String branchCompanyName = leaseCarTemplate.getBranchCompanyName();//所属分公司
                    Date manufactureTime = leaseCarTemplate.getManufactureTime();//出厂日期
                    String certificateNumber = leaseCarTemplate.getCertificateNumber();//合格证号
                    String plateNumber = leaseCarTemplate.getPlateNumber();//车牌号
                    String invoicedCarPrice = leaseCarTemplate.getInvoicedCarPrice();//车辆含税价/采购合同价
                    String marketPrice = leaseCarTemplate.getMarketPrice();

                    System.out.println("*****************prices" + marketPrice);
                    //String belongerCompanyHeaderName = leaseCarTemplate.getBelongerCompanyHeaderName();//所有人
                    Date inStorehouseTime = leaseCarTemplate.getInStorehouseTime();//入库日期
                    //String gpsSupplierName = leaseCarTemplate.getGpsSupplierName();//GPS供应商

                    if (StringUtils.isBlank(purchaseContractNnumber) || StringUtils.isBlank(carSupplierName)
                            || StringUtils.isBlank(supplierinternalNumber)
                            || StringUtils.isBlank(companyHeaderName) || StringUtils.isBlank(carBrandsName)
                            || StringUtils.isBlank(carSeriesName) || StringUtils.isBlank(carModelName)
                            || StringUtils.isBlank(carColorName)
                            || StringUtils.isBlank(engineNumber) || StringUtils.isBlank(cardFrameNumber)
                            || StringUtils.isBlank(branchCompanyName) || manufactureTime == null
                            || StringUtils.isBlank(certificateNumber) || StringUtils.isBlank(invoicedCarPrice)
                            || StringUtils.isBlank(plateNumber)
                            /*|| StringUtils.isBlank(belongerCompanyHeaderName)*/
                            || inStorehouseTime == null
                            /*|| StringUtils.isBlank(gpsSupplierName)*/
                            ) {
                        leaseCarTemplate.setUpdateState("失败，缺少必填项");
                        failNum++;
                        continue;
                    }

                    if (engineNumberIsExist) { //检测发动机号是否存在
                        Map params = Maps.newHashMap();
                        params.put("engineNumber", leaseCarTemplate.getEngineNumber());
                        params.put("id", null);
                        List<LeaseCar> leasCarList = leaseCarService.findByParams(params);
                        for (int j = 0; j < leasCarList.size(); j++) {
                            LeaseCar leaseCar = leasCarList.get(j);
                            dualUpdateCarImportExcel(leaseCarTemplate, userSession, leaseCar);//处理车辆数据导入/修改
                        }
                    } else if (cardFrameNumberIsExist) {//检测车架号是否存在
                        Map params = Maps.newHashMap();
                        params.put("cardFrameNumber", leaseCarTemplate.getCardFrameNumber());
                        params.put("id", null);
                        List<LeaseCar> leasCarList = leaseCarService.findByParams(params);
                        for (int j = 0; j < leasCarList.size(); j++) {
                            LeaseCar leaseCar = leasCarList.get(j);
                            dualUpdateCarImportExcel(leaseCarTemplate, userSession, leaseCar);//处理车辆数据导入/修改
                        }
                    } else {
                        dualInsertCarImportExcel(leaseCarTemplate, userSession);//处理车辆数据导入/新增
                    }

                    successNum++;
                    leaseCarTemplate.setUpdateState("成功");

                }

                carImportExcelBackInfo = new CarImportExcelBackInfo();
                carImportExcelBackInfo.setFailNum(failNum);//失败数量
                carImportExcelBackInfo.setSuccessNum(successNum);//成功数量
                carImportExcelBackInfo.setBackInfo(backInfoList);//反馈信息
                carImportExcelBackInfo.setLeaseCarTemplateList(leaseCarTemplateList);
            }
        }

        return carImportExcelBackInfo;
    }

    /**
     * 处理车辆数据导入/新增
     *
     * @param leaseCarTemplate Excel导入的车辆数据
     * @return
     * @throws GMException
     */
    public boolean dualInsertCarImportExcel(LeaseCarTemplate leaseCarTemplate, UserSession userSession) throws GMException {

        String purchaseContractNnumber = leaseCarTemplate.getPurchaseContractNnumber();//采购合同编号
        String parBuyFinancingerName = leaseCarTemplate.getCarBuyFinancingerName();//融资方名称
        String carSupplierName = leaseCarTemplate.getCarSupplierName();//供应商名称
        String supplierinternalNumber = leaseCarTemplate.getSupplierinternalNumber();//供应商编号
        String companyHeaderName = leaseCarTemplate.getCompanyHeaderName();//公司合同方名称
        String carBrandsName = leaseCarTemplate.getCarBrandsName();//品牌名称
        String carSeriesName = leaseCarTemplate.getCarSeriesName();//系列名称
        String carModelName = leaseCarTemplate.getCarModelName();//车型名称
        String carColorName = leaseCarTemplate.getCarColorName();//颜色名称
        String engineNumber = leaseCarTemplate.getEngineNumber();//发动机号
        String cardFrameNumber = leaseCarTemplate.getCardFrameNumber();//车架号
        String branchCompanyName = leaseCarTemplate.getBranchCompanyName();//所属分公司
        Date manufactureTime = leaseCarTemplate.getManufactureTime();//出厂日期
        String certificateNumber = leaseCarTemplate.getCertificateNumber();//合格证号
        String plateNumber = leaseCarTemplate.getPlateNumber();//车牌号
        String invoicedCarPrice = leaseCarTemplate.getInvoicedCarPrice();//车辆含税价/采购合同价
        String marketPrice = leaseCarTemplate.getMarketPrice();//市场指导价
        //String belongerCompanyHeaderName = leaseCarTemplate.getBelongerCompanyHeaderName();//所有人
        Date inStorehouseTime = leaseCarTemplate.getInStorehouseTime();//入库日期
        //String gpsSupplierName = leaseCarTemplate.getGpsSupplierName();//GPS供应商

        Long contractId = null;//采购合同主键Id
        Long carBuyFinancingerId = null;//融资方主键id
        Long carSupplierId = null;//供应商主键id
        Long brandsId = null;//品牌主键id
        Long seriesId = null;//系列主键Id
        Long modelId = null;//车型主键Id
        Long branchCompanyId = null;//所属分公司主键Id
        Long companyHeaderId = null;//公司合同方主键Id
        Long belongerCompanyHeaderId = null;//所有人主键Id/默认使用分公司
        Long colorId = null;//颜色主键Id
        Long gpsSupplierId = null;//GPS供应商主键Id

        Map paramsMap = Maps.newHashMap();

        //处理品牌是否需要创建
        if (StringUtils.isNotEmpty(carBrandsName)) {
            paramsMap.put("name", carBrandsName);
            List<LeaseCarBrands> leaseCarBrandsLsit = leaseCarBrandsService.findByName(paramsMap);
            //品牌不存在说明这个品牌的系列、车型都要新建
            if (leaseCarBrandsLsit == null || leaseCarBrandsLsit.size() <= 0) {
                //插入品牌数据
                LeaseCarBrands leaseCarBrands = new LeaseCarBrands();
                leaseCarBrands.setName(carBrandsName);//品牌名称
                leaseCarBrands.setCreateBy(userSession.getUserId());
                leaseCarBrands.setUpdateBy(userSession.getUserId());
                leaseCarBrands = leaseCarBrandsService.insertSelective(leaseCarBrands);
                brandsId = leaseCarBrands.getId();//品牌主键ID
                //插入品牌数据

                //插入系列数据
                LeaseCarSeries leaseCarSeries = new LeaseCarSeries();
                leaseCarSeries.setName(carSeriesName);//系列名称
                leaseCarSeries.setBrandsId(brandsId);//品牌主键ID
                leaseCarSeries.setCreateBy(userSession.getUserId());
                leaseCarSeries.setUpdateBy(userSession.getUserId());
                leaseCarSeries = leaseCarSeriesService.insertSelective(leaseCarSeries);
                seriesId = leaseCarSeries.getId();//系列主键ID
                //插入系列数据

                //插入车型数据
                LeaseCarModel leaseCarModel = new LeaseCarModel();
                leaseCarModel.setCompleteModelName(carModelName);//车型名称
                leaseCarModel.setBusinessModelName(carModelName);//商业型号
                leaseCarModel.setSeriesId(seriesId);//系列主键ID
                leaseCarModel.setMarketPrice(new BigDecimal(StringUtils.isNotEmpty(leaseCarTemplate.getMarketPrice()) ? leaseCarTemplate.getMarketPrice() : "0"));
                leaseCarModel.setCreateBy(userSession.getUserId());
                leaseCarModel.setUpdateBy(userSession.getUserId());
                leaseCarModel = leaseCarModelService.insertSelective(leaseCarModel);
                modelId = leaseCarModel.getId();//车型主键ID
                //插入车型数据

                //处理颜色是否需要创建
                paramsMap.put("name", carColorName);
                List<LeaseCarColor> leaseCarColorList = leaseCarColorService.findByName(paramsMap);
                if (leaseCarColorList == null || leaseCarColorList.size() <= 0) {
                    //插入颜色数据
                    LeaseCarColor leaseCarColor = new LeaseCarColor();
                    leaseCarColor.setName(carColorName);
                    leaseCarColor.setCreateBy(userSession.getUserId());
                    leaseCarColor.setUpdateBy(userSession.getUserId());
                    leaseCarColor = leaseCarColorService.insertSelective(leaseCarColor);
                    colorId = leaseCarColor.getId();//颜色主键id
                    //插入颜色数据

                    //插入车型-颜色数据
                    LeaseCarModelColor leaseCarModelColor = new LeaseCarModelColor();
                    leaseCarModelColor.setCarModelId(modelId);//车型主键id
                    leaseCarModelColor.setCarColorId(colorId);//颜色主键id
                    leaseCarModelColor.setPrice(new BigDecimal(invoicedCarPrice));//价格
                    leaseCarModelColor = leaseCarModelColorService.insertSelective(leaseCarModelColor);
                    //插入车型-颜色数据
                } else {//颜色存在则检测是否车型-颜色
                    colorId = leaseCarColorList.get(0).getId();//颜色主键id

                    paramsMap.put("modelId", modelId);
                    paramsMap.put("colorId", colorId);
                    List<LeaseCarModelColor> leaseCarModelColorList = leaseCarModelColorService.selectCarModelAndColor(paramsMap);
                    if (leaseCarModelColorList == null || leaseCarModelColorList.size() <= 0) {
                        //插入车型-颜色数据
                        LeaseCarModelColor leaseCarModelColor = new LeaseCarModelColor();
                        leaseCarModelColor.setCarModelId(modelId);//车型主键id
                        leaseCarModelColor.setCarColorId(colorId);//颜色主键id
                        leaseCarModelColor.setPrice(new BigDecimal(invoicedCarPrice));//价格
                        leaseCarModelColor = leaseCarModelColorService.insertSelective(leaseCarModelColor);
                        //插入车型-颜色数据
                    }
                }
                //处理颜色是否需要创建

            } else {//品牌存在则检测是否存在导入的系列
                brandsId = leaseCarBrandsLsit.get(0).getId();
                paramsMap.put("brandId", brandsId);//品牌主键ID
                paramsMap.put("name", carSeriesName);//系列名称
                //处理系列是否需要创建
                List<LeaseCarSeries> leaseCarSeriesList = leaseCarSeriesService.findByBrandsIdAndName(paramsMap);
                if (leaseCarSeriesList == null || leaseCarSeriesList.size() <= 0) {
                    //插入系列数据
                    LeaseCarSeries leaseCarSeries = new LeaseCarSeries();
                    leaseCarSeries.setName(carSeriesName);//系列名称
                    leaseCarSeries.setBrandsId(brandsId);//品牌主键ID
                    leaseCarSeries.setCreateBy(userSession.getUserId());
                    leaseCarSeries.setUpdateBy(userSession.getUserId());
                    leaseCarSeries = leaseCarSeriesService.insertSelective(leaseCarSeries);
                    seriesId = leaseCarSeries.getId();//系列主键ID
                    //插入系列数据

                    //插入车型数据
                    LeaseCarModel leaseCarModel = new LeaseCarModel();
                    leaseCarModel.setCompleteModelName(carModelName);//车型名称
                    leaseCarModel.setBusinessModelName(carModelName);//商业型号
                    leaseCarModel.setSeriesId(seriesId);//系列主键ID
                    leaseCarModel.setMarketPrice(new BigDecimal(StringUtils.isNotEmpty(leaseCarTemplate.getMarketPrice()) ? leaseCarTemplate.getMarketPrice() : "0"));
                    leaseCarModel.setCreateBy(userSession.getUserId());
                    leaseCarModel.setUpdateBy(userSession.getUserId());
                    leaseCarModel = leaseCarModelService.insertSelective(leaseCarModel);
                    modelId = leaseCarModel.getId();//车型主键ID
                    //插入车型数据

                    //处理颜色是否需要创建
                    paramsMap.put("name", carColorName);
                    List<LeaseCarColor> leaseCarColorList = leaseCarColorService.findByName(paramsMap);
                    if (leaseCarColorList == null || leaseCarColorList.size() <= 0) {
                        //插入颜色数据
                        LeaseCarColor leaseCarColor = new LeaseCarColor();
                        leaseCarColor.setName(carColorName);
                        leaseCarColor.setCreateBy(userSession.getUserId());
                        leaseCarColor.setUpdateBy(userSession.getUserId());
                        leaseCarColor = leaseCarColorService.insertSelective(leaseCarColor);
                        colorId = leaseCarColor.getId();//颜色主键id
                        //插入颜色数据

                        //插入车型-颜色数据
                        LeaseCarModelColor leaseCarModelColor = new LeaseCarModelColor();
                        leaseCarModelColor.setCarModelId(modelId);//车型主键id
                        leaseCarModelColor.setCarColorId(colorId);//颜色主键id
                        leaseCarModelColor.setPrice(new BigDecimal(invoicedCarPrice));//价格
                        leaseCarModelColor = leaseCarModelColorService.insertSelective(leaseCarModelColor);
                        //插入车型-颜色数据
                    } else {//颜色存在则检测是否车型-颜色
                        colorId = leaseCarColorList.get(0).getId();//颜色主键id

                        paramsMap.put("modelId", modelId);
                        paramsMap.put("colorId", colorId);
                        List<LeaseCarModelColor> leaseCarModelColorList = leaseCarModelColorService.selectCarModelAndColor(paramsMap);
                        if (leaseCarModelColorList == null || leaseCarModelColorList.size() <= 0) {
                            //插入车型-颜色数据
                            LeaseCarModelColor leaseCarModelColor = new LeaseCarModelColor();
                            leaseCarModelColor.setCarModelId(modelId);//车型主键id
                            leaseCarModelColor.setCarColorId(colorId);//颜色主键id
                            leaseCarModelColor.setPrice(new BigDecimal(invoicedCarPrice));//价格
                            leaseCarModelColor = leaseCarModelColorService.insertSelective(leaseCarModelColor);
                            //插入车型-颜色数据
                        }
                    }
                    //处理颜色是否需要创建

                } else {//系列存在则检测是否存在导入的车型
                    seriesId = leaseCarSeriesList.get(0).getId();
                    paramsMap.put("seriesId", seriesId);//品牌主键ID
                    paramsMap.put("completeModelName", carModelName);//系列名称
                    //处理车型是否需要创建
                    List<LeaseCarModel> leaseCarModelList = leaseCarModelService.findBySeriesIdAndName(paramsMap);
                    if (leaseCarModelList == null || leaseCarModelList.size() <= 0) {
                        //插入车型数据
                        LeaseCarModel leaseCarModel = new LeaseCarModel();
                        leaseCarModel.setCompleteModelName(carModelName);//车型名称
                        leaseCarModel.setBusinessModelName(carModelName);//商业型号
                        leaseCarModel.setSeriesId(seriesId);//系列主键ID
                        leaseCarModel.setMarketPrice(new BigDecimal(StringUtils.isNotEmpty(leaseCarTemplate.getMarketPrice()) ? leaseCarTemplate.getMarketPrice() : "0"));
                        leaseCarModel.setCreateBy(userSession.getUserId());
                        leaseCarModel.setUpdateBy(userSession.getUserId());
                        leaseCarModel = leaseCarModelService.insertSelective(leaseCarModel);
                        modelId = leaseCarModel.getId();//车型主键ID
                        //插入车型数据

                        //处理颜色是否需要创建
                        paramsMap.put("name", carColorName);
                        List<LeaseCarColor> leaseCarColorList = leaseCarColorService.findByName(paramsMap);
                        if (leaseCarColorList == null || leaseCarColorList.size() <= 0) {
                            //插入颜色数据
                            LeaseCarColor leaseCarColor = new LeaseCarColor();
                            leaseCarColor.setName(carColorName);
                            leaseCarColor.setCreateBy(userSession.getUserId());
                            leaseCarColor.setUpdateBy(userSession.getUserId());
                            leaseCarColor = leaseCarColorService.insertSelective(leaseCarColor);
                            colorId = leaseCarColor.getId();//颜色主键id
                            //插入颜色数据

                            //插入车型-颜色数据
                            LeaseCarModelColor leaseCarModelColor = new LeaseCarModelColor();
                            leaseCarModelColor.setCarModelId(modelId);//车型主键id
                            leaseCarModelColor.setCarColorId(colorId);//颜色主键id
                            leaseCarModelColor.setPrice(new BigDecimal(invoicedCarPrice));//价格
                            leaseCarModelColor = leaseCarModelColorService.insertSelective(leaseCarModelColor);
                            //插入车型-颜色数据
                        } else {//颜色存在则检测是否车型-颜色
                            colorId = leaseCarColorList.get(0).getId();//颜色主键id

                            paramsMap.put("modelId", modelId);
                            paramsMap.put("colorId", colorId);
                            List<LeaseCarModelColor> leaseCarModelColorList = leaseCarModelColorService.selectCarModelAndColor(paramsMap);
                            if (leaseCarModelColorList == null || leaseCarModelColorList.size() <= 0) {
                                //插入车型-颜色数据
                                LeaseCarModelColor leaseCarModelColor = new LeaseCarModelColor();
                                leaseCarModelColor.setCarModelId(modelId);//车型主键id
                                leaseCarModelColor.setCarColorId(colorId);//颜色主键id
                                leaseCarModelColor.setPrice(new BigDecimal(invoicedCarPrice));//价格
                                leaseCarModelColor = leaseCarModelColorService.insertSelective(leaseCarModelColor);
                                //插入车型-颜色数据
                            }
                        }
                        //处理颜色是否需要创建

                    } else {
                        //车型存在则检测是否存在导入的颜色
                        modelId = leaseCarModelList.get(0).getId();//车型主键ID
                        //车型存在则修改市场指导价
                        if (StringUtils.isNotEmpty(leaseCarTemplate.getMarketPrice())) {
                            Map<String, Object> param = Maps.newHashMap();
                            param.put("id", modelId);
                            BigDecimal decimal = new BigDecimal(StringUtils.isNotEmpty(leaseCarTemplate.getMarketPrice()) ? leaseCarTemplate.getMarketPrice() : "0");
                            param.put("marketPrice", decimal);
                            leaseCarModelService.updateMarketPriceByPrimaryKey(param);
                        }


                        paramsMap.put("name", carColorName);
                        List<LeaseCarColor> leaseCarColorList = leaseCarColorService.findByName(paramsMap);
                        if (leaseCarColorList == null || leaseCarColorList.size() <= 0) {
                            //插入颜色数据
                            LeaseCarColor leaseCarColor = new LeaseCarColor();
                            leaseCarColor.setName(carColorName);
                            leaseCarColor.setCreateBy(userSession.getUserId());
                            leaseCarColor.setUpdateBy(userSession.getUserId());
                            leaseCarColor = leaseCarColorService.insertSelective(leaseCarColor);
                            colorId = leaseCarColor.getId();//颜色主键id
                            //插入颜色数据

                            //插入车型-颜色数据
                            LeaseCarModelColor leaseCarModelColor = new LeaseCarModelColor();
                            leaseCarModelColor.setCarModelId(modelId);//车型主键id
                            leaseCarModelColor.setCarColorId(colorId);//颜色主键id
                            leaseCarModelColor.setPrice(new BigDecimal(invoicedCarPrice));//价格
                            leaseCarModelColor = leaseCarModelColorService.insertSelective(leaseCarModelColor);
                            //插入车型-颜色数据
                        } else {//颜色存在则检测是否车型-颜色
                            colorId = leaseCarColorList.get(0).getId();//颜色主键id

                            paramsMap.put("modelId", modelId);
                            paramsMap.put("colorId", colorId);
                            List<LeaseCarModelColor> leaseCarModelColorList = leaseCarModelColorService.selectCarModelAndColor(paramsMap);
                            if (leaseCarModelColorList == null || leaseCarModelColorList.size() <= 0) {
                                //插入车型-颜色数据
                                LeaseCarModelColor leaseCarModelColor = new LeaseCarModelColor();
                                leaseCarModelColor.setCarModelId(modelId);//车型主键id
                                leaseCarModelColor.setCarColorId(colorId);//颜色主键id
                                leaseCarModelColor.setPrice(new BigDecimal(invoicedCarPrice));//价格
                                leaseCarModelColor = leaseCarModelColorService.insertSelective(leaseCarModelColor);
                                //插入车型-颜色数据
                            }

                        }

                    }
                }
            }
        }
        //处理品牌是否需要创建

        //处理供应商是否需要创建
        if (StringUtils.isNotEmpty(carSupplierName)) {
            paramsMap.put("name", carSupplierName);
            List<LeaseCarSupplier> leaseCarSupplierList = leaseCarSupplierService.findByName(paramsMap);
            if (leaseCarSupplierList == null || leaseCarSupplierList.size() <= 0) {
                LeaseCarSupplier leaseCarSupplier = new LeaseCarSupplier();
                leaseCarSupplier.setName(carSupplierName);//供应商名称
                leaseCarSupplier.setInternalNumber(supplierinternalNumber);//供应商内部编号
                leaseCarSupplier.setCreateBy(userSession.getUserId());
                leaseCarSupplier.setUpdateBy(userSession.getUserId());
                leaseCarSupplier = leaseCarSupplierService.insertSelective(leaseCarSupplier);
                carSupplierId = leaseCarSupplier.getId();//供应商主键Id
            } else {
                carSupplierId = leaseCarSupplierList.get(0).getId();//供应商主键Id
                if (!leaseCarSupplierList.get(0).getInternalNumber().equals(supplierinternalNumber)) {
                    LeaseCarSupplier leaseCarSupplier = new LeaseCarSupplier();
                    leaseCarSupplier.setId(carSupplierId);
                    leaseCarSupplier.setInternalNumber(supplierinternalNumber);
                    leaseCarSupplierService.updateByPrimaryKeySelective(leaseCarSupplier);
                }
            }
        }
        //处理供应商是否需要创建

        //处理公司合同方是否需要创建
        if (StringUtils.isNotEmpty(companyHeaderName)) {
            paramsMap.put("name", companyHeaderName);
            List<LeaseCompanyHeader> leaseCompanyHeaderList = leaseCompanyHeaderService.findByName(paramsMap);
            if (leaseCompanyHeaderList == null || leaseCompanyHeaderList.size() <= 0) {
                LeaseCompanyHeader leaseCompanyHeader = new LeaseCompanyHeader();
                leaseCompanyHeader.setName(companyHeaderName);
                leaseCompanyHeader.setCreateBy(userSession.getUserId());
                leaseCompanyHeader.setUpdateBy(userSession.getUserId());
                leaseCompanyHeader = leaseCompanyHeaderService.insertSelective(leaseCompanyHeader);
                companyHeaderId = leaseCompanyHeader.getId();//公司合同方主键ID
            } else {
                companyHeaderId = leaseCompanyHeaderList.get(0).getId();//公司合同方主键Id
            }
        }
        //处理公司合同方是否需要创建

        //处理融资方是否需要创建
        if (!StringUtils.isEmpty(parBuyFinancingerName)) {
            paramsMap.put("name", parBuyFinancingerName);
            List<LeaseCarBuyFinancinger> leaseCarBuyFinancingerList = leaseCarBuyFinancingerService.findByName(paramsMap);
            if (leaseCarBuyFinancingerList == null || leaseCarBuyFinancingerList.size() <= 0) {
                LeaseCarBuyFinancinger leaseCarBuyFinancinger = new LeaseCarBuyFinancinger();
                leaseCarBuyFinancinger.setName(parBuyFinancingerName);//融资方名称
                leaseCarBuyFinancinger.setCreateBy(userSession.getUserId());
                leaseCarBuyFinancinger.setUpdateBy(userSession.getUserId());
                leaseCarBuyFinancinger = leaseCarBuyFinancingerService.insertSelective(leaseCarBuyFinancinger);
                carBuyFinancingerId = leaseCarBuyFinancinger.getId();//融资方主键ID
            } else {
                carBuyFinancingerId = leaseCarBuyFinancingerList.get(0).getId();//融资方主键ID
            }
        }
        //处理融资方是否需要创建

        //处理采购合同是否需要创建
        if (!StringUtils.isEmpty(purchaseContractNnumber)) {
            paramsMap.put("contractNumber", purchaseContractNnumber);
            List<LeasePurchaseContract> leasePurchaseContractLiast = leasePurchaseContractService.selectByContractNumber(paramsMap);//采购合同
            if (leasePurchaseContractLiast == null || leasePurchaseContractLiast.size() <= 0) {
                LeasePurchaseContract leasePurchaseContract = new LeasePurchaseContract();
                leasePurchaseContract.setContractNumber(purchaseContractNnumber);//采购合同编号
                leasePurchaseContract.setCarSupplierId(carSupplierId);//供应商主键id
                leasePurchaseContract.setBrandsId(brandsId);//品牌主键ID
                leasePurchaseContract.setSeriesId(seriesId);//系列主键ID
                leasePurchaseContract.setModelId(modelId);//车型主键ID
                leasePurchaseContract.setBuyCardCapitalTypeId(carBuyFinancingerId != null ? 17l : 16l);//购车资金类型 16:自有资金/17:融资
                leasePurchaseContract.setCarBuyFinancingerId(carBuyFinancingerId);//融资方主键id
                leasePurchaseContract.setCompanyHeaderId(companyHeaderId);
                leasePurchaseContract.setCompanyHeaderName(companyHeaderName);
                leasePurchaseContract.setCreateBy(userSession.getUserId());
                leasePurchaseContract.setUpdateBy(userSession.getUserId());
                leasePurchaseContract.setCompanyHeaderId(companyHeaderId);//公司合同方主键Id
                leasePurchaseContract = leasePurchaseContractService.insertSelective(leasePurchaseContract);
                contractId = leasePurchaseContract.getId();//采购合同主键Id
            } else {
                contractId = leasePurchaseContractLiast.get(0).getId();//采购合同主键Id

                for (int i = 0; i < leasePurchaseContractLiast.size(); i++) {
                    LeasePurchaseContract leasePurchaseContract = leasePurchaseContractLiast.get(i);
                    leasePurchaseContract.setCarSupplierId(carSupplierId);//供应商主键id
                    leasePurchaseContract.setBrandsId(brandsId);//品牌主键ID
                    leasePurchaseContract.setSeriesId(seriesId);//系列主键ID
                    leasePurchaseContract.setModelId(modelId);//车型主键ID
                    leasePurchaseContract.setBuyCardCapitalTypeId(carBuyFinancingerId != null ? 17l : 16l);//购车资金类型 16:自有资金/17:融资
                    leasePurchaseContract.setCarBuyFinancingerId(carBuyFinancingerId);//融资方主键id
                    leasePurchaseContract.setCompanyHeaderId(companyHeaderId);
                    leasePurchaseContract.setCompanyHeaderName(companyHeaderName);
                    leasePurchaseContract.setUpdateBy(userSession.getUserId());
                    leasePurchaseContract.setCompanyHeaderId(companyHeaderId);//公司合同方主键Id
                    leasePurchaseContractService.updateByPrimaryKey(leasePurchaseContract);
                }

            }
        }
        //处理采购合同是否需要创建

        //处理所属分公司是否需要创建
        if (!StringUtils.isEmpty(branchCompanyName)) {
            paramsMap.put("name", branchCompanyName);
            List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyService.findByName(paramsMap);
            if (leaseBranchCompanyList == null || leaseBranchCompanyList.size() <= 0) {
                LeaseBranchCompany leaseBranchCompany = new LeaseBranchCompany();
                leaseBranchCompany.setName(branchCompanyName);//所属分公司名称
                leaseBranchCompany.setCreateBy(userSession.getUserId());
                leaseBranchCompany.setUpdateBy(userSession.getUserId());
                leaseBranchCompany = leaseBranchCompanyService.insertSelective(leaseBranchCompany);
                branchCompanyId = leaseBranchCompany.getId();//所属分公司主键ID
            } else {
                branchCompanyId = leaseBranchCompanyList.get(0).getId();//所属分公司主键ID
            }
            //处理所属分公司是否需要创建
        }
        //处理所属分公司是否需要创建

        /*
            //处理所有人是否需要创建
            paramsMap.put("name", belongerCompanyHeaderName);
            List<LeaseCompanyHeader> belongerCompanyHeaderList = leaseCompanyHeaderService.findByName(paramsMap);
            if (belongerCompanyHeaderList == null || belongerCompanyHeaderList.size() <= 0) {
                LeaseCompanyHeader leaseCompanyHeader = new LeaseCompanyHeader();
                leaseCompanyHeader.setName(belongerCompanyHeaderName);
                leaseCompanyHeader.setCreateBy(userSession.getUserId());
                leaseCompanyHeader.setUpdateBy(userSession.getUserId());
                leaseCompanyHeader = leaseCompanyHeaderService.insertSelective(leaseCompanyHeader);
                belongerCompanyHeaderId = leaseCompanyHeader.getId();//所有人主键ID
            } else {
                belongerCompanyHeaderId = belongerCompanyHeaderList.get(0).getId();//所有人主键Id
            }
             //处理所有人是否需要创建
            */

        /*
        //处理GPS供应商是否需要创建
        paramsMap.put("name", gpsSupplierName);
        if (!StringUtils.isEmpty(gpsSupplierName)) {
            List<LeaseGpsSupplier> leaseGpsSupplierList = leaseGpsSupplierService.findByName(paramsMap);
            if (leaseGpsSupplierList == null || leaseGpsSupplierList.size() <= 0) {
                LeaseGpsSupplier leaseGpsSupplier = new LeaseGpsSupplier();
                leaseGpsSupplier.setName(gpsSupplierName);
                leaseGpsSupplier.setCreateBy(userSession.getUserId());
                leaseGpsSupplier.setUpdateBy(userSession.getUserId());
                leaseGpsSupplier = leaseGpsSupplierService.insertSelective(leaseGpsSupplier);
                gpsSupplierId = leaseGpsSupplier.getId();//GPS供应商主键ID
            } else {
                gpsSupplierId = leaseGpsSupplierList.get(0).getId();//所有人主键Id
            }
        }
        //处理GPS供应商是否需要创建
        */

        //处理创建车辆
        LeaseCar leaseCar = new LeaseCar();
        leaseCar.setContractId(contractId);
        leaseCar.setContractNumber(purchaseContractNnumber);//采购合同编号
        leaseCar.setCarBuyFinancingerId(carBuyFinancingerId);//融资方主键ID
        leaseCar.setBrandsId(brandsId);//品牌主键ID
        leaseCar.setSeriesId(seriesId);//系列主键ID
        leaseCar.setModelId(modelId);//车型主键ID
        leaseCar.setColorId(colorId);//颜色主键ID
        leaseCar.setEngineNumber(engineNumber);//发动机号
        leaseCar.setCardFrameNumber(cardFrameNumber);//车架号
        leaseCar.setBranchCompanyId(branchCompanyId);//所属分公司
        leaseCar.setManufactureTime(manufactureTime);//出厂日期
        leaseCar.setCertificateNumber(certificateNumber);//合格证号
        leaseCar.setPlateNumber(plateNumber);//车牌号
        leaseCar.setInvoicedCarPrice(invoicedCarPrice == null ? new BigDecimal(0) : new BigDecimal(invoicedCarPrice));//车辆含税价
        leaseCar.setBelongerTpye(0);//所有人/默认使用分公司
        leaseCar.setBelongerCompanyHeaderId(belongerCompanyHeaderId);//所有人主键ID
        leaseCar.setStorehouseStatus(1);//库存状态0:未入仓;1:已出仓;2:公司仓库;3:经销商仓库
        leaseCar.setInStorehouseTime(inStorehouseTime);//入库日期
        leaseCar.setGpsSupplierId(gpsSupplierId);//GPS供应商主键ID
        leaseCar.setLeaseStatus(1);//租赁状态0:未开始;1:未到期未过户;2:已过户;3:已过户抵押;4:已回收;5:到期不变更（售后回租）
        leaseCar.setPlateStatus(0);//上牌状态:是否已上牌/有录入车牌号则视为已上牌/ 0 已上牌 1已预约未上牌 2未预约
        leaseCar.setCreateBy(userSession.getUserId());
        leaseCar.setUpdateBy(userSession.getUserId());
        leaseCar = leaseCarService.insertSelective(leaseCar);
        //处理创建车辆

        //车辆-购车融资方 （一对多）
        LeaseSchemeCarFinancinger leaseSchemeCarFinancinger = new LeaseSchemeCarFinancinger();
        leaseSchemeCarFinancinger.setCarId(leaseCar.getId());//车辆主键ID
        leaseSchemeCarFinancinger.setCarBuyFinancingerId(carBuyFinancingerId);//融资方主键ID
        leaseSchemeCarFinancinger.setIsEnable(true);
        leaseSchemeCarFinancinger.setCreateBy(userSession.getUserId());
        leaseSchemeCarFinancinger.setUpdateBy(userSession.getUserId());
        leaseSchemeCarFinancingerService.insertSelective(leaseSchemeCarFinancinger);
        //车辆-购车融资方 （一对多）

        //插入使用和被使用的数据/车型
        leaseCommonService.insertUseUsed(leaseCar.getId(), null, leaseCar.getModelId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_CAR_MODEL);
        //插入使用和被使用的数据/购车融资方
        leaseCommonService.insertUseUsed(leaseCar.getId(), null, leaseCar.getCarBuyFinancingerId(), leaseCar.getCarBuyFinancingerName(), UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_CAR_BUY_FINANCINGER);
        //插入使用和被使用的数据/分公司
        leaseCommonService.insertUseUsed(leaseCar.getId(), null, leaseCar.getBranchCompanyId(), leaseCar.getBranchCompanyName(), UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_BRANCH_COMPANY);
        //插入使用和被使用的数据/采购合同
        leaseCommonService.insertUseUsed(leaseCar.getId(), null, leaseCar.getContractId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_PURCHASE_CONTRACT);
        //插入使用和被使用的数据/颜色
        leaseCommonService.insertUseUsed(leaseCar.getId(), null, leaseCar.getColorId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_CAR_COLOR);
        //插入使用和被使用的数据/GPS供应商
        leaseCommonService.insertUseUsed(leaseCar.getId(), null, leaseCar.getGpsSupplierId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_GPS_SUPPLIER);
        //插入使用和被使用的数据/合同方
        leaseCommonService.insertUseUsed(leaseCar.getId(), null, leaseCar.getBelongerCompanyHeaderId(), null, UseType.TYPE_LEASE_CAR, UsedType.TYPE_LEASE_COMPANY_HEADER);

        return true;

    }

    /**
     * 处理车辆数据导入/修改
     *
     * @param leaseCarTemplate Excel导入的车辆数据
     * @param userSession
     * @param leaseCar
     * @return
     * @throws GMException
     */
    public boolean dualUpdateCarImportExcel(LeaseCarTemplate leaseCarTemplate, UserSession userSession, LeaseCar leaseCar) throws GMException {
        String purchaseContractNnumber = leaseCarTemplate.getPurchaseContractNnumber();//采购合同编号
        String parBuyFinancingerName = leaseCarTemplate.getCarBuyFinancingerName();//融资方名称
        String carSupplierName = leaseCarTemplate.getCarSupplierName();//供应商名称
        String supplierinternalNumber = leaseCarTemplate.getSupplierinternalNumber();//供应商编号
        String companyHeaderName = leaseCarTemplate.getCompanyHeaderName();//公司合同方名称
        String carBrandsName = leaseCarTemplate.getCarBrandsName();//品牌名称
        String carSeriesName = leaseCarTemplate.getCarSeriesName();//系列名称
        String carModelName = leaseCarTemplate.getCarModelName();//车型名称
        String carColorName = leaseCarTemplate.getCarColorName();//颜色名称
        String engineNumber = leaseCarTemplate.getEngineNumber();//发动机号
        String cardFrameNumber = leaseCarTemplate.getCardFrameNumber();//车架号
        String branchCompanyName = leaseCarTemplate.getBranchCompanyName();//所属分公司
        Date manufactureTime = leaseCarTemplate.getManufactureTime();//出厂日期
        String certificateNumber = leaseCarTemplate.getCertificateNumber();//合格证号
        String plateNumber = leaseCarTemplate.getPlateNumber();//车牌号
        String invoicedCarPrice = leaseCarTemplate.getInvoicedCarPrice();//车辆含税价
        String marketPrice = leaseCarTemplate.getMarketPrice();//市场指导价
        //String belongerCompanyHeaderName = leaseCarTemplate.getBelongerCompanyHeaderName();//所有人
        Date inStorehouseTime = leaseCarTemplate.getInStorehouseTime();//入库日期
        //String gpsSupplierName = leaseCarTemplate.getGpsSupplierName();//GPS供应商

        Long contractId = null;//采购合同主键Id
        Long carBuyFinancingerId = null;//融资方主键id
        Long carSupplierId = null;//供应商主键id
        Long brandsId = null;//品牌主键id
        Long seriesId = null;//系列主键Id
        Long modelId = null;//车型主键Id
        Long branchCompanyId = null;//所属分公司主键Id
        Long companyHeaderId = null;//公司合同方主键Id
        Long belongerCompanyHeaderId = null;//所有人主键Id/默认使用分公司
        Long colorId = null;//颜色主键Id
        Long gpsSupplierId = null;//GPS供应商主键Id

        Map paramsMap = Maps.newHashMap();

        //处理品牌是否需要创建
        paramsMap.put("name", carBrandsName);
        if (StringUtil.isNotEmpty(carBrandsName)) {
            List<LeaseCarBrands> leaseCarBrandsLsit = leaseCarBrandsService.findByName(paramsMap);
            //品牌不存在说明这个品牌的系列、车型都要新建
            if (leaseCarBrandsLsit == null || leaseCarBrandsLsit.size() <= 0) {
                //插入品牌数据
                LeaseCarBrands leaseCarBrands = new LeaseCarBrands();
                leaseCarBrands.setName(carBrandsName);//品牌名称
                leaseCarBrands.setCreateBy(userSession.getUserId());
                leaseCarBrands.setUpdateBy(userSession.getUserId());
                leaseCarBrands = leaseCarBrandsService.insertSelective(leaseCarBrands);
                brandsId = leaseCarBrands.getId();//品牌主键ID
                //插入品牌数据

                //插入系列数据
                LeaseCarSeries leaseCarSeries = new LeaseCarSeries();
                leaseCarSeries.setName(carSeriesName);//系列名称
                leaseCarSeries.setBrandsId(brandsId);//品牌主键ID
                leaseCarSeries.setCreateBy(userSession.getUserId());
                leaseCarSeries.setUpdateBy(userSession.getUserId());
                leaseCarSeries = leaseCarSeriesService.insertSelective(leaseCarSeries);
                seriesId = leaseCarSeries.getId();//系列主键ID
                //插入系列数据

                //插入车型数据
                LeaseCarModel leaseCarModel = new LeaseCarModel();
                leaseCarModel.setCompleteModelName(carModelName);//车型名称
                leaseCarModel.setBusinessModelName(carModelName);//商业型号
                leaseCarModel.setSeriesId(seriesId);//系列主键ID
                leaseCarModel.setMarketPrice(new BigDecimal(StringUtils.isNotEmpty(leaseCarTemplate.getMarketPrice()) ? leaseCarTemplate.getMarketPrice() : "0"));
                leaseCarModel.setCreateBy(userSession.getUserId());
                leaseCarModel.setUpdateBy(userSession.getUserId());
                leaseCarModel = leaseCarModelService.insertSelective(leaseCarModel);
                modelId = leaseCarModel.getId();//车型主键ID
                //插入车型数据

                //处理颜色是否需要创建
                paramsMap.put("name", carColorName);
                List<LeaseCarColor> leaseCarColorList = leaseCarColorService.findByName(paramsMap);
                if (leaseCarColorList == null || leaseCarColorList.size() <= 0) {
                    //插入颜色数据
                    LeaseCarColor leaseCarColor = new LeaseCarColor();
                    leaseCarColor.setName(carColorName);
                    leaseCarColor.setCreateBy(userSession.getUserId());
                    leaseCarColor.setUpdateBy(userSession.getUserId());
                    leaseCarColor = leaseCarColorService.insertSelective(leaseCarColor);
                    colorId = leaseCarColor.getId();//颜色主键id
                    //插入颜色数据

                    //插入车型-颜色数据
                    LeaseCarModelColor leaseCarModelColor = new LeaseCarModelColor();
                    leaseCarModelColor.setCarModelId(modelId);//车型主键id
                    leaseCarModelColor.setCarColorId(colorId);//颜色主键id
                    leaseCarModelColor.setPrice(new BigDecimal(invoicedCarPrice));//价格
                    leaseCarModelColor = leaseCarModelColorService.insertSelective(leaseCarModelColor);
                    //插入车型-颜色数据
                } else {//颜色存在则检测是否车型-颜色
                    colorId = leaseCarColorList.get(0).getId();//颜色主键id
                    paramsMap.put("modelId", modelId);
                    paramsMap.put("colorId", colorId);
                    List<LeaseCarModelColor> leaseCarModelColorList = leaseCarModelColorService.selectCarModelAndColor(paramsMap);
                    if (leaseCarModelColorList == null || leaseCarModelColorList.size() <= 0) {
                        //插入车型-颜色数据
                        LeaseCarModelColor leaseCarModelColor = new LeaseCarModelColor();
                        leaseCarModelColor.setCarModelId(modelId);//车型主键id
                        leaseCarModelColor.setCarColorId(colorId);//颜色主键id
                        leaseCarModelColor.setPrice(new BigDecimal(invoicedCarPrice));//价格
                        leaseCarModelColor = leaseCarModelColorService.insertSelective(leaseCarModelColor);
                        //插入车型-颜色数据
                    }
                }
                //处理颜色是否需要创建

            } else {//品牌存在则检测是否存在导入的系列
                brandsId = leaseCarBrandsLsit.get(0).getId();
                paramsMap.put("brandId", brandsId);//品牌主键ID
                paramsMap.put("name", carSeriesName);//系列名称
                //处理系列是否需要创建
                List<LeaseCarSeries> leaseCarSeriesList = leaseCarSeriesService.findByBrandsIdAndName(paramsMap);
                if (leaseCarSeriesList == null || leaseCarSeriesList.size() <= 0) {
                    //插入系列数据
                    LeaseCarSeries leaseCarSeries = new LeaseCarSeries();
                    leaseCarSeries.setName(carSeriesName);//系列名称
                    leaseCarSeries.setBrandsId(brandsId);//品牌主键ID
                    leaseCarSeries.setCreateBy(userSession.getUserId());
                    leaseCarSeries.setUpdateBy(userSession.getUserId());
                    leaseCarSeries = leaseCarSeriesService.insertSelective(leaseCarSeries);
                    seriesId = leaseCarSeries.getId();//系列主键ID
                    //插入系列数据

                    //插入车型数据
                    LeaseCarModel leaseCarModel = new LeaseCarModel();
                    leaseCarModel.setCompleteModelName(carModelName);//车型名称
                    leaseCarModel.setBusinessModelName(carModelName);//商业型号
                    leaseCarModel.setSeriesId(seriesId);//系列主键ID
                    leaseCarModel.setMarketPrice(new BigDecimal(StringUtils.isNotEmpty(leaseCarTemplate.getMarketPrice()) ? leaseCarTemplate.getMarketPrice() : "0"));
                    leaseCarModel.setCreateBy(userSession.getUserId());
                    leaseCarModel.setUpdateBy(userSession.getUserId());
                    leaseCarModel = leaseCarModelService.insertSelective(leaseCarModel);
                    modelId = leaseCarModel.getId();//车型主键ID
                    //插入车型数据

                    //处理颜色是否需要创建
                    paramsMap.put("name", carColorName);
                    List<LeaseCarColor> leaseCarColorList = leaseCarColorService.findByName(paramsMap);
                    if (leaseCarColorList == null || leaseCarColorList.size() <= 0) {
                        //插入颜色数据
                        LeaseCarColor leaseCarColor = new LeaseCarColor();
                        leaseCarColor.setName(carColorName);
                        leaseCarColor.setCreateBy(userSession.getUserId());
                        leaseCarColor.setUpdateBy(userSession.getUserId());
                        leaseCarColor = leaseCarColorService.insertSelective(leaseCarColor);
                        colorId = leaseCarColor.getId();//颜色主键id
                        //插入颜色数据

                        //插入车型-颜色数据
                        LeaseCarModelColor leaseCarModelColor = new LeaseCarModelColor();
                        leaseCarModelColor.setCarModelId(modelId);//车型主键id
                        leaseCarModelColor.setCarColorId(colorId);//颜色主键id
                        leaseCarModelColor.setPrice(new BigDecimal(invoicedCarPrice));//价格
                        leaseCarModelColor = leaseCarModelColorService.insertSelective(leaseCarModelColor);
                        //插入车型-颜色数据
                    } else {//颜色存在则检测是否车型-颜色
                        colorId = leaseCarColorList.get(0).getId();//颜色主键id
                        paramsMap.put("modelId", modelId);
                        paramsMap.put("colorId", colorId);
                        List<LeaseCarModelColor> leaseCarModelColorList = leaseCarModelColorService.selectCarModelAndColor(paramsMap);
                        if (leaseCarModelColorList == null || leaseCarModelColorList.size() <= 0) {
                            //插入车型-颜色数据
                            LeaseCarModelColor leaseCarModelColor = new LeaseCarModelColor();
                            leaseCarModelColor.setCarModelId(modelId);//车型主键id
                            leaseCarModelColor.setCarColorId(colorId);//颜色主键id
                            leaseCarModelColor.setPrice(new BigDecimal(invoicedCarPrice));//价格
                            leaseCarModelColor = leaseCarModelColorService.insertSelective(leaseCarModelColor);
                            //插入车型-颜色数据
                        }
                    }
                    //处理颜色是否需要创建

                } else {//系列存在则检测是否存在导入的车型
                    seriesId = leaseCarSeriesList.get(0).getId();
                    paramsMap.put("seriesId", seriesId);//品牌主键ID
                    paramsMap.put("completeModelName", carModelName);//系列名称
                    //处理车型是否需要创建
                    List<LeaseCarModel> leaseCarModelList = leaseCarModelService.findBySeriesIdAndName(paramsMap);
                    if (leaseCarModelList == null || leaseCarModelList.size() <= 0) {
                        //插入车型数据
                        LeaseCarModel leaseCarModel = new LeaseCarModel();
                        leaseCarModel.setCompleteModelName(carModelName);//车型名称
                        leaseCarModel.setBusinessModelName(carModelName);//商业型号
                        leaseCarModel.setSeriesId(seriesId);//系列主键ID
                        leaseCarModel.setMarketPrice(new BigDecimal(StringUtils.isNotEmpty(leaseCarTemplate.getMarketPrice()) ? leaseCarTemplate.getMarketPrice() : "0"));
                        leaseCarModel.setCreateBy(userSession.getUserId());
                        leaseCarModel.setUpdateBy(userSession.getUserId());
                        leaseCarModel = leaseCarModelService.insertSelective(leaseCarModel);
                        modelId = leaseCarModel.getId();//车型主键ID
                        //插入车型数据

                        //处理颜色是否需要创建
                        paramsMap.put("name", carColorName);
                        List<LeaseCarColor> leaseCarColorList = leaseCarColorService.findByName(paramsMap);
                        if (leaseCarColorList == null || leaseCarColorList.size() <= 0) {
                            //插入颜色数据
                            LeaseCarColor leaseCarColor = new LeaseCarColor();
                            leaseCarColor.setName(carColorName);
                            leaseCarColor.setCreateBy(userSession.getUserId());
                            leaseCarColor.setUpdateBy(userSession.getUserId());
                            leaseCarColor = leaseCarColorService.insertSelective(leaseCarColor);
                            colorId = leaseCarColor.getId();//颜色主键id
                            //插入颜色数据

                            //插入车型-颜色数据
                            LeaseCarModelColor leaseCarModelColor = new LeaseCarModelColor();
                            leaseCarModelColor.setCarModelId(modelId);//车型主键id
                            leaseCarModelColor.setCarColorId(colorId);//颜色主键id
                            leaseCarModelColor.setPrice(new BigDecimal(invoicedCarPrice));//价格
                            leaseCarModelColor = leaseCarModelColorService.insertSelective(leaseCarModelColor);
                            //插入车型-颜色数据
                        } else {
                            //颜色存在则检测是否车型-颜色
                            colorId = leaseCarColorList.get(0).getId();//颜色主键id
                            paramsMap.put("modelId", modelId);
                            paramsMap.put("colorId", colorId);
                            List<LeaseCarModelColor> leaseCarModelColorList = leaseCarModelColorService.selectCarModelAndColor(paramsMap);
                            if (leaseCarModelColorList == null || leaseCarModelColorList.size() <= 0) {
                                //插入车型-颜色数据
                                LeaseCarModelColor leaseCarModelColor = new LeaseCarModelColor();
                                leaseCarModelColor.setCarModelId(modelId);//车型主键id
                                leaseCarModelColor.setCarColorId(colorId);//颜色主键id
                                leaseCarModelColor.setPrice(new BigDecimal(invoicedCarPrice));//价格
                                leaseCarModelColor = leaseCarModelColorService.insertSelective(leaseCarModelColor);
                                //插入车型-颜色数据
                            }
                        }
                        //处理颜色是否需要创建

                    } else {
                        //车型存在则检测是否存在导入的颜色
                        modelId = leaseCarModelList.get(0).getId();//车型主键ID
                        //车型存在则修改市场指导价
                        if (StringUtils.isNotEmpty(leaseCarTemplate.getMarketPrice())) {
                            Map<String, Object> param = Maps.newHashMap();
                            param.put("id", modelId);
                            BigDecimal decimal = new BigDecimal(StringUtils.isNotEmpty(leaseCarTemplate.getMarketPrice()) ? leaseCarTemplate.getMarketPrice() : "0");
                            param.put("marketPrice", decimal);
                            leaseCarModelService.updateMarketPriceByPrimaryKey(param);
                        }
                        paramsMap.put("name", carColorName);
                        List<LeaseCarColor> leaseCarColorList = leaseCarColorService.findByName(paramsMap);
                        if (leaseCarColorList == null || leaseCarColorList.size() <= 0) {
                            //插入颜色数据
                            LeaseCarColor leaseCarColor = new LeaseCarColor();
                            leaseCarColor.setName(carColorName);
                            leaseCarColor.setCreateBy(userSession.getUserId());
                            leaseCarColor.setUpdateBy(userSession.getUserId());
                            leaseCarColor = leaseCarColorService.insertSelective(leaseCarColor);
                            colorId = leaseCarColor.getId();//颜色主键id
                            //插入颜色数据

                            //插入车型-颜色数据
                            LeaseCarModelColor leaseCarModelColor = new LeaseCarModelColor();
                            leaseCarModelColor.setCarModelId(modelId);//车型主键id
                            leaseCarModelColor.setCarColorId(colorId);//颜色主键id
                            leaseCarModelColor.setPrice(new BigDecimal(invoicedCarPrice));//价格
                            leaseCarModelColor = leaseCarModelColorService.insertSelective(leaseCarModelColor);
                            //插入车型-颜色数据
                        } else {//颜色存在则检测是否车型-颜色
                            colorId = leaseCarColorList.get(0).getId();//颜色主键id
                            paramsMap.put("modelId", modelId);
                            paramsMap.put("colorId", colorId);
                            List<LeaseCarModelColor> leaseCarModelColorList = leaseCarModelColorService.selectCarModelAndColor(paramsMap);
                            if (leaseCarModelColorList == null || leaseCarModelColorList.size() <= 0) {
                                //插入车型-颜色数据
                                LeaseCarModelColor leaseCarModelColor = new LeaseCarModelColor();
                                leaseCarModelColor.setCarModelId(modelId);//车型主键id
                                leaseCarModelColor.setCarColorId(colorId);//颜色主键id
                                leaseCarModelColor.setPrice(new BigDecimal(invoicedCarPrice));//价格
                                leaseCarModelColor = leaseCarModelColorService.insertSelective(leaseCarModelColor);
                                //插入车型-颜色数据
                            }

                        }

                    }
                }
            }
            //处理品牌是否需要创建

        }

        //处理供应商是否需要创建
        paramsMap.put("name", carSupplierName);
        if (StringUtils.isNotEmpty(carSupplierName)) {
            List<LeaseCarSupplier> leaseCarSupplierList = leaseCarSupplierService.findByName(paramsMap);
            if (leaseCarSupplierList == null || leaseCarSupplierList.size() <= 0) {
                LeaseCarSupplier leaseCarSupplier = new LeaseCarSupplier();
                leaseCarSupplier.setName(carSupplierName);//供应商名称
                leaseCarSupplier.setInternalNumber(supplierinternalNumber);//供应商内部编号
                leaseCarSupplier.setCreateBy(userSession.getUserId());
                leaseCarSupplier.setUpdateBy(userSession.getUserId());
                leaseCarSupplier = leaseCarSupplierService.insertSelective(leaseCarSupplier);
                carSupplierId = leaseCarSupplier.getId();//供应商主键Id
            } else {
                carSupplierId = leaseCarSupplierList.get(0).getId();//供应商主键Id
                if (!leaseCarSupplierList.get(0).getInternalNumber().equals(supplierinternalNumber)) {
                    LeaseCarSupplier leaseCarSupplier = new LeaseCarSupplier();
                    leaseCarSupplier.setId(carSupplierId);
                    leaseCarSupplier.setInternalNumber(supplierinternalNumber);
                    leaseCarSupplierService.updateByPrimaryKeySelective(leaseCarSupplier);
                }
            }
        }
        //处理供应商是否需要创建

        //处理公司合同方是否需要创建
        if (StringUtils.isNotEmpty(companyHeaderName)) {
            paramsMap.put("name", companyHeaderName);
            List<LeaseCompanyHeader> leaseCompanyHeaderList = leaseCompanyHeaderService.findByName(paramsMap);
            if (leaseCompanyHeaderList == null || leaseCompanyHeaderList.size() <= 0) {
                LeaseCompanyHeader leaseCompanyHeader = new LeaseCompanyHeader();
                leaseCompanyHeader.setName(companyHeaderName);
                leaseCompanyHeader.setCreateBy(userSession.getUserId());
                leaseCompanyHeader.setUpdateBy(userSession.getUserId());
                leaseCompanyHeader = leaseCompanyHeaderService.insertSelective(leaseCompanyHeader);
                companyHeaderId = leaseCompanyHeader.getId();//公司合同方主键ID
            } else {
                companyHeaderId = leaseCompanyHeaderList.get(0).getId();//公司合同方主键Id
            }
        }
        //处理公司合同方是否需要创建

        //处理融资方是否需要创建
        if (!StringUtils.isEmpty(parBuyFinancingerName)) {
            paramsMap.put("name", parBuyFinancingerName);
            List<LeaseCarBuyFinancinger> leaseCarBuyFinancingerList = leaseCarBuyFinancingerService.findByName(paramsMap);
            if (leaseCarBuyFinancingerList == null || leaseCarBuyFinancingerList.size() <= 0) {
                LeaseCarBuyFinancinger leaseCarBuyFinancinger = new LeaseCarBuyFinancinger();
                leaseCarBuyFinancinger.setName(parBuyFinancingerName);//融资方名称
                leaseCarBuyFinancinger.setCreateBy(userSession.getUserId());
                leaseCarBuyFinancinger.setUpdateBy(userSession.getUserId());
                leaseCarBuyFinancinger = leaseCarBuyFinancingerService.insertSelective(leaseCarBuyFinancinger);
                carBuyFinancingerId = leaseCarBuyFinancinger.getId();//融资方主键ID
            } else {
                carBuyFinancingerId = leaseCarBuyFinancingerList.get(0).getId();//融资方主键ID
            }
        }
        //处理融资方是否需要创建

        //处理采购合同是否需要创建
        if (StringUtils.isNotEmpty(purchaseContractNnumber)) {
            paramsMap.put("contractNumber", purchaseContractNnumber);
            List<LeasePurchaseContract> leasePurchaseContractLiast = leasePurchaseContractService.selectByContractNumber(paramsMap);//采购合同
            if (leasePurchaseContractLiast == null || leasePurchaseContractLiast.size() <= 0) {
                LeasePurchaseContract leasePurchaseContract = new LeasePurchaseContract();
                leasePurchaseContract.setContractNumber(purchaseContractNnumber);//采购合同编号
                leasePurchaseContract.setCarSupplierId(carSupplierId);//供应商主键id
                leasePurchaseContract.setBrandsId(brandsId);//品牌主键ID
                leasePurchaseContract.setSeriesId(seriesId);//系列主键ID
                leasePurchaseContract.setModelId(modelId);//车型主键ID
                leasePurchaseContract.setCarBuyFinancingerId(carBuyFinancingerId);//融资方主键id
                leasePurchaseContract.setCompanyHeaderId(companyHeaderId);
                leasePurchaseContract.setCompanyHeaderName(companyHeaderName);
                leasePurchaseContract.setCreateBy(userSession.getUserId());
                leasePurchaseContract.setUpdateBy(userSession.getUserId());
                leasePurchaseContract.setCompanyHeaderId(companyHeaderId);//公司合同方主键Id
                leasePurchaseContract = leasePurchaseContractService.insertSelective(leasePurchaseContract);
                contractId = leasePurchaseContract.getId();//采购合同主键Id
            } else {
                contractId = leasePurchaseContractLiast.get(0).getId();//采购合同主键Id

                for (int i = 0; i < leasePurchaseContractLiast.size(); i++) {
                    LeasePurchaseContract leasePurchaseContract = leasePurchaseContractLiast.get(i);
                    leasePurchaseContract.setCarSupplierId(carSupplierId);//供应商主键id
                    leasePurchaseContract.setBrandsId(brandsId);//品牌主键ID
                    leasePurchaseContract.setSeriesId(seriesId);//系列主键ID
                    leasePurchaseContract.setModelId(modelId);//车型主键ID
                    leasePurchaseContract.setBuyCardCapitalTypeId(carBuyFinancingerId != null ? 17l : 16l);//购车资金类型 16:自有资金/17:融资
                    leasePurchaseContract.setCarBuyFinancingerId(carBuyFinancingerId);//融资方主键id
                    leasePurchaseContract.setCompanyHeaderId(companyHeaderId);
                    leasePurchaseContract.setCompanyHeaderName(companyHeaderName);
                    leasePurchaseContract.setUpdateBy(userSession.getUserId());
                    leasePurchaseContract.setCompanyHeaderId(companyHeaderId);//公司合同方主键Id
                    leasePurchaseContractService.updateByPrimaryKey(leasePurchaseContract);
                }
            }
        }
        //处理采购合同是否需要创建

        //处理所属分公司是否需要创建
        if (StringUtils.isNotEmpty(branchCompanyName)) {
            paramsMap.put("name", branchCompanyName);
            List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyService.findByName(paramsMap);
            if (leaseBranchCompanyList == null || leaseBranchCompanyList.size() <= 0) {
                LeaseBranchCompany leaseBranchCompany = new LeaseBranchCompany();
                leaseBranchCompany.setName(branchCompanyName);//所属分公司名称
                leaseBranchCompany.setCreateBy(userSession.getUserId());
                leaseBranchCompany.setUpdateBy(userSession.getUserId());
                leaseBranchCompany = leaseBranchCompanyService.insertSelective(leaseBranchCompany);
                branchCompanyId = leaseBranchCompany.getId();//所属分公司主键ID
            } else {
                branchCompanyId = leaseBranchCompanyList.get(0).getId();//所属分公司主键ID
            }
        }
        //处理所属分公司是否需要创建

        /*
        //处理所有人是否需要创建
        if (StringUtils.isNotEmpty(belongerCompanyHeaderName)){
            paramsMap.put("name", belongerCompanyHeaderName);
            List<LeaseCompanyHeader> belongerCompanyHeaderList = leaseCompanyHeaderService.findByName(paramsMap);
            if (belongerCompanyHeaderList == null || belongerCompanyHeaderList.size() <= 0) {
                LeaseCompanyHeader leaseCompanyHeader = new LeaseCompanyHeader();
                leaseCompanyHeader.setName(belongerCompanyHeaderName);
                leaseCompanyHeader.setCreateBy(userSession.getUserId());
                leaseCompanyHeader.setUpdateBy(userSession.getUserId());
                leaseCompanyHeader = leaseCompanyHeaderService.insertSelective(leaseCompanyHeader);
                belongerCompanyHeaderId = leaseCompanyHeader.getId();//所有人主键ID
            } else {
                belongerCompanyHeaderId = belongerCompanyHeaderList.get(0).getId();//所有人主键Id
            }
        }
        //处理所有人是否需要创建
        */

        /*
        //处理GPS供应商是否需要创建
        if (StringUtils.isNotEmpty(gpsSupplierName)){
            paramsMap.put("name", gpsSupplierName);
            List<LeaseGpsSupplier> leaseGpsSupplierList = leaseGpsSupplierService.findByName(paramsMap);
            if (leaseGpsSupplierList == null || leaseGpsSupplierList.size() <= 0) {
                LeaseGpsSupplier leaseGpsSupplier = new LeaseGpsSupplier();
                leaseGpsSupplier.setName(gpsSupplierName);
                leaseGpsSupplier.setCreateBy(userSession.getUserId());
                leaseGpsSupplier.setUpdateBy(userSession.getUserId());
                leaseGpsSupplier = leaseGpsSupplierService.insertSelective(leaseGpsSupplier);
                gpsSupplierId = leaseGpsSupplier.getId();//GPS供应商主键ID
            } else {
                gpsSupplierId = leaseGpsSupplierList.get(0).getId();//所有人主键Id
            }
        }
        //处理GPS供应商是否需要创建
        */

        //处理创建车辆
        leaseCar.setContractId(contractId);
        leaseCar.setContractNumber(purchaseContractNnumber);//采购合同编号
        leaseCar.setCarBuyFinancingerId(carBuyFinancingerId);//融资方主键ID
        leaseCar.setBrandsId(brandsId);//品牌主键ID
        leaseCar.setSeriesId(seriesId);//系列主键ID
        leaseCar.setModelId(modelId);//车型主键ID
        leaseCar.setColorId(colorId);//颜色主键ID
        leaseCar.setEngineNumber(engineNumber);//发动机号
        leaseCar.setCardFrameNumber(cardFrameNumber);//车架号
        leaseCar.setBranchCompanyId(branchCompanyId);//所属分公司
        leaseCar.setManufactureTime(manufactureTime);//出厂日期
        leaseCar.setCertificateNumber(certificateNumber);//合格证号
        leaseCar.setPlateNumber(plateNumber);//车牌号
        leaseCar.setInvoicedCarPrice(invoicedCarPrice == null ? new BigDecimal(0) : new BigDecimal(invoicedCarPrice));//车辆含税价/采购合同价
        leaseCar.setBelongerTpye(0);//所有人/默认使用分公司
        leaseCar.setBelongerCompanyHeaderId(belongerCompanyHeaderId);//所有人主键ID
        leaseCar.setStorehouseStatus(1);//库存状态0:未入仓;1:已出仓;2:公司仓库;3:经销商仓库
        leaseCar.setInStorehouseTime(inStorehouseTime);//入库日期
        leaseCar.setGpsSupplierId(gpsSupplierId);//GPS供应商主键ID
        leaseCar.setLeaseStatus(1);//租赁状态0:未开始;1:未到期未过户;2:已过户;3:已过户抵押;4:已回收;5:到期不变更（售后回租）
        leaseCar.setPlateStatus(0);//上牌状态:是否已上牌/有录入车牌号则视为已上牌/ 0 已上牌 1已预约未上牌 2未预约
        leaseCar.setCreateBy(userSession.getUserId());
        leaseCar.setUpdateBy(userSession.getUserId());
        int row = leaseCarService.updateByPrimaryKey(leaseCar);
        //处理创建车辆

        //车辆-购车融资方 （一对多）
        leaseSchemeCarFinancingerService.deleteByCarId(leaseCar.getId());
        LeaseSchemeCarFinancinger leaseSchemeCarFinancinger = new LeaseSchemeCarFinancinger();
        leaseSchemeCarFinancinger.setCarId(leaseCar.getId());//车辆主键ID
        leaseSchemeCarFinancinger.setCarBuyFinancingerId(carBuyFinancingerId);//融资方主键ID
        leaseSchemeCarFinancinger.setIsEnable(true);
        leaseSchemeCarFinancinger.setCreateBy(userSession.getUserId());
        leaseSchemeCarFinancinger.setUpdateBy(userSession.getUserId());
        leaseSchemeCarFinancingerService.insertSelective(leaseSchemeCarFinancinger);
        //车辆-购车融资方 （一对多）

        return true;

    }

    /**
     * @param paramsMap
     * @return
     */
    @Override
    public List<LeaseCarExport> findLeaseCarExport(Map<String, Object> paramsMap) {
        List<LeaseCarExport> leaseCarList = leaseCarService.findLeaseCarExport(paramsMap);
        return leaseCarList;
    }

    /**
     * 修改车辆贷后的处理方案
     *
     * @param leaseCar
     * @return
     * @throws GMException
     */
    @Override
    public int updateDealStatus(LeaseCar leaseCar) throws GMException {
        int row = leaseCarService.updateDealStatus(leaseCar);
        return row;
    }
}
