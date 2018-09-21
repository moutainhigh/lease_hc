package com.hc.lease.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.service.api.LeaseWxTitleService;
import com.hc.lease.wx.model.LeaseWxTitle;
import com.hc.lease.wx.dao.LeaseWxTitleMapper;

import java.util.List;
import java.util.Map;

/**
 * 联系我们ServiceImpl
 * @author Qiang
 * @version 2017-11-30
 */
@Service("leaseWxTitleService")
public class LeaseWxTitleServiceImpl implements LeaseWxTitleService {

	@Autowired
	private LeaseWxTitleMapper leaseWxTitleMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxTitleMapper.deleteByPrimaryKey(id);
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
        int row = leaseWxTitleMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseWxTitle insert(LeaseWxTitle leaseWxTitle) throws GMException {
        leaseWxTitle.setCreateTime(DateTime.now().toDate());
        leaseWxTitle.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxTitleMapper.insert(leaseWxTitle);
        return leaseWxTitle;
    }

    public LeaseWxTitle insertSelective(LeaseWxTitle leaseWxTitle) throws GMException {
        leaseWxTitle.setCreateTime(DateTime.now().toDate());
        leaseWxTitle.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxTitleMapper.insertSelective(leaseWxTitle);
        return leaseWxTitle;
    }

    public int insertList(List<LeaseWxTitle> list) throws GMException {
        int row = leaseWxTitleMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseWxTitle leaseWxTitle) throws GMException {
        leaseWxTitle.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxTitleMapper.updateByPrimaryKeySelective(leaseWxTitle);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxTitle leaseWxTitle) throws GMException {
        leaseWxTitle.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxTitleMapper.updateByPrimaryKey(leaseWxTitle);
        return row;
    }

    public LeaseWxTitle selectByPrimaryKey(Long id) throws GMException {
        LeaseWxTitle leaseWxTitle = leaseWxTitleMapper.selectByPrimaryKey(id);
        return leaseWxTitle;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseWxTitle> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseWxTitle> leaseWxTitleList = leaseWxTitleMapper.findPage(paramsMap);
        PageInfo<LeaseWxTitle> page = new PageInfo<LeaseWxTitle>(leaseWxTitleList);
        return page;
    }

    public List <LeaseWxTitle> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxTitle> leaseWxTitleList = leaseWxTitleMapper.findAll(paramsMap);
        return leaseWxTitleList;
    }

}
