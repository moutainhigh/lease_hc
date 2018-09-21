package com.hc.lease.baseInfo.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 组织结构树形结构
 * 公司、部门、组织
 * Created by Tong on 2018/4/10.
 */
public class OrganizationTreeVo implements Serializable {

    @ApiModelProperty(value = "主键Id", hidden = false)
    private String id;
    @ApiModelProperty(value = "名称", hidden = false)
    private String name;
    @ApiModelProperty(value = "主管主键Id/后台用户主键Id", hidden = false)
    private Long leaderId;
    @ApiModelProperty(value = "主管名称", hidden = false)
    private String leaderName;
    @ApiModelProperty(value = "助理主键Id/后台用户主键Id", hidden = false)
    private Long assistantId;
    @ApiModelProperty(value = "助理名称", hidden = false)
    private String assistantName;
    @ApiModelProperty(value = "上级主管主键Id/后台用户主键Id", hidden = false)
    private Long parentLeaderId;
    @ApiModelProperty(value = "上级主管名称", hidden = false)
    private String parentLeaderName;
    @ApiModelProperty(value = "分管副总主键Id/后台用户主键Id", hidden = false)
    private Long deputyLeadeId;
    @ApiModelProperty(value = "分管副总名称", hidden = false)
    private String deputyLeaderName;
    @ApiModelProperty(value = "状态 0:禁用 1:启用", hidden = false)
    private Boolean isEnable;
    @ApiModelProperty(value = "排序", hidden = false)
    private Integer sort;

    @ApiModelProperty(value = "父级Id", hidden = false)
    private Long parentId;
    @ApiModelProperty(value = "父级类型/公司:company、部门:department、组:group", hidden = false)
    private Long parentType;

    @ApiModelProperty(value = "类型/公司:company、部门:department、组:group", hidden = false)
    private String type;

    public OrganizationTreeVo() {
    }

}
