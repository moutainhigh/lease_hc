package com.hc.lease.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.user.vo.AuthRoleSelectByTypeVo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.user.service.api.LeaseAuthoRoleService;
import com.hc.lease.user.model.LeaseAuthoRole;
import com.hc.lease.user.dao.LeaseAuthoRoleMapper;

import java.util.List;
import java.util.Map;

/**
 * 角色ServiceImpl
 * @author tong
 * @version 2018-08-27
 */
@Service("leaseAuthoRoleService")
public class LeaseAuthoRoleServiceImpl implements LeaseAuthoRoleService {

	@Autowired
	private LeaseAuthoRoleMapper leaseAuthoRoleMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAuthoRoleMapper.deleteByPrimaryKey(id);
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
        int row = leaseAuthoRoleMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAuthoRole insert(LeaseAuthoRole leaseAuthoRole) throws GMException {
        leaseAuthoRole.setCreateTime(DateTime.now().toDate());
        leaseAuthoRole.setUpdateTime(DateTime.now().toDate());
        int row = leaseAuthoRoleMapper.insert(leaseAuthoRole);
        return leaseAuthoRole;
    }

    public LeaseAuthoRole insertSelective(LeaseAuthoRole leaseAuthoRole) throws GMException {
        leaseAuthoRole.setCreateTime(DateTime.now().toDate());
        leaseAuthoRole.setUpdateTime(DateTime.now().toDate());
        int row = leaseAuthoRoleMapper.insertSelective(leaseAuthoRole);
        return leaseAuthoRole;
    }

    public int insertList(List<LeaseAuthoRole> list) throws GMException {
        int row = leaseAuthoRoleMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAuthoRole leaseAuthoRole) throws GMException {
        leaseAuthoRole.setUpdateTime(DateTime.now().toDate());
        int row = leaseAuthoRoleMapper.updateByPrimaryKeySelective(leaseAuthoRole);
        return row;
    }

    public int updateByPrimaryKey(LeaseAuthoRole leaseAuthoRole) throws GMException {
        leaseAuthoRole.setUpdateTime(DateTime.now().toDate());
        int row = leaseAuthoRoleMapper.updateByPrimaryKey(leaseAuthoRole);
        return row;
    }

    public LeaseAuthoRole selectByPrimaryKey(Long id) throws GMException {
        LeaseAuthoRole leaseAuthoRole = leaseAuthoRoleMapper.selectByPrimaryKey(id);
        return leaseAuthoRole;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseAuthoRole> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAuthoRole> leaseAuthoRoleList = leaseAuthoRoleMapper.findPage(paramsMap);
        PageInfo<LeaseAuthoRole> page = new PageInfo<LeaseAuthoRole>(leaseAuthoRoleList);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <LeaseAuthoRole> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAuthoRole> leaseAuthoRoleList = leaseAuthoRoleMapper.findAll(paramsMap);
        return leaseAuthoRoleList;
    }

    @Override
    public List<AuthRoleSelectByTypeVo> selectByType(Map<String, Object> paramsMap) throws GMException {
        List<AuthRoleSelectByTypeVo> leaseAuthoRoleList = leaseAuthoRoleMapper.selectByType(paramsMap);
        return leaseAuthoRoleList;
    }
}
