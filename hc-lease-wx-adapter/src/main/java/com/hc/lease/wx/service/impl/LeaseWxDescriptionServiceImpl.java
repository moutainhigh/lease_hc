package com.hc.lease.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.service.api.LeaseWxDescriptionService;
import com.hc.lease.wx.model.LeaseWxDescription;
import com.hc.lease.wx.dao.LeaseWxDescriptionMapper;

import java.util.List;
import java.util.Map;

/**
 * 简介ServiceImpl
 * @author Qiang
 * @version 2018-03-28
 */
@Service("leaseWxDescriptionService")
public class LeaseWxDescriptionServiceImpl implements LeaseWxDescriptionService {

	@Autowired
	private LeaseWxDescriptionMapper leaseWxDescriptionMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxDescriptionMapper.deleteByPrimaryKey(id);
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
        int row = leaseWxDescriptionMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseWxDescription insert(LeaseWxDescription leaseWxDescription) throws GMException {
        leaseWxDescription.setCreateTime(DateTime.now().toDate());
        leaseWxDescription.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxDescriptionMapper.insert(leaseWxDescription);
        return leaseWxDescription;
    }

    public LeaseWxDescription insertSelective(LeaseWxDescription leaseWxDescription) throws GMException {
        leaseWxDescription.setCreateTime(DateTime.now().toDate());
        leaseWxDescription.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxDescriptionMapper.insertSelective(leaseWxDescription);
        return leaseWxDescription;
    }

    public int insertList(List<LeaseWxDescription> list) throws GMException {
        int row = leaseWxDescriptionMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseWxDescription leaseWxDescription) throws GMException {
        leaseWxDescription.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxDescriptionMapper.updateByPrimaryKeySelective(leaseWxDescription);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxDescription leaseWxDescription) throws GMException {
        leaseWxDescription.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxDescriptionMapper.updateByPrimaryKey(leaseWxDescription);
        return row;
    }

    public LeaseWxDescription selectByPrimaryKey(Long id) throws GMException {
        LeaseWxDescription leaseWxDescription = leaseWxDescriptionMapper.selectByPrimaryKey(id);
        return leaseWxDescription;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseWxDescription> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseWxDescription> leaseWxDescriptionList = leaseWxDescriptionMapper.findPage(paramsMap);
        PageInfo<LeaseWxDescription> page = new PageInfo<LeaseWxDescription>(leaseWxDescriptionList);
        return page;
    }

    public List <LeaseWxDescription> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxDescription> leaseWxDescriptionList = leaseWxDescriptionMapper.findAll(paramsMap);
        return leaseWxDescriptionList;
    }

}
