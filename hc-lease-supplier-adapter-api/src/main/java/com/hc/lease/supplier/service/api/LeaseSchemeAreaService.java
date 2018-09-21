package com.hc.lease.supplier.service.api;

import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.supplier.model.LeaseSchemeArea;

/**
* 融租方案-适用地区Service
* @author Qiang
* @version 2017-05-08
*/

public interface LeaseSchemeAreaService extends BaseService<LeaseSchemeArea> {


    void deleteBySchemeId(Long id);
}
