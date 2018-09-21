package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.dao.LeaseAgentsSecondaryMapper;
import com.hc.lease.supplier.model.LeaseAgentsSecondary;
import com.hc.lease.supplier.service.api.LeaseAgentsSecondaryService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 二级区域ServiceImpl
 *
 * @author Qiang
 * @version 2017-12-15
 */
@Service("leaseAgentsSecondaryService")
public class LeaseAgentsSecondaryServiceImpl implements LeaseAgentsSecondaryService {

    @Autowired
    private LeaseAgentsSecondaryMapper leaseAgentsSecondaryMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAgentsSecondaryMapper.deleteByPrimaryKey(id);
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
        int row = leaseAgentsSecondaryMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAgentsSecondary insert(LeaseAgentsSecondary leaseAgentsSecondary) throws GMException {
        leaseAgentsSecondary.setCreateTime(DateTime.now().toDate());
        leaseAgentsSecondary.setUpdateTime(DateTime.now().toDate());
        int row = leaseAgentsSecondaryMapper.insert(leaseAgentsSecondary);
        return leaseAgentsSecondary;
    }

    public LeaseAgentsSecondary insertSelective(LeaseAgentsSecondary leaseAgentsSecondary) throws GMException {
        leaseAgentsSecondary.setCreateTime(DateTime.now().toDate());
        leaseAgentsSecondary.setUpdateTime(DateTime.now().toDate());
        leaseAgentsSecondary.setIsEnable(leaseAgentsSecondary.getIsEnable() == null ? true : leaseAgentsSecondary.getIsEnable());
        int row = leaseAgentsSecondaryMapper.insertSelective(leaseAgentsSecondary);
        return leaseAgentsSecondary;
    }

    public int insertList(List<LeaseAgentsSecondary> list) throws GMException {
        int row = leaseAgentsSecondaryMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAgentsSecondary leaseAgentsSecondary) throws GMException {
        leaseAgentsSecondary.setUpdateTime(DateTime.now().toDate());
        int row = leaseAgentsSecondaryMapper.updateByPrimaryKeySelective(leaseAgentsSecondary);
        return row;
    }

    public int updateByPrimaryKey(LeaseAgentsSecondary leaseAgentsSecondary) throws GMException {
        leaseAgentsSecondary.setUpdateTime(DateTime.now().toDate());
        int row = leaseAgentsSecondaryMapper.updateByPrimaryKey(leaseAgentsSecondary);
        return row;
    }

    public LeaseAgentsSecondary selectByPrimaryKey(Long id) throws GMException {
        LeaseAgentsSecondary leaseAgentsSecondary = leaseAgentsSecondaryMapper.selectByPrimaryKey(id);
        return leaseAgentsSecondary;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAgentsSecondary> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAgentsSecondary> leaseAgentsSecondaryList = leaseAgentsSecondaryMapper.findPage(paramsMap);
        PageInfo<LeaseAgentsSecondary> page = new PageInfo<LeaseAgentsSecondary>(leaseAgentsSecondaryList);
        return page;
    }

    public List<LeaseAgentsSecondary> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAgentsSecondary> leaseAgentsSecondaryList = leaseAgentsSecondaryMapper.findAll(paramsMap);
        return leaseAgentsSecondaryList;
    }

    public List<LeaseAgentsSecondary> selectByLevelId(Long id) {
        List<LeaseAgentsSecondary> leaseWxSecondaries = leaseAgentsSecondaryMapper.selectByLevelId(id);
        return leaseWxSecondaries;
    }

    public void deleteByLevelId(Long id) {
        leaseAgentsSecondaryMapper.deleteByLevelId(id);
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
        List<String> leaseWxSecondaries = leaseAgentsSecondaryMapper.findExportExcelModel(params);
        return leaseWxSecondaries;
    }

    /**
     * @param paramsMap
     * @return
     */
    @Override
    public List<LeaseAgentsSecondary> findByName(Map<String, Object> paramsMap) {
        List<LeaseAgentsSecondary> leaseWxSecondaries = leaseAgentsSecondaryMapper.findByName(paramsMap);
        return leaseWxSecondaries;
    }

    public int disableByPrimaryKey(Map<String, Object> paramsMap) {
      int row=  leaseAgentsSecondaryMapper.disableByPrimaryKey(paramsMap);
        return row;
    }

    public void updateSort(LeaseAgentsSecondary leaseAgentsSecondary) {

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id",leaseAgentsSecondary.getId());
        paramsMap.put("mark",leaseAgentsSecondary.getMark());
        leaseAgentsSecondaryMapper.updateSort(paramsMap);
    }
}
