package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.vo.ContractPartyContactAddressVo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.dao.LeaseContractBaseinfoUseMapper;
import com.hc.lease.order.model.LeaseContractBaseinfoUse;
import com.hc.lease.order.service.api.LeaseContractBaseinfoUseService;
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
@Service("leaseContractBaseinfoUseService")
public class LeaseContractBaseinfoUseServiceImpl implements LeaseContractBaseinfoUseService {

    @Autowired
    private LeaseContractBaseinfoUseMapper leaseContractBaseinfoUseMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractBaseinfoUseMapper.deleteByPrimaryKey(id);
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
        int row = leaseContractBaseinfoUseMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseContractBaseinfoUse insert(LeaseContractBaseinfoUse record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        record.setContractPartyContactAddressVoList(null);
        int row = leaseContractBaseinfoUseMapper.insert(record);
        return record;
    }

    public LeaseContractBaseinfoUse insertSelective(LeaseContractBaseinfoUse record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        List<ContractPartyContactAddressVo> contractPartyContactAddressVoList = record.getContractPartyContactAddressVoList();
        record.setContractPartyContactAddress(contractPartyContactAddressVoList);
        record.setContractPartyContactAddressVoList(null);
        int row = leaseContractBaseinfoUseMapper.insertSelective(record);
        return record;
    }

    public LeaseContractBaseinfoUse selectByPrimaryKey(Long id) throws GMException {
        LeaseContractBaseinfoUse leaseContractBaseinfo = leaseContractBaseinfoUseMapper.selectByPrimaryKey(id);
        return leaseContractBaseinfo;
    }

    public int updateByPrimaryKeySelective(LeaseContractBaseinfoUse record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        List<ContractPartyContactAddressVo> contractPartyContactAddressVoList = record.getContractPartyContactAddressVoList();
        record.setContractPartyContactAddress(contractPartyContactAddressVoList);
        int row = leaseContractBaseinfoUseMapper.updateByPrimaryKeySelective(record);
        record.setContractPartyContactAddressVoList(null);
        return row;
    }

    public int updateByPrimaryKey(LeaseContractBaseinfoUse record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseContractBaseinfoUseMapper.updateByPrimaryKey(record);
        record.setContractPartyContactAddressVoList(null);
        return row;
    }

    public int insertList(List<LeaseContractBaseinfoUse> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseContractBaseinfoUse> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        //throw new GMGMException(GMGMExceptionConstant.OBJECT_NULL_EXCEPTION);
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseContractBaseinfoUse> leaseContractBaseinfoList = leaseContractBaseinfoUseMapper.findPage(paramsMap);
        PageInfo<LeaseContractBaseinfoUse> page = new PageInfo<LeaseContractBaseinfoUse>(leaseContractBaseinfoList);
        return page;
    }

    public List<LeaseContractBaseinfoUse> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractBaseinfoUse> leaseContractBaseinfoList = leaseContractBaseinfoUseMapper.findAll(paramsMap);
        return leaseContractBaseinfoList;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param params
     * @return
     */
    public List<LeaseContractBaseinfoUse> findByName(Map params) throws GMException {
        List<LeaseContractBaseinfoUse> list = leaseContractBaseinfoUseMapper.findByName(params);
        return list;
    }

    public List<LeaseContractBaseinfoUse> findAllNoPage(Object o) {
        List<LeaseContractBaseinfoUse> list = leaseContractBaseinfoUseMapper.findPage(null);
        return list;
    }

}
