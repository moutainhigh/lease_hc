package com.hc.lease.common.core.exception;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 接口数据返回封装
 *
 * @author Tong
 */
public class ResultHashMap extends HashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = -4970973511892646114L;
    public final static String ERROR = "error";// 错误状态 true/false
    public final static String RESULT = "result";// 返回结果集

    private String status = "status";// 回显状态码
    private String subCode = "subCode";// 回显类型码
    private String errMsg = "errMsg";// 回显信息

    private String pageCount = "pageCount";// 返回数据总条数/装载返回分页用到

    private String otherDate = "otherDate";// 其他数据

    public ResultHashMap() {
        this.put(ERROR, false);
    }

    public ResultHashMap(Object result) {
        /*
         * if (result instanceof java.util.List) { Map<String , Object> map =
		 * new HashMap<String, Object>(); map.put("data", result); result = map;
		 * }
		 */
        this.put(ERROR, false);
        this.put(RESULT, result);
    }

    public ResultHashMap(boolean bo, Object result) {
		/*
		 * if (result instanceof java.util.List) { Map<String , Object> map =
		 * new HashMap<String, Object>(); map.put("data", result); result = map;
		 * }
		 */
        this.put(ERROR, bo);
        this.put(RESULT, result);
    }

    /**
     * @param bo                  错误状态 false:没错、true有错
     * @param result              返回结果
     * @param gmExceptionConstant 自定义回显提示名称
     */
    public ResultHashMap(boolean bo, Object result, GMExceptionConstant gmExceptionConstant) {
		/*
		 * if (result instanceof java.util.List) { Map<String , Object> map =
		 * new HashMap<String, Object>(); map.put("data", result); result = map;
		 * }
		 */

        this.put(RESULT, result);
        this.put(ERROR, bo);
        this.put(subCode, gmExceptionConstant.getErrorCode());
        this.put(errMsg, gmExceptionConstant.getErrMsg());
        this.put(status, gmExceptionConstant.getStatus());
    }

    /**
     * @param bo                  错误状态 false:没错、true:有错
     * @param result              返回结果
     * @param gmExceptionConstant 自定义回显提示名称
     * @param count               返回数据总条数/装载返回分页用到
     */
    public ResultHashMap(boolean bo, Object result, GMExceptionConstant gmExceptionConstant, Integer count) {
        this.put(pageCount, count);
        this.put(RESULT, result);
        this.put(ERROR, bo);
        this.put(subCode, gmExceptionConstant.getErrorCode());
        this.put(errMsg, gmExceptionConstant.getErrMsg());
        this.put(status, gmExceptionConstant.getStatus());
    }

    /**
     * @param bo                  错误状态 false:没错、true:有错
     * @param result              返回结果
     * @param gmExceptionConstant 自定义回显提示名称
     * @param OTHERDATE           其他数据
     */
    public ResultHashMap(boolean bo, Object result, GMExceptionConstant gmExceptionConstant, Object OTHERDATE) {
        this.put(otherDate, OTHERDATE);
        this.put(RESULT, result);
        this.put(ERROR, bo);
        this.put(subCode, gmExceptionConstant.getErrorCode());
        this.put(errMsg, gmExceptionConstant.getErrMsg());
        this.put(status, gmExceptionConstant.getStatus());
    }

}
