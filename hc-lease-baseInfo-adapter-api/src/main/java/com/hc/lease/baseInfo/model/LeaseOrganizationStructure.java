package com.hc.lease.baseInfo.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 组织结构
 */
public class LeaseOrganizationStructure implements Serializable {
    @ApiModelProperty(value = "主键id", hidden = false)
    private Long id;
    @ApiModelProperty(value = "编号", hidden = false)
    private String number;
    @ApiModelProperty(value = "名称", hidden = false)
    private String name;
    @ApiModelProperty(value = "父级Id", hidden = false)
    private Long parentId;
    @ApiModelProperty(value = "主管主键id", hidden = false)
    private Long leaderId;
    @ApiModelProperty(value = "主管名称", hidden = false)
    private String leaderName;
    @ApiModelProperty(value = "主管手机", hidden = false)
    private String leaderPhone;
    @ApiModelProperty(value = "助理主键id", hidden = false)
    private Long assistantId;
    @ApiModelProperty(value = "助理名称", hidden = false)
    private String assistantName;
    @ApiModelProperty(value = "助理手机", hidden = false)
    private String assistantPhone;
    @ApiModelProperty(value = "上级主管主键id", hidden = false)
    private Long parentLeaderId;
    @ApiModelProperty(value = "上级主管名称", hidden = false)
    private String parentLeaderName;
    @ApiModelProperty(value = "上级主管手机", hidden = false)
    private String parentLeaderPhone;
    @ApiModelProperty(value = "分管副总主键Id/后台用户主键Id", hidden = false)
    private Long deputyLeadeId;
    @ApiModelProperty(value = "分管副总名称", hidden = false)
    private String deputyLeaderName;
    @ApiModelProperty(value = "分管副总手机", hidden = false)
    private String deputyLeaderPhone;
    @ApiModelProperty(value = "创建日期", hidden = false)
    private Date createTime;
    @ApiModelProperty(value = "修改日期", hidden = false)
    private Date updateTime;
    @ApiModelProperty(value = "创建人主键id", hidden = false)
    private Long createBy;
    @ApiModelProperty(value = "修改人主键id", hidden = false)
    private Long updateBy;
    @ApiModelProperty(value = "状态 0:禁用 1:启用", hidden = false)
    private Integer isEnable;
    @ApiModelProperty(value = "排序", hidden = false)
    private Integer sort;
    @ApiModelProperty(value = "描述", hidden = false)
    private String remark;
    @ApiModelProperty(value = "类型/公司:company、部门:department、组:group", hidden = false)
    private String type;
    @ApiModelProperty(value = "左编码值", hidden = false)
    private Integer lft;
    @ApiModelProperty(value = "右编码值", hidden = false)
    private Integer rgt;
    @ApiModelProperty(value = "层级", hidden = false)
    private Integer level;
    @ApiModelProperty(value = "是否默认/默认的数据不删除", hidden = false)
    private Integer isDefault;

    @ApiModelProperty(value = "主键id", hidden = false)
    private List<Long> ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName == null ? null : leaderName.trim();
    }

    public String getLeaderPhone() {
        return leaderPhone;
    }

    public void setLeaderPhone(String leaderPhone) {
        this.leaderPhone = leaderPhone == null ? null : leaderPhone.trim();
    }

    public Long getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(Long assistantId) {
        this.assistantId = assistantId;
    }

    public String getAssistantName() {
        return assistantName;
    }

    public void setAssistantName(String assistantName) {
        this.assistantName = assistantName == null ? null : assistantName.trim();
    }

    public String getAssistantPhone() {
        return assistantPhone;
    }

    public void setAssistantPhone(String assistantPhone) {
        this.assistantPhone = assistantPhone == null ? null : assistantPhone.trim();
    }

    public Long getParentLeaderId() {
        return parentLeaderId;
    }

    public void setParentLeaderId(Long parentLeaderId) {
        this.parentLeaderId = parentLeaderId;
    }

    public String getParentLeaderName() {
        return parentLeaderName;
    }

    public void setParentLeaderName(String parentLeaderName) {
        this.parentLeaderName = parentLeaderName == null ? null : parentLeaderName.trim();
    }

    public String getParentLeaderPhone() {
        return parentLeaderPhone;
    }

    public void setParentLeaderPhone(String parentLeaderPhone) {
        this.parentLeaderPhone = parentLeaderPhone == null ? null : parentLeaderPhone.trim();
    }

    public Long getDeputyLeadeId() {
        return deputyLeadeId;
    }

    public void setDeputyLeadeId(Long deputyLeadeId) {
        this.deputyLeadeId = deputyLeadeId;
    }

    public String getDeputyLeaderName() {
        return deputyLeaderName;
    }

    public void setDeputyLeaderName(String deputyLeaderName) {
        this.deputyLeaderName = deputyLeaderName == null ? null : deputyLeaderName.trim();
    }

    public String getDeputyLeaderPhone() {
        return deputyLeaderPhone;
    }

    public void setDeputyLeaderPhone(String deputyLeaderPhone) {
        this.deputyLeaderPhone = deputyLeaderPhone == null ? null : deputyLeaderPhone.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getLft() {
        return lft;
    }

    public void setLft(Integer lft) {
        this.lft = lft;
    }

    public Integer getRgt() {
        return rgt;
    }

    public void setRgt(Integer rgt) {
        this.rgt = rgt;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}