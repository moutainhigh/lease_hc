package com.hc.lease.account.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.account.adapter.api.LeaseAccountBankPaySinAdapter;
import com.hc.lease.account.model.LeaseAccountBankPaySin;
import com.hc.lease.account.service.api.LeaseAccountBankPaySinService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 承租人银行卡通联支付签约AdapterImpl
 *
 * @author Tong
 * @version 2018-04-19
 */
@Service("leaseAccountBankPaySinAdapter")
public class LeaseAccountBankPaySinAdapterImpl implements LeaseAccountBankPaySinAdapter {

    @Autowired
    private LeaseAccountBankPaySinService leaseAccountBankPaySinService;

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
        int row = leaseAccountBankPaySinService.deleteByPrimaryKey(id);
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
        int row = leaseAccountBankPaySinService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAccountBankPaySin record) throws GMException {
        record = leaseAccountBankPaySinService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAccountBankPaySin record) throws GMException {
        record = leaseAccountBankPaySinService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(record);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAccountBankPaySin record) throws GMException {
        int row = leaseAccountBankPaySinService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAccountBankPaySin record) throws GMException {
        int row = leaseAccountBankPaySinService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAccountBankPaySin selectByPrimaryKey(Long id) throws GMException {
        LeaseAccountBankPaySin leaseAccountBankPaySin = leaseAccountBankPaySinService.selectByPrimaryKey(id);
        return leaseAccountBankPaySin;
    }

    public int insertList(List<LeaseAccountBankPaySin> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAccountBankPaySin> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAccountBankPaySin> page = leaseAccountBankPaySinService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseAccountBankPaySin> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAccountBankPaySin> leaseAccountBankPaySinList = leaseAccountBankPaySinService.findAll(paramsMap);
        return leaseAccountBankPaySinList;
    }

    /**
     * 检测银行卡是否已经授权签约成功
     *
     * @param bankCardNumber
     * @return
     * @throws GMException
     */
    @Override
    public LeaseAccountBankPaySin findByBankCardNumber(String bankCardNumber) throws GMException {
        LeaseAccountBankPaySin checkBankCardNumberIsSign = leaseAccountBankPaySinService.findByBankCardNumber(bankCardNumber);
        return checkBankCardNumberIsSign;
    }

    /**
     * 协议支付签约
     * 新增承租人代扣授权 页面刷新请求数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public LeaseAccountBankPaySin findAccountBankCardById(Map<String, Object> paramsMap) throws GMException {
        LeaseAccountBankPaySin leaseAccountBankPaySin = leaseAccountBankPaySinService.findAccountBankCardById(paramsMap);
        return leaseAccountBankPaySin;
    }

    /**
     * 根据用户主键Id修改数据
     *
     * @param leaseAccountBankPaySin
     * @return
     * @throws GMException
     */
    @Override
    public int updateByAccountId(LeaseAccountBankPaySin leaseAccountBankPaySin) throws GMException {
        int row = leaseAccountBankPaySinService.updateByAccountId(leaseAccountBankPaySin);
        return row;
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
        int row = leaseAccountBankPaySinService.deleteByAccountId(accountId);
        return row;
    }

    public List<LeaseAccountBankPaySin> findAllNoPage(Object o) {
        List<LeaseAccountBankPaySin> leaseAccountBankPaySins = leaseAccountBankPaySinService.findAllNoPage(o);
        return leaseAccountBankPaySins;
    }

    /**
     * 根据用户主键Id修改用户名
     *
     * @param leaseAccountBankPaySin
     * @return
     * @throws GMException
     */
    @Override
    public int updateAccountNameByAccountId(LeaseAccountBankPaySin leaseAccountBankPaySin) throws GMException {
        int row = leaseAccountBankPaySinService.updateAccountNameByAccountId(leaseAccountBankPaySin);
        return row;
    }
}
