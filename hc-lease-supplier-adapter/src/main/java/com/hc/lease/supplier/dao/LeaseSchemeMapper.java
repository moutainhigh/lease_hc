package com.hc.lease.supplier.dao;

import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.supplier.model.LeaseScheme;

import java.util.List;
import java.util.Map;

public interface LeaseSchemeMapper extends BaseDao<LeaseScheme> {

    List<LeaseScheme> findByName(Map params);
}