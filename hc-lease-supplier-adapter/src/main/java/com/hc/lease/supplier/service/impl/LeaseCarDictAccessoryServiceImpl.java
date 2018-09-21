package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.dao.LeaseCarDictAccessoryMapper;
import com.hc.lease.supplier.model.LeaseCarDictAccessory;
import com.hc.lease.supplier.service.api.LeaseCarDictAccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融资方案-车辆ServiceImpl
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseCarDictAccessoryService")
public class LeaseCarDictAccessoryServiceImpl implements LeaseCarDictAccessoryService {

	@Autowired
	private LeaseCarDictAccessoryMapper leaseCarDictAccessoryMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseCarDictAccessoryMapper.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row= leaseCarDictAccessoryMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseCarDictAccessory insert(LeaseCarDictAccessory record) throws GMException {

        int row = leaseCarDictAccessoryMapper.insert(record);
        return record;
    }

    public LeaseCarDictAccessory insertSelective(LeaseCarDictAccessory record) throws GMException {
        int row = leaseCarDictAccessoryMapper.insertSelective(record);
        return record;
    }
    public int insertList(List<LeaseCarDictAccessory> record) throws GMException {
        int row = leaseCarDictAccessoryMapper.insertList(record);
        return row;
    }


    public int updateByPrimaryKeySelective(LeaseCarDictAccessory record) throws GMException {
        int row = leaseCarDictAccessoryMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCarDictAccessory record) throws GMException {
        int row = leaseCarDictAccessoryMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseCarDictAccessory selectByPrimaryKey(Long id) throws GMException {
        LeaseCarDictAccessory leaseCarDictAccessory = leaseCarDictAccessoryMapper.selectByPrimaryKey(id);
        return leaseCarDictAccessory;
    }


    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseCarDictAccessory> findPage(int pageNum, int pageSize,Map<String,Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseCarDictAccessory> leaseSchemeCarList = leaseCarDictAccessoryMapper.findPage(paramsMap);
        PageInfo<LeaseCarDictAccessory> page = new PageInfo<LeaseCarDictAccessory>(leaseSchemeCarList);
        return page;
    }

    public List <LeaseCarDictAccessory> findAll(Map<String,Object> paramsMap) throws GMException {
        List<LeaseCarDictAccessory> leaseSchemeCarList = leaseCarDictAccessoryMapper.findAll(paramsMap);
        return leaseSchemeCarList;
    }


    public void deleteByCarId(Long id) {
        leaseCarDictAccessoryMapper.deleteByCarId(id);
    }
}
