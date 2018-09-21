package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.api.LeaseSchemePriceService;
import com.hc.lease.supplier.model.LeaseSchemePrice;
import com.hc.lease.supplier.dao.LeaseSchemePriceMapper;

import java.util.List;
import java.util.Map;

/**
 * 方案报价ServiceImpl
 * @author Qiang
 * @version 2018-07-27
 */
@Service("leaseSchemePriceService")
public class LeaseSchemePriceServiceImpl implements LeaseSchemePriceService {

	@Autowired
	private LeaseSchemePriceMapper leaseSchemePriceMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemePriceMapper.deleteByPrimaryKey(id);
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
        int row = leaseSchemePriceMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseSchemePrice insert(LeaseSchemePrice leaseSchemePrice) throws GMException {
        leaseSchemePrice.setCreateTime(DateTime.now().toDate());
        leaseSchemePrice.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePriceMapper.insert(leaseSchemePrice);
        return leaseSchemePrice;
    }

    public LeaseSchemePrice insertSelective(LeaseSchemePrice leaseSchemePrice) throws GMException {
        leaseSchemePrice.setCreateTime(DateTime.now().toDate());
        leaseSchemePrice.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePriceMapper.insertSelective(leaseSchemePrice);
        return leaseSchemePrice;
    }

    public int insertList(List<LeaseSchemePrice> list) throws GMException {
        int row = leaseSchemePriceMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseSchemePrice leaseSchemePrice) throws GMException {
        leaseSchemePrice.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePriceMapper.updateByPrimaryKeySelective(leaseSchemePrice);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemePrice leaseSchemePrice) throws GMException {
        leaseSchemePrice.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePriceMapper.updateByPrimaryKey(leaseSchemePrice);
        return row;
    }

    public LeaseSchemePrice selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemePrice leaseSchemePrice = leaseSchemePriceMapper.selectByPrimaryKey(id);
        return leaseSchemePrice;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseSchemePrice> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseSchemePrice> leaseSchemePriceList = leaseSchemePriceMapper.findPage(paramsMap);
        PageInfo<LeaseSchemePrice> page = new PageInfo<LeaseSchemePrice>(leaseSchemePriceList);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <LeaseSchemePrice> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemePrice> leaseSchemePriceList = leaseSchemePriceMapper.findAll(paramsMap);
        return leaseSchemePriceList;
    }

}
