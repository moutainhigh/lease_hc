package com.hc.lease.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.user.service.api.LeaseUserLoginLogService;
import com.hc.lease.user.model.LeaseUserLoginLog;
import com.hc.lease.user.dao.LeaseUserLoginLogMapper;

import java.util.List;
import java.util.Map;

/**
 * 后台用户登录日志ServiceImpl
 *
 * @author Tong
 * @version 2017-12-18
 */
@Service("leaseUserLoginLogService")
public class LeaseUserLoginLogServiceImpl implements LeaseUserLoginLogService {

    @Autowired
    private LeaseUserLoginLogMapper leaseUserLoginLogMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseUserLoginLogMapper.deleteByPrimaryKey(id);
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
        int row = leaseUserLoginLogMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseUserLoginLog insert(LeaseUserLoginLog leaseUserLoginLog) throws GMException {
        int row = leaseUserLoginLogMapper.insert(leaseUserLoginLog);
        return leaseUserLoginLog;
    }

    public LeaseUserLoginLog insertSelective(LeaseUserLoginLog leaseUserLoginLog) throws GMException {
        int row = leaseUserLoginLogMapper.insertSelective(leaseUserLoginLog);
        return leaseUserLoginLog;
    }

    public int insertList(List<LeaseUserLoginLog> list) throws GMException {
        int row = leaseUserLoginLogMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseUserLoginLog leaseUserLoginLog) throws GMException {
        int row = leaseUserLoginLogMapper.updateByPrimaryKeySelective(leaseUserLoginLog);
        return row;
    }

    public int updateByPrimaryKey(LeaseUserLoginLog leaseUserLoginLog) throws GMException {
        int row = leaseUserLoginLogMapper.updateByPrimaryKey(leaseUserLoginLog);
        return row;
    }

    public LeaseUserLoginLog selectByPrimaryKey(Long id) throws GMException {
        LeaseUserLoginLog leaseUserLoginLog = leaseUserLoginLogMapper.selectByPrimaryKey(id);
        return leaseUserLoginLog;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseUserLoginLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseUserLoginLog> leaseUserLoginLogList = leaseUserLoginLogMapper.findPage(paramsMap);
        PageInfo<LeaseUserLoginLog> page = new PageInfo<LeaseUserLoginLog>(leaseUserLoginLogList);
        return page;
    }

    public List<LeaseUserLoginLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseUserLoginLog> leaseUserLoginLogList = leaseUserLoginLogMapper.findAll(paramsMap);
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
        int row = leaseUserLoginLogMapper.updateBySessionCurrent(leaseUserLoginLog);
        return row;
    }

    public LeaseUserLoginLog addSelective(LeaseUserLoginLog leaseUserLoginLog) throws GMException {
        int row = leaseUserLoginLogMapper.addSelective(leaseUserLoginLog);
        return leaseUserLoginLog;
    }

}
