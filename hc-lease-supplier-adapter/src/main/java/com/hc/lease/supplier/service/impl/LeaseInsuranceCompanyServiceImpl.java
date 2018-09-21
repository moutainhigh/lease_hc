package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.dao.LeaseInsuranceCompanyMapper;
import com.hc.lease.supplier.model.LeaseInsuranceCompany;
import com.hc.lease.supplier.service.api.LeaseInsuranceCompanyService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 保险公司ServiceImpl
 *
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseInsuranceCompanyService")
public class LeaseInsuranceCompanyServiceImpl implements LeaseInsuranceCompanyService {

    @Autowired
    private LeaseInsuranceCompanyMapper leaseInsuranceCompanyMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseInsuranceCompanyMapper.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseInsuranceCompanyMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseInsuranceCompany insert(LeaseInsuranceCompany record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseInsuranceCompanyMapper.insert(record);
        return record;
    }

    public LeaseInsuranceCompany insertSelective(LeaseInsuranceCompany record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseInsuranceCompanyMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseInsuranceCompany> record) throws GMException {
        int row = leaseInsuranceCompanyMapper.insertList(record);
        return row;
    }


    public int updateByPrimaryKeySelective(LeaseInsuranceCompany record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseInsuranceCompanyMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseInsuranceCompany record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseInsuranceCompanyMapper.updateByPrimaryKey(record);
        return row;
    }


    public LeaseInsuranceCompany selectByPrimaryKey(Long id) throws GMException {
        LeaseInsuranceCompany leaseInsuranceCompany = leaseInsuranceCompanyMapper.selectByPrimaryKey(id);
        return leaseInsuranceCompany;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseInsuranceCompany> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseInsuranceCompany> leaseInsuranceCompanyList = leaseInsuranceCompanyMapper.findPage(paramsMap);
        PageInfo<LeaseInsuranceCompany> page = new PageInfo<LeaseInsuranceCompany>(leaseInsuranceCompanyList);
        return page;
    }

    public List<LeaseInsuranceCompany> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseInsuranceCompany> leaseInsuranceCompanyList = leaseInsuranceCompanyMapper.findAll(paramsMap);
        return leaseInsuranceCompanyList;
    }

    public List<LeaseInsuranceCompany> findByName(Map params) {

        List<LeaseInsuranceCompany> leaseInsuranceCompanyList = leaseInsuranceCompanyMapper.findByName(params);

        return leaseInsuranceCompanyList;
    }

    public int disableByPrimaryKey(Map<String, Object> params) {
        int row = leaseInsuranceCompanyMapper.disableByPrimaryKey(params);
        return row;
    }

    @Override
    public Long getIdByInsuranceCompanyName(String insuranceCompanyName) {
        return leaseInsuranceCompanyMapper.getIdByInsuranceCompanyName(insuranceCompanyName);
    }

    @Override
    public List<String> findAllInsuranceCompanyNames() {
        return leaseInsuranceCompanyMapper.findAllInsuranceCompanyNames();
    }

    public List<LeaseInsuranceCompany> findAllNoPage(Map param) {
        List<LeaseInsuranceCompany> leaseInsuranceCompanyList=leaseInsuranceCompanyMapper.findPage(param);
        return leaseInsuranceCompanyList;
    }

    public Integer findMaxNumber() {
        Integer number=  leaseInsuranceCompanyMapper.findMaxNumber();
        return number;
    }

    public void updateSort(LeaseInsuranceCompany leaseInsuranceCompany) {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id",leaseInsuranceCompany.getId());
        paramsMap.put("mark",leaseInsuranceCompany.getMark());
        leaseInsuranceCompanyMapper.updateSort(paramsMap);
    }
}
