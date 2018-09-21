package com.hc.lease.baseInfo.adapter.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.adapter.api.LeaseDictAdapter;
import com.hc.lease.baseInfo.model.LeaseDict;
import com.hc.lease.baseInfo.service.api.LeaseDictService;
import com.hc.lease.baseInfo.vo.LeaseDicts;
import com.hc.lease.common.core.constant.DictType;
import com.hc.lease.common.core.excel.poi.vo.LeaseDictBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseDictTemplate;
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
 * 字典表AdapterImpl
 *
 * @author Tong
 * @version 2017-04-17
 */
@Service("leaseDictAdapter")
public class LeaseDictAdapterImpl implements LeaseDictAdapter {

    @Autowired
    private LeaseDictService leaseDictService;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseDictService.deleteByPrimaryKey(id);
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
        int row = leaseDictService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseDict record) throws GMException {
        record = leaseDictService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseDict record) throws GMException {
            if (record.getType()==null) {
                Map backMap = Maps.newHashMap();
                backMap.put("key", "type");
                throw new GMException(GMExceptionConstant.FAILED_SAVE, backMap);
            }
        if(record.getType().equals(DictType.TYPE_OUTPUTVOLUME)){
            record.setDescription("排量");
        }else  if(record.getType().equals(DictType.TYPE_FUELTYPE)){
            record.setDescription("燃料类型");
        }else  if(record.getType().equals(DictType.TYPE_STAGING_NUMBER)){
            record.setDescription("分期数");
        }else  if(record.getType().equals(DictType.TYPE_CARACCESSORY)){
            record.setDescription("随车物料");
        }
        Integer maxNumber = leaseDictService.findMaxNumber(record.getType());
        if (maxNumber == null) {
            record.setNumber(1001);
        } else {
            record.setNumber(maxNumber + 1);
        }
        record.setDefaultSelected(false);
        record = leaseDictService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public LeaseDict selectByPrimaryKey(Long id) throws GMException {
        LeaseDict leaseDict = leaseDictService.selectByPrimaryKey(id);
        return leaseDict;
    }

    public int updateByPrimaryKeySelective(LeaseDict record) throws GMException {
        int row = leaseDictService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseDict record) throws GMException {
        int row = leaseDictService.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseDict> list) throws GMException {
        return 0;
    }

    public List<LeaseDict> findByType(String type) {
        List<LeaseDict> leaseDictList = leaseDictService.findByType(type);
        return leaseDictList;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseDict> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseDict> page = leaseDictService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseDict> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseDict> leaseDictList = leaseDictService.findAll(paramsMap);
        return leaseDictList;
    }

    /**
     * 导出车辆录入模板需要的数据
     *
     * @param type
     * @return
     * @throws GMException
     */
    @Override
    public List<String> findExportExcelModel(String type) throws GMException {
        List<String> leaseDictList = leaseDictService.findExportExcelModel(type);
        return leaseDictList;
    }

    /**
     * @param paramsMap
     * @return
     */
    @Override
    public List<LeaseDict> findByValueAndType(Map<String, Object> paramsMap) {
        List<LeaseDict> leaseDictList = leaseDictService.findByValueAndType(paramsMap);
        return leaseDictList;
    }

    public int disableByPrimaryKey(Map<String, Object> paramsMap) {

       int row= leaseDictService.disableByPrimaryKey(paramsMap);
        return row;
    }

    public int updateDefaultSelected(Map<String, Object> paramsMap) {
        int row=  leaseDictService.updateDefaultSelected(paramsMap);
        return row;
    }

    public int updateSort(LeaseDicts leaseDicts) {


        if(leaseDicts.getLeaseDicts()!=null && leaseDicts.getLeaseDicts().size()>0){
            List<LeaseDict> leaseDictList=leaseDicts.getLeaseDicts();
            for (LeaseDict leaseDict : leaseDictList) {
                leaseDictService.updateSort(leaseDict);
            }
        }
        return 0;
    }

    public LeaseDictBackInfo importExcelCarColor(List<LeaseDictTemplate> leaseDictTemplates, String type) throws GMException {

        LeaseDictBackInfo  leaseDictBackInfo = null;
        if (leaseDictTemplates != null) {
            if (leaseDictTemplates.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                List<Map> backInfoList = new ArrayList<Map>();
                for (int i = 0; i < leaseDictTemplates.size(); i++) {
                    LeaseDictTemplate  leaseDictTemplate = leaseDictTemplates.get(i);
                    String name = leaseDictTemplate.getName();
                    String number = leaseDictTemplate.getNumber();
                    if (StringUtils.isBlank(name)) {
                        leaseDictTemplate.setUpdateState("失败，缺少必填项");
                        failNum++;
                        continue;
                    }

                    Map<String,Object> params=Maps.newHashMap();
                    params.put("name",leaseDictTemplate.getName());
                    params.put("type",type);
                    List<LeaseDict> leaseCarColorList = leaseDictService.findByValueAndType(params);
                    if(leaseCarColorList==null || leaseCarColorList.size()==0){
                        LeaseDict leaseDict=new LeaseDict();
                        leaseDict.setValue(leaseDictTemplate.getName());
                        leaseDict.setType(type);
                        Integer maxNumber = leaseDictService.findMaxNumber(type);
                        if (maxNumber == null) {
                            leaseDict.setNumber(1001);
                        } else {
                            leaseDict.setNumber(maxNumber + 1);
                        }
                        if(type.equals(DictType.TYPE_OUTPUTVOLUME)){
                            leaseDict.setDescription("排量");
                        }else  if(type.equals(DictType.TYPE_FUELTYPE)){
                            leaseDict.setDescription("燃料类型");
                        }else  if(type.equals(DictType.TYPE_STAGING_NUMBER)){
                            leaseDict.setDescription("分期数");
                        }else  if(type.equals(DictType.TYPE_CARACCESSORY)){
                            leaseDict.setDescription("随车物料");

                        }
                        leaseDict.setDefaultSelected(false);

                        leaseDictService.insertSelective(leaseDict);
                    }
                    successNum++;
                    leaseDictTemplate.setUpdateState("成功");

                }

                leaseDictBackInfo = new LeaseDictBackInfo();
                leaseDictBackInfo.setFailNum(failNum);//失败数量
                leaseDictBackInfo.setSuccessNum(successNum);//成功数量
                leaseDictBackInfo.setBackInfo(backInfoList);//反馈信息
                leaseDictBackInfo.setLeaseDictTemplates(leaseDictTemplates);
            }
        }

        return leaseDictBackInfo;

    }
}
