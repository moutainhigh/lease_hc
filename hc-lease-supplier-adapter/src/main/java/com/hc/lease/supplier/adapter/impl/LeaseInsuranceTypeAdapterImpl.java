package com.hc.lease.supplier.adapter.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.baseInfo.service.api.LeaseCommonService;
import com.hc.lease.baseInfo.service.api.LeaseUseUsedService;
import com.hc.lease.common.core.constant.UseType;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.excel.poi.vo.LeaseInsuranceTypeExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseInsuranceTypeTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.supplier.adapter.api.LeaseInsuranceTypeAdapter;
import com.hc.lease.supplier.model.LeaseInsuranceCompany;
import com.hc.lease.supplier.model.LeaseInsuranceType;
import com.hc.lease.supplier.service.api.LeaseInsuranceCompanyService;
import com.hc.lease.supplier.service.api.LeaseInsuranceTypeService;
import com.hc.lease.supplier.vo.LeaseInsuranceTypes;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 险种AdapterImpl
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseInsuranceTypeAdapter")
public class LeaseInsuranceTypeAdapterImpl implements LeaseInsuranceTypeAdapter {

	@Autowired
	private LeaseInsuranceTypeService leaseInsuranceTypeService;
    @Autowired
    private LeaseInsuranceCompanyService leaseInsuranceCompanyService;

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
        List<LeaseInsuranceType> leaseInsuranceTypeList = leaseInsuranceTypeService.findByName(params);
        if (leaseInsuranceTypeList != null) {
            if (leaseInsuranceTypeList.size() > 0) {
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
    public Map<String, Object> checkByInsuranceTypeIsExist(Long id) throws GMException {
        List exceptionMessageList = new ArrayList();
        Map<String, Object> backMap = Maps.newHashMap();
        boolean item = false;
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("usedId", id);
        paramsMap.put("usedType", UsedType.TYPE_LEASE_INSURANCE_TYPE);
        List<LeaseUseUsed> leaseUseUsedList = leaseCommonService.selectByUsed(paramsMap);

        //List<LeaseCar> leaseCarList = leaseCarService.findByStorehouseId(ids);
        if (leaseUseUsedList != null) {
            if (leaseUseUsedList.size() > 0) {
                item = true;
                LeaseInsuranceType leaseInsuranceType = leaseInsuranceTypeService.selectByPrimaryKey(id);
                Map<String, Object> exceptionMessageMap = Maps.newHashMap();
                exceptionMessageMap = new HashMap<String, Object>();
                exceptionMessageMap.put("message", leaseInsuranceType.getName());
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
       List<LeaseInsuranceCompany> list= leaseInsuranceCompanyService.findAll(null);

        Map<String, Object> map=new HashMap();
        map.put("leaseInsuranceCompanyList",list);
        return map;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {
        int row = leaseInsuranceTypeService.disableByPrimaryKey(params);
        return row;
    }

    public int updateSort(LeaseInsuranceTypes leaseInsuranceTypes) {

        if(leaseInsuranceTypes.getLeaseInsuranceTypes()!=null && leaseInsuranceTypes.getLeaseInsuranceTypes().size()>0){
            List<LeaseInsuranceType> leaseInsuranceTypeList=leaseInsuranceTypes.getLeaseInsuranceTypes();
            for (LeaseInsuranceType leaseInsuranceType : leaseInsuranceTypeList) {
                leaseInsuranceTypeService.updateSort(leaseInsuranceType);
            }
        }

        return 0;
    }

    public int updateDefaultSelected(Map<String, Object> paramsMap) {
        int row=leaseInsuranceTypeService.updateDefaultSelected(paramsMap);
        return row;
    }

    public List<LeaseInsuranceType> findAllNoPage(Map param) {
        List<LeaseInsuranceType> leaseInsuranceTypeList= leaseInsuranceTypeService.findAllNoPage(param);
        return leaseInsuranceTypeList;
    }


    public int deleteByPrimaryKey(Long id) throws GMException {
        Map<String, Object> isExist = checkByInsuranceTypeIsExist(id);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }
        int row = leaseInsuranceTypeService.deleteByPrimaryKey(id);
        leaseUseUsedService.deleteByUse(id,UseType.TYPE_LEASE_INSURANCE_TYPE);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row=leaseInsuranceTypeService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseInsuranceType record) throws GMException {
        record = leaseInsuranceTypeService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseInsuranceType record) throws GMException {
        Integer maxNumber = leaseInsuranceTypeService.findMaxNumber();
        if (maxNumber == null) {
            record.setNumber(1001);
        } else {
            record.setNumber(maxNumber + 1);
        }
        record.setDefaultSelected(false);

        record = leaseInsuranceTypeService.insertSelective(record);


        //leaseCommonService.insertUseUsed(record.getId(),record.getName(),record.getInsuranceCompanyId(),null, UseType.TYPE_LEASE_INSURANCE_TYPE, UsedType.TYPE_LEASE_INSURANCE_COMPANY);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int insertList(List<LeaseInsuranceType> list) throws GMException {
        return 0;
    }

   /* public int insert(List<LeaseInsuranceType> record) throws GMException {
        int row = leaseInsuranceTypeService.insert(record);
        return row;
    }

    public int insertSelective(List<LeaseInsuranceType> record) throws GMException {
        int row = leaseInsuranceTypeService.insertSelective(record);
        return row;
    }*/

    public int updateByPrimaryKeySelective(LeaseInsuranceType record) throws GMException {
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_INSURANCE_TYPE);
        int row = leaseInsuranceTypeService.updateByPrimaryKeySelective(record);
        leaseCommonService.insertUseUsed(record.getId(),record.getName(),record.getInsuranceCompanyId(),null, UseType.TYPE_LEASE_INSURANCE_TYPE, UsedType.TYPE_LEASE_INSURANCE_COMPANY);
        return row;
    }

    public int updateByPrimaryKey(LeaseInsuranceType record) throws GMException {
        int row = leaseInsuranceTypeService.updateByPrimaryKey(record);
        return row;
    }

   /* public int updateByPrimaryKeySelective(List<LeaseInsuranceType> record) throws GMException {
        int row = leaseInsuranceTypeService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(List<LeaseInsuranceType> record) throws GMException {
        int row = leaseInsuranceTypeService.updateByPrimaryKey(record);
        return row;
    }*/

    public LeaseInsuranceType selectByPrimaryKey(Long id) throws GMException {
        LeaseInsuranceType leaseInsuranceType = leaseInsuranceTypeService.selectByPrimaryKey(id);
        return leaseInsuranceType;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseInsuranceType> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseInsuranceType> page = leaseInsuranceTypeService.findPage(pageNum, pageSize,paramsMap);
        return page;
    }

    public List<LeaseInsuranceType> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseInsuranceType> leaseInsuranceTypeList = leaseInsuranceTypeService.findAll(paramsMap);
        return leaseInsuranceTypeList;
    }

    public LeaseInsuranceTypeExcelBackInfo importExcelInsuranceType(List<LeaseInsuranceTypeTemplate> leaseInsuranceTypeTemplates) throws GMException {
        LeaseInsuranceTypeExcelBackInfo  leaseInsuranceTypeExcelBackInfo = null;
        if (leaseInsuranceTypeTemplates != null) {
            if (leaseInsuranceTypeTemplates.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                List<Map> backInfoList = new ArrayList<Map>();
                for (int i = 0; i < leaseInsuranceTypeTemplates.size(); i++) {
                    LeaseInsuranceTypeTemplate  leaseInsuranceTypeTemplate = leaseInsuranceTypeTemplates.get(i);
                    String name = leaseInsuranceTypeTemplate.getName();
                    String number = leaseInsuranceTypeTemplate.getNumber();
                    if (StringUtils.isBlank(name)) {
                        leaseInsuranceTypeTemplate.setUpdateState("失败，缺少必填项");
                        failNum++;
                        continue;
                    }

                    Map<String,Object> params=Maps.newHashMap();
                    params.put("name",leaseInsuranceTypeTemplate.getName());
                    List<LeaseInsuranceType> leaseInsuranceTypeList = leaseInsuranceTypeService.findByName(params);
                    if(leaseInsuranceTypeList==null || leaseInsuranceTypeList.size()==0){
                        LeaseInsuranceType leaseInsuranceType=new LeaseInsuranceType();
                        leaseInsuranceType.setName(leaseInsuranceTypeTemplate.getName());
                        Integer maxNumber = leaseInsuranceTypeService.findMaxNumber();
                        if (maxNumber == null) {
                            leaseInsuranceType.setNumber(1001);
                        } else {
                            leaseInsuranceType.setNumber(maxNumber + 1);
                        }
                        leaseInsuranceType.setDefaultSelected(false);
                        leaseInsuranceTypeService.insertSelective(leaseInsuranceType);
                    }
                    successNum++;
                    leaseInsuranceTypeTemplate.setUpdateState("成功");

                }

                leaseInsuranceTypeExcelBackInfo = new LeaseInsuranceTypeExcelBackInfo();
                leaseInsuranceTypeExcelBackInfo.setFailNum(failNum);//失败数量
                leaseInsuranceTypeExcelBackInfo.setSuccessNum(successNum);//成功数量
                leaseInsuranceTypeExcelBackInfo.setBackInfo(backInfoList);//反馈信息
                leaseInsuranceTypeExcelBackInfo.setLeaseInsuranceTypeTemplates(leaseInsuranceTypeTemplates);
            }
        }

        return leaseInsuranceTypeExcelBackInfo;
    }








}
