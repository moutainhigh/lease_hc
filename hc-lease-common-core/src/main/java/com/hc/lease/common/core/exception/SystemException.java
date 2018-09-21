package com.hc.lease.common.core.exception;

/**
 * Created by Administrator on 2017/4/20.
 */
@SuppressWarnings("serial")
public class SystemException extends Exception {


    public SystemException(String msg) {
        super(msg);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }

    public SystemException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
