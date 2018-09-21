package com.hc.lease.order.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeaseSchemeOrder implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "订单号", hidden = false)
    private String sn;
    @ApiModelProperty(value = "融租方案主键Id", hidden = false)
    private Long schemeId;
    @ApiModelProperty(value = "车辆主键Id", hidden = false)
    private Long cardId;
    @ApiModelProperty(value = "汽车价格", hidden = false)
    private BigDecimal carPrice;
    @ApiModelProperty(value = "渠道佣金", hidden = false)
    private BigDecimal commission;
    @ApiModelProperty(value = "实收保证金", hidden = false)
    private BigDecimal receiveMargin;

    @ApiModelProperty(value = "客户综合报价", hidden = false)
    private BigDecimal comprehensiveQuote;
    @ApiModelProperty(value = "全包价（元）", hidden = false)
    private BigDecimal totleCarPrice;
    @ApiModelProperty(value = "租金总额", hidden = false)
    private BigDecimal leasePrice;
    @ApiModelProperty(value = "月租", hidden = false)
    private BigDecimal monthlyRent;
    @ApiModelProperty(value = "出租人/合同方主键id", hidden = false)
    private Long contractPartyId;
    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "排序", hidden = false)
    private Integer sort;
    @ApiModelProperty(value = "订单状态", hidden = false)
    private Integer status;
    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;
    @ApiModelProperty(value = "扣款日", hidden = false)
    private Integer payDate;

    @ApiModelProperty(value = "品牌主键Id/适用车型", hidden = false)
    private Long contractBrandsId;
    @ApiModelProperty(value = "系列主键Id/适用车型", hidden = false)
    private Long contractSeriesId;
    @ApiModelProperty(value = "车型主键Id/适用车型", hidden = false)

    private Long contractModelId;
    @ApiModelProperty(value = "扣款日", hidden = false)
    private Integer periodCount;
    @ApiModelProperty(value = "父订单主键Id", hidden = false)
    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public Long getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Long schemeId) {
        this.schemeId = schemeId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public BigDecimal getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(BigDecimal carPrice) {
        this.carPrice = carPrice;
    }

    public BigDecimal getTotleCarPrice() {
        return totleCarPrice;
    }

    public void setTotleCarPrice(BigDecimal totleCarPrice) {
        this.totleCarPrice = totleCarPrice;
    }

    public BigDecimal getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public BigDecimal getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(BigDecimal leasePrice) {
        this.leasePrice = leasePrice;
    }

    public Long getContractPartyId() {
        return contractPartyId;
    }

    public void setContractPartyId(Long contractPartyId) {
        this.contractPartyId = contractPartyId;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public Integer getPayDate() {
        return payDate;
    }

    public void setPayDate(Integer payDate) {
        this.payDate = payDate;
    }

    public BigDecimal getComprehensiveQuote() {
        return comprehensiveQuote;
    }

    public void setComprehensiveQuote(BigDecimal comprehensiveQuote) {
        this.comprehensiveQuote = comprehensiveQuote;
    }

    public BigDecimal getReceiveMargin() {
        return receiveMargin;
    }

    public void setReceiveMargin(BigDecimal receiveMargin) {
        this.receiveMargin = receiveMargin;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Long getContractBrandsId() {
        return contractBrandsId;
    }

    public void setContractBrandsId(Long contractBrandsId) {
        this.contractBrandsId = contractBrandsId;
    }

    public Long getContractSeriesId() {
        return contractSeriesId;
    }

    public void setContractSeriesId(Long contractSeriesId) {
        this.contractSeriesId = contractSeriesId;
    }

    public Long getContractModelId() {
        return contractModelId;
    }

    public void setContractModelId(Long contractModelId) {
        this.contractModelId = contractModelId;
    }

    public Integer getPeriodCount() {
        return periodCount;
    }

    public void setPeriodCount(Integer periodCount) {
        this.periodCount = periodCount;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "LeaseSchemeOrder{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", schemeId=" + schemeId +
                ", cardId=" + cardId +
                ", carPrice=" + carPrice +
                ", commission=" + commission +
                ", receiveMargin=" + receiveMargin +
                ", comprehensiveQuote=" + comprehensiveQuote +
                ", totleCarPrice=" + totleCarPrice +
                ", leasePrice=" + leasePrice +
                ", monthlyRent=" + monthlyRent +
                ", contractPartyId=" + contractPartyId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", sort=" + sort +
                ", status=" + status +
                ", ids=" + ids +
                ", payDate=" + payDate +
                ", contractBrandsId=" + contractBrandsId +
                ", contractSeriesId=" + contractSeriesId +
                ", contractModelId=" + contractModelId +
                ", periodCount=" + periodCount +
                ", parentId=" + parentId +
                '}';
    }
}