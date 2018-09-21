package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.supplier.adapter.api.LeaseAgentsLevelAdapter;
import com.hc.lease.supplier.model.LeaseAgents;
import com.hc.lease.supplier.model.LeaseAgentsLevel;
import com.hc.lease.supplier.model.LeaseAgentsSecondary;
import com.hc.lease.supplier.service.api.LeaseAgentsLevelService;
import com.hc.lease.supplier.service.api.LeaseAgentsSecondaryService;
import com.hc.lease.supplier.service.api.LeaseAgentsService;
import com.hc.lease.supplier.vo.LeaseAgentsLevels;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 一级区域AdapterImpl
 *
 * @author Qiang
 * @version 2017-12-15
 */
@Service("leaseAgentsLevelAdapter")
public class LeaseAgentsLevelAdapterImpl implements LeaseAgentsLevelAdapter {

    @Autowired
    private LeaseAgentsLevelService leaseAgentsLevelService;
    @Autowired
    private LeaseAgentsSecondaryService leaseAgentsSecondaryService;
    @Autowired
    private LeaseAgentsService leaseAgentsService;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAgentsLevel> leaseAgentsLevels = leaseAgentsLevelService.findAll(null);
        List<LeaseAgentsSecondary> leaseWxSecondaries = leaseAgentsSecondaryService.findAll(null);
        List<LeaseAgents> leaseWxStores = leaseAgentsService.findAll(null);
        Map<String, Object> params = Maps.newHashMap();
        params.put("leaseWxLevelList", leaseAgentsLevels);
        params.put("leaseWxSecondaryList", leaseWxSecondaries);
        params.put("leaseWxStoresList", leaseWxStores);
        return params;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        List<LeaseAgentsSecondary> leaseWxSecondaries = leaseAgentsSecondaryService.selectByLevelId(id);
        for (LeaseAgentsSecondary leaseAgentsSecondary : leaseWxSecondaries) {
            leaseAgentsService.deleteBySecondaryId(leaseAgentsSecondary.getId());
        }
        leaseAgentsSecondaryService.deleteByLevelId(id);
        int row = leaseAgentsLevelService.deleteByPrimaryKey(id);
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
        int row = leaseAgentsLevelService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAgentsLevel record) throws GMException {
        record = leaseAgentsLevelService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAgentsLevel record) throws GMException {
        record = leaseAgentsLevelService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAgentsLevel record) throws GMException {
        int row = leaseAgentsLevelService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAgentsLevel record) throws GMException {
        int row = leaseAgentsLevelService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAgentsLevel selectByPrimaryKey(Long id) throws GMException {
        LeaseAgentsLevel leaseAgentsLevel = leaseAgentsLevelService.selectByPrimaryKey(id);
        return leaseAgentsLevel;
    }

    public int insertList(List<LeaseAgentsLevel> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAgentsLevel> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAgentsLevel> page = leaseAgentsLevelService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseAgentsLevel> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAgentsLevel> leaseAgentsLevelList = leaseAgentsLevelService.findAll(paramsMap);
        return leaseAgentsLevelList;
    }

    /**
     * 导入模板需要的数据
     *
     * @param params
     * @return
     * @throws GMException
     */
    @Override
    public List<String> findExportExcelModel(Map params) throws GMException {
        List<String> leaseWxLevelList = leaseAgentsLevelService.findExportExcelModel(params);
        return leaseWxLevelList;
    }

    /**
     * @param paramsMap
     * @return
     */
    @Override
    public List<LeaseAgentsLevel> findByName(Map<String, Object> paramsMap) {
        List<LeaseAgentsLevel> leaseAgentsLevelList = leaseAgentsLevelService.findByName(paramsMap);
        return leaseAgentsLevelList;
    }

    public int disableByPrimaryKey(Map<String, Object> paramsMap) {
       int row = leaseAgentsLevelService.disableByPrimaryKey(paramsMap);
        return row;
    }

    public int updateSort(LeaseAgentsLevels leaseAgentsLevels) {
        if(leaseAgentsLevels.getLeaseAgentsLevels()!=null && leaseAgentsLevels.getLeaseAgentsLevels().size()>0){
            List<LeaseAgentsLevel> leaseAgentsLevelList=leaseAgentsLevels.getLeaseAgentsLevels();
            for (LeaseAgentsLevel leaseAgentsLevel : leaseAgentsLevelList) {
                leaseAgentsLevelService.updateSort(leaseAgentsLevel);
            }
        }

        return 1;
    }
}
