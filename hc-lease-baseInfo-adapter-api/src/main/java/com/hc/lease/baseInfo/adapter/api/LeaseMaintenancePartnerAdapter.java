package com.hc.lease.baseInfo.adapter.api;

import com.hc.lease.baseInfo.model.LeaseMaintenancePartner;
import com.hc.lease.baseInfo.vo.LeaseMaintenancePartners;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.excel.poi.vo.LeaseMaintenancePartnerExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseMaintenancePartnerTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;

import java.util.List;
import java.util.Map;

/**
 * 保养维护合作方Adapter
 *
 * @author Tong
 * @version 2017-04-17
 */

public interface LeaseMaintenancePartnerAdapter extends BaseAdapter<LeaseMaintenancePartner> {
    /**
     * 添加或者修改 需要的初始化参数
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    ResultHashMap insertSelective(LeaseMaintenancePartner leaseMaintenancePartner, UserSession userSession)throws GMException;

    int updateByPrimaryKeySelective(LeaseMaintenancePartner leaseMaintenancePartner, UserSession userSession)throws GMException;

    int disableByPrimaryKey(Map<String, Object> params)throws GMException;

    List<LeaseMaintenancePartner> findAllNoPage(Map param);

    LeaseMaintenancePartnerExcelBackInfo importExcelBranchCompany(List<LeaseMaintenancePartnerTemplate> leaseMaintenancePartnerTemplates) throws GMException;

    int updateSort(LeaseMaintenancePartners leaseMaintenancePartners);
}
