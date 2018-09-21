package com.hc.lease.supplier.service.api;

import com.hc.lease.supplier.model.LeaseAgents;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.supplier.vo.FindPageVo;

import java.util.List;
import java.util.Map;

/**
 * 门店Service
 *
 * @author Qiang
 * @version 2017-12-15
 */

public interface LeaseAgentsService extends BaseService<LeaseAgents> {

    void deleteBySecondaryId(Long id);

    List<LeaseAgents> findByName(Map<String, Object> paramsMap);

    int disableByPrimaryKey(Map<String, Object> paramsMap);

    void updateSort(LeaseAgents leaseAgents);

    List<FindPageVo> findAllNoPage(Object o);

    Integer findMaxNumber();

    List<String> findExportExcelModel(Map param);
}
