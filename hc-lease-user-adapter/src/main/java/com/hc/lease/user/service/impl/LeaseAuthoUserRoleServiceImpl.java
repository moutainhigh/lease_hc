package com.hc.lease.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.user.service.api.LeaseAuthoUserRoleService;
import com.hc.lease.user.model.LeaseAuthoUserRole;
import com.hc.lease.user.dao.LeaseAuthoUserRoleMapper;

import java.util.List;
import java.util.Map;

/**
 * 用户对应的角色ServiceImpl
 * @author tong
 * @version 2018-08-27
 */
@Service("leaseAuthoUserRoleService")
public class LeaseAuthoUserRoleServiceImpl implements LeaseAuthoUserRoleService {

	@Autowired
	private LeaseAuthoUserRoleMapper leaseAuthoUserRoleMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAuthoUserRoleMapper.deleteByPrimaryKey(id);
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
        int row = leaseAuthoUserRoleMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAuthoUserRole insert(LeaseAuthoUserRole leaseAuthoUserRole) throws GMException {
        int row = leaseAuthoUserRoleMapper.insert(leaseAuthoUserRole);
        return leaseAuthoUserRole;
    }

    public LeaseAuthoUserRole insertSelective(LeaseAuthoUserRole leaseAuthoUserRole) throws GMException {
        int row = leaseAuthoUserRoleMapper.insertSelective(leaseAuthoUserRole);
        return leaseAuthoUserRole;
    }

    public int insertList(List<LeaseAuthoUserRole> list) throws GMException {
        int row = leaseAuthoUserRoleMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAuthoUserRole leaseAuthoUserRole) throws GMException {
        int row = leaseAuthoUserRoleMapper.updateByPrimaryKeySelective(leaseAuthoUserRole);
        return row;
    }

    public int updateByPrimaryKey(LeaseAuthoUserRole leaseAuthoUserRole) throws GMException {
        int row = leaseAuthoUserRoleMapper.updateByPrimaryKey(leaseAuthoUserRole);
        return row;
    }

    public LeaseAuthoUserRole selectByPrimaryKey(Long id) throws GMException {
        LeaseAuthoUserRole leaseAuthoUserRole = leaseAuthoUserRoleMapper.selectByPrimaryKey(id);
        return leaseAuthoUserRole;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseAuthoUserRole> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAuthoUserRole> leaseAuthoUserRoleList = leaseAuthoUserRoleMapper.findPage(paramsMap);
        PageInfo<LeaseAuthoUserRole> page = new PageInfo<LeaseAuthoUserRole>(leaseAuthoUserRoleList);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <LeaseAuthoUserRole> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAuthoUserRole> leaseAuthoUserRoleList = leaseAuthoUserRoleMapper.findAll(paramsMap);
        return leaseAuthoUserRoleList;
    }

    @Override
    public int deleteByUserId(Long userId) throws GMException {
        int row = leaseAuthoUserRoleMapper.deleteByUserId(userId);
        return row;
    }
}
