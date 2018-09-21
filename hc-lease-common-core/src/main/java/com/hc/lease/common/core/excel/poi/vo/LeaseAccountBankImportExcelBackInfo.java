package com.hc.lease.common.core.excel.poi.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 创建人：Qiang<br/>
 * 创建时间：2018/3/19<br/>
 * 说明：承租人银行卡导入结果反馈
 */
@Data
public class LeaseAccountBankImportExcelBackInfo implements Serializable {
    private List<Map> backInfo;
    /**
     * 成功数
     */
    private int successNum;
    /**
     * 失败数
     */
    private int failNum;

    //导入的数据
    List<LeaseAccountBankExcelTemplate> leaseAccountBankExcelTemplates;

    public List<Map> getBackInfo() {
        return backInfo;
    }

    public void setBackInfo(List<Map> backInfo) {
        this.backInfo = backInfo;
    }

    public int getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(int successNum) {
        this.successNum = successNum;
    }

    public int getFailNum() {
        return failNum;
    }

    public void setFailNum(int failNum) {
        this.failNum = failNum;
    }


    public List<LeaseAccountBankExcelTemplate> getLeaseAccountBankExcelTemplates() {
        return leaseAccountBankExcelTemplates;
    }

    public void setLeaseAccountBankExcelTemplates(List<LeaseAccountBankExcelTemplate> leaseAccountBankExcelTemplates) {
        this.leaseAccountBankExcelTemplates = leaseAccountBankExcelTemplates;
    }
}
