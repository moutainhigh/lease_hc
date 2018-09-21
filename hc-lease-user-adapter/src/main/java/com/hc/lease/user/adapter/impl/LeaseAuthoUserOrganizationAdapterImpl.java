package com.hc.lease.user.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.user.adapter.api.LeaseAuthoUserOrganizationAdapter;
import com.hc.lease.user.service.api.LeaseAuthoUserOrganizationService;
import com.hc.lease.user.model.LeaseAuthoUserOrganization;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 用户-公司、部门、组中间表，用户所属的组织AdapterImpl
 * @author tong
 * @version 2018-08-27
 */
@Service("leaseAuthoUserOrganizationAdapter")
public class LeaseAuthoUserOrganizationAdapterImpl implements LeaseAuthoUserOrganizationAdapter {

	@Autowired
	private LeaseAuthoUserOrganizationService leaseAuthoUserOrganizationService;

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
        int row = leaseAuthoUserOrganizationService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseAuthoUserOrganizationService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAuthoUserOrganization record) throws GMException {
        record = leaseAuthoUserOrganizationService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAuthoUserOrganization record) throws GMException {
        record = leaseAuthoUserOrganizationService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAuthoUserOrganization record) throws GMException {
        int row = leaseAuthoUserOrganizationService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAuthoUserOrganization record) throws GMException {
        int row = leaseAuthoUserOrganizationService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAuthoUserOrganization selectByPrimaryKey(Long id) throws GMException {
        LeaseAuthoUserOrganization leaseAuthoUserOrganization = leaseAuthoUserOrganizationService.selectByPrimaryKey(id);
        return leaseAuthoUserOrganization;
    }

    public int insertList(List<LeaseAuthoUserOrganization> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseAuthoUserOrganization> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAuthoUserOrganization> page = leaseAuthoUserOrganizationService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List<LeaseAuthoUserOrganization> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAuthoUserOrganization> leaseAuthoUserOrganizationList = leaseAuthoUserOrganizationService.findAll(paramsMap);
        return leaseAuthoUserOrganizationList;
    }

    @Override
    public int deleteByUserId(Long userId) throws GMException {
        int row = leaseAuthoUserOrganizationService.deleteByUserId(userId);
        return row;
    }
}
