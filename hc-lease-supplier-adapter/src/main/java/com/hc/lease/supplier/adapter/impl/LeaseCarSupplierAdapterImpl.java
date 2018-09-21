package com.hc.lease.supplier.adapter.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.baseInfo.service.api.LeaseBankService;
import com.hc.lease.baseInfo.service.api.LeaseCommonService;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.excel.poi.vo.CarSupplierImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseCarSupplierTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.supplier.adapter.api.LeaseCarSupplierAdapter;
import com.hc.lease.supplier.model.LeaseCarSupplier;
import com.hc.lease.supplier.service.api.LeaseCarSupplierService;
import com.hc.lease.supplier.service.api.LeasePurchaseContractService;
import com.hc.lease.supplier.vo.LeaseCarSupplierPageVo;
import com.hc.lease.supplier.vo.LeaseCarSuppliers;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 车辆供应商表AdapterImpl
 *
 * @author Qiang
 * @version 2017-05-05
 */
@Service("leaseCarSupplierAdapter")
public class LeaseCarSupplierAdapterImpl implements LeaseCarSupplierAdapter {

    @Autowired
    private LeaseCarSupplierService leaseCarSupplierService;
    @Autowired
    private LeaseCommonService leaseCommonService;

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
        List<LeaseCarSupplier> leaseCarSupplierList = leaseCarSupplierService.findByName(params);
        if (leaseCarSupplierList != null) {
            if (leaseCarSupplierList.size() > 0) {
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
    public Map<String, Object> checkByCarSupplierIsExist(Long id) throws GMException {
        List exceptionMessageList = new ArrayList();
        Map<String, Object> backMap = Maps.newHashMap();
        boolean item = false;
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("usedId", id);
        paramsMap.put("usedType", UsedType.TYPE_LEASE_CARSUPPLIER);
        List<LeaseUseUsed> leaseUseUsedList = leaseCommonService.selectByUsed(paramsMap);
        //List<LeasePurchaseContract> leasePurchaseContractList = leasePurchaseContractService.findByCarSupplierId(ids);
        if (leaseUseUsedList != null) {
            if (leaseUseUsedList.size() > 0) {
                item = true;
                LeaseCarSupplier leaseCarSupplier = leaseCarSupplierService.selectByPrimaryKey(id);
                Map<String, Object> exceptionMessageMap = Maps.newHashMap();
                exceptionMessageMap = new HashMap<String, Object>();
                exceptionMessageMap.put("message", leaseCarSupplier.getName());
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
        Map<String, Object> map = new HashMap();

        /*
        List<LeaseBank> leaseBankList=leaseBankService.findAll(null);
        map.put("leaseBankList",leaseBankList);
        */

        return map;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {
        int row = leaseCarSupplierService.disableByPrimaryKey(params);
        return row;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {

        Map<String, Object> isExist = checkByCarSupplierIsExist(id);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }
        int row = leaseCarSupplierService.deleteByPrimaryKey(id);
      /*  LeaseInvoiceHeader leaseInvoiceHeader= leaseInvoiceHeaderService.selectByCarSupplierIdAndType(id);
    if(leaseInvoiceHeader!=null){
        row=leaseInvoiceHeaderService.deleteByPrimaryKey(leaseInvoiceHeader.getId());
    }*/
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseCarSupplierService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseCarSupplier record) throws GMException {
        record = leaseCarSupplierService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseCarSupplier record) throws GMException {
        boolean bool = checkByNameIsExist(record.getName(), record.getId());
        if (bool) {
            throw new GMException(GMExceptionConstant.NAME_REPEAT);
        }

        record = leaseCarSupplierService.insertSelective(record);

       /* LeaseInvoiceHeader leaseInvoiceHeader=new LeaseInvoiceHeader();
        leaseInvoiceHeader.setAccount(record.getAccount());
        leaseInvoiceHeader.setAccountName(record.getAccountName());
        leaseInvoiceHeader.setBankId(record.getBankId());
        leaseInvoiceHeader.setPersonalId(record.getId());
        leaseInvoiceHeader.setType(TYPE_CARSUPPLIER);
        leaseInvoiceHeaderService.insertSelective(leaseInvoiceHeader);*/
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseCarSupplier record) throws GMException {
        boolean bool = checkByNameIsExist(record.getName(), record.getId());
        if (bool) {
            throw new GMException(GMExceptionConstant.NAME_REPEAT);
        }
        int row = leaseCarSupplierService.updateByPrimaryKeySelective(record);
/*
        LeaseInvoiceHeader leaseInvoiceHeader= leaseInvoiceHeaderService.selectByCarSupplierIdAndType(record.getId());
        if(leaseInvoiceHeader!=null){
            LeaseInvoiceHeader _leaseInvoiceHeader=new LeaseInvoiceHeader();
            _leaseInvoiceHeader.setAccountName(record.getAccountName());
            _leaseInvoiceHeader.setAccount(record.getAccount());
            _leaseInvoiceHeader.setBankId(record.getBankId());
            _leaseInvoiceHeader.setId(leaseInvoiceHeader.getId());
            leaseInvoiceHeaderService.updateByPrimaryKeySelective(_leaseInvoiceHeader);
        }*/
        return row;
    }

    public int updateByPrimaryKey(LeaseCarSupplier record) throws GMException {
        int row = leaseCarSupplierService.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseCarSupplier> list) throws GMException {
        return 0;
    }


    public LeaseCarSupplier selectByPrimaryKey(Long id) throws GMException {
        LeaseCarSupplier leaseCarSupplier = leaseCarSupplierService.selectByPrimaryKey(id);
        return leaseCarSupplier;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseCarSupplier> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseCarSupplier> page = leaseCarSupplierService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseCarSupplier> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarSupplier> leaseCarSupplierList = leaseCarSupplierService.findAll(paramsMap);
        return leaseCarSupplierList;
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
        List<String> leaseCarSupplierList = leaseCarSupplierService.findExportExcelModel(params);
        return leaseCarSupplierList;
    }

    public int updateSort(LeaseCarSuppliers leaseCarSuppliers) {
        if(leaseCarSuppliers.getLeaseCarSuppliers()!=null && leaseCarSuppliers.getLeaseCarSuppliers().size()>0){
            List<LeaseCarSupplier> leaseCarSupplierList=leaseCarSuppliers.getLeaseCarSuppliers();
            for (LeaseCarSupplier leaseCarSupplier : leaseCarSupplierList) {
                leaseCarSupplierService.updateSort(leaseCarSupplier);
            }
        }
        return 1;
    }

    public List<LeaseCarSupplierPageVo> findAllNoPage(Map params) {
        List<LeaseCarSupplierPageVo> leaseCarSupplierList=  leaseCarSupplierService.findAllNoPage(params);
        return leaseCarSupplierList;
    }

    public CarSupplierImportExcelBackInfo importExcelCarSupplier(List<LeaseCarSupplierTemplate> carSupplierTemplates, UserSession userSession) throws GMException, ParseException {

        CarSupplierImportExcelBackInfo carSupplierImportExcelBackInfo = null;
        if (carSupplierTemplates != null) {
            if (carSupplierTemplates.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                List<Map> backInfoList = new ArrayList<Map>();
                for (int i = 0; i < carSupplierTemplates.size(); i++) {
                    LeaseCarSupplierTemplate  leaseCarSupplierTemplate = carSupplierTemplates.get(i);
                    String internalNumber = leaseCarSupplierTemplate.getInternalNumber();
                    String name = leaseCarSupplierTemplate.getName();

                    if (StringUtils.isBlank(internalNumber) || StringUtils.isBlank(name)
                            ) {
                        leaseCarSupplierTemplate.setUpdateState("失败，缺少必填项");
                        failNum++;
                        continue;
                    }

                    Map<String,Object> params=Maps.newHashMap();
                    params.put("name",leaseCarSupplierTemplate.getName());
                    List<LeaseCarSupplier> leaseCarSuppliers = leaseCarSupplierService.findByName(params);
                    if(leaseCarSuppliers!=null && leaseCarSuppliers.size()>0){
                        for (int j = 0; j < leaseCarSuppliers.size(); j++) {
                            LeaseCarSupplier leaseCarSupplier = leaseCarSuppliers.get(j);
                            dualUpdateCarSupplierImportExcel(leaseCarSupplierTemplate, userSession, leaseCarSupplier);//处理车辆供应商数据导入/修改
                        }
                    } else {
                        dualInsertCarSupplierImportExcel(leaseCarSupplierTemplate, userSession);//处理车辆供应商数据导入/新增
                    }

                    successNum++;
                    leaseCarSupplierTemplate.setUpdateState("成功");

                }

                carSupplierImportExcelBackInfo = new CarSupplierImportExcelBackInfo();
                carSupplierImportExcelBackInfo.setFailNum(failNum);//失败数量
                carSupplierImportExcelBackInfo.setSuccessNum(successNum);//成功数量
                carSupplierImportExcelBackInfo.setBackInfo(backInfoList);//反馈信息
                carSupplierImportExcelBackInfo.setLeaseCarSupplierTemplates(carSupplierTemplates);
            }
        }

        return carSupplierImportExcelBackInfo;
    }

    private void dualInsertCarSupplierImportExcel(LeaseCarSupplierTemplate leaseCarSupplierTemplate, UserSession userSession) throws GMException, ParseException {

        LeaseCarSupplier carSupplier=new LeaseCarSupplier();
        carSupplier.setName(leaseCarSupplierTemplate.getName());
        carSupplier.setCooperateTime(leaseCarSupplierTemplate.getCooperateTime()!=null?leaseCarSupplierTemplate.getCooperateTime():null);
        carSupplier.setInternalNumber(leaseCarSupplierTemplate.getInternalNumber());
        carSupplier.setAccount(leaseCarSupplierTemplate.getAccount()!=null?leaseCarSupplierTemplate.getAccount():null);
        carSupplier.setAccountName(leaseCarSupplierTemplate.getAccountName()!=null?leaseCarSupplierTemplate.getAccountName():null);
        carSupplier.setBankName(leaseCarSupplierTemplate.getBankName()!=null?leaseCarSupplierTemplate.getBankName():null);
        carSupplier.setContacts(leaseCarSupplierTemplate.getContacts()!=null?leaseCarSupplierTemplate.getContacts():null);
        carSupplier.setContactPhone(leaseCarSupplierTemplate.getContactPhone()!=null?leaseCarSupplierTemplate.getContactPhone():null);
        //carSupplier.setAdvantage(leaseCarSupplierTemplate.getAdvantage()!=null?leaseCarSupplierTemplate.getAdvantage():null);
        carSupplier.setOrganizationNumber(leaseCarSupplierTemplate.getOrganizationNumber()!=null?leaseCarSupplierTemplate.getOrganizationNumber():null);
        carSupplier.setAddress(leaseCarSupplierTemplate.getAddress()!=null?leaseCarSupplierTemplate.getAddress():null);
        carSupplier.setPhone(leaseCarSupplierTemplate.getPhone()!=null?leaseCarSupplierTemplate.getPhone():null);
        carSupplier.setBranchBank(leaseCarSupplierTemplate.getBranchBank()!=null?leaseCarSupplierTemplate.getBranchBank():null);
        carSupplier.setRemarks(leaseCarSupplierTemplate.getRemarks()!=null?leaseCarSupplierTemplate.getRemarks():null);
        carSupplier.setCreateBy(11L);
        leaseCarSupplierService.insertSelective(carSupplier);

    }

    private void dualUpdateCarSupplierImportExcel(LeaseCarSupplierTemplate leaseCarSupplierTemplate, UserSession userSession, LeaseCarSupplier leaseCarSupplier) throws GMException, ParseException {
        //更新车辆供应商数据
        LeaseCarSupplier carSupplier=new LeaseCarSupplier();
        carSupplier.setId(leaseCarSupplier.getId());
        carSupplier.setName(leaseCarSupplierTemplate.getName());
        carSupplier.setCooperateTime(leaseCarSupplierTemplate.getCooperateTime()!=null?leaseCarSupplierTemplate.getCooperateTime():null);
        carSupplier.setInternalNumber(leaseCarSupplierTemplate.getInternalNumber());
        carSupplier.setAccount(leaseCarSupplierTemplate.getAccount()!=null?leaseCarSupplierTemplate.getAccount():null);
        carSupplier.setAccountName(leaseCarSupplierTemplate.getAccountName()!=null?leaseCarSupplierTemplate.getAccountName():null);
        carSupplier.setBankName(leaseCarSupplierTemplate.getBankName()!=null?leaseCarSupplierTemplate.getBankName():null);
        carSupplier.setContacts(leaseCarSupplierTemplate.getContacts()!=null?leaseCarSupplierTemplate.getContacts():null);
        carSupplier.setContactPhone(leaseCarSupplierTemplate.getContactPhone()!=null?leaseCarSupplierTemplate.getContactPhone():null);
        //carSupplier.setAdvantage(leaseCarSupplierTemplate.getAdvantage()!=null?leaseCarSupplierTemplate.getAdvantage():null);
        carSupplier.setOrganizationNumber(leaseCarSupplierTemplate.getOrganizationNumber()!=null?leaseCarSupplierTemplate.getOrganizationNumber():null);
        carSupplier.setAddress(leaseCarSupplierTemplate.getAddress()!=null?leaseCarSupplierTemplate.getAddress():null);
        carSupplier.setPhone(leaseCarSupplierTemplate.getPhone()!=null?leaseCarSupplierTemplate.getPhone():null);
        carSupplier.setBranchBank(leaseCarSupplierTemplate.getBranchBank()!=null?leaseCarSupplierTemplate.getBranchBank():null);
        carSupplier.setRemarks(leaseCarSupplierTemplate.getRemarks()!=null?leaseCarSupplierTemplate.getRemarks():null);
        carSupplier.setUpdateBy(11L);
        leaseCarSupplierService.updateByPrimaryKeySelective(carSupplier);
    }
}
