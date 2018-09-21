package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.api.LeasePackageBalancePaymentService;
import com.hc.lease.supplier.model.LeasePackageBalancePayment;
import com.hc.lease.supplier.dao.LeasePackageBalancePaymentMapper;

import java.util.List;
import java.util.Map;

/**
 * 融租方案-尾款ServiceImpl
 * @author Qiang
 * @version 2017-11-02
 */
@Service("leasePackageBalancePaymentService")
public class LeasePackageBalancePaymentServiceImpl implements LeasePackageBalancePaymentService {

	@Autowired
	private LeasePackageBalancePaymentMapper leasePackageBalancePaymentMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leasePackageBalancePaymentMapper.deleteByPrimaryKey(id);
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
        int row = leasePackageBalancePaymentMapper.deleteBatchById(ids);
        return row;
    }

    public LeasePackageBalancePayment insert(LeasePackageBalancePayment leasePackageBalancePayment) throws GMException {
        leasePackageBalancePayment.setCreateTime(DateTime.now().toDate());
        leasePackageBalancePayment.setUpdateTime(DateTime.now().toDate());
        int row = leasePackageBalancePaymentMapper.insert(leasePackageBalancePayment);
        return leasePackageBalancePayment;
    }

    public LeasePackageBalancePayment insertSelective(LeasePackageBalancePayment leasePackageBalancePayment) throws GMException {
        leasePackageBalancePayment.setCreateTime(DateTime.now().toDate());
        leasePackageBalancePayment.setUpdateTime(DateTime.now().toDate());
        int row = leasePackageBalancePaymentMapper.insertSelective(leasePackageBalancePayment);
        return leasePackageBalancePayment;
    }

    public int insertList(List<LeasePackageBalancePayment> list) throws GMException {
        int row = leasePackageBalancePaymentMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeasePackageBalancePayment leasePackageBalancePayment) throws GMException {
        leasePackageBalancePayment.setUpdateTime(DateTime.now().toDate());
        int row = leasePackageBalancePaymentMapper.updateByPrimaryKeySelective(leasePackageBalancePayment);
        return row;
    }

    public int updateByPrimaryKey(LeasePackageBalancePayment leasePackageBalancePayment) throws GMException {
        leasePackageBalancePayment.setUpdateTime(DateTime.now().toDate());
        int row = leasePackageBalancePaymentMapper.updateByPrimaryKey(leasePackageBalancePayment);
        return row;
    }

    public LeasePackageBalancePayment selectByPrimaryKey(Long id) throws GMException {
        LeasePackageBalancePayment leasePackageBalancePayment = leasePackageBalancePaymentMapper.selectByPrimaryKey(id);
        return leasePackageBalancePayment;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeasePackageBalancePayment> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeasePackageBalancePayment> leasePackageBalancePaymentList = leasePackageBalancePaymentMapper.findPage(paramsMap);
        PageInfo<LeasePackageBalancePayment> page = new PageInfo<LeasePackageBalancePayment>(leasePackageBalancePaymentList);
        return page;
    }

    public List <LeasePackageBalancePayment> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeasePackageBalancePayment> leasePackageBalancePaymentList = leasePackageBalancePaymentMapper.findAll(paramsMap);
        return leasePackageBalancePaymentList;
    }

    public void deleteByPackageId(Long packageId) throws GMException  {
        leasePackageBalancePaymentMapper.deleteByPackageId(packageId);
    }

    public LeasePackageBalancePayment selectBySchemeId(Long schemeId) throws GMException {
        LeasePackageBalancePayment leasePackageBalancePayment=leasePackageBalancePaymentMapper.selectBySchemeId(schemeId);
        return leasePackageBalancePayment;
    }

    public List<LeasePackageBalancePayment> findBySchemeId(Long schemeId) throws GMException {
        List<LeasePackageBalancePayment> leasePackageBalancePayment=leasePackageBalancePaymentMapper.findBySchemeId(schemeId);
        return leasePackageBalancePayment;
    }

}
