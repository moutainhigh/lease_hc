package com.hc.lease.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.user.service.api.LeaseAuthoUserOrganizationService;
import com.hc.lease.user.model.LeaseAuthoUserOrganization;
import com.hc.lease.user.dao.LeaseAuthoUserOrganizationMapper;

import java.util.List;
import java.util.Map;

/**
 * 用户-公司、部门、组中间表，用户所属的组织ServiceImpl
 * @author tong
 * @version 2018-08-27
 */
@Service("leaseAuthoUserOrganizationService")
public class LeaseAuthoUserOrganizationServiceImpl implements LeaseAuthoUserOrganizationService {

	@Autowired
	private LeaseAuthoUserOrganizationMapper leaseAuthoUserOrganizationMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAuthoUserOrganizationMapper.deleteByPrimaryKey(id);
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
        int row = leaseAuthoUserOrganizationMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAuthoUserOrganization insert(LeaseAuthoUserOrganization leaseAuthoUserOrganization) throws GMException {
        int row = leaseAuthoUserOrganizationMapper.insert(leaseAuthoUserOrganization);
        return leaseAuthoUserOrganization;
    }

    public LeaseAuthoUserOrganization insertSelective(LeaseAuthoUserOrganization leaseAuthoUserOrganization) throws GMException {
        int row = leaseAuthoUserOrganizationMapper.insertSelective(leaseAuthoUserOrganization);
        return leaseAuthoUserOrganization;
    }

    public int insertList(List<LeaseAuthoUserOrganization> list) throws GMException {
        int row = leaseAuthoUserOrganizationMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAuthoUserOrganization leaseAuthoUserOrganization) throws GMException {
        int row = leaseAuthoUserOrganizationMapper.updateByPrimaryKeySelective(leaseAuthoUserOrganization);
        return row;
    }

    public int updateByPrimaryKey(LeaseAuthoUserOrganization leaseAuthoUserOrganization) throws GMException {
        int row = leaseAuthoUserOrganizationMapper.updateByPrimaryKey(leaseAuthoUserOrganization);
        return row;
    }

    public LeaseAuthoUserOrganization selectByPrimaryKey(Long id) throws GMException {
        LeaseAuthoUserOrganization leaseAuthoUserOrganization = leaseAuthoUserOrganizationMapper.selectByPrimaryKey(id);
        return leaseAuthoUserOrganization;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseAuthoUserOrganization> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAuthoUserOrganization> leaseAuthoUserOrganizationList = leaseAuthoUserOrganizationMapper.findPage(paramsMap);
        PageInfo<LeaseAuthoUserOrganization> page = new PageInfo<LeaseAuthoUserOrganization>(leaseAuthoUserOrganizationList);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <LeaseAuthoUserOrganization> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAuthoUserOrganization> leaseAuthoUserOrganizationList = leaseAuthoUserOrganizationMapper.findAll(paramsMap);
        return leaseAuthoUserOrganizationList;
    }

    @Override
    public int deleteByUserId(Long userId) throws GMException {
        int row = leaseAuthoUserOrganizationMapper.deleteByUserId(userId);
        return row;
    }
}
