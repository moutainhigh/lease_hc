package com.hc.lease.common.core.constant;

/**
 * 组织结构类型/公司:company、部门:department、组:group
 * Created by tong on 2018/8/27
 */
public enum OrganizationStructureType {

    company("company", "公司"),
    department("department", "部门"),
    group("group", "组");


    private String value;

    private String description;

    private OrganizationStructureType(String value, String description) {
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
