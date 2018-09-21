package com.hc.lease.postlending.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.postlending.model.LeaseManualDeductionsData;
import com.hc.lease.postlending.vo.ExportManualDeductionsCheckExcelVo;
import com.hc.lease.postlending.vo.FindNeedPayVo;
import com.hc.lease.postlending.vo.FindQueryTradeVo;

import java.util.List;
import java.util.Map;

public interface LeaseManualDeductionsDataMapper extends BaseDao<LeaseManualDeductionsData> {

    /**
     * 可以扣款的数据
     *
     * @param paramsMap
     * @return
     */
    List<FindNeedPayVo> findNeedPay(Map<String, Object> paramsMap);

    /**
     * 需要轮询通联手动扣款
     *
     * @param paramsMap
     * @return
     */
    List<FindQueryTradeVo> findQueryTrade(Map<String, Object> paramsMap);

    /**
     * 下载核对、下载结果
     *
     * @param paramsMap
     * @return
     */
    List<ExportManualDeductionsCheckExcelVo> exportManualDeductionsCheckExcel(Map<String, Object> paramsMap);

    /**
     * 手动扣款统计主键id 删除
     *
     * @param statistId
     * @return
     */
    int deleteByStatistId(Long statistId);

}