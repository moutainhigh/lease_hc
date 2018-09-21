package com.hc.lease.order.service.api;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.order.model.LeaseSchemeRepaymentStatus;
import com.hc.lease.order.vo.FindByPlateNumberAndRepaymentDateVo;
import com.hc.lease.order.vo.FindQueryTradeNewVo;

import java.util.List;
import java.util.Map;

/**
 * 月供的状态、滞纳金的状态、挂靠费的状态、提前还款的状态、尾付的状态，一个合同的某一期对应的这几种款项只有一条记录，可能每一种款项会操作多次扣款，每次操作的状态都更新Service
 *
 * @author Tong
 * @version 2017-08-17
 */

public interface LeaseSchemeRepaymentStatusService extends BaseService<LeaseSchemeRepaymentStatus> {

    /**
     * 查询某个合同某一期的某种款项的数据
     *
     * @param paramsMap
     * @return
     */
    LeaseSchemeRepaymentStatus findByType(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 需要轮询通联 的 交易流水/状态为扣款中
     *
     * @param paramsMap
     * @return
     */
    List<FindQueryTradeNewVo> findQueryTradeNew(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 批量更新
     *
     * @param list
     * @return
     */
    int batchUpdateByContract(List<LeaseSchemeRepaymentStatus> list, DubboTreaceParames dubboTreaceParames);

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
    LeaseSchemeRepaymentStatus selectByContract(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 合同是否还款完毕
     *
     * @param paramsMap
     * @return
     */
    Boolean findByContractidAndStatus(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    void updateByRepaymentId(LeaseSchemeRepaymentStatus leaseSchemeRepaymentStatus);

    boolean updateByContractIdAndType(Map<String, Object> params);

    /**
     * 定时轮询通联超额拆分交易结果 批量更新
     *
     * @param leaseSchemeRepaymentStatusList
     * @return
     */
    int batchUpdateBySplitCheck(List<LeaseSchemeRepaymentStatus> leaseSchemeRepaymentStatusList);

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
