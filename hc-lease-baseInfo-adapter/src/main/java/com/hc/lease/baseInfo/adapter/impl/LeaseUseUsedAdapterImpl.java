package com.hc.lease.baseInfo.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.adapter.api.LeaseUseUsedAdapter;
import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.baseInfo.service.api.LeaseUseUsedService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 使用和被使用的数据AdapterImpl
 *
 * @author Tong
 * @version 2017-06-20
 */
@Service("leaseUseUsedAdapter")
public class LeaseUseUsedAdapterImpl implements LeaseUseUsedAdapter {

    @Autowired
    private LeaseUseUsedService leaseUseUsedService;

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
        int row = leaseUseUsedService.deleteByPrimaryKey(id);
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
        int row = leaseUseUsedService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseUseUsed record) throws GMException {
        record = leaseUseUsedService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseUseUsed record) throws GMException {
        record = leaseUseUsedService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseUseUsed record) throws GMException {
        int row = leaseUseUsedService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseUseUsed record) throws GMException {
        int row = leaseUseUsedService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseUseUsed selectByPrimaryKey(Long id) throws GMException {
        LeaseUseUsed leaseUseUsed = leaseUseUsedService.selectByPrimaryKey(id);
        return leaseUseUsed;
    }

    public int insertList(List<LeaseUseUsed> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseUseUsed> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseUseUsed> page = leaseUseUsedService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseUseUsed> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseUseUsed> leaseUseUsedList = leaseUseUsedService.findAll(paramsMap);
        return leaseUseUsedList;
    }

    /**
     * @param paramsMap
     * @return
     */
    public int deleteByUseUsed(Map<String, Object> paramsMap) {
        int row = leaseUseUsedService.deleteByUseUsed(paramsMap);
        return row;
    }

    /**
     * @param paramsMap
     * @return
     */
    public List<LeaseUseUsed> selectByUsed(Map<String, Object> paramsMap) {
        List<LeaseUseUsed> leaseUseUsedList = leaseUseUsedService.selectByUsed(paramsMap);
        return leaseUseUsedList;
    }
}
