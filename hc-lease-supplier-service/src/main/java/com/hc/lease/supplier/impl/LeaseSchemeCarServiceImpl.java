package com.hc.lease.supplier.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeasePackage;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.LeaseSchemeCarService;
import com.hc.lease.supplier.model.LeaseSchemeCar;
import com.hc.lease.supplier.dao.LeaseSchemeCarMapper;

import java.util.List;
import java.util.Map;

/**
 * 融资方案-车辆ServiceImpl
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseSchemeCarService")
public class LeaseSchemeCarServiceImpl implements LeaseSchemeCarService {

	@Autowired
	private LeaseSchemeCarMapper leaseSchemeCarMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemeCarMapper.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row= leaseSchemeCarMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseSchemeCar insert(LeaseSchemeCar record) throws GMException {

        int row = leaseSchemeCarMapper.insert(record);
        return record;
    }

    public LeaseSchemeCar insertSelective(LeaseSchemeCar record) throws GMException {
        int row = leaseSchemeCarMapper.insertSelective(record);
        return record;
    }
    public int insertList(List<LeaseSchemeCar> record) throws GMException {
        int row = leaseSchemeCarMapper.insertList(record);
        return row;
    }


    public int updateByPrimaryKeySelective(LeaseSchemeCar record) throws GMException {
        int row = leaseSchemeCarMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeCar record) throws GMException {
        int row = leaseSchemeCarMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseSchemeCar selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeCar leaseSchemeCar = leaseSchemeCarMapper.selectByPrimaryKey(id);
        return leaseSchemeCar;
    }


    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseSchemeCar> findPage(int pageNum, int pageSize,Map<String,Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseSchemeCar> leaseSchemeCarList = leaseSchemeCarMapper.findPage(paramsMap);
        PageInfo<LeaseSchemeCar> page = new PageInfo<LeaseSchemeCar>(leaseSchemeCarList);
        return page;
    }

    public List <LeaseSchemeCar> findAll(Map<String,Object> paramsMap) throws GMException {
        List<LeaseSchemeCar> leaseSchemeCarList = leaseSchemeCarMapper.findAll(paramsMap);
        return leaseSchemeCarList;
    }

    public int updateBySchemId(LeaseSchemeCar leaseSchemeCar) {
        leaseSchemeCarMapper.updateBySchemeId(leaseSchemeCar);


        return 0;
    }

    public int deleteBySchemeId(Long id) {
       int row= leaseSchemeCarMapper.deleteBySchemeId(id);

        return row;
    }
}
