package com.hc.lease.order.service.api;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.model.LeaseSchemeRepayment;
import com.hc.lease.order.vo.*;

import java.util.List;
import java.util.Map;

/**
 * 融租合同-还款Service
 *
 * @author Qiang
 * @version 2017-05-23
 */

public interface LeaseSchemeRepaymentService extends BaseService<LeaseSchemeRepayment> {

    void deleteByContractId(Long id);

    /**
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<LeaseSchemeRepayment> selectByContractId(Map<String, Object> paramsMap) throws GMException;

    /**
     * 租金支付表 / 融租合同-月租还款计划明细
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<SelectByContractIdVo> findByContractId(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 融租合同的 当月月供、过期未付款的月供
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<FindMonthVo> findMonth(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 融租合同的 当月月供
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<FindMonthVo> findCurrentMonth(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 检测 融租合同的 已逾期，未扣款的月租
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<LeaseSchemeRepayment> checkOverdue(Map<String, Object> paramsMap) throws GMException;

    /**
     * 融租合同的 当月已逾期的月租还款记录
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<FindOverdueVo> findCurrentOverdue(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 融租合同的 已逾期的还款记录
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<FindOverdueVo> findOverdue(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 批量更新
     *
     * @param leaseSchemeRepaymentList
     */
    void batchUpdate(List<LeaseSchemeRepayment> leaseSchemeRepaymentList, DubboTreaceParames dubboTreaceParames);

    /**
     * @param paramsMap
     * @return
     */
    LeaseSchemeRepayment selectContract(Map<String, Object> paramsMap);

    /**
     * 批量扣款 查询所有月供/挂靠
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    PageInfo<BatchPostlendingPaymentVo> findBatchPostlendingPayment(int pageNum, int pageSize, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 提交批扣查询需要处理的月供、滞纳金，查询扣款方式支持代扣的数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<BatchPostlendingPaymentVo> findBatchPostlendingPaymentDual(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 查询所有月供 批量扣款 统计
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> findAllMonthStatistics(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 根据分公司统计所有月供 批量扣款
     *
     * @param paramsMap
     * @return
     */
    List<FindAllMonthStaticsticsByCityVo> findAllMonthStatisticsByCity(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 批量补录的数据/月供
     *
     * @param paramsMap
     * @return
     */
    List<Map<String, Object>> findRepaymentExcept(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames);

    /**
     * 查询某个扣款日的合同还款明细数据/月租、滞纳金、尾款
     *
     * @param list
     * @return
     * @throws GMException
     */
    List<FindByRepaymentDateVo> findByRepaymentDate(List<String> list, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 查询还款明细数据/月租、滞纳金、挂靠费
     *
     * @param list
     * @return
     * @throws GMException
     */
    List<FindByRepaymentDateVo> findByRepaymentId(List<Long> list, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 还款日7天前、3天前 的还款数据
     *
     * @param paramsMap
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    List<LeaseSchemeRepayment> advanceSendRepaymentSms(Map<String, String> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    LeaseSchemeRepayment findByContractIdAndPeriod(Map<String, Object> params);


    boolean updateTotalByContractId(Map<String, Object> params);

    List<BatchPostlendingPaymentVo> batchPostlendingPaymentNoPage(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 备份数据
     *
     * @param paramsMap
     * @return
     */
    int backData(Map<String, Object> paramsMap);

}
