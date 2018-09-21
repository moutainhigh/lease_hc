package com.hc.lease.supplier.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeaseInsuranceCompany;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.LeaseInsuranceTypeService;
import com.hc.lease.supplier.model.LeaseInsuranceType;
import com.hc.lease.supplier.dao.LeaseInsuranceTypeMapper;

import java.util.List;
import java.util.Map;

/**
 * 险种ServiceImpl
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseInsuranceTypeService")
public class LeaseInsuranceTypeServiceImpl implements LeaseInsuranceTypeService {

	@Autowired
	private LeaseInsuranceTypeMapper leaseInsuranceTypeMapper;

    public Map<String,Object> insertViewParames(Map<String, Object> paramsMap) throws GMException{

        Map<String,Object> map= leaseInsuranceTypeMapper.insertViewParames(paramsMap);

        return map;
    }

    public List<LeaseInsuranceType> findByInsuranceCompanyId(List<Long> ids) {
        List<LeaseInsuranceType> leaseInsuranceTypeList=leaseInsuranceTypeMapper.findByInsuranceCompanyId(ids);
        return leaseInsuranceTypeList;
    }


    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseInsuranceTypeMapper.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row= leaseInsuranceTypeMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseInsuranceType insert(LeaseInsuranceType record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseInsuranceTypeMapper.insert(record);
        return record;
    }

    public LeaseInsuranceType insertSelective(LeaseInsuranceType record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseInsuranceTypeMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseInsuranceType> record) throws GMException {
        int row = leaseInsuranceTypeMapper.insertList(record);
        return row;
    }


    public int updateByPrimaryKeySelective(LeaseInsuranceType record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseInsuranceTypeMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseInsuranceType record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseInsuranceTypeMapper.updateByPrimaryKey(record);
        return row;
    }


    public LeaseInsuranceType selectByPrimaryKey(Long id) throws GMException {
        LeaseInsuranceType leaseInsuranceType = leaseInsuranceTypeMapper.selectByPrimaryKey(id);
        return leaseInsuranceType;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseInsuranceType> findPage(int pageNum, int pageSize,Map<String,Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseInsuranceType> leaseInsuranceTypeList = leaseInsuranceTypeMapper.findPage(paramsMap);
        PageInfo<LeaseInsuranceType> page = new PageInfo<LeaseInsuranceType>(leaseInsuranceTypeList);
        return page;
    }


    public List <LeaseInsuranceType> findAll(Map<String,Object> paramsMap) throws GMException {
        List<LeaseInsuranceType> leaseInsuranceTypeList = leaseInsuranceTypeMapper.findAll(paramsMap);
        return leaseInsuranceTypeList;
    }

}
