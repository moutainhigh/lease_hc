package com.hc.lease.supplier.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseCarInventory implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "品牌主键Id", hidden = false)
    private Long brandsId;
    @ApiModelProperty(value = "系列主键Id", hidden = false)
    private Long seriesId;
    @ApiModelProperty(value = "车型主键Id", hidden = false)
    private Long modelId;
    @ApiModelProperty(value = "仓库主键id", hidden = false)
    private Long storehouseId;
    @ApiModelProperty(value = "当前库存数量", hidden = false)
    private Integer currentInventoryNumber;
    @ApiModelProperty(value = "销售/出租数量", hidden = false)
    private Integer leaseNumber;
    @ApiModelProperty(value = "调仓数量", hidden = false)
    private Integer transferStorehouseNumber;
    @ApiModelProperty(value = "入仓操作员主键id", hidden = false)
    private Long inStorehouseOperatorId;
    @ApiModelProperty(value = "入仓操作员名称", hidden = false)
    private String inStorehouseOperatorName;
    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;
    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandsId() {
        return brandsId;
    }

    public void setBrandsId(Long brandsId) {
        this.brandsId = brandsId;
    }

    public Long getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Long seriesId) {
        this.seriesId = seriesId;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Long getStorehouseId() {
        return storehouseId;
    }

    public void setStorehouseId(Long storehouseId) {
        this.storehouseId = storehouseId;
    }

    public Integer getCurrentInventoryNumber() {
        return currentInventoryNumber;
    }

    public void setCurrentInventoryNumber(Integer currentInventoryNumber) {
        this.currentInventoryNumber = currentInventoryNumber;
    }

    public Integer getLeaseNumber() {
        return leaseNumber;
    }

    public void setLeaseNumber(Integer leaseNumber) {
        this.leaseNumber = leaseNumber;
    }

    public Integer getTransferStorehouseNumber() {
        return transferStorehouseNumber;
    }

    public void setTransferStorehouseNumber(Integer transferStorehouseNumber) {
        this.transferStorehouseNumber = transferStorehouseNumber;
    }

    public Long getInStorehouseOperatorId() {
        return inStorehouseOperatorId;
    }

    public void setInStorehouseOperatorId(Long inStorehouseOperatorId) {
        this.inStorehouseOperatorId = inStorehouseOperatorId;
    }

    public String getInStorehouseOperatorName() {
        return inStorehouseOperatorName;
    }

    public void setInStorehouseOperatorName(String inStorehouseOperatorName) {
        this.inStorehouseOperatorName = inStorehouseOperatorName == null ? null : inStorehouseOperatorName.trim();
    }
}