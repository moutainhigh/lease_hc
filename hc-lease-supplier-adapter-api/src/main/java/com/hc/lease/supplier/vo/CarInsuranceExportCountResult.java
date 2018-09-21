package com.hc.lease.supplier.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 车辆保险Export导入统计结果
 * Created by LJ on 2018/4/20
 */
@Data
public class CarInsuranceExportCountResult implements Serializable {

    //导入成功数量
    private Integer succeedNum;

    //导入失败数量
    private Integer failureNum;

    private List<CarInsuranceImportResultExcel> list;

    public CarInsuranceExportCountResult(Integer succeedNum, Integer failureNum, List<CarInsuranceImportResultExcel> list) {
        this.succeedNum = succeedNum;
        this.failureNum = failureNum;
        this.list = list;
    }
}
