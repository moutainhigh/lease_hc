package com.hc.lease.activity.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.activity.adapter.api.LeaseActivityRecordAdapter;
import com.hc.lease.activity.service.api.LeaseActivityRecordService;
import com.hc.lease.activity.model.LeaseActivityRecord;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 活动访问记录AdapterImpl
 * @author Qiang
 * @version 2018-01-08
 */
@Service("leaseActivityRecordAdapter")
public class LeaseActivityRecordAdapterImpl implements LeaseActivityRecordAdapter {

	@Autowired
	private LeaseActivityRecordService leaseActivityRecordService;

    /**
    * 添加或者修改 需要的初始化参数
    *
    * @param paramsMap
    * @return
    */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public LeaseActivityRecord selectByIP(String ipAddress) {
        LeaseActivityRecord leaseActivityRecord=leaseActivityRecordService.selectByIP(ipAddress);
        return leaseActivityRecord;
    }

    public List<LeaseActivityRecord> findAllNoPage(Object o) {
        List<LeaseActivityRecord> leaseActivityRecords=  leaseActivityRecordService.findAllNoPage(o);
        return leaseActivityRecords;
    }


    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseActivityRecordService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseActivityRecordService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseActivityRecord record) throws GMException {
        record = leaseActivityRecordService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseActivityRecord record) throws GMException {
        record = leaseActivityRecordService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseActivityRecord record) throws GMException {
        int row = leaseActivityRecordService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseActivityRecord record) throws GMException {
        int row = leaseActivityRecordService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseActivityRecord selectByPrimaryKey(Long id) throws GMException {
        LeaseActivityRecord leaseActivityRecord = leaseActivityRecordService.selectByPrimaryKey(id);
        return leaseActivityRecord;
    }

    public int insertList(List<LeaseActivityRecord> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseActivityRecord> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseActivityRecord> page = leaseActivityRecordService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseActivityRecord> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseActivityRecord> leaseActivityRecordList = leaseActivityRecordService.findAll(paramsMap);
        return leaseActivityRecordList;
    }

}
