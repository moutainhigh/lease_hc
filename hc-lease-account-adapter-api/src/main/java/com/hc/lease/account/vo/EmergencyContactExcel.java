package com.hc.lease.account.vo;

import com.hc.lease.common.core.excel.easyxls.annotation.ExcelAttribute;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 紧急联系人Excel导出
 * Created by tong on 2017/6/7.
 */
@Data
public class EmergencyContactExcel implements Serializable{

    @ExcelAttribute(column = "A", name = "身份证(必填)")
    private String idCard;

    @ExcelAttribute(column = "B", name = "紧急联系人姓名")
    private String emergencyContactName;

    @ExcelAttribute(column = "C", name = "紧急联系人与本人关系")
    private String emergencyContactRelationship;

    @ExcelAttribute(column = "D", name = "紧急联系人手机")
    private String emergencyContactPhone;

  /*  @ExcelAttribute(column = "E", name = "紧急联系人地址")
    private String emergencyContactAddredss;*/

    /*@ExcelAttribute(column = "F", name = "顺序")
    private Integer sort;*/
}
