package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.api.LeaseSchemePriceAnnualService;
import com.hc.lease.supplier.model.LeaseSchemePriceAnnual;
import com.hc.lease.supplier.dao.LeaseSchemePriceAnnualMapper;

import java.util.List;
import java.util.Map;

/**
 * 方案报价-年度尾款ServiceImpl
 * @author Qiang
 * @version 2018-07-27
 */
@Service("leaseSchemePriceAnnualService")
public class LeaseSchemePriceAnnualServiceImpl implements LeaseSchemePriceAnnualService {

	@Autowired
	private LeaseSchemePriceAnnualMapper leaseSchemePriceAnnualMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemePriceAnnualMapper.deleteByPrimaryKey(id);
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
        int row = leaseSchemePriceAnnualMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseSchemePriceAnnual insert(LeaseSchemePriceAnnual leaseSchemePriceAnnual) throws GMException {
        leaseSchemePriceAnnual.setCreateTime(DateTime.now().toDate());
        leaseSchemePriceAnnual.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePriceAnnualMapper.insert(leaseSchemePriceAnnual);
        return leaseSchemePriceAnnual;
    }

    public LeaseSchemePriceAnnual insertSelective(LeaseSchemePriceAnnual leaseSchemePriceAnnual) throws GMException {
        leaseSchemePriceAnnual.setCreateTime(DateTime.now().toDate());
        leaseSchemePriceAnnual.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePriceAnnualMapper.insertSelective(leaseSchemePriceAnnual);
        return leaseSchemePriceAnnual;
    }

    public int insertList(List<LeaseSchemePriceAnnual> list) throws GMException {
        int row = leaseSchemePriceAnnualMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseSchemePriceAnnual leaseSchemePriceAnnual) throws GMException {
        leaseSchemePriceAnnual.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePriceAnnualMapper.updateByPrimaryKeySelective(leaseSchemePriceAnnual);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemePriceAnnual leaseSchemePriceAnnual) throws GMException {
        leaseSchemePriceAnnual.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePriceAnnualMapper.updateByPrimaryKey(leaseSchemePriceAnnual);
        return row;
    }

    public LeaseSchemePriceAnnual selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemePriceAnnual leaseSchemePriceAnnual = leaseSchemePriceAnnualMapper.selectByPrimaryKey(id);
        return leaseSchemePriceAnnual;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseSchemePriceAnnual> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseSchemePriceAnnual> leaseSchemePriceAnnualList = leaseSchemePriceAnnualMapper.findPage(paramsMap);
        PageInfo<LeaseSchemePriceAnnual> page = new PageInfo<LeaseSchemePriceAnnual>(leaseSchemePriceAnnualList);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <LeaseSchemePriceAnnual> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemePriceAnnual> leaseSchemePriceAnnualList = leaseSchemePriceAnnualMapper.findAll(paramsMap);
        return leaseSchemePriceAnnualList;
    }

    public void deleteBySchemePriceId(Long id) {

        leaseSchemePriceAnnualMapper.deleteBySchemePriceId(id);
    }
}
