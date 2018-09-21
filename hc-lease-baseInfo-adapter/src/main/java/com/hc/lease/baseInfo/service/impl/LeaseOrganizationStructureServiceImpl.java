package com.hc.lease.baseInfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.dao.LeaseOrganizationStructureMapper;
import com.hc.lease.baseInfo.model.LeaseOrganizationStructure;
import com.hc.lease.baseInfo.service.api.LeaseOrganizationStructureService;
import com.hc.lease.baseInfo.vo.FindParentTreeVo;
import com.hc.lease.baseInfo.vo.OrganizationStructureSelectByTypeVo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 组织结构ServiceImpl
 *
 * @author Tong
 * @version 2018-04-12
 */
@Service("leaseOrganizationStructureService")
public class LeaseOrganizationStructureServiceImpl implements LeaseOrganizationStructureService {

    @Autowired
    private LeaseOrganizationStructureMapper leaseOrganizationStructureMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseOrganizationStructureMapper.deleteByPrimaryKey(id);
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
        int row = leaseOrganizationStructureMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseOrganizationStructure insert(LeaseOrganizationStructure leaseOrganizationStructure) throws GMException {
        leaseOrganizationStructure.setCreateTime(DateTime.now().toDate());
        leaseOrganizationStructure.setUpdateTime(DateTime.now().toDate());
        int row = leaseOrganizationStructureMapper.insert(leaseOrganizationStructure);
        return leaseOrganizationStructure;
    }

    public LeaseOrganizationStructure insertSelective(LeaseOrganizationStructure leaseOrganizationStructure) throws GMException {
        leaseOrganizationStructure.setCreateTime(DateTime.now().toDate());
        leaseOrganizationStructure.setUpdateTime(DateTime.now().toDate());
        int row = leaseOrganizationStructureMapper.insertSelective(leaseOrganizationStructure);
        return leaseOrganizationStructure;
    }

    public int insertList(List<LeaseOrganizationStructure> list) throws GMException {
        int row = leaseOrganizationStructureMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseOrganizationStructure leaseOrganizationStructure) throws GMException {
        leaseOrganizationStructure.setUpdateTime(DateTime.now().toDate());
        int row = leaseOrganizationStructureMapper.updateByPrimaryKeySelective(leaseOrganizationStructure);
        return row;
    }

    public int updateByPrimaryKey(LeaseOrganizationStructure leaseOrganizationStructure) throws GMException {
        leaseOrganizationStructure.setUpdateTime(DateTime.now().toDate());
        int row = leaseOrganizationStructureMapper.updateByPrimaryKey(leaseOrganizationStructure);
        return row;
    }

    public LeaseOrganizationStructure selectByPrimaryKey(Long id) throws GMException {
        LeaseOrganizationStructure leaseOrganizationStructure = leaseOrganizationStructureMapper.selectByPrimaryKey(id);
        return leaseOrganizationStructure;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseOrganizationStructure> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseOrganizationStructure> leaseOrganizationStructureList = leaseOrganizationStructureMapper.findPage(paramsMap);
        PageInfo<LeaseOrganizationStructure> page = new PageInfo<LeaseOrganizationStructure>(leaseOrganizationStructureList);
        return page;
    }

    public List<LeaseOrganizationStructure> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseOrganizationStructure> leaseOrganizationStructureList = leaseOrganizationStructureMapper.findAll(paramsMap);
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
        List<FindParentTreeVo> findParentTreeVoList = leaseOrganizationStructureMapper.findParentTree(paramsMap);
        return findParentTreeVoList;
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
        Boolean isHaveChild = leaseOrganizationStructureMapper.checkHaveChild(parentId);
        return isHaveChild;
    }

    /**
     * 检测是否默认/默认的数据不删除
     *
     * @param id
     * @return
     * @throws GMException
     */
    @Override
    public Boolean checkIsDefault(Long id) throws GMException {
        Boolean isHaveChild = leaseOrganizationStructureMapper.checkIsDefault(id);
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
        List<LeaseOrganizationStructure> selectByParentIdList = leaseOrganizationStructureMapper.selectByParentId(parentId);
        return selectByParentIdList;
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
        int row = leaseOrganizationStructureMapper.updateChildsStatus(paramsMap);
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
        Boolean checkSameLevelSort = leaseOrganizationStructureMapper.checkSameLevelSort(paramsMap);
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
        Integer maxSort = leaseOrganizationStructureMapper.selectSameLevelMaxSort(paramsMap);
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
        List<OrganizationStructureSelectByTypeVo> leaseOrganizationStructureList = leaseOrganizationStructureMapper.selectByType(list);
        return leaseOrganizationStructureList;
    }
}
