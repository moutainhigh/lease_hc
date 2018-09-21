package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseInsuranceType;

import java.util.List;
import java.util.Map;

public interface LeaseInsuranceTypeMapper extends BaseDao<LeaseInsuranceType> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    Map<String,Object> insertViewParames(Map<String, Object> paramsMap);

    List<LeaseInsuranceType> findByInsuranceCompanyId(List<Long> ids);

    int disableByPrimaryKey(Map<String, Object> params);

    void updateSort(Map<String, Object> paramsMap);

    int updateDefaultSelected(Map<String, Object> paramsMap);

    Integer findMaxNumber();

    List<LeaseInsuranceType> findByName(Map params);
}