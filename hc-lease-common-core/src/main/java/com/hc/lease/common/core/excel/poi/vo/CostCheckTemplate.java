package com.hc.lease.common.core.excel.poi.vo;

import com.hc.lease.common.core.excel.poi.annotation.CostCheckExcelCol;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/9/28<br/>
 * 说明：
 */
@Data
@CostCheckExcelCol("成本核对信息")
public class CostCheckTemplate implements Serializable {
    @CostCheckExcelCol("车架号(必填)")
    private String cardFrameNumber;
    @CostCheckExcelCol("含税车价(必填)")
    private BigDecimal invoicedCarPrice;
    @CostCheckExcelCol("购置税(必填)")
    private BigDecimal purchaseTax;
    @CostCheckExcelCol("车发票号(选填)")
    private String invoiceNumber;
    @CostCheckExcelCol("导入结果(非填项)")
    private String updateState;

}
