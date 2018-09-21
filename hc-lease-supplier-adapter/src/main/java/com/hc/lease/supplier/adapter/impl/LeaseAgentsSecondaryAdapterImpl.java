package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.supplier.adapter.api.LeaseAgentsSecondaryAdapter;
import com.hc.lease.supplier.model.LeaseAgentsSecondary;
import com.hc.lease.supplier.service.api.LeaseAgentsService;
import com.hc.lease.supplier.vo.LeaseAgentsSecondarys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.api.LeaseAgentsSecondaryService;

import hc.lease.common.util.ListUtil;

import java.util.List;
import java.util.Map;

import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 二级区域AdapterImpl
 *
 * @author Qiang
 * @version 2017-12-15
 */
@Service("leaseAgentsSecondaryAdapter")
public class LeaseAgentsSecondaryAdapterImpl implements LeaseAgentsSecondaryAdapter {

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
        return null;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        leaseAgentsService.deleteBySecondaryId(id);
        int row = leaseAgentsSecondaryService.deleteByPrimaryKey(id);
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
        int row = leaseAgentsSecondaryService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAgentsSecondary record) throws GMException {
        record = leaseAgentsSecondaryService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAgentsSecondary record) throws GMException {
        record = leaseAgentsSecondaryService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAgentsSecondary record) throws GMException {
        int row = leaseAgentsSecondaryService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAgentsSecondary record) throws GMException {
        int row = leaseAgentsSecondaryService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAgentsSecondary selectByPrimaryKey(Long id) throws GMException {
        LeaseAgentsSecondary leaseAgentsSecondary = leaseAgentsSecondaryService.selectByPrimaryKey(id);
        return leaseAgentsSecondary;
    }

    public int insertList(List<LeaseAgentsSecondary> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAgentsSecondary> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAgentsSecondary> page = leaseAgentsSecondaryService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseAgentsSecondary> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAgentsSecondary> leaseAgentsSecondaryList = leaseAgentsSecondaryService.findAll(paramsMap);
        return leaseAgentsSecondaryList;
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
        List<String> leaseWxSecondaryList = leaseAgentsSecondaryService.findExportExcelModel(params);
        return leaseWxSecondaryList;
    }

    /**
     * @param paramsMap
     * @return
     */
    @Override
    public List<LeaseAgentsSecondary> findByName(Map<String, Object> paramsMap) {
        List<LeaseAgentsSecondary> leaseAgentsSecondaryList = leaseAgentsSecondaryService.findByName(paramsMap);
        return leaseAgentsSecondaryList;
    }

    public int disableByPrimaryKey(Map<String, Object> paramsMap) {
        int row=leaseAgentsSecondaryService.disableByPrimaryKey(paramsMap);
        return row;
    }

    public int updateSort(LeaseAgentsSecondarys leaseAgentsSecondarys) {
        if(leaseAgentsSecondarys.getLeaseAgentsSecondaries()!=null && leaseAgentsSecondarys.getLeaseAgentsSecondaries().size()>0){
            List<LeaseAgentsSecondary> leaseAgentsSecondaryList=leaseAgentsSecondarys.getLeaseAgentsSecondaries();
            for (LeaseAgentsSecondary leaseAgentsSecondary : leaseAgentsSecondaryList) {
                leaseAgentsSecondaryService.updateSort(leaseAgentsSecondary);
            }
        }
        return 1;
    }
}
