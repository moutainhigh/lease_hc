package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.api.LeaseSchemePriceStagesService;
import com.hc.lease.supplier.model.LeaseSchemePriceStages;
import com.hc.lease.supplier.dao.LeaseSchemePriceStagesMapper;

import java.util.List;
import java.util.Map;

/**
 * 方案报价-分期ServiceImpl
 * @author Qiang
 * @version 2018-07-27
 */
@Service("leaseSchemePriceStagesService")
public class LeaseSchemePriceStagesServiceImpl implements LeaseSchemePriceStagesService {

	@Autowired
	private LeaseSchemePriceStagesMapper leaseSchemePriceStagesMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemePriceStagesMapper.deleteByPrimaryKey(id);
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
        int row = leaseSchemePriceStagesMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseSchemePriceStages insert(LeaseSchemePriceStages leaseSchemePriceStages) throws GMException {
        leaseSchemePriceStages.setCreateTime(DateTime.now().toDate());
        leaseSchemePriceStages.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePriceStagesMapper.insert(leaseSchemePriceStages);
        return leaseSchemePriceStages;
    }

    public LeaseSchemePriceStages insertSelective(LeaseSchemePriceStages leaseSchemePriceStages) throws GMException {
        leaseSchemePriceStages.setCreateTime(DateTime.now().toDate());
        leaseSchemePriceStages.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePriceStagesMapper.insertSelective(leaseSchemePriceStages);
        return leaseSchemePriceStages;
    }

    public int insertList(List<LeaseSchemePriceStages> list) throws GMException {
        int row = leaseSchemePriceStagesMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseSchemePriceStages leaseSchemePriceStages) throws GMException {
        leaseSchemePriceStages.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePriceStagesMapper.updateByPrimaryKeySelective(leaseSchemePriceStages);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemePriceStages leaseSchemePriceStages) throws GMException {
        leaseSchemePriceStages.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemePriceStagesMapper.updateByPrimaryKey(leaseSchemePriceStages);
        return row;
    }

    public LeaseSchemePriceStages selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemePriceStages leaseSchemePriceStages = leaseSchemePriceStagesMapper.selectByPrimaryKey(id);
        return leaseSchemePriceStages;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseSchemePriceStages> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseSchemePriceStages> leaseSchemePriceStagesList = leaseSchemePriceStagesMapper.findPage(paramsMap);
        PageInfo<LeaseSchemePriceStages> page = new PageInfo<LeaseSchemePriceStages>(leaseSchemePriceStagesList);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List <LeaseSchemePriceStages> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemePriceStages> leaseSchemePriceStagesList = leaseSchemePriceStagesMapper.findAll(paramsMap);
        return leaseSchemePriceStagesList;
    }

    public void deleteBySchemePriceId(Long id) {
        leaseSchemePriceStagesMapper.deleteBySchemePriceId(id);
    }
}
