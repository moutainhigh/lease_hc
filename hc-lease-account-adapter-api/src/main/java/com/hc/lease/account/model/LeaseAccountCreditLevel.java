package com.hc.lease.account.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 承租人信用评级实体类
 */
@Data
public class LeaseAccountCreditLevel implements Serializable {

    /**
     * 承租人信用评级表id
     */
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;

    /**
     * 注册用户/承租人主键id
     */
    @ApiModelProperty(value = "承租人id", hidden = false)
    private Long accountId;

    /**
     * 信用评级（A,B,C）
     */
    @ApiModelProperty(value = "信用评级（A,B,C）", hidden = false)
    private String level;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", hidden = false)
    private String remark;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", hidden = false)
    private Date updateTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", hidden = false)
    private Date createTime;

    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

}