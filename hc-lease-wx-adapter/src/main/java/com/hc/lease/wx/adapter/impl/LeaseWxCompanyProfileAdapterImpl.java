package com.hc.lease.wx.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.adapter.api.LeaseWxCompanyProfileAdapter;
import com.hc.lease.wx.service.api.LeaseWxCompanyProfileService;
import com.hc.lease.wx.model.LeaseWxCompanyProfile;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 购买说明AdapterImpl
 * @author Qiang
 * @version 2017-11-30
 */
@Service("leaseWxCompanyProfileAdapter")
public class LeaseWxCompanyProfileAdapterImpl implements LeaseWxCompanyProfileAdapter {

	@Autowired
	private LeaseWxCompanyProfileService leaseWxCompanyProfileService;

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
        int row = leaseWxCompanyProfileService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseWxCompanyProfileService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseWxCompanyProfile record) throws GMException {
        record = leaseWxCompanyProfileService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseWxCompanyProfile record) throws GMException {
        record = leaseWxCompanyProfileService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseWxCompanyProfile record) throws GMException {
        int row = leaseWxCompanyProfileService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxCompanyProfile record) throws GMException {
        int row = leaseWxCompanyProfileService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseWxCompanyProfile selectByPrimaryKey(Long id) throws GMException {
        LeaseWxCompanyProfile leaseWxCompanyProfile = leaseWxCompanyProfileService.selectByPrimaryKey(id);
        return leaseWxCompanyProfile;
    }

    public int insertList(List<LeaseWxCompanyProfile> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseWxCompanyProfile> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseWxCompanyProfile> page = leaseWxCompanyProfileService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseWxCompanyProfile> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxCompanyProfile> leaseWxCompanyProfileList = leaseWxCompanyProfileService.findAll(paramsMap);
        return leaseWxCompanyProfileList;
    }

}
