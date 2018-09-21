package com.hc.lease.postlending.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.dao.LeaseAllinpayBatchMapper;
import com.hc.lease.postlending.model.LeaseAllinpayBatch;
import com.hc.lease.postlending.service.api.LeaseAllinpayBatchService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通联批量代收批次统计ServiceImpl
 * @author Tong
 * @version 2017-06-09
 */
@Service("leaseAllinpayBatchService")
public class LeaseAllinpayBatchServiceImpl implements LeaseAllinpayBatchService {

	@Autowired
	private LeaseAllinpayBatchMapper leaseAllinpayBatchMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAllinpayBatchMapper.deleteByPrimaryKey(id);
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
        int row = leaseAllinpayBatchMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAllinpayBatch insert(LeaseAllinpayBatch record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpayBatchMapper.insert(record);
        return record;
    }

    public LeaseAllinpayBatch insertSelective(LeaseAllinpayBatch record) throws GMException {
        int row = leaseAllinpayBatchMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseAllinpayBatch> list) throws GMException {
        int row = leaseAllinpayBatchMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpayBatch record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpayBatchMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpayBatch record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpayBatchMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAllinpayBatch selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpayBatch leaseAllinpayBatch = leaseAllinpayBatchMapper.selectByPrimaryKey(id);
        return leaseAllinpayBatch;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseAllinpayBatch> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAllinpayBatch> leaseAllinpayBatchList = leaseAllinpayBatchMapper.findPage(paramsMap);
        PageInfo<LeaseAllinpayBatch> page = new PageInfo<LeaseAllinpayBatch>(leaseAllinpayBatchList);
        return page;
    }

    public List <LeaseAllinpayBatch> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpayBatch> leaseAllinpayBatchList = leaseAllinpayBatchMapper.findAll(paramsMap);
        return leaseAllinpayBatchList;
    }

    @Override
    public LeaseAllinpayBatch selectByBatchNumber(Map<String, Object> paramsMap) {
        LeaseAllinpayBatch leaseAllinpayBatch = leaseAllinpayBatchMapper.selectByBatchNumber(paramsMap);
        return leaseAllinpayBatch;
    }

    public List<LeaseAllinpayBatch> findNoPage(Map<String, Object> paramsMap) {
        List<LeaseAllinpayBatch> leaseAllinpayBatchList = leaseAllinpayBatchMapper.findPage(paramsMap);
        return leaseAllinpayBatchList;
    }
}
