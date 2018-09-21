package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.order.service.api.LeaseContractRepaymentExceptService;
import com.hc.lease.order.model.LeaseContractRepaymentExcept;
import com.hc.lease.order.dao.LeaseContractRepaymentExceptMapper;

import java.util.List;
import java.util.Map;

/**
 * 融租合同 不用系统处理扣款的月租,录入的合同数据如果是不需要系统处理租金扣款，则记录，因为有些合同数据是线下处理了收款ServiceImpl
 * @author Tong
 * @version 2017-09-01
 */
@Service("leaseContractRepaymentExceptService")
public class LeaseContractRepaymentExceptServiceImpl implements LeaseContractRepaymentExceptService {

	@Autowired
	private LeaseContractRepaymentExceptMapper leaseContractRepaymentExceptMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractRepaymentExceptMapper.deleteByPrimaryKey(id);
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
        int row = leaseContractRepaymentExceptMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseContractRepaymentExcept insert(LeaseContractRepaymentExcept leaseContractRepaymentExcept) throws GMException {
        leaseContractRepaymentExcept.setCreateTime(DateTime.now().toDate());
        leaseContractRepaymentExcept.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractRepaymentExceptMapper.insert(leaseContractRepaymentExcept);
        return leaseContractRepaymentExcept;
    }

    public LeaseContractRepaymentExcept insertSelective(LeaseContractRepaymentExcept leaseContractRepaymentExcept) throws GMException {
        leaseContractRepaymentExcept.setCreateTime(DateTime.now().toDate());
        leaseContractRepaymentExcept.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractRepaymentExceptMapper.insertSelective(leaseContractRepaymentExcept);
        return leaseContractRepaymentExcept;
    }

    public int insertList(List<LeaseContractRepaymentExcept> list) throws GMException {
        int row = leaseContractRepaymentExceptMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseContractRepaymentExcept leaseContractRepaymentExcept) throws GMException {
        leaseContractRepaymentExcept.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractRepaymentExceptMapper.updateByPrimaryKeySelective(leaseContractRepaymentExcept);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractRepaymentExcept leaseContractRepaymentExcept) throws GMException {
        leaseContractRepaymentExcept.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractRepaymentExceptMapper.updateByPrimaryKey(leaseContractRepaymentExcept);
        return row;
    }

    public LeaseContractRepaymentExcept selectByPrimaryKey(Long id) throws GMException {
        LeaseContractRepaymentExcept leaseContractRepaymentExcept = leaseContractRepaymentExceptMapper.selectByPrimaryKey(id);
        return leaseContractRepaymentExcept;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseContractRepaymentExcept> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseContractRepaymentExcept> leaseContractRepaymentExceptList = leaseContractRepaymentExceptMapper.findPage(paramsMap);
        PageInfo<LeaseContractRepaymentExcept> page = new PageInfo<LeaseContractRepaymentExcept>(leaseContractRepaymentExceptList);
        return page;
    }

    public List <LeaseContractRepaymentExcept> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractRepaymentExcept> leaseContractRepaymentExceptList = leaseContractRepaymentExceptMapper.findAll(paramsMap);
        return leaseContractRepaymentExceptList;
    }

}
