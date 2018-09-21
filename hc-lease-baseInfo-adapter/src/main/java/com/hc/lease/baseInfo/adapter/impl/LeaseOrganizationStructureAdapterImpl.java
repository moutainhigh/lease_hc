package com.hc.lease.baseInfo.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.adapter.api.LeaseOrganizationStructureAdapter;
import com.hc.lease.baseInfo.model.LeaseOrganizationStructure;
import com.hc.lease.baseInfo.service.api.LeaseOrganizationStructureService;
import com.hc.lease.baseInfo.vo.FindParentTreeVo;
import com.hc.lease.baseInfo.vo.OrganizationInserChildVo;
import com.hc.lease.baseInfo.vo.OrganizationStructureSelectByTypeVo;
import com.hc.lease.common.core.constant.OrganizationType;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.user.service.api.LeaseUserService;
import com.hc.lease.user.vo.FindAllUserVo;
import hc.lease.common.util.ListUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 组织结构AdapterImpl
 *
 * @author Tong
 * @version 2018-04-12
 */
@Service("leaseOrganizationStructureAdapter")
public class LeaseOrganizationStructureAdapterImpl implements LeaseOrganizationStructureAdapter {

    @Autowired
    private LeaseOrganizationStructureService leaseOrganizationStructureService;

    @Autowired
    private LeaseUserService leaseUserService;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        //组织结构用到的用户数据
        List<FindAllUserVo> leaseUserList = leaseUserService.findOrganizationUser(null);

