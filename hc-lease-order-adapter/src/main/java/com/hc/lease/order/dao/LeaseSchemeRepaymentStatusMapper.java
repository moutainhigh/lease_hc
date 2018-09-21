package com.hc.lease.order.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.order.model.LeaseSchemeRepaymentStatus;
import com.hc.lease.order.vo.FindByPlateNumberAndRepaymentDateVo;
import com.hc.lease.order.vo.FindQueryTradeNewVo;

import java.util.List;
import java.util.Map;

public interface LeaseSchemeRepaymentStatusMapper extends BaseDao<LeaseSchemeRepaymentStatus> {

    /**
     * 查询某个合同某一期的某种款项的数据
     *
     * @param paramsMap
     * @return
     */
    LeaseSchemeRepaymentStatus findByType(Map<String, Object> paramsMap);

    /**
     * 需要轮询通联 的 交易流水/状态为扣款中
     *
     * @param paramsMap
     * @return
     */
    List<FindQueryTradeNewVo> findQueryTradeNew(Map<String, Object> paramsMap);

    /**
     * 批量更新
     *
     * @param list
     * @return
     */
    int batchUpdateByContract(List<LeaseSchemeRepaymentStatus> list);

    /**
     * @param contractId
     * @return
     */
    int deleteByContractId(Long contractId);

    /**
     * 查询月供、滞纳金的支付状态
     *
     * @param paramsMap
     * @return
     */
    LeaseSchemeRepaymentStatus selectByContract(Map<String, Object> paramsMap);

    /**
     * 合同是否还款完毕
     *
     * @param paramsMap
     * @return
     */
    Boolean findByContractidAndStatus(Map<String, Object> paramsMap);

    void updateByRepaymentId(LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus);

    boolean updateByContractIdAndType(Map<String, Object> params);

    int batchUpdateBySplitCheck(List<LeaseSchemeRepaymentStatus> list);

    /**
     * 车牌号和扣款日期查询还款计划
     *
     * @param paramsMap
     * @return
     */
    FindByPlateNumberAndRepaymentDateVo findByPlateNumberAndRepaymentDate(Map<String, Object> paramsMap);

    /**
     * 备份数据
     *
     * @param paramsMap
     * @return
     */
    int backData(Map<String, Object> paramsMap);

    /**
     * 合同是否存在还款中的还款计划
     *
     * @param paramsMap
     * @return
     */
    Boolean findContractPayStatusByContractId(Map<String, Object> paramsMap);

}