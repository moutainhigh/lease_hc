package com.hc.lease.wx.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.adapter.api.LeaseWxSmsAdapter;
import com.hc.lease.wx.service.api.LeaseWxSmsService;
import com.hc.lease.wx.model.LeaseWxSms;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 小程序短信参数配置AdapterImpl
 * @author Qiang
 * @version 2018-03-23
 */
@Service("leaseWxSmsAdapter")
public class LeaseWxSmsAdapterImpl implements LeaseWxSmsAdapter {

	@Autowired
	private LeaseWxSmsService leaseWxSmsService;

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
        int row = leaseWxSmsService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseWxSmsService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseWxSms record) throws GMException {
        record = leaseWxSmsService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseWxSms record) throws GMException {
        record = leaseWxSmsService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseWxSms record) throws GMException {
        int row = leaseWxSmsService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxSms record) throws GMException {
        int row = leaseWxSmsService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseWxSms selectByPrimaryKey(Long id) throws GMException {
        LeaseWxSms leaseWxSms = leaseWxSmsService.selectByPrimaryKey(id);
        return leaseWxSms;
    }

    public int insertList(List<LeaseWxSms> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseWxSms> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseWxSms> page = leaseWxSmsService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseWxSms> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxSms> leaseWxSmsList = leaseWxSmsService.findAll(paramsMap);
        return leaseWxSmsList;
    }

}
