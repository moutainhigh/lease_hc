package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.adapter.api.LeaseSchemePriceRentAdapter;
import com.hc.lease.supplier.service.api.LeaseSchemePriceRentService;
import com.hc.lease.supplier.model.LeaseSchemePriceRent;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 方案报价-纯租AdapterImpl
 * @author Qiang
 * @version 2018-08-09
 */
@Service("leaseSchemePriceRentAdapter")
public class LeaseSchemePriceRentAdapterImpl implements LeaseSchemePriceRentAdapter {

	@Autowired
	private LeaseSchemePriceRentService leaseSchemePriceRentService;

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
        int row = leaseSchemePriceRentService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseSchemePriceRentService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseSchemePriceRent record) throws GMException {
        record = leaseSchemePriceRentService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseSchemePriceRent record) throws GMException {
        record = leaseSchemePriceRentService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseSchemePriceRent record) throws GMException {
        int row = leaseSchemePriceRentService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemePriceRent record) throws GMException {
        int row = leaseSchemePriceRentService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseSchemePriceRent selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemePriceRent leaseSchemePriceRent = leaseSchemePriceRentService.selectByPrimaryKey(id);
        return leaseSchemePriceRent;
    }

    public int insertList(List<LeaseSchemePriceRent> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseSchemePriceRent> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseSchemePriceRent> page = leaseSchemePriceRentService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List<LeaseSchemePriceRent> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemePriceRent> leaseSchemePriceRentList = leaseSchemePriceRentService.findAll(paramsMap);
        return leaseSchemePriceRentList;
    }

}
