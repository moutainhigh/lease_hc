package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.supplier.adapter.api.LeasePackageAdapter;
import com.hc.lease.supplier.model.LeasePackage;
import com.hc.lease.supplier.service.api.LeasePackageService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 套餐AdapterImpl
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leasePackageAdapter")
public class LeasePackageAdapterImpl implements LeasePackageAdapter {

	@Autowired
	private LeasePackageService leasePackageService;

    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leasePackageService.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row=leasePackageService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeasePackage record) throws GMException {
        record = leasePackageService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeasePackage record) throws GMException {
        record = leasePackageService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int insertList(List<LeasePackage> list) throws GMException {
        return 0;
    }

  /*  public int insert(List<LeasePackage> record) throws GMException {
        int row = leasePackageService.insert(record);
        return row;
    }

    public int insertSelective(List<LeasePackage> record) throws GMException {
        int row = leasePackageService.insertSelective(record);
        return row;
    }*/

    public int updateByPrimaryKeySelective(LeasePackage record) throws GMException {
        int row = leasePackageService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeasePackage record) throws GMException {
        int row = leasePackageService.updateByPrimaryKey(record);
        return row;
    }

    /*public int updateByPrimaryKeySelective(List<LeasePackage> record) throws GMException {
        int row = leasePackageService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(List<LeasePackage> record) throws GMException {
        int row = leasePackageService.updateByPrimaryKey(record);
        return row;
    }*/

    public LeasePackage selectByPrimaryKey(Long id) throws GMException {
        LeasePackage leasePackage = leasePackageService.selectByPrimaryKey(id);
        return leasePackage;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeasePackage> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeasePackage> page = leasePackageService.findPage(pageNum, pageSize,paramsMap);
        return page;
    }

    public List<LeasePackage> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeasePackage> leasePackageList = leasePackageService.findAll(paramsMap);
        return leasePackageList;
    }

}
