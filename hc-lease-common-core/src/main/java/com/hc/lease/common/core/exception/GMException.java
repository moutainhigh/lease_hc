package com.hc.lease.common.core.exception;

import hc.lease.common.util.ListUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GMException extends Exception implements Serializable {

    private static final long serialVersionUID = -2396344394815479161L;

    public static final String ISP = "ISP";// 系统内部
    public static final String ISV = "ISV";// 用户导致错误

    private String errorCode;
    private String subCode;
    private Integer status;
    private String errMsg;

    private Object result = "result";// 返回结果集

    public GMException() {
    }

    public GMException(String subCode, String message) {
        super(message);
        this.errorCode = ISV;
        this.subCode = subCode;
    }

    public GMException(GMExceptionConstant gmExceptionConstant) {
        super(gmExceptionConstant.getErrMsg());
        Map<String, Object> resultMap = new HashMap<String, Object>();
        //resultMap.put("msg", gmExceptionConstant.getErrorMsg());
        this.result = resultMap;
        this.errorCode = ISV;
        this.subCode = gmExceptionConstant.getErrorCode();
        this.status = gmExceptionConstant.getStatus();
        this.errMsg = gmExceptionConstant.getErrMsg();
    }

    public GMException(GMExceptionConstant gmExceptionConstant, Object object) {
        super(gmExceptionConstant.getErrMsg());
        Object object1 = ListUtil.objectIsNullToList(object);
        this.result = object1;
        this.errorCode = ISV;
        this.subCode = gmExceptionConstant.getErrorCode();
        this.status = gmExceptionConstant.getStatus();
        this.errMsg = gmExceptionConstant.getErrMsg();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
