package com.hc.lease.order.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LeaseUpdateMonthlyrent implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "合同id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "用户id", hidden = false)
    private Long userId;
    @ApiModelProperty(value = "修改后租金", hidden = false)
    private BigDecimal newMonthlyrent;
    @ApiModelProperty(value = "修改前租金", hidden = false)
    private BigDecimal oldMonthlyrent;
    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getNewMonthlyrent() {
        return newMonthlyrent;
    }

    public void setNewMonthlyrent(BigDecimal newMonthlyrent) {
        this.newMonthlyrent = newMonthlyrent;
    }

    public BigDecimal getOldMonthlyrent() {
        return oldMonthlyrent;
    }

    public void setOldMonthlyrent(BigDecimal oldMonthlyrent) {
        this.oldMonthlyrent = oldMonthlyrent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
}