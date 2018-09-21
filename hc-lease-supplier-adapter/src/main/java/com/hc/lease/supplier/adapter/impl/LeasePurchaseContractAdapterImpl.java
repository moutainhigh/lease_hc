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
import com.hc.lease.common.core.file.UploadFileUtil;
import com.hc.lease.common.core.file.UploadService;
import com.hc.lease.supplier.adapter.api.LeasePurchaseContractAdapter;
import com.hc.lease.supplier.model.LeaseCarSupplier;
import com.hc.lease.supplier.model.LeasePurchaseContract;
import com.hc.lease.supplier.service.api.LeaseCarSupplierService;
import com.hc.lease.supplier.service.api.LeasePurchaseContractService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hc.lease.common.core.constant.DictType.TYPE_BUYCARDCAPITALTYPE;

/**
 * 采购合同AdapterImpl
 *
 * @author Qiang
 * @version 2017-05-10
 */
@Service("leasePurchaseContractAdapter")
public class LeasePurchaseContractAdapterImpl implements LeasePurchaseContractAdapter {

    @Autowired
    private LeasePurchaseContractService leasePurchaseContractService;
    @Autowired
    private LeaseCompanyHeaderService leaseCompanyHeaderService;
    @Autowired
    private LeaseCarBuyFinancingerService leaseCarBuyFinancingerService;
    @Autowired
    private LeaseCarSupplierService leaseCarSupplierService;
    @Autowired
    private LeaseCarBrandsService leaseCarBrandsService;
    @Autowired
    private LeaseCarSeriesService leaseCarSeriesService;
    @Autowired
    private LeaseCarModelService leaseCarModelService;
    @Autowired
    private LeaseDictService leaseDictService;
    @Autowired
    private LeaseCommonService leaseCommonService;
    @Autowired
    private LeaseUseUsedService leaseUseUsedService;


    @Value("${img.url}")
    String imgUrl;

    @Value("${img.maxSize}")
    private String maxSize;//文件大小限制范围

    @Value("${img.fileImgFolder}")
    private String fileImgFolder;//图片存放文件夹路径根目录

    @Value("${supplier.img.fileImgFolder}")
    private String supplierFileImgFolder;//图片存放文件夹路径


    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCompanyHeader> leaseCompanyHeaderList = leaseCompanyHeaderService.findAll(null);
        List<LeaseCarBuyFinancinger> leaseCarBuyFinancingerList = leaseCarBuyFinancingerService.findAll(null);
        List<LeaseCarSupplier> leaseCarSupplierList = leaseCarSupplierService.findAll(null);
        List<LeaseCarBrands> leaseCarBrandses = leaseCarBrandsService.findAll(null);
        List<LeaseCarSeries> leaseCarSeries = leaseCarSeriesService.findAll(null);
        List<LeaseCarModel> leaseCarModels = leaseCarModelService.findAll(null);
        List<LeaseDict> leaseBuyCardCapitalType = leaseDictService.findByType(TYPE_BUYCARDCAPITALTYPE);
        Map<String, Object> map = new HashMap();
        map.put("leaseCompanyHeaderList", leaseCompanyHeaderList);
        map.put("leaseCarBuyFinancingerList", leaseCarBuyFinancingerList);
        map.put("leaseCarSupplierList", leaseCarSupplierList);
        map.put("leaseCarBrandseList", leaseCarBrandses);
        map.put("leaseCarSerieList", leaseCarSeries);
        map.put("leaseCarModelList", leaseCarModels);
        map.put("leaseBuyCardCapitalType", leaseBuyCardCapitalType);
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
        List<LeasePurchaseContract> leasPurchaseContractList = leasePurchaseContractService.findByParams(params);
        if (leasPurchaseContractList != null) {
            if (leasPurchaseContractList.size() > 0) {
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
    public Map<String, Object> checkByPurchaseContractIsExist(Long id) throws GMException {
        List exceptionMessageList = new ArrayList();
        Map<String, Object> backMap = Maps.newHashMap();
        boolean item = false;
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("usedId", id);
        paramsMap.put("usedType", UsedType.TYPE_LEASE_PURCHASE_CONTRACT);
        List<LeaseUseUsed> leaseUseUsedList = leaseCommonService.selectByUsed(paramsMap);
        // List<LeaseInsuranceType> leaseInsuranceTypeList = leaseInsuranceTypeService.findByInsuranceCompanyId(ids);
        if (leaseUseUsedList != null) {
            if (leaseUseUsedList.size() > 0) {
                item = true;
                LeasePurchaseContract leasePurchaseContract = leasePurchaseContractService.selectByPrimaryKey(id);
                Map<String, Object> exceptionMessageMap = Maps.newHashMap();
                exceptionMessageMap = new HashMap<String, Object>();
                exceptionMessageMap.put("message", leasePurchaseContract.getContractNumber());
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


    public int deleteByPrimaryKey(Long id) throws GMException {
        Map<String, Object> isExist = checkByPurchaseContractIsExist(id);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }
        int row = leasePurchaseContractService.deleteByPrimaryKey(id);
        leaseUseUsedService.deleteByUse(id, UseType.TYPE_LEASE_PURCHASECONTRACT);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leasePurchaseContractService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeasePurchaseContract record) throws GMException {
        record = leasePurchaseContractService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    //文件大小 单位KB
    public ResultHashMap insertSelective(LeasePurchaseContract record) throws GMException {

        //检测合同编号是否存在
        boolean plateNumberIsExist = checkByParams("contractNumber", record.getContractNumber(), record.getId());
        if (plateNumberIsExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "contractNumber");
            throw new GMException(GMExceptionConstant.CONTRACTNUMBER_REPEAT, backMap);
        }
        if (record.getScannerImgs().size() > 0) {
            String filePath = UploadFileUtil.dualImgs(record.getScannerImgs(), maxSize, fileImgFolder, supplierFileImgFolder, imgUrl);
            record.setScannerImg(filePath);
        }

        record = leasePurchaseContractService.insertSelective(record);

        leaseCommonService.insertUseUsed(record.getId(), null, record.getCarBuyFinancingerId(), null, UseType.TYPE_LEASE_PURCHASECONTRACT, UsedType.TYPE_LEASE_CAR_BUY_FINANCINGER);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getCarSupplierId(), null, UseType.TYPE_LEASE_PURCHASECONTRACT, UsedType.TYPE_LEASE_CARSUPPLIER);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getCompanyHeaderId(), null, UseType.TYPE_LEASE_PURCHASECONTRACT, UsedType.TYPE_LEASE_COMPANY_HEADER);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getSeriesId(), null, UseType.TYPE_LEASE_PURCHASECONTRACT, UsedType.TYPE_LEASE_CAR_SERIES);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getBrandsId(), null, UseType.TYPE_LEASE_PURCHASECONTRACT, UsedType.TYPE_LEASE_CAR_BRANDS);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getModelId(), null, UseType.TYPE_LEASE_PURCHASECONTRACT, UsedType.TYPE_LEASE_CAR_MODEL);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int insertList(List<LeasePurchaseContract> list) throws GMException {
        return 0;
    }

