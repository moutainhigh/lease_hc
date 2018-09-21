package com.hc.lease.baseInfo.adapter.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.adapter.api.LeaseArchiveLocationAdapter;
import com.hc.lease.baseInfo.model.LeaseArchiveLocation;
import com.hc.lease.baseInfo.model.LeaseCarColor;
import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.baseInfo.service.api.LeaseArchiveLocationService;
import com.hc.lease.baseInfo.service.api.LeaseCommonService;
import com.hc.lease.baseInfo.vo.LeaseArchiveLocations;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.excel.poi.vo.LeaseArchiveLocationExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseArchiveLocationTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 归档位置AdapterImpl
 *
 * @author Tong
 * @version 2017-04-17
 */
@Service("leaseArchiveLocationAdapter")
public class LeaseArchiveLocationAdapterImpl implements LeaseArchiveLocationAdapter {

    @Autowired
    private LeaseArchiveLocationService leaseArchiveLocationService;
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
        List<LeaseArchiveLocation> leaseArchiveLocationList = leaseArchiveLocationService.findByName(params);
        if (leaseArchiveLocationList != null) {
            if (leaseArchiveLocationList.size() > 0) {
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
    public Map<String, Object> checkArchiveLocationIsExist(Long id) throws GMException {
        List exceptionMessageList = new ArrayList();
        Map<String, Object> backMap = Maps.newHashMap();
        boolean item = false;
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("usedId", id);
        paramsMap.put("usedType", UsedType.TYPE_LEASE_ARCHIVELOCATION);
        List<LeaseUseUsed> leaseUseUsedList = leaseCommonService.selectByUsed(paramsMap);

        if (leaseUseUsedList != null) {
            if (leaseUseUsedList.size() > 0) {
                item = true;
                LeaseArchiveLocation leaseArchiveLocation = leaseArchiveLocationService.selectByPrimaryKey(id);
                Map<String, Object> exceptionMessageMap = Maps.newHashMap();
                exceptionMessageMap = new HashMap<String, Object>();
                exceptionMessageMap.put("message", leaseArchiveLocation.getName());
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


    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    @Override
    public ResultHashMap insertSelective(LeaseArchiveLocation leaseArchiveLocation, UserSession userSession)throws GMException  {
        boolean isExist = checkByNameIsExist(leaseArchiveLocation.getName(), leaseArchiveLocation.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }
        leaseArchiveLocation.setCreateBy(userSession.getUserId());
        leaseArchiveLocation.setUpdateBy(userSession.getUserId());
        Integer maxNumber = leaseArchiveLocationService.findMaxNumber();
        if (maxNumber == null) {
            leaseArchiveLocation.setNumber(1001);
        } else {
            leaseArchiveLocation.setNumber(maxNumber + 1);
        }
        leaseArchiveLocation.setDefaultSelected(false);


        leaseArchiveLocation = leaseArchiveLocationService.insertSelective(leaseArchiveLocation);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }


    public int updateByPrimaryKeySelective(LeaseArchiveLocation leaseArchiveLocation, UserSession userSession) throws GMException {
        boolean isExist = checkByNameIsExist(leaseArchiveLocation.getName(), leaseArchiveLocation.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        leaseArchiveLocation.setUpdateBy(userSession.getUserId());
        int row = leaseArchiveLocationService.updateByPrimaryKeySelective(leaseArchiveLocation);
        return row;
    }

    public int disableByPrimaryKey(Map<String, Object> params) {
        int row =leaseArchiveLocationService.disableByPrimaryKey(params);
        return row;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        Map<String, Object> isExist = checkArchiveLocationIsExist(id);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }
        int row = leaseArchiveLocationService.deleteByPrimaryKey(id);
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
        int row = leaseArchiveLocationService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseArchiveLocation record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseArchiveLocationService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseArchiveLocation record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseArchiveLocationService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public LeaseArchiveLocation selectByPrimaryKey(Long id) throws GMException {
        LeaseArchiveLocation leaseArchiveLocation = leaseArchiveLocationService.selectByPrimaryKey(id);
        return leaseArchiveLocation;
    }

    public int updateByPrimaryKeySelective(LeaseArchiveLocation record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseArchiveLocationService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseArchiveLocation record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseArchiveLocationService.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseArchiveLocation> list) throws GMException {
        return 0;
    }

    public int updateSort(LeaseArchiveLocations leaseArchiveLocations) {

        if(leaseArchiveLocations.getLeaseArchiveLocations()!=null && leaseArchiveLocations.getLeaseArchiveLocations().size()>0){
            List<LeaseArchiveLocation> archiveLocations=leaseArchiveLocations.getLeaseArchiveLocations();
            for (LeaseArchiveLocation leaseArchiveLocation : archiveLocations) {
                leaseArchiveLocationService.updateSort(leaseArchiveLocation);
            }
        }
        return 0;
    }


    public int updateDefaultSelected(Map<String, Object> paramsMap) {
        int row=leaseArchiveLocationService.updateDefaultSelected(paramsMap);
        return row;
    }

    public List<LeaseArchiveLocation> findAllNoPage(Map param) {
        List<LeaseArchiveLocation> archiveLocations= leaseArchiveLocationService.findAllNoPage(param);
        return archiveLocations;
    }




    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseArchiveLocation> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseArchiveLocation> page = leaseArchiveLocationService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseArchiveLocation> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseArchiveLocation> leaseArchiveLocationList = leaseArchiveLocationService.findAll(paramsMap);
        return leaseArchiveLocationList;
    }


    public LeaseArchiveLocationExcelBackInfo importExcelArchiveLocation(List<LeaseArchiveLocationTemplate> leaseArchiveLocationTemplates) throws GMException {

        LeaseArchiveLocationExcelBackInfo  leaseArchiveLocationExcelBackInfo = null;
        if (leaseArchiveLocationTemplates != null) {
            if (leaseArchiveLocationTemplates.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                List<Map> backInfoList = new ArrayList<Map>();
                for (int i = 0; i < leaseArchiveLocationTemplates.size(); i++) {
                    LeaseArchiveLocationTemplate  leaseArchiveLocationTemplate = leaseArchiveLocationTemplates.get(i);
                    String name = leaseArchiveLocationTemplate.getName();
                    if (StringUtils.isBlank(name)) {
                        leaseArchiveLocationTemplate.setUpdateState("失败，缺少必填项");
                        failNum++;
                        continue;
                    }

                    Map<String,Object> params=Maps.newHashMap();
                    params.put("name",leaseArchiveLocationTemplate.getName());
                    List<LeaseArchiveLocation> leaseArchiveLocations = leaseArchiveLocationService.findByName(params);
                    if(leaseArchiveLocations==null || leaseArchiveLocations.size()==0){
                        LeaseArchiveLocation leaseArchiveLocation=new LeaseArchiveLocation();
                        leaseArchiveLocation.setName(leaseArchiveLocationTemplate.getName());
                        leaseArchiveLocation.setRemarks(leaseArchiveLocationTemplate.getRemarks());
                        Integer maxNumber = leaseArchiveLocationService.findMaxNumber();
                        if (maxNumber == null) {
                            leaseArchiveLocation.setNumber(1001);
                        } else {
                            leaseArchiveLocation.setNumber(maxNumber + 1);
                        }
                        leaseArchiveLocation.setDefaultSelected(false);
                        leaseArchiveLocationService.insertSelective(leaseArchiveLocation);
                    }else{

                        LeaseArchiveLocation archiveLocation=new LeaseArchiveLocation();
                        archiveLocation.setId(leaseArchiveLocations.get(0).getId());
                        archiveLocation.setRemarks(leaseArchiveLocationTemplate.getRemarks());
                        leaseArchiveLocationService.updateByPrimaryKeySelective(archiveLocation);
                    }
                    successNum++;
                    leaseArchiveLocationTemplate.setUpdateState("成功");

                }

                leaseArchiveLocationExcelBackInfo = new LeaseArchiveLocationExcelBackInfo();
                leaseArchiveLocationExcelBackInfo.setFailNum(failNum);//失败数量
                leaseArchiveLocationExcelBackInfo.setSuccessNum(successNum);//成功数量
                leaseArchiveLocationExcelBackInfo.setBackInfo(backInfoList);//反馈信息
                leaseArchiveLocationExcelBackInfo.setLeaseArchiveLocationTemplates(leaseArchiveLocationTemplates);
            }
        }

        return leaseArchiveLocationExcelBackInfo;

    }

}
