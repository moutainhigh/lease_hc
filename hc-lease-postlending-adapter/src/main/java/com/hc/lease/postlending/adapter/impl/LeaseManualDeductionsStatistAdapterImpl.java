package com.hc.lease.postlending.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.postlending.adapter.api.LeaseManualDeductionsStatistAdapter;
import com.hc.lease.postlending.service.api.LeaseManualDeductionsStatistService;
import com.hc.lease.postlending.model.LeaseManualDeductionsStatist;

import hc.lease.common.util.ListUtil;

import java.util.List;
import java.util.Map;

import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 手动扣款统计AdapterImpl
 *
 * @author Tong
 * @version 2018-07-06
 */
@Service("leaseManualDeductionsStatistAdapter")
public class LeaseManualDeductionsStatistAdapterImpl implements LeaseManualDeductionsStatistAdapter {

    @Autowired
    private LeaseManualDeductionsStatistService leaseManualDeductionsStatistService;

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
        int row = leaseManualDeductionsStatistService.deleteByPrimaryKey(id);
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
        int row = leaseManualDeductionsStatistService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseManualDeductionsStatist record) throws GMException {
        record = leaseManualDeductionsStatistService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseManualDeductionsStatist record) throws GMException {
        record = leaseManualDeductionsStatistService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseManualDeductionsStatist record) throws GMException {
        int row = leaseManualDeductionsStatistService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseManualDeductionsStatist record) throws GMException {
        int row = leaseManualDeductionsStatistService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseManualDeductionsStatist selectByPrimaryKey(Long id) throws GMException {
        LeaseManualDeductionsStatist leaseManualDeductionsStatist = leaseManualDeductionsStatistService.selectByPrimaryKey(id);
        return leaseManualDeductionsStatist;
    }

    public int insertList(List<LeaseManualDeductionsStatist> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseManualDeductionsStatist> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseManualDeductionsStatist> page = leaseManualDeductionsStatistService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseManualDeductionsStatist> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseManualDeductionsStatist> leaseManualDeductionsStatistList = leaseManualDeductionsStatistService.findAll(paramsMap);
        return leaseManualDeductionsStatistList;
    }

    /**
     * 提交支付更新
     *
     * @param leaseManualDeductionsStatist
     * @return
     * @throws GMException
     */
    @Override
    public int updateOnpay(LeaseManualDeductionsStatist leaseManualDeductionsStatist) throws GMException {
        int row = leaseManualDeductionsStatistService.updateOnpay(leaseManualDeductionsStatist);
        return row;
    }
}
