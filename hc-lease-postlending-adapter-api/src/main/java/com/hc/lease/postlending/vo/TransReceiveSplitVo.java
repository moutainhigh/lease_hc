package com.hc.lease.postlending.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 接收 支付参数封装
 * 通联支付拆单 批量协议支付
 * Created by tong on 2017/6/10.
 */
public class TransReceiveSplitVo implements Serializable {

    @ApiModelProperty(value = "通联支付超额拆分交易明细主键id", hidden = false, required = true)
    Long allinpaySplitId;

    @ApiModelProperty(value = "通联支付超额拆分交易明细主键id", hidden = false, required = true)
    List<Long> allinpaySplitIds;

    public Long getAllinpaySplitId() {
        return allinpaySplitId;
    }

    public void setAllinpaySplitId(Long allinpaySplitId) {
        this.allinpaySplitId = allinpaySplitId;
    }

    public List<Long> getAllinpaySplitIds() {
        return allinpaySplitIds;
    }

    public void setAllinpaySplitIds(List<Long> allinpaySplitIds) {
        this.allinpaySplitIds = allinpaySplitIds;
    }

    @Override
    public String toString() {
        return "TransReceiveSplitVo{" +
                "allinpaySplitId=" + allinpaySplitId +
                ", allinpaySplitIds=" + allinpaySplitIds +
                '}';
    }
}
