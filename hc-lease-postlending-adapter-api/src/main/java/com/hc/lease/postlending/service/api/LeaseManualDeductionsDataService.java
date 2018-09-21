package com.hc.lease.postlending.service.api;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.model.LeaseManualDeductionsData;
import com.hc.lease.postlending.vo.ExportManualDeductionsCheckExcelVo;
import com.hc.lease.postlending.vo.FindNeedPayVo;
import com.hc.lease.postlending.vo.FindQueryTradeVo;

import java.util.List;
import java.util.Map;

/**
 * 手动扣款提交的数据Service
 *
 * @author Tong
 * @version 2018-07-09
 */

public interface LeaseManualDeductionsDataService extends BaseService<LeaseManualDeductionsData> {

    /**
     * 可以扣款的数据
     *
     * @param paramsMap
     * @return
     */
    List<FindNeedPayVo> findNeedPay(Map<String, Object> paramsMap) throws GMException;

    /**
     * 需要轮询通联手动扣款
     *
     * @param paramsMap
     * @return
     */
    List<FindQueryTradeVo> findQueryTrade(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 下载核对、下载结果
     *
     * @param paramsMap
     * @return
     */
    List<ExportManualDeductionsCheckExcelVo> exportManualDeductionsCheckExcel(Map<String, Object> paramsMap) throws GMException;

    /**
     * 手动扣款统计主键id 删除
     *
     * @param statistId
     * @return
     */
    int deleteByStatistId(Long statistId);

}