        //新增或者修改需要的上级单位的数据
        //加载上级单位需要知道当前的组织是什么类型，如果是公司则上级单位只能是公司，如果是部门则上级单位只能是公司或部门，如果是组则上级单位只能是部门或组
        List<FindParentTreeVo> findParentTreeVoList = leaseOrganizationStructureService.findParentTree(paramsMap);
        Map<String, Object> map = Maps.newHashMap();
        map.put("parentTreeVoList", findParentTreeVoList);
        map.put("userList", leaseUserList);
        return map;
    }

    /**
     * 根据ID删除记录
     *
     * @param id .
     * @return
     * @throws GMException
     */
    public int deleteByPrimaryKey(Long id) throws GMException {

        //检测是否默认/默认的数据不可删除
        Boolean isDefault = leaseOrganizationStructureService.checkIsDefault(id);
        if (isDefault) throw new GMException(GMExceptionConstant.ORGANIZATION_IS_DEFAULT_ERROR);
        //检测是否存在下级，不可删除
        Boolean isHaveChild = leaseOrganizationStructureService.checkHaveChild(id);
        if (isHaveChild) throw new GMException(GMExceptionConstant.ORGANIZATION_HAVE_CHILD_ERROR);

        int row = leaseOrganizationStructureService.deleteByPrimaryKey(id);
        return row;

    }

    /**
     * 根据ID删除记录.批量删除
     *
     * @param ids .
     * @return
     * @throws GMException
     */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseOrganizationStructureService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseOrganizationStructure record) throws GMException {
        record = leaseOrganizationStructureService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseOrganizationStructure record) throws GMException {
        record = leaseOrganizationStructureService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    /**
     * 修改
     *
     * @param record
     * @return
     * @throws GMException
     */
    public int updateByPrimaryKeySelective(LeaseOrganizationStructure record) throws GMException {

        //检测排序是否合理、是否被使用
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("level", record.getLevel());
        paramsMap.put("parentId", record.getParentId());
        paramsMap.put("sort", record.getSort());
        paramsMap.put("id", record.getId());
        Boolean checkSameLevelSort = leaseOrganizationStructureService.checkSameLevelSort(paramsMap);//查找同一子级的排序是否被使用
        if (checkSameLevelSort) {
            Integer maxSort = leaseOrganizationStructureService.selectSameLevelMaxSort(paramsMap);
            GMExceptionConstant.CHECK_SAME_LEVEL_SORT.setErrMsg("排序序号冲突,可填比" + maxSort + "大的数字");
            throw new GMException(GMExceptionConstant.CHECK_SAME_LEVEL_SORT);
        }
        //检测排序是否合理、是否被使用

        LeaseOrganizationStructure parentObj = leaseOrganizationStructureService.selectByPrimaryKey(record.getParentId());//查询父级数据
        record.setLevel(parentObj == null ? 0 : parentObj.getLevel() + 1);//修改上级 则组织的层级也要更新
        int row = leaseOrganizationStructureService.updateByPrimaryKeySelective(record);

        /*
        //状态必须跟上级相同
        LeaseOrganizationStructure leaseOrganizationStructureParent = leaseOrganizationStructureService.selectByPrimaryKey(record.getParentId());//查询父级的状态
        if (!record.getIsEnable().equals(leaseOrganizationStructureParent.getIsEnable()))
            throw new GMException(GMExceptionConstant.STATUS_ERROR);
        //状态必须跟上级相同
        */

        //修改所有子级状态
        List parentIdLit = changeChildStatus(record.getId(), null);//整理所有子级的主键id
        paramsMap.put("isEnable", record.getIsEnable());
        paramsMap.put("list", parentIdLit);
        if (parentIdLit != null && parentIdLit.size() > 0) {
            leaseOrganizationStructureService.updateChildsStatus(paramsMap);
        }
        //修改所有子级状态

        return row;
    }

    public int updateByPrimaryKey(LeaseOrganizationStructure record) throws GMException {
        int row = leaseOrganizationStructureService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseOrganizationStructure selectByPrimaryKey(Long id) throws GMException {
        LeaseOrganizationStructure leaseOrganizationStructure = leaseOrganizationStructureService.selectByPrimaryKey(id);
        return leaseOrganizationStructure;
    }

    public int insertList(List<LeaseOrganizationStructure> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseOrganizationStructure> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseOrganizationStructure> page = leaseOrganizationStructureService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseOrganizationStructure> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseOrganizationStructure> leaseOrganizationStructureList = leaseOrganizationStructureService.findAll(paramsMap);
        return leaseOrganizationStructureList;
    }

    /**
     * 新增或者修改需要的上级单位的数据
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public List<FindParentTreeVo> findParentTree(Map<String, Object> paramsMap) throws GMException {
        List<FindParentTreeVo> findParentTreeVoList = leaseOrganizationStructureService.findParentTree(paramsMap);
        return findParentTreeVoList;
    }

    /**
     * 新增下级
     *
     * @param organizationInserChildVo
     * @return
     * @throws GMException
     */
    public ResultHashMap insertChildLevel(OrganizationInserChildVo organizationInserChildVo, UserSession userSession) throws GMException {

        /*
        //状态必须跟上级相同
        LeaseOrganizationStructure leaseOrganizationStructureParent = leaseOrganizationStructureService.selectByPrimaryKey(organizationInserChildVo.getParentId());//查询父级的状态
        if (!organizationInserChildVo.getIsEnable().equals(leaseOrganizationStructureParent.getIsEnable()))
            throw new GMException(GMExceptionConstant.STATUS_ERROR);
        //状态必须跟上级相同
        */

        //检测排序是否合理、是否被使用
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("level", organizationInserChildVo.getLevel() + 1);
        paramsMap.put("parentId", organizationInserChildVo.getParentId());
        paramsMap.put("sort", organizationInserChildVo.getSort());
        Boolean checkSameLevelSort = leaseOrganizationStructureService.checkSameLevelSort(paramsMap);//查找同一子级的排序是否被使用
        if (checkSameLevelSort) {
            Integer maxSort = leaseOrganizationStructureService.selectSameLevelMaxSort(paramsMap);
            GMExceptionConstant.CHECK_SAME_LEVEL_SORT.setErrMsg("组织排序序号冲突,可填比" + maxSort + "大的数字");
            throw new GMException(GMExceptionConstant.CHECK_SAME_LEVEL_SORT);
        }
        //检测排序是否合理、是否被使用

        Date nowDate = DateTime.now().toDate();
        LeaseOrganizationStructure leaseOrganizationStructure = new LeaseOrganizationStructure();
        leaseOrganizationStructure.setIsEnable(organizationInserChildVo.getIsEnable());
        leaseOrganizationStructure.setSort(organizationInserChildVo.getSort());
        leaseOrganizationStructure.setType(organizationInserChildVo.getLevel() == null || organizationInserChildVo.getType() == null ? OrganizationType.TYPE_COMPANY.value() : organizationInserChildVo.getType());//如果没有传递类型则默认新增一级公司
        leaseOrganizationStructure.setLevel(organizationInserChildVo.getLevel() == null || organizationInserChildVo.getType() == null ? 0 : organizationInserChildVo.getLevel() + 1);//如果没有传递级别则默认新增一级公司
        leaseOrganizationStructure.setName(organizationInserChildVo.getName());
        leaseOrganizationStructure.setParentId(organizationInserChildVo.getParentId());
        leaseOrganizationStructure.setLeaderId(organizationInserChildVo.getLeaderId());
        leaseOrganizationStructure.setAssistantId(organizationInserChildVo.getAssistantId());
        leaseOrganizationStructure.setParentLeaderId(organizationInserChildVo.getParentLeaderId());
        leaseOrganizationStructure.setDeputyLeadeId(organizationInserChildVo.getDeputyLeadeId());
        leaseOrganizationStructure.setCreateTime(nowDate);
        leaseOrganizationStructure.setUpdateTime(nowDate);
        leaseOrganizationStructure.setLevel(organizationInserChildVo.getLevel() + 1);
        leaseOrganizationStructure.setIsDefault(0);
        leaseOrganizationStructure.setCreateBy(userSession.getUserId());
        leaseOrganizationStructure.setUpdateBy(userSession.getUserId());

        leaseOrganizationStructure = leaseOrganizationStructureService.insertSelective(leaseOrganizationStructure);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    /**
     * 新增同级
     *
     * @param organizationInserChildVo
     * @return
     * @throws GMException
     */
    @Override
    public ResultHashMap insertSameLevel(OrganizationInserChildVo organizationInserChildVo, UserSession userSession) throws GMException {
        Date nowDate = DateTime.now().toDate();
        LeaseOrganizationStructure leaseOrganizationStructure = new LeaseOrganizationStructure();
        leaseOrganizationStructure.setIsEnable(organizationInserChildVo.getIsEnable());
        leaseOrganizationStructure.setSort(organizationInserChildVo.getSort());
        leaseOrganizationStructure.setType(organizationInserChildVo.getLevel() == null || organizationInserChildVo.getType() == null ? OrganizationType.TYPE_COMPANY.value() : organizationInserChildVo.getType());//如果没有传递类型则默认新增一级公司
        leaseOrganizationStructure.setLevel(organizationInserChildVo.getLevel() == null || organizationInserChildVo.getType() == null ? 0 : organizationInserChildVo.getLevel());//如果没有传递级别则默认新增一级公司
        leaseOrganizationStructure.setName(organizationInserChildVo.getName());
        leaseOrganizationStructure.setParentId(organizationInserChildVo.getParentId() == null ? 0 : organizationInserChildVo.getParentId());
        leaseOrganizationStructure.setLeaderId(organizationInserChildVo.getLeaderId());
        leaseOrganizationStructure.setAssistantId(organizationInserChildVo.getAssistantId());
        leaseOrganizationStructure.setParentLeaderId(organizationInserChildVo.getParentLeaderId());
        leaseOrganizationStructure.setDeputyLeadeId(organizationInserChildVo.getDeputyLeadeId());
        leaseOrganizationStructure.setCreateTime(nowDate);
        leaseOrganizationStructure.setUpdateTime(nowDate);
        leaseOrganizationStructure.setIsDefault(0);
        leaseOrganizationStructure.setCreateBy(userSession.getUserId());
        leaseOrganizationStructure.setUpdateBy(userSession.getUserId());

        leaseOrganizationStructure = leaseOrganizationStructureService.insertSelective(leaseOrganizationStructure);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    /**
     * 检测是否有下级
     *
     * @param parentId
     * @return
     * @throws GMException
     */
    @Override
    public Boolean checkHaveChild(Long parentId) throws GMException {
        Boolean isHaveChild = leaseOrganizationStructureService.checkHaveChild(parentId);
        return isHaveChild;
    }

    /**
     * 检测是否默认/默认的数据不可删除
     *
     * @param id
     * @return
     * @throws GMException
     */
    @Override
    public Boolean checkIsDefault(Long id) throws GMException {
        Boolean isHaveChild = leaseOrganizationStructureService.checkIsDefault(id);
        return isHaveChild;
    }

    /**
     * 根据父级查询数据
     *
     * @param parentId
     * @return
     * @throws GMException
     */
    @Override
    public List<LeaseOrganizationStructure> selectByParentId(Long parentId) throws GMException {
        List<LeaseOrganizationStructure> leaseOrganizationStructureList = leaseOrganizationStructureService.selectByParentId(parentId);
        return leaseOrganizationStructureList;
    }

    /**
     * 整理所有子级的主键id
     *
     * @param parentId
     */
    public List changeChildStatus(Long parentId, ArrayList parentIdLit) throws GMException {
        if (parentIdLit == null || parentIdLit.size() < 0) parentIdLit = new ArrayList();
        List<LeaseOrganizationStructure> leaseOrganizationStructureList = leaseOrganizationStructureService.selectByParentId(parentId);
        if (leaseOrganizationStructureList != null && leaseOrganizationStructureList.size() > 0) {
            for (int i = 0; i < leaseOrganizationStructureList.size(); i++) {
                LeaseOrganizationStructure leaseOrganizationStructure = leaseOrganizationStructureList.get(i);
                parentIdLit.add(leaseOrganizationStructure.getId());
                changeChildStatus(leaseOrganizationStructure.getId(), parentIdLit);
            }
        }
        return parentIdLit;
    }

    /**
     * 修改所有子级状态
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public int updateChildsStatus(Map<String, Object> paramsMap) throws GMException {
        int row = leaseOrganizationStructureService.updateChildsStatus(paramsMap);
        return row;
    }

    /**
     * 查找同一子级的排序是否被使用
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public Boolean checkSameLevelSort(Map<String, Object> paramsMap) throws GMException {
        Boolean checkSameLevelSort = leaseOrganizationStructureService.checkSameLevelSort(paramsMap);
        return checkSameLevelSort;
    }

    /**
     * 查找同一子级的最大排序
     *
     * @param paramsMap
     * @return
     * @throws GMException
     */
    @Override
    public Integer selectSameLevelMaxSort(Map<String, Object> paramsMap) throws GMException {
        Integer maxSort = leaseOrganizationStructureService.selectSameLevelMaxSort(paramsMap);
        return maxSort;
    }

    /**
     * 用类型查询
     *
     * @param list
     * @return
     * @throws GMException
     */
    @Override
    public List<OrganizationStructureSelectByTypeVo> selectByType(List list) throws GMException {
        List<OrganizationStructureSelectByTypeVo> leaseOrganizationStructureList = leaseOrganizationStructureService.selectByType(list);
        return leaseOrganizationStructureList;
    }
}
