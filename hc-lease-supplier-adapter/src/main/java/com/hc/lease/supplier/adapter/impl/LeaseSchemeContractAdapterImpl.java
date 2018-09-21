package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.adapter.api.LeaseSchemeContractAdapter;
import com.hc.lease.supplier.service.api.LeaseSchemeContractService;
import com.hc.lease.supplier.model.LeaseSchemeContract;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 方案报价-合同AdapterImpl
 * @author Qiang
 * @version 2018-08-09
 */
@Service("leaseSchemeContractAdapter")
public class LeaseSchemeContractAdapterImpl implements LeaseSchemeContractAdapter {

	@Autowired
	private LeaseSchemeContractService leaseSchemeContractService;

    /**
    * 添加或者修改 需要的初始化参数
    *
    * @param paramsMap
    * @return
    */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    /**
    * 根据ID删除记录
    *
    * @param id .
    * @return
    * @throws GMException
    */
    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemeContractService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseSchemeContractService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseSchemeContract record) throws GMException {
        record = leaseSchemeContractService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseSchemeContract record) throws GMException {
        record = leaseSchemeContractService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseSchemeContract record) throws GMException {
        int row = leaseSchemeContractService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeContract record) throws GMException {
        int row = leaseSchemeContractService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseSchemeContract selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeContract leaseSchemeContract = leaseSchemeContractService.selectByPrimaryKey(id);
        return leaseSchemeContract;
    }

    public int insertList(List<LeaseSchemeContract> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseSchemeContract> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseSchemeContract> page = leaseSchemeContractService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List<LeaseSchemeContract> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeContract> leaseSchemeContractList = leaseSchemeContractService.findAll(paramsMap);
        return leaseSchemeContractList;
    }

}
