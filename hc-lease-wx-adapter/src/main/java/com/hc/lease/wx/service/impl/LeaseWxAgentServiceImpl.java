package com.hc.lease.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.service.api.LeaseWxAgentService;
import com.hc.lease.wx.model.LeaseWxAgent;
import com.hc.lease.wx.dao.LeaseWxAgentMapper;

import java.util.List;
import java.util.Map;

/**
 * 代理ServiceImpl
 * @author Qiang
 * @version 2017-11-29
 */
@Service("leaseWxAgentService")
public class LeaseWxAgentServiceImpl implements LeaseWxAgentService {

	@Autowired
	private LeaseWxAgentMapper leaseWxAgentMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxAgentMapper.deleteByPrimaryKey(id);
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
        int row = leaseWxAgentMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseWxAgent insert(LeaseWxAgent leaseWxAgent) throws GMException {
        leaseWxAgent.setCreateTime(DateTime.now().toDate());
        leaseWxAgent.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxAgentMapper.insert(leaseWxAgent);
        return leaseWxAgent;
    }

    public LeaseWxAgent insertSelective(LeaseWxAgent leaseWxAgent) throws GMException {
        leaseWxAgent.setCreateTime(DateTime.now().toDate());
        leaseWxAgent.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxAgentMapper.insertSelective(leaseWxAgent);
        return leaseWxAgent;
    }

    public int insertList(List<LeaseWxAgent> list) throws GMException {
        int row = leaseWxAgentMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseWxAgent leaseWxAgent) throws GMException {
        leaseWxAgent.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxAgentMapper.updateByPrimaryKeySelective(leaseWxAgent);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxAgent leaseWxAgent) throws GMException {
        leaseWxAgent.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxAgentMapper.updateByPrimaryKey(leaseWxAgent);
        return row;
    }

    public LeaseWxAgent selectByPrimaryKey(Long id) throws GMException {
        LeaseWxAgent leaseWxAgent = leaseWxAgentMapper.selectByPrimaryKey(id);
        return leaseWxAgent;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseWxAgent> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseWxAgent> leaseWxAgentList = leaseWxAgentMapper.findPage(paramsMap);
        PageInfo<LeaseWxAgent> page = new PageInfo<LeaseWxAgent>(leaseWxAgentList);
        return page;
    }

    public List <LeaseWxAgent> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxAgent> leaseWxAgentList = leaseWxAgentMapper.findAll(paramsMap);
        return leaseWxAgentList;
    }

    public int updateDealStatus(Long id, Integer deal) {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id",id);
        paramsMap.put("deal",deal);
        int row =leaseWxAgentMapper.updateDealStatus(paramsMap);
        return row;
    }

    public List<LeaseWxAgent> findAllNoPage(Map<String, Object> paramsMap) {
      List<LeaseWxAgent> leaseWxAgents=leaseWxAgentMapper.findPage(paramsMap);
        return leaseWxAgents;
    }
}
