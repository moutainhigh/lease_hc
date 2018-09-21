package com.hc.lease.baseInfo.adapter.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.adapter.api.LeaseCarBuyFinancingerAdapter;
import com.hc.lease.baseInfo.model.LeaseCarBuyFinancinger;
import com.hc.lease.baseInfo.model.LeaseDict;
import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.baseInfo.service.api.LeaseCarBuyFinancingerService;
import com.hc.lease.baseInfo.service.api.LeaseCommonService;
import com.hc.lease.baseInfo.service.api.LeaseDictService;
import com.hc.lease.baseInfo.vo.LeaseCarBuyFinancingers;
import com.hc.lease.common.core.constant.DictType;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.excel.poi.vo.LeaseCarBuyFinancingerExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseCarBuyFinancingerTemplate;
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
 * 购车融资方AdapterImpl
 *
 * @author Tong
 * @version 2017-04-17
 */
@Service("leaseCarBuyFinancingerAdapter")
public class LeaseCarBuyFinancingerAdapterImpl implements LeaseCarBuyFinancingerAdapter {

    @Autowired
    private LeaseCarBuyFinancingerService leaseCarBuyFinancingerService;

    @Autowired
    private LeaseDictService leaseDictService;

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
        List<LeaseCarBuyFinancinger> leaseCarBuyFinancingerList = leaseCarBuyFinancingerService.findByName(params);
        if (leaseCarBuyFinancingerList != null) {
            if (leaseCarBuyFinancingerList.size() > 0) {
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
        List<LeaseCarBuyFinancinger> leaseCarBuyFinancingerList = leaseCarBuyFinancingerService.findByName(params);
        if (leaseCarBuyFinancingerList != null) {
            if (leaseCarBuyFinancingerList.size() > 0) {
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
    public Map<String, Object> checkByCarBuyFinancingerIdIsExist(Long id) throws GMException {
        List exceptionMessageList = new ArrayList();
        Map<String, Object> backMap = Maps.newHashMap();
        boolean item = false;
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("usedId", id);
        paramsMap.put("usedType", UsedType.TYPE_LEASE_CAR_BUY_FINANCINGER);
        List<LeaseUseUsed> leaseUseUsedList = leaseCommonService.selectByUsed(paramsMap);
        if (leaseUseUsedList != null) {
            if (leaseUseUsedList.size() > 0) {
                item = true;
                LeaseCarBuyFinancinger leaseCarBuyFinancinger = leaseCarBuyFinancingerService.selectByPrimaryKey(id);
                Map<String, Object> exceptionMessageMap = Maps.newHashMap();
                exceptionMessageMap = new HashMap<String, Object>();
                exceptionMessageMap.put("message", leaseCarBuyFinancinger.getName());
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
        Map<String, Object> map = Maps.newHashMap();
        List<LeaseDict> leaseDictFinancingModeList = leaseDictService.findByType(DictType.TYPE_FINANCINGMODE);//融资方式
        map.put("leaseDictFinancingModeList", leaseDictFinancingModeList);
        return map;
    }


    public ResultHashMap insertSelective(LeaseCarBuyFinancinger leaseCarBuyFinancinger, UserSession userSession) throws GMException {

        boolean isExist = checkByNameIsExist(leaseCarBuyFinancinger.getName(), leaseCarBuyFinancinger.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        boolean bool = checkByNumberIsExist(leaseCarBuyFinancinger.getNumber(), leaseCarBuyFinancinger.getId());
        if (bool) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "number");
            throw new GMException(GMExceptionConstant.NUMBER_REPEAT, backMap);
        }



        leaseCarBuyFinancinger.setCreateBy(userSession.getUserId());
        leaseCarBuyFinancinger.setUpdateBy(userSession.getUserId());

        leaseCarBuyFinancinger = leaseCarBuyFinancingerService.insertSelective(leaseCarBuyFinancinger);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }


    public int updateByPrimaryKeySelective(LeaseCarBuyFinancinger leaseCarBuyFinancinger, UserSession userSession) throws GMException {
        boolean isExist = checkByNameIsExist(leaseCarBuyFinancinger.getName(), leaseCarBuyFinancinger.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }
        boolean bool = checkByNumberIsExist(leaseCarBuyFinancinger.getNumber(), leaseCarBuyFinancinger.getId());
        if (bool) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "number");
            throw new GMException(GMExceptionConstant.NUMBER_REPEAT, backMap);
        }


        leaseCarBuyFinancinger.setUpdateBy(userSession.getUserId());
        int row = leaseCarBuyFinancingerService.updateByPrimaryKeySelective(leaseCarBuyFinancinger);
        return row;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {

        int row = leaseCarBuyFinancingerService.disableByPrimaryKey(params);
        return row;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        Map<String, Object> isExist = checkByCarBuyFinancingerIdIsExist(id);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }
        int row = leaseCarBuyFinancingerService.deleteByPrimaryKey(id);
        leaseCommonService.delUseUsed(id, null, UsedType.TYPE_LEASE_CAR_BUY_FINANCINGER, null);//删除使用者数据
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
        int row = leaseCarBuyFinancingerService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseCarBuyFinancinger record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseCarBuyFinancingerService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseCarBuyFinancinger record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseCarBuyFinancingerService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public LeaseCarBuyFinancinger selectByPrimaryKey(Long id) throws GMException {
        LeaseCarBuyFinancinger leaseCarBuyFinancinger = leaseCarBuyFinancingerService.selectByPrimaryKey(id);
        return leaseCarBuyFinancinger;
    }

    public int updateByPrimaryKeySelective(LeaseCarBuyFinancinger record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseCarBuyFinancingerService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCarBuyFinancinger record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseCarBuyFinancingerService.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseCarBuyFinancinger> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseCarBuyFinancinger> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseCarBuyFinancinger> page = leaseCarBuyFinancingerService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseCarBuyFinancinger> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarBuyFinancinger> leaseCarBuyFinancingerList = leaseCarBuyFinancingerService.findAll(paramsMap);
        return leaseCarBuyFinancingerList;
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
        List<String> list = leaseCarBuyFinancingerService.findExportExcelModel(params);
        return list;
    }

    public int updateSort(LeaseCarBuyFinancingers leaseCarBuyFinancingers) {
        if(leaseCarBuyFinancingers.getLeaseCarBuyFinancingers()!=null && leaseCarBuyFinancingers.getLeaseCarBuyFinancingers().size()>0){
            List<LeaseCarBuyFinancinger> carBuyFinancingers=leaseCarBuyFinancingers.getLeaseCarBuyFinancingers();
            for (LeaseCarBuyFinancinger  carBuyFinancinger: carBuyFinancingers) {
                leaseCarBuyFinancingerService.updateSort(carBuyFinancinger);
            }
        }
        return 0;
    }

    public List<LeaseCarBuyFinancinger> findAllNoPage(Map param) {
        List<LeaseCarBuyFinancinger> leaseCarBuyFinancingerList=leaseCarBuyFinancingerService.findAllNoPage(param);
        return leaseCarBuyFinancingerList;
    }

    public LeaseCarBuyFinancingerExcelBackInfo importExcelCarBuyFinancinger(List<LeaseCarBuyFinancingerTemplate> leaseCarBuyFinancingerTemplates) throws GMException {

        LeaseCarBuyFinancingerExcelBackInfo leaseCarBuyFinancingerExcelBackInfo = null;
        if (leaseCarBuyFinancingerTemplates != null) {
            if (leaseCarBuyFinancingerTemplates.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                List<Map> backInfoList = new ArrayList<Map>();
                for (int i = 0; i < leaseCarBuyFinancingerTemplates.size(); i++) {
                    LeaseCarBuyFinancingerTemplate  leaseCarBuyFinancingerTemplate = leaseCarBuyFinancingerTemplates.get(i);
                    String name = leaseCarBuyFinancingerTemplate.getName();
                    String number = leaseCarBuyFinancingerTemplate.getNumber();

                    if (StringUtils.isBlank(name)||StringUtils.isBlank(number)) {
                        leaseCarBuyFinancingerTemplate.setUpdateState("失败，缺少必填项");
                        failNum++;
                        continue;
                    }

                    Long financingMode=null;
                    if(StringUtils.isNotEmpty(leaseCarBuyFinancingerTemplate.getFinancingModeName())){
                        Map<String,Object> param=Maps.newHashMap();
                        param.put("name",leaseCarBuyFinancingerTemplate.getFinancingModeName());
                        param.put("type",DictType.TYPE_FINANCINGMODE);
                        List<LeaseDict> financingModeList = leaseDictService.findByValueAndType(param);
                        if(financingModeList==null ||financingModeList.size()==0){
                            leaseCarBuyFinancingerTemplate.setUpdateState("失败，融资方式不存在");
                            failNum++;
                            continue;
                        }
                         financingMode = financingModeList.get(0).getId();
                    }




                    Map<String,Object> params=Maps.newHashMap();
                    params.put("name",leaseCarBuyFinancingerTemplate.getName());
                    List<LeaseCarBuyFinancinger> leaseCarBuyFinancingerList = leaseCarBuyFinancingerService.findByName(params);
                    if(leaseCarBuyFinancingerList!=null && leaseCarBuyFinancingerList.size()>0){
                        boolean bool = checkByNumberIsExist(leaseCarBuyFinancingerTemplate.getNumber(), leaseCarBuyFinancingerList.get(0).getId());
                        if (bool) {
                            leaseCarBuyFinancingerTemplate.setUpdateState("失败，编号重复");
                            failNum++;
                            continue;
                        }

                        for (int j = 0; j < leaseCarBuyFinancingerList.size(); j++) {
                            LeaseCarBuyFinancinger leaseCarBuyFinancinger = leaseCarBuyFinancingerList.get(j);
                            dualUpdateCarBuyFinancingerImportExcel(leaseCarBuyFinancingerTemplate,leaseCarBuyFinancinger,financingMode);
                        }
                    } else {
                        boolean bool = checkByNumberIsExist(leaseCarBuyFinancingerTemplate.getNumber(), null);
                        if (bool) {
                            leaseCarBuyFinancingerTemplate.setUpdateState("失败，编号重复");
                            failNum++;
                            continue;
                        }
                        dualInsertCarBuyFinancingerImportExcel(leaseCarBuyFinancingerTemplate,financingMode);
                    }
                    successNum++;
                    leaseCarBuyFinancingerTemplate.setUpdateState("成功");

                }

                leaseCarBuyFinancingerExcelBackInfo = new LeaseCarBuyFinancingerExcelBackInfo();
                leaseCarBuyFinancingerExcelBackInfo.setFailNum(failNum);//失败数量
                leaseCarBuyFinancingerExcelBackInfo.setSuccessNum(successNum);//成功数量
                leaseCarBuyFinancingerExcelBackInfo.setBackInfo(backInfoList);//反馈信息
                leaseCarBuyFinancingerExcelBackInfo.setLeaseCarBuyFinancingerTemplates(leaseCarBuyFinancingerTemplates);
            }
        }

        return leaseCarBuyFinancingerExcelBackInfo;

    }

    private void dualInsertCarBuyFinancingerImportExcel(LeaseCarBuyFinancingerTemplate leaseCarBuyFinancingerTemplate,Long financingMode) throws GMException {
        LeaseCarBuyFinancinger carBuyFinancinger= new LeaseCarBuyFinancinger();
        carBuyFinancinger.setName(leaseCarBuyFinancingerTemplate.getName());
        carBuyFinancinger.setNumber(leaseCarBuyFinancingerTemplate.getNumber());
        carBuyFinancinger.setFinancingMode(financingMode);
        carBuyFinancinger.setFinancingProportion(leaseCarBuyFinancingerTemplate.getFinancingProportion());
        carBuyFinancinger.setFinancingQuota(leaseCarBuyFinancingerTemplate.getFinancingQuota());
        carBuyFinancinger.setRemarks(leaseCarBuyFinancingerTemplate.getRemarks());
        leaseCarBuyFinancingerService.insertSelective(carBuyFinancinger);


    }

    private void dualUpdateCarBuyFinancingerImportExcel(LeaseCarBuyFinancingerTemplate leaseCarBuyFinancingerTemplate, LeaseCarBuyFinancinger leaseCarBuyFinancinger, Long financingMode) throws GMException {
        LeaseCarBuyFinancinger carBuyFinancinger= new LeaseCarBuyFinancinger();
        carBuyFinancinger.setId(leaseCarBuyFinancinger.getId());
        carBuyFinancinger.setName(leaseCarBuyFinancingerTemplate.getName());
        carBuyFinancinger.setNumber(leaseCarBuyFinancingerTemplate.getNumber());
        carBuyFinancinger.setFinancingMode(financingMode);
        carBuyFinancinger.setFinancingProportion(leaseCarBuyFinancingerTemplate.getFinancingProportion());
        carBuyFinancinger.setFinancingQuota(leaseCarBuyFinancingerTemplate.getFinancingQuota());
        carBuyFinancinger.setRemarks(leaseCarBuyFinancingerTemplate.getRemarks());
        leaseCarBuyFinancingerService.updateByPrimaryKeySelective(carBuyFinancinger);
    }
}
