package com.hc.lease.baseInfo.service.api;

import com.hc.lease.baseInfo.model.LeaseOrganizationStructure;
import com.hc.lease.baseInfo.vo.FindParentTreeVo;
import com.hc.lease.baseInfo.vo.OrganizationStructureSelectByTypeVo;
import com.hc.lease.common.core.dao.BaseService;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 组织结构Service
 *
 * @author Tong
 * @version 2018-04-12
 */

public interface LeaseOrganizationStructureService extends BaseService<LeaseOrganizationStructure> {
    /**
     * 新增或者修改需要的上级单位的数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<FindParentTreeVo> findParentTree(Map<String, Object> paramsMap) throws GMException;

    /**
     * 新增或者修改需要的上级单位的数据
     *
     * @param parentId
     * @return
     * @throws GMException
     */
    Boolean checkHaveChild(Long parentId) throws GMException;

    /**
     * 检测是否默认/默认的数据不可删除
     *
     * @param id
     * @return
     * @throws GMException
     */
    Boolean checkIsDefault(Long id) throws GMException;

    /**
     * 根据父级查询数据
     *
     * @param parentId
     * @return
     * @throws GMException
     */
    List<LeaseOrganizationStructure> selectByParentId(Long parentId) throws GMException;

    /**
     * 修改所有子级状态
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    int updateChildsStatus(Map<String, Object> paramsMap) throws GMException;

    /**
     * 查找同一子级的排序是否被使用
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    Boolean checkSameLevelSort(Map<String, Object> paramsMap) throws GMException;

    /**
     * 查找同一子级的最大排序
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    Integer selectSameLevelMaxSort(Map<String, Object> paramsMap) throws GMException;

    /**
     * 用类型查询
     *
     * @param list
     * @return
     * @throws GMException
     */
    List<OrganizationStructureSelectByTypeVo> selectByType(List list) throws GMException;

}
