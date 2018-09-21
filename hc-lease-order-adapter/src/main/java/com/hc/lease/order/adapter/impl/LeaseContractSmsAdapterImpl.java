package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.order.adapter.api.LeaseContractSmsAdapter;
import com.hc.lease.order.service.api.LeaseContractSmsService;
import com.hc.lease.order.model.LeaseContractSms;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 短信日志-融租合同AdapterImpl
 * @author Qiang
 * @version 2017-08-31
 */
@Service("leaseContractSmsAdapter")
public class LeaseContractSmsAdapterImpl implements LeaseContractSmsAdapter {

	@Autowired
	private LeaseContractSmsService leaseContractSmsService;

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
        int row = leaseContractSmsService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseContractSmsService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseContractSms record) throws GMException {
        record = leaseContractSmsService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseContractSms record) throws GMException {
        record = leaseContractSmsService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseContractSms record) throws GMException {
        int row = leaseContractSmsService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractSms record) throws GMException {
        int row = leaseContractSmsService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseContractSms selectByPrimaryKey(Long id) throws GMException {
        LeaseContractSms leaseContractSms = leaseContractSmsService.selectByPrimaryKey(id);
        return leaseContractSms;
    }

    public int insertList(List<LeaseContractSms> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseContractSms> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseContractSms> page = leaseContractSmsService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseContractSms> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractSms> leaseContractSmsList = leaseContractSmsService.findAll(paramsMap);
        return leaseContractSmsList;
    }

}
