package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.api.LeaseSchemePriceRentService;
import com.hc.lease.supplier.model.LeaseSchemePriceRent;
import com.hc.lease.supplier.dao.LeaseSchemePriceRentMapper;

import java.util.List;
import java.util.Map;

/**
 * 方案报价-纯租ServiceImpl
 * @author Qiang
 * @version 2018-08-09
 */
@Service("leaseSchemePriceRentService")
public class LeaseSchemePriceRentServiceImpl implements LeaseSchemePriceRentService {

	@Autowired
	private LeaseSchemePriceRentMapper leaseSchemePriceRentMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemePriceRentMapper.deleteByPrimaryKey(id);
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
        int row = leaseSchemePriceRentMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseSchemePriceRent insert(LeaseSchemePriceRent leaseSchemePriceRent) throws GMException {
        leaseSchemePriceRent.setCreateTime(DateTime.now().toDate());
        leaseSchemePriceRent.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePriceRentMapper.insert(leaseSchemePriceRent);
        return leaseSchemePriceRent;
    }

    public LeaseSchemePriceRent insertSelective(LeaseSchemePriceRent leaseSchemePriceRent) throws GMException {
        leaseSchemePriceRent.setCreateTime(DateTime.now().toDate());
        leaseSchemePriceRent.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePriceRentMapper.insertSelective(leaseSchemePriceRent);
        return leaseSchemePriceRent;
    }

    public int insertList(List<LeaseSchemePriceRent> list) throws GMException {
        int row = leaseSchemePriceRentMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseSchemePriceRent leaseSchemePriceRent) throws GMException {
        leaseSchemePriceRent.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePriceRentMapper.updateByPrimaryKeySelective(leaseSchemePriceRent);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemePriceRent leaseSchemePriceRent) throws GMException {
        leaseSchemePriceRent.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePriceRentMapper.updateByPrimaryKey(leaseSchemePriceRent);
        return row;
    }

    public LeaseSchemePriceRent selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemePriceRent leaseSchemePriceRent = leaseSchemePriceRentMapper.selectByPrimaryKey(id);
        return leaseSchemePriceRent;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseSchemePriceRent> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseSchemePriceRent> leaseSchemePriceRentList = leaseSchemePriceRentMapper.findPage(paramsMap);
        PageInfo<LeaseSchemePriceRent> page = new PageInfo<LeaseSchemePriceRent>(leaseSchemePriceRentList);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <LeaseSchemePriceRent> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemePriceRent> leaseSchemePriceRentList = leaseSchemePriceRentMapper.findAll(paramsMap);
        return leaseSchemePriceRentList;
    }

    public void deleteBySchemePriceId(Long id) {
        leaseSchemePriceRentMapper.deleteBySchemePriceId(id);
    }
}
