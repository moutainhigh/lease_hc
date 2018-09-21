package com.hc.lease.common.core.excel.poi.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 创建人：张建遵<br/>
 * 创建时间：2017/10/12<br/>
 * 说明：成本核对导入信息
 */
@Data
public class CostCheckReadInfo implements Serializable {
    private List<CostCheckTemplate> costCheckTemplates;
    /**
     * 成功数
     */
    private int successNum;
    /**
     * 失败数
     */
    private int failNum;

    @Override
    public String toString() {
        return "CostCheckReadInfo{" +
                "costCheckTemplates=" + costCheckTemplates +
                ", successNum=" + successNum +
                ", failNum=" + failNum +
                '}';
    }
}
