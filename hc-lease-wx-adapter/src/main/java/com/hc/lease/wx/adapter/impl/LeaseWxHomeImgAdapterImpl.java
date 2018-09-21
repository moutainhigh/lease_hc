package com.hc.lease.wx.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.file.UploadFileUtil;
import com.hc.lease.wx.model.LeaseWxHomeImgs;
import hc.lease.common.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.adapter.api.LeaseWxHomeImgAdapter;
import com.hc.lease.wx.service.api.LeaseWxHomeImgService;
import com.hc.lease.wx.model.LeaseWxHomeImg;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 首页图AdapterImpl
 * @author Qiang
 * @version 2017-11-29
 */
@Service("leaseWxHomeImgAdapter")
public class LeaseWxHomeImgAdapterImpl implements LeaseWxHomeImgAdapter {

	@Autowired
	private LeaseWxHomeImgService leaseWxHomeImgService;

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

    public int updateSort(LeaseWxHomeImgs leaseWxHomeImgs) {
        if(leaseWxHomeImgs.getLeaseWxHomeImgs()!=null && leaseWxHomeImgs.getLeaseWxHomeImgs().size()>0){
          List<LeaseWxHomeImg> leaseWxHomeImgList=leaseWxHomeImgs.getLeaseWxHomeImgs();
            for (LeaseWxHomeImg leaseWxHomeImg : leaseWxHomeImgList) {
                leaseWxHomeImgService.updateSort(leaseWxHomeImg);
            }
        }
        return 0;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseWxHomeImgService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseWxHomeImgService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseWxHomeImg record) throws GMException {
        if (record.getImg() != null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setImg(filePath);
        }
        record = leaseWxHomeImgService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseWxHomeImg record) throws GMException {
        if (record.getImg() != null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setImg(filePath);
        }
        record = leaseWxHomeImgService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseWxHomeImg record) throws GMException {
        if (record.getImg() != null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setImg(filePath);
        }
        int row = leaseWxHomeImgService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxHomeImg record) throws GMException {
        if (record.getImg() != null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setImg(filePath);
        }
        int row = leaseWxHomeImgService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseWxHomeImg selectByPrimaryKey(Long id) throws GMException {
        LeaseWxHomeImg leaseWxHomeImg = leaseWxHomeImgService.selectByPrimaryKey(id);
        return leaseWxHomeImg;
    }

    public int insertList(List<LeaseWxHomeImg> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseWxHomeImg> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseWxHomeImg> page = leaseWxHomeImgService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseWxHomeImg> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxHomeImg> leaseWxHomeImgList = leaseWxHomeImgService.findAll(paramsMap);
        return leaseWxHomeImgList;
    }

}
