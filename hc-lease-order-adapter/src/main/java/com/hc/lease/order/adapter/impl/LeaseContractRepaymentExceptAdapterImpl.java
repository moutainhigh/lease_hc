package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.order.adapter.api.LeaseContractRepaymentExceptAdapter;
import com.hc.lease.order.service.api.LeaseContractRepaymentExceptService;
import com.hc.lease.order.model.LeaseContractRepaymentExcept;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 融租合同 不用系统处理扣款的月租,录入的合同数据如果是不需要系统处理租金扣款，则记录，因为有些合同数据是线下处理了收款AdapterImpl
 * @author Tong
 * @version 2017-09-01
 */
@Service("leaseContractRepaymentExceptAdapter")
public class LeaseContractRepaymentExceptAdapterImpl implements LeaseContractRepaymentExceptAdapter {

	@Autowired
	private LeaseContractRepaymentExceptService leaseContractRepaymentExceptService;

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
        int row = leaseContractRepaymentExceptService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseContractRepaymentExceptService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseContractRepaymentExcept record) throws GMException {
        record = leaseContractRepaymentExceptService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseContractRepaymentExcept record) throws GMException {
        record = leaseContractRepaymentExceptService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseContractRepaymentExcept record) throws GMException {
        int row = leaseContractRepaymentExceptService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractRepaymentExcept record) throws GMException {
        int row = leaseContractRepaymentExceptService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseContractRepaymentExcept selectByPrimaryKey(Long id) throws GMException {
        LeaseContractRepaymentExcept leaseContractRepaymentExcept = leaseContractRepaymentExceptService.selectByPrimaryKey(id);
        return leaseContractRepaymentExcept;
    }

    public int insertList(List<LeaseContractRepaymentExcept> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseContractRepaymentExcept> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseContractRepaymentExcept> page = leaseContractRepaymentExceptService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseContractRepaymentExcept> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractRepaymentExcept> leaseContractRepaymentExceptList = leaseContractRepaymentExceptService.findAll(paramsMap);
        return leaseContractRepaymentExceptList;
    }

}
