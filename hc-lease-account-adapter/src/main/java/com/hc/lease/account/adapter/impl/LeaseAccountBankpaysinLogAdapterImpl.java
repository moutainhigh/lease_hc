package com.hc.lease.account.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.account.adapter.api.LeaseAccountBankpaysinLogAdapter;
import com.hc.lease.account.model.LeaseAccountBankpaysinLog;
import com.hc.lease.account.service.api.LeaseAccountBankpaysinLogService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 承租人银行卡通联支付签约日志AdapterImpl
 *
 * @author Tong
 * @version 2018-04-23
 */
@Service("leaseAccountBankpaysinLogAdapter")
public class LeaseAccountBankpaysinLogAdapterImpl implements LeaseAccountBankpaysinLogAdapter {

    @Autowired
    private LeaseAccountBankpaysinLogService leaseAccountBankpaysinLogService;

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
        int row = leaseAccountBankpaysinLogService.deleteByPrimaryKey(id);
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
        int row = leaseAccountBankpaysinLogService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAccountBankpaysinLog record) throws GMException {
        record = leaseAccountBankpaysinLogService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAccountBankpaysinLog record) throws GMException {
        record = leaseAccountBankpaysinLogService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAccountBankpaysinLog record) throws GMException {
        int row = leaseAccountBankpaysinLogService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAccountBankpaysinLog record) throws GMException {
        int row = leaseAccountBankpaysinLogService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAccountBankpaysinLog selectByPrimaryKey(Long id) throws GMException {
        LeaseAccountBankpaysinLog leaseAccountBankpaysinLog = leaseAccountBankpaysinLogService.selectByPrimaryKey(id);
        return leaseAccountBankpaysinLog;
    }

    public int insertList(List<LeaseAccountBankpaysinLog> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAccountBankpaysinLog> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAccountBankpaysinLog> page = leaseAccountBankpaysinLogService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseAccountBankpaysinLog> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAccountBankpaysinLog> leaseAccountBankpaysinLogList = leaseAccountBankpaysinLogService.findAll(paramsMap);
        return leaseAccountBankpaysinLogList;
    }

    /**
     * 根据用户主键Id删除数据
     *
     * @param accountId
     * @return
     * @throws GMException
     */
    @Override
    public int deleteByAccountId(Long accountId) throws GMException {
        int row = leaseAccountBankpaysinLogService.deleteByAccountId(accountId);
        return row;
    }
}
