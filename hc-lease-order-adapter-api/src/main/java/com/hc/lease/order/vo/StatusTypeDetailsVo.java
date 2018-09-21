package com.hc.lease.order.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 合同的 款项 对应的 支付结果 状态
 * Created by Administrator on 2017/8/30.
 */
public class StatusTypeDetailsVo implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Integer type;
    @ApiModelProperty(value = "未扣款数量", hidden = false)
    private Integer dualCount;
    @ApiModelProperty(value = "扣款中数量", hidden = false)
    private Integer dualingCount;
    @ApiModelProperty(value = "成功数量", hidden = false)
    private Integer successCount;
    @ApiModelProperty(value = "失败数量", hidden = false)
    private Integer failCount;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDualCount() {
        return dualCount;
    }

    public void setDualCount(Integer dualCount) {
        this.dualCount = dualCount;
    }

    public Integer getDualingCount() {
        return dualingCount;
    }

    public void setDualingCount(Integer dualingCount) {
        this.dualingCount = dualingCount;
    }

    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    public Integer getFailCount() {
        return failCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }
}
