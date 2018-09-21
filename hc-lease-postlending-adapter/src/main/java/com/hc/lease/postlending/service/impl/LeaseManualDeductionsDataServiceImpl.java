package com.hc.lease.postlending.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.constant.DubboTreaceParames;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.postlending.dao.LeaseManualDeductionsDataMapper;
import com.hc.lease.postlending.model.LeaseManualDeductionsData;
import com.hc.lease.postlending.service.api.LeaseManualDeductionsDataService;
import com.hc.lease.postlending.vo.ExportManualDeductionsCheckExcelVo;
import com.hc.lease.postlending.vo.FindNeedPayVo;
import com.hc.lease.postlending.vo.FindQueryTradeVo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 手动扣款提交的数据ServiceImpl
 *
 * @author Tong
 * @version 2018-07-09
 */
@Service("leaseManualDeductionsDataService")
public class LeaseManualDeductionsDataServiceImpl implements LeaseManualDeductionsDataService {

    @Autowired
    private LeaseManualDeductionsDataMapper leaseManualDeductionsDataMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseManualDeductionsDataMapper.deleteByPrimaryKey(id);
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
        int row = leaseManualDeductionsDataMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseManualDeductionsData insert(LeaseManualDeductionsData leaseManualDeductionsData) throws GMException {
        leaseManualDeductionsData.setCreateTime(DateTime.now().toDate());
        leaseManualDeductionsData.setUpdateTime(DateTime.now().toDate());
        int row = leaseManualDeductionsDataMapper.insert(leaseManualDeductionsData);
        return leaseManualDeductionsData;
    }

    public LeaseManualDeductionsData insertSelective(LeaseManualDeductionsData leaseManualDeductionsData) throws GMException {
        leaseManualDeductionsData.setCreateTime(DateTime.now().toDate());
        leaseManualDeductionsData.setUpdateTime(DateTime.now().toDate());
        int row = leaseManualDeductionsDataMapper.insertSelective(leaseManualDeductionsData);
        return leaseManualDeductionsData;
    }

    public int insertList(List<LeaseManualDeductionsData> list) throws GMException {
        int row = leaseManualDeductionsDataMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseManualDeductionsData leaseManualDeductionsData) throws GMException {
        leaseManualDeductionsData.setUpdateTime(DateTime.now().toDate());
        int row = leaseManualDeductionsDataMapper.updateByPrimaryKeySelective(leaseManualDeductionsData);
        return row;
    }

    public int updateByPrimaryKey(LeaseManualDeductionsData leaseManualDeductionsData) throws GMException {
        leaseManualDeductionsData.setUpdateTime(DateTime.now().toDate());
        int row = leaseManualDeductionsDataMapper.updateByPrimaryKey(leaseManualDeductionsData);
        return row;
    }

    public LeaseManualDeductionsData selectByPrimaryKey(Long id) throws GMException {
        LeaseManualDeductionsData leaseManualDeductionsData = leaseManualDeductionsDataMapper.selectByPrimaryKey(id);
        return leaseManualDeductionsData;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseManualDeductionsData> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseManualDeductionsData> leaseManualDeductionsDataList = leaseManualDeductionsDataMapper.findPage(paramsMap);
        PageInfo<LeaseManualDeductionsData> page = new PageInfo<LeaseManualDeductionsData>(leaseManualDeductionsDataList);
        return page;
    }

    /**
     * 所有数据列表
     *
     * @return
     */
    public List<LeaseManualDeductionsData> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseManualDeductionsData> leaseManualDeductionsDataList = leaseManualDeductionsDataMapper.findAll(paramsMap);
        return leaseManualDeductionsDataList;
    }

    /**
     * 可以扣款的数据
     *
     * @param paramsMap
     * @return
     */
    @Override
    public List<FindNeedPayVo> findNeedPay(Map<String, Object> paramsMap) throws GMException {
        List<FindNeedPayVo> leaseManualDeductionsDataList = leaseManualDeductionsDataMapper.findNeedPay(paramsMap);
        return leaseManualDeductionsDataList;
    }

    /**
     * 需要轮询通联手动扣款
     *
     * @param paramsMap
     * @return
     */
    @Override
    public List<FindQueryTradeVo> findQueryTrade(Map<String, Object> paramsMap, DubboTreaceParames dubboTreaceParames) throws GMException {
        List<FindQueryTradeVo> findQueryTradeVoList = leaseManualDeductionsDataMapper.findQueryTrade(paramsMap);
        return findQueryTradeVoList;
    }

    /**
     * 下载核对、下载结果
     *
     * @param paramsMap
     * @return
     */
    @Override
    public List<ExportManualDeductionsCheckExcelVo> exportManualDeductionsCheckExcel(Map<String, Object> paramsMap) throws GMException {
        List<ExportManualDeductionsCheckExcelVo> exportManualDeductionsCheckExcelList = leaseManualDeductionsDataMapper.exportManualDeductionsCheckExcel(paramsMap);
        return exportManualDeductionsCheckExcelList;
    }

    /**
     * 手动扣款统计主键id 删除
     *
     * @param statistId
     * @return
     */
    @Override
    public int deleteByStatistId(Long statistId) {
        int row = leaseManualDeductionsDataMapper.deleteByStatistId(statistId);
        return row;
    }
}
