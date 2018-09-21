package com.hc.lease.wx.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.WxSmsType;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.sms.SmsApi;
import com.hc.lease.wx.model.LeaseWxSms;
import com.hc.lease.wx.service.api.LeaseWxSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.adapter.api.LeaseWxCustomAdapter;
import com.hc.lease.wx.service.api.LeaseWxCustomService;
import com.hc.lease.wx.model.LeaseWxCustom;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 个人定制AdapterImpl
 * @author Qiang
 * @version 2018-03-23
 */
@Service("leaseWxCustomAdapter")
public class LeaseWxCustomAdapterImpl implements LeaseWxCustomAdapter {

	@Autowired
	private LeaseWxCustomService leaseWxCustomService;
    @Autowired
    private LeaseWxSmsService leaseWxSmsService;

    /**
    * 添加或者修改 需要的初始化参数
    *
    * @param paramsMap
    * @return
    */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public int updateDealStatus(Long id, Integer deal) {
        int row=leaseWxCustomService.updateDealStatus(id,deal);
        return row;
    }

    public List<LeaseWxCustom> findAllNoPage(Map<String, Object> paramsMap) {
        List<LeaseWxCustom>  leaseWxCustoms=leaseWxCustomService.findAllNoPage(paramsMap);
        return leaseWxCustoms;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxCustomService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseWxCustomService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseWxCustom record) throws GMException {
        record = leaseWxCustomService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseWxCustom record) throws GMException {
        record = leaseWxCustomService.insertSelective(record);
       LeaseWxSms leaseWxSms= leaseWxSmsService.findByType(WxSmsType.TYPE_APPOINTMENT);
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

    public int updateByPrimaryKeySelective(LeaseWxCustom record) throws GMException {
        int row = leaseWxCustomService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxCustom record) throws GMException {
        int row = leaseWxCustomService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseWxCustom selectByPrimaryKey(Long id) throws GMException {
        LeaseWxCustom leaseWxCustom = leaseWxCustomService.selectByPrimaryKey(id);
        return leaseWxCustom;
    }

    public int insertList(List<LeaseWxCustom> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseWxCustom> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseWxCustom> page = leaseWxCustomService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseWxCustom> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxCustom> leaseWxCustomList = leaseWxCustomService.findAll(paramsMap);
        return leaseWxCustomList;
    }

}
