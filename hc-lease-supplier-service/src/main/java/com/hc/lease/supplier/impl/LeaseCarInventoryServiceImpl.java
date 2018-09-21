package com.hc.lease.supplier.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeaseCarInsurance;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.LeaseCarInventoryService;
import com.hc.lease.supplier.model.LeaseCarInventory;
import com.hc.lease.supplier.dao.LeaseCarInventoryMapper;

import java.util.List;
import java.util.Map;

/**
 * 库存ServiceImpl
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseCarInventoryService")
public class LeaseCarInventoryServiceImpl implements LeaseCarInventoryService {

	@Autowired
	private LeaseCarInventoryMapper leaseCarInventoryMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseCarInventoryMapper.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row= leaseCarInventoryMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseCarInventory insert(LeaseCarInventory record) throws GMException {

        int row = leaseCarInventoryMapper.insert(record);
        return record;
    }

    public LeaseCarInventory insertSelective(LeaseCarInventory record) throws GMException {
        int row = leaseCarInventoryMapper.insertSelective(record);
        return record;
    }
    public int insertList(List<LeaseCarInventory> record) throws GMException {
        int row = leaseCarInventoryMapper.insertList(record);
        return row;
    }


    public int updateByPrimaryKeySelective(LeaseCarInventory record) throws GMException {
        int row = leaseCarInventoryMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCarInventory record) throws GMException {
        int row = leaseCarInventoryMapper.updateByPrimaryKey(record);
        return row;
    }


    public LeaseCarInventory selectByPrimaryKey(Long id) throws GMException {
        LeaseCarInventory leaseCarInventory = leaseCarInventoryMapper.selectByPrimaryKey(id);
        return leaseCarInventory;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseCarInventory> findPage(int pageNum, int pageSize,Map<String,Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseCarInventory> leaseCarInventoryList = leaseCarInventoryMapper.findPage(paramsMap);
        PageInfo<LeaseCarInventory> page = new PageInfo<LeaseCarInventory>(leaseCarInventoryList);
        return page;
    }

    public List <LeaseCarInventory> findAll(Map<String,Object> paramsMap) throws GMException {
        List<LeaseCarInventory> leaseCarInventoryList = leaseCarInventoryMapper.findAll(paramsMap);
        return leaseCarInventoryList;
    }

}
