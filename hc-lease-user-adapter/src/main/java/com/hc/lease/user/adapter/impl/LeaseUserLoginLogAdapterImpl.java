package com.hc.lease.user.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.user.adapter.api.LeaseUserLoginLogAdapter;
import com.hc.lease.user.service.api.LeaseUserLoginLogService;
import com.hc.lease.user.model.LeaseUserLoginLog;

import hc.lease.common.util.ListUtil;

import java.util.List;
import java.util.Map;

import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 后台用户登录日志AdapterImpl
 *
 * @author Tong
 * @version 2017-12-18
 */
@Service("leaseUserLoginLogAdapter")
public class LeaseUserLoginLogAdapterImpl implements LeaseUserLoginLogAdapter {

    @Autowired
    private LeaseUserLoginLogService leaseUserLoginLogService;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseUserLoginLogService.deleteByPrimaryKey(id);
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
        int row = leaseUserLoginLogService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseUserLoginLog record) throws GMException {
        record = leaseUserLoginLogService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseUserLoginLog record) throws GMException {
        record = leaseUserLoginLogService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseUserLoginLog record) throws GMException {
        int row = leaseUserLoginLogService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseUserLoginLog record) throws GMException {
        int row = leaseUserLoginLogService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseUserLoginLog selectByPrimaryKey(Long id) throws GMException {
        LeaseUserLoginLog leaseUserLoginLog = leaseUserLoginLogService.selectByPrimaryKey(id);
        return leaseUserLoginLog;
    }

    public int insertList(List<LeaseUserLoginLog> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseUserLoginLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseUserLoginLog> page = leaseUserLoginLogService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseUserLoginLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseUserLoginLog> leaseUserLoginLogList = leaseUserLoginLogService.findAll(paramsMap);
        return leaseUserLoginLogList;
    }

    /**
     * 根据session修改
     *
     * @param leaseUserLoginLog
     * @return
     */
    @Override
    public int updateBySessionCurrent(LeaseUserLoginLog leaseUserLoginLog) {
        int row = leaseUserLoginLogService.updateBySessionCurrent(leaseUserLoginLog);
        return row;
    }

    @Override
    public ResultHashMap addSelective(LeaseUserLoginLog leaseUserLoginLog) throws GMException {
        leaseUserLoginLog = leaseUserLoginLogService.addSelective(leaseUserLoginLog);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }
}
