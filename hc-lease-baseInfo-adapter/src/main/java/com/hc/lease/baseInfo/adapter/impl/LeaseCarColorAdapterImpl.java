package com.hc.lease.baseInfo.adapter.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.adapter.api.LeaseCarColorAdapter;
import com.hc.lease.baseInfo.model.LeaseCarColor;
import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.baseInfo.service.api.LeaseCarColorService;
import com.hc.lease.baseInfo.service.api.LeaseCarModelColorService;
import com.hc.lease.baseInfo.service.api.LeaseCommonService;
import com.hc.lease.baseInfo.vo.LeaseCarColors;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.excel.poi.vo.LeaseCarColorExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseCarColorTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 车辆颜色AdapterImpl
 *
 * @author Tong
 * @version 2017-04-17
 */
@Service("leaseCarColorAdapter")
public class LeaseCarColorAdapterImpl implements LeaseCarColorAdapter {

    @Autowired
    private LeaseCarColorService leaseCarColorService;

    @Autowired
    private LeaseCommonService leaseCommonService;

    /**
     * 检测数据是否被使用
     *
     * @param id
     * @return
     * @throws GMException
     */
    public Map<String, Object> checkByColorIdIsExist(Long id) throws GMException {
        List exceptionMessageList = new ArrayList();
        Map<String, Object> backMap = Maps.newHashMap();
        boolean item = false;
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("usedId", id);
        paramsMap.put("usedType", UsedType.TYPE_LEASE_CAR_COLOR);
        List<LeaseUseUsed> leaseUseUsedList = leaseCommonService.selectByUsed(paramsMap);

        if (leaseUseUsedList != null) {
            if (leaseUseUsedList.size() > 0) {
                item = true;
                LeaseCarColor leaseCarColor = leaseCarColorService.selectByPrimaryKey(id);
                Map<String, Object> exceptionMessageMap = Maps.newHashMap();
                exceptionMessageMap = new HashMap<String, Object>();
                exceptionMessageMap.put("message", leaseCarColor.getName());
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
        List<LeaseCarColor> leaseCarColorList = leaseCarColorService.findByName(params);
        if (leaseCarColorList != null) {
            if (leaseCarColorList.size() > 0) {
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
        return null;
    }

    @Override
    public ResultHashMap insertSelective(LeaseCarColor leaseCarColor, UserSession userSession) throws GMException {

        boolean isExist = checkByNameIsExist(leaseCarColor.getName(), leaseCarColor.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        Integer maxNumber = leaseCarColorService.findMaxNumber();
        if (maxNumber == null) {
            leaseCarColor.setNumber(1001);
        } else {
            leaseCarColor.setNumber(maxNumber + 1);
        }

        leaseCarColor.setCreateBy(userSession.getUserId());
        leaseCarColor.setUpdateBy(userSession.getUserId());
        leaseCarColor = leaseCarColorService.insertSelective(leaseCarColor);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    @Override
    public int updateByPrimaryKeySelective(LeaseCarColor leaseCarColor, UserSession userSession) throws GMException {

        boolean isExist = checkByNameIsExist(leaseCarColor.getName(), leaseCarColor.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }
        leaseCarColor.setUpdateBy(userSession.getUserId());
        int row = leaseCarColorService.updateByPrimaryKeySelective(leaseCarColor);
        return row;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {
        int row = leaseCarColorService.disableByPrimaryKey(params);
        return row;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        Map<String, Object> isExist = checkByColorIdIsExist(id);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }
        int row = leaseCarColorService.deleteByPrimaryKey(id);
        leaseCommonService.delUseUsed(id, null, UsedType.TYPE_LEASE_CAR_COLOR, null);//删除使用者数据
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
        int row = leaseCarColorService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseCarColor record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseCarColorService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseCarColor record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        Integer maxNumber = leaseCarColorService.findMaxNumber();
        if (maxNumber == null) {
            record.setNumber(1001);
        } else {
            record.setNumber(maxNumber + 1);
        }
        record = leaseCarColorService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public LeaseCarColor selectByPrimaryKey(Long id) throws GMException {
        LeaseCarColor leaseAccount = leaseCarColorService.selectByPrimaryKey(id);
        return leaseAccount;
    }

    public int updateByPrimaryKeySelective(LeaseCarColor record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseCarColorService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCarColor record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseCarColorService.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseCarColor> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseCarColor> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseCarColor> page = leaseCarColorService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseCarColor> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarColor> leaseCarColorList = leaseCarColorService.findAll(paramsMap);
        return leaseCarColorList;
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
        List<String> leaseCarColorList = leaseCarColorService.findExportExcelModel(params);
        return leaseCarColorList;
    }

    public int updateSort(LeaseCarColors leaseCarColors) {

        if(leaseCarColors.getLeaseCarColors()!=null && leaseCarColors.getLeaseCarColors().size()>0){
            List<LeaseCarColor> leaseCarColorList=leaseCarColors.getLeaseCarColors();
            for (LeaseCarColor leaseCarColor : leaseCarColorList) {
                leaseCarColorService.updateSort(leaseCarColor);
            }
        }
        return 0;
    }

    public List<LeaseCarColor> findAllNoPage(Map param) {
        List<LeaseCarColor> leaseCarColorList=  leaseCarColorService.findAllNoPage(param);
        return leaseCarColorList;
    }

    public LeaseCarColorExcelBackInfo importExcelCarColor(List<LeaseCarColorTemplate> leaseCarColorTemplates) throws GMException {
        LeaseCarColorExcelBackInfo  leaseCarColorExcelBackInfo = null;
        if (leaseCarColorTemplates != null) {
            if (leaseCarColorTemplates.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                List<Map> backInfoList = new ArrayList<Map>();
                for (int i = 0; i < leaseCarColorTemplates.size(); i++) {
                    LeaseCarColorTemplate  leaseCarColorTemplate = leaseCarColorTemplates.get(i);
                    String name = leaseCarColorTemplate.getName();
                    String number = leaseCarColorTemplate.getNumber();
                    if (StringUtils.isBlank(name)) {
                        leaseCarColorTemplate.setUpdateState("失败，缺少必填项");
                        failNum++;
                        continue;
                    }

                    Map<String,Object> params=Maps.newHashMap();
                    params.put("name",leaseCarColorTemplate.getName());
                    List<LeaseCarColor> leaseCarColorList = leaseCarColorService.findByName(params);
                    if(leaseCarColorList==null || leaseCarColorList.size()==0){
                        LeaseCarColor carColor=new LeaseCarColor();
                        carColor.setName(leaseCarColorTemplate.getName());
                        Integer maxNumber = leaseCarColorService.findMaxNumber();
                        if (maxNumber == null) {
                            carColor.setNumber(1001);
                        } else {
                            carColor.setNumber(maxNumber + 1);
                        }
                        leaseCarColorService.insertSelective(carColor);
                    }
                    successNum++;
                    leaseCarColorTemplate.setUpdateState("成功");

                }

                leaseCarColorExcelBackInfo = new LeaseCarColorExcelBackInfo();
                leaseCarColorExcelBackInfo.setFailNum(failNum);//失败数量
                leaseCarColorExcelBackInfo.setSuccessNum(successNum);//成功数量
                leaseCarColorExcelBackInfo.setBackInfo(backInfoList);//反馈信息
                leaseCarColorExcelBackInfo.setLeaseCarColorTemplates(leaseCarColorTemplates);
            }
        }

        return leaseCarColorExcelBackInfo;

    }
}
