package com.hc.lease.supplier.adapter.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.baseInfo.service.api.LeaseCommonService;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.excel.poi.vo.LeaseInsuranceCompanyExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseInsuranceCompanyTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.supplier.adapter.api.LeaseInsuranceCompanyAdapter;
import com.hc.lease.supplier.model.LeaseInsuranceCompany;
import com.hc.lease.supplier.model.LeaseStorehouse;
import com.hc.lease.supplier.service.api.LeaseInsuranceCompanyService;
import com.hc.lease.supplier.service.api.LeaseInsuranceTypeService;
import com.hc.lease.supplier.vo.LeaseInsuranceCompanys;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 保险公司AdapterImpl
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseInsuranceCompanyAdapter")
public class LeaseInsuranceCompanyAdapterImpl implements LeaseInsuranceCompanyAdapter {

	@Autowired
	private LeaseInsuranceCompanyService leaseInsuranceCompanyService;
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
        List<LeaseInsuranceCompany> leaseInsuranceCompanyList = leaseInsuranceCompanyService.findByName(params);
        if (leaseInsuranceCompanyList != null) {
            if (leaseInsuranceCompanyList.size() > 0) {
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
    public Map<String, Object> checkByInsuranceCompanyIsExist(Long id) throws GMException {
        List exceptionMessageList = new ArrayList();
        Map<String, Object> backMap = Maps.newHashMap();
        boolean item = false;
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("usedId", id);
        paramsMap.put("usedType", UsedType.TYPE_LEASE_INSURANCE_COMPANY);
        List<LeaseUseUsed> leaseUseUsedList = leaseCommonService.selectByUsed(paramsMap);
       // List<LeaseInsuranceType> leaseInsuranceTypeList = leaseInsuranceTypeService.findByInsuranceCompanyId(ids);
        if (leaseUseUsedList != null) {
            if (leaseUseUsedList.size() > 0) {
                item = true;
                LeaseInsuranceCompany leaseInsuranceCompany = leaseInsuranceCompanyService.selectByPrimaryKey(id);
                Map<String, Object> exceptionMessageMap = Maps.newHashMap();
                exceptionMessageMap = new HashMap<String, Object>();
                exceptionMessageMap.put("message", leaseInsuranceCompany.getName());
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
        int row = leaseInsuranceCompanyService.disableByPrimaryKey(params);
        return row;
    }

    public int updateSort(LeaseInsuranceCompanys leaseInsuranceCompanys) {

        if(leaseInsuranceCompanys.getLeaseInsuranceCompanies()!=null && leaseInsuranceCompanys.getLeaseInsuranceCompanies().size()>0){
            List<LeaseInsuranceCompany> leaseInsuranceCompanyList=leaseInsuranceCompanys.getLeaseInsuranceCompanies();
            for (LeaseInsuranceCompany leaseInsuranceCompany : leaseInsuranceCompanyList) {
                leaseInsuranceCompanyService.updateSort(leaseInsuranceCompany);
            }
        }
        return 1;

    }

    @Override
    public List<String> findAllInsuranceCompanyNames() {
        return leaseInsuranceCompanyService.findAllInsuranceCompanyNames();
    }

    public List<LeaseInsuranceCompany> findAllNoPage(Map param) {
        List<LeaseInsuranceCompany> leaseInsuranceCompanyList=leaseInsuranceCompanyService.findAllNoPage(param);
        return leaseInsuranceCompanyList;
    }



    public int deleteByPrimaryKey(Long id) throws GMException {

        Map<String, Object> isExist = checkByInsuranceCompanyIsExist(id);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }
        int row = leaseInsuranceCompanyService.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row=leaseInsuranceCompanyService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseInsuranceCompany record) throws GMException {
        record = leaseInsuranceCompanyService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseInsuranceCompany record) throws GMException {
        boolean bool = checkByNameIsExist(record.getName(), record.getId());
        if(bool){
            throw new GMException(GMExceptionConstant.NAME_REPEAT);
        }
        Integer maxNumber = leaseInsuranceCompanyService.findMaxNumber();
        if (maxNumber == null) {
            record.setNumber(1001);
        } else {
            record.setNumber(maxNumber + 1);
        }


        record = leaseInsuranceCompanyService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int insertList(List<LeaseInsuranceCompany> list) throws GMException {
        return 0;
    }



    public int updateByPrimaryKeySelective(LeaseInsuranceCompany record) throws GMException {
        boolean bool = checkByNameIsExist(record.getName(), record.getId());
        if(bool){
            throw new GMException(GMExceptionConstant.NAME_REPEAT);
        }

        int row = leaseInsuranceCompanyService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseInsuranceCompany record) throws GMException {
        int row = leaseInsuranceCompanyService.updateByPrimaryKey(record);
        return row;
    }

 /*   public int updateByPrimaryKeySelective(List<LeaseInsuranceCompany> record) throws GMException {
        int row = leaseInsuranceCompanyService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(List<LeaseInsuranceCompany> record) throws GMException {
        int row = leaseInsuranceCompanyService.updateByPrimaryKey(record);
        return row;
    }
*/
    public LeaseInsuranceCompany selectByPrimaryKey(Long id) throws GMException {
        LeaseInsuranceCompany leaseInsuranceCompany = leaseInsuranceCompanyService.selectByPrimaryKey(id);
        return leaseInsuranceCompany;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseInsuranceCompany> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseInsuranceCompany> page = leaseInsuranceCompanyService.findPage(pageNum, pageSize,paramsMap);
        return page;
    }

    public List<LeaseInsuranceCompany> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseInsuranceCompany> leaseInsuranceCompanyList = leaseInsuranceCompanyService.findAll(paramsMap);
        return leaseInsuranceCompanyList;
    }


    public LeaseInsuranceCompanyExcelBackInfo importExcelInsuranceCompany(List<LeaseInsuranceCompanyTemplate> leaseInsuranceCompanyTemplates) throws GMException {
        LeaseInsuranceCompanyExcelBackInfo  leaseInsuranceCompanyExcelBackInfo = null;
        if (leaseInsuranceCompanyTemplates != null) {
            if (leaseInsuranceCompanyTemplates.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                List<Map> backInfoList = new ArrayList<Map>();
                for (int i = 0; i < leaseInsuranceCompanyTemplates.size(); i++) {
                    LeaseInsuranceCompanyTemplate  leaseInsuranceCompanyTemplate = leaseInsuranceCompanyTemplates.get(i);
                    String name = leaseInsuranceCompanyTemplate.getName();
                    String number = leaseInsuranceCompanyTemplate.getNumber();
                    if (StringUtils.isBlank(name)) {
                        leaseInsuranceCompanyTemplate.setUpdateState("失败，缺少必填项");
                        failNum++;
                        continue;
                    }

                    Map<String,Object> params=Maps.newHashMap();
                    params.put("name",leaseInsuranceCompanyTemplate.getName());
                    List<LeaseInsuranceCompany> leaseInsuranceCompanyList = leaseInsuranceCompanyService.findByName(params);
                    if(leaseInsuranceCompanyList==null || leaseInsuranceCompanyList.size()==0){
                        LeaseInsuranceCompany leaseInsuranceCompany=new LeaseInsuranceCompany();
                        leaseInsuranceCompany.setName(leaseInsuranceCompanyTemplate.getName());
                        Integer maxNumber = leaseInsuranceCompanyService.findMaxNumber();
                        if (maxNumber == null) {
                            leaseInsuranceCompany.setNumber(1001);
                        } else {
                            leaseInsuranceCompany.setNumber(maxNumber + 1);
                        }
                        leaseInsuranceCompanyService.insertSelective(leaseInsuranceCompany);
                    }
                    successNum++;
                    leaseInsuranceCompanyTemplate.setUpdateState("成功");

                }

                leaseInsuranceCompanyExcelBackInfo = new LeaseInsuranceCompanyExcelBackInfo();
                leaseInsuranceCompanyExcelBackInfo.setFailNum(failNum);//失败数量
                leaseInsuranceCompanyExcelBackInfo.setSuccessNum(successNum);//成功数量
                leaseInsuranceCompanyExcelBackInfo.setBackInfo(backInfoList);//反馈信息
                leaseInsuranceCompanyExcelBackInfo.setLeaseInsuranceCompanyTemplates(leaseInsuranceCompanyTemplates);
            }
        }

        return leaseInsuranceCompanyExcelBackInfo;
    }




}
