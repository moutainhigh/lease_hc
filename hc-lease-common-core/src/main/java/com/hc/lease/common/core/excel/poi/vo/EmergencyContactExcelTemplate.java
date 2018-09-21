package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.easyxls.annotation.ExcelAttribute;
import lombok.Data;

import java.io.Serializable;

/**
 * 紧急联系人Excel导出
 * Created by qiang on 2018/3/19.
 */
@Data
public class EmergencyContactExcelTemplate implements Serializable{

    @ExcelAttribute(column = "A", name = "身份证(必填)")
    private String idCard;

    @ExcelAttribute(column = "B", name = "紧急联系人姓名")
    private String emergencyContactName;

    @ExcelAttribute(column = "C", name = "紧急联系人与本人关系")
    private String emergencyContactRelationship;

    @ExcelAttribute(column = "D", name = "紧急联系人手机")
    private String emergencyContactPhone;

   /* @ExcelAttribute(column = "E", name = "紧急联系人地址")
    private String emergencyContactAddredss;*/

    @ExcelAttribute(column = "E", name = "导入结果")
    private String updateState;

    private Integer sort;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

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



    /*public String getUpdateState() {
        return updateState;
    }

    public void setUpdateState(String updateState) {
        this.updateState = updateState;
    }*/
}
