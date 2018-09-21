package com.hc.lease.baseInfo.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.dao.LeaseCompanyHeaderMapper;
import com.hc.lease.baseInfo.model.LeaseArchiveLocation;
import com.hc.lease.baseInfo.model.LeaseCompanyHeader;
import com.hc.lease.baseInfo.service.LeaseCompanyHeaderService;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 合同方-公司抬头ServiceImpl
 * @author Tong
 * @version 2017-04-14
 */
@Service("leaseCompanyHeaderService")
public class LeaseCompanyHeaderServiceImpl implements LeaseCompanyHeaderService {

	@Autowired
	private LeaseCompanyHeaderMapper leaseCompanyHeaderMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseCompanyHeaderMapper.deleteByPrimaryKey(id);
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
        int row = leaseCompanyHeaderMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseCompanyHeader insert(LeaseCompanyHeader record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseCompanyHeaderMapper.insert(record);
        return record;
    }

    public LeaseCompanyHeader insertSelective(LeaseCompanyHeader record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseCompanyHeaderMapper.insertSelective(record);
        return record;
    }

    public LeaseCompanyHeader selectByPrimaryKey(Long id) throws GMException {
        LeaseCompanyHeader leaseCompanyHeader = leaseCompanyHeaderMapper.selectByPrimaryKey(id);
        return leaseCompanyHeader;
    }

    public int updateByPrimaryKeySelective(LeaseCompanyHeader record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseCompanyHeaderMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCompanyHeader record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseCompanyHeaderMapper.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseCompanyHeader> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     * @return
     */
    public PageInfo<LeaseCompanyHeader> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseCompanyHeader> leaseCompanyHeaderList = leaseCompanyHeaderMapper.findPage(paramsMap);
        PageInfo<LeaseCompanyHeader> page = new PageInfo<LeaseCompanyHeader>(leaseCompanyHeaderList);
        return page;
    }

    public List<LeaseCompanyHeader> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCompanyHeader> leaseCompanyHeaderList = leaseCompanyHeaderMapper.findAll(paramsMap);
        return leaseCompanyHeaderList;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public List<LeaseCompanyHeader> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCompanyHeader> list = leaseCompanyHeaderMapper.insertViewParames(paramsMap);
        return list;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param params
     * @return
     */
    public List<LeaseCompanyHeader> findByName(Map params) throws GMException {
        List<LeaseCompanyHeader> list = leaseCompanyHeaderMapper.findByName(params);
        return list;
    }

}
