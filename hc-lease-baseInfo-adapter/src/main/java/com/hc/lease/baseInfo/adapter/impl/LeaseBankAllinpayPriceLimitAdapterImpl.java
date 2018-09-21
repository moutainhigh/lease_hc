package com.hc.lease.baseInfo.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.baseInfo.adapter.api.LeaseBankAllinpayPriceLimitAdapter;
import com.hc.lease.baseInfo.service.api.LeaseBankAllinpayPriceLimitService;
import com.hc.lease.baseInfo.model.LeaseBankAllinpayPriceLimit;

import hc.lease.common.util.ListUtil;

import java.util.List;
import java.util.Map;

import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 通联支付银行额度，包括通联代扣、通联协议支付 的限额AdapterImpl
 *
 * @author Tong
 * @version 2018-05-10
 */
@Service("leaseBankAllinpayPriceLimitAdapter")
public class LeaseBankAllinpayPriceLimitAdapterImpl implements LeaseBankAllinpayPriceLimitAdapter {

    @Autowired
    private LeaseBankAllinpayPriceLimitService leaseBankAllinpayPriceLimitService;

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
        int row = leaseBankAllinpayPriceLimitService.deleteByPrimaryKey(id);
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
        int row = leaseBankAllinpayPriceLimitService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseBankAllinpayPriceLimit record) throws GMException {
        record = leaseBankAllinpayPriceLimitService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseBankAllinpayPriceLimit record) throws GMException {
        record = leaseBankAllinpayPriceLimitService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseBankAllinpayPriceLimit record) throws GMException {
        int row = leaseBankAllinpayPriceLimitService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseBankAllinpayPriceLimit record) throws GMException {
        int row = leaseBankAllinpayPriceLimitService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseBankAllinpayPriceLimit selectByPrimaryKey(Long id) throws GMException {
        LeaseBankAllinpayPriceLimit leaseBankAllinpayPriceLimit = leaseBankAllinpayPriceLimitService.selectByPrimaryKey(id);
        return leaseBankAllinpayPriceLimit;
    }

    public int insertList(List<LeaseBankAllinpayPriceLimit> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseBankAllinpayPriceLimit> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseBankAllinpayPriceLimit> page = leaseBankAllinpayPriceLimitService.findPage(pageNum, pageSize, paramsMap);
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
        List<LeaseBankAllinpayPriceLimit> leaseBankAllinpayPriceLimitList = leaseBankAllinpayPriceLimitService.findAll(paramsMap);
        return leaseBankAllinpayPriceLimitList;
    }

}
