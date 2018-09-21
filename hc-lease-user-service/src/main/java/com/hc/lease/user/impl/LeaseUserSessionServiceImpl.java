package com.hc.lease.user.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.user.service.LeaseUserSessionService;
import com.hc.lease.user.model.LeaseUserSession;
import com.hc.lease.user.dao.LeaseUserSessionMapper;

import java.util.List;
import java.util.Map;

/**
 * 后台用户登录状态sessionServiceImpl
 * @author Tong
 * @version 2017-06-26
 */
@Service("leaseUserSessionService")
public class LeaseUserSessionServiceImpl implements LeaseUserSessionService {

	@Autowired
	private LeaseUserSessionMapper leaseUserSessionMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseUserSessionMapper.deleteByPrimaryKey(id);
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
        int row = leaseUserSessionMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseUserSession insert(LeaseUserSession record) throws GMException {
        int row = leaseUserSessionMapper.insert(record);
        return record;
    }

    public LeaseUserSession insertSelective(LeaseUserSession record) throws GMException {
        int row = leaseUserSessionMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseUserSession> list) throws GMException {
        int row = leaseUserSessionMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseUserSession record) throws GMException {
        int row = leaseUserSessionMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseUserSession record) throws GMException {
        int row = leaseUserSessionMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseUserSession selectByPrimaryKey(Long id) throws GMException {
        LeaseUserSession leaseUserSession = leaseUserSessionMapper.selectByPrimaryKey(id);
        return leaseUserSession;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseUserSession> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseUserSession> leaseUserSessionList = leaseUserSessionMapper.findPage(paramsMap);
        PageInfo<LeaseUserSession> page = new PageInfo<LeaseUserSession>(leaseUserSessionList);
        return page;
    }

    public List <LeaseUserSession> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseUserSession> leaseUserSessionList = leaseUserSessionMapper.findAll(paramsMap);
        return leaseUserSessionList;
    }

    public int deleteByDeviceIdAndPhone(Map<String, Object> paramsMap) throws GMException {
        return leaseUserSessionMapper.deleteByDeviceIdAndPhone(paramsMap);
    }

    public LeaseUserSession selectByDeviceId(String deviceId) throws GMException {
        LeaseUserSession leaseUserSession = leaseUserSessionMapper.selectByDeviceId(deviceId);
        return leaseUserSession;
    }
}
