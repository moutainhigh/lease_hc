package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.adapter.api.LeaseSchemeCarFinancingerAdapter;
import com.hc.lease.supplier.service.api.LeaseSchemeCarFinancingerService;
import com.hc.lease.supplier.model.LeaseSchemeCarFinancinger;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 车辆与融租方AdapterImpl
 * @author Qiang
 * @version 2017-08-18
 */
@Service("leaseSchemeCarFinancingerAdapter")
public class LeaseSchemeCarFinancingerAdapterImpl implements LeaseSchemeCarFinancingerAdapter {

	@Autowired
	private LeaseSchemeCarFinancingerService leaseSchemeCarFinancingerService;

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
        int row = leaseSchemeCarFinancingerService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseSchemeCarFinancingerService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseSchemeCarFinancinger record) throws GMException {
        record = leaseSchemeCarFinancingerService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseSchemeCarFinancinger record) throws GMException {
        record = leaseSchemeCarFinancingerService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseSchemeCarFinancinger record) throws GMException {
        int row = leaseSchemeCarFinancingerService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeCarFinancinger record) throws GMException {
        int row = leaseSchemeCarFinancingerService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseSchemeCarFinancinger selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeCarFinancinger leaseSchemeCarFinancinger = leaseSchemeCarFinancingerService.selectByPrimaryKey(id);
        return leaseSchemeCarFinancinger;
    }

    public int insertList(List<LeaseSchemeCarFinancinger> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseSchemeCarFinancinger> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseSchemeCarFinancinger> page = leaseSchemeCarFinancingerService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseSchemeCarFinancinger> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeCarFinancinger> leaseSchemeCarFinancingerList = leaseSchemeCarFinancingerService.findAll(paramsMap);
        return leaseSchemeCarFinancingerList;
    }

    @Override
    public int deleteByCarId(Long carId) {
        int row = leaseSchemeCarFinancingerService.deleteByCarId(carId);
        return row;
    }
}
