package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.order.service.api.LeaseContractCarLoseService;
import com.hc.lease.order.model.LeaseContractCarLose;
import com.hc.lease.order.dao.LeaseContractCarLoseMapper;

import java.util.List;
import java.util.Map;

/**
 * 贷后车辆管理-丢失ServiceImpl
 * @author Tong
 * @version 2018-08-03
 */
@Service("leaseContractCarLoseService")
public class LeaseContractCarLoseServiceImpl implements LeaseContractCarLoseService {

	@Autowired
	private LeaseContractCarLoseMapper leaseContractCarLoseMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractCarLoseMapper.deleteByPrimaryKey(id);
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
        int row = leaseContractCarLoseMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseContractCarLose insert(LeaseContractCarLose leaseContractCarLose) throws GMException {
        leaseContractCarLose.setCreateTime(DateTime.now().toDate());
        leaseContractCarLose.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractCarLoseMapper.insert(leaseContractCarLose);
        return leaseContractCarLose;
    }

    public LeaseContractCarLose insertSelective(LeaseContractCarLose leaseContractCarLose) throws GMException {
        leaseContractCarLose.setCreateTime(DateTime.now().toDate());
        leaseContractCarLose.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractCarLoseMapper.insertSelective(leaseContractCarLose);
        return leaseContractCarLose;
    }

    public int insertList(List<LeaseContractCarLose> list) throws GMException {
        int row = leaseContractCarLoseMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseContractCarLose leaseContractCarLose) throws GMException {
        leaseContractCarLose.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractCarLoseMapper.updateByPrimaryKeySelective(leaseContractCarLose);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractCarLose leaseContractCarLose) throws GMException {
        leaseContractCarLose.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractCarLoseMapper.updateByPrimaryKey(leaseContractCarLose);
        return row;
    }

    public LeaseContractCarLose selectByPrimaryKey(Long id) throws GMException {
        LeaseContractCarLose leaseContractCarLose = leaseContractCarLoseMapper.selectByPrimaryKey(id);
        return leaseContractCarLose;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseContractCarLose> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseContractCarLose> leaseContractCarLoseList = leaseContractCarLoseMapper.findPage(paramsMap);
        PageInfo<LeaseContractCarLose> page = new PageInfo<LeaseContractCarLose>(leaseContractCarLoseList);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <LeaseContractCarLose> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractCarLose> leaseContractCarLoseList = leaseContractCarLoseMapper.findAll(paramsMap);
        return leaseContractCarLoseList;
    }

    @Override
    public int findMaxDualNumber(Map<String, Object> paramsMap) throws GMException {
        int dualNumber = leaseContractCarLoseMapper.findMaxDualNumber(paramsMap);
        return dualNumber;
    }
}
