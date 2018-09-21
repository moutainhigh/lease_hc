package com.hc.lease.supplier.vo;

import com.hc.lease.common.core.excel.easyxls.annotation.ExcelAttribute;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by LJ on 2018/4/18
 */
@Data
public class CarInsuranceImportResultExcel extends LeaseCarInsuranceExcel implements Serializable {


    @ExcelAttribute(name = "交强险导入结果")
    private String jqInsuranceImportResult = "成功";

    @ExcelAttribute(name = "交强险导入失败原因")
    private String jqInsuranceImportRemark;

    @ExcelAttribute(name = "商业险#1导入结果")
    private String commercialInsuranceImportResult = "成功";

    @ExcelAttribute(name = "商业险#1失败原因")
    private String commercialInsuranceImportRemark;

    @ExcelAttribute(name = "商业险#2导入结果")
    private String secondCommercialInsuranceImportResult = "成功";

    @ExcelAttribute(name = "商业险#2失败原因")
    private String secondCommercialInsuranceImportRemark;

    public void setLeaseCarInsuranceExcelProperty(LeaseCarInsuranceExcel insurance) {
        super.setCarId(insurance.getCarId());
        super.setCarBrandName(insurance.getCarBrandName());
        super.setCarSeriesName(insurance.getCarSeriesName());
        super.setCarModelName(insurance.getCarModelName());
        super.setCarEngineNum(insurance.getCarEngineNum());
        super.setCarFrameNum(insurance.getCarFrameNum());
        super.setCarPlateNumber(insurance.getCarPlateNumber());
        super.setJqInsuranceExpireDate(insurance.getJqInsuranceExpireDate());
        super.setCommercialInsuranceExpireDate(insurance.getCommercialInsuranceExpireDate());
        super.setSecondCommercialInsuranceExpireDate(insurance.getSecondCommercialInsuranceExpireDate());
        super.setJqInsuranceId(insurance.getJqInsuranceId());
        super.setJqInsuranceWarrantyNum(insurance.getJqInsuranceWarrantyNum());
        super.setJqInsuranceCompanyId(insurance.getJqInsuranceCompanyId());
        super.setJqInsuranceCompanyName(insurance.getJqInsuranceCompanyName());
        super.setJqInsuranceCost(insurance.getJqInsuranceCost());
        super.setJqInsuranceEffectiveDate(insurance.getJqInsuranceEffectiveDate());
        super.setCommercialInsuranceId(insurance.getCommercialInsuranceId());
        super.setCommercialInsuranceWarrantyNum(insurance.getCommercialInsuranceWarrantyNum());
        super.setCommercialInsuranceCompanyId(insurance.getCommercialInsuranceCompanyId());
        super.setCommercialInsuranceCompanyName(insurance.getCommercialInsuranceCompanyName());
        super.setCommercialInsuranceCost(insurance.getCommercialInsuranceCost());
        super.setCommercialInsuranceEffectiveDate(insurance.getCommercialInsuranceEffectiveDate());
        super.setSecondCommercialInsuranceId(insurance.getSecondCommercialInsuranceId());
        super.setSecondCommercialInsuranceWarrantyNum(insurance.getSecondCommercialInsuranceWarrantyNum());
        super.setSecondCommercialInsuranceCompanyId(insurance.getSecondCommercialInsuranceCompanyId());
        super.setSecondCommercialInsuranceCompanyName(insurance.getSecondCommercialInsuranceCompanyName());
        super.setSecondCommercialInsuranceCost(insurance.getSecondCommercialInsuranceCost());
        super.setSecondCommercialInsuranceEffectiveDate(insurance.getSecondCommercialInsuranceEffectiveDate());
    }

    public void setUnifyFailure(String result, String remark) {
        this.jqInsuranceImportResult = result;
        this.commercialInsuranceImportResult = result;
        this.secondCommercialInsuranceImportResult = result;
        this.jqInsuranceImportRemark = remark;
        this.commercialInsuranceImportRemark = remark;
        this.secondCommercialInsuranceImportRemark = remark;
    }

    public void setJqInsuranceImportFailure(String result, String remark) {
        this.jqInsuranceImportResult = result;
        this.jqInsuranceImportRemark = remark;
    }

    public void setCommercialInsuranceImportFailure(String result, String remark) {
        this.commercialInsuranceImportResult = result;
        this.commercialInsuranceImportRemark = remark;
    }

    public void setSecondCommercialInsuranceImportFailure(String result, String remark) {
        this.secondCommercialInsuranceImportResult = result;
        this.secondCommercialInsuranceImportRemark = remark;
    }
}
