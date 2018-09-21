package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.order.service.api.LeaseSchemeRepaymentHistoryService;
import com.hc.lease.order.model.LeaseSchemeRepaymentHistory;
import com.hc.lease.order.dao.LeaseSchemeRepaymentHistoryMapper;

import java.util.List;
import java.util.Map;

/**
 * 根据融租合同数据生成月租还款计划明细 历史ServiceImpl
 * @author Tong
 * @version 2018-07-19
 */
@Service("leaseSchemeRepaymentHistoryService")
public class LeaseSchemeRepaymentHistoryServiceImpl implements LeaseSchemeRepaymentHistoryService {

	@Autowired
	private LeaseSchemeRepaymentHistoryMapper leaseSchemeRepaymentHistoryMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemeRepaymentHistoryMapper.deleteByPrimaryKey(id);
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
        int row = leaseSchemeRepaymentHistoryMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseSchemeRepaymentHistory insert(LeaseSchemeRepaymentHistory leaseSchemeRepaymentHistory) throws GMException {
        leaseSchemeRepaymentHistory.setCreateTime(DateTime.now().toDate());
        leaseSchemeRepaymentHistory.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeRepaymentHistoryMapper.insert(leaseSchemeRepaymentHistory);
        return leaseSchemeRepaymentHistory;
    }

    public LeaseSchemeRepaymentHistory insertSelective(LeaseSchemeRepaymentHistory leaseSchemeRepaymentHistory) throws GMException {
        leaseSchemeRepaymentHistory.setCreateTime(DateTime.now().toDate());
        leaseSchemeRepaymentHistory.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeRepaymentHistoryMapper.insertSelective(leaseSchemeRepaymentHistory);
        return leaseSchemeRepaymentHistory;
    }

    public int insertList(List<LeaseSchemeRepaymentHistory> list) throws GMException {
        int row = leaseSchemeRepaymentHistoryMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseSchemeRepaymentHistory leaseSchemeRepaymentHistory) throws GMException {
        leaseSchemeRepaymentHistory.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeRepaymentHistoryMapper.updateByPrimaryKeySelective(leaseSchemeRepaymentHistory);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeRepaymentHistory leaseSchemeRepaymentHistory) throws GMException {
        leaseSchemeRepaymentHistory.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeRepaymentHistoryMapper.updateByPrimaryKey(leaseSchemeRepaymentHistory);
        return row;
    }

    public LeaseSchemeRepaymentHistory selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeRepaymentHistory leaseSchemeRepaymentHistory = leaseSchemeRepaymentHistoryMapper.selectByPrimaryKey(id);
        return leaseSchemeRepaymentHistory;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseSchemeRepaymentHistory> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseSchemeRepaymentHistory> leaseSchemeRepaymentHistoryList = leaseSchemeRepaymentHistoryMapper.findPage(paramsMap);
        PageInfo<LeaseSchemeRepaymentHistory> page = new PageInfo<LeaseSchemeRepaymentHistory>(leaseSchemeRepaymentHistoryList);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <LeaseSchemeRepaymentHistory> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeRepaymentHistory> leaseSchemeRepaymentHistoryList = leaseSchemeRepaymentHistoryMapper.findAll(paramsMap);
        return leaseSchemeRepaymentHistoryList;
    }

}
