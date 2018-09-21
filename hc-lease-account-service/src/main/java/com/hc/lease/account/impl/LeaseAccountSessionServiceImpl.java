package com.hc.lease.account.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.account.dao.LeaseAccountSessionMapper;
import com.hc.lease.account.model.LeaseAccountSession;
import com.hc.lease.account.service.LeaseAccountSessionService;
import com.hc.lease.common.core.exception.GMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 注册用户/承租人登录状态sessionServiceImpl
 *
 * @author Tong
 * @version 2017-05-24
 */
@Service("leaseAccountSessionService")
public class LeaseAccountSessionServiceImpl implements LeaseAccountSessionService {

    @Autowired
    private LeaseAccountSessionMapper leaseAccountSessionMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAccountSessionMapper.deleteByPrimaryKey(id);
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
        int row = leaseAccountSessionMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAccountSession insert(LeaseAccountSession record) throws GMException {
        int row = leaseAccountSessionMapper.insert(record);
        return record;
    }

    public LeaseAccountSession insertSelective(LeaseAccountSession record) throws GMException {
        int row = leaseAccountSessionMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseAccountSession> list) throws GMException {
        int row = leaseAccountSessionMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAccountSession record) throws GMException {
        int row = leaseAccountSessionMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAccountSession record) throws GMException {
        int row = leaseAccountSessionMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAccountSession selectByPrimaryKey(Long id) throws GMException {
        LeaseAccountSession leaseAccountSession = leaseAccountSessionMapper.selectByPrimaryKey(id);
        return leaseAccountSession;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAccountSession> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAccountSession> leaseAccountSessionList = leaseAccountSessionMapper.findPage(paramsMap);
        PageInfo<LeaseAccountSession> page = new PageInfo<LeaseAccountSession>(leaseAccountSessionList);
        return page;
    }

    public List<LeaseAccountSession> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAccountSession> leaseAccountSessionList = leaseAccountSessionMapper.findAll(paramsMap);
        return leaseAccountSessionList;
    }

    public int insertOrUpdate(LeaseAccountSession leaseAccountSession) throws GMException {
        int row = leaseAccountSessionMapper.deleteByAccountId(leaseAccountSession.getAccountId());
        leaseAccountSessionMapper.insertSelective(leaseAccountSession);
        return 0;
    }

    public LeaseAccountSession selectByDeviceId(String deviceId) throws GMException {
        LeaseAccountSession leaseAccountSession = leaseAccountSessionMapper.selectByDeviceId(deviceId);
        return leaseAccountSession;
    }

    public int deleteByDeviceIdAndPhone(Map<String, Object> paramsMap) throws GMException {
        return leaseAccountSessionMapper.deleteByDeviceIdAndPhone(paramsMap);
    }

}
