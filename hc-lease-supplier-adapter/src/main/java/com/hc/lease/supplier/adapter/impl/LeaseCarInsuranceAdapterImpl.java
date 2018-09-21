package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.supplier.adapter.api.LeaseCarInsuranceAdapter;
import com.hc.lease.supplier.model.LeaseCarInsurance;
import com.hc.lease.supplier.service.api.LeaseCarInsuranceService;
import com.hc.lease.supplier.vo.CarInsuranceExportCountResult;
import com.hc.lease.supplier.vo.CarInsuranceImportResultExcel;
import com.hc.lease.supplier.vo.InsuranceCarIdQuery;
import com.hc.lease.supplier.vo.LeaseCarInsuranceExcel;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 车辆保险信息AdapterImpl
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseCarInsuranceAdapter")
public class LeaseCarInsuranceAdapterImpl implements LeaseCarInsuranceAdapter {

	@Autowired
	private LeaseCarInsuranceService leaseCarInsuranceService;

    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    @Override
    public List<LeaseCarInsuranceExcel> exportAllQuery(InsuranceCarIdQuery queryParameter) {
        return leaseCarInsuranceService.exportAllQuery(queryParameter);
    }

    @Override
    public PageInfo<LeaseCarInsuranceExcel> exportPageQuery(InsuranceCarIdQuery queryParameter) {
        return leaseCarInsuranceService.exportPageQuery(queryParameter);
    }

    @Override
    public CarInsuranceExportCountResult saveCarInsuranceExcelImport(List<LeaseCarInsuranceExcel> list) throws Exception {
        return leaseCarInsuranceService.saveCarInsuranceExcelImport(list);
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseCarInsuranceService.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row=leaseCarInsuranceService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseCarInsurance record) throws GMException {
        record = leaseCarInsuranceService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseCarInsurance record) throws GMException {
        record = leaseCarInsuranceService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int insertList(List<LeaseCarInsurance> list) throws GMException {
        return 0;
    }


    /*public int insert(List<LeaseCarInsurance> record) throws GMException {
        int row = leaseCarInsuranceService.insert(record);
        return row;
    }

    public int insertSelective(List<LeaseCarInsurance> record) throws GMException {
        int row = leaseCarInsuranceService.insertSelective(record);
        return row;
    }*/

    public int updateByPrimaryKeySelective(LeaseCarInsurance record) throws GMException {
        int row = leaseCarInsuranceService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCarInsurance record) throws GMException {
        int row = leaseCarInsuranceService.updateByPrimaryKey(record);
        return row;
    }

   /* public int updateByPrimaryKeySelective(List<LeaseCarInsurance> record) throws GMException {
        int row = leaseCarInsuranceService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(List<LeaseCarInsurance> record) throws GMException {
        int row = leaseCarInsuranceService.updateByPrimaryKey(record);
        return row;
    }*/

    public LeaseCarInsurance selectByPrimaryKey(Long id) throws GMException {
        LeaseCarInsurance leaseCarInsurance = leaseCarInsuranceService.selectByPrimaryKey(id);
        return leaseCarInsurance;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseCarInsurance> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseCarInsurance> page = leaseCarInsuranceService.findPage(pageNum, pageSize,paramsMap);
        return page;
    }

    public List<LeaseCarInsurance> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCarInsurance> leaseCarInsuranceList = leaseCarInsuranceService.findAll(paramsMap);
        return leaseCarInsuranceList;
    }

}
