package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.dao.LeaseInventoryAdjustmentMapper;
import com.hc.lease.supplier.model.LeaseInventoryAdjustment;
import com.hc.lease.supplier.service.api.LeaseInventoryAdjustmentService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 调库ServiceImpl
 * @author Qiang
 * @version 2017-05-22
 */
@Service("leaseInventoryAdjustmentService")
public class LeaseInventoryAdjustmentServiceImpl implements LeaseInventoryAdjustmentService {

	@Autowired
	private LeaseInventoryAdjustmentMapper leaseInventoryAdjustmentMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseInventoryAdjustmentMapper.deleteByPrimaryKey(id);
        return row;
    }
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row= leaseInventoryAdjustmentMapper.deleteBatchById(ids);
        return row;
    }
    public LeaseInventoryAdjustment insert(LeaseInventoryAdjustment record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseInventoryAdjustmentMapper.insert(record);
        return record;
    }
    public int insertList(List<LeaseInventoryAdjustment> record) throws GMException {
        int row = leaseInventoryAdjustmentMapper.insertList(record);
        return row;
    }

    public LeaseInventoryAdjustment insertSelective(LeaseInventoryAdjustment record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseInventoryAdjustmentMapper.insertSelective(record);
        return record;
    }


    public int updateByPrimaryKeySelective(LeaseInventoryAdjustment record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseInventoryAdjustmentMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseInventoryAdjustment record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseInventoryAdjustmentMapper.updateByPrimaryKey(record);
        return row;
    }



    public LeaseInventoryAdjustment selectByPrimaryKey(Long id) throws GMException {
        LeaseInventoryAdjustment leaseInventoryAdjustment = leaseInventoryAdjustmentMapper.selectByPrimaryKey(id);
        return leaseInventoryAdjustment;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseInventoryAdjustment> findPage(int pageNum, int pageSize,Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseInventoryAdjustment> leaseInventoryAdjustmentList = leaseInventoryAdjustmentMapper.findPage(paramsMap);
        PageInfo<LeaseInventoryAdjustment> page = new PageInfo<LeaseInventoryAdjustment>(leaseInventoryAdjustmentList);
        return page;
    }

    public List <LeaseInventoryAdjustment> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseInventoryAdjustment> leaseInventoryAdjustmentList = leaseInventoryAdjustmentMapper.findAll(paramsMap);
        return leaseInventoryAdjustmentList;
    }

}
