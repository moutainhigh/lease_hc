package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.adapter.api.LeaseSchemePriceStagesAdapter;
import com.hc.lease.supplier.service.api.LeaseSchemePriceStagesService;
import com.hc.lease.supplier.model.LeaseSchemePriceStages;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 方案报价-分期AdapterImpl
 * @author Qiang
 * @version 2018-07-27
 */
@Service("leaseSchemePriceStagesAdapter")
public class LeaseSchemePriceStagesAdapterImpl implements LeaseSchemePriceStagesAdapter {

	@Autowired
	private LeaseSchemePriceStagesService leaseSchemePriceStagesService;

    /**
    * 添加或者修改 需要的初始化参数
    *
    * @param paramsMap
    * @return
    */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    /**
    * 根据ID删除记录
    *
    * @param id .
    * @return
    * @throws GMException
    */
    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemePriceStagesService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseSchemePriceStagesService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseSchemePriceStages record) throws GMException {
        record = leaseSchemePriceStagesService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseSchemePriceStages record) throws GMException {
        record = leaseSchemePriceStagesService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseSchemePriceStages record) throws GMException {
        int row = leaseSchemePriceStagesService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemePriceStages record) throws GMException {
        int row = leaseSchemePriceStagesService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseSchemePriceStages selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemePriceStages leaseSchemePriceStages = leaseSchemePriceStagesService.selectByPrimaryKey(id);
        return leaseSchemePriceStages;
    }

    public int insertList(List<LeaseSchemePriceStages> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseSchemePriceStages> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseSchemePriceStages> page = leaseSchemePriceStagesService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List<LeaseSchemePriceStages> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemePriceStages> leaseSchemePriceStagesList = leaseSchemePriceStagesService.findAll(paramsMap);
        return leaseSchemePriceStagesList;
    }

}
