package com.hc.lease.wx.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.model.LeaseArea;
import com.hc.lease.baseInfo.service.api.LeaseAreaService;
import com.hc.lease.common.core.constant.WxSmsType;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.sms.SmsApi;
import com.hc.lease.wx.model.LeaseWxSms;
import com.hc.lease.wx.service.api.LeaseWxSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.adapter.api.LeaseWxAgentAdapter;
import com.hc.lease.wx.service.api.LeaseWxAgentService;
import com.hc.lease.wx.model.LeaseWxAgent;

import hc.lease.common.util.ListUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 代理AdapterImpl
 * @author Qiang
 * @version 2017-11-29
 */
@Service("leaseWxAgentAdapter")
public class LeaseWxAgentAdapterImpl implements LeaseWxAgentAdapter {

	@Autowired
	private LeaseWxAgentService leaseWxAgentService;
    @Autowired
    private LeaseAreaService leaseAreaService;

    @Autowired
    private LeaseWxSmsService leaseWxSmsService;

    /**
    * 添加或者修改 需要的初始化参数
    *
    * @param paramsMap
    * @return
    */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {

        List<LeaseArea> leaseAreaList=leaseAreaService.findAreaByEnableAndModel(null);
        Map<String,Object> map=new HashMap();
        map.put("leaseAreaList",leaseAreaList);
        return map;
    }

    public int updateDealStatus(Long id, Integer deal) {
       int row = leaseWxAgentService.updateDealStatus(id,deal);
        return row;
    }

    public List<LeaseWxAgent> findAllNoPage(Map<String, Object> paramsMap) {
        List<LeaseWxAgent> leaseWxAgents=leaseWxAgentService.findAllNoPage(paramsMap);
        return leaseWxAgents;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxAgentService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseWxAgentService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseWxAgent record) throws GMException {
        record = leaseWxAgentService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseWxAgent record) throws GMException {
        record = leaseWxAgentService.insertSelective(record);
        LeaseWxSms leaseWxSms = leaseWxSmsService.findByType(WxSmsType.TYPE_AGENT);
        if(leaseWxSms!=null) {
            String callPhone = leaseWxSms.getCallPhone();
            String[] split = callPhone.split(",");
            if (split.length > 1) {
                SmsApi.sendMsg(callPhone, leaseWxSms.getSmsContent() + record.getId() + "【合创汽车金融】", true);
            } else {
                SmsApi.sendMsg(callPhone, leaseWxSms.getSmsContent() + record.getId() + "【合创汽车金融】", false);
            }
        }
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseWxAgent record) throws GMException {
        int row = leaseWxAgentService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxAgent record) throws GMException {
        int row = leaseWxAgentService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseWxAgent selectByPrimaryKey(Long id) throws GMException {
        LeaseWxAgent leaseWxAgent = leaseWxAgentService.selectByPrimaryKey(id);
        return leaseWxAgent;
    }

    public int insertList(List<LeaseWxAgent> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseWxAgent> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseWxAgent> page = leaseWxAgentService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseWxAgent> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxAgent> leaseWxAgentList = leaseWxAgentService.findAll(paramsMap);
        return leaseWxAgentList;
    }

}
