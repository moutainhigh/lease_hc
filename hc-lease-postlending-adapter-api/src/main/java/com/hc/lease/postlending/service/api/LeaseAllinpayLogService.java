package com.hc.lease.postlending.service.api;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.model.LeaseAllinpayLog;
import com.hc.lease.postlending.vo.ContractAllinpayLogVo;

import java.util.List;
import java.util.Map;

/**
 * 通联代收流水Service
 *
 * @author Tong
 * @version 2017-06-09
 */

public interface LeaseAllinpayLogService extends BaseService<LeaseAllinpayLog> {

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
     * 通联日志
     * 单笔
     * 查看明细
     * 因为每笔款不是即时出结果，所以代收流水的状态不是最终状态，轮询流水的状态是最终状态
     *
     * @param paramsMap
     * @return
     */
    List<ContractAllinpayLogVo> paymentLogDetail(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * @param paramsMap
     * @return
     */
    LeaseAllinpayLog findByReqSn(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 批扣数据用城市统计
     *
     * @param paramsMap
     * @return
     */
    List<Map<String, Object>> allinpayBatchStatisticsByCity(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 查看统计/总计
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> allinpayBatchStatistics(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 还款历史/合同还款明细
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<ContractAllinpayLogVo> findByContractId(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

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
