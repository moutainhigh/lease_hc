package com.hc.lease.order.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 报废 数据列表
 * Created by tong on 2018/8/7
 */
public class ScrapFindPageVo implements Serializable {
    @ApiModelProperty(value = "主键Id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "处理编号", hidden = false)
    private String  dualNumberName;
    @ApiModelProperty(value = "车辆状态", hidden = false)
    private String dealWayName;
    @ApiModelProperty(value = "合同号", hidden = false)
    private String completeContractNumber;
    @ApiModelProperty(value = "承租人名称", hidden = false)
    private String accountName;
    @ApiModelProperty(value = "承租人手机", hidden = false)
    private String accountPhone;
    @ApiModelProperty(value = "车牌号", hidden = false)
    private String plateNumber;
    @ApiModelProperty(value = "型号", hidden = false)
    private String modelName;
    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "合同主键Id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "车辆主键Id", hidden = false)
    private Long carId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDualNumberName() {
        return dualNumberName;
    }

    public void setDualNumberName(String dualNumberName) {
        this.dualNumberName = dualNumberName;
    }

    public String getDealWayName() {
        return dealWayName;
    }

    public void setDealWayName(String dealWayName) {
        this.dealWayName = dealWayName;
    }

    public String getCompleteContractNumber() {
        return completeContractNumber;
    }

    public void setCompleteContractNumber(String completeContractNumber) {
        this.completeContractNumber = completeContractNumber;
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

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    @Override
    public String toString() {
        return "ScrapFindPageVo{" +
                "id=" + id +
                ", dualNumberName='" + dualNumberName + '\'' +
                ", dealWayName='" + dealWayName + '\'' +
                ", completeContractNumber='" + completeContractNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountPhone='" + accountPhone + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", modelName='" + modelName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", contractId=" + contractId +
                ", carId=" + carId +
                '}';
    }
}
