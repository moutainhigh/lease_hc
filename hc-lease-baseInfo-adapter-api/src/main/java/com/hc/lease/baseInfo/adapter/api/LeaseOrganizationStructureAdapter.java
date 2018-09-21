package com.hc.lease.baseInfo.adapter.api;

import com.hc.lease.baseInfo.model.LeaseOrganizationStructure;
import com.hc.lease.baseInfo.vo.FindParentTreeVo;
import com.hc.lease.baseInfo.vo.OrganizationInserChildVo;
import com.hc.lease.baseInfo.vo.OrganizationStructureSelectByTypeVo;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;

import java.util.List;
import java.util.Map;

/**
 * 组织结构Adapter
 *
 * @author Tong
 * @version 2018-04-12
 */

public interface LeaseOrganizationStructureAdapter extends BaseAdapter<LeaseOrganizationStructure> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 新增或者修改需要的上级单位的数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<FindParentTreeVo> findParentTree(Map<String, Object> paramsMap) throws GMException;

    /**
     * 新增下级
     *
     * @param organizationInserChildVo
     * @return
     * @throws GMException
     */
    ResultHashMap insertChildLevel(OrganizationInserChildVo organizationInserChildVo, UserSession userSession) throws GMException;

    /**
     * 新增同级
     *
     * @param organizationInserChildVo
     * @return
     * @throws GMException
     */
    ResultHashMap insertSameLevel(OrganizationInserChildVo organizationInserChildVo, UserSession userSession) throws GMException;

    /**
     * 检测是否有下级
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
     * @param paramsMap
     * @return
     * @throws GMException
     */
    List<OrganizationStructureSelectByTypeVo> selectByType(List list) throws GMException;

}
