package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.supplier.adapter.api.LeaseSchemePackageAdapter;
import com.hc.lease.supplier.model.LeaseSchemePackage;
import com.hc.lease.supplier.service.api.LeaseSchemePackageService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融租方案-套餐AdapterImpl
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseSchemePackageAdapter")
public class LeaseSchemePackageAdapterImpl implements LeaseSchemePackageAdapter {

	@Autowired
	private LeaseSchemePackageService leaseSchemePackageService;

    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemePackageService.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row=leaseSchemePackageService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseSchemePackage record) throws GMException {
        record = leaseSchemePackageService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseSchemePackage record) throws GMException {
        record = leaseSchemePackageService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }


    public int insertList(List<LeaseSchemePackage> list) throws GMException {
        return 0;
    }

  /*  public int insert(List<LeaseSchemePackage> record) throws GMException {
        int row = leaseSchemePackageService.insert(record);
        return row;
    }

    public int insertSelective(List<LeaseSchemePackage> record) throws GMException {
        int row = leaseSchemePackageService.insertSelective(record);
        return row;
    }*/

    public int updateByPrimaryKeySelective(LeaseSchemePackage record) throws GMException {
        int row = leaseSchemePackageService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemePackage record) throws GMException {
        int row = leaseSchemePackageService.updateByPrimaryKey(record);
        return row;
    }

    /*public int updateByPrimaryKeySelective(List<LeaseSchemePackage> record) throws GMException {
        int row = leaseSchemePackageService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(List<LeaseSchemePackage> record) throws GMException {
        int row = leaseSchemePackageService.updateByPrimaryKey(record);
        return row;
    }*/

    public LeaseSchemePackage selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemePackage leaseSchemePackage = leaseSchemePackageService.selectByPrimaryKey(id);
        return leaseSchemePackage;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseSchemePackage> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseSchemePackage> page = leaseSchemePackageService.findPage(pageNum, pageSize,paramsMap);
        return page;
    }

    public List<LeaseSchemePackage> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemePackage> leaseSchemePackageList = leaseSchemePackageService.findAll(paramsMap);
        return leaseSchemePackageList;
    }

}
