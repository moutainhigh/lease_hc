package com.hc.lease.wx.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.adapter.api.LeaseWxCompanyContactAdapter;
import com.hc.lease.wx.service.api.LeaseWxCompanyContactService;
import com.hc.lease.wx.model.LeaseWxCompanyContact;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 购买说明AdapterImpl
 * @author Qiang
 * @version 2017-11-30
 */
@Service("leaseWxCompanyContactAdapter")
public class LeaseWxCompanyContactAdapterImpl implements LeaseWxCompanyContactAdapter {

	@Autowired
	private LeaseWxCompanyContactService leaseWxCompanyContactService;

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
        int row = leaseWxCompanyContactService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseWxCompanyContactService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseWxCompanyContact record) throws GMException {
        record = leaseWxCompanyContactService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseWxCompanyContact record) throws GMException {
        record = leaseWxCompanyContactService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseWxCompanyContact record) throws GMException {
        int row = leaseWxCompanyContactService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxCompanyContact record) throws GMException {
        int row = leaseWxCompanyContactService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseWxCompanyContact selectByPrimaryKey(Long id) throws GMException {
        LeaseWxCompanyContact leaseWxCompanyContact = leaseWxCompanyContactService.selectByPrimaryKey(id);
        return leaseWxCompanyContact;
    }

    public int insertList(List<LeaseWxCompanyContact> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseWxCompanyContact> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseWxCompanyContact> page = leaseWxCompanyContactService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseWxCompanyContact> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxCompanyContact> leaseWxCompanyContactList = leaseWxCompanyContactService.findAll(paramsMap);
        return leaseWxCompanyContactList;
    }

}
