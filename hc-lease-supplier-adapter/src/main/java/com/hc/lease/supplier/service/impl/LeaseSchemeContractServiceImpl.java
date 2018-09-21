package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.api.LeaseSchemeContractService;
import com.hc.lease.supplier.model.LeaseSchemeContract;
import com.hc.lease.supplier.dao.LeaseSchemeContractMapper;

import java.util.List;
import java.util.Map;

/**
 * 方案报价-合同ServiceImpl
 * @author Qiang
 * @version 2018-08-09
 */
@Service("leaseSchemeContractService")
public class LeaseSchemeContractServiceImpl implements LeaseSchemeContractService {

	@Autowired
	private LeaseSchemeContractMapper leaseSchemeContractMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemeContractMapper.deleteByPrimaryKey(id);
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
        int row = leaseSchemeContractMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseSchemeContract insert(LeaseSchemeContract leaseSchemeContract) throws GMException {
        leaseSchemeContract.setCreateTime(DateTime.now().toDate());
        leaseSchemeContract.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeContractMapper.insert(leaseSchemeContract);
        return leaseSchemeContract;
    }

    public LeaseSchemeContract insertSelective(LeaseSchemeContract leaseSchemeContract) throws GMException {
        leaseSchemeContract.setCreateTime(DateTime.now().toDate());
        leaseSchemeContract.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeContractMapper.insertSelective(leaseSchemeContract);
        return leaseSchemeContract;
    }

    public int insertList(List<LeaseSchemeContract> list) throws GMException {
        int row = leaseSchemeContractMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseSchemeContract leaseSchemeContract) throws GMException {
        leaseSchemeContract.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeContractMapper.updateByPrimaryKeySelective(leaseSchemeContract);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeContract leaseSchemeContract) throws GMException {
        leaseSchemeContract.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeContractMapper.updateByPrimaryKey(leaseSchemeContract);
        return row;
    }

    public LeaseSchemeContract selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeContract leaseSchemeContract = leaseSchemeContractMapper.selectByPrimaryKey(id);
        return leaseSchemeContract;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseSchemeContract> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseSchemeContract> leaseSchemeContractList = leaseSchemeContractMapper.findPage(paramsMap);
        PageInfo<LeaseSchemeContract> page = new PageInfo<LeaseSchemeContract>(leaseSchemeContractList);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <LeaseSchemeContract> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeContract> leaseSchemeContractList = leaseSchemeContractMapper.findAll(paramsMap);
        return leaseSchemeContractList;
    }

}
