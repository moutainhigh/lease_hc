package com.hc.lease.account.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 承租人评级列表
 *
 * @author xuzhencheng
 * @since 2018-01-15
 */
@Data
public class AccountCreditLevelVo implements Serializable {

    /**承租人id*/
    @ApiModelProperty(value = "承租人ID", hidden = false)
    private Long accountId;

    /**承租人名称*/
    @ApiModelProperty(value = "承租人名字", hidden = false)
    private String accountName;

    /**手机号*/
    @ApiModelProperty(value = "手机号码", hidden = false)
    private String phone;

    /**分公司名称*/
    @ApiModelProperty(value = "分公司名称", hidden = false)
    private String companyName;

    /**逾期次数*/
    @ApiModelProperty(value = "逾期次数", hidden = false)
    private Integer times;

    /**逾期天数*/
    @ApiModelProperty(value = "逾期天数", hidden = false)
    private Integer days;

    /**评级*/
    @ApiModelProperty(value = "评级", hidden = false)
    private String level;

    /**创建时间*/
    private Date createTime;
}
