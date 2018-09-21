package com.hc.lease.user.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.user.adapter.api.LeaseAuthoUserRoleAdapter;
import com.hc.lease.user.service.api.LeaseAuthoUserRoleService;
import com.hc.lease.user.model.LeaseAuthoUserRole;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 用户对应的角色AdapterImpl
 * @author tong
 * @version 2018-08-27
 */
@Service("leaseAuthoUserRoleAdapter")
public class LeaseAuthoUserRoleAdapterImpl implements LeaseAuthoUserRoleAdapter {

	@Autowired
	private LeaseAuthoUserRoleService leaseAuthoUserRoleService;

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
        int row = leaseAuthoUserRoleService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseAuthoUserRoleService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAuthoUserRole record) throws GMException {
        record = leaseAuthoUserRoleService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAuthoUserRole record) throws GMException {
        record = leaseAuthoUserRoleService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAuthoUserRole record) throws GMException {
        int row = leaseAuthoUserRoleService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAuthoUserRole record) throws GMException {
        int row = leaseAuthoUserRoleService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAuthoUserRole selectByPrimaryKey(Long id) throws GMException {
        LeaseAuthoUserRole leaseAuthoUserRole = leaseAuthoUserRoleService.selectByPrimaryKey(id);
        return leaseAuthoUserRole;
    }

    public int insertList(List<LeaseAuthoUserRole> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseAuthoUserRole> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAuthoUserRole> page = leaseAuthoUserRoleService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List<LeaseAuthoUserRole> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAuthoUserRole> leaseAuthoUserRoleList = leaseAuthoUserRoleService.findAll(paramsMap);
        return leaseAuthoUserRoleList;
    }

    @Override
    public int deleteByUserId(Long userId) throws GMException {
        int row = leaseAuthoUserRoleService.deleteByUserId(userId);
        return row;
    }
}
