package com.hc.lease.supplier.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeaseInsuranceType;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.LeasePackageService;
import com.hc.lease.supplier.model.LeasePackage;
import com.hc.lease.supplier.dao.LeasePackageMapper;

import java.util.List;
import java.util.Map;

/**
 * 套餐ServiceImpl
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leasePackageService")
public class LeasePackageServiceImpl implements LeasePackageService {

	@Autowired
	private LeasePackageMapper leasePackageMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leasePackageMapper.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row= leasePackageMapper.deleteBatchById(ids);
        return row;
    }

    public LeasePackage insert(LeasePackage record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leasePackageMapper.insert(record);
        return record;
    }

    public LeasePackage insertSelective(LeasePackage record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leasePackageMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeasePackage> record) throws GMException {
        int row = leasePackageMapper.insertList(record);
        return row;
    }


    public int updateByPrimaryKeySelective(LeasePackage record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leasePackageMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeasePackage record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leasePackageMapper.updateByPrimaryKey(record);
        return row;
    }


    public LeasePackage selectByPrimaryKey(Long id) throws GMException {
        LeasePackage leasePackage = leasePackageMapper.selectByPrimaryKey(id);
        return leasePackage;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeasePackage> findPage(int pageNum, int pageSize,Map<String,Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeasePackage> leasePackageList = leasePackageMapper.findPage(paramsMap);
        PageInfo<LeasePackage> page = new PageInfo<LeasePackage>(leasePackageList);
        return page;
    }

    public List <LeasePackage> findAll(Map<String,Object> paramsMap) throws GMException {
        List<LeasePackage> leasePackageList = leasePackageMapper.findAll(paramsMap);
        return leasePackageList;
    }

}
