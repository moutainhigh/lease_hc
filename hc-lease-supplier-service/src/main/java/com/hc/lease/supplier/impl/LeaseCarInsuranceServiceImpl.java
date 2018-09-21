package com.hc.lease.supplier.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.LeaseCarInsuranceService;
import com.hc.lease.supplier.model.LeaseCarInsurance;
import com.hc.lease.supplier.dao.LeaseCarInsuranceMapper;

import java.util.List;
import java.util.Map;

/**
 * 车辆保险信息ServiceImpl
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseCarInsuranceService")
public class LeaseCarInsuranceServiceImpl implements LeaseCarInsuranceService {

	@Autowired
	private LeaseCarInsuranceMapper leaseCarInsuranceMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseCarInsuranceMapper.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row= leaseCarInsuranceMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseCarInsurance insert(LeaseCarInsurance record) throws GMException {
        int row = leaseCarInsuranceMapper.insert(record);
        return record;
    }

    public LeaseCarInsurance insertSelective(LeaseCarInsurance record) throws GMException {

        int row = leaseCarInsuranceMapper.insertSelective(record);
        return record;
    }




    public int insertList(List<LeaseCarInsurance> record) throws GMException {
        int row = leaseCarInsuranceMapper.insertList(record);
        return row;
    }



    public int updateByPrimaryKeySelective(LeaseCarInsurance record) throws GMException {

        int row = leaseCarInsuranceMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCarInsurance record) throws GMException {

        int row = leaseCarInsuranceMapper.updateByPrimaryKey(record);
        return row;
    }



    public LeaseCarInsurance selectByPrimaryKey(Long id) throws GMException {
        LeaseCarInsurance leaseCarInsurance = leaseCarInsuranceMapper.selectByPrimaryKey(id);
        return leaseCarInsurance;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseCarInsurance> findPage(int pageNum, int pageSize,Map<String,Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseCarInsurance> leaseCarInsuranceList = leaseCarInsuranceMapper.findPage(paramsMap);
        PageInfo<LeaseCarInsurance> page = new PageInfo<LeaseCarInsurance>(leaseCarInsuranceList);
        return page;
    }

    public List <LeaseCarInsurance> findAll(Map<String,Object> paramsMap) throws GMException {
        List<LeaseCarInsurance> leaseCarInsuranceList = leaseCarInsuranceMapper.findAll(paramsMap);
        return leaseCarInsuranceList;
    }

    public void updateByCarId(LeaseCarInsurance leaseCarInsurance) {
        leaseCarInsuranceMapper.updateByCarId(leaseCarInsurance);

    }

    public void deleteByCarId(Long id) {
        leaseCarInsuranceMapper.deleteByCarId(id);
    }
}
