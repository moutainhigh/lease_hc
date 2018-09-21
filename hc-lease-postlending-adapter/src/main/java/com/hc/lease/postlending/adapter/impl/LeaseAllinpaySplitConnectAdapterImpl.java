package com.hc.lease.postlending.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.postlending.adapter.api.LeaseAllinpaySplitConnectAdapter;
import com.hc.lease.postlending.model.LeaseAllinpaySplitConnect;
import com.hc.lease.postlending.service.api.LeaseAllinpaySplitConnectService;
import com.hc.lease.postlending.vo.FindSplitCheckMapVo;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通联支付（协议支付、代扣），已经超额的还款计划明细则被记录AdapterImpl
 *
 * @author Tong
 * @version 2018-06-25
 */
@Service("leaseAllinpaySplitConnectAdapter")
public class LeaseAllinpaySplitConnectAdapterImpl implements LeaseAllinpaySplitConnectAdapter {

    @Autowired
    private LeaseAllinpaySplitConnectService leaseAllinpaySplitConnectService;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAllinpaySplitConnectService.deleteByPrimaryKey(id);
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
        int row = leaseAllinpaySplitConnectService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAllinpaySplitConnect record) throws GMException {
        record = leaseAllinpaySplitConnectService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAllinpaySplitConnect record) throws GMException {
        record = leaseAllinpaySplitConnectService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAllinpaySplitConnect record) throws GMException {
        int row = leaseAllinpaySplitConnectService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAllinpaySplitConnect record) throws GMException {
        int row = leaseAllinpaySplitConnectService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAllinpaySplitConnect selectByPrimaryKey(Long id) throws GMException {
        LeaseAllinpaySplitConnect leaseAllinpaySplitConnect = leaseAllinpaySplitConnectService.selectByPrimaryKey(id);
        return leaseAllinpaySplitConnect;
    }

    public int insertList(List<LeaseAllinpaySplitConnect> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAllinpaySplitConnect> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAllinpaySplitConnect> page = leaseAllinpaySplitConnectService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseAllinpaySplitConnect> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAllinpaySplitConnect> leaseAllinpaySplitConnectList = leaseAllinpaySplitConnectService.findAll(paramsMap);
        return leaseAllinpaySplitConnectList;
    }

    /**
     * 查询拆分的的明细全部扣款成功的数据
     *
     * @param paramsMap
     * @return
     */
    @Override
    public List<FindSplitCheckMapVo> findSplitCheck(Map<String, Object> paramsMap) {
        List<FindSplitCheckMapVo> findSplitCheckMapVoList = leaseAllinpaySplitConnectService.findSplitCheck(paramsMap);
        return findSplitCheckMapVoList;
    }

    @Override
    public int updateRepaymentId(Map<String, Object> paramsMap) throws GMException {
        int row = leaseAllinpaySplitConnectService.updateRepaymentId(paramsMap);
        return row;
    }
}
