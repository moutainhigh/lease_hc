package com.hc.lease.wx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.service.api.LeaseWxAgentImgService;
import com.hc.lease.wx.model.LeaseWxAgentImg;
import com.hc.lease.wx.dao.LeaseWxAgentImgMapper;

import java.util.List;
import java.util.Map;

/**
 * 代理图ServiceImpl
 * @author Qiang
 * @version 2017-11-30
 */
@Service("leaseWxAgentImgService")
public class LeaseWxAgentImgServiceImpl implements LeaseWxAgentImgService {

	@Autowired
	private LeaseWxAgentImgMapper leaseWxAgentImgMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxAgentImgMapper.deleteByPrimaryKey(id);
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
        int row = leaseWxAgentImgMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseWxAgentImg insert(LeaseWxAgentImg leaseWxAgentImg) throws GMException {
        leaseWxAgentImg.setCreateTime(DateTime.now().toDate());
        leaseWxAgentImg.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxAgentImgMapper.insert(leaseWxAgentImg);
        return leaseWxAgentImg;
    }

    public LeaseWxAgentImg insertSelective(LeaseWxAgentImg leaseWxAgentImg) throws GMException {
        leaseWxAgentImg.setCreateTime(DateTime.now().toDate());
        leaseWxAgentImg.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxAgentImgMapper.insertSelective(leaseWxAgentImg);
        return leaseWxAgentImg;
    }

    public int insertList(List<LeaseWxAgentImg> list) throws GMException {
        int row = leaseWxAgentImgMapper.insertList(list);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseWxAgentImg leaseWxAgentImg) throws GMException {
        leaseWxAgentImg.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxAgentImgMapper.updateByPrimaryKeySelective(leaseWxAgentImg);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxAgentImg leaseWxAgentImg) throws GMException {
        leaseWxAgentImg.setUpdateTime(DateTime.now().toDate());
        int row = leaseWxAgentImgMapper.updateByPrimaryKey(leaseWxAgentImg);
        return row;
    }

    public LeaseWxAgentImg selectByPrimaryKey(Long id) throws GMException {
        LeaseWxAgentImg leaseWxAgentImg = leaseWxAgentImgMapper.selectByPrimaryKey(id);
        return leaseWxAgentImg;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseWxAgentImg> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseWxAgentImg> leaseWxAgentImgList = leaseWxAgentImgMapper.findPage(paramsMap);
        PageInfo<LeaseWxAgentImg> page = new PageInfo<LeaseWxAgentImg>(leaseWxAgentImgList);
        return page;
    }

    public List <LeaseWxAgentImg> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxAgentImg> leaseWxAgentImgList = leaseWxAgentImgMapper.findAll(paramsMap);
        return leaseWxAgentImgList;
    }

}
