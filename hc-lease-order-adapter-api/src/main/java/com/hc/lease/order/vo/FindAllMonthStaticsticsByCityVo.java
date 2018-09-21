package com.hc.lease.order.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 租金支付表 / 融租合同-月租还款计划明细
 * Created by Administrator on 2017/8/30.
 */
public class FindAllMonthStaticsticsByCityVo implements Serializable {

    @ApiModelProperty(value = "公司名称", hidden = false)
    private String branchCompanyName;
    @ApiModelProperty(value = "公司主键id", hidden = false)
    private Long branchCompanyId;
    @ApiModelProperty(value = "应扣总额", hidden = false)
    private BigDecimal totalSum;
    @ApiModelProperty(value = "已扣总额", hidden = false)
    private BigDecimal collectedSum;
    @ApiModelProperty(value = "未扣总额", hidden = false)
    private BigDecimal unCollectedSum;
    @ApiModelProperty(value = "应扣数量", hidden = false)
    private Integer totalCount;
    @ApiModelProperty(value = "已扣数量", hidden = false)
    private Integer collectedCount;
    @ApiModelProperty(value = "未扣数量", hidden = false)
    private Integer unCollectedCount;

    public String getBranchCompanyName() {
        return branchCompanyName;
    }

    public void setBranchCompanyName(String branchCompanyName) {
        this.branchCompanyName = branchCompanyName;
    }

    public Long getBranchCompanyId() {
        return branchCompanyId;
    }

    public void setBranchCompanyId(Long branchCompanyId) {
        this.branchCompanyId = branchCompanyId;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
    }

    public BigDecimal getCollectedSum() {
        return collectedSum;
    }

    public void setCollectedSum(BigDecimal collectedSum) {
        this.collectedSum = collectedSum;
    }

    public BigDecimal getUnCollectedSum() {
        return unCollectedSum;
    }

    public void setUnCollectedSum(BigDecimal unCollectedSum) {
        this.unCollectedSum = unCollectedSum;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCollectedCount() {
        return collectedCount;
    }

    public void setCollectedCount(Integer collectedCount) {
        this.collectedCount = collectedCount;
    }

    public Integer getUnCollectedCount() {
        return unCollectedCount;
    }

    public void setUnCollectedCount(Integer unCollectedCount) {
        this.unCollectedCount = unCollectedCount;
    }
}
