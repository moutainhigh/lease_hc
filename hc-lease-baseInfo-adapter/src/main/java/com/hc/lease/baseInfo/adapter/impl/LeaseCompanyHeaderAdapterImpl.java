package com.hc.lease.baseInfo.adapter.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.adapter.api.LeaseCompanyHeaderAdapter;
import com.hc.lease.baseInfo.model.LeaseCompanyHeader;
import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.baseInfo.service.api.LeaseCommonService;
import com.hc.lease.baseInfo.service.api.LeaseCompanyHeaderService;
import com.hc.lease.baseInfo.vo.LeaseCompanyHeaders;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.excel.poi.vo.LeaseCompanyHeaderExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseCompanyHeaderTemplate;
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
 * 合同方-公司抬头AdapterImpl
 *
 * @author Tong
 * @version 2017-04-17
 */
@Service("leaseCompanyHeaderAdapter")
public class LeaseCompanyHeaderAdapterImpl implements LeaseCompanyHeaderAdapter {

    @Autowired
    private LeaseCompanyHeaderService leaseCompanyHeaderService;
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
        List<LeaseCompanyHeader> leaseCompanyHeaderList = leaseCompanyHeaderService.findByName(params);
        if (leaseCompanyHeaderList != null) {
            if (leaseCompanyHeaderList.size() > 0) {
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
    public Map<String, Object> checkByCompanyHeaderIdIsExist(Long id) throws GMException {
        List exceptionMessageList = new ArrayList();
        Map<String, Object> backMap = Maps.newHashMap();
        boolean item = false;
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("usedId", id);
        paramsMap.put("usedType", UsedType.TYPE_LEASE_COMPANY_HEADER);
        List<LeaseUseUsed> leaseUseUsedList = leaseCommonService.selectByUsed(paramsMap);
        if (leaseUseUsedList != null) {
            if (leaseUseUsedList.size() > 0) {
                item = true;
                LeaseCompanyHeader leaseCompanyHeader = leaseCompanyHeaderService.selectByPrimaryKey(id);
                Map<String, Object> exceptionMessageMap = Maps.newHashMap();
                exceptionMessageMap = new HashMap<String, Object>();
                exceptionMessageMap.put("message", leaseCompanyHeader.getName());
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


    public ResultHashMap insertSelective(LeaseCompanyHeader record, UserSession userSession) throws GMException {
        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }
        record.setCreateBy(userSession.getUserId());
        record.setUpdateBy(userSession.getUserId());

        Integer maxNumber = leaseCompanyHeaderService.findMaxNumber();
        if (maxNumber == null) {
            record.setNumber(1001);
        } else {
            record.setNumber(maxNumber + 1);
        }

        record = leaseCompanyHeaderService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }


    public int updateByPrimaryKeySelective(LeaseCompanyHeader record, UserSession userSession) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }
        record.setUpdateBy(userSession.getUserId());

        int row = leaseCompanyHeaderService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {

        int row = leaseCompanyHeaderService.disableByPrimaryKey(params);
        return row;
    }


    public int updateSort(LeaseCompanyHeaders leaseCompanyHeaders) {

        if(leaseCompanyHeaders.getLeaseCompanyHeaders()!=null && leaseCompanyHeaders.getLeaseCompanyHeaders().size()>0){
            List<LeaseCompanyHeader> leaseCompanyHeaderList=leaseCompanyHeaders.getLeaseCompanyHeaders();
            for (LeaseCompanyHeader leaseCompanyHeader : leaseCompanyHeaderList) {
                leaseCompanyHeaderService.updateSort(leaseCompanyHeader);
            }
        }
        return 0;
    }




    public int deleteByPrimaryKey(Long id) throws GMException {
        Map<String, Object> isExist = checkByCompanyHeaderIdIsExist(id);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }
        int row = leaseCompanyHeaderService.deleteByPrimaryKey(id);
        leaseCommonService.delUseUsed(id, null, UsedType.TYPE_LEASE_COMPANY_HEADER, null);//删除使用者数据
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
        int row = leaseCompanyHeaderService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseCompanyHeader record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseCompanyHeaderService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseCompanyHeader record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseCompanyHeaderService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public LeaseCompanyHeader selectByPrimaryKey(Long id) throws GMException {
        LeaseCompanyHeader leaseCompanyHeader = leaseCompanyHeaderService.selectByPrimaryKey(id);
        return leaseCompanyHeader;
    }

    public int updateByPrimaryKeySelective(LeaseCompanyHeader record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseCompanyHeaderService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCompanyHeader record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseCompanyHeaderService.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseCompanyHeader> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseCompanyHeader> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseCompanyHeader> page = leaseCompanyHeaderService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseCompanyHeader> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCompanyHeader> leaseCompanyHeaderList = leaseCompanyHeaderService.findAll(paramsMap);
        return leaseCompanyHeaderList;
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
        List<String> leaseCompanyHeaderList = leaseCompanyHeaderService.findExportExcelModel(params);
        return leaseCompanyHeaderList;
    }


    public List<LeaseCompanyHeader> findAllNoPage(Map param) {
        List<LeaseCompanyHeader> leaseCompanyHeaders=leaseCompanyHeaderService.findAllNoPage(param);
        return leaseCompanyHeaders;
    }

    public LeaseCompanyHeaderExcelBackInfo importExcelCompanyHeader(List<LeaseCompanyHeaderTemplate> leaseCompanyHeaderTemplates) throws GMException {
        LeaseCompanyHeaderExcelBackInfo  leaseCompanyHeaderExcelBackInfo = null;
        if (leaseCompanyHeaderTemplates != null) {
            if (leaseCompanyHeaderTemplates.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                List<Map> backInfoList = new ArrayList<Map>();
                for (int i = 0; i < leaseCompanyHeaderTemplates.size(); i++) {
                    LeaseCompanyHeaderTemplate  leaseCompanyHeaderTemplate = leaseCompanyHeaderTemplates.get(i);
                    String name = leaseCompanyHeaderTemplate.getName();
                    String number = leaseCompanyHeaderTemplate.getNumber();
                    if (StringUtils.isBlank(name)) {
                        leaseCompanyHeaderTemplate.setUpdateState("失败，缺少必填项");
                        failNum++;
                        continue;
                    }

                    Map<String,Object> params=Maps.newHashMap();
                    params.put("name",leaseCompanyHeaderTemplate.getName());
                    List<LeaseCompanyHeader> leaseCompanyHeaderList = leaseCompanyHeaderService.findByName(params);
                    if(leaseCompanyHeaderList==null || leaseCompanyHeaderList.size()==0){
                        LeaseCompanyHeader leaseCompanyHeader=new LeaseCompanyHeader();
                        leaseCompanyHeader.setName(leaseCompanyHeaderTemplate.getName());
                        Integer maxNumber = leaseCompanyHeaderService.findMaxNumber();
                        if (maxNumber == null) {
                            leaseCompanyHeader.setNumber(1001);
                        } else {
                            leaseCompanyHeader.setNumber(maxNumber + 1);
                        }
                        leaseCompanyHeaderService.insertSelective(leaseCompanyHeader);
                    }
                    successNum++;
                    leaseCompanyHeaderTemplate.setUpdateState("成功");

                }

                leaseCompanyHeaderExcelBackInfo = new LeaseCompanyHeaderExcelBackInfo();
                leaseCompanyHeaderExcelBackInfo.setFailNum(failNum);//失败数量
                leaseCompanyHeaderExcelBackInfo.setSuccessNum(successNum);//成功数量
                leaseCompanyHeaderExcelBackInfo.setBackInfo(backInfoList);//反馈信息
                leaseCompanyHeaderExcelBackInfo.setLeaseCompanyHeaderTemplates(leaseCompanyHeaderTemplates);
            }
        }

        return leaseCompanyHeaderExcelBackInfo;
    }


}
