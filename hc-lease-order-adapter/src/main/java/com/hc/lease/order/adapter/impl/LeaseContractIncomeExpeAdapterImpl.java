package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.adapter.api.LeaseContractIncomeExpeAdapter;
import com.hc.lease.order.model.LeaseContractIncomeExpe;
import com.hc.lease.order.service.api.LeaseContractIncomeExpeService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 贷后车辆管理-收入和支出AdapterImpl
 *
 * @author Tong
 * @version 2018-08-03
 */
@Service("leaseContractIncomeExpeAdapter")
public class LeaseContractIncomeExpeAdapterImpl implements LeaseContractIncomeExpeAdapter {

    @Autowired
    private LeaseContractIncomeExpeService leaseContractIncomeExpeService;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    /**
     * 根据ID删除记录
     *
     * @param id .
     * @return
     * @throws GMException
     */
    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractIncomeExpeService.deleteByPrimaryKey(id);
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
        int row = leaseContractIncomeExpeService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseContractIncomeExpe record) throws GMException {
        record = leaseContractIncomeExpeService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseContractIncomeExpe record) throws GMException {
        record = leaseContractIncomeExpeService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseContractIncomeExpe record) throws GMException {
        int row = leaseContractIncomeExpeService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractIncomeExpe record) throws GMException {
        int row = leaseContractIncomeExpeService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseContractIncomeExpe selectByPrimaryKey(Long id) throws GMException {
        LeaseContractIncomeExpe leaseContractIncomeExpe = leaseContractIncomeExpeService.selectByPrimaryKey(id);
        return leaseContractIncomeExpe;
    }

    public int insertList(List<LeaseContractIncomeExpe> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseContractIncomeExpe> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseContractIncomeExpe> page = leaseContractIncomeExpeService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseContractIncomeExpe> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractIncomeExpe> leaseContractIncomeExpeList = leaseContractIncomeExpeService.findAll(paramsMap);
        return leaseContractIncomeExpeList;
    }

    @Override
    public int deleteByContractId(Map<String, Object> paramsMap) throws GMException {
        int row = leaseContractIncomeExpeService.deleteByContractId(paramsMap);
        return row;
    }

    @Override
    public List<LeaseContractIncomeExpe> findByContractIdAndSource(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractIncomeExpe> leaseContractIncomeExpeList = leaseContractIncomeExpeService.findByContractIdAndSource(paramsMap);
        return leaseContractIncomeExpeList;
    }
}
