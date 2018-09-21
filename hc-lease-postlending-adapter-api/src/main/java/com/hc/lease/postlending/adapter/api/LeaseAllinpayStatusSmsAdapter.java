package com.hc.lease.postlending.adapter.api;

import com.hc.lease.postlending.model.LeaseAllinpayStatusSms;
import com.hc.lease.common.core.dao.BaseAdapter;
import com.hc.lease.common.core.exception.GMException;
import java.util.Map;

/**
 * 通联扣款结果短信通知日志Adapter
 * @author Tong
 * @version 2017-09-13
 */

public interface LeaseAllinpayStatusSmsAdapter extends BaseAdapter<LeaseAllinpayStatusSms> {

    /**
    * 添加或者修改 需要的初始化参数
    * @param paramsMap
    * @return
    */
    Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException;

}
