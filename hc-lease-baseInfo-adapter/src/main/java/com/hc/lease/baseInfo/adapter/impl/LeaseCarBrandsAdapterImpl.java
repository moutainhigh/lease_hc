package com.hc.lease.baseInfo.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.adapter.api.LeaseCarBrandsAdapter;
import com.hc.lease.baseInfo.model.LeaseCarBrands;
import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.baseInfo.service.api.LeaseCarBrandsService;
import com.hc.lease.baseInfo.service.api.LeaseCarSeriesService;
import com.hc.lease.baseInfo.service.api.LeaseCommonService;
import com.hc.lease.baseInfo.vo.LeaseCarBrandses;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.constant.UserSession;
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
 * 车辆品牌ServiceImpl
 *
 * @author Tong
 * @version 2017-04-17
 */
@Service("leaseCarBrandsAdapter")
public class LeaseCarBrandsAdapterImpl implements LeaseCarBrandsAdapter {

    @Autowired
    private LeaseCarBrandsService leaseCarBrandsService;

    @Autowired
    private LeaseCommonService leaseCommonService;

    /**
     * 检测数据是否被使用
     *
     * @param id
     * @return
     * @throws GMException
     */
    public Map<String, Object> checkByBrandsIdIsExist(Long id) throws GMException {
        List exceptionMessageList = new ArrayList();
        Map<String, Object> backMap = Maps.newHashMap();
        boolean item = false;
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("usedId", id);
        paramsMap.put("usedType", UsedType.TYPE_LEASE_CAR_BRANDS);
        List<LeaseUseUsed> leaseUseUsedList = leaseCommonService.selectByUsed(paramsMap);

        if (leaseUseUsedList != null) {
            if (leaseUseUsedList.size() > 0) {
                item = true;
                LeaseCarBrands leaseCarBrands = leaseCarBrandsService.selectByPrimaryKey(id);
                Map<String, Object> exceptionMessageMap = Maps.newHashMap();
                exceptionMessageMap = new HashMap<String, Object>();
                exceptionMessageMap.put("message", leaseCarBrands.getName());
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
        List<LeaseCarBrands> leaseCarBrandsList = leaseCarBrandsService.findByName(params);
        if (leaseCarBrandsList != null) {
            if (leaseCarBrandsList.size() > 0) {
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
    public ResultHashMap insertSelective(LeaseCarBrands leaseCarBrands, UserSession userSession) throws GMException {
        boolean isExist = checkByNameIsExist(leaseCarBrands.getName(), leaseCarBrands.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }
        leaseCarBrands.setCreateBy(userSession.getUserId());
        leaseCarBrands.setUpdateBy(userSession.getUserId());
        leaseCarBrands = leaseCarBrandsService.insertSelective(leaseCarBrands);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }


    public int updateByPrimaryKeySelective(LeaseCarBrands leaseCarBrands, UserSession userSession) throws GMException {

        boolean isExist = checkByNameIsExist(leaseCarBrands.getName(), leaseCarBrands.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }
        leaseCarBrands.setUpdateBy(userSession.getUserId());

        int row = leaseCarBrandsService.updateByPrimaryKeySelective(leaseCarBrands);
        return row;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {
        int row = leaseCarBrandsService.disableByPrimaryKey(params);
        return row;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        Map<String, Object> isExist = checkByBrandsIdIsExist(id);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }
        int row = leaseCarBrandsService.deleteByPrimaryKey(id);
        leaseCommonService.delUseUsed(id, null, UsedType.TYPE_LEASE_CAR_BRANDS, null);//删除使用者数据
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
        int row = leaseCarBrandsService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseCarBrands record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseCarBrandsService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseCarBrands record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseCarBrandsService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public LeaseCarBrands selectByPrimaryKey(Long id) throws GMException {
        LeaseCarBrands leaseCarBrands = leaseCarBrandsService.selectByPrimaryKey(id);
        return leaseCarBrands;
    }

    public int updateByPrimaryKeySelective(LeaseCarBrands record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseCarBrandsService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCarBrands record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseCarBrandsService.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseCarBrands> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseCarBrands> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseCarBrands> page = leaseCarBrandsService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseCarBrands> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarBrands> leaseCarBrandsList = leaseCarBrandsService.findAll(paramsMap);
        return leaseCarBrandsList;
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
        List<String> leaseCarBrandsList = leaseCarBrandsService.findExportExcelModel(params);
        return leaseCarBrandsList;
    }

    public int updateSort(LeaseCarBrandses leaseCarBrandses) {
        if(leaseCarBrandses.getLeaseCarBrandses()!=null && leaseCarBrandses.getLeaseCarBrandses().size()>0){
            List<LeaseCarBrands> leaseCarBrandsList=leaseCarBrandses.getLeaseCarBrandses();
            for (LeaseCarBrands leaseCarBrands : leaseCarBrandsList) {
                leaseCarBrandsService.updateSort(leaseCarBrands);
            }
        }

        return 1;
    }
}
