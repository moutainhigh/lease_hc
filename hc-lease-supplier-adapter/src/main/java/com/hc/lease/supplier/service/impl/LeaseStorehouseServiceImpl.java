package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.dao.LeaseStorehouseMapper;
import com.hc.lease.supplier.model.LeaseStorehouse;
import com.hc.lease.supplier.service.api.LeaseStorehouseService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 仓库ServiceImpl
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseStorehouseService")
public class LeaseStorehouseServiceImpl implements LeaseStorehouseService {

	@Autowired
	private LeaseStorehouseMapper leaseStorehouseMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseStorehouseMapper.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row= leaseStorehouseMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseStorehouse insert(LeaseStorehouse record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseStorehouseMapper.insert(record);
        return record;
    }

    public LeaseStorehouse insertSelective(LeaseStorehouse record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseStorehouseMapper.insertSelective(record);
        return record;
    }


    public int insertList(List<LeaseStorehouse> record) throws GMException {
        int row = leaseStorehouseMapper.insertList(record);
        return row;
    }


    public int updateByPrimaryKeySelective(LeaseStorehouse record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseStorehouseMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseStorehouse record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseStorehouseMapper.updateByPrimaryKey(record);
        return row;
    }


    public LeaseStorehouse selectByPrimaryKey(Long id) throws GMException {
        LeaseStorehouse leaseStorehouse = leaseStorehouseMapper.selectByPrimaryKey(id);
        return leaseStorehouse;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseStorehouse> findPage(int pageNum, int pageSize,Map<String,Object> params) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseStorehouse> leaseStorehouseList = leaseStorehouseMapper.findPage(params);
        PageInfo<LeaseStorehouse> page = new PageInfo<LeaseStorehouse>(leaseStorehouseList);
        return page;
    }

    public List <LeaseStorehouse> findAll(Map<String,Object> params) throws GMException {
        List<LeaseStorehouse> leaseStorehouseList = leaseStorehouseMapper.findAll(params);
        return leaseStorehouseList;
    }

    public List<LeaseStorehouse> findByBranchCompanyId(List<String> ids) {
        List<LeaseStorehouse> leaseStorehouseList=leaseStorehouseMapper.findByBranchCompanyId(ids);

        return leaseStorehouseList;
    }

    public List<LeaseStorehouse> findByName(Map params) {

        List<LeaseStorehouse> leaseStorehouseList=leaseStorehouseMapper.findByName(params);

        return leaseStorehouseList;
    }

    public List<LeaseStorehouse> findByBelongIdAndBelongType(Map<String, Object> params) {
        List<LeaseStorehouse> leaseStorehouseList =leaseStorehouseMapper.findByBelongIdAndBelongType(params);
        return leaseStorehouseList;
    }

    public int disableByPrimaryKey(Map<String, Object> params) {
        int row = leaseStorehouseMapper.disableByPrimaryKey(params);
        return row;
    }

    public void updateSort(LeaseStorehouse leaseStorehouse) {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id",leaseStorehouse.getId());
        paramsMap.put("mark",leaseStorehouse.getMark());
        leaseStorehouseMapper.updateSort(paramsMap);
    }

    public int updateDefaultSelected(Map<String, Object> paramsMap) {
        int row = leaseStorehouseMapper.updateDefaultSelected(paramsMap);
        return row;
    }

    public List<LeaseStorehouse> findAllNoPage(Map param) {
        List<LeaseStorehouse> leaseStorehouseList= leaseStorehouseMapper.findPage(param);
        return leaseStorehouseList;
    }
}
