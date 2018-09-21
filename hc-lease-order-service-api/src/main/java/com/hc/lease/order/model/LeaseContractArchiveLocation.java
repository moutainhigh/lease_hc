package com.hc.lease.order.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class LeaseContractArchiveLocation implements Serializable{
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "融租合同主键Id", hidden = false)
    private Long contractId;
    @ApiModelProperty(value = "归档位置主键Id", hidden = false)
    private Long archiveLocationId;
    @ApiModelProperty(value = "归档号", hidden = false)
    private String archiveNumber;
    @ApiModelProperty(value = "级别", hidden = false)
    private Integer level;

    //显示用
    private String archiveLocationName;

    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

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

    public Long getArchiveLocationId() {
        return archiveLocationId;
    }

    public void setArchiveLocationId(Long archiveLocationId) {
        this.archiveLocationId = archiveLocationId;
    }

    public String getArchiveNumber() {
        return archiveNumber;
    }

    public void setArchiveNumber(String archiveNumber) {
        this.archiveNumber = archiveNumber == null ? null : archiveNumber.trim();
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getArchiveLocationName() {
        return archiveLocationName;
    }

    public void setArchiveLocationName(String archiveLocationName) {
        this.archiveLocationName = archiveLocationName;
    }
}