package com.hc.lease.baseInfo.adapter.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.adapter.api.LeaseMaintenancePartnerAdapter;
import com.hc.lease.baseInfo.model.LeaseArea;
import com.hc.lease.baseInfo.model.LeaseBranchCompany;
import com.hc.lease.baseInfo.model.LeaseMaintenancePartner;
import com.hc.lease.baseInfo.service.api.*;
import com.hc.lease.baseInfo.vo.LeaseMaintenancePartners;
import com.hc.lease.common.core.constant.AreaModel;
import com.hc.lease.common.core.constant.UseType;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.excel.poi.vo.LeaseBranchCompanyExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseMaintenancePartnerExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseMaintenancePartnerTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 保养维护合作方AdapterImpl
 *
 * @author Tong
 * @version 2017-04-17
 */
@Service("leaseMaintenancePartnerAdapter")
public class LeaseMaintenancePartnerAdapterImpl implements LeaseMaintenancePartnerAdapter {

    @Autowired
    private LeaseMaintenancePartnerService leaseMaintenancePartnerService;

    @Autowired
    private LeaseAreaService leaseAreaService;

    @Autowired
    private LeaseBranchCompanyService leaseBranchCompanyService;

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
        List<LeaseMaintenancePartner> leaseMaintenancePartnerList = leaseMaintenancePartnerService.findByName(params);
        if (leaseMaintenancePartnerList != null) {
            if (leaseMaintenancePartnerList.size() > 0) {
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
        List<LeaseMaintenancePartner> leaseMaintenancePartnerList = leaseMaintenancePartnerService.findByName(params);
        if (leaseMaintenancePartnerList != null) {
            if (leaseMaintenancePartnerList.size() > 0) {
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
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {

        paramsMap.put("isEnable", true);
        paramsMap.put("model", AreaModel.MODEL_MAINTENANCEPARTNER);
        Map<String, Object> map = Maps.newHashMap();
        List<LeaseArea> leaseAreaList = leaseAreaService.findAreaByEnableAndModel(paramsMap);//地区
        map.put("leaseAreaList", leaseAreaList);
        List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyService.findAll(paramsMap);
        map.put("leaseBranchCompanyList", leaseBranchCompanyList);

        return map;
    }

    public ResultHashMap insertSelective(LeaseMaintenancePartner record, UserSession userSession) throws GMException {
        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }
        boolean bool = checkByNumberIsExist(record.getNumber(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "number");
            throw new GMException(GMExceptionConstant.NUMBER_REPEAT, backMap);
        }


        record.setCreateBy(userSession.getUserId());
        record.setUpdateBy(userSession.getUserId());
        record = leaseMaintenancePartnerService.insertSelective(record);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBranchCompanyId(), record.getBranchCompanyName(), UseType.TYPE_LEASE_MAINTENANCE_PARTNER, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseMaintenancePartner record, UserSession userSession) throws GMException {
        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }
        boolean bool = checkByNumberIsExist(record.getNumber(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "number");
            throw new GMException(GMExceptionConstant.NUMBER_REPEAT, backMap);
        }

        record.setUpdateBy(userSession.getUserId());
        int row = leaseMaintenancePartnerService.updateByPrimaryKeySelective(record);
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_MAINTENANCE_PARTNER);
        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBranchCompanyId(), record.getBranchCompanyName(), UseType.TYPE_LEASE_MAINTENANCE_PARTNER, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        return row;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {
        int row = leaseMaintenancePartnerService.disableByPrimaryKey(params);
        return row;
    }



    public int deleteByPrimaryKey(Long id) throws GMException {

        int row = leaseMaintenancePartnerService.deleteByPrimaryKey(id);
        return row;
    }

    /**
     * 根据ID删除记录.批量删除
     *
     * @param ids .
     * @return
     * @throws GMException
     */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseMaintenancePartnerService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseMaintenancePartner record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseMaintenancePartnerService.insert(record);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBranchCompanyId(), record.getBranchCompanyName(), UseType.TYPE_LEASE_MAINTENANCE_PARTNER, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseMaintenancePartner record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseMaintenancePartnerService.insertSelective(record);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBranchCompanyId(), record.getBranchCompanyName(), UseType.TYPE_LEASE_MAINTENANCE_PARTNER, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public LeaseMaintenancePartner selectByPrimaryKey(Long id) throws GMException {
        LeaseMaintenancePartner leaseMaintenancePartner = leaseMaintenancePartnerService.selectByPrimaryKey(id);
        return leaseMaintenancePartner;
    }

    public int updateByPrimaryKeySelective(LeaseMaintenancePartner record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseMaintenancePartnerService.updateByPrimaryKeySelective(record);
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_MAINTENANCE_PARTNER);
        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBranchCompanyId(), record.getBranchCompanyName(), UseType.TYPE_LEASE_MAINTENANCE_PARTNER, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        return row;
    }

    public int updateByPrimaryKey(LeaseMaintenancePartner record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseMaintenancePartnerService.updateByPrimaryKey(record);
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_MAINTENANCE_PARTNER);
        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBranchCompanyId(), record.getBranchCompanyName(), UseType.TYPE_LEASE_MAINTENANCE_PARTNER, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        return row;
    }

    public int insertList(List<LeaseMaintenancePartner> list) throws GMException {
        return 0;
    }


    public int updateSort(LeaseMaintenancePartners leaseMaintenancePartners) {

        if(leaseMaintenancePartners.getLeaseMaintenancePartners()!=null && leaseMaintenancePartners.getLeaseMaintenancePartners().size()>0){
            List<LeaseMaintenancePartner> leaseMaintenancePartnerList=leaseMaintenancePartners.getLeaseMaintenancePartners();
            for (LeaseMaintenancePartner leaseMaintenancePartner : leaseMaintenancePartnerList) {
                leaseMaintenancePartnerService.updateSort(leaseMaintenancePartner);
            }
        }
        return 0;
    }




    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseMaintenancePartner> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseMaintenancePartner> page = leaseMaintenancePartnerService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseMaintenancePartner> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseMaintenancePartner> leaseMaintenancePartnerList = leaseMaintenancePartnerService.findAll(paramsMap);
        return leaseMaintenancePartnerList;
    }



    public List<LeaseMaintenancePartner> findAllNoPage(Map param) {
        List<LeaseMaintenancePartner> leaseMaintenancePartners= leaseMaintenancePartnerService.findAllNoPage(param);
        return leaseMaintenancePartners;
    }

    public LeaseMaintenancePartnerExcelBackInfo importExcelBranchCompany(List<LeaseMaintenancePartnerTemplate> leaseMaintenancePartnerTemplates) throws GMException {
        LeaseMaintenancePartnerExcelBackInfo leaseMaintenancePartnerExcelBackInfo = null;
        if (leaseMaintenancePartnerTemplates != null) {
            if (leaseMaintenancePartnerTemplates.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                List<Map> backInfoList = new ArrayList<Map>();
                for (int i = 0; i < leaseMaintenancePartnerTemplates.size(); i++) {
                    LeaseMaintenancePartnerTemplate  leaseMaintenancePartnerTemplate = leaseMaintenancePartnerTemplates.get(i);
                    String number = leaseMaintenancePartnerTemplate.getNumber();
                    String name = leaseMaintenancePartnerTemplate.getName();


                    if (StringUtils.isBlank(number) || StringUtils.isBlank(name)) {
                        leaseMaintenancePartnerTemplate.setUpdateState("失败，缺少必填项");
                        failNum++;
                        continue;
                    }

                    LeaseArea province=null;
                    if(StringUtils.isNotEmpty(leaseMaintenancePartnerTemplate.getProvinceName())) {
                        Map<String, Object> param = Maps.newHashMap();
                        param.put("name", leaseMaintenancePartnerTemplate.getProvinceName());
                         province = leaseAreaService.findByName(param);
                        if (province == null) {
                            leaseMaintenancePartnerTemplate.setUpdateState("失败,省名称不存在");
                            failNum++;
                            continue;
                        }
                    }
                    LeaseArea city=null;
                    if(StringUtils.isNotEmpty(leaseMaintenancePartnerTemplate.getProvinceName())) {
                        Map<String, Object> cityParam = Maps.newHashMap();
                        cityParam.put("name", leaseMaintenancePartnerTemplate.getCityName());
                         city = leaseAreaService.findByName(cityParam);
                        if (city == null) {
                            leaseMaintenancePartnerTemplate.setUpdateState("失败,市名称不存在");
                            failNum++;
                            continue;
                        }

                    }
                    Map<String,Object> params=Maps.newHashMap();
                    params.put("name",leaseMaintenancePartnerTemplate.getName());
                    List<LeaseMaintenancePartner> leaseMaintenancePartnerList = leaseMaintenancePartnerService.findByName(params);
                    if(leaseMaintenancePartnerList!=null && leaseMaintenancePartnerList.size()>0){
                        boolean bool = checkByNumberIsExist(leaseMaintenancePartnerTemplate.getNumber(), leaseMaintenancePartnerList.get(0).getId());
                        if (bool) {
                            leaseMaintenancePartnerTemplate.setUpdateState("失败,编号重复");
                            failNum++;
                            continue;
                        }

                        for (int j = 0; j < leaseMaintenancePartnerList.size(); j++) {
                            LeaseMaintenancePartner leaseMaintenancePartner = leaseMaintenancePartnerList.get(j);
                            dualUpdateMaintenancePartnerImportExcel(leaseMaintenancePartnerTemplate,leaseMaintenancePartner,province,city);//处理保养合作方数据导入/修改
                        }
                    } else {
                        boolean bool = checkByNumberIsExist(leaseMaintenancePartnerTemplate.getNumber(), null);
                        if (bool) {
                            leaseMaintenancePartnerTemplate.setUpdateState("失败,编号重复");
                            failNum++;
                            continue;
                        }
                        dualInsertMaintenancePartnerImportExcel(leaseMaintenancePartnerTemplate,province,city);//处理分公司数据导入/新增
                    }
                    successNum++;
                    leaseMaintenancePartnerTemplate.setUpdateState("成功");

                }
                leaseMaintenancePartnerExcelBackInfo = new LeaseMaintenancePartnerExcelBackInfo();
                leaseMaintenancePartnerExcelBackInfo.setFailNum(failNum);//失败数量
                leaseMaintenancePartnerExcelBackInfo.setSuccessNum(successNum);//成功数量
                leaseMaintenancePartnerExcelBackInfo.setBackInfo(backInfoList);//反馈信息
                leaseMaintenancePartnerExcelBackInfo.setLeaseMaintenancePartnerTemplates(leaseMaintenancePartnerTemplates);
            }
        }

        return leaseMaintenancePartnerExcelBackInfo;
    }

    private void dualInsertMaintenancePartnerImportExcel(LeaseMaintenancePartnerTemplate leaseMaintenancePartnerTemplate, LeaseArea province, LeaseArea city) throws GMException {
        LeaseMaintenancePartner leaseMaintenancePartner=new LeaseMaintenancePartner();
        leaseMaintenancePartner.setName(leaseMaintenancePartnerTemplate.getName());
        leaseMaintenancePartner.setNumber(leaseMaintenancePartnerTemplate.getNumber());
        leaseMaintenancePartner.setProvinceName(leaseMaintenancePartnerTemplate.getProvinceName());
        if(StringUtils.isNotEmpty(leaseMaintenancePartnerTemplate.getProvinceName())) {
            leaseMaintenancePartner.setProvinceId(province.getId());
        }
        if(StringUtils.isNotEmpty(leaseMaintenancePartnerTemplate.getCityName())) {
            leaseMaintenancePartner.setCityId(city.getId());
        }
        leaseMaintenancePartner.setCityName(leaseMaintenancePartnerTemplate.getCityName());

        leaseMaintenancePartner.setAddress(leaseMaintenancePartnerTemplate.getAddress());
        leaseMaintenancePartner.setPhone(leaseMaintenancePartnerTemplate.getPhone());
        leaseMaintenancePartner.setRemarks(leaseMaintenancePartnerTemplate.getRemarks());
        leaseMaintenancePartnerService.insertSelective(leaseMaintenancePartner);


    }

    private void dualUpdateMaintenancePartnerImportExcel(LeaseMaintenancePartnerTemplate leaseMaintenancePartnerTemplate, LeaseMaintenancePartner leaseMaintenancePartner, LeaseArea province, LeaseArea city) throws GMException {
        LeaseMaintenancePartner maintenancePartner=new LeaseMaintenancePartner();
        maintenancePartner.setId(leaseMaintenancePartner.getId());
        maintenancePartner.setName(leaseMaintenancePartnerTemplate.getName());
        maintenancePartner.setNumber(leaseMaintenancePartnerTemplate.getNumber());
        maintenancePartner.setProvinceName(leaseMaintenancePartnerTemplate.getProvinceName());
        if(StringUtils.isNotEmpty(leaseMaintenancePartnerTemplate.getProvinceName())) {
            maintenancePartner.setProvinceId(province.getId());
        }
        if(StringUtils.isNotEmpty(leaseMaintenancePartnerTemplate.getCityName())) {
            maintenancePartner.setCityId(city.getId());
        }
        maintenancePartner.setCityName(leaseMaintenancePartnerTemplate.getCityName());

        maintenancePartner.setAddress(leaseMaintenancePartnerTemplate.getAddress());
        maintenancePartner.setPhone(leaseMaintenancePartnerTemplate.getPhone());
        maintenancePartner.setRemarks(leaseMaintenancePartnerTemplate.getRemarks());
        leaseMaintenancePartnerService.updateByPrimaryKeySelective(maintenancePartner);
    }


}
