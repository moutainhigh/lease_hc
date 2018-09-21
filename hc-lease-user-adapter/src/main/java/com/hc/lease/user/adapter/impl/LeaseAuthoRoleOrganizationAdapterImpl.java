package com.hc.lease.user.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.user.adapter.api.LeaseAuthoRoleOrganizationAdapter;
import com.hc.lease.user.service.api.LeaseAuthoRoleOrganizationService;
import com.hc.lease.user.model.LeaseAuthoRoleOrganization;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 角色-公司、部门、组中间表。用于控制角色查看指定公司、部门的数据AdapterImpl
 * @author tong
 * @version 2018-08-27
 */
@Service("leaseAuthoRoleOrganizationAdapter")
public class LeaseAuthoRoleOrganizationAdapterImpl implements LeaseAuthoRoleOrganizationAdapter {

	@Autowired
	private LeaseAuthoRoleOrganizationService leaseAuthoRoleOrganizationService;

    /**
    * 添加或者修改 需要的初始化参数
    *
    * @param paramsMap
    * @return
    */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    /**
    * 根据ID删除记录
    *
    * @param id .
    * @return
    * @throws GMException
    */
    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAuthoRoleOrganizationService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseAuthoRoleOrganizationService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAuthoRoleOrganization record) throws GMException {
        record = leaseAuthoRoleOrganizationService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAuthoRoleOrganization record) throws GMException {
        record = leaseAuthoRoleOrganizationService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAuthoRoleOrganization record) throws GMException {
        int row = leaseAuthoRoleOrganizationService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAuthoRoleOrganization record) throws GMException {
        int row = leaseAuthoRoleOrganizationService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAuthoRoleOrganization selectByPrimaryKey(Long id) throws GMException {
        LeaseAuthoRoleOrganization leaseAuthoRoleOrganization = leaseAuthoRoleOrganizationService.selectByPrimaryKey(id);
        return leaseAuthoRoleOrganization;
    }

    public int insertList(List<LeaseAuthoRoleOrganization> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseAuthoRoleOrganization> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAuthoRoleOrganization> page = leaseAuthoRoleOrganizationService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List<LeaseAuthoRoleOrganization> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAuthoRoleOrganization> leaseAuthoRoleOrganizationList = leaseAuthoRoleOrganizationService.findAll(paramsMap);
        return leaseAuthoRoleOrganizationList;
    }

}
