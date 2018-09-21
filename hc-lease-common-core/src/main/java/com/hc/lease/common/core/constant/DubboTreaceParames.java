package com.hc.lease.common.core.constant;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 统一接口跟踪参数
 */
public class DubboTreaceParames implements Serializable {

    @ApiModelProperty(value = "接口名称", hidden = false)
    private String treaceInterfaceName;

    @ApiModelProperty(value = "接口方法名称", hidden = false)
    private String treaceMethodName;

    @ApiModelProperty(value = "操作用户主键id", hidden = false)
    private Long treaceUserId;

    @ApiModelProperty(value = "操作用户名称", hidden = false)
    private String treaceUserName;

    @ApiModelProperty(value = "操作时间", hidden = false)
    private Date treaceTime;

    @ApiModelProperty(value = "接口调用跟踪参数、此参数用于串连服务，同一个调用过程此参数相同，方便追踪", hidden = false)
    private String treace;

    public String getTreaceInterfaceName() {
        return treaceInterfaceName;
    }

    public void setTreaceInterfaceName(String treaceInterfaceName) {
        this.treaceInterfaceName = treaceInterfaceName;
    }

    public String getTreaceMethodName() {
        return treaceMethodName;
    }

    public void setTreaceMethodName(String treaceMethodName) {
        this.treaceMethodName = treaceMethodName;
    }

    public Long getTreaceUserId() {
        return treaceUserId;
    }

    public void setTreaceUserId(Long treaceUserId) {
        this.treaceUserId = treaceUserId;
    }

    public String getTreaceUserName() {
        return treaceUserName;
    }

    public void setTreaceUserName(String treaceUserName) {
        this.treaceUserName = treaceUserName;
    }

    public Date getTreaceTime() {
        return treaceTime;
    }

    public void setTreaceTime(Date treaceTime) {
        this.treaceTime = treaceTime;
    }

    public String getTreace() {
        return treace;
    }

    public void setTreace(String treace) {
        this.treace = treace;
    }

    @Override
    public String toString() {
        return "DubboTreaceParames{" +
                "treaceInterfaceName='" + treaceInterfaceName + '\'' +
                ", treaceMethodName='" + treaceMethodName + '\'' +
                ", treaceUserId=" + treaceUserId +
                ", treaceUserName='" + treaceUserName + '\'' +
                ", treaceTime=" + treaceTime +
                ", treace='" + treace + '\'' +
                '}';
    }
}