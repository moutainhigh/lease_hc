package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.order.service.api.LeaseContractIncomeExpeService;
import com.hc.lease.order.model.LeaseContractIncomeExpe;
import com.hc.lease.order.dao.LeaseContractIncomeExpeMapper;

import java.util.List;
import java.util.Map;

/**
 * 贷后车辆管理-收入和支出ServiceImpl
 * @author Tong
 * @version 2018-08-03
 */
@Service("leaseContractIncomeExpeService")
public class LeaseContractIncomeExpeServiceImpl implements LeaseContractIncomeExpeService {

	@Autowired
	private LeaseContractIncomeExpeMapper leaseContractIncomeExpeMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractIncomeExpeMapper.deleteByPrimaryKey(id);
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
        int row = leaseContractIncomeExpeMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseContractIncomeExpe insert(LeaseContractIncomeExpe leaseContractIncomeExpe) throws GMException {
        leaseContractIncomeExpe.setCreateTime(DateTime.now().toDate());
        leaseContractIncomeExpe.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractIncomeExpeMapper.insert(leaseContractIncomeExpe);
        return leaseContractIncomeExpe;
    }

    public LeaseContractIncomeExpe insertSelective(LeaseContractIncomeExpe leaseContractIncomeExpe) throws GMException {
        leaseContractIncomeExpe.setCreateTime(DateTime.now().toDate());
        leaseContractIncomeExpe.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractIncomeExpeMapper.insertSelective(leaseContractIncomeExpe);
        return leaseContractIncomeExpe;
    }

    public int insertList(List<LeaseContractIncomeExpe> list) throws GMException {
        int row = leaseContractIncomeExpeMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseContractIncomeExpe leaseContractIncomeExpe) throws GMException {
        leaseContractIncomeExpe.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractIncomeExpeMapper.updateByPrimaryKeySelective(leaseContractIncomeExpe);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractIncomeExpe leaseContractIncomeExpe) throws GMException {
        leaseContractIncomeExpe.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractIncomeExpeMapper.updateByPrimaryKey(leaseContractIncomeExpe);
        return row;
    }

    public LeaseContractIncomeExpe selectByPrimaryKey(Long id) throws GMException {
        LeaseContractIncomeExpe leaseContractIncomeExpe = leaseContractIncomeExpeMapper.selectByPrimaryKey(id);
        return leaseContractIncomeExpe;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseContractIncomeExpe> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseContractIncomeExpe> leaseContractIncomeExpeList = leaseContractIncomeExpeMapper.findPage(paramsMap);
        PageInfo<LeaseContractIncomeExpe> page = new PageInfo<LeaseContractIncomeExpe>(leaseContractIncomeExpeList);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <LeaseContractIncomeExpe> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractIncomeExpe> leaseContractIncomeExpeList = leaseContractIncomeExpeMapper.findAll(paramsMap);
        return leaseContractIncomeExpeList;
    }

    @Override
    public int deleteByContractId(Map<String, Object> paramsMap) throws GMException {
        int row = leaseContractIncomeExpeMapper.deleteByContractId(paramsMap);
        return row;
    }

    @Override
    public List<LeaseContractIncomeExpe> findByContractIdAndSource(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractIncomeExpe> leaseContractIncomeExpeList = leaseContractIncomeExpeMapper.findByContractIdAndSource(paramsMap);
        return leaseContractIncomeExpeList;
    }
}
