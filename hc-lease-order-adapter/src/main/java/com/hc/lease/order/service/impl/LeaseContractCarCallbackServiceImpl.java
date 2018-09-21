package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.vo.FindByPrimaryKeyVo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.order.service.api.LeaseContractCarCallbackService;
import com.hc.lease.order.model.LeaseContractCarCallback;
import com.hc.lease.order.dao.LeaseContractCarCallbackMapper;

import java.util.List;
import java.util.Map;

/**
 * 贷后车辆管理-收车ServiceImpl
 * @author Tong
 * @version 2018-08-03
 */
@Service("leaseContractCarCallbackService")
public class LeaseContractCarCallbackServiceImpl implements LeaseContractCarCallbackService {

	@Autowired
	private LeaseContractCarCallbackMapper leaseContractCarCallbackMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractCarCallbackMapper.deleteByPrimaryKey(id);
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
        int row = leaseContractCarCallbackMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseContractCarCallback insert(LeaseContractCarCallback leaseContractCarCallback) throws GMException {
        leaseContractCarCallback.setCreateTime(DateTime.now().toDate());
        leaseContractCarCallback.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractCarCallbackMapper.insert(leaseContractCarCallback);
        return leaseContractCarCallback;
    }

    public LeaseContractCarCallback insertSelective(LeaseContractCarCallback leaseContractCarCallback) throws GMException {
        leaseContractCarCallback.setCreateTime(DateTime.now().toDate());
        leaseContractCarCallback.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractCarCallbackMapper.insertSelective(leaseContractCarCallback);
        return leaseContractCarCallback;
    }

    public int insertList(List<LeaseContractCarCallback> list) throws GMException {
        int row = leaseContractCarCallbackMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseContractCarCallback leaseContractCarCallback) throws GMException {
        leaseContractCarCallback.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractCarCallbackMapper.updateByPrimaryKeySelective(leaseContractCarCallback);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractCarCallback leaseContractCarCallback) throws GMException {
        leaseContractCarCallback.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractCarCallbackMapper.updateByPrimaryKey(leaseContractCarCallback);
        return row;
    }

    public LeaseContractCarCallback selectByPrimaryKey(Long id) throws GMException {
        LeaseContractCarCallback leaseContractCarCallback = leaseContractCarCallbackMapper.selectByPrimaryKey(id);
        return leaseContractCarCallback;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseContractCarCallback> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseContractCarCallback> leaseContractCarCallbackList = leaseContractCarCallbackMapper.findPage(paramsMap);
        PageInfo<LeaseContractCarCallback> page = new PageInfo<LeaseContractCarCallback>(leaseContractCarCallbackList);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <LeaseContractCarCallback> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractCarCallback> leaseContractCarCallbackList = leaseContractCarCallbackMapper.findAll(paramsMap);
        return leaseContractCarCallbackList;
    }

    @Override
    public FindByPrimaryKeyVo findByPrimaryKey(Long id) {
        FindByPrimaryKeyVo findByPrimaryKeyVo = leaseContractCarCallbackMapper.findByPrimaryKey(id);
        return findByPrimaryKeyVo;
    }

    @Override
    public int findMaxDualNumber(Map<String, Object> paramsMap) throws GMException {
        int dealNumber = leaseContractCarCallbackMapper.findMaxDualNumber(paramsMap);
        return dealNumber;
    }
}
