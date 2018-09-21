package com.hc.lease.baseInfo.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.adapter.api.LeaseAreaAdapter;
import com.hc.lease.baseInfo.model.LeaseArea;
import com.hc.lease.baseInfo.service.api.LeaseAreaService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 地区AdapterImpl
 *
 * @author Tong
 * @version 2017-04-26
 */
@Service("leaseAreaAdapter")
public class LeaseAreaAdapterImpl implements LeaseAreaAdapter {

    @Autowired
    private LeaseAreaService leaseAreaService;

    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAreaService.deleteByPrimaryKey(id);
        return row;
    }

    /**
     * 根据ID删除记录.批量删除
     *
     * @param ids .
     * @return
     * @throws GMException
     */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseAreaService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseArea record) throws GMException {
        record = leaseAreaService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseArea record) throws GMException {
        record = leaseAreaService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int insertList(List<LeaseArea> record) throws GMException {
        int row = leaseAreaService.insertList(record);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseArea record) throws GMException {
        int row = leaseAreaService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseArea record) throws GMException {
        int row = leaseAreaService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseArea selectByPrimaryKey(Long id) throws GMException {
        LeaseArea leaseArea = leaseAreaService.selectByPrimaryKey(id);
        return leaseArea;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseArea> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseArea> page = leaseAreaService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseArea> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseArea> leaseAreaList = leaseAreaService.findAll(paramsMap);
        return leaseAreaList;
    }

    public List<LeaseArea> findAreaByEnableAndModel(Map<String, Object> paramsMap) throws GMException {
        List<LeaseArea> leaseAreaList = leaseAreaService.findAreaByEnableAndModel(paramsMap);
        return leaseAreaList;
    }

}
