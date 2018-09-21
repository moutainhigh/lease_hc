package com.hc.lease.supplier.service;

import base.BaseTest;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.excel.easyxls.bean.ExcelConfig;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.excel.easyxls.common.XlsUtil;
import com.hc.lease.supplier.adapter.api.LeaseInsuranceCompanyAdapter;
import com.hc.lease.supplier.model.LeaseCarInsurance;
import com.hc.lease.supplier.service.api.LeaseCarInsuranceService;
import com.hc.lease.supplier.vo.CarInsuranceExportCountResult;
import com.hc.lease.supplier.vo.CarInsuranceImportResultExcel;
import com.hc.lease.supplier.vo.InsuranceCarIdQuery;
import com.hc.lease.supplier.vo.LeaseCarInsuranceExcel;
import hc.lease.common.util.DateUtils;
import jxl.Workbook;
import jxl.WorkbookSettings;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LJ on 2018/4/18
 */
//@Slf4j
public class LeaseCarInsuranceServiceTest extends BaseTest {

   /* @Resource
    private LeaseCarInsuranceService leaseCarInsuranceService;

    @Resource
    private LeaseInsuranceCompanyAdapter leaseInsuranceCompanyAdapter;

   // @Test
    public void exportAllQuery() throws Exception {
        InsuranceCarIdQuery insuranceCarIdQuery = new InsuranceCarIdQuery();
        Date date = new Date();
        Date date1 = DateUtils.dateCalculate(date, Calendar.YEAR, 1);
        insuranceCarIdQuery.setExpireBeginDate(date);
        insuranceCarIdQuery.setExpireEndDate(date1);
        List<LeaseCarInsuranceExcel> leaseCarInsuranceExcels = leaseCarInsuranceService.exportAllQuery(insuranceCarIdQuery);
        XlsUtil.listToXls(getExcelConfig(), leaseCarInsuranceExcels, "E:\\", DateUtil.getDateYmd(DateTime.now().toDate()) + "_1", this.getParams());
        //log.info("leaseCarInsuranceExcels {}", leaseCarInsuranceExcels);
    }

    //@Test
    public void saveCarInsuranceExcelImport() throws Exception {
        String filePath = "E:\\" + DateUtil.getDateYmd(DateTime.now().toDate()) + "_1.xls";
        WorkbookSettings workbookSettings = new WorkbookSettings();
        workbookSettings.setCellValidationDisabled(true);
        Workbook wb = Workbook.getWorkbook(new File(filePath), workbookSettings);
        List<LeaseCarInsuranceExcel> list = (List<LeaseCarInsuranceExcel>) XlsUtil.workbookToList(getExcelConfig(), wb);
        CarInsuranceExportCountResult carInsuranceExportCountResult = leaseCarInsuranceService.saveCarInsuranceExcelImport(list);
        XlsUtil.listToXls(getExcelImportResultConfig(), carInsuranceExportCountResult.getList(), "E:\\", DateUtil.getDateYmd(DateTime.now().toDate()) + "_2", this.getParams());
    }

    //@Test
    public void insuranceExcelImport() throws Exception {
        String filePath = "E:\\" + DateUtil.getDateYmd(DateTime.now().toDate()) + "_1.xls";
        Workbook wb = Workbook.getWorkbook(new File(filePath));
        List<LeaseCarInsuranceExcel> list = (List<LeaseCarInsuranceExcel>) XlsUtil.workbookToList(getExcelConfig(), wb);
        log.info("leaseCarInsuranceExcels {}", list);
    }

    @Test
    public void findPage() throws Exception {
        InsuranceCarIdQuery insuranceCarIdQuery = new InsuranceCarIdQuery();
        insuranceCarIdQuery.setPageNum(1);
        insuranceCarIdQuery.setPageSize(10);
        Date date = new Date();
        Date date1 = DateUtils.dateCalculate(date, Calendar.YEAR, 1);
        insuranceCarIdQuery.setExpireBeginDate(date);
        insuranceCarIdQuery.setExpireEndDate(date1);
        PageInfo<LeaseCarInsuranceExcel> page = leaseCarInsuranceService.exportPageQuery(insuranceCarIdQuery);
        log.info("====page {}", page);
    }

    private ExcelConfig getExcelConfig() {
        ExcelConfig config = new ExcelConfig.Builder(LeaseCarInsuranceExcel.class)
                .sheetName("车辆保险信息")
                .sheetNum(0)
                .startRow(1)
                .build();
        return config;
    }

    private ExcelConfig getExcelImportResultConfig() {
        ExcelConfig config = new ExcelConfig.Builder(CarInsuranceImportResultExcel.class)
                .sheetName("车辆保险导入结果信息")
                .sheetNum(0)
                .startRow(1)
                .build();
        return config;
    }

    private Map<String, List<String>> getParams() {
        Map<String, List<String>> params = new HashMap<>();
        List<String> allInsuranceCompanyNames = leaseInsuranceCompanyAdapter.findAllInsuranceCompanyNames();
        params.put("insuranceCompanyList", allInsuranceCompanyNames);
        return params;
    }*/
}