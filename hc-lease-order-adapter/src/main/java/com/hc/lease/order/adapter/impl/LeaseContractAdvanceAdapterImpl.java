package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.adapter.api.LeaseContractAdvanceAdapter;
import com.hc.lease.order.model.LeaseContractAdvance;
import com.hc.lease.order.service.api.LeaseContractAdvanceService;
import com.hc.lease.order.vo.FindAdvanceVo;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融租合同贷后管理登记为提前还款,因为提前还款款项包括尾款，罚息，剩余本金，做一个提前还款汇总记录，方便处理几种款项的支付状态AdapterImpl
 *
 * @author Tong
 * @version 2017-08-26
 */
@Service("leaseContractAdvanceAdapter")
public class LeaseContractAdvanceAdapterImpl implements LeaseContractAdvanceAdapter {

    @Autowired
    private LeaseContractAdvanceService leaseContractAdvanceService;

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
        int row = leaseContractAdvanceService.deleteByPrimaryKey(id);
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
        int row = leaseContractAdvanceService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseContractAdvance record) throws GMException {
        record = leaseContractAdvanceService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseContractAdvance record) throws GMException {
        record = leaseContractAdvanceService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseContractAdvance record) throws GMException {
        int row = leaseContractAdvanceService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractAdvance record) throws GMException {
        int row = leaseContractAdvanceService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseContractAdvance selectByPrimaryKey(Long id) throws GMException {
        LeaseContractAdvance leaseContractAdvance = leaseContractAdvanceService.selectByPrimaryKey(id);
        return leaseContractAdvance;
    }

    public int insertList(List<LeaseContractAdvance> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseContractAdvance> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseContractAdvance> page = leaseContractAdvanceService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseContractAdvance> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractAdvance> leaseContractAdvanceList = leaseContractAdvanceService.findAll(paramsMap);
        return leaseContractAdvanceList;
    }

    /**
     * 融租合同的提前还款
     *
     * @param paramsMap
     * @return
     */
    public List<FindAdvanceVo> findAdvance(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<FindAdvanceVo> leaseContractAdvanceList = leaseContractAdvanceService.findAdvance(paramsMap, dubboTreaceParames);
        return leaseContractAdvanceList;
    }
}
