package com.hc.lease.baseInfo.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 新增或者修改需要的上级单位的数据
 * Created by Tong on 2017/4/19.
 */
public class FindParentTreeVo implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "名称", hidden = false)
    private String name;
    @ApiModelProperty(value = "父级Id", hidden = false)
    private Long parentId;
    @ApiModelProperty(value = "类型/公司:company、部门:department、组:group", hidden = false)
    private String type;
    @ApiModelProperty(value = "层级", hidden = false)
    private Integer level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
