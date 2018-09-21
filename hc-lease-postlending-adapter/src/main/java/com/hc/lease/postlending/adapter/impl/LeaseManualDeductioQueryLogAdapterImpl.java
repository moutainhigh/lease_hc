package com.hc.lease.postlending.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.postlending.adapter.api.LeaseManualDeductioQueryLogAdapter;
import com.hc.lease.postlending.service.api.LeaseManualDeductioQueryLogService;
import com.hc.lease.postlending.model.LeaseManualDeductioQueryLog;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 手动扣款通联轮询款项支付状态，支付的时候记录的代收流水的状态不是通联最后的支付状态，通联规定每笔款都要在支付后10分钟查询结果，这里就记录查询结果的状态，每一条支付流水都对应一条轮询流水AdapterImpl
 * @author Tong
 * @version 2018-07-06
 */
@Service("leaseManualDeductioQueryLogAdapter")
public class LeaseManualDeductioQueryLogAdapterImpl implements LeaseManualDeductioQueryLogAdapter {

	@Autowired
	private LeaseManualDeductioQueryLogService leaseManualDeductioQueryLogService;

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
        int row = leaseManualDeductioQueryLogService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseManualDeductioQueryLogService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseManualDeductioQueryLog record) throws GMException {
        record = leaseManualDeductioQueryLogService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseManualDeductioQueryLog record) throws GMException {
        record = leaseManualDeductioQueryLogService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseManualDeductioQueryLog record) throws GMException {
        int row = leaseManualDeductioQueryLogService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseManualDeductioQueryLog record) throws GMException {
        int row = leaseManualDeductioQueryLogService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseManualDeductioQueryLog selectByPrimaryKey(Long id) throws GMException {
        LeaseManualDeductioQueryLog leaseManualDeductioQueryLog = leaseManualDeductioQueryLogService.selectByPrimaryKey(id);
        return leaseManualDeductioQueryLog;
    }

    public int insertList(List<LeaseManualDeductioQueryLog> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseManualDeductioQueryLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseManualDeductioQueryLog> page = leaseManualDeductioQueryLogService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List<LeaseManualDeductioQueryLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseManualDeductioQueryLog> leaseManualDeductioQueryLogList = leaseManualDeductioQueryLogService.findAll(paramsMap);
        return leaseManualDeductioQueryLogList;
    }

}
