package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeaseAgentsLevel;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.api.LeaseAgentsLevelService;
import com.hc.lease.supplier.dao.LeaseAgentsLevelMapper;

import java.util.List;
import java.util.Map;

/**
 * 一级区域ServiceImpl
 *
 * @author Qiang
 * @version 2017-12-15
 */
@Service("leaseAgentsLevelService")
public class LeaseAgentsLevelServiceImpl implements LeaseAgentsLevelService {

    @Autowired
    private LeaseAgentsLevelMapper leaseAgentsLevelMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAgentsLevelMapper.deleteByPrimaryKey(id);
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
        int row = leaseAgentsLevelMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAgentsLevel insert(LeaseAgentsLevel leaseAgentsLevel) throws GMException {
        leaseAgentsLevel.setCreateTime(DateTime.now().toDate());
        leaseAgentsLevel.setUpdateTime(DateTime.now().toDate());
        int row = leaseAgentsLevelMapper.insert(leaseAgentsLevel);
        return leaseAgentsLevel;
    }

    public LeaseAgentsLevel insertSelective(LeaseAgentsLevel leaseAgentsLevel) throws GMException {
        leaseAgentsLevel.setCreateTime(DateTime.now().toDate());
        leaseAgentsLevel.setUpdateTime(DateTime.now().toDate());
        leaseAgentsLevel.setIsEnable(leaseAgentsLevel.getIsEnable() == null ? true : leaseAgentsLevel.getIsEnable());
        int row = leaseAgentsLevelMapper.insertSelective(leaseAgentsLevel);
        return leaseAgentsLevel;
    }

    public int insertList(List<LeaseAgentsLevel> list) throws GMException {
        int row = leaseAgentsLevelMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAgentsLevel leaseAgentsLevel) throws GMException {
        leaseAgentsLevel.setUpdateTime(DateTime.now().toDate());
        int row = leaseAgentsLevelMapper.updateByPrimaryKeySelective(leaseAgentsLevel);
        return row;
    }

    public int updateByPrimaryKey(LeaseAgentsLevel leaseAgentsLevel) throws GMException {
        leaseAgentsLevel.setUpdateTime(DateTime.now().toDate());
        int row = leaseAgentsLevelMapper.updateByPrimaryKey(leaseAgentsLevel);
        return row;
    }

    public LeaseAgentsLevel selectByPrimaryKey(Long id) throws GMException {
        LeaseAgentsLevel leaseAgentsLevel = leaseAgentsLevelMapper.selectByPrimaryKey(id);
        return leaseAgentsLevel;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAgentsLevel> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAgentsLevel> leaseAgentsLevelList = leaseAgentsLevelMapper.findPage(paramsMap);
        PageInfo<LeaseAgentsLevel> page = new PageInfo<LeaseAgentsLevel>(leaseAgentsLevelList);
        return page;
    }

    public List<LeaseAgentsLevel> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAgentsLevel> leaseAgentsLevelList = leaseAgentsLevelMapper.findAll(paramsMap);
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
        List<String> leaseWxLevelList = leaseAgentsLevelMapper.findExportExcelModel(params);
        return leaseWxLevelList;
    }

    /**
     * @param paramsMap
     * @return
     */
    @Override
    public List<LeaseAgentsLevel> findByName(Map<String, Object> paramsMap) {
        List<LeaseAgentsLevel> leaseAgentsLevelList = leaseAgentsLevelMapper.findByName(paramsMap);
        return leaseAgentsLevelList;
    }

    public int disableByPrimaryKey(Map<String, Object> paramsMap) {
       int row= leaseAgentsLevelMapper.disableByPrimaryKey(paramsMap);
        return row;
    }

    public void updateSort(LeaseAgentsLevel leaseAgentsLevel) {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id",leaseAgentsLevel.getId());
        paramsMap.put("mark",leaseAgentsLevel.getMark());
        leaseAgentsLevelMapper.updateSort(paramsMap);
    }
}
