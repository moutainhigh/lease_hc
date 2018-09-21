package com.hc.lease.baseInfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.baseInfo.service.api.LeaseBankAllinpayPriceLimitService;
import com.hc.lease.baseInfo.model.LeaseBankAllinpayPriceLimit;
import com.hc.lease.baseInfo.dao.LeaseBankAllinpayPriceLimitMapper;

import java.util.List;
import java.util.Map;

/**
 * 通联支付银行额度，包括通联代扣、通联协议支付 的限额ServiceImpl
 *
 * @author Tong
 * @version 2018-05-10
 */
@Service("leaseBankAllinpayPriceLimitService")
public class LeaseBankAllinpayPriceLimitServiceImpl implements LeaseBankAllinpayPriceLimitService {

    @Autowired
    private LeaseBankAllinpayPriceLimitMapper leaseBankAllinpayPriceLimitMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseBankAllinpayPriceLimitMapper.deleteByPrimaryKey(id);
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
        int row = leaseBankAllinpayPriceLimitMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseBankAllinpayPriceLimit insert(LeaseBankAllinpayPriceLimit leaseBankAllinpayPriceLimit) throws GMException {
        leaseBankAllinpayPriceLimit.setCreateTime(DateTime.now().toDate());
        leaseBankAllinpayPriceLimit.setUpdateTime(DateTime.now().toDate());
        int row = leaseBankAllinpayPriceLimitMapper.insert(leaseBankAllinpayPriceLimit);
        return leaseBankAllinpayPriceLimit;
    }

    public LeaseBankAllinpayPriceLimit insertSelective(LeaseBankAllinpayPriceLimit leaseBankAllinpayPriceLimit) throws GMException {
        leaseBankAllinpayPriceLimit.setCreateTime(DateTime.now().toDate());
        leaseBankAllinpayPriceLimit.setUpdateTime(DateTime.now().toDate());
        int row = leaseBankAllinpayPriceLimitMapper.insertSelective(leaseBankAllinpayPriceLimit);
        return leaseBankAllinpayPriceLimit;
    }

    public int insertList(List<LeaseBankAllinpayPriceLimit> list) throws GMException {
        int row = leaseBankAllinpayPriceLimitMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseBankAllinpayPriceLimit leaseBankAllinpayPriceLimit) throws GMException {
        leaseBankAllinpayPriceLimit.setUpdateTime(DateTime.now().toDate());
        int row = leaseBankAllinpayPriceLimitMapper.updateByPrimaryKeySelective(leaseBankAllinpayPriceLimit);
        return row;
    }

    public int updateByPrimaryKey(LeaseBankAllinpayPriceLimit leaseBankAllinpayPriceLimit) throws GMException {
        leaseBankAllinpayPriceLimit.setUpdateTime(DateTime.now().toDate());
        int row = leaseBankAllinpayPriceLimitMapper.updateByPrimaryKey(leaseBankAllinpayPriceLimit);
        return row;
    }

    public LeaseBankAllinpayPriceLimit selectByPrimaryKey(Long id) throws GMException {
        LeaseBankAllinpayPriceLimit leaseBankAllinpayPriceLimit = leaseBankAllinpayPriceLimitMapper.selectByPrimaryKey(id);
        return leaseBankAllinpayPriceLimit;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseBankAllinpayPriceLimit> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseBankAllinpayPriceLimit> leaseBankAllinpayPriceLimitList = leaseBankAllinpayPriceLimitMapper.findPage(paramsMap);
        PageInfo<LeaseBankAllinpayPriceLimit> page = new PageInfo<LeaseBankAllinpayPriceLimit>(leaseBankAllinpayPriceLimitList);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<LeaseBankAllinpayPriceLimit> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseBankAllinpayPriceLimit> leaseBankAllinpayPriceLimitList = leaseBankAllinpayPriceLimitMapper.findAll(paramsMap);
        return leaseBankAllinpayPriceLimitList;
    }

}
