package com.hc.lease.supplier.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 车辆保险信息查询对象
 * Created by LJ on 2018/4/17
 */
@Data
public class CarInsuranceExportQuery implements Serializable {

    /**
     * 当期页码
     */
    private Integer pageNum;

    /**
     * 每页数据量
     */
    private Integer pageSize;

    /**
     * 保险年分
     */
    private Integer insuranceYearNum = 1;

    /**
     * 保险到期日期起
     */
    private Date expireBeginDate;

    /**
     * 保险到期日期止
     */
    private Date expireEndDate;
}
