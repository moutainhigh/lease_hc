package com.aipg.common;

import java.io.Serializable;


/**
 * 组装报文头部
 */
public class MakeReq implements Serializable {
    private String level;//处理级别 0-9  0优先级最低，默认为5
    private String dataType;//数据格式
    private String version;//版本

    public MakeReq() {
    }

    public MakeReq(String level, String dataType, String version) {
        this.level = level;
        this.dataType = dataType;
        this.version = version;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "MakeReq{" +
                "level='" + level + '\'' +
                ", dataType='" + dataType + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
