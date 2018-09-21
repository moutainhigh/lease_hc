package com.hc.lease.common.core.excel.poi.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 创建人：tong<br/>
 * 创建时间：2018/1/7<br/>
 * 说明：小程序车辆数据导入结果反馈
 */
@Data
public class LeaseBranchCompanyExcelBackInfo implements Serializable {
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
    List<LeaseBranchCompanyTemplate> leaseBranchCompanyTemplates;

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

    public List<LeaseBranchCompanyTemplate> getLeaseBranchCompanyTemplates() {
        return leaseBranchCompanyTemplates;
    }

    public void setLeaseBranchCompanyTemplates(List<LeaseBranchCompanyTemplate> leaseBranchCompanyTemplates) {
        this.leaseBranchCompanyTemplates = leaseBranchCompanyTemplates;
    }

}
