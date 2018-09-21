package com.hc.lease.postlending.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.model.LeaseAllinpayLog;
import com.hc.lease.postlending.vo.ContractAllinpayLogVo;

import java.util.List;
import java.util.Map;

/**
 * 通联代收流水
 */
public interface LeaseAllinpayLogMapper extends BaseDao<LeaseAllinpayLog> {

    /**
     * 根据 通联 轮询回来的处理结果
     * 更新 代收流水 状态
     *
     * @param leaseAllinpayLog
     * @return
     * @throws GMException
     */
    int updateByReqSn(LeaseAllinpayLog leaseAllinpayLog) throws GMException;

    /**
     * 查询 单笔/批扣 明细
     *
     * @param paramsMap
     * @return
     */
    List<ContractAllinpayLogVo> paymentLogDetail(Map<String, Object> paramsMap);

    /**
     * @param paramsMap
     * @return
     */
    LeaseAllinpayLog findByReqSn(Map<String, Object> paramsMap);

    /**
     * 批扣数据用城市统计/查看统计
     *
     * @param paramsMap
     * @return
     */
    List<Map<String, Object>> allinpayBatchStatisticsByCity(Map<String, Object> paramsMap);

    /**
     * 查看统计/总计
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> allinpayBatchStatistics(Map<String, Object> paramsMap);

    /**
     * 查询 单笔/批扣 明细
     *
     * @param paramsMap
     * @return
     */
    List<ContractAllinpayLogVo> findByContractId(Map<String, Object> paramsMap);

    /**
     * @param contractId
     * @return
     */
    int deleteByContractId(Long contractId);

    /**
     * 修改合同 则 跟着更新 支付流水
     *
     * @param leaseAllinpayLog
     * @return
     * @throws GMException
     */
    int updateByContractId(LeaseAllinpayLog leaseAllinpayLog) throws GMException;

    List<ContractAllinpayLogVo> exportAllinpayLog(Map<String, Object> paramsMap);
}