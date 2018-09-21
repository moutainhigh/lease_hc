package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.adapter.api.LeaseSchemePriceAnnualAdapter;
import com.hc.lease.supplier.service.api.LeaseSchemePriceAnnualService;
import com.hc.lease.supplier.model.LeaseSchemePriceAnnual;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 方案报价-年度尾款AdapterImpl
 * @author Qiang
 * @version 2018-07-27
 */
@Service("leaseSchemePriceAnnualAdapter")
public class LeaseSchemePriceAnnualAdapterImpl implements LeaseSchemePriceAnnualAdapter {

	@Autowired
	private LeaseSchemePriceAnnualService leaseSchemePriceAnnualService;

    /**
    * 添加或者修改 需要的初始化参数
    *
    * @param paramsMap
    * @return
    */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    /**
    * 根据ID删除记录
    *
    * @param id .
    * @return
    * @throws GMException
    */
    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemePriceAnnualService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseSchemePriceAnnualService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseSchemePriceAnnual record) throws GMException {
        record = leaseSchemePriceAnnualService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseSchemePriceAnnual record) throws GMException {
        record = leaseSchemePriceAnnualService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseSchemePriceAnnual record) throws GMException {
        int row = leaseSchemePriceAnnualService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemePriceAnnual record) throws GMException {
        int row = leaseSchemePriceAnnualService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseSchemePriceAnnual selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemePriceAnnual leaseSchemePriceAnnual = leaseSchemePriceAnnualService.selectByPrimaryKey(id);
        return leaseSchemePriceAnnual;
    }

    public int insertList(List<LeaseSchemePriceAnnual> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseSchemePriceAnnual> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseSchemePriceAnnual> page = leaseSchemePriceAnnualService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List<LeaseSchemePriceAnnual> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemePriceAnnual> leaseSchemePriceAnnualList = leaseSchemePriceAnnualService.findAll(paramsMap);
        return leaseSchemePriceAnnualList;
    }

}
