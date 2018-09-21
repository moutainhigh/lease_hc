package com.hc.lease.postlending.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.postlending.adapter.api.LeaseAllinpayStatusSmsAdapter;
import com.hc.lease.postlending.service.api.LeaseAllinpayStatusSmsService;
import com.hc.lease.postlending.model.LeaseAllinpayStatusSms;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 通联扣款结果短信通知日志AdapterImpl
 * @author Tong
 * @version 2017-09-13
 */
@Service("leaseAllinpayStatusSmsAdapter")
public class LeaseAllinpayStatusSmsAdapterImpl implements LeaseAllinpayStatusSmsAdapter {

	@Autowired
	private LeaseAllinpayStatusSmsService leaseAllinpayStatusSmsService;

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
        int row = leaseAllinpayStatusSmsService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseAllinpayStatusSmsService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAllinpayStatusSms record) throws GMException {
        record = leaseAllinpayStatusSmsService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAllinpayStatusSms record) throws GMException {
        record = leaseAllinpayStatusSmsService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpayStatusSms record) throws GMException {
        int row = leaseAllinpayStatusSmsService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpayStatusSms record) throws GMException {
        int row = leaseAllinpayStatusSmsService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAllinpayStatusSms selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpayStatusSms leaseAllinpayStatusSms = leaseAllinpayStatusSmsService.selectByPrimaryKey(id);
        return leaseAllinpayStatusSms;
    }

    public int insertList(List<LeaseAllinpayStatusSms> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseAllinpayStatusSms> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAllinpayStatusSms> page = leaseAllinpayStatusSmsService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseAllinpayStatusSms> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpayStatusSms> leaseAllinpayStatusSmsList = leaseAllinpayStatusSmsService.findAll(paramsMap);
        return leaseAllinpayStatusSmsList;
    }

}
