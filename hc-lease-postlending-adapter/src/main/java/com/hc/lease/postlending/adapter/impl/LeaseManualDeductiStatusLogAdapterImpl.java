package com.hc.lease.postlending.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.postlending.adapter.api.LeaseManualDeductiStatusLogAdapter;
import com.hc.lease.postlending.service.api.LeaseManualDeductiStatusLogService;
import com.hc.lease.postlending.model.LeaseManualDeductiStatusLog;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 手动扣款支付状态流水AdapterImpl
 * @author Tong
 * @version 2018-07-06
 */
@Service("leaseManualDeductiStatusLogAdapter")
public class LeaseManualDeductiStatusLogAdapterImpl implements LeaseManualDeductiStatusLogAdapter {

	@Autowired
	private LeaseManualDeductiStatusLogService leaseManualDeductiStatusLogService;

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
        int row = leaseManualDeductiStatusLogService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseManualDeductiStatusLogService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseManualDeductiStatusLog record) throws GMException {
        record = leaseManualDeductiStatusLogService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseManualDeductiStatusLog record) throws GMException {
        record = leaseManualDeductiStatusLogService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseManualDeductiStatusLog record) throws GMException {
        int row = leaseManualDeductiStatusLogService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseManualDeductiStatusLog record) throws GMException {
        int row = leaseManualDeductiStatusLogService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseManualDeductiStatusLog selectByPrimaryKey(Long id) throws GMException {
        LeaseManualDeductiStatusLog leaseManualDeductiStatusLog = leaseManualDeductiStatusLogService.selectByPrimaryKey(id);
        return leaseManualDeductiStatusLog;
    }

    public int insertList(List<LeaseManualDeductiStatusLog> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseManualDeductiStatusLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseManualDeductiStatusLog> page = leaseManualDeductiStatusLogService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List<LeaseManualDeductiStatusLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseManualDeductiStatusLog> leaseManualDeductiStatusLogList = leaseManualDeductiStatusLogService.findAll(paramsMap);
        return leaseManualDeductiStatusLogList;
    }

}
