package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseAgents;
import com.hc.lease.supplier.vo.FindPageVo;

import java.util.List;
import java.util.Map;

public interface LeaseAgentsMapper extends BaseDao<LeaseAgents> {

    void deleteBySecondaryId(Long id);

    List<LeaseAgents> findByName(Map<String, Object> paramsMap);

    int disableByPrimaryKey(Map<String, Object> paramsMap);

    void updateSort(Map<String, Object> paramsMap);

    Integer findMaxNumber();

    List<FindPageVo> findAllNoPage(Map<String, Object> paramsMap);

    List<String> findExportExcelModel(Map param);
}