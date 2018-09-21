package com.hc.lease.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.user.service.LeaseUserService;
import com.hc.lease.user.model.LeaseUser;
import com.hc.lease.user.dao.LeaseUserMapper;

import java.util.List;
import java.util.Map;

/**
 * 后台用户ServiceImpl
 * @author Tong
 * @version 2017-06-26
 */
@Service("leaseUserService")
public class LeaseUserServiceImpl implements LeaseUserService {

	@Autowired
	private LeaseUserMapper leaseUserMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseUserMapper.deleteByPrimaryKey(id);
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
        int row = leaseUserMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseUser insert(LeaseUser record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseUserMapper.insert(record);
        return record;
    }

    public LeaseUser insertSelective(LeaseUser record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseUserMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseUser> list) throws GMException {
        int row = leaseUserMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseUser record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseUserMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseUser record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseUserMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseUser selectByPrimaryKey(Long id) throws GMException {
        LeaseUser leaseUser = leaseUserMapper.selectByPrimaryKey(id);
        return leaseUser;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseUser> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseUser> leaseUserList = leaseUserMapper.findPage(paramsMap);
        PageInfo<LeaseUser> page = new PageInfo<LeaseUser>(leaseUserList);
        return page;
    }

    public List <LeaseUser> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseUser> leaseUserList = leaseUserMapper.findAll(paramsMap);
        return leaseUserList;
    }

    public List<LeaseUser> findByPhone(Map<String, Object> paramsMap) throws GMException {
        List<LeaseUser> leaseUserList = leaseUserMapper.findByPhone(paramsMap);
        return leaseUserList;
    }
}
