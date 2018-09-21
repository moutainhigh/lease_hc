package com.hc.lease.postlending.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.dao.LeaseAllinpaySplitMapper;
import com.hc.lease.postlending.model.LeaseAllinpaySplit;
import com.hc.lease.postlending.service.api.LeaseAllinpaySplitService;
import com.hc.lease.postlending.vo.AllinpaySplitFindPageVo;
import com.hc.lease.postlending.vo.BatchPostlendingPaymentSplitVo;
import com.hc.lease.postlending.vo.FindQueryTradeNewSplitVo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通联支付超额拆分交易明细ServiceImpl
 *
 * @author Tong
 * @version 2018-06-19
 */
@Service("leaseAllinpaySplitService")
public class LeaseAllinpaySplitServiceImpl implements LeaseAllinpaySplitService {

    @Autowired
    private LeaseAllinpaySplitMapper leaseAllinpaySplitMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAllinpaySplitMapper.deleteByPrimaryKey(id);
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
        int row = leaseAllinpaySplitMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAllinpaySplit insert(LeaseAllinpaySplit leaseAllinpaySplit) throws GMException {
        leaseAllinpaySplit.setCreateTime(DateTime.now().toDate());
        leaseAllinpaySplit.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpaySplitMapper.insert(leaseAllinpaySplit);
        return leaseAllinpaySplit;
    }

    public LeaseAllinpaySplit insertSelective(LeaseAllinpaySplit leaseAllinpaySplit) throws GMException {
        leaseAllinpaySplit.setCreateTime(DateTime.now().toDate());
        leaseAllinpaySplit.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpaySplitMapper.insertSelective(leaseAllinpaySplit);
        return leaseAllinpaySplit;
    }

    public int insertList(List<LeaseAllinpaySplit> list) throws GMException {
        int row = leaseAllinpaySplitMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpaySplit leaseAllinpaySplit) throws GMException {
        int row = leaseAllinpaySplitMapper.updateByPrimaryKeySelective(leaseAllinpaySplit);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpaySplit leaseAllinpaySplit) throws GMException {
        leaseAllinpaySplit.setUpdateTime(DateTime.now().toDate());
        int row = leaseAllinpaySplitMapper.updateByPrimaryKey(leaseAllinpaySplit);
        return row;
    }

    public LeaseAllinpaySplit selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpaySplit leaseAllinpaySplit = leaseAllinpaySplitMapper.selectByPrimaryKey(id);
        return leaseAllinpaySplit;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAllinpaySplit> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAllinpaySplit> leaseAllinpaySplitList = leaseAllinpaySplitMapper.findPage(paramsMap);
        PageInfo<LeaseAllinpaySplit> page = new PageInfo<LeaseAllinpaySplit>(leaseAllinpaySplitList);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseAllinpaySplit> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpaySplit> leaseAllinpaySplitList = leaseAllinpaySplitMapper.findAll(paramsMap);
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
        List<AllinpaySplitFindPageVo> leaseAllinpaySplitList = leaseAllinpaySplitMapper.findPageSplit(paramsMap);
        return leaseAllinpaySplitList;
    }

    /**
     * 分页
     *
     * @return
     */
    @Override
    public PageInfo<AllinpaySplitFindPageVo> findPageSplit(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<AllinpaySplitFindPageVo> leaseAllinpaySplitList = leaseAllinpaySplitMapper.findPageSplit(paramsMap);
        PageInfo<AllinpaySplitFindPageVo> page = new PageInfo<AllinpaySplitFindPageVo>(leaseAllinpaySplitList);
        return page;
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
        int row = leaseAllinpaySplitMapper.changeStatusHangUpOrDown(paramsMap);
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
        List<BatchPostlendingPaymentSplitVo> batchPostlendingPaymentSplitVoList = leaseAllinpaySplitMapper.findBatchSplitDual(paramsMap);
        return batchPostlendingPaymentSplitVoList;
    }

    @Override
    public BatchPostlendingPaymentSplitVo selectDualSinglePostlendingPaymentSplit(Long id) throws GMException {
        BatchPostlendingPaymentSplitVo batchPostlendingPaymentSplitVo = leaseAllinpaySplitMapper.selectDualSinglePostlendingPaymentSplit(id);
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
        int row = leaseAllinpaySplitMapper.batchUpdateByContract(list);
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
        List<FindQueryTradeNewSplitVo> leaseAllinpaySplitList = leaseAllinpaySplitMapper.findQueryTradeNewSplit(paramsMap);
        return leaseAllinpaySplitList;
    }

    /**
     * 处理拆分明细状态、挂起
     *
     * @param paramsMap
     * @return
     */
    @Override
    public int changeIsOverTime(Map<String, Object> paramsMap) {
        int row = leaseAllinpaySplitMapper.changeIsOverTime(paramsMap);
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
        int row = leaseAllinpaySplitMapper.updateByContractId(leaseAllinpaySplit);
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
        int row = leaseAllinpaySplitMapper.updateRepaymentId(paramsMap);
        return row;
    }
}
