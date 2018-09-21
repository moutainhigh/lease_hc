package com.hc.lease.baseInfo.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.adapter.api.LeaseInvoiceHeaderAdapter;
import com.hc.lease.baseInfo.model.LeaseInvoiceHeader;
import com.hc.lease.baseInfo.service.api.LeaseInvoiceHeaderService;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 发票抬头信息AdapterImpl
 *
 * @author Tong
 * @version 2017-04-17
 */
@Service("leaseInvoiceHeaderAdapter")
public class LeaseInvoiceHeaderAdapterImpl implements LeaseInvoiceHeaderAdapter {

    @Autowired
    private LeaseInvoiceHeaderService leaseInvoiceHeaderService;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }


    public ResultHashMap insertSelective(LeaseInvoiceHeader record, UserSession userSession) throws GMException {
        record.setCreateBy(userSession.getUserId());
        record.setUpdateBy(userSession.getUserId());
        record = leaseInvoiceHeaderService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }


    public int updateByPrimaryKeySelective(LeaseInvoiceHeader record, UserSession userSession) throws GMException {
       record.setCreateBy(userSession.getUserId());
        int row = leaseInvoiceHeaderService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {
        int row = leaseInvoiceHeaderService.disableByPrimaryKey(params);
        return row;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseInvoiceHeaderService.deleteByPrimaryKey(id);
        return row;
    }

    /**
     * 根据ID删除记录.批量删除
     *
     * @param ids .
     * @return
     * @throws GMException
     */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseInvoiceHeaderService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseInvoiceHeader record) throws GMException {
        record = leaseInvoiceHeaderService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseInvoiceHeader record) throws GMException {
        record = leaseInvoiceHeaderService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public LeaseInvoiceHeader selectByPrimaryKey(Long id) throws GMException {
        LeaseInvoiceHeader leaseInvoiceHeader = leaseInvoiceHeaderService.selectByPrimaryKey(id);
        return leaseInvoiceHeader;
    }

    public int updateByPrimaryKeySelective(LeaseInvoiceHeader record) throws GMException {
        int row = leaseInvoiceHeaderService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseInvoiceHeader record) throws GMException {
        int row = leaseInvoiceHeaderService.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseInvoiceHeader> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseInvoiceHeader> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseInvoiceHeader> page = leaseInvoiceHeaderService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseInvoiceHeader> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseInvoiceHeader> leaseInvoiceHeaderList = leaseInvoiceHeaderService.findAll(paramsMap);
        return leaseInvoiceHeaderList;
    }

}
