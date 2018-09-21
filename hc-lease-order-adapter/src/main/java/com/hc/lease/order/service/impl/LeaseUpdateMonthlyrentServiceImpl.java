package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.order.service.api.LeaseUpdateMonthlyrentService;
import com.hc.lease.order.model.LeaseUpdateMonthlyrent;
import com.hc.lease.order.dao.LeaseUpdateMonthlyrentMapper;

import java.util.List;
import java.util.Map;

/**
 * 融租合同修改租金备份ServiceImpl
 * @author Tong
 * @version 2017-12-28
 */
@Service("leaseUpdateMonthlyrentService")
public class LeaseUpdateMonthlyrentServiceImpl implements LeaseUpdateMonthlyrentService {

	@Autowired
	private LeaseUpdateMonthlyrentMapper leaseUpdateMonthlyrentMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseUpdateMonthlyrentMapper.deleteByPrimaryKey(id);
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
        int row = leaseUpdateMonthlyrentMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseUpdateMonthlyrent insert(LeaseUpdateMonthlyrent leaseUpdateMonthlyrent) throws GMException {
        leaseUpdateMonthlyrent.setCreateTime(DateTime.now().toDate());
        leaseUpdateMonthlyrent.setUpdateTime(DateTime.now().toDate());
        int row = leaseUpdateMonthlyrentMapper.insert(leaseUpdateMonthlyrent);
        return leaseUpdateMonthlyrent;
    }

    public LeaseUpdateMonthlyrent insertSelective(LeaseUpdateMonthlyrent leaseUpdateMonthlyrent) throws GMException {
        leaseUpdateMonthlyrent.setCreateTime(DateTime.now().toDate());
        leaseUpdateMonthlyrent.setUpdateTime(DateTime.now().toDate());
        int row = leaseUpdateMonthlyrentMapper.insertSelective(leaseUpdateMonthlyrent);
        return leaseUpdateMonthlyrent;
    }

    public int insertList(List<LeaseUpdateMonthlyrent> list) throws GMException {
        int row = leaseUpdateMonthlyrentMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseUpdateMonthlyrent leaseUpdateMonthlyrent) throws GMException {
        leaseUpdateMonthlyrent.setUpdateTime(DateTime.now().toDate());
        int row = leaseUpdateMonthlyrentMapper.updateByPrimaryKeySelective(leaseUpdateMonthlyrent);
        return row;
    }

    public int updateByPrimaryKey(LeaseUpdateMonthlyrent leaseUpdateMonthlyrent) throws GMException {
        leaseUpdateMonthlyrent.setUpdateTime(DateTime.now().toDate());
        int row = leaseUpdateMonthlyrentMapper.updateByPrimaryKey(leaseUpdateMonthlyrent);
        return row;
    }

    public LeaseUpdateMonthlyrent selectByPrimaryKey(Long id) throws GMException {
        LeaseUpdateMonthlyrent leaseUpdateMonthlyrent = leaseUpdateMonthlyrentMapper.selectByPrimaryKey(id);
        return leaseUpdateMonthlyrent;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseUpdateMonthlyrent> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseUpdateMonthlyrent> leaseUpdateMonthlyrentList = leaseUpdateMonthlyrentMapper.findPage(paramsMap);
        PageInfo<LeaseUpdateMonthlyrent> page = new PageInfo<LeaseUpdateMonthlyrent>(leaseUpdateMonthlyrentList);
        return page;
    }

    public List <LeaseUpdateMonthlyrent> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseUpdateMonthlyrent> leaseUpdateMonthlyrentList = leaseUpdateMonthlyrentMapper.findAll(paramsMap);
        return leaseUpdateMonthlyrentList;
    }

}
