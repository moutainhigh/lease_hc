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
public class FindAccountCreditLevelVo implements Serializable {

    /**
     * 承租人/手机
     */
    @ApiModelProperty(value = "手机", hidden = false)
    private String accountNameOrPhone;

    /**
     * 录入开始时间
     */
    @ApiModelProperty(value = "录入开始日期", hidden = false)
    private Date startTime;

    /**
     * 录入结束时间
     */
    @ApiModelProperty(value = "录入结束时间", hidden = false)
    private Date finishTime;

    /**
     * 评级
     */
    @ApiModelProperty(value = "评级", hidden = false)
    private String level;

    /**
     * 最小逾期次数
     */
    @ApiModelProperty(value = "最小逾期次数", hidden = false)
    private Integer minTimes;

    /**
     * 最大逾期次数
     */
    @ApiModelProperty(value = "最大逾期次数", hidden = false)
    private Integer maxTimes;

    /**
     * 分公司名称
     */
    @ApiModelProperty(value = "分公司名称", hidden = false)
    private String companyName;

    private Integer pageNum = 1;

    private Integer pageSize = 10;
}
