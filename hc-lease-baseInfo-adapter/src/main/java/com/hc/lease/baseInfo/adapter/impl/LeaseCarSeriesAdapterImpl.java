package com.hc.lease.baseInfo.adapter.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.adapter.api.LeaseCarSeriesAdapter;
import com.hc.lease.baseInfo.model.LeaseCarBrands;
import com.hc.lease.baseInfo.model.LeaseCarSeries;
import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.baseInfo.service.api.*;
import com.hc.lease.baseInfo.vo.LeaseCarSeriesList;
import com.hc.lease.common.core.constant.UseType;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.excel.poi.vo.CarBrandSeriesImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseCarBrandSeriesTemplate;
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
 * 车辆系列AdapterImpl
 *
 * @author Tong
 * @version 2017-04-17
 */
@Service("leaseCarSeriesAdapter")
public class LeaseCarSeriesAdapterImpl implements LeaseCarSeriesAdapter {

    @Autowired
    private LeaseCarSeriesService leaseCarSeriesService;

    @Autowired
    private LeaseCarBrandsService leaseCarBrandsService;

    @Autowired
    private LeaseCommonService leaseCommonService;
    @Autowired
    private LeaseUseUsedService leaseUseUsedService;


    /**
     * 检测数据是否被使用
     *
     * @param id
     * @return
     * @throws GMException
     */
    public Map<String, Object> checkBySeriesIdIsExist(Long id) throws GMException {
        List exceptionMessageList = new ArrayList();
        Map<String, Object> backMap = Maps.newHashMap();
        boolean item = false;
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("usedId", id);
        paramsMap.put("usedType", UsedType.TYPE_LEASE_CAR_SERIES);
        List<LeaseUseUsed> leaseUseUsedList = leaseCommonService.selectByUsed(paramsMap);

        if (leaseUseUsedList != null) {
            if (leaseUseUsedList.size() > 0) {
                item = true;
                LeaseCarSeries leaseCarSeries = leaseCarSeriesService.selectByPrimaryKey(id);
                Map<String, Object> exceptionMessageMap = Maps.newHashMap();
                exceptionMessageMap = new HashMap<String, Object>();
                exceptionMessageMap.put("message", leaseCarSeries.getName());
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
        List<LeaseCarSeries> leaseCarSeriesList = leaseCarSeriesService.findByName(params);
        if (leaseCarSeriesList != null) {
            if (leaseCarSeriesList.size() > 0) {
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
        Map<String, Object> map = Maps.newHashMap();
        List<LeaseCarBrands> leaseCarBrandsList = leaseCarBrandsService.insertViewParames(paramsMap);//车辆品牌
        map.put("leaseCarBrandsList", leaseCarBrandsList);
        return map;
    }


    public ResultHashMap insertSelective(LeaseCarSeries record, UserSession userSession) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }
        record.setCreateBy(userSession.getUserId());
        record.setUpdateBy(userSession.getUserId());

        record = leaseCarSeriesService.insertSelective(record);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBrandsId(), record.getBrandName(), UseType.TYPE_LEASE_CAR_SERIES, UsedType.TYPE_LEASE_CAR_BRANDS);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }


    public int updateByPrimaryKeySelective(LeaseCarSeries record, UserSession userSession) throws GMException {
        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }
        record.setUpdateBy(userSession.getUserId());

        int row = leaseCarSeriesService.updateByPrimaryKeySelective(record);
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_CAR_SERIES);
        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBrandsId(), record.getBrandName(), UseType.TYPE_LEASE_CAR_SERIES, UsedType.TYPE_LEASE_CAR_BRANDS);

        return row;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {

        int row = leaseCarSeriesService.disableByPrimaryKey(params);
        return row;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        Map<String, Object> isExist = checkBySeriesIdIsExist(id);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }
        int row = leaseCarSeriesService.deleteByPrimaryKey(id);
        leaseCommonService.delUseUsed(id, null, UsedType.TYPE_LEASE_CAR_SERIES, null);//删除使用者数据
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
        int row = leaseCarSeriesService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseCarSeries record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseCarSeriesService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseCarSeries record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseCarSeriesService.insertSelective(record);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBrandsId(), record.getBrandName(), UseType.TYPE_LEASE_CAR_SERIES, UsedType.TYPE_LEASE_CAR_BRANDS);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public LeaseCarSeries selectByPrimaryKey(Long id) throws GMException {
        LeaseCarSeries leaseCarSeries = leaseCarSeriesService.selectByPrimaryKey(id);
        return leaseCarSeries;
    }

    public int updateByPrimaryKeySelective(LeaseCarSeries record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseCarSeriesService.updateByPrimaryKeySelective(record);
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_CAR_SERIES);
        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBrandsId(), record.getBrandName(), UseType.TYPE_LEASE_CAR_SERIES, UsedType.TYPE_LEASE_CAR_BRANDS);

        return row;
    }

    public int updateByPrimaryKey(LeaseCarSeries record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseCarSeriesService.updateByPrimaryKey(record);
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_CAR_SERIES);
        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBrandsId(), record.getBrandName(), UseType.TYPE_LEASE_CAR_SERIES, UsedType.TYPE_LEASE_CAR_BRANDS);

        return row;
    }

    public int insertList(List<LeaseCarSeries> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseCarSeries> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseCarSeries> page = leaseCarSeriesService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<LeaseCarSeries> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarSeries> leaseCarSeriesList = leaseCarSeriesService.findAll(paramsMap);
        return leaseCarSeriesList;
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
        List<String> leaseCarSeriesList = leaseCarSeriesService.findExportExcelModel(params);
        return leaseCarSeriesList;
    }

    public int updateSort(LeaseCarSeriesList leaseCarSeriesList) {
        if(leaseCarSeriesList.getLeaseCarSeriesList()!=null &&leaseCarSeriesList.getLeaseCarSeriesList().size()>0){
            List<LeaseCarSeries> leaseCarSeriesLists=leaseCarSeriesList.getLeaseCarSeriesList();
            for (LeaseCarSeries leaseCarSeries : leaseCarSeriesLists) {
                leaseCarSeriesService.updateSort(leaseCarSeries);
            }
        }
        return 0;
    }

    public List<LeaseCarSeries> findAllNoPage(Map params) {
        List<LeaseCarSeries> leaseCarSeries= leaseCarSeriesService.findAllNoPage(params);
        return leaseCarSeries;
    }

    public CarBrandSeriesImportExcelBackInfo importExcelCarBrandSeries(List<LeaseCarBrandSeriesTemplate> leaseCarBrandSeriesTemplates, UserSession userSession) throws GMException {
        CarBrandSeriesImportExcelBackInfo carBrandSeriesImportExcelBackInfo = null;
        if (leaseCarBrandSeriesTemplates != null) {
            if (leaseCarBrandSeriesTemplates.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                List<Map> backInfoList = new ArrayList<Map>();
                for (int i = 0; i < leaseCarBrandSeriesTemplates.size(); i++) {
                    LeaseCarBrandSeriesTemplate  leaseCarBrandSeriesTemplate = leaseCarBrandSeriesTemplates.get(i);
                    String brandName = leaseCarBrandSeriesTemplate.getBrandName();

                    if (StringUtils.isBlank(brandName)) {
                        leaseCarBrandSeriesTemplate.setUpdateState("失败，缺少必填项");
                        failNum++;
                        continue;
                    }

                    Map<String,Object> params=Maps.newHashMap();
                    params.put("name",leaseCarBrandSeriesTemplate.getBrandName());
                    List<LeaseCarBrands> leaseCarBrandses = leaseCarBrandsService.findByName(params);
                    if(leaseCarBrandses!=null && leaseCarBrandses.size()>0){
                        for (int j = 0; j < leaseCarBrandses.size(); j++) {
                            LeaseCarBrands leaseCarBrands = leaseCarBrandses.get(0);
                            dualCarSeriesImportExcel(leaseCarBrandSeriesTemplate,leaseCarBrands);
                            break;
                        }
                    } else {
                        LeaseCarBrands leaseCarBrands=new LeaseCarBrands();
                        leaseCarBrands.setName(leaseCarBrandSeriesTemplate.getBrandName());
                        leaseCarBrands.setCreateBy(11L);
                        LeaseCarBrands carBrands = leaseCarBrandsService.insertSelective(leaseCarBrands);
                        dualCarSeriesImportExcel(leaseCarBrandSeriesTemplate,carBrands);
                    }
                    successNum++;
                    leaseCarBrandSeriesTemplate.setUpdateState("成功");

                }

                carBrandSeriesImportExcelBackInfo = new CarBrandSeriesImportExcelBackInfo();
                carBrandSeriesImportExcelBackInfo.setFailNum(failNum);//失败数量
                carBrandSeriesImportExcelBackInfo.setSuccessNum(successNum);//成功数量
                carBrandSeriesImportExcelBackInfo.setBackInfo(backInfoList);//反馈信息
                carBrandSeriesImportExcelBackInfo.setLeaseCarBrandSeriesTemplates(leaseCarBrandSeriesTemplates);
            }
        }

        return carBrandSeriesImportExcelBackInfo;

    }

    private void dualCarSeriesImportExcel(LeaseCarBrandSeriesTemplate leaseCarBrandSeriesTemplate, LeaseCarBrands leaseCarBrands) throws GMException {
        Map<String,Object> param=Maps.newHashMap();
        param.put("name",leaseCarBrandSeriesTemplate.getSeriesName());
        System.out.println("*****************************seriesName"+leaseCarBrandSeriesTemplate.getSeriesName());
        List<LeaseCarSeries> leaseCarSeries = leaseCarSeriesService.findByName(param);
        if(leaseCarSeries==null || leaseCarSeries.size()==0){
            System.out.println("*****************************seriesName0"+leaseCarBrandSeriesTemplate.getSeriesName());
            LeaseCarSeries carSeries =new LeaseCarSeries();
            carSeries.setBrandsId(leaseCarBrands.getId());
            carSeries.setName(leaseCarBrandSeriesTemplate.getSeriesName());
            carSeries.setCreateBy(11L);
            LeaseCarSeries record = leaseCarSeriesService.insertSelective(carSeries);

            //插入使用和被使用的数据
            leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBrandsId(), record.getBrandName(), UseType.TYPE_LEASE_CAR_SERIES, UsedType.TYPE_LEASE_CAR_BRANDS);
        }
    }
}
