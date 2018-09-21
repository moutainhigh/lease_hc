package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeaseAgents;
import com.hc.lease.supplier.vo.FindPageVo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.api.LeaseAgentsService;
import com.hc.lease.supplier.dao.LeaseAgentsMapper;

import java.util.List;
import java.util.Map;

/**
 * 门店ServiceImpl
 *
 * @author Qiang
 * @version 2017-12-15
 */
@Service("leaseAgentsService")
public class LeaseAgentsServiceImpl implements LeaseAgentsService {

    @Autowired
    private LeaseAgentsMapper leaseAgentsMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAgentsMapper.deleteByPrimaryKey(id);
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
        int row = leaseAgentsMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAgents insert(LeaseAgents leaseAgents) throws GMException {
        leaseAgents.setCreateTime(DateTime.now().toDate());
        leaseAgents.setUpdateTime(DateTime.now().toDate());
        int row = leaseAgentsMapper.insert(leaseAgents);
        return leaseAgents;
    }

    public LeaseAgents insertSelective(LeaseAgents leaseAgents) throws GMException {
        leaseAgents.setCreateTime(DateTime.now().toDate());
        leaseAgents.setUpdateTime(DateTime.now().toDate());
        leaseAgents.setIsEnable(leaseAgents.getIsEnable() == null ? true : leaseAgents.getIsEnable());
        int row = leaseAgentsMapper.insertSelective(leaseAgents);
        return leaseAgents;
    }

    public int insertList(List<LeaseAgents> list) throws GMException {
        int row = leaseAgentsMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAgents leaseAgents) throws GMException {
        leaseAgents.setUpdateTime(DateTime.now().toDate());
        int row = leaseAgentsMapper.updateByPrimaryKeySelective(leaseAgents);
        return row;
    }

    public int updateByPrimaryKey(LeaseAgents leaseAgents) throws GMException {
        leaseAgents.setUpdateTime(DateTime.now().toDate());
        int row = leaseAgentsMapper.updateByPrimaryKey(leaseAgents);
        return row;
    }

    public LeaseAgents selectByPrimaryKey(Long id) throws GMException {
        LeaseAgents leaseAgents = leaseAgentsMapper.selectByPrimaryKey(id);
        return leaseAgents;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAgents> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAgents> leaseAgentsList = leaseAgentsMapper.findPage(paramsMap);
        PageInfo<LeaseAgents> page = new PageInfo<LeaseAgents>(leaseAgentsList);
        return page;
    }

    public List<LeaseAgents> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAgents> leaseAgentsList = leaseAgentsMapper.findAll(paramsMap);
        return leaseAgentsList;
    }

    public void deleteBySecondaryId(Long id) {
        leaseAgentsMapper.deleteBySecondaryId(id);
    }

    /**
     * @param paramsMap
     * @return
     */
    @Override
    public List<LeaseAgents> findByName(Map<String, Object> paramsMap) {
        List<LeaseAgents> leaseAgentsList = leaseAgentsMapper.findByName(paramsMap);
        return leaseAgentsList;
    }

    public int disableByPrimaryKey(Map<String, Object> paramsMap) {
       int row= leaseAgentsMapper.disableByPrimaryKey(paramsMap);
        return row;
    }

    public void updateSort(LeaseAgents leaseAgents) {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id",leaseAgents.getId());
        paramsMap.put("mark",leaseAgents.getMark());
        leaseAgentsMapper.updateSort(paramsMap);
    }

    public List<FindPageVo> findAllNoPage(Object o) {
        List<FindPageVo> leaseAgentses=leaseAgentsMapper.findAllNoPage(null);
        return leaseAgentses;
    }

    public Integer findMaxNumber() {
        Integer maxNumber=leaseAgentsMapper.findMaxNumber();
        return maxNumber;
    }

    public List<String> findExportExcelModel(Map param) {
        List<String> leaseAgentsList= leaseAgentsMapper.findExportExcelModel(param);
        return leaseAgentsList;
    }
}
