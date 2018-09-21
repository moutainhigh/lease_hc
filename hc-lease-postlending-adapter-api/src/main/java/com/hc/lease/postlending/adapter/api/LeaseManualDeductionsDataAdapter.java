package com.hc.lease.postlending.adapter.api;

import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.excel.poi.vo.ManualDeductionsDataTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.postlending.model.LeaseManualDeductionsData;
import com.hc.lease.postlending.vo.ExportManualDeductionsCheckExcelVo;
import com.hc.lease.postlending.vo.FindNeedPayVo;
import com.hc.lease.postlending.vo.FindQueryTradeVo;
import com.hc.lease.postlending.vo.ManualDeductionsDataVo;

import java.util.List;
import java.util.Map;

/**
 * 手动扣款提交的数据Adapter
 *
 * @author Tong
 * @version 2018-07-09
 */

public interface LeaseManualDeductionsDataAdapter extends BaseAdapter<LeaseManualDeductionsData> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 手动扣款/新增(Excel上传)
     *
     * @param manualDeductionsDataTemplateList
     * @param userSession
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    ResultHashMap importManualDeductions(List<ManualDeductionsDataTemplate> manualDeductionsDataTemplateList, UserSession userSession, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 手动扣款/重新上传
     *
     * @param manualDeductionsDataTemplateList
     * @param userSession
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    ResultHashMap importManualDeductionsAgain(List<ManualDeductionsDataTemplate> manualDeductionsDataTemplateList, Long statistId, UserSession userSession, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 可以扣款的数据
     *
     * @param paramsMap
     * @return
     */
    List<FindNeedPayVo> findNeedPay(Map<String, Object> paramsMap) throws GMException;

    /**
     * 处理导入的数据的扣款
     *
     * @param leaseManualDeductionsDataList
     * @param dubboTreaceParames
     * @return
     * @throws GMException
     */
    ResultHashMap dualImportManualDeductionsPay(List<FindNeedPayVo> leaseManualDeductionsDataList, Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames,UserSession userSession) throws GMException;

    /**
     * 需要轮询通联手动扣款
     *
     * @param paramsMap
     * @return
     */
    List<FindQueryTradeVo> findQueryTrade(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException;

    /**
     * 下载核对
     *
     * @param paramsMap
     * @return
     */
    List<ExportManualDeductionsCheckExcelVo> exportManualDeductionsCheckExcel(Map<String, Object> paramsMap) throws GMException;

    /**
     * 下载结果
     *
     * @param paramsMap
     * @return
     */
    List<ExportManualDeductionsCheckExcelVo> exportManualDeductionsPaymentResultExcel(Map<String, Object> paramsMap) throws GMException;

    /**
     * 手动扣款统计主键id 删除
     *
     * @param statistId
     * @return
     */
    int deleteByStatistId(Long statistId);

}
