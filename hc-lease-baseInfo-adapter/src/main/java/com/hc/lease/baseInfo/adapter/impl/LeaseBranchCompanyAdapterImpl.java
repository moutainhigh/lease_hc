package com.hc.lease.baseInfo.adapter.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.adapter.api.LeaseBranchCompanyAdapter;
import com.hc.lease.baseInfo.model.LeaseArea;
import com.hc.lease.baseInfo.model.LeaseBranchCompany;
import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.baseInfo.service.api.LeaseAreaService;
import com.hc.lease.baseInfo.service.api.LeaseBranchCompanyService;
import com.hc.lease.baseInfo.service.api.LeaseCommonService;
import com.hc.lease.baseInfo.vo.LeaseBranchCompanys;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.excel.poi.vo.LeaseBranchCompanyExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseBranchCompanyTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.supplier.model.LeaseCarSupplier;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 分公司AdapterImpl
 *
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseBranchCompanyAdapter")
public class LeaseBranchCompanyAdapterImpl implements LeaseBranchCompanyAdapter {

    @Autowired
    private LeaseBranchCompanyService leaseBranchCompanyService;
    @Autowired
    private LeaseAreaService leaseAreaService;

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
        List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyService.findByName(params);
        if (leaseBranchCompanyList != null) {
            if (leaseBranchCompanyList.size() > 0) {
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
        List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyService.findByName(params);
        if (leaseBranchCompanyList != null) {
            if (leaseBranchCompanyList.size() > 0) {
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
    public Map<String, Object> checkByBranchCompanyIsExist(Long id) throws GMException {
        List exceptionMessageList = new ArrayList();
        Map<String, Object> backMap = Maps.newHashMap();
        boolean item = false;
        String _id = id + "";
        List<String> ids = new ArrayList<String>();
        ids.add(_id);

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("usedId", id);
        paramsMap.put("usedType", UsedType.TYPE_LEASE_BRANCH_COMPANY);
        List<LeaseUseUsed> leaseUseUsedList = leaseCommonService.selectByUsed(paramsMap);

        if (leaseUseUsedList != null) {
            if (leaseUseUsedList.size() > 0) {
                item = true;
                LeaseBranchCompany leaseBranchCompany = leaseBranchCompanyService.selectByPrimaryKey(id);
                Map<String, Object> exceptionMessageMap = Maps.newHashMap();
                exceptionMessageMap = new HashMap<String, Object>();
                exceptionMessageMap.put("message", leaseBranchCompany.getName());
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
        //paramsMap.put("model",MODEL_BRANCHCOMPANY);
        List<LeaseArea> leaseAreaList = leaseAreaService.findAreaByEnableAndModel(null);
        Map<String, Object> map = new HashMap();
        map.put("leaseAreaList", leaseAreaList);
        return map;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {

        int row = leaseBranchCompanyService.disableByPrimaryKey(params);
        return row;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        Map<String, Object> isExist = checkByBranchCompanyIsExist(id);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }
        int row = leaseBranchCompanyService.deleteByPrimaryKey(id);
        leaseCommonService.delUseUsed(id, null, UsedType.TYPE_LEASE_BRANCH_COMPANY, null);//删除使用者数据
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {

        int row = leaseBranchCompanyService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseBranchCompany record) throws GMException {
        record = leaseBranchCompanyService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseBranchCompany record) throws GMException {
        boolean bool = checkByNameIsExist(record.getName(), record.getId());
        if (bool) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        boolean check = checkByNumberIsExist(record.getNumber(), record.getId());
        if (check) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "number");
            throw new GMException(GMExceptionConstant.NUMBER_REPEAT, backMap);
        }


        record = leaseBranchCompanyService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int insertList(List<LeaseBranchCompany> list) throws GMException {
        return 0;
    }

    public int updateByPrimaryKeySelective(LeaseBranchCompany record) throws GMException {
        boolean bool = checkByNameIsExist(record.getName(), record.getId());
        if (bool) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        boolean check = checkByNumberIsExist(record.getNumber(), record.getId());
        if (check) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "number");
            throw new GMException(GMExceptionConstant.NUMBER_REPEAT, backMap);
        }


        int row = leaseBranchCompanyService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseBranchCompany record) throws GMException {
        int row = leaseBranchCompanyService.updateByPrimaryKey(record);
        return row;
    }


    public LeaseBranchCompany selectByPrimaryKey(Long id) throws GMException {
        LeaseBranchCompany leaseBranchCompany = leaseBranchCompanyService.selectByPrimaryKey(id);
        return leaseBranchCompany;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseBranchCompany> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseBranchCompany> page = leaseBranchCompanyService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseBranchCompany> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyService.findAll(paramsMap);
        return leaseBranchCompanyList;
    }

    @Override
    public List<String> findExportExcelModel(Map params) throws GMException {
        List<String> leaseBranchCompanyList = leaseBranchCompanyService.findExportExcelModel(params);
        return leaseBranchCompanyList;
    }

    public int updateSort(LeaseBranchCompanys leaseBranchCompanys) {

        if(leaseBranchCompanys.getLeaseBranchCompanies()!=null && leaseBranchCompanys.getLeaseBranchCompanies().size()>0){
            List<LeaseBranchCompany> leaseBranchCompanies=leaseBranchCompanys.getLeaseBranchCompanies();
            for (LeaseBranchCompany leaseBranchCompany : leaseBranchCompanies) {
                leaseBranchCompanyService.updateSort(leaseBranchCompany);
            }
        }
        return 1;

    }

    public List<LeaseBranchCompany> findAllNoPage(Map params) {
        List<LeaseBranchCompany> leaseBranchCompanies =  leaseBranchCompanyService.findAllNoPage(params);
        return leaseBranchCompanies;
    }

    public LeaseBranchCompanyExcelBackInfo importExcelBranchCompany(List<LeaseBranchCompanyTemplate> leaseBranchCompanyTemplates) throws GMException {

        LeaseBranchCompanyExcelBackInfo leaseBranchCompanyExcelBackInfo = null;
        if (leaseBranchCompanyTemplates != null) {
            if (leaseBranchCompanyTemplates.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                List<Map> backInfoList = new ArrayList<Map>();
                for (int i = 0; i < leaseBranchCompanyTemplates.size(); i++) {
                    LeaseBranchCompanyTemplate  leaseBranchCompanyTemplate = leaseBranchCompanyTemplates.get(i);
                    String number = leaseBranchCompanyTemplate.getNumber();
                    String name = leaseBranchCompanyTemplate.getName();
                    String provinceName = leaseBranchCompanyTemplate.getProvinceName();
                    String cityName = leaseBranchCompanyTemplate.getCityName();
                    String organizationNumber = leaseBranchCompanyTemplate.getOrganizationNumber();
                    String address = leaseBranchCompanyTemplate.getAddress();
                    String phone = leaseBranchCompanyTemplate.getPhone();

                    if (StringUtils.isBlank(number) || StringUtils.isBlank(name) || StringUtils.isBlank(provinceName)
                            || StringUtils.isBlank(cityName) || StringUtils.isBlank(organizationNumber) || StringUtils.isBlank(address)
                            || StringUtils.isBlank(phone)
                            ) {
                        leaseBranchCompanyTemplate.setUpdateState("失败，缺少必填项");
                        failNum++;
                        continue;
                    }
                    Map<String,Object> param=Maps.newHashMap();
                    param.put("name",leaseBranchCompanyTemplate.getProvinceName());
                    LeaseArea province=leaseAreaService.findByName(param);
                    if(province==null){
                        leaseBranchCompanyTemplate.setUpdateState("失败,省名称不存在");
                        failNum++;
                        continue;
                    }
                    Map<String,Object> cityParam=Maps.newHashMap();
                    cityParam.put("name",leaseBranchCompanyTemplate.getCityName());
                    LeaseArea city=leaseAreaService.findByName(cityParam);
                    if(city==null){
                        leaseBranchCompanyTemplate.setUpdateState("失败,市名称不存在");
                        failNum++;
                        continue;
                    }

                    Map<String,Object> params=Maps.newHashMap();
                    params.put("name",leaseBranchCompanyTemplate.getName());
                    List<LeaseBranchCompany> leaseBranchCompanies = leaseBranchCompanyService.findByName(params);
                    if(leaseBranchCompanies!=null && leaseBranchCompanies.size()>0){
                        boolean b = checkByNumberIsExist(leaseBranchCompanyTemplate.getNumber(), leaseBranchCompanies.get(0).getId());
                        if(b){
                            leaseBranchCompanyTemplate.setUpdateState("失败,编号重复");
                            failNum++;
                            continue;
                        }
                        for (int j = 0; j < leaseBranchCompanies.size(); j++) {
                            LeaseBranchCompany leaseBranchCompany = leaseBranchCompanies.get(j);
                            dualUpdateBranchCompanyImportExcel(leaseBranchCompanyTemplate,leaseBranchCompany,province,city);//处理分公司数据导入/修改
                        }
                    } else {
                        boolean b = checkByNumberIsExist(leaseBranchCompanyTemplate.getNumber(),null);
                        if(b){
                            leaseBranchCompanyTemplate.setUpdateState("失败,编号重复");
                            failNum++;
                            continue;
                        }
                        dualInsertBranchCompanyImportExcel(leaseBranchCompanyTemplate,province,city);//处理分公司数据导入/新增
                    }
                    successNum++;
                    leaseBranchCompanyTemplate.setUpdateState("成功");

                }
                leaseBranchCompanyExcelBackInfo = new LeaseBranchCompanyExcelBackInfo();
                leaseBranchCompanyExcelBackInfo.setFailNum(failNum);//失败数量
                leaseBranchCompanyExcelBackInfo.setSuccessNum(successNum);//成功数量
                leaseBranchCompanyExcelBackInfo.setBackInfo(backInfoList);//反馈信息
                leaseBranchCompanyExcelBackInfo.setLeaseBranchCompanyTemplates(leaseBranchCompanyTemplates);
            }
        }

        return leaseBranchCompanyExcelBackInfo;
    }

    private void dualInsertBranchCompanyImportExcel(LeaseBranchCompanyTemplate leaseBranchCompanyTemplate, LeaseArea province, LeaseArea city) throws GMException {
        LeaseBranchCompany branchCompany=new LeaseBranchCompany();
        branchCompany.setName(leaseBranchCompanyTemplate.getName());
        branchCompany.setNumber(leaseBranchCompanyTemplate.getNumber());
        branchCompany.setOrganizationNumber(leaseBranchCompanyTemplate.getOrganizationNumber());
        branchCompany.setProvinceName(leaseBranchCompanyTemplate.getProvinceName());
        branchCompany.setProvinceId(province.getId());
        branchCompany.setCityName(leaseBranchCompanyTemplate.getCityName());
        branchCompany.setCityId(city.getId());
        branchCompany.setAddress(leaseBranchCompanyTemplate.getAddress());
        branchCompany.setContacts(leaseBranchCompanyTemplate.getContacts());
        branchCompany.setContactPhone(leaseBranchCompanyTemplate.getContactPhone());
        branchCompany.setPhone(leaseBranchCompanyTemplate.getPhone());
        branchCompany.setRemarks(leaseBranchCompanyTemplate.getRemarks());
        leaseBranchCompanyService.insertSelective(branchCompany);


    }

    private void dualUpdateBranchCompanyImportExcel(LeaseBranchCompanyTemplate leaseBranchCompanyTemplate, LeaseBranchCompany leaseBranchCompany, LeaseArea province, LeaseArea city) throws GMException {
        LeaseBranchCompany branchCompany=new LeaseBranchCompany();
        branchCompany.setId(leaseBranchCompany.getId());
        branchCompany.setName(leaseBranchCompanyTemplate.getName());
        branchCompany.setNumber(leaseBranchCompanyTemplate.getNumber());
        branchCompany.setOrganizationNumber(leaseBranchCompanyTemplate.getOrganizationNumber());
        branchCompany.setProvinceName(leaseBranchCompanyTemplate.getProvinceName());
        branchCompany.setProvinceId(province.getId());
        branchCompany.setCityName(leaseBranchCompanyTemplate.getCityName());
        branchCompany.setCityId(city.getId());
        branchCompany.setAddress(leaseBranchCompanyTemplate.getAddress());
        branchCompany.setContacts(leaseBranchCompanyTemplate.getContacts());
        branchCompany.setContactPhone(leaseBranchCompanyTemplate.getContactPhone());
        branchCompany.setPhone(leaseBranchCompanyTemplate.getPhone());
        branchCompany.setRemarks(leaseBranchCompanyTemplate.getRemarks());
        leaseBranchCompanyService.updateByPrimaryKeySelective(branchCompany);
    }
}
