package com.hc.lease.wx.adapter.api;

import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.excel.poi.vo.WxCarSchemeImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.WxCarSchemeTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.wx.model.LeaseWxCarScheme;

import java.util.List;
import java.util.Map;

/**
 * 车辆信息-融租方案Adapter
 *
 * @author Qiang
 * @version 2017-11-29
 */

public interface LeaseWxCarSchemeAdapter extends BaseAdapter<LeaseWxCarScheme> {

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    /**
     * 处理小程序车辆方案导入
     *
     * @param wxCarSchemeTemplateList 车辆方案数据
     * @param userSession
     * @return
     * @throws GMException
     */
    WxCarSchemeImportExcelBackInfo importExcelWxCarScheme(List<WxCarSchemeTemplate> wxCarSchemeTemplateList, UserSession userSession) throws GMException;

}
