package com.hc.lease.baseInfo.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.baseInfo.adapter.api.LeaseSmsLogAdapter;
import com.hc.lease.baseInfo.service.api.LeaseSmsLogService;
import com.hc.lease.baseInfo.model.LeaseSmsLog;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 短信日志AdapterImpl
 * @author Qiang
 * @version 2017-08-30
 */
@Service("leaseSmsLogAdapter")
public class LeaseSmsLogAdapterImpl implements LeaseSmsLogAdapter {

	@Autowired
	private LeaseSmsLogService leaseSmsLogService;

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
        int row = leaseSmsLogService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseSmsLogService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseSmsLog record) throws GMException {
        record = leaseSmsLogService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseSmsLog record) throws GMException {
        record = leaseSmsLogService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseSmsLog record) throws GMException {
        int row = leaseSmsLogService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSmsLog record) throws GMException {
        int row = leaseSmsLogService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseSmsLog selectByPrimaryKey(Long id) throws GMException {
        LeaseSmsLog leaseSmsLog = leaseSmsLogService.selectByPrimaryKey(id);
        return leaseSmsLog;
    }

    public int insertList(List<LeaseSmsLog> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseSmsLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseSmsLog> page = leaseSmsLogService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseSmsLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSmsLog> leaseSmsLogList = leaseSmsLogService.findAll(paramsMap);
        return leaseSmsLogList;
    }

}
