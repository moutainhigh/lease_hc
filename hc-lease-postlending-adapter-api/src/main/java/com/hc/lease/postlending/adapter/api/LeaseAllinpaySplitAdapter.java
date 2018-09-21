package com.hc.lease.postlending.adapter.api;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.model.LeaseAllinpaySplit;
import com.hc.lease.postlending.vo.AllinpaySplitFindPageVo;
import com.hc.lease.postlending.vo.BatchPostlendingPaymentSplitVo;
import com.hc.lease.postlending.vo.FindQueryTradeNewSplitVo;

import java.util.List;
import java.util.Map;

/**
 * 通联支付超额拆分交易明细Adapter
 *
 * @author Tong
 * @version 2018-06-19
 */

public interface LeaseAllinpaySplitAdapter extends BaseAdapter<LeaseAllinpaySplit> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 全部数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<AllinpaySplitFindPageVo> findAllSplit(Map<String, Object> paramsMap) throws GMException;

    /**
     * 分页
     *
     * @return
     */
    PageInfo<AllinpaySplitFindPageVo> findPageSplit(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException;

    /**
     * 待扣->挂起
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    int changeStatusHangUpOrDown(Map<String, Object> paramsMap) throws GMException;

    /**
     * 批量协议支付
     * 通联支付拆单
     * 批量协议支付 通联支付拆单 查询需要处理的数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<BatchPostlendingPaymentSplitVo> findBatchSplitDual(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 用主键查询
     *
     * @param id
     * @return
     * @throws GMException
     */
    BatchPostlendingPaymentSplitVo selectDualSinglePostlendingPaymentSplit(Long id) throws GMException;

    /**
     * 批量更新
     *
     * @param list
     * @return
     */
    int batchUpdateByContract(List<LeaseAllinpaySplit> list, DubboTreaceParames dubboTreaceParames);

    /**
     * 需要轮询通联超额拆分 的 交易流水/状态为扣款中
     *
     * @param paramsMap
     * @return
     */
    List<FindQueryTradeNewSplitVo> findQueryTradeNewSplit(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 处理拆分明细状态、挂起
     *
     * @param paramsMap
     * @return
     */
    int changeIsOverTime(Map<String, Object> paramsMap);

    /**
     * 修改合同则修改合同的修改状态
     * 0:合同未作修改 ; 1:合同已作修改
     *
     * @param leaseAllinpaySplit
     * @return
     */
    int updateByContractId(LeaseAllinpaySplit leaseAllinpaySplit);

    /**
     * 合同修改同时修改 拆单的还款计划主键id,
     * 同时修改 lease_allinpay_split_query_log、lease_allinpay_split_log、lease_allinpay_split、lease_allinpay_split_connect
     *
     * @return
     */
    int updateRepaymentId(Map<String, Object> paramsMap) throws GMException;

}
