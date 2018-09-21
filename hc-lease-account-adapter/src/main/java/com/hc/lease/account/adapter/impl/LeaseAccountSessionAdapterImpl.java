package com.hc.lease.account.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.account.adapter.api.LeaseAccountSessionAdapter;
import com.hc.lease.account.model.LeaseAccountSession;
import com.hc.lease.account.service.api.LeaseAccountSessionService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 注册用户/承租人登录状态sessionAdapterImpl
 *
 * @author Tong
 * @version 2017-05-24
 */
@Service("leaseAccountSessionAdapter")
public class LeaseAccountSessionAdapterImpl implements LeaseAccountSessionAdapter {

    @Autowired
    private LeaseAccountSessionService leaseAccountSessionService;

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
        int row = leaseAccountSessionService.deleteByPrimaryKey(id);
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
        int row = leaseAccountSessionService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAccountSession record) throws GMException {
        record = leaseAccountSessionService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAccountSession record) throws GMException {
        record = leaseAccountSessionService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAccountSession record) throws GMException {
        int row = leaseAccountSessionService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAccountSession record) throws GMException {
        int row = leaseAccountSessionService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAccountSession selectByPrimaryKey(Long id) throws GMException {
        LeaseAccountSession leaseAccountSession = leaseAccountSessionService.selectByPrimaryKey(id);
        return leaseAccountSession;
    }

    public int insertList(List<LeaseAccountSession> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAccountSession> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAccountSession> page = leaseAccountSessionService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseAccountSession> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAccountSession> leaseAccountSessionList = leaseAccountSessionService.findAll(paramsMap);
        return leaseAccountSessionList;
    }

    public LeaseAccountSession selectByDeviceId(String deviceId) throws GMException {
        LeaseAccountSession leaseAccountSession = leaseAccountSessionService.selectByDeviceId(deviceId);
        return leaseAccountSession;
    }

}
