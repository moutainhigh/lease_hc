package com.hc.lease.wx.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.file.UploadFileUtil;
import hc.lease.common.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.adapter.api.LeaseWxDescriptionAdapter;
import com.hc.lease.wx.service.api.LeaseWxDescriptionService;
import com.hc.lease.wx.model.LeaseWxDescription;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 简介AdapterImpl
 * @author Qiang
 * @version 2018-03-28
 */
@Service("leaseWxDescriptionAdapter")
public class LeaseWxDescriptionAdapterImpl implements LeaseWxDescriptionAdapter {

    @Value("${img.url}")
    String imgUrl;

    @Value("${img.maxSize}")
    private String maxSize;//文件大小限制范围

    @Value("${img.fileImgFolder}")
    private String fileImgFolder;//图片存放文件夹路径根目录

    @Value("${wx.img.fileImgFolder}")
    private String wxFileImgFolder;//图片存放文件夹路径


	@Autowired
	private LeaseWxDescriptionService leaseWxDescriptionService;

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
        int row = leaseWxDescriptionService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseWxDescriptionService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseWxDescription record) throws GMException {
        if (record.getDescription()!= null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getDescription(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setDescription(filePath);
        }

        record = leaseWxDescriptionService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseWxDescription record) throws GMException {
        if (record.getDescription()!= null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getDescription(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setDescription(filePath);
        }
        record = leaseWxDescriptionService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseWxDescription record) throws GMException {
        if (record.getDescription()!= null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getDescription(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setDescription(filePath);
        }
        int row = leaseWxDescriptionService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxDescription record) throws GMException {
        if (record.getDescription()!= null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getDescription(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setDescription(filePath);
        }
        int row = leaseWxDescriptionService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseWxDescription selectByPrimaryKey(Long id) throws GMException {
        LeaseWxDescription leaseWxDescription = leaseWxDescriptionService.selectByPrimaryKey(id);
        return leaseWxDescription;
    }

    public int insertList(List<LeaseWxDescription> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseWxDescription> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseWxDescription> page = leaseWxDescriptionService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseWxDescription> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxDescription> leaseWxDescriptionList = leaseWxDescriptionService.findAll(paramsMap);
        return leaseWxDescriptionList;
    }

}
