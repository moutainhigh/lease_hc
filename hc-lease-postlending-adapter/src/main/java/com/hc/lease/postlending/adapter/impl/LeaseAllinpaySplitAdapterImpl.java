package com.hc.lease.postlending.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.postlending.adapter.api.LeaseAllinpaySplitAdapter;
import com.hc.lease.postlending.model.LeaseAllinpaySplit;
import com.hc.lease.postlending.service.api.LeaseAllinpaySplitService;
import com.hc.lease.postlending.vo.AllinpaySplitFindPageVo;
import com.hc.lease.postlending.vo.BatchPostlendingPaymentSplitVo;
import com.hc.lease.postlending.vo.FindQueryTradeNewSplitVo;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通联支付超额拆分交易明细AdapterImpl
 *
 * @author Tong
 * @version 2018-06-19
 */
@Service("leaseAllinpaySplitAdapter")
public class LeaseAllinpaySplitAdapterImpl implements LeaseAllinpaySplitAdapter {

    @Autowired
    private LeaseAllinpaySplitService leaseAllinpaySplitService;

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
        int row = leaseAllinpaySplitService.deleteByPrimaryKey(id);
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
        int row = leaseAllinpaySplitService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAllinpaySplit record) throws GMException {
        record = leaseAllinpaySplitService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAllinpaySplit record) throws GMException {
        record = leaseAllinpaySplitService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpaySplit record) throws GMException {
        int row = leaseAllinpaySplitService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpaySplit record) throws GMException {
        int row = leaseAllinpaySplitService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAllinpaySplit selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpaySplit leaseAllinpaySplit = leaseAllinpaySplitService.selectByPrimaryKey(id);
        return leaseAllinpaySplit;
    }

    public int insertList(List<LeaseAllinpaySplit> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAllinpaySplit> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAllinpaySplit> page = leaseAllinpaySplitService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseAllinpaySplit> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpaySplit> leaseAllinpaySplitList = leaseAllinpaySplitService.findAll(paramsMap);
        return leaseAllinpaySplitList;
    }

    /**
     * 全部数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public List<AllinpaySplitFindPageVo> findAllSplit(Map<String, Object> paramsMap) throws GMException {
        List<AllinpaySplitFindPageVo> leaseAllinpaySplitList = leaseAllinpaySplitService.findAllSplit(paramsMap);
        return leaseAllinpaySplitList;
    }

    @Override
    public PageInfo<AllinpaySplitFindPageVo> findPageSplit(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<AllinpaySplitFindPageVo> leaseAllinpaySplitList = leaseAllinpaySplitService.findPageSplit(pageNum, pageSize, paramsMap);
        return leaseAllinpaySplitList;
    }

    /**
     * 待扣->挂起
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public int changeStatusHangUpOrDown(Map<String, Object> paramsMap) throws GMException {
        int row = leaseAllinpaySplitService.changeStatusHangUpOrDown(paramsMap);
        return row;
    }

    /**
     * 批量协议支付
     * 通联支付拆单
     * 批量协议支付 通联支付拆单 查询需要处理的数据
     *
     * @param paramsMap
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    @Override
    public List<BatchPostlendingPaymentSplitVo> findBatchSplitDual(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<BatchPostlendingPaymentSplitVo> batchPostlendingPaymentSplitVoList = leaseAllinpaySplitService.findBatchSplitDual(paramsMap, dubboTreaceParames);
        return batchPostlendingPaymentSplitVoList;
    }

    @Override
    public BatchPostlendingPaymentSplitVo selectDualSinglePostlendingPaymentSplit(Long id) throws GMException {
        BatchPostlendingPaymentSplitVo batchPostlendingPaymentSplitVo = leaseAllinpaySplitService.selectDualSinglePostlendingPaymentSplit(id);
        return batchPostlendingPaymentSplitVo;
    }

    /**
     * 批量更新
     *
     * @param list
     * @param dubboTreaceParames
     * @return
     */
    @Override
    public int batchUpdateByContract(List<LeaseAllinpaySplit> list, DubboTreaceParames dubboTreaceParames) {
        int row = leaseAllinpaySplitService.batchUpdateByContract(list, dubboTreaceParames);
        return row;
    }

    /**
     * 需要轮询通联超额拆分 的 交易流水/状态为扣款中
     *
     * @param paramsMap
     * @param dubboTreaceParames
     * @return
     */
    @Override
    public List<FindQueryTradeNewSplitVo> findQueryTradeNewSplit(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) {
        List<FindQueryTradeNewSplitVo> batchPostlendingPaymentSplitVoList = leaseAllinpaySplitService.findQueryTradeNewSplit(paramsMap, dubboTreaceParames);
        return batchPostlendingPaymentSplitVoList;
    }

    /**
     * 处理拆分明细状态、挂起
     *
     * @param paramsMap
     * @return
     */
    @Override
    public int changeIsOverTime(Map<String, Object> paramsMap) {
        int row = leaseAllinpaySplitService.changeIsOverTime(paramsMap);
        return row;
    }

    /**
     * 修改合同则修改合同的修改状态
     * 0:合同未作修改 ; 1:合同已作修改
     *
     * @param leaseAllinpaySplit
     * @return
     */
    @Override
    public int updateByContractId(LeaseAllinpaySplit leaseAllinpaySplit) {
        int row = leaseAllinpaySplitService.updateByContractId(leaseAllinpaySplit);
        return row;
    }

    /**
     * 合同修改同时修改 拆单的还款计划主键id,
     * 同时修改 lease_allinpay_split_query_log、lease_allinpay_split_log、lease_allinpay_split、lease_allinpay_split_connect
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public int updateRepaymentId(Map<String, Object> paramsMap) throws GMException {
        int row = leaseAllinpaySplitService.updateRepaymentId(paramsMap);
        return row;
    }
}
