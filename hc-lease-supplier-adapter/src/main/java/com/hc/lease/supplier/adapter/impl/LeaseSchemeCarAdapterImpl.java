package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.supplier.adapter.api.LeaseSchemeCarAdapter;
import com.hc.lease.supplier.model.LeaseSchemeCar;
import com.hc.lease.supplier.service.api.LeaseSchemeCarService;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融资方案-车辆AdapterImpl
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseSchemeCarAdapter")
public class LeaseSchemeCarAdapterImpl implements LeaseSchemeCarAdapter {

	@Autowired
	private LeaseSchemeCarService leaseSchemeCarService;

    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemeCarService.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row=leaseSchemeCarService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseSchemeCar record) throws GMException {
        record = leaseSchemeCarService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseSchemeCar record) throws GMException {
        record = leaseSchemeCarService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int insertList(List<LeaseSchemeCar> list) throws GMException {
        return 0;
    }

  /*  public int insert(List<LeaseSchemeCar> record) throws GMException {
        int row = leaseSchemeCarService.insert(record);
        return row;
    }

    public int insertSelective(List<LeaseSchemeCar> record) throws GMException {
        int row = leaseSchemeCarService.insertSelective(record);
        return row;
    }*/

    public int updateByPrimaryKeySelective(LeaseSchemeCar record) throws GMException {
        int row = leaseSchemeCarService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeCar record) throws GMException {
        int row = leaseSchemeCarService.updateByPrimaryKey(record);
        return row;
    }

   /* public int updateByPrimaryKeySelective(List<LeaseSchemeCar> record) throws GMException {
        int row = leaseSchemeCarService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(List<LeaseSchemeCar> record) throws GMException {
        int row = leaseSchemeCarService.updateByPrimaryKey(record);
        return row;
    }*/

    public LeaseSchemeCar selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeCar leaseSchemeCar = leaseSchemeCarService.selectByPrimaryKey(id);
        return leaseSchemeCar;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseSchemeCar> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseSchemeCar> page = leaseSchemeCarService.findPage(pageNum, pageSize,paramsMap);
        return page;
    }

    public List<LeaseSchemeCar> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeCar> leaseSchemeCarList = leaseSchemeCarService.findAll(paramsMap);
        return leaseSchemeCarList;
    }

}
