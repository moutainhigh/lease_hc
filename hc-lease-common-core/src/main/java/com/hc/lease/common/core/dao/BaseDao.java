package com.hc.lease.common.core.dao;

import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;


/**
 * @param <T>
 * @描述: 数据访问层基础支撑接口
 * @作者: Tong
 * @创建时间: 2017-4-17
 */
public interface BaseDao<T> {

    /**
     * 根据实体对象新增记录.
     *
     * @param entity .
     * @return id .
     */
    int insert(T entity);

    /**
     * 根据实体对象新增记录.
     *
     * @param entity .
     * @return id .
     */
    int insertSelective(T entity);

    /**
     * 批量保存对象.
     *
     * @param list .
     * @return id .
     */
    int insertList(List<T> list);

    /**
     * 批量保存对象.
     *
     * @param list .
     * @return id .
     */
    int insertSelectiveList(List<T> list);

    /**
     * 更新实体对应的记录.
     *
     * @param entity .
     * @return
     */
    int updateByPrimaryKey(T entity);

    /**
     * 更新实体对应的记录.
     *
     * @param entity .
     * @return
     */
    int updateByPrimaryKeySelective(T entity);

    /**
     * 批量更新对象.
     *
     * @param list .
     * @return int .
     */
    int updateByPrimaryKeyList(List<T> list);

    /**
     * 批量更新对象.
     *
     * @param list .
     * @return int .
     */
    int updateByPrimaryKeySelectiveList(List<T> list);

    /**
     * 根据ID查找记录.
     *
     * @param id .
     * @return entity .
     */
    T selectByPrimaryKey(Long id);

    /**
     * 根据ID删除记录.
     *
     * @param id .
     * @return
     */
    int deleteByPrimaryKey(Long id);

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
    List<T> findPage(Map<String, Object> paramsMap);

    /**
     * @return
     */
    List<T> findAll(Map<String, Object> paramsMap);


}
