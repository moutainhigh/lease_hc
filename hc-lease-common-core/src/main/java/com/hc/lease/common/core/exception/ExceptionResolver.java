package com.hc.lease.common.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * 自定义统一异常抛出
 */
public class ExceptionResolver extends AbstractHandlerExceptionResolver {
	final Logger log = LoggerFactory.getLogger(ExceptionResolver.class);

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

		ModelAndView view = new ModelAndView("jsonView");
		System.out.println("=======ExceptionResolver===1=====");
		if (ex instanceof GMException) {
			System.out.println("=======ExceptionResolver===2=====");
			String subCode = ((GMException) ex).getSubCode();
			view.addObject("status", ((GMException) ex).getStatus());
			view.addObject("error", true);
			view.addObject("result", ((GMException) ex).getResult());
			// view.addObject("errorCode", GMSOAException.ISV);
			view.addObject("subCode", subCode);
			view.addObject("errMsg", ex.getMessage());
			return view;
		} else if (ex instanceof HttpSessionRequiredException) {
			view.addObject("status", ((GMException) ex).getStatus());
			view.addObject("error", true);
			view.addObject("result", ((GMException) ex).getResult());
			// view.addObject("errorCode", GMSOAException.ISV);
			view.addObject("subCode", null);
			view.addObject("errMsg", null);
			return view;
		} else if (ex instanceof MissingServletRequestParameterException) {
			view.addObject("status", ((GMException) ex).getStatus());
			view.addObject("error", true);
			view.addObject("result", ((GMException) ex).getResult());
			// view.addObject("errorCode", GMSOAException.ISV);
			view.addObject("subCode", null);
			view.addObject("errMsg", ex.getMessage());
			return view;
		} else if (ex instanceof UndeclaredThrowableException) {
			GMException gMException = (GMException) ((UndeclaredThrowableException) ex).getUndeclaredThrowable();
			String subCode = gMException.getSubCode();
			view.addObject("status", gMException.getStatus());
			view.addObject("error", true);
			view.addObject("result", gMException.getResult());
			// view.addObject("errorCode", GMSOAException.ISV);
			view.addObject("subCode", subCode);
			view.addObject("errMsg", gMException.getErrMsg());
			return view;
		} else {
			try {
				view.addObject("status", ((GMException) ex).getStatus());
				view.addObject("error", true);
				view.addObject("result", ((GMException) ex).getResult());
				// view.addObject("errorCode", GMSOAException.ISP);
				view.addObject("subCode", null);
				view.addObject("errMsg", ex.getMessage());
				log.error("异常了exception==",ex);
				System.out.println("=======出现系统未捕获出来的异常=1=======");
			} catch (Exception e) {
				log.error("异常了exception==",ex);
				System.out.println("=======出现系统未捕获出来的异常=2=======");
				ex.printStackTrace();
			}
			return view;
		}
	}
}