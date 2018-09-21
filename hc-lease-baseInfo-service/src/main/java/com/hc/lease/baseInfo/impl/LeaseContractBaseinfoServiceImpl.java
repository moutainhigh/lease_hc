package com.hc.lease.baseInfo.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.dao.LeaseContractBaseinfoMapper;
import com.hc.lease.baseInfo.model.LeaseContractBaseinfo;
import com.hc.lease.baseInfo.model.LeaseRule;
import com.hc.lease.baseInfo.service.LeaseContractBaseinfoService;
import com.hc.lease.baseInfo.vo.ContractPartyContactAddressVo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融租合同基础数据ServiceImpl
 *
 * @author Tong
 * @version 2017-04-14
 */
@Service("leaseContractBaseinfoService")
public class LeaseContractBaseinfoServiceImpl implements LeaseContractBaseinfoService {

    @Autowired
    private LeaseContractBaseinfoMapper leaseContractBaseinfoMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractBaseinfoMapper.deleteByPrimaryKey(id);
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
        int row = leaseContractBaseinfoMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseContractBaseinfo insert(LeaseContractBaseinfo record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        record.setContractPartyContactAddressVoList(null);
        int row = leaseContractBaseinfoMapper.insert(record);
        return record;
    }

    public LeaseContractBaseinfo insertSelective(LeaseContractBaseinfo record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        List<ContractPartyContactAddressVo> contractPartyContactAddressVoList = record.getContractPartyContactAddressVoList();
        record.setContractPartyContactAddress(contractPartyContactAddressVoList);
        record.setContractPartyContactAddressVoList(null);
        int row = leaseContractBaseinfoMapper.insertSelective(record);
        return record;
    }

    public LeaseContractBaseinfo selectByPrimaryKey(Long id) throws GMException {
        LeaseContractBaseinfo leaseContractBaseinfo = leaseContractBaseinfoMapper.selectByPrimaryKey(id);
        return leaseContractBaseinfo;
    }

    public int updateByPrimaryKeySelective(LeaseContractBaseinfo record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractBaseinfoMapper.updateByPrimaryKeySelective(record);
        record.setContractPartyContactAddressVoList(null);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractBaseinfo record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractBaseinfoMapper.updateByPrimaryKey(record);
        record.setContractPartyContactAddressVoList(null);
        return row;
    }

    public int insertList(List<LeaseContractBaseinfo> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseContractBaseinfo> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        //throw new GMGMException(GMGMExceptionConstant.OBJECT_NULL_EXCEPTION);
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseContractBaseinfo> leaseContractBaseinfoList = leaseContractBaseinfoMapper.findPage(paramsMap);
        PageInfo<LeaseContractBaseinfo> page = new PageInfo<LeaseContractBaseinfo>(leaseContractBaseinfoList);
        return page;
    }

    public List<LeaseContractBaseinfo> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractBaseinfo> leaseContractBaseinfoList = leaseContractBaseinfoMapper.findAll(paramsMap);
        return leaseContractBaseinfoList;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param params
     * @return
     */
    public List<LeaseContractBaseinfo> findByName(Map params) throws GMException {
        List<LeaseContractBaseinfo> list = leaseContractBaseinfoMapper.findByName(params);
        return list;
    }

    public List<LeaseContractBaseinfo> findAllNoPage(Object o) {
        List<LeaseContractBaseinfo> list = leaseContractBaseinfoMapper.findPage(null);
        return list;
    }

}
