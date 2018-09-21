package com.hc.lease.supplier.adapter.api;

import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.supplier.model.LeaseScheme;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.vo.LeaseSchemePackageVo;

import java.util.Map;

/**
 * 融租方案Adapter
 * @author Qiang
 * @version 2017-05-08
 */

public interface LeaseSchemeAdapter extends BaseAdapter<LeaseScheme> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

   ResultHashMap insertSelectives(LeaseSchemePackageVo leaseSchemePackageVo)throws GMException;


    int updateByPrimaryKeySelectives(LeaseSchemePackageVo leaseSchemePackageVo)throws GMException ;
}
