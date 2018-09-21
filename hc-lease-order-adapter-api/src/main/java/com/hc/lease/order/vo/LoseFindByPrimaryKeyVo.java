package com.hc.lease.order.vo;

import com.hc.lease.order.model.LeaseContractIncomeExpe;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 丢失 数据列表
 * Created by tong on 2018/8/7
 */
public class LoseFindByPrimaryKeyVo implements Serializable {
    @ApiModelProperty(value = "承租人名称", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "承租人手机", hidden = false)
    private String accountPhone;
    @ApiModelProperty(value = "合同号", hidden = false)
    private String completeContractNumber;
    @ApiModelProperty(value = "车牌号", hidden = false)
    private String plateNumber;
    @ApiModelProperty(value = "车架号", hidden = false)
    private String cardFrameNumber;
    @ApiModelProperty(value = "品牌名称", hidden = false)
    private String brandsName;
    @ApiModelProperty(value = "系列名称", hidden = false)
    private String seriesName;
    @ApiModelProperty(value = "主键Id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "丢失备注", hidden = false)
    private String remarks;
    @ApiModelProperty(value = "处置方案", hidden = false)
    private String dealWayName;
    @ApiModelProperty(value = "最后更新", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "处置备注", hidden = false)
    private String dealRemarks;
    @ApiModelProperty(value = "合同主键Id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "车辆主键Id", hidden = false)
    private Long carId;
    @ApiModelProperty(value = "收入和支出 (跟进/处置/传值)", hidden = false)
    private List<LeaseContractIncomeExpe> incomeExpeList;
    @ApiModelProperty(value = "嵌套查询需要的source条件", hidden = false)
    private Integer findSource;

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

    public String getCompleteContractNumber() {
        return completeContractNumber;
    }

    public void setCompleteContractNumber(String completeContractNumber) {
        this.completeContractNumber = completeContractNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getCardFrameNumber() {
        return cardFrameNumber;
    }

    public void setCardFrameNumber(String cardFrameNumber) {
        this.cardFrameNumber = cardFrameNumber;
    }

    public String getBrandsName() {
        return brandsName;
    }

    public void setBrandsName(String brandsName) {
        this.brandsName = brandsName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDealWayName() {
        return dealWayName;
    }

    public void setDealWayName(String dealWayName) {
        this.dealWayName = dealWayName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDealRemarks() {
        return dealRemarks;
    }

    public void setDealRemarks(String dealRemarks) {
        this.dealRemarks = dealRemarks;
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
        return "LoseFindByPrimaryKeyVo{" +
                "accountName='" + accountName + '\'' +
                ", accountPhone='" + accountPhone + '\'' +
                ", completeContractNumber='" + completeContractNumber + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", cardFrameNumber='" + cardFrameNumber + '\'' +
                ", brandsName='" + brandsName + '\'' +
                ", seriesName='" + seriesName + '\'' +
                ", id=" + id +
                ", remarks='" + remarks + '\'' +
                ", dealWayName='" + dealWayName + '\'' +
                ", updateTime=" + updateTime +
                ", dealRemarks='" + dealRemarks + '\'' +
                ", contractId=" + contractId +
                ", carId=" + carId +
                ", incomeExpeList=" + incomeExpeList +
                ", findSource=" + findSource +
                '}';
    }
}
