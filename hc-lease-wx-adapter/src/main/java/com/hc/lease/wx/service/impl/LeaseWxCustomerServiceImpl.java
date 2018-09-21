package com.hc.lease.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.service.api.LeaseWxCustomerService;
import com.hc.lease.wx.model.LeaseWxCustomer;
import com.hc.lease.wx.dao.LeaseWxCustomerMapper;

import java.util.List;
import java.util.Map;

/**
 * 预约客户ServiceImpl
 * @author Qiang
 * @version 2017-11-29
 */
@Service("leaseWxCustomerService")
public class LeaseWxCustomerServiceImpl implements LeaseWxCustomerService {

	@Autowired
	private LeaseWxCustomerMapper leaseWxCustomerMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxCustomerMapper.deleteByPrimaryKey(id);
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
        int row = leaseWxCustomerMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseWxCustomer insert(LeaseWxCustomer leaseWxCustomer) throws GMException {
        leaseWxCustomer.setCreateTime(DateTime.now().toDate());
        leaseWxCustomer.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCustomerMapper.insert(leaseWxCustomer);
        return leaseWxCustomer;
    }

    public LeaseWxCustomer insertSelective(LeaseWxCustomer leaseWxCustomer) throws GMException {
        leaseWxCustomer.setCreateTime(DateTime.now().toDate());
        leaseWxCustomer.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCustomerMapper.insertSelective(leaseWxCustomer);
        return leaseWxCustomer;
    }

    public int insertList(List<LeaseWxCustomer> list) throws GMException {
        int row = leaseWxCustomerMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseWxCustomer leaseWxCustomer) throws GMException {
        leaseWxCustomer.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCustomerMapper.updateByPrimaryKeySelective(leaseWxCustomer);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxCustomer leaseWxCustomer) throws GMException {
        leaseWxCustomer.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCustomerMapper.updateByPrimaryKey(leaseWxCustomer);
        return row;
    }

    public LeaseWxCustomer selectByPrimaryKey(Long id) throws GMException {
        LeaseWxCustomer leaseWxCustomer = leaseWxCustomerMapper.selectByPrimaryKey(id);
        return leaseWxCustomer;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseWxCustomer> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseWxCustomer> leaseWxCustomerList = leaseWxCustomerMapper.findPage(paramsMap);
        PageInfo<LeaseWxCustomer> page = new PageInfo<LeaseWxCustomer>(leaseWxCustomerList);
        return page;
    }

    public List <LeaseWxCustomer> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxCustomer> leaseWxCustomerList = leaseWxCustomerMapper.findAll(paramsMap);
        return leaseWxCustomerList;
    }

    public int updateDealStatus(Long id, Integer deal) {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id",id);
        paramsMap.put("deal",deal);
        int row =leaseWxCustomerMapper.updateDealStatus(paramsMap);
        return row;
    }

    public List<LeaseWxCustomer> findAllNoPage(Map<String, Object> paramsMap) {
       List<LeaseWxCustomer> leaseWxCustomers= leaseWxCustomerMapper.findPage(paramsMap);
        return leaseWxCustomers;
    }
}
