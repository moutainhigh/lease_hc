package com.hc.lease.account.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.account.vo.LeaseAccountBankExcel;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.account.service.api.LeaseAccountBankCardService;
import com.hc.lease.account.model.LeaseAccountBankCard;
import com.hc.lease.account.dao.LeaseAccountBankCardMapper;

import java.util.List;
import java.util.Map;

/**
 * 承租人银行卡ServiceImpl
 *
 * @author Qiang
 * @version 2018-01-15
 */
@Service("leaseAccountBankCardService")
public class LeaseAccountBankCardServiceImpl implements LeaseAccountBankCardService {

    @Autowired
    private LeaseAccountBankCardMapper leaseAccountBankCardMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAccountBankCardMapper.deleteByPrimaryKey(id);
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
        int row = leaseAccountBankCardMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAccountBankCard insert(LeaseAccountBankCard leaseAccountBankCard) throws GMException {
        leaseAccountBankCard.setCreateTime(DateTime.now().toDate());
        leaseAccountBankCard.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountBankCardMapper.insert(leaseAccountBankCard);
        return leaseAccountBankCard;
    }

    public LeaseAccountBankCard insertSelective(LeaseAccountBankCard leaseAccountBankCard) throws GMException {
        leaseAccountBankCard.setCreateTime(DateTime.now().toDate());
        leaseAccountBankCard.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountBankCardMapper.insertSelective(leaseAccountBankCard);
        return leaseAccountBankCard;
    }

    public int insertList(List<LeaseAccountBankCard> list) throws GMException {
        int row = leaseAccountBankCardMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAccountBankCard leaseAccountBankCard) throws GMException {
        leaseAccountBankCard.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountBankCardMapper.updateByPrimaryKeySelective(leaseAccountBankCard);
        return row;
    }

    public int updateByPrimaryKey(LeaseAccountBankCard leaseAccountBankCard) throws GMException {
        leaseAccountBankCard.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountBankCardMapper.updateByPrimaryKey(leaseAccountBankCard);
        return row;
    }

    public LeaseAccountBankCard selectByPrimaryKey(Long id) throws GMException {
        LeaseAccountBankCard leaseAccountBankCard = leaseAccountBankCardMapper.selectByPrimaryKey(id);
        return leaseAccountBankCard;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAccountBankCard> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAccountBankCard> leaseAccountBankCardList = leaseAccountBankCardMapper.findPage(paramsMap);
        PageInfo<LeaseAccountBankCard> page = new PageInfo<LeaseAccountBankCard>(leaseAccountBankCardList);
        return page;
    }

    public List<LeaseAccountBankCard> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAccountBankCard> leaseAccountBankCardList = leaseAccountBankCardMapper.findAll(paramsMap);
        return leaseAccountBankCardList;
    }

    public void deleteByAccountId(Long id) {
        leaseAccountBankCardMapper.deleteByAccountId(id);
    }

    public LeaseAccountBankCard selectByBackCardNumberAndAccountId(LeaseAccountBankCard leaseAccountBankCard) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("accountId", leaseAccountBankCard.getAccountId());
        params.put("backCardNumber", leaseAccountBankCard.getBackCardNumber());
        LeaseAccountBankCard _leaseAccountBankCard = leaseAccountBankCardMapper.selectByBackCardNumberAndAccountId(params);
        return _leaseAccountBankCard;
    }

    @Override
    public List<LeaseAccountBankCard> selectByAccountId(Long id) {
        List<LeaseAccountBankCard> leaseAccountBankCardList = leaseAccountBankCardMapper.selectByAccountId(id);
        return leaseAccountBankCardList;
    }

    public List<LeaseAccountBankExcel> findAllByExcel(Object o) {

        List<LeaseAccountBankExcel> leaseAccountBankExcels = leaseAccountBankCardMapper.findAllByExcel(o);
        return leaseAccountBankExcels;
    }

    public LeaseAccountBankCard findByAccountIdAndBackCardNumber(Map<String, Object> params) {
        LeaseAccountBankCard leaseAccountBankCard = leaseAccountBankCardMapper.findByAccountIdAndBackCardNumber(params);
        return leaseAccountBankCard;
    }

    @Override
    public LeaseAccountBankCard findByAccountIdAndId(Map<String, Object> paramsMap) throws GMException {
        LeaseAccountBankCard leaseAccountBankCard = leaseAccountBankCardMapper.findByAccountIdAndId(paramsMap);
        return leaseAccountBankCard;
    }

    /**
     * 根据 手机、身份证、银行主键Id、银行卡或存折号码 查询
     *
     * @param params
     * @return
     */
    @Override
    public List<LeaseAccountBankCard> findByAccountInfo(Map<String, Object> params) {
        List<LeaseAccountBankCard> leaseAccountBankCardList = leaseAccountBankCardMapper.findByAccountInfo(params);
        return leaseAccountBankCardList;
    }

    @Override
    public int updateAccountNameByAccountId(LeaseAccountBankCard leaseAccountBankCard) {
        int row = leaseAccountBankCardMapper.updateAccountNameByAccountId(leaseAccountBankCard);
        return row;
    }
}
