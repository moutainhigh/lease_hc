package com.hc.lease.baseInfo.model;

import java.io.Serializable;

/**
 * 使用和被使用的数据
 */
public class LeaseUseUsed implements Serializable{
    private Long id;

    private Long useId;

    private String useName;

    private Long usedId;

    private String usedName;

    private String useType;

    private String usedType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUseId() {
        return useId;
    }

    public void setUseId(Long useId) {
        this.useId = useId;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName == null ? null : useName.trim();
    }

    public Long getUsedId() {
        return usedId;
    }

    public void setUsedId(Long usedId) {
        this.usedId = usedId;
    }

    public String getUsedName() {
        return usedName;
    }

    public void setUsedName(String usedName) {
        this.usedName = usedName == null ? null : usedName.trim();
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType == null ? null : useType.trim();
    }

    public String getUsedType() {
        return usedType;
    }

    public void setUsedType(String usedType) {
        this.usedType = usedType == null ? null : usedType.trim();
    }
}