package com.hc.lease.wx.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.file.UploadFileUtil;
import hc.lease.common.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.adapter.api.LeaseWxBuyDescriptionAdapter;
import com.hc.lease.wx.service.api.LeaseWxBuyDescriptionService;
import com.hc.lease.wx.model.LeaseWxBuyDescription;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 购买说明AdapterImpl
 * @author Qiang
 * @version 2017-11-30
 */
@Service("leaseWxBuyDescriptionAdapter")
public class LeaseWxBuyDescriptionAdapterImpl implements LeaseWxBuyDescriptionAdapter {

	@Autowired
	private LeaseWxBuyDescriptionService leaseWxBuyDescriptionService;


    @Value("${img.url}")
    String imgUrl;

    @Value("${img.maxSize}")
    private String maxSize;//文件大小限制范围

    @Value("${img.fileImgFolder}")
    private String fileImgFolder;//图片存放文件夹路径根目录

    @Value("${wx.img.fileImgFolder}")
    private String wxFileImgFolder;//图片存放文件夹路径

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
        int row = leaseWxBuyDescriptionService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseWxBuyDescriptionService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseWxBuyDescription record) throws GMException {
        if (record.getBuyImg() != null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getBuyImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setBuyImg(filePath);
        }
        record = leaseWxBuyDescriptionService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseWxBuyDescription record) throws GMException {
        if (record.getBuyImg() != null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getBuyImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setBuyImg(filePath);
        }
        record = leaseWxBuyDescriptionService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseWxBuyDescription record) throws GMException {
        if (record.getBuyImg() != null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getBuyImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setBuyImg(filePath);
        }
        int row = leaseWxBuyDescriptionService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxBuyDescription record) throws GMException {
        if (record.getBuyImg() != null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getBuyImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setBuyImg(filePath);
        }
        int row = leaseWxBuyDescriptionService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseWxBuyDescription selectByPrimaryKey(Long id) throws GMException {
        LeaseWxBuyDescription leaseWxBuyDescription = leaseWxBuyDescriptionService.selectByPrimaryKey(id);
        return leaseWxBuyDescription;
    }

    public int insertList(List<LeaseWxBuyDescription> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseWxBuyDescription> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseWxBuyDescription> page = leaseWxBuyDescriptionService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseWxBuyDescription> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxBuyDescription> leaseWxBuyDescriptionList = leaseWxBuyDescriptionService.findAll(paramsMap);
        return leaseWxBuyDescriptionList;
    }

}
