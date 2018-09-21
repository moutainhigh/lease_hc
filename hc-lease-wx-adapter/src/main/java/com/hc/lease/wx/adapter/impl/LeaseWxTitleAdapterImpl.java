package com.hc.lease.wx.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.adapter.api.LeaseWxTitleAdapter;
import com.hc.lease.wx.service.api.LeaseWxTitleService;
import com.hc.lease.wx.model.LeaseWxTitle;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 标题口号AdapterImpl
 * @author Qiang
 * @version 2017-11-30
 */
@Service("leaseWxTitleAdapter")
public class LeaseWxTitleAdapterImpl implements LeaseWxTitleAdapter {

	@Autowired
	private LeaseWxTitleService leaseWxTitleService;

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
        int row = leaseWxTitleService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseWxTitleService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseWxTitle record) throws GMException {
        record = leaseWxTitleService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseWxTitle record) throws GMException {
        record = leaseWxTitleService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseWxTitle record) throws GMException {
        int row = leaseWxTitleService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxTitle record) throws GMException {
        int row = leaseWxTitleService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseWxTitle selectByPrimaryKey(Long id) throws GMException {
        LeaseWxTitle leaseWxTitle = leaseWxTitleService.selectByPrimaryKey(id);
        return leaseWxTitle;
    }

    public int insertList(List<LeaseWxTitle> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseWxTitle> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseWxTitle> page = leaseWxTitleService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseWxTitle> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxTitle> leaseWxTitleList = leaseWxTitleService.findAll(paramsMap);
        return leaseWxTitleList;
    }

}
