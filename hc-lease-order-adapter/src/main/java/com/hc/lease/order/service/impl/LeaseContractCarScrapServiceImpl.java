package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.order.service.api.LeaseContractCarScrapService;
import com.hc.lease.order.model.LeaseContractCarScrap;
import com.hc.lease.order.dao.LeaseContractCarScrapMapper;

import java.util.List;
import java.util.Map;

/**
 * 贷后车辆管理-报废ServiceImpl
 * @author Tong
 * @version 2018-08-03
 */
@Service("leaseContractCarScrapService")
public class LeaseContractCarScrapServiceImpl implements LeaseContractCarScrapService {

	@Autowired
	private LeaseContractCarScrapMapper leaseContractCarScrapMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractCarScrapMapper.deleteByPrimaryKey(id);
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
        int row = leaseContractCarScrapMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseContractCarScrap insert(LeaseContractCarScrap leaseContractCarScrap) throws GMException {
        leaseContractCarScrap.setCreateTime(DateTime.now().toDate());
        leaseContractCarScrap.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractCarScrapMapper.insert(leaseContractCarScrap);
        return leaseContractCarScrap;
    }

    public LeaseContractCarScrap insertSelective(LeaseContractCarScrap leaseContractCarScrap) throws GMException {
        leaseContractCarScrap.setCreateTime(DateTime.now().toDate());
        leaseContractCarScrap.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractCarScrapMapper.insertSelective(leaseContractCarScrap);
        return leaseContractCarScrap;
    }

    public int insertList(List<LeaseContractCarScrap> list) throws GMException {
        int row = leaseContractCarScrapMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseContractCarScrap leaseContractCarScrap) throws GMException {
        leaseContractCarScrap.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractCarScrapMapper.updateByPrimaryKeySelective(leaseContractCarScrap);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractCarScrap leaseContractCarScrap) throws GMException {
        leaseContractCarScrap.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractCarScrapMapper.updateByPrimaryKey(leaseContractCarScrap);
        return row;
    }

    public LeaseContractCarScrap selectByPrimaryKey(Long id) throws GMException {
        LeaseContractCarScrap leaseContractCarScrap = leaseContractCarScrapMapper.selectByPrimaryKey(id);
        return leaseContractCarScrap;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseContractCarScrap> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseContractCarScrap> leaseContractCarScrapList = leaseContractCarScrapMapper.findPage(paramsMap);
        PageInfo<LeaseContractCarScrap> page = new PageInfo<LeaseContractCarScrap>(leaseContractCarScrapList);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <LeaseContractCarScrap> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractCarScrap> leaseContractCarScrapList = leaseContractCarScrapMapper.findAll(paramsMap);
        return leaseContractCarScrapList;
    }

    @Override
    public int findMaxDualNumber(Map<String, Object> paramsMap) throws GMException {
        int dualNumber = leaseContractCarScrapMapper.findMaxDualNumber(paramsMap);
        return dualNumber;
    }
}
