package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.api.LeaseSchemeCarFinancingerService;
import com.hc.lease.supplier.model.LeaseSchemeCarFinancinger;
import com.hc.lease.supplier.dao.LeaseSchemeCarFinancingerMapper;

import java.util.List;
import java.util.Map;

/**
 * 车辆与融租方ServiceImpl
 *
 * @author Qiang
 * @version 2017-08-18
 */
@Service("leaseSchemeCarFinancingerService")
public class LeaseSchemeCarFinancingerServiceImpl implements LeaseSchemeCarFinancingerService {

    @Autowired
    private LeaseSchemeCarFinancingerMapper leaseSchemeCarFinancingerMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemeCarFinancingerMapper.deleteByPrimaryKey(id);
        return row;
    }

    /**
     * 根据ID删除记录.批量删除
     *
     * @param ids .
     * @return
     * @throws GMException
     */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseSchemeCarFinancingerMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseSchemeCarFinancinger insert(LeaseSchemeCarFinancinger record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeCarFinancingerMapper.insert(record);
        return record;
    }

    public LeaseSchemeCarFinancinger insertSelective(LeaseSchemeCarFinancinger record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeCarFinancingerMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseSchemeCarFinancinger> list) throws GMException {
        int row = leaseSchemeCarFinancingerMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseSchemeCarFinancinger record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeCarFinancingerMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeCarFinancinger record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeCarFinancingerMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseSchemeCarFinancinger selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeCarFinancinger leaseSchemeCarFinancinger = leaseSchemeCarFinancingerMapper.selectByPrimaryKey(id);
        return leaseSchemeCarFinancinger;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseSchemeCarFinancinger> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseSchemeCarFinancinger> leaseSchemeCarFinancingerList = leaseSchemeCarFinancingerMapper.findPage(paramsMap);
        PageInfo<LeaseSchemeCarFinancinger> page = new PageInfo<LeaseSchemeCarFinancinger>(leaseSchemeCarFinancingerList);
        return page;
    }

    public List<LeaseSchemeCarFinancinger> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeCarFinancinger> leaseSchemeCarFinancingerList = leaseSchemeCarFinancingerMapper.findAll(paramsMap);
        return leaseSchemeCarFinancingerList;
    }

    public List<LeaseSchemeCarFinancinger> findByCarId(Long id) {

        Map<String, Object> map = Maps.newHashMap();
        map.put("carId", id);
        List<LeaseSchemeCarFinancinger> leaseSchemeCarFinancinger = leaseSchemeCarFinancingerMapper.findByCarId(map);
        return leaseSchemeCarFinancinger;
    }

    @Override
    public int deleteByCarId(Long carId) {
        int row = leaseSchemeCarFinancingerMapper.deleteByCarId(carId);
        return row;
    }
}
