package com.hc.lease.supplier.adapter.api;

import com.hc.lease.common.core.excel.poi.vo.LeaseInsuranceCompanyExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseInsuranceCompanyTemplate;
import com.hc.lease.supplier.model.LeaseInsuranceCompany;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.vo.LeaseInsuranceCompanys;


import java.util.List;
import java.util.Map;

/**
 * 保险公司Adapter
 * @author Qiang
 * @version 2017-05-08
 */

public interface LeaseInsuranceCompanyAdapter extends BaseAdapter<LeaseInsuranceCompany> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    int disableByPrimaryKey(Map<String, Object> params)throws GMException;

    int updateSort(LeaseInsuranceCompanys leaseInsuranceCompanys);

    List<String> findAllInsuranceCompanyNames();

    List<LeaseInsuranceCompany> findAllNoPage(Map param);

    LeaseInsuranceCompanyExcelBackInfo importExcelInsuranceCompany(List<LeaseInsuranceCompanyTemplate> leaseInsuranceCompanyTemplates) throws GMException;
}
