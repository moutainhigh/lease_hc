package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.api.LeaseSchemePrice1xService;
import com.hc.lease.supplier.model.LeaseSchemePrice1x;
import com.hc.lease.supplier.dao.LeaseSchemePrice1xMapper;

import java.util.List;
import java.util.Map;

/**
 * 方案报价-1+xServiceImpl
 * @author Qiang
 * @version 2018-07-27
 */
@Service("leaseSchemePrice1xService")
public class LeaseSchemePrice1xServiceImpl implements LeaseSchemePrice1xService {

	@Autowired
	private LeaseSchemePrice1xMapper leaseSchemePrice1xMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemePrice1xMapper.deleteByPrimaryKey(id);
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
        int row = leaseSchemePrice1xMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseSchemePrice1x insert(LeaseSchemePrice1x leaseSchemePrice1x) throws GMException {
        leaseSchemePrice1x.setCreateTime(DateTime.now().toDate());
        leaseSchemePrice1x.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePrice1xMapper.insert(leaseSchemePrice1x);
        return leaseSchemePrice1x;
    }

    public LeaseSchemePrice1x insertSelective(LeaseSchemePrice1x leaseSchemePrice1x) throws GMException {
        leaseSchemePrice1x.setCreateTime(DateTime.now().toDate());
        leaseSchemePrice1x.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePrice1xMapper.insertSelective(leaseSchemePrice1x);
        return leaseSchemePrice1x;
    }

    public int insertList(List<LeaseSchemePrice1x> list) throws GMException {
        int row = leaseSchemePrice1xMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseSchemePrice1x leaseSchemePrice1x) throws GMException {
        leaseSchemePrice1x.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePrice1xMapper.updateByPrimaryKeySelective(leaseSchemePrice1x);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemePrice1x leaseSchemePrice1x) throws GMException {
        leaseSchemePrice1x.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePrice1xMapper.updateByPrimaryKey(leaseSchemePrice1x);
        return row;
    }

    public LeaseSchemePrice1x selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemePrice1x leaseSchemePrice1x = leaseSchemePrice1xMapper.selectByPrimaryKey(id);
        return leaseSchemePrice1x;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseSchemePrice1x> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseSchemePrice1x> leaseSchemePrice1xList = leaseSchemePrice1xMapper.findPage(paramsMap);
        PageInfo<LeaseSchemePrice1x> page = new PageInfo<LeaseSchemePrice1x>(leaseSchemePrice1xList);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <LeaseSchemePrice1x> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemePrice1x> leaseSchemePrice1xList = leaseSchemePrice1xMapper.findAll(paramsMap);
        return leaseSchemePrice1xList;
    }

    public void deleteBySchemePriceId(Long id) {
        leaseSchemePrice1xMapper.deleteBySchemePriceId(id);
    }
}
