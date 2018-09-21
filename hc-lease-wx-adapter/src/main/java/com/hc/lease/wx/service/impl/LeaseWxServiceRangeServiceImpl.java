package com.hc.lease.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.service.api.LeaseWxServiceRangeService;
import com.hc.lease.wx.model.LeaseWxServiceRange;
import com.hc.lease.wx.dao.LeaseWxServiceRangeMapper;

import java.util.List;
import java.util.Map;

/**
 * 服务范围ServiceImpl
 * @author Qiang
 * @version 2018-03-26
 */
@Service("leaseWxServiceRangeService")
public class LeaseWxServiceRangeServiceImpl implements LeaseWxServiceRangeService {

	@Autowired
	private LeaseWxServiceRangeMapper leaseWxServiceRangeMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxServiceRangeMapper.deleteByPrimaryKey(id);
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
        int row = leaseWxServiceRangeMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseWxServiceRange insert(LeaseWxServiceRange leaseWxServiceRange) throws GMException {
        leaseWxServiceRange.setCreateTime(DateTime.now().toDate());
        leaseWxServiceRange.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxServiceRangeMapper.insert(leaseWxServiceRange);
        return leaseWxServiceRange;
    }

    public LeaseWxServiceRange insertSelective(LeaseWxServiceRange leaseWxServiceRange) throws GMException {
        leaseWxServiceRange.setCreateTime(DateTime.now().toDate());
        leaseWxServiceRange.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxServiceRangeMapper.insertSelective(leaseWxServiceRange);
        return leaseWxServiceRange;
    }

    public int insertList(List<LeaseWxServiceRange> list) throws GMException {
        int row = leaseWxServiceRangeMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseWxServiceRange leaseWxServiceRange) throws GMException {
        leaseWxServiceRange.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxServiceRangeMapper.updateByPrimaryKeySelective(leaseWxServiceRange);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxServiceRange leaseWxServiceRange) throws GMException {
        leaseWxServiceRange.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxServiceRangeMapper.updateByPrimaryKey(leaseWxServiceRange);
        return row;
    }

    public LeaseWxServiceRange selectByPrimaryKey(Long id) throws GMException {
        LeaseWxServiceRange leaseWxServiceRange = leaseWxServiceRangeMapper.selectByPrimaryKey(id);
        return leaseWxServiceRange;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseWxServiceRange> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseWxServiceRange> leaseWxServiceRangeList = leaseWxServiceRangeMapper.findPage(paramsMap);
        PageInfo<LeaseWxServiceRange> page = new PageInfo<LeaseWxServiceRange>(leaseWxServiceRangeList);
        return page;
    }

    public List <LeaseWxServiceRange> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxServiceRange> leaseWxServiceRangeList = leaseWxServiceRangeMapper.findAll(paramsMap);
        return leaseWxServiceRangeList;
    }

}
