package com.hc.lease.supplier.service.api;

import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.supplier.model.LeaseScheme;

import java.util.List;
import java.util.Map;

/**
* 融租方案Service
* @author Qiang
* @version 2017-05-08
*/

public interface LeaseSchemeService extends BaseService<LeaseScheme> {

    List<LeaseScheme> findAllNoPage();

    List<LeaseScheme> findByName(Map params);
}
