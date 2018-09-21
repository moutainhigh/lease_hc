package com.hc.lease.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.service.api.LeaseWxHomeImgService;
import com.hc.lease.wx.model.LeaseWxHomeImg;
import com.hc.lease.wx.dao.LeaseWxHomeImgMapper;

import java.util.List;
import java.util.Map;

/**
 * 首页图ServiceImpl
 * @author Qiang
 * @version 2017-11-29
 */
@Service("leaseWxHomeImgService")
public class LeaseWxHomeImgServiceImpl implements LeaseWxHomeImgService {

	@Autowired
	private LeaseWxHomeImgMapper leaseWxHomeImgMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxHomeImgMapper.deleteByPrimaryKey(id);
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
        int row = leaseWxHomeImgMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseWxHomeImg insert(LeaseWxHomeImg leaseWxHomeImg) throws GMException {
        leaseWxHomeImg.setCreateTime(DateTime.now().toDate());
        leaseWxHomeImg.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxHomeImgMapper.insert(leaseWxHomeImg);
        return leaseWxHomeImg;
    }

    public LeaseWxHomeImg insertSelective(LeaseWxHomeImg leaseWxHomeImg) throws GMException {
        leaseWxHomeImg.setCreateTime(DateTime.now().toDate());
        leaseWxHomeImg.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxHomeImgMapper.insertSelective(leaseWxHomeImg);
        return leaseWxHomeImg;
    }

    public int insertList(List<LeaseWxHomeImg> list) throws GMException {
        int row = leaseWxHomeImgMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseWxHomeImg leaseWxHomeImg) throws GMException {
        leaseWxHomeImg.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxHomeImgMapper.updateByPrimaryKeySelective(leaseWxHomeImg);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxHomeImg leaseWxHomeImg) throws GMException {
        leaseWxHomeImg.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxHomeImgMapper.updateByPrimaryKey(leaseWxHomeImg);
        return row;
    }

    public LeaseWxHomeImg selectByPrimaryKey(Long id) throws GMException {
        LeaseWxHomeImg leaseWxHomeImg = leaseWxHomeImgMapper.selectByPrimaryKey(id);
        return leaseWxHomeImg;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseWxHomeImg> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseWxHomeImg> leaseWxHomeImgList = leaseWxHomeImgMapper.findPage(paramsMap);
        PageInfo<LeaseWxHomeImg> page = new PageInfo<LeaseWxHomeImg>(leaseWxHomeImgList);
        return page;
    }

    public List <LeaseWxHomeImg> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxHomeImg> leaseWxHomeImgList = leaseWxHomeImgMapper.findAll(paramsMap);
        return leaseWxHomeImgList;
    }

    public int updateSort(LeaseWxHomeImg leaseWxHomeImg) {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id",leaseWxHomeImg.getId());
        paramsMap.put("mark",leaseWxHomeImg.getMark());
        leaseWxHomeImgMapper.updateSort(paramsMap);
        return 0;
    }
}
