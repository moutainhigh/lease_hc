

package com.hc.lease.order.vo;

import com.hc.lease.order.model.LeaseContractArchiveLocation;
import com.hc.lease.order.model.LeaseSchemeOrderAccount;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 月供管理列表 / 租金支付计划表 / 还款历史 VO
 */
public class LeasePostLendingVo implements Serializable {

    @ApiModelProperty(value = "主键id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "还款记录主键id", hidden = false)
    private Long repaymentId;
    @ApiModelProperty(value = "合同编号", hidden = false)
    private String completeContractNumber;
    @ApiModelProperty(value = "分公司名称", hidden = false)
    private String branchCompanyName;
    @ApiModelProperty(value = "承租人名称", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "承租人手机", hidden = false)
    private String accountPhone;
    @ApiModelProperty(value = "扣款日", hidden = false)
    private String repaymentDate;
    @ApiModelProperty(value = "期数", hidden = false)
    private String totalPeriod;
    @ApiModelProperty(value = "逾期天数", hidden = false)
    private Integer overdueDay;
    @ApiModelProperty(value = "扣款总额", hidden = false)
    private BigDecimal totlePrice;
    @ApiModelProperty(value = "费用明细/扣款方式/扣款结果", hidden = false)
    private List<RepaymentDetailsVo> repaymentDetails;
    @ApiModelProperty(value = "是否挂靠 0否 1是", hidden = false)
    private Integer status;
    @ApiModelProperty(value = "合同付款结果统计", hidden = false)
    private List<StatusTypeDetailsVo> statusTypeDetails;
    @ApiModelProperty(value = "累计逾期天数", hidden = false)
    private Integer totalOverdueDay;
    @ApiModelProperty(value = "失败累计", hidden = false)
    private Integer totalFail;
    @ApiModelProperty(value = "用户类型：0:个人;1:公司", hidden = false)
    private Integer accountType;

    @ApiModelProperty(value = "身份证号码", hidden = false)
    private String idCard;
    @ApiModelProperty(value = "银行代码", hidden = false)
    private String bankCode;
    @ApiModelProperty(value = "银行代码", hidden = false)
    private String bankName;
    @ApiModelProperty(value = "承租人还款银行账号", hidden = false)
    private String backCardNumber;
    @ApiModelProperty(value = "车牌号码", hidden = false)
    private String plateNumber;
    @ApiModelProperty(value = "合同开始日期", hidden = false)
    private String leaseStartTime;
    @ApiModelProperty(value = "合同结束日期", hidden = false)
    private String leaseEndTime;
    @ApiModelProperty(value = "扣款日", hidden = false)
    private Integer payDate;
    @ApiModelProperty(value = "承租人银行卡是否签约 0:否1:是", hidden = false)
    private Integer isSign;
    @ApiModelProperty(value = "银行预留手机号", hidden = false)
    private String bankPhone;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Long repaymentId) {
        this.repaymentId = repaymentId;
    }

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

    public String getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public String getTotalPeriod() {
        return totalPeriod;
    }

    public void setTotalPeriod(String totalPeriod) {
        this.totalPeriod = totalPeriod;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    public BigDecimal getTotlePrice() {
        return totlePrice;
    }

    public void setTotlePrice(BigDecimal totlePrice) {
        this.totlePrice = totlePrice;
    }

    public List<RepaymentDetailsVo> getRepaymentDetails() {
        return repaymentDetails;
    }

    public void setRepaymentDetails(List<RepaymentDetailsVo> repaymentDetails) {
        this.repaymentDetails = repaymentDetails;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<StatusTypeDetailsVo> getStatusTypeDetails() {
        return statusTypeDetails;
    }

    public void setStatusTypeDetails(List<StatusTypeDetailsVo> statusTypeDetails) {
        this.statusTypeDetails = statusTypeDetails;
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

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBackCardNumber() {
        return backCardNumber;
    }

    public void setBackCardNumber(String backCardNumber) {
        this.backCardNumber = backCardNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getLeaseStartTime() {
        return leaseStartTime;
    }

    public void setLeaseStartTime(String leaseStartTime) {
        this.leaseStartTime = leaseStartTime;
    }

    public String getLeaseEndTime() {
        return leaseEndTime;
    }

    public void setLeaseEndTime(String leaseEndTime) {
        this.leaseEndTime = leaseEndTime;
    }

    public Integer getPayDate() {
        return payDate;
    }

    public void setPayDate(Integer payDate) {
        this.payDate = payDate;
    }

    public Integer getIsSign() {
        return isSign;
    }

    public void setIsSign(Integer isSign) {
        this.isSign = isSign;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone;
    }
}
