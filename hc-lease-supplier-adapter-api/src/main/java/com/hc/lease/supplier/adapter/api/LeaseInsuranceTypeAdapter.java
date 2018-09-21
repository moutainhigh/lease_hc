package com.hc.lease.supplier.adapter.api;

import com.hc.lease.common.core.excel.poi.vo.LeaseInsuranceTypeExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.LeaseInsuranceTypeTemplate;
import com.hc.lease.supplier.model.LeaseInsuranceType;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.vo.LeaseInsuranceTypes;

import java.util.List;
import java.util.Map;

/**
 * 险种Adapter
 * @author Qiang
 * @version 2017-05-08
 */

public interface LeaseInsuranceTypeAdapter extends BaseAdapter<LeaseInsuranceType> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    int disableByPrimaryKey(Map<String, Object> params) throws GMException;

    int updateSort(LeaseInsuranceTypes leaseInsuranceTypes);

    int updateDefaultSelected(Map<String, Object> paramsMap);

    List<LeaseInsuranceType> findAllNoPage(Map param);

    LeaseInsuranceTypeExcelBackInfo importExcelInsuranceType(List<LeaseInsuranceTypeTemplate> leaseInsuranceTypeTemplates) throws GMException;
}
