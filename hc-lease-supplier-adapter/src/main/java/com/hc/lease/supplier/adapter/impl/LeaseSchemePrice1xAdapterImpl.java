package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.adapter.api.LeaseSchemePrice1xAdapter;
import com.hc.lease.supplier.service.api.LeaseSchemePrice1xService;
import com.hc.lease.supplier.model.LeaseSchemePrice1x;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 方案报价-1+xAdapterImpl
 * @author Qiang
 * @version 2018-07-27
 */
@Service("leaseSchemePrice1xAdapter")
public class LeaseSchemePrice1xAdapterImpl implements LeaseSchemePrice1xAdapter {

	@Autowired
	private LeaseSchemePrice1xService leaseSchemePrice1xService;

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
        int row = leaseSchemePrice1xService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseSchemePrice1xService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseSchemePrice1x record) throws GMException {
        record = leaseSchemePrice1xService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseSchemePrice1x record) throws GMException {
        record = leaseSchemePrice1xService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseSchemePrice1x record) throws GMException {
        int row = leaseSchemePrice1xService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemePrice1x record) throws GMException {
        int row = leaseSchemePrice1xService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseSchemePrice1x selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemePrice1x leaseSchemePrice1x = leaseSchemePrice1xService.selectByPrimaryKey(id);
        return leaseSchemePrice1x;
    }

    public int insertList(List<LeaseSchemePrice1x> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseSchemePrice1x> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseSchemePrice1x> page = leaseSchemePrice1xService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List<LeaseSchemePrice1x> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemePrice1x> leaseSchemePrice1xList = leaseSchemePrice1xService.findAll(paramsMap);
        return leaseSchemePrice1xList;
    }

}
