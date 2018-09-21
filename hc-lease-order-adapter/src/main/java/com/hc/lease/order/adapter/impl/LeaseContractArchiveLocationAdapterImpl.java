package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.adapter.api.LeaseContractArchiveLocationAdapter;
import com.hc.lease.order.model.LeaseContractArchiveLocation;
import com.hc.lease.order.service.api.LeaseContractArchiveLocationService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融租合同-归档信息AdapterImpl
 * @author Qiang
 * @version 2017-05-23
 */
@Service("leaseContractArchiveLocationAdapter")
public class LeaseContractArchiveLocationAdapterImpl implements LeaseContractArchiveLocationAdapter {

	@Autowired
	private LeaseContractArchiveLocationService leaseContractArchiveLocationService;

    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractArchiveLocationService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseContractArchiveLocationService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseContractArchiveLocation record) throws GMException {
        record = leaseContractArchiveLocationService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseContractArchiveLocation record) throws GMException {
        record = leaseContractArchiveLocationService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }



    public int updateByPrimaryKeySelective(LeaseContractArchiveLocation record) throws GMException {
        int row = leaseContractArchiveLocationService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractArchiveLocation record) throws GMException {
        int row = leaseContractArchiveLocationService.updateByPrimaryKey(record);
        return row;
    }



    public LeaseContractArchiveLocation selectByPrimaryKey(Long id) throws GMException {
        LeaseContractArchiveLocation leaseContractArchiveLocation = leaseContractArchiveLocationService.selectByPrimaryKey(id);
        return leaseContractArchiveLocation;
    }

    public int insertList(List<LeaseContractArchiveLocation> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseContractArchiveLocation> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseContractArchiveLocation> page = leaseContractArchiveLocationService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseContractArchiveLocation> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractArchiveLocation> leaseContractArchiveLocationList = leaseContractArchiveLocationService.findAll(paramsMap);
        return leaseContractArchiveLocationList;
    }

}
