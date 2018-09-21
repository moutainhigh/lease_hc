package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.adapter.api.LeasePackageBalancePaymentAdapter;
import com.hc.lease.supplier.service.api.LeasePackageBalancePaymentService;
import com.hc.lease.supplier.model.LeasePackageBalancePayment;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 融租方案-尾款AdapterImpl
 * @author Qiang
 * @version 2017-11-02
 */
@Service("leasePackageBalancePaymentAdapter")
public class LeasePackageBalancePaymentAdapterImpl implements LeasePackageBalancePaymentAdapter {

	@Autowired
	private LeasePackageBalancePaymentService leasePackageBalancePaymentService;

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
        int row = leasePackageBalancePaymentService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leasePackageBalancePaymentService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeasePackageBalancePayment record) throws GMException {
        record = leasePackageBalancePaymentService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeasePackageBalancePayment record) throws GMException {
        record = leasePackageBalancePaymentService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeasePackageBalancePayment record) throws GMException {
        int row = leasePackageBalancePaymentService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeasePackageBalancePayment record) throws GMException {
        int row = leasePackageBalancePaymentService.updateByPrimaryKey(record);
        return row;
    }

    public LeasePackageBalancePayment selectByPrimaryKey(Long id) throws GMException {
        LeasePackageBalancePayment leasePackageBalancePayment = leasePackageBalancePaymentService.selectByPrimaryKey(id);
        return leasePackageBalancePayment;
    }

    public int insertList(List<LeasePackageBalancePayment> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeasePackageBalancePayment> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeasePackageBalancePayment> page = leasePackageBalancePaymentService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeasePackageBalancePayment> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeasePackageBalancePayment> leasePackageBalancePaymentList = leasePackageBalancePaymentService.findAll(paramsMap);
        return leasePackageBalancePaymentList;
    }

}
