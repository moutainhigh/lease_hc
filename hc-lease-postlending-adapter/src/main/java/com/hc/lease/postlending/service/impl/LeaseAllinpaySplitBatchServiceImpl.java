package com.hc.lease.postlending.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.postlending.service.api.LeaseAllinpaySplitBatchService;
import com.hc.lease.postlending.model.LeaseAllinpaySplitBatch;
import com.hc.lease.postlending.dao.LeaseAllinpaySplitBatchMapper;

import java.util.List;
import java.util.Map;

/**
 * 通联支付超额拆分交易明细 批量支付批次统计ServiceImpl
 * @author Tong
 * @version 2018-06-19
 */
@Service("leaseAllinpaySplitBatchService")
public class LeaseAllinpaySplitBatchServiceImpl implements LeaseAllinpaySplitBatchService {

	@Autowired
	private LeaseAllinpaySplitBatchMapper leaseAllinpaySplitBatchMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAllinpaySplitBatchMapper.deleteByPrimaryKey(id);
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
        int row = leaseAllinpaySplitBatchMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAllinpaySplitBatch insert(LeaseAllinpaySplitBatch leaseAllinpaySplitBatch) throws GMException {
        leaseAllinpaySplitBatch.setCreateTime(DateTime.now().toDate());
        leaseAllinpaySplitBatch.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpaySplitBatchMapper.insert(leaseAllinpaySplitBatch);
        return leaseAllinpaySplitBatch;
    }

    public LeaseAllinpaySplitBatch insertSelective(LeaseAllinpaySplitBatch leaseAllinpaySplitBatch) throws GMException {
        leaseAllinpaySplitBatch.setCreateTime(DateTime.now().toDate());
        leaseAllinpaySplitBatch.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpaySplitBatchMapper.insertSelective(leaseAllinpaySplitBatch);
        return leaseAllinpaySplitBatch;
    }

    public int insertList(List<LeaseAllinpaySplitBatch> list) throws GMException {
        int row = leaseAllinpaySplitBatchMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpaySplitBatch leaseAllinpaySplitBatch) throws GMException {
        leaseAllinpaySplitBatch.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpaySplitBatchMapper.updateByPrimaryKeySelective(leaseAllinpaySplitBatch);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpaySplitBatch leaseAllinpaySplitBatch) throws GMException {
        leaseAllinpaySplitBatch.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpaySplitBatchMapper.updateByPrimaryKey(leaseAllinpaySplitBatch);
        return row;
    }

    public LeaseAllinpaySplitBatch selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpaySplitBatch leaseAllinpaySplitBatch = leaseAllinpaySplitBatchMapper.selectByPrimaryKey(id);
        return leaseAllinpaySplitBatch;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseAllinpaySplitBatch> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAllinpaySplitBatch> leaseAllinpaySplitBatchList = leaseAllinpaySplitBatchMapper.findPage(paramsMap);
        PageInfo<LeaseAllinpaySplitBatch> page = new PageInfo<LeaseAllinpaySplitBatch>(leaseAllinpaySplitBatchList);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <LeaseAllinpaySplitBatch> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpaySplitBatch> leaseAllinpaySplitBatchList = leaseAllinpaySplitBatchMapper.findAll(paramsMap);
        return leaseAllinpaySplitBatchList;
    }

    @Override
    public LeaseAllinpaySplitBatch selectByBatchNumber(Map<String, Object> paramsMap) {
        LeaseAllinpaySplitBatch leaseAllinpaySplitBatch = leaseAllinpaySplitBatchMapper.selectByBatchNumber(paramsMap);
        return leaseAllinpaySplitBatch;
    }
}
