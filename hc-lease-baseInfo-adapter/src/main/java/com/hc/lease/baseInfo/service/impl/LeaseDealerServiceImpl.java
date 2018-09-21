package com.hc.lease.baseInfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.dao.LeaseDealerMapper;
import com.hc.lease.baseInfo.model.LeaseDealer;
import com.hc.lease.baseInfo.service.api.LeaseDealerService;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 经销商ServiceImpl
 *
 * @author Tong
 * @version 2017-04-14
 */
@Service("leaseDealerService")
public class LeaseDealerServiceImpl implements LeaseDealerService {

    @Autowired
    private LeaseDealerMapper leaseDealerMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseDealerMapper.deleteByPrimaryKey(id);
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
        int row = leaseDealerMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseDealer insert(LeaseDealer record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseDealerMapper.insert(record);
        return record;
    }

    public LeaseDealer insertSelective(LeaseDealer record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseDealerMapper.insertSelective(record);
        return record;
    }

    public LeaseDealer selectByPrimaryKey(Long id) throws GMException {
        LeaseDealer leaseDealer = leaseDealerMapper.selectByPrimaryKey(id);
        return leaseDealer;
    }

    public int updateByPrimaryKeySelective(LeaseDealer record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseDealerMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseDealer record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseDealerMapper.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseDealer> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseDealer> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseDealer> leaseDealerList = leaseDealerMapper.findPage(paramsMap);
        PageInfo<LeaseDealer> page = new PageInfo<LeaseDealer>(leaseDealerList);
        return page;
    }

    public List<LeaseDealer> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseDealer> leaseDealerList = leaseDealerMapper.findAll(paramsMap);
        return leaseDealerList;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public List<LeaseDealer> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        List<LeaseDealer> list = leaseDealerMapper.insertViewParames(paramsMap);
        return list;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param params
     * @return
     */
    public List<LeaseDealer> findByName(Map params) throws GMException {
        List<LeaseDealer> list = leaseDealerMapper.findByName(params);
        return list;
    }

    /**
     * 根据父级主键id检测数据是否存在
     *
     * @param id
     * @return
     * @throws GMException
     */
    public List<LeaseDealer> selectByParentId(Long id) throws GMException {
        List<LeaseDealer> leaseDealerList = leaseDealerMapper.selectByParentId(id);
        return leaseDealerList;
    }

    public List<LeaseDealer> selectByGrade(int i) {
        List<LeaseDealer> leaseDealerList = leaseDealerMapper.selectByGrade(i);
        return leaseDealerList;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {
        int row = leaseDealerMapper.disableByPrimaryKey(params);
        return row;
    }

}
