package com.hc.lease.account.adapter.api;

import com.hc.lease.account.model.LeaseAccountCompany;
import com.hc.lease.account.vo.LeaseAccountCompanyExcel;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.excel.easyxls.bean.ExcelConfig;
import com.hc.lease.common.core.excel.poi.vo.LeaseAccountCompanyExcelTemplate;
import com.hc.lease.common.core.excel.poi.vo.LeaseAccountCompanyImportExcelBackInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.ResultHashMap;
import jxl.Workbook;

import java.util.List;
import java.util.Map;

/**
 * 注册公司类型用户Adapter
 *
 * @author Tong
 * @version 2017-11-02
 */

public interface LeaseAccountCompanyAdapter extends BaseAdapter<LeaseAccountCompany> {

    int updateByAccountId(LeaseAccountCompany leaseAccountCompany);

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 新增/注册
     *
     * @param leaseAccountCompany
     * @return
     * @throws GMException
     */
    ResultHashMap accountRegister(LeaseAccountCompany leaseAccountCompany) throws GMException;

    List<LeaseAccountCompanyExcel> findAllByCompanyExcel(Object o);


    LeaseAccountCompanyImportExcelBackInfo importAccountCompanyExcel(List<LeaseAccountCompanyExcelTemplate> leaseAccountCompanyExcelTemplates) throws GMException;
}
