package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.order.adapter.api.LeaseUpdateMonthlyrentAdapter;
import com.hc.lease.order.service.api.LeaseUpdateMonthlyrentService;
import com.hc.lease.order.model.LeaseUpdateMonthlyrent;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 融租合同修改租金备份AdapterImpl
 * @author Tong
 * @version 2017-12-28
 */
@Service("leaseUpdateMonthlyrentAdapter")
public class LeaseUpdateMonthlyrentAdapterImpl implements LeaseUpdateMonthlyrentAdapter {

	@Autowired
	private LeaseUpdateMonthlyrentService leaseUpdateMonthlyrentService;

    /**
    * 添加或者修改 需要的初始化参数
    *
    * @param paramsMap
    * @return
    */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseUpdateMonthlyrentService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseUpdateMonthlyrentService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseUpdateMonthlyrent record) throws GMException {
        record = leaseUpdateMonthlyrentService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseUpdateMonthlyrent record) throws GMException {
        record = leaseUpdateMonthlyrentService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseUpdateMonthlyrent record) throws GMException {
        int row = leaseUpdateMonthlyrentService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseUpdateMonthlyrent record) throws GMException {
        int row = leaseUpdateMonthlyrentService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseUpdateMonthlyrent selectByPrimaryKey(Long id) throws GMException {
        LeaseUpdateMonthlyrent leaseUpdateMonthlyrent = leaseUpdateMonthlyrentService.selectByPrimaryKey(id);
        return leaseUpdateMonthlyrent;
    }

    public int insertList(List<LeaseUpdateMonthlyrent> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseUpdateMonthlyrent> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseUpdateMonthlyrent> page = leaseUpdateMonthlyrentService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseUpdateMonthlyrent> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseUpdateMonthlyrent> leaseUpdateMonthlyrentList = leaseUpdateMonthlyrentService.findAll(paramsMap);
        return leaseUpdateMonthlyrentList;
    }

}
