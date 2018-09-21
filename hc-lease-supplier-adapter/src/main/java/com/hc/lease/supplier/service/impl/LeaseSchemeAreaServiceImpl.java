package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.dao.LeaseSchemeAreaMapper;
import com.hc.lease.supplier.model.LeaseSchemeArea;
import com.hc.lease.supplier.service.api.LeaseSchemeAreaService;
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
@Service("leaseSchemeAreaService")
public class LeaseSchemeAreaServiceImpl implements LeaseSchemeAreaService {

	@Autowired
	private LeaseSchemeAreaMapper leaseSchemeAreaMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemeAreaMapper.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row= leaseSchemeAreaMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseSchemeArea insert(LeaseSchemeArea record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseSchemeAreaMapper.insert(record);
        return record;
    }

    public LeaseSchemeArea insertSelective(LeaseSchemeArea record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseSchemeAreaMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseSchemeArea> record) throws GMException {
        int row = leaseSchemeAreaMapper.insertList(record);
        return row;
    }


    public int updateByPrimaryKeySelective(LeaseSchemeArea record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeAreaMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeArea record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeAreaMapper.updateByPrimaryKey(record);
        return row;
    }


    public LeaseSchemeArea selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeArea leaseSchemeArea = leaseSchemeAreaMapper.selectByPrimaryKey(id);
        return leaseSchemeArea;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseSchemeArea> findPage(int pageNum, int pageSize,Map<String,Object> params) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseSchemeArea> leaseSchemeList = leaseSchemeAreaMapper.findPage(params);
        PageInfo<LeaseSchemeArea> page = new PageInfo<LeaseSchemeArea>(leaseSchemeList);
        return page;
    }

    public List <LeaseSchemeArea> findAll(Map<String,Object> params) throws GMException {
        List<LeaseSchemeArea> leaseSchemeList = leaseSchemeAreaMapper.findAll(params);
        return leaseSchemeList;
    }

    public void deleteBySchemeId(Long id) {
        leaseSchemeAreaMapper.deleteBySchemeId(id);
    }

   /* public List<LeaseSchemeVehicle> findAllNoPage() {
        List<LeaseSchemeVehicle> leaseSchemeList=leaseSchemeVehicleMapper.findPage(null);
        return leaseSchemeList;
    }*/

    /*public List<LeaseSchemeVehicle> findByName(Map params) {
        List<LeaseSchemeVehicle> leaseCarSupplierList= leaseSchemeVehicleMapper.findByName(params);
        return leaseCarSupplierList;*/
    
}
