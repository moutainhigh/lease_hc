package com.hc.lease.account.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 紧急联系人
 * Created by tong on 2017/6/7.
 */
public class EmergencyContactVo implements Serializable{
    @ApiModelProperty(value = "紧急联系人姓名", hidden = false)
    private String emergencyContactName;

    @ApiModelProperty(value = "紧急联系人与本人关系", hidden = false)
    private String emergencyContactRelationship;

    @ApiModelProperty(value = "急联系人手机", hidden = false)
    private String emergencyContactPhone;

    @ApiModelProperty(value = "顺序", hidden = false)
    private Integer sort;

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactRelationship() {
        return emergencyContactRelationship;
    }

    public void setEmergencyContactRelationship(String emergencyContactRelationship) {
        this.emergencyContactRelationship = emergencyContactRelationship;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
