package com.hc.lease.supplier.service;

import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeaseInsuranceType;
import com.hc.lease.common.core.dao.BaseService;

import java.util.List;
import java.util.Map;

/**
* 险种Service
* @author Qiang
* @version 2017-05-08
*/

public interface LeaseInsuranceTypeService extends BaseService<LeaseInsuranceType> {


    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
   Map<String,Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;


    List<LeaseInsuranceType> findByInsuranceCompanyId(List<Long> ids);
}
