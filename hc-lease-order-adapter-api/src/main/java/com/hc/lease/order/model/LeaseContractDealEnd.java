package com.hc.lease.order.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 贷后合同管理-结束处置
 */
public class LeaseContractDealEnd implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "融租合同主键id(结束处置/传值)", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "车辆主键id(结束处置/传值)", hidden = false)
    private Long carId;
    @ApiModelProperty(value = "处置方案 1还款中 2待过户 3过户结束 4待挂靠结束 5提前还款结束 6其他到期结束(结束处置/传值)", hidden = false)
    private Integer dealWay;
    @ApiModelProperty(value = "处置备注(结束处置/传值)", hidden = false)
    private String dealRemarks;
    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;
    @ApiModelProperty(value = "收入和支出(结束处置/传值)", hidden = false)
    private List<LeaseContractIncomeExpe> incomeExpeList;
    @ApiModelProperty(value = "嵌套查询需要的source条件", hidden = false)
    private Integer findSource;

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

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Integer getDealWay() {
        return dealWay == null ? 0 : dealWay;
    }

    public void setDealWay(Integer dealWay) {
        this.dealWay = dealWay;
    }

    public String getDealRemarks() {
        return dealRemarks;
    }

    public void setDealRemarks(String dealRemarks) {
        this.dealRemarks = dealRemarks == null ? null : dealRemarks.trim();
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

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public List<LeaseContractIncomeExpe> getIncomeExpeList() {
        return incomeExpeList;
    }

    public void setIncomeExpeList(List<LeaseContractIncomeExpe> incomeExpeList) {
        this.incomeExpeList = incomeExpeList;
    }

    public Integer getFindSource() {
        return findSource;
    }

    public void setFindSource(Integer findSource) {
        this.findSource = findSource;
    }

    @Override
    public String toString() {
        return "LeaseContractDealEnd{" +
                "id=" + id +
                ", contractId=" + contractId +
                ", carId=" + carId +
                ", dealWay=" + dealWay +
                ", dealRemarks='" + dealRemarks + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", ids=" + ids +
                ", incomeExpeList=" + incomeExpeList +
                ", findSource=" + findSource +
                '}';
    }
}