package com.hc.lease.baseInfo.service;

import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 公共处理Service
 *
 * @author Tong
 * @version 2017-04-26
 */

public interface LeaseCommonService {

    /**
     * 插入使用和被使用的数据
     *
     * @param useId
     * @param useName
     * @param usedId
     * @param usedName
     * @param useType
     * @param usedType
     * @return
     * @throws GMException
     */
    public int insertUseUsed(Long useId, String useName, Long usedId, String usedName, String useType, String usedType) throws GMException;

    /**
     * 查找被使用者
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<LeaseUseUsed> selectByUsed(Map<String, Object> paramsMap) throws GMException;

    Boolean checkUsed(Long used, String usedType);

    /**
     * 删除使用和被使用的数据
     *
     * @param useId
     * @param usedId
     * @param useType
     * @param usedType
     * @return
     * @throws GMException
     */
    int delUseUsed(Long useId, Long usedId, String useType, String usedType) throws GMException;

}
