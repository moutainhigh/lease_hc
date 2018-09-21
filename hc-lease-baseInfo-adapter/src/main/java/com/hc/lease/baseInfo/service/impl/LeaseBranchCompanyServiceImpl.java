package com.hc.lease.baseInfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.dao.LeaseBranchCompanyMapper;
import com.hc.lease.baseInfo.model.LeaseBranchCompany;
import com.hc.lease.baseInfo.service.api.LeaseBranchCompanyService;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 分公司ServiceImpl
 *
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseBranchCompanyService")
public class LeaseBranchCompanyServiceImpl implements LeaseBranchCompanyService {

    @Autowired
    private LeaseBranchCompanyMapper leaseBranchCompanyMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseBranchCompanyMapper.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseBranchCompanyMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseBranchCompany insert(LeaseBranchCompany record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseBranchCompanyMapper.insert(record);
        return record;
    }

    public LeaseBranchCompany insertSelective(LeaseBranchCompany record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseBranchCompanyMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseBranchCompany> record) throws GMException {
        int row = leaseBranchCompanyMapper.insertList(record);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseBranchCompany record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseBranchCompanyMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseBranchCompany record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseBranchCompanyMapper.updateByPrimaryKey(record);
        return row;
    }


    public LeaseBranchCompany selectByPrimaryKey(Long id) throws GMException {
        LeaseBranchCompany leaseBranchCompany = leaseBranchCompanyMapper.selectByPrimaryKey(id);
        return leaseBranchCompany;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseBranchCompany> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyMapper.findPage(paramsMap);
        PageInfo<LeaseBranchCompany> page = new PageInfo<LeaseBranchCompany>(leaseBranchCompanyList);
        return page;
    }

    public List<LeaseBranchCompany> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyMapper.findAll(paramsMap);
        return leaseBranchCompanyList;
    }

    public List<LeaseBranchCompany> findByName(Map params) {
        List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyMapper.findByName(params);
        return leaseBranchCompanyList;
    }

    public int disableByPrimaryKey(Map<String, Object> params) {

        int row = leaseBranchCompanyMapper.disableByPrimaryKey(params);
        return row;
    }

    /**
     * 导出车辆录入模板需要的数据
     *
     * @param params
     * @return
     * @throws GMException
     */
    @Override
    public List<String> findExportExcelModel(Map params) throws GMException {
        List<String> leaseBranchCompanyList = leaseBranchCompanyMapper.findExportExcelModel(params);
        return leaseBranchCompanyList;
    }

    public void updateSort(LeaseBranchCompany leaseBranchCompany) {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id",leaseBranchCompany.getId());
        paramsMap.put("mark",leaseBranchCompany.getMark());
        leaseBranchCompanyMapper.updateSort(paramsMap);
    }

    public List<LeaseBranchCompany> findAllNoPage(Map params) {
        List<LeaseBranchCompany> leaseBranchCompanyList=leaseBranchCompanyMapper.findPage(params);
        return leaseBranchCompanyList;
    }
}
