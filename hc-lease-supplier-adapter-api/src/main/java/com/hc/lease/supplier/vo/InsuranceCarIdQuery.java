package com.hc.lease.supplier.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by LJ on 2018/4/17
 */
@Data
@ApiModel
public class InsuranceCarIdQuery implements Serializable {

    /**
     * 当期页码
     */
    @ApiModelProperty(value = "当期页码")
    private Integer pageNum = 1;

    /**
     * 每页数据量
     */
    @ApiModelProperty(value = "分页大小")
    private Integer pageSize = 10;

    /**
     * 保险到期日期起
     */
    @ApiModelProperty(value = "保险到期日期起")
    private Date expireBeginDate;

    /**
     * 保险到期日期止
     */
    @ApiModelProperty(value = "保险到期日期止")
    private Date expireEndDate;
}
