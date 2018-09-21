package com.hc.lease.supplier.adapter.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.baseInfo.service.api.LeaseCommonService;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.excel.poi.vo.LeaseGpsSupplierExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseGpsSupplierTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.supplier.adapter.api.LeaseGpsSupplierAdapter;
import com.hc.lease.supplier.model.LeaseGpsSupplier;
import com.hc.lease.supplier.service.api.LeaseCarService;
import com.hc.lease.supplier.service.api.LeaseGpsSupplierService;
import com.hc.lease.supplier.vo.LeaseGpsSuppliers;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GPS供应商表AdapterImpl
 *
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseGpsSupplierAdapter")
public class LeaseGpsSupplierAdapterImpl implements LeaseGpsSupplierAdapter {

    @Autowired
    private LeaseGpsSupplierService leaseGpsSupplierService;
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
        List<LeaseGpsSupplier> leaseGpsSupplierList = leaseGpsSupplierService.findByName(params);
        if (leaseGpsSupplierList != null) {
            if (leaseGpsSupplierList.size() > 0) {
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
     * 检测编号是否存在
     *
     * @param number
     * @return
     * @throws GMException
     */
    public boolean checkByNumberIsExist(String number, Long id) throws GMException {
        boolean item = false;
        Map params = Maps.newHashMap();
        params.put("number", number);
        params.put("id", id);
        List<LeaseGpsSupplier> leaseGpsSupplierList = leaseGpsSupplierService.findByName(params);
        if (leaseGpsSupplierList != null) {
            if (leaseGpsSupplierList.size() > 0) {
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
    public Map<String, Object> checkByGpsSupplierIsExist(Long id) throws GMException {
        List exceptionMessageList = new ArrayList();
        Map<String, Object> backMap = Maps.newHashMap();
        boolean item = false;
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("usedId", id);
        paramsMap.put("usedType", UsedType.TYPE_LEASE_GPS_SUPPLIER);
        List<LeaseUseUsed> leaseUseUsedList = leaseCommonService.selectByUsed(paramsMap);
        //List<LeaseCar> leaseCarList = leaseCarService.findByGpsSupplierId(ids);
        if (leaseUseUsedList != null) {
            if (leaseUseUsedList.size() > 0) {
                item = true;
                LeaseGpsSupplier leaseGpsSupplier = leaseGpsSupplierService.selectByPrimaryKey(id);
                Map<String, Object> exceptionMessageMap = Maps.newHashMap();
                exceptionMessageMap = new HashMap<String, Object>();
                exceptionMessageMap.put("message", leaseGpsSupplier.getName());
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
        return null;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {
        int row = leaseGpsSupplierService.disableByPrimaryKey(params);
        return row;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        Map<String, Object> isExist = checkByGpsSupplierIsExist(id);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }

        int row = leaseGpsSupplierService.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseGpsSupplierService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseGpsSupplier record) throws GMException {
        record = leaseGpsSupplierService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseGpsSupplier record) throws GMException {
        boolean bool = checkByNameIsExist(record.getName(), record.getId());
        if (bool) {
            throw new GMException(GMExceptionConstant.NAME_REPEAT);
        }

        boolean b = checkByNumberIsExist(record.getNumber(), record.getId());
        if (b) {
            throw new GMException(GMExceptionConstant.NUMBER_REPEAT);
        }

        record = leaseGpsSupplierService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }


    public int insertList(List<LeaseGpsSupplier> list) throws GMException {
        return 0;
    }

   /* public int insert(List<LeaseGpsSupplier> record) throws GMException {
        int row = leaseGpsSupplierService.insert(record);
        return row;
    }

    public int insertSelective(List<LeaseGpsSupplier> record) throws GMException {
        int row = leaseGpsSupplierService.insertSelective(record);
        return row;
    }*/

    public int updateByPrimaryKeySelective(LeaseGpsSupplier record) throws GMException {
        boolean bool = checkByNameIsExist(record.getName(), record.getId());
        if (bool) {
            throw new GMException(GMExceptionConstant.NAME_REPEAT);
        }
        boolean b = checkByNumberIsExist(record.getNumber(), record.getId());
        if (b) {
            throw new GMException(GMExceptionConstant.NUMBER_REPEAT);
        }


        int row = leaseGpsSupplierService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseGpsSupplier record) throws GMException {
        int row = leaseGpsSupplierService.updateByPrimaryKey(record);
        return row;
    }

   /* public int updateByPrimaryKeySelective(List<LeaseGpsSupplier> record) throws GMException {
        int row = leaseGpsSupplierService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(List<LeaseGpsSupplier> record) throws GMException {
        int row = leaseGpsSupplierService.updateByPrimaryKey(record);
        return row;
    }*/

    public LeaseGpsSupplier selectByPrimaryKey(Long id) throws GMException {
        LeaseGpsSupplier leaseGpsSupplier = leaseGpsSupplierService.selectByPrimaryKey(id);
        return leaseGpsSupplier;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseGpsSupplier> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseGpsSupplier> page = leaseGpsSupplierService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseGpsSupplier> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseGpsSupplier> leaseGpsSupplierList = leaseGpsSupplierService.findAll(paramsMap);
        return leaseGpsSupplierList;
    }

    /**
     * 导出车辆录入模板需要的数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public List<String> findExportExcelModel(Map<String, Object> paramsMap) throws GMException {
        List<String> leaseGpsSupplierList = leaseGpsSupplierService.findExportExcelModel(paramsMap);
        return leaseGpsSupplierList;
    }

    public int updateSort(LeaseGpsSuppliers leaseGpsSuppliers) {

        if(leaseGpsSuppliers.getLeaseGpsSuppliers()!=null && leaseGpsSuppliers.getLeaseGpsSuppliers().size()>0){
            List<LeaseGpsSupplier> leaseGpsSupplierList=leaseGpsSuppliers.getLeaseGpsSuppliers();
            for (LeaseGpsSupplier leaseGpsSupplier : leaseGpsSupplierList) {
                leaseGpsSupplierService.updateSort(leaseGpsSupplier);
            }
        }

        return 1;
    }

    public List<LeaseGpsSupplier> findAllNoPage(Map param) {
        List<LeaseGpsSupplier> leaseGpsSupplierList=leaseGpsSupplierService.findAllNoPage(param);
        return leaseGpsSupplierList;
    }

    public LeaseGpsSupplierExcelBackInfo importExcelGpsSupplier(List<LeaseGpsSupplierTemplate> leaseGpsSupplierTemplates) throws GMException {

        LeaseGpsSupplierExcelBackInfo leaseGpsSupplierExcelBackInfo = null;
        if (leaseGpsSupplierTemplates != null) {
            if (leaseGpsSupplierTemplates.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                List<Map> backInfoList = new ArrayList<Map>();
                for (int i = 0; i < leaseGpsSupplierTemplates.size(); i++) {
                    LeaseGpsSupplierTemplate  leaseGpsSupplierTemplate = leaseGpsSupplierTemplates.get(i);
                    String number = leaseGpsSupplierTemplate.getNumber();
                    String name = leaseGpsSupplierTemplate.getName();
                    if (StringUtils.isBlank(number) || StringUtils.isBlank(name)) {
                        leaseGpsSupplierTemplate.setUpdateState("失败，缺少必填项");
                        failNum++;
                        continue;
                    }
                    Map<String,Object> params=Maps.newHashMap();
                    params.put("name",leaseGpsSupplierTemplate.getName());
                    List<LeaseGpsSupplier> leaseGpsSupplierList = leaseGpsSupplierService.findByName(params);
                    if(leaseGpsSupplierList!=null && leaseGpsSupplierList.size()>0){
                        boolean b = checkByNumberIsExist(leaseGpsSupplierTemplate.getNumber(), leaseGpsSupplierList.get(0).getId());
                        if (b) {
                            leaseGpsSupplierTemplate.setUpdateState("失败，编号重复");
                            failNum++;
                            continue;
                        }
                        for (int j = 0; j < leaseGpsSupplierList.size(); j++) {
                            LeaseGpsSupplier leaseGpsSupplier = leaseGpsSupplierList.get(j);
                            dualUpdateGpsSupplierImportExcel(leaseGpsSupplierTemplate,leaseGpsSupplier);//处理GPS供应商数据导入/修改
                        }
                    } else {
                        boolean b = checkByNumberIsExist(leaseGpsSupplierTemplate.getNumber(), null);
                        if (b) {
                            leaseGpsSupplierTemplate.setUpdateState("失败，编号重复");
                            failNum++;
                            continue;
                        }
                        dualInsertGpsSupplierImportExcel(leaseGpsSupplierTemplate);//处理GPS供应商数据导入/新增
                    }
                    successNum++;
                    leaseGpsSupplierTemplate.setUpdateState("成功");

                }
                leaseGpsSupplierExcelBackInfo = new LeaseGpsSupplierExcelBackInfo();
                leaseGpsSupplierExcelBackInfo.setFailNum(failNum);//失败数量
                leaseGpsSupplierExcelBackInfo.setSuccessNum(successNum);//成功数量
                leaseGpsSupplierExcelBackInfo.setBackInfo(backInfoList);//反馈信息
                leaseGpsSupplierExcelBackInfo.setLeaseGpsSupplierTemplates(leaseGpsSupplierTemplates);
            }
        }
        return leaseGpsSupplierExcelBackInfo;


    }

    private void dualInsertGpsSupplierImportExcel(LeaseGpsSupplierTemplate leaseGpsSupplierTemplate) throws GMException {
        LeaseGpsSupplier gpsSupplier=new LeaseGpsSupplier();
        gpsSupplier.setName(leaseGpsSupplierTemplate.getName());
        gpsSupplier.setNumber(leaseGpsSupplierTemplate.getNumber());
        gpsSupplier.setGpsCost(new BigDecimal(StringUtils.isNotEmpty(leaseGpsSupplierTemplate.getGpsCost())?leaseGpsSupplierTemplate.getGpsCost():"0"));
        gpsSupplier.setContacts(leaseGpsSupplierTemplate.getContacts());
        gpsSupplier.setContactPhone(leaseGpsSupplierTemplate.getContactPhone());
        gpsSupplier.setAddress(leaseGpsSupplierTemplate.getAddress());
        gpsSupplier.setRemarks(leaseGpsSupplierTemplate.getRemarks());
        leaseGpsSupplierService.insertSelective(gpsSupplier);
    }

    private void dualUpdateGpsSupplierImportExcel(LeaseGpsSupplierTemplate leaseGpsSupplierTemplate, LeaseGpsSupplier leaseGpsSupplier) throws GMException {
        LeaseGpsSupplier gpsSupplier=new LeaseGpsSupplier();
        gpsSupplier.setId(leaseGpsSupplier.getId());
        gpsSupplier.setName(leaseGpsSupplierTemplate.getName());
        gpsSupplier.setNumber(leaseGpsSupplierTemplate.getNumber());
        gpsSupplier.setGpsCost(new BigDecimal(StringUtils.isNotEmpty(leaseGpsSupplierTemplate.getGpsCost())?leaseGpsSupplierTemplate.getGpsCost():"0"));
        gpsSupplier.setContacts(leaseGpsSupplierTemplate.getContacts());
        gpsSupplier.setContactPhone(leaseGpsSupplierTemplate.getContactPhone());
        gpsSupplier.setAddress(leaseGpsSupplierTemplate.getAddress());
        gpsSupplier.setRemarks(leaseGpsSupplierTemplate.getRemarks());
        leaseGpsSupplierService.updateByPrimaryKeySelective(gpsSupplier);
    }
}
