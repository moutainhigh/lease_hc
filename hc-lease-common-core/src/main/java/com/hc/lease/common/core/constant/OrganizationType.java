package com.hc.lease.common.core.constant;

/**
 * 组织结构的类型 公司、部门、组
 * Created by tong on 2018/4/10.
 */
public enum OrganizationType {

    TYPE_COMPANY("company", "组织结构/公司"),
    TYPE_DEPARTMENT("department", "组织结构/部门"),
    TYPE_GROUP("group", "组织结构/组");

    private String value;

    private String description;

    private OrganizationType(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String value() {
        return value;
    }

    public String description() {
        return description;
    }

}
