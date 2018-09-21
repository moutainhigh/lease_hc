package com.hc.lease.common.core.excel.easyxls;

import com.hc.lease.common.core.exception.GMException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 导入excel
 * Created by tong on 2017/5/31.
 */
public interface LoadXlsService {

    String loadXls(HttpServletRequest request, RedirectAttributes redirectAttributes) throws GMException;

}
