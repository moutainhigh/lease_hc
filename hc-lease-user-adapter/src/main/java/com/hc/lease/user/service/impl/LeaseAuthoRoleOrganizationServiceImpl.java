package com.hc.lease.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.user.service.api.LeaseAuthoRoleOrganizationService;
import com.hc.lease.user.model.LeaseAuthoRoleOrganization;
import com.hc.lease.user.dao.LeaseAuthoRoleOrganizationMapper;

import java.util.List;
import java.util.Map;

/**
 * 角色-公司、部门、组中间表。用于控制角色查看指定公司、部门的数据ServiceImpl
 * @author tong
 * @version 2018-08-27
 */
@Service("leaseAuthoRoleOrganizationService")
public class LeaseAuthoRoleOrganizationServiceImpl implements LeaseAuthoRoleOrganizationService {

	@Autowired
	private LeaseAuthoRoleOrganizationMapper leaseAuthoRoleOrganizationMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAuthoRoleOrganizationMapper.deleteByPrimaryKey(id);
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
        int row = leaseAuthoRoleOrganizationMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAuthoRoleOrganization insert(LeaseAuthoRoleOrganization leaseAuthoRoleOrganization) throws GMException {
        int row = leaseAuthoRoleOrganizationMapper.insert(leaseAuthoRoleOrganization);
        return leaseAuthoRoleOrganization;
    }

    public LeaseAuthoRoleOrganization insertSelective(LeaseAuthoRoleOrganization leaseAuthoRoleOrganization) throws GMException {
        int row = leaseAuthoRoleOrganizationMapper.insertSelective(leaseAuthoRoleOrganization);
        return leaseAuthoRoleOrganization;
    }

    public int insertList(List<LeaseAuthoRoleOrganization> list) throws GMException {
        int row = leaseAuthoRoleOrganizationMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAuthoRoleOrganization leaseAuthoRoleOrganization) throws GMException {
        int row = leaseAuthoRoleOrganizationMapper.updateByPrimaryKeySelective(leaseAuthoRoleOrganization);
        return row;
    }

    public int updateByPrimaryKey(LeaseAuthoRoleOrganization leaseAuthoRoleOrganization) throws GMException {
        int row = leaseAuthoRoleOrganizationMapper.updateByPrimaryKey(leaseAuthoRoleOrganization);
        return row;
    }

    public LeaseAuthoRoleOrganization selectByPrimaryKey(Long id) throws GMException {
        LeaseAuthoRoleOrganization leaseAuthoRoleOrganization = leaseAuthoRoleOrganizationMapper.selectByPrimaryKey(id);
        return leaseAuthoRoleOrganization;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseAuthoRoleOrganization> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAuthoRoleOrganization> leaseAuthoRoleOrganizationList = leaseAuthoRoleOrganizationMapper.findPage(paramsMap);
        PageInfo<LeaseAuthoRoleOrganization> page = new PageInfo<LeaseAuthoRoleOrganization>(leaseAuthoRoleOrganizationList);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <LeaseAuthoRoleOrganization> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAuthoRoleOrganization> leaseAuthoRoleOrganizationList = leaseAuthoRoleOrganizationMapper.findAll(paramsMap);
        return leaseAuthoRoleOrganizationList;
    }

}
