package com.hc.lease.account.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.account.dao.LeaseAccountMapper;
import com.hc.lease.account.model.LeaseAccount;
import com.hc.lease.account.service.LeaseAccountService;
import com.hc.lease.account.vo.LeaseAccountVo;
import com.hc.lease.common.core.enumConstant.AccountStatus;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;
import hc.lease.common.util.FileUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 承租人/用户
 */
@Service("leaseAccountService")
public class LeaseAccountServiceImpl implements LeaseAccountService {

    @Autowired
    private LeaseAccountMapper leaseAccountMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAccountMapper.deleteByPrimaryKey(id);
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
        int row = leaseAccountMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseAccount insert(LeaseAccount record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountMapper.insert(record);
        return record;
    }

    public LeaseAccount insertSelective(LeaseAccount record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setStatus(AccountStatus.normal.ordinal());
        int row = leaseAccountMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseAccount> list) throws GMException {
        int row = leaseAccountMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseAccount record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAccount record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseAccountMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAccount selectByPrimaryKey(Long id) throws GMException {
        LeaseAccount leaseArchiveLocation = leaseAccountMapper.selectByPrimaryKey(id);
        return leaseArchiveLocation;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAccount> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseAccount> leaseArchiveLocationList = leaseAccountMapper.findPage(paramsMap);
        PageInfo<LeaseAccount> page = new PageInfo<LeaseAccount>(leaseArchiveLocationList);
        return page;
    }

    public List<LeaseAccount> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAccount> leaseArchiveLocationList = leaseAccountMapper.findAll(paramsMap);
        return leaseArchiveLocationList;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public List<LeaseAccount> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAccount> list = leaseAccountMapper.insertViewParames(paramsMap);
        return list;
    }

    /**
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<LeaseAccount> findByPhone(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAccount> leaseAccountList = leaseAccountMapper.findByPhone(paramsMap);
        return leaseAccountList;
    }

    public List<LeaseAccount> selectAllAccountNoPage(Map<String, Object> paramsMap) {
        List<LeaseAccount> leaseAccountList = leaseAccountMapper.findPage(paramsMap);
        return leaseAccountList;
    }

    /**
     * 检测身份证号码是否存在
     *
     * @param paramsMap
     * @return
     */
    public List<LeaseAccount> findByIdCard(Map<String, Object> paramsMap) {
        List<LeaseAccount> leaseAccountList = leaseAccountMapper.findByIdCard(paramsMap);
        return leaseAccountList;
    }
}
