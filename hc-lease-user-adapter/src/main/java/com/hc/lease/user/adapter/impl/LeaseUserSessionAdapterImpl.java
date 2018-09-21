package com.hc.lease.user.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.user.adapter.api.LeaseUserSessionAdapter;
import com.hc.lease.user.model.LeaseUserSession;
import com.hc.lease.user.service.api.LeaseUserSessionService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 后台用户登录状态sessionAdapterImpl
 * @author Tong
 * @version 2017-06-26
 */
@Service("leaseUserSessionAdapter")
public class LeaseUserSessionAdapterImpl implements LeaseUserSessionAdapter {

	@Autowired
	private LeaseUserSessionService leaseUserSessionService;

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
        int row = leaseUserSessionService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseUserSessionService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseUserSession record) throws GMException {
        record = leaseUserSessionService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseUserSession record) throws GMException {
        record = leaseUserSessionService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseUserSession record) throws GMException {
        int row = leaseUserSessionService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseUserSession record) throws GMException {
        int row = leaseUserSessionService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseUserSession selectByPrimaryKey(Long id) throws GMException {
        LeaseUserSession leaseUserSession = leaseUserSessionService.selectByPrimaryKey(id);
        return leaseUserSession;
    }

    public int insertList(List<LeaseUserSession> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseUserSession> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseUserSession> page = leaseUserSessionService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseUserSession> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseUserSession> leaseUserSessionList = leaseUserSessionService.findAll(paramsMap);
        return leaseUserSessionList;
    }

    public LeaseUserSession selectByDeviceId(String deviceId) throws GMException {
        LeaseUserSession leaseUserSession = leaseUserSessionService.selectByDeviceId(deviceId);
        return leaseUserSession;
    }
}
