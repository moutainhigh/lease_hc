package com.hc.lease.wx.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.file.UploadFileUtil;
import hc.lease.common.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.adapter.api.LeaseWxServiceRangeAdapter;
import com.hc.lease.wx.service.api.LeaseWxServiceRangeService;
import com.hc.lease.wx.model.LeaseWxServiceRange;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 服务范围AdapterImpl
 * @author Qiang
 * @version 2018-03-26
 */
@Service("leaseWxServiceRangeAdapter")
public class LeaseWxServiceRangeAdapterImpl implements LeaseWxServiceRangeAdapter {

    @Value("${img.url}")
    String imgUrl;

    @Value("${img.maxSize}")
    private String maxSize;//文件大小限制范围

    @Value("${img.fileImgFolder}")
    private String fileImgFolder;//图片存放文件夹路径根目录

    @Value("${wx.img.fileImgFolder}")
    private String wxFileImgFolder;//图片存放文件夹路径


	@Autowired
	private LeaseWxServiceRangeService leaseWxServiceRangeService;

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
        int row = leaseWxServiceRangeService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseWxServiceRangeService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseWxServiceRange record) throws GMException {

        if (record.getServiceRange() != null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getServiceRange(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setServiceRange(filePath);
        }
        record = leaseWxServiceRangeService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseWxServiceRange record) throws GMException {
        if (record.getServiceRange() != null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getServiceRange(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setServiceRange(filePath);
        }
        record = leaseWxServiceRangeService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseWxServiceRange record) throws GMException {
        if (record.getServiceRange() != null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getServiceRange(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setServiceRange(filePath);
        }
        int row = leaseWxServiceRangeService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxServiceRange record) throws GMException {
        if (record.getServiceRange() != null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getServiceRange(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setServiceRange(filePath);
        }
        int row = leaseWxServiceRangeService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseWxServiceRange selectByPrimaryKey(Long id) throws GMException {
        LeaseWxServiceRange leaseWxServiceRange = leaseWxServiceRangeService.selectByPrimaryKey(id);
        return leaseWxServiceRange;
    }

    public int insertList(List<LeaseWxServiceRange> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseWxServiceRange> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseWxServiceRange> page = leaseWxServiceRangeService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseWxServiceRange> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxServiceRange> leaseWxServiceRangeList = leaseWxServiceRangeService.findAll(paramsMap);
        return leaseWxServiceRangeList;
    }

}
