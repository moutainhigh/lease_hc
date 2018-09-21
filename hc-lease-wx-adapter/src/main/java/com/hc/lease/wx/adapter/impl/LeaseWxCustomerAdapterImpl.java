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

import com.hc.lease.wx.adapter.api.LeaseWxCustomerAdapter;
import com.hc.lease.wx.service.api.LeaseWxCustomerService;
import com.hc.lease.wx.model.LeaseWxCustomer;

import hc.lease.common.util.ListUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 预约客户AdapterImpl
 * @author Qiang
 * @version 2017-11-29
 */
@Service("leaseWxCustomerAdapter")
public class LeaseWxCustomerAdapterImpl implements LeaseWxCustomerAdapter {

	@Autowired
	private LeaseWxCustomerService leaseWxCustomerService;
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

    public int updateDealStatus(Long id, Integer deal) throws GMException {
        int row=leaseWxCustomerService.updateDealStatus(id,deal);
        return row;
    }

    public List<LeaseWxCustomer> findAllNoPage(Map<String, Object> paramsMap) {
      List<LeaseWxCustomer> leaseWxCustomers=  leaseWxCustomerService.findAllNoPage(paramsMap);
        return leaseWxCustomers;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxCustomerService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseWxCustomerService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseWxCustomer record) throws GMException {
        record = leaseWxCustomerService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseWxCustomer record) throws GMException {
        record = leaseWxCustomerService.insertSelective(record);

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

    public int updateByPrimaryKeySelective(LeaseWxCustomer record) throws GMException {
        int row = leaseWxCustomerService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxCustomer record) throws GMException {
        int row = leaseWxCustomerService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseWxCustomer selectByPrimaryKey(Long id) throws GMException {
        LeaseWxCustomer leaseWxCustomer = leaseWxCustomerService.selectByPrimaryKey(id);
        return leaseWxCustomer;
    }

    public int insertList(List<LeaseWxCustomer> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseWxCustomer> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseWxCustomer> page = leaseWxCustomerService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseWxCustomer> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxCustomer> leaseWxCustomerList = leaseWxCustomerService.findAll(paramsMap);
        return leaseWxCustomerList;
    }

}
