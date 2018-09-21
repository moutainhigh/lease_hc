package com.hc.lease.account.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.account.dao.LeaseAccountBankPaySinMapper;
import com.hc.lease.account.model.LeaseAccountBankPaySin;
import com.hc.lease.account.service.api.LeaseAccountBankPaySinService;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 承租人银行卡通联支付签约ServiceImpl
 *
 * @author Tong
 * @version 2018-04-19
 */
@Service("leaseAccountBankPaySinService")
public class LeaseAccountBankPaySinServiceImpl implements LeaseAccountBankPaySinService {

    @Autowired
    private LeaseAccountBankPaySinMapper leaseAccountBankPaySinMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAccountBankPaySinMapper.deleteByPrimaryKey(id);
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
        int row = leaseAccountBankPaySinMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAccountBankPaySin insert(LeaseAccountBankPaySin leaseAccountBankPaySin) throws GMException {
        leaseAccountBankPaySin.setCreateTime(DateTime.now().toDate());
        leaseAccountBankPaySin.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountBankPaySinMapper.insert(leaseAccountBankPaySin);
        return leaseAccountBankPaySin;
    }

    public LeaseAccountBankPaySin insertSelective(LeaseAccountBankPaySin leaseAccountBankPaySin) throws GMException {
        leaseAccountBankPaySin.setCreateTime(DateTime.now().toDate());
        leaseAccountBankPaySin.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountBankPaySinMapper.insertSelective(leaseAccountBankPaySin);
        return leaseAccountBankPaySin;
    }

    public int insertList(List<LeaseAccountBankPaySin> list) throws GMException {
        int row = leaseAccountBankPaySinMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAccountBankPaySin leaseAccountBankPaySin) throws GMException {
        leaseAccountBankPaySin.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountBankPaySinMapper.updateByPrimaryKeySelective(leaseAccountBankPaySin);
        return row;
    }

    public int updateByPrimaryKey(LeaseAccountBankPaySin leaseAccountBankPaySin) throws GMException {
        leaseAccountBankPaySin.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountBankPaySinMapper.updateByPrimaryKey(leaseAccountBankPaySin);
        return row;
    }

    public LeaseAccountBankPaySin selectByPrimaryKey(Long id) throws GMException {
        LeaseAccountBankPaySin leaseAccountBankPaySin = leaseAccountBankPaySinMapper.selectByPrimaryKey(id);
        return leaseAccountBankPaySin;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAccountBankPaySin> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAccountBankPaySin> leaseAccountBankPaySinList = leaseAccountBankPaySinMapper.findPage(paramsMap);
        PageInfo<LeaseAccountBankPaySin> page = new PageInfo<LeaseAccountBankPaySin>(leaseAccountBankPaySinList);
        return page;
    }

    public List<LeaseAccountBankPaySin> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAccountBankPaySin> leaseAccountBankPaySinList = leaseAccountBankPaySinMapper.findAll(paramsMap);
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
        LeaseAccountBankPaySin checkBankCardNumberIsSign = leaseAccountBankPaySinMapper.findByBankCardNumber(bankCardNumber);
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
        LeaseAccountBankPaySin leaseAccountBankPaySin = leaseAccountBankPaySinMapper.findAccountBankCardById(paramsMap);
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
        int row = leaseAccountBankPaySinMapper.updateByAccountId(leaseAccountBankPaySin);
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
        int row = leaseAccountBankPaySinMapper.deleteByAccountId(accountId);
        return row;
    }

    public List<LeaseAccountBankPaySin> findAllNoPage(Object o) {
        List<LeaseAccountBankPaySin> leaseAccountBankPaySins = leaseAccountBankPaySinMapper.findPage(null);
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
        int row = leaseAccountBankPaySinMapper.updateAccountNameByAccountId(leaseAccountBankPaySin);
        return row;
    }
}
