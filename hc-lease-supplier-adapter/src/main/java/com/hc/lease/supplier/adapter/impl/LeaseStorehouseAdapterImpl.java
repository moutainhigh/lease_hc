package com.hc.lease.supplier.adapter.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.model.LeaseArea;
import com.hc.lease.baseInfo.model.LeaseBranchCompany;
import com.hc.lease.baseInfo.model.LeaseDealer;
import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.baseInfo.service.api.*;
import com.hc.lease.common.core.constant.UseType;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.excel.poi.vo.LeaseStorehouseExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseStorehouseTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.supplier.adapter.api.LeaseStorehouseAdapter;
import com.hc.lease.supplier.model.LeaseCarSupplier;
import com.hc.lease.supplier.model.LeaseStorehouse;
import com.hc.lease.supplier.service.api.LeaseCarService;
import com.hc.lease.supplier.service.api.LeaseStorehouseService;
import com.hc.lease.supplier.vo.LeaseStorehouses;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 仓库AdapterImpl
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseStorehouseAdapter")
public class LeaseStorehouseAdapterImpl implements LeaseStorehouseAdapter {

	@Autowired
	private LeaseStorehouseService leaseStorehouseService;
    @Autowired
    private LeaseBranchCompanyService leaseBranchCompanyService;
    @Autowired
    private LeaseAreaService leaseAreaService;
    @Autowired
    private LeaseDealerService leaseDealerService;
    @Autowired
    private LeaseCommonService leaseCommonService;
    @Autowired
    private LeaseUseUsedService leaseUseUsedService;

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
        List<LeaseStorehouse> leaseStorehouseList = leaseStorehouseService.findByName(params);
        if (leaseStorehouseList != null) {
            if (leaseStorehouseList.size() > 0) {
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
     * 根据编号是否存在
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
        List<LeaseStorehouse> leaseStorehouseList = leaseStorehouseService.findByName(params);
        if (leaseStorehouseList != null) {
            if (leaseStorehouseList.size() > 0) {
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
     * 检测数据是否被使用
     *
     * @param id
     * @return
     * @throws GMException
     */
    public Map<String, Object> checkByStorehouseIsExist(Long id) throws GMException {
        List exceptionMessageList = new ArrayList();
        Map<String, Object> backMap = Maps.newHashMap();
        boolean item = false;
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("usedId", id);
        paramsMap.put("usedType", UsedType.TYPE_LEASE_STOREHOUSE);
        List<LeaseUseUsed> leaseUseUsedList = leaseCommonService.selectByUsed(paramsMap);

        //List<LeaseCar> leaseCarList = leaseCarService.findByStorehouseId(ids);
        if (leaseUseUsedList != null) {
            if (leaseUseUsedList.size() > 0) {
                item = true;
                LeaseStorehouse leaseStorehouse = leaseStorehouseService.selectByPrimaryKey(id);
                Map<String, Object> exceptionMessageMap = Maps.newHashMap();
                exceptionMessageMap = new HashMap<String, Object>();
                exceptionMessageMap.put("message", leaseStorehouse.getName());
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

        List<LeaseBranchCompany> list=leaseBranchCompanyService.findAll(null);
        List<LeaseArea> leaseAreaList=leaseAreaService.findAreaByEnableAndModel(null);
        List<LeaseDealer> leaseTwoDealerList=leaseDealerService.selectByGrade(2);
        List<LeaseDealer> leaseDealers=leaseDealerService.selectByGrade(1);
        Map<String,Object> map=new HashMap();
        map.put("leaseBranchCompanyList",list);
        map.put("leaseAreaList",leaseAreaList);
        map.put("leaseDealerList",leaseDealers);
        map.put("leaseTwoDealerList",leaseTwoDealerList);
        return map;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {
        int row = leaseStorehouseService.disableByPrimaryKey(params);
        return row;
    }

    public int updateSort(LeaseStorehouses leaseStorehouses) {
        if(leaseStorehouses.getLeaseStorehouses()!=null && leaseStorehouses.getLeaseStorehouses().size()>0){
            List<LeaseStorehouse> leaseStorehouseList=leaseStorehouses.getLeaseStorehouses();
            for (LeaseStorehouse leaseStorehouse : leaseStorehouseList) {
                leaseStorehouseService.updateSort(leaseStorehouse);
            }
        }
        return 1;

    }

    public int updateDefaultSelected(Map<String, Object> paramsMap) {
        int row =  leaseStorehouseService.updateDefaultSelected(paramsMap);
        return row;
    }

    public List<LeaseStorehouse> findAllNoPage(Map param) {

        List<LeaseStorehouse> leaseStorehouseList=  leaseStorehouseService.findAllNoPage(param);

        return leaseStorehouseList;
    }


    public int deleteByPrimaryKey(Long id) throws GMException {
        Map<String, Object> isExist = checkByStorehouseIsExist(id);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }
        int row = leaseStorehouseService.deleteByPrimaryKey(id);
        leaseUseUsedService.deleteByUse(id,UseType.TYPE_LEASE_STOREHOUSE);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row=leaseStorehouseService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseStorehouse record) throws GMException {
        boolean bool = checkByNameIsExist(record.getName(), record.getId());
        if(bool){
            throw new GMException(GMExceptionConstant.NAME_REPEAT);
        }
        record = leaseStorehouseService.insert(record);

        //插入使用和被使用的数据
      /*  if(record.getBelongType()==0) {
            leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBelongId(), null, UseType.TYPE_LEASE_STOREHOUSE, UsedType.TYPE_LEASE_BRANCH_COMPANY);
        }else{
            leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBelongId(), null, UseType.TYPE_LEASE_STOREHOUSE, UsedType.TYPE_LEASE_DEALER);
        }*/

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseStorehouse record) throws GMException {
        boolean bool = checkByNameIsExist(record.getName(), record.getId());
        if(bool){
            throw new GMException(GMExceptionConstant.NAME_REPEAT);
        }

        boolean b = checkByNumberIsExist(record.getNumber(), record.getId());
        if(b){
            throw new GMException(GMExceptionConstant.NUMBER_REPEAT);
        }

        record.setDefaultSelected(false);

        record = leaseStorehouseService.insertSelective(record);

        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getCompanyId(), null, UseType.TYPE_LEASE_STOREHOUSE, UsedType.TYPE_LEASE_BRANCH_COMPANY);
        //插入使用和被使用的数据
        /*if(record.getBelongType()==0) {
            leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBelongId(), null, UseType.TYPE_LEASE_STOREHOUSE, UsedType.TYPE_LEASE_BRANCH_COMPANY);
        }else{
            leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBelongId(), null, UseType.TYPE_LEASE_STOREHOUSE, UsedType.TYPE_LEASE_DEALER);
        }*/
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int insertList(List<LeaseStorehouse> list) throws GMException {
        return 0;
    }

   /* public int insert(List<LeaseStorehouse> record) throws GMException {
        int row = leaseStorehouseService.insert(record);
        return row;
    }

    public int insertSelective(List<LeaseStorehouse> record) throws GMException {
        int row = leaseStorehouseService.insertSelective(record);
        return row;
    }*/

    public int updateByPrimaryKeySelective(LeaseStorehouse record) throws GMException {
        boolean bool = checkByNameIsExist(record.getName(), record.getId());
        if(bool){
            throw new GMException(GMExceptionConstant.NAME_REPEAT);
        }

        boolean b = checkByNumberIsExist(record.getNumber(), record.getId());
        if(b){
            throw new GMException(GMExceptionConstant.NUMBER_REPEAT);
        }
        int row = leaseStorehouseService.updateByPrimaryKeySelective(record);
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_STOREHOUSE);
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getCompanyId(), null, UseType.TYPE_LEASE_STOREHOUSE, UsedType.TYPE_LEASE_BRANCH_COMPANY);
      /*  if(record.getBelongType()==0) {
            leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBelongId(), null, UseType.TYPE_LEASE_STOREHOUSE, UsedType.TYPE_LEASE_BRANCH_COMPANY);
        }else{
            leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBelongId(), null, UseType.TYPE_LEASE_STOREHOUSE, UsedType.TYPE_LEASE_DEALER);
        }*/

        return row;
    }

    public int updateByPrimaryKey(LeaseStorehouse record) throws GMException {
        int row = leaseStorehouseService.updateByPrimaryKey(record);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getCompanyId(), null, UseType.TYPE_LEASE_STOREHOUSE, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        return row;
    }

  /*  public int updateByPrimaryKeySelective(List<LeaseStorehouse> record) throws GMException {
        int row = leaseStorehouseService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(List<LeaseStorehouse> record) throws GMException {
        int row = leaseStorehouseService.updateByPrimaryKey(record);
        return row;
    }*/

    public LeaseStorehouse selectByPrimaryKey(Long id) throws GMException {
        LeaseStorehouse leaseStorehouse = leaseStorehouseService.selectByPrimaryKey(id);
        return leaseStorehouse;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseStorehouse> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseStorehouse> page = leaseStorehouseService.findPage(pageNum, pageSize,paramsMap);
        return page;
    }

    public List<LeaseStorehouse> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseStorehouse> leaseStorehouseList = leaseStorehouseService.findAll(paramsMap);
        return leaseStorehouseList;
    }


    public LeaseStorehouseExcelBackInfo importExcelStorehouse(List<LeaseStorehouseTemplate> leaseStorehouseTemplates) throws GMException {
        LeaseStorehouseExcelBackInfo leaseStorehouseExcelBackInfo = null;
        if (leaseStorehouseTemplates != null) {
            if (leaseStorehouseTemplates.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                List<Map> backInfoList = new ArrayList<Map>();
                for (int i = 0; i < leaseStorehouseTemplates.size(); i++) {
                    LeaseStorehouseTemplate  leaseStorehouseTemplate = leaseStorehouseTemplates.get(i);
                    String number = leaseStorehouseTemplate.getNumber();
                    String name = leaseStorehouseTemplate.getName();
                    String companyName = leaseStorehouseTemplate.getCompanyName();
                    String maxCardSum = leaseStorehouseTemplate.getMaxCardSum();

                    if (StringUtils.isBlank(number) || StringUtils.isBlank(name) || StringUtils.isBlank(companyName)
                            || StringUtils.isBlank(maxCardSum)
                            ) {
                        leaseStorehouseTemplate.setUpdateState("失败，缺少必填项");
                        failNum++;
                        continue;
                    }
                    Map<String,Object> param=Maps.newHashMap();
                    param.put("name",leaseStorehouseTemplate.getCompanyName());
                    List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyService.findByName(param);
                    if(leaseBranchCompanyList==null ||leaseBranchCompanyList.size()==0){
                        leaseStorehouseTemplate.setUpdateState("失败,分公司名称不存在");
                        failNum++;
                        continue;
                    }

                    Map<String,Object> params=Maps.newHashMap();
                    params.put("name",leaseStorehouseTemplate.getName());
                    List<LeaseStorehouse> leaseStorehouseList = leaseStorehouseService.findByName(params);
                    if(leaseStorehouseList!=null && leaseStorehouseList.size()>0){
                        boolean b = checkByNumberIsExist(leaseStorehouseTemplate.getNumber(), leaseStorehouseList.get(0).getId());
                        if(b){
                            leaseStorehouseTemplate.setUpdateState("失败，编号重复");
                            failNum++;
                            continue;
                        }
                        for (int j = 0; j < leaseStorehouseList.size(); j++) {
                            LeaseStorehouse leaseStorehouse = leaseStorehouseList.get(j);
                            dualUpdateStorehouseImportExcel(leaseStorehouseTemplate,leaseStorehouse,leaseBranchCompanyList.get(0).getId());//处理仓库数据导入/修改
                        }
                    } else {
                        boolean b = checkByNumberIsExist(leaseStorehouseTemplate.getNumber(), null);
                        if(b){
                            leaseStorehouseTemplate.setUpdateState("失败，编号重复");
                            failNum++;
                            continue;
                        }
                        dualInsertStorehouseImportExcel(leaseStorehouseTemplate,leaseBranchCompanyList.get(0).getId());//处理仓库数据导入/新增
                    }
                    successNum++;
                    leaseStorehouseTemplate.setUpdateState("成功");

                }
                leaseStorehouseExcelBackInfo = new LeaseStorehouseExcelBackInfo();
                leaseStorehouseExcelBackInfo.setFailNum(failNum);//失败数量
                leaseStorehouseExcelBackInfo.setSuccessNum(successNum);//成功数量
                leaseStorehouseExcelBackInfo.setBackInfo(backInfoList);//反馈信息
                leaseStorehouseExcelBackInfo.setLeaseStorehouseTemplates(leaseStorehouseTemplates);
            }
        }
        return leaseStorehouseExcelBackInfo;
    }

    private void dualInsertStorehouseImportExcel(LeaseStorehouseTemplate leaseStorehouseTemplate, Long id) throws GMException {
        LeaseStorehouse storehouse=new LeaseStorehouse();
        storehouse.setName(leaseStorehouseTemplate.getName());
        storehouse.setNumber(leaseStorehouseTemplate.getNumber());
        storehouse.setMaxCardSum(leaseStorehouseTemplate.getMaxCardSum());
        storehouse.setCompanyId(id);
        storehouse.setContacts(leaseStorehouseTemplate.getContacts());
        storehouse.setContactPhone(leaseStorehouseTemplate.getContactPhone());
        storehouse.setAddress(leaseStorehouseTemplate.getAddress());
        storehouse.setRemarks(leaseStorehouseTemplate.getRemarks());
        storehouse.setDefaultSelected(false);
        LeaseStorehouse record = leaseStorehouseService.insertSelective(storehouse);
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getCompanyId(), null, UseType.TYPE_LEASE_STOREHOUSE, UsedType.TYPE_LEASE_BRANCH_COMPANY);
    }

    private void dualUpdateStorehouseImportExcel(LeaseStorehouseTemplate leaseStorehouseTemplate, LeaseStorehouse leaseStorehouse, Long id) throws GMException {
        LeaseStorehouse storehouse=new LeaseStorehouse();
        storehouse.setId(leaseStorehouse.getId());
        storehouse.setName(leaseStorehouseTemplate.getName());
        storehouse.setNumber(leaseStorehouseTemplate.getNumber());
        storehouse.setMaxCardSum(leaseStorehouseTemplate.getMaxCardSum());
        storehouse.setCompanyId(id);
        storehouse.setContacts(leaseStorehouseTemplate.getContacts());
        storehouse.setContactPhone(leaseStorehouseTemplate.getContactPhone());
        storehouse.setAddress(leaseStorehouseTemplate.getAddress());
        storehouse.setRemarks(leaseStorehouseTemplate.getRemarks());
        leaseStorehouseService.updateByPrimaryKeySelective(storehouse);
        leaseUseUsedService.deleteByUse(leaseStorehouse.getId(), UseType.TYPE_LEASE_STOREHOUSE);
        leaseCommonService.insertUseUsed(leaseStorehouse.getId(), leaseStorehouse.getName(), id, null, UseType.TYPE_LEASE_STOREHOUSE, UsedType.TYPE_LEASE_BRANCH_COMPANY);
    }


}