    public int updateByPrimaryKeySelective(LeasePurchaseContract record) throws GMException {

        //检测合同编号是否存在
        boolean plateNumberIsExist = checkByParams("contractNumber", record.getContractNumber(), record.getId());
        if (plateNumberIsExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "contractNumber");
            throw new GMException(GMExceptionConstant.CONTRACTNUMBER_REPEAT, backMap);
        }
        if (record.getScannerImgs().size() > 0) {
            String filePath = UploadFileUtil.dualImgs(record.getScannerImgs(), maxSize, fileImgFolder, supplierFileImgFolder, imgUrl);
            record.setScannerImg(filePath);
        }
        int row = leasePurchaseContractService.updateByPrimaryKeySelective(record);
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_PURCHASECONTRACT);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getCarBuyFinancingerId(), null, UseType.TYPE_LEASE_PURCHASECONTRACT, UsedType.TYPE_LEASE_CAR_BUY_FINANCINGER);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getCarSupplierId(), null, UseType.TYPE_LEASE_PURCHASECONTRACT, UsedType.TYPE_LEASE_CARSUPPLIER);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getCompanyHeaderId(), null, UseType.TYPE_LEASE_PURCHASECONTRACT, UsedType.TYPE_LEASE_COMPANY_HEADER);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getSeriesId(), null, UseType.TYPE_LEASE_PURCHASECONTRACT, UsedType.TYPE_LEASE_CAR_SERIES);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getBrandsId(), null, UseType.TYPE_LEASE_PURCHASECONTRACT, UsedType.TYPE_LEASE_CAR_BRANDS);
        leaseCommonService.insertUseUsed(record.getId(), null, record.getModelId(), null, UseType.TYPE_LEASE_PURCHASECONTRACT, UsedType.TYPE_LEASE_CAR_MODEL);

        return row;
    }

    public int updateByPrimaryKey(LeasePurchaseContract record) throws GMException {

        //检测合同编号是否存在
        boolean plateNumberIsExist = checkByParams("contractNumber", record.getContractNumber(), record.getId());
        if (plateNumberIsExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "contractNumber");
            throw new GMException(GMExceptionConstant.CONTRACTNUMBER_REPEAT, backMap);
        }

        int row = leasePurchaseContractService.updateByPrimaryKey(record);
        return row;
    }


    public LeasePurchaseContract selectByPrimaryKey(Long id) throws GMException {
        LeasePurchaseContract leasePurchaseContract = leasePurchaseContractService.selectByPrimaryKey(id);
        return leasePurchaseContract;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeasePurchaseContract> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        //paramsMap.put("imgUrl", imgUrl);
        PageInfo<LeasePurchaseContract> page = leasePurchaseContractService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeasePurchaseContract> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeasePurchaseContract> leasePurchaseContractList = leasePurchaseContractService.findAll(paramsMap);
        return leasePurchaseContractList;
    }

    /**
     * 导出车辆录入模板需要的数据
     *
     * @param params
     * @return
     * @throws GMException
     */
    @Override
    public List<String> findExportExcelModel(Map params) throws GMException {
        List<String> leasePurchaseContractList = leasePurchaseContractService.findExportExcelModel(params);
        return leasePurchaseContractList;
    }

    /**
     * 根据采购合同编号查询
     *
     * @param paramsMap
     * @return
     */
    @Override
    public List<LeasePurchaseContract> selectByContractNumber(Map<String, Object> paramsMap) {
        List<LeasePurchaseContract> leasePurchaseContractList = leasePurchaseContractService.selectByContractNumber(paramsMap);
        return leasePurchaseContractList;
    }
}
