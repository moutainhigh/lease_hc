package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.dao.LeaseSchemeVehicleMapper;
import com.hc.lease.supplier.model.LeaseSchemeVehicle;
import com.hc.lease.supplier.service.api.LeaseSchemeVehicleService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融租方案-适用车型ServiceImpl
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseSchemeVehicleService")
public class LeaseSchemeVehicleServiceImpl implements LeaseSchemeVehicleService {

	@Autowired
	private LeaseSchemeVehicleMapper leaseSchemeVehicleMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemeVehicleMapper.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row= leaseSchemeVehicleMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseSchemeVehicle insert(LeaseSchemeVehicle record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseSchemeVehicleMapper.insert(record);
        return record;
    }

    public LeaseSchemeVehicle insertSelective(LeaseSchemeVehicle record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseSchemeVehicleMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseSchemeVehicle> record) throws GMException {
        int row = leaseSchemeVehicleMapper.insertList(record);
        return row;
    }


    public int updateByPrimaryKeySelective(LeaseSchemeVehicle record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeVehicleMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeVehicle record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeVehicleMapper.updateByPrimaryKey(record);
        return row;
    }


    public LeaseSchemeVehicle selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeVehicle LeaseSchemeVehicle = leaseSchemeVehicleMapper.selectByPrimaryKey(id);
        return LeaseSchemeVehicle;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseSchemeVehicle> findPage(int pageNum, int pageSize,Map<String,Object> params) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseSchemeVehicle> leaseSchemeList = leaseSchemeVehicleMapper.findPage(params);
        PageInfo<LeaseSchemeVehicle> page = new PageInfo<LeaseSchemeVehicle>(leaseSchemeList);
        return page;
    }

    public List <LeaseSchemeVehicle> findAll(Map<String,Object> params) throws GMException {
        List<LeaseSchemeVehicle> leaseSchemeList = leaseSchemeVehicleMapper.findAll(params);
        return leaseSchemeList;
    }

    public void deleteBySchemeId(Long id) {
        leaseSchemeVehicleMapper.deleteBySchemeId(id);
    }

   /* public List<LeaseSchemeVehicle> findAllNoPage() {
        List<LeaseSchemeVehicle> leaseSchemeList=leaseSchemeVehicleMapper.findPage(null);
        return leaseSchemeList;
    }*/

    /*public List<LeaseSchemeVehicle> findByName(Map params) {
        List<LeaseSchemeVehicle> leaseCarSupplierList= leaseSchemeVehicleMapper.findByName(params);
        return leaseCarSupplierList;*/

}
