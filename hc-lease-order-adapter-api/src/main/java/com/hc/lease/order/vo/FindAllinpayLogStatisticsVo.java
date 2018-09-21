package com.hc.lease.order.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 还款历史 查看里面的统计部分
 * Created by Administrator on 2018/9/7
 */
public class FindAllinpayLogStatisticsVo implements Serializable {

    @ApiModelProperty(value = "合同编号", hidden = false)
    private String completeContractNumber;
    @ApiModelProperty(value = "分公司", hidden = false)
    private String branchCompanyName;
    @ApiModelProperty(value = "承租人", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "手机", hidden = false)
    private String accountPhone;
    @ApiModelProperty(value = "逾期天数累计", hidden = false)
    private Integer totalOverdueDay;
    @ApiModelProperty(value = "失败累计", hidden = false)
    private Integer totalFail;

    public String getCompleteContractNumber() {
        return completeContractNumber;
    }

    public void setCompleteContractNumber(String completeContractNumber) {
        this.completeContractNumber = completeContractNumber;
    }

    public String getBranchCompanyName() {
        return branchCompanyName;
    }

    public void setBranchCompanyName(String branchCompanyName) {
        this.branchCompanyName = branchCompanyName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPhone() {
        return accountPhone;
    }

    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
    }

    public Integer getTotalOverdueDay() {
        return totalOverdueDay;
    }

    public void setTotalOverdueDay(Integer totalOverdueDay) {
        this.totalOverdueDay = totalOverdueDay;
    }

    public Integer getTotalFail() {
        return totalFail;
    }

    public void setTotalFail(Integer totalFail) {
        this.totalFail = totalFail;
    }
}
