package com.hc.lease.wx.adapter.api;

import com.hc.lease.common.core.excel.poi.vo.WxCarOtherSchemeImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.WxCarOtherSchemeTemplate;
import com.hc.lease.wx.model.LeaseWxCarOtherScheme;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;

import java.util.List;
import java.util.Map;

/**
 * 车辆1+X方案Adapter
 * @author Qiang
 * @version 2018-04-10
 */

public interface LeaseWxCarOtherSchemeAdapter extends BaseAdapter<LeaseWxCarOtherScheme> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

    WxCarOtherSchemeImportExcelBackInfo importExcelWxCarOtherScheme(List<WxCarOtherSchemeTemplate> wxCarOtherSchemeTemplates) throws GMException;
}
