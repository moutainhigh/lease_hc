package com.hc.lease.common.core.constant;

/**
 * 角色类型：0职位、1补充
 * Created by tong on 2018/8/27
 */
public enum AuthRoleType {

    company(0, "职位"),
    department(1, "补充");


    private Integer value;

    private String description;

    private AuthRoleType(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public Integer value() {
        return value;
    }

    public String description() {
        return description;
    }

}
