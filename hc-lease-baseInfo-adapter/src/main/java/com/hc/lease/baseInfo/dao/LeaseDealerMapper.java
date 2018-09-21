package com.hc.lease.baseInfo.dao;

import com.hc.lease.baseInfo.model.LeaseDealer;
import com.hc.lease.common.core.dao.BaseDao;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 经销商
 */
public interface LeaseDealerMapper extends BaseDao<LeaseDealer> {

    /**
     * 初始化编辑页面的参数
     *
     * @return
     */
    List<LeaseDealer> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 根据ID删除记录.批量删除
     *
     * @param ids .
     * @return
     */
    int deleteBatchById(List<Long> ids) throws GMException;

    /**
     * 根据名称检测数据是否存在
     *
     * @return
     */
    List<LeaseDealer> findByName(Map params) throws GMException;

    /**
     * 根据父级主键id检测数据是否存在
     *
     * @param id
     * @return
     * @throws GMException
     */
    List<LeaseDealer> selectByParentId(Long id) throws GMException;

    /**
     * 根据级别查询
     * @param i
     * @return
     */
    List<LeaseDealer> selectByGrade(int i);

    int disableByPrimaryKey(Map<String, Object> params)throws GMException;
}