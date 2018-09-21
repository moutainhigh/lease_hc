package com.hc.lease.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.service.api.LeaseWxCustomService;
import com.hc.lease.wx.model.LeaseWxCustom;
import com.hc.lease.wx.dao.LeaseWxCustomMapper;

import java.util.List;
import java.util.Map;

/**
 * 小程序短信参数配置ServiceImpl
 * @author Qiang
 * @version 2018-03-23
 */
@Service("leaseWxCustomService")
public class LeaseWxCustomServiceImpl implements LeaseWxCustomService {

	@Autowired
	private LeaseWxCustomMapper leaseWxCustomMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxCustomMapper.deleteByPrimaryKey(id);
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
        int row = leaseWxCustomMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseWxCustom insert(LeaseWxCustom leaseWxCustom) throws GMException {
        leaseWxCustom.setCreateTime(DateTime.now().toDate());
        leaseWxCustom.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCustomMapper.insert(leaseWxCustom);
        return leaseWxCustom;
    }

    public LeaseWxCustom insertSelective(LeaseWxCustom leaseWxCustom) throws GMException {
        leaseWxCustom.setCreateTime(DateTime.now().toDate());
        leaseWxCustom.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCustomMapper.insertSelective(leaseWxCustom);
        return leaseWxCustom;
    }

    public int insertList(List<LeaseWxCustom> list) throws GMException {
        int row = leaseWxCustomMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseWxCustom leaseWxCustom) throws GMException {
        leaseWxCustom.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCustomMapper.updateByPrimaryKeySelective(leaseWxCustom);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxCustom leaseWxCustom) throws GMException {
        leaseWxCustom.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxCustomMapper.updateByPrimaryKey(leaseWxCustom);
        return row;
    }

    public LeaseWxCustom selectByPrimaryKey(Long id) throws GMException {
        LeaseWxCustom leaseWxCustom = leaseWxCustomMapper.selectByPrimaryKey(id);
        return leaseWxCustom;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseWxCustom> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseWxCustom> leaseWxCustomList = leaseWxCustomMapper.findPage(paramsMap);
        PageInfo<LeaseWxCustom> page = new PageInfo<LeaseWxCustom>(leaseWxCustomList);
        return page;
    }

    public List <LeaseWxCustom> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxCustom> leaseWxCustomList = leaseWxCustomMapper.findAll(paramsMap);
        return leaseWxCustomList;
    }

    public int updateDealStatus(Long id, Integer deal) {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id",id);
        paramsMap.put("deal",deal);
       int row= leaseWxCustomMapper.updateDealStatus(paramsMap);
        return row;
    }

    public List<LeaseWxCustom> findAllNoPage(Map<String, Object> paramsMap) {
        List<LeaseWxCustom> leaseWxCustoms=leaseWxCustomMapper.findPage(paramsMap);
        return leaseWxCustoms;
    }
}
