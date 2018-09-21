package com.hc.lease.user.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.user.vo.AuthRoleSelectByTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.user.adapter.api.LeaseAuthoRoleAdapter;
import com.hc.lease.user.service.api.LeaseAuthoRoleService;
import com.hc.lease.user.model.LeaseAuthoRole;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 角色AdapterImpl
 * @author tong
 * @version 2018-08-27
 */
@Service("leaseAuthoRoleAdapter")
public class LeaseAuthoRoleAdapterImpl implements LeaseAuthoRoleAdapter {

	@Autowired
	private LeaseAuthoRoleService leaseAuthoRoleService;

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
        int row = leaseAuthoRoleService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseAuthoRoleService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAuthoRole record) throws GMException {
        record = leaseAuthoRoleService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAuthoRole record) throws GMException {
        record = leaseAuthoRoleService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAuthoRole record) throws GMException {
        int row = leaseAuthoRoleService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAuthoRole record) throws GMException {
        int row = leaseAuthoRoleService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAuthoRole selectByPrimaryKey(Long id) throws GMException {
        LeaseAuthoRole leaseAuthoRole = leaseAuthoRoleService.selectByPrimaryKey(id);
        return leaseAuthoRole;
    }

    public int insertList(List<LeaseAuthoRole> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseAuthoRole> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAuthoRole> page = leaseAuthoRoleService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List<LeaseAuthoRole> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAuthoRole> leaseAuthoRoleList = leaseAuthoRoleService.findAll(paramsMap);
        return leaseAuthoRoleList;
    }

    @Override
    public List<AuthRoleSelectByTypeVo> selectByType(Map<String, Object> paramsMap) throws GMException {
        List<AuthRoleSelectByTypeVo> leaseAuthoRoleList = leaseAuthoRoleService.selectByType(paramsMap);
        return leaseAuthoRoleList;
    }
}
