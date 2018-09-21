package com.hc.lease.common.core.dao;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;


/**
 * @param <T>
 * @描述: 数据访问层基础支撑接口
 * @作者: Tong
 * @创建时间: 2017-4-17
 */
public interface BaseService<T> {

    /**
     * 根据实体对象新增记录.
     *
     * @param entity .
     * @return id .
     */
    T insert(T entity) throws GMException;

    /**
     * 根据实体对象新增记录.
     *
     * @param entity .
     * @return id .
     */
    T insertSelective(T entity) throws GMException;

    /**
     * 批量保存对象.
     *
     * @param list .
     * @return id .
     */
    int insertList(List<T> list) throws GMException;

    /**
     * 更新实体对应的记录.
     *
     * @param entity .
     * @return
     */
    int updateByPrimaryKey(T entity) throws GMException;

    /**
     * 更新实体对应的记录.
     *
     * @param entity .
     * @return
     */
    int updateByPrimaryKeySelective(T entity) throws GMException;

    /**
     * 根据ID查找记录.
     *
     * @param id .
     * @return entity .
     */
    T selectByPrimaryKey(Long id) throws GMException;

    /**
     * 根据ID删除记录.
     *
     * @param id .
     * @return
     */
    int deleteByPrimaryKey(Long id) throws GMException;

    /**
     * 根据ID删除记录.批量删除
     *
     * @param ids .
     * @return
     */
    int deleteBatchById(List<Long> ids) throws GMException;

    /**
     * 分页
     *
     * @return
     */
    PageInfo<T> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException;

    /**
     * 所有数据列表
     *
     * @return
     */
    List<T> findAll(Map<String, Object> paramsMap) throws GMException;

}
