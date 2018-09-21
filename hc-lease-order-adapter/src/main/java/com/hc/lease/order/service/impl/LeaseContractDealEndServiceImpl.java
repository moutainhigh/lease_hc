package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.order.service.api.LeaseContractDealEndService;
import com.hc.lease.order.model.LeaseContractDealEnd;
import com.hc.lease.order.dao.LeaseContractDealEndMapper;

import java.util.List;
import java.util.Map;

/**
 * 贷后合同管理-结束处置ServiceImpl
 * @author Tong
 * @version 2018-08-03
 */
@Service("leaseContractDealEndService")
public class LeaseContractDealEndServiceImpl implements LeaseContractDealEndService {

	@Autowired
	private LeaseContractDealEndMapper leaseContractDealEndMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractDealEndMapper.deleteByPrimaryKey(id);
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
        int row = leaseContractDealEndMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseContractDealEnd insert(LeaseContractDealEnd leaseContractDealEnd) throws GMException {
        leaseContractDealEnd.setCreateTime(DateTime.now().toDate());
        leaseContractDealEnd.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractDealEndMapper.insert(leaseContractDealEnd);
        return leaseContractDealEnd;
    }

    public LeaseContractDealEnd insertSelective(LeaseContractDealEnd leaseContractDealEnd) throws GMException {
        leaseContractDealEnd.setCreateTime(DateTime.now().toDate());
        leaseContractDealEnd.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractDealEndMapper.insertSelective(leaseContractDealEnd);
        return leaseContractDealEnd;
    }

    public int insertList(List<LeaseContractDealEnd> list) throws GMException {
        int row = leaseContractDealEndMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseContractDealEnd leaseContractDealEnd) throws GMException {
        leaseContractDealEnd.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractDealEndMapper.updateByPrimaryKeySelective(leaseContractDealEnd);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractDealEnd leaseContractDealEnd) throws GMException {
        leaseContractDealEnd.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractDealEndMapper.updateByPrimaryKey(leaseContractDealEnd);
        return row;
    }

    public LeaseContractDealEnd selectByPrimaryKey(Long id) throws GMException {
        LeaseContractDealEnd leaseContractDealEnd = leaseContractDealEndMapper.selectByPrimaryKey(id);
        return leaseContractDealEnd;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseContractDealEnd> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseContractDealEnd> leaseContractDealEndList = leaseContractDealEndMapper.findPage(paramsMap);
        PageInfo<LeaseContractDealEnd> page = new PageInfo<LeaseContractDealEnd>(leaseContractDealEndList);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <LeaseContractDealEnd> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractDealEnd> leaseContractDealEndList = leaseContractDealEndMapper.findAll(paramsMap);
        return leaseContractDealEndList;
    }

    @Override
    public LeaseContractDealEnd findByContractId(Long contractId) {
        LeaseContractDealEnd leaseContractDealEnd = leaseContractDealEndMapper.findByContractId(contractId);
        return leaseContractDealEnd;
    }
}
