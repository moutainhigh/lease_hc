package com.hc.lease.postlending.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.postlending.adapter.api.LeaseAllinpayStatusLogAdapter;
import com.hc.lease.postlending.model.LeaseAllinpayStatusLog;
import com.hc.lease.postlending.service.api.LeaseAllinpayStatusLogService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 代收状态流水AdapterImpl
 * @author Tong
 * @version 2017-06-15
 */
@Service("leaseAllinpayStatusLogAdapter")
public class LeaseAllinpayStatusLogAdapterImpl implements LeaseAllinpayStatusLogAdapter {

	@Autowired
	private LeaseAllinpayStatusLogService leaseAllinpayStatusLogService;

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
        int row = leaseAllinpayStatusLogService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseAllinpayStatusLogService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAllinpayStatusLog record) throws GMException {
        record = leaseAllinpayStatusLogService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAllinpayStatusLog record) throws GMException {
        record = leaseAllinpayStatusLogService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpayStatusLog record) throws GMException {
        int row = leaseAllinpayStatusLogService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpayStatusLog record) throws GMException {
        int row = leaseAllinpayStatusLogService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAllinpayStatusLog selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpayStatusLog leaseAllinpayStatusLog = leaseAllinpayStatusLogService.selectByPrimaryKey(id);
        return leaseAllinpayStatusLog;
    }

    public int insertList(List<LeaseAllinpayStatusLog> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseAllinpayStatusLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAllinpayStatusLog> page = leaseAllinpayStatusLogService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseAllinpayStatusLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpayStatusLog> leaseAllinpayStatusLogList = leaseAllinpayStatusLogService.findAll(paramsMap);
        return leaseAllinpayStatusLogList;
    }

}
