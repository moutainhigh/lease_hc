package com.hc.lease.wx.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.file.UploadFileUtil;
import hc.lease.common.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.adapter.api.LeaseWxAgentImgAdapter;
import com.hc.lease.wx.service.api.LeaseWxAgentImgService;
import com.hc.lease.wx.model.LeaseWxAgentImg;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 代理图AdapterImpl
 * @author Qiang
 * @version 2017-11-30
 */
@Service("leaseWxAgentImgAdapter")
public class LeaseWxAgentImgAdapterImpl implements LeaseWxAgentImgAdapter {

	@Autowired
	private LeaseWxAgentImgService leaseWxAgentImgService;


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
        int row = leaseWxAgentImgService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseWxAgentImgService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseWxAgentImg record) throws GMException {

        if (record.getAgentImgs()!=null && record.getAgentImgs().size() > 0) {
            String filePath = UploadFileUtil.dualImgs(record.getAgentImgs(), maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setAgentImg(filePath);
        }
        record = leaseWxAgentImgService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseWxAgentImg record) throws GMException {
        if (record.getAgentImgs()!=null && record.getAgentImgs().size() > 0) {
            String filePath = UploadFileUtil.dualImgs(record.getAgentImgs(), maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setAgentImg(filePath);
        }
        record = leaseWxAgentImgService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseWxAgentImg record) throws GMException {
        if (record.getAgentImgs()!=null && record.getAgentImgs().size() > 0) {
            String filePath = UploadFileUtil.dualImgs(record.getAgentImgs(), maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setAgentImg(filePath);
        }
        int row = leaseWxAgentImgService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxAgentImg record) throws GMException {
        if (record.getAgentImgs()!=null && record.getAgentImgs().size() > 0) {
            String filePath = UploadFileUtil.dualImgs(record.getAgentImgs(), maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setAgentImg(filePath);
        }
        int row = leaseWxAgentImgService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseWxAgentImg selectByPrimaryKey(Long id) throws GMException {
        LeaseWxAgentImg leaseWxAgentImg = leaseWxAgentImgService.selectByPrimaryKey(id);
        return leaseWxAgentImg;
    }

    public int insertList(List<LeaseWxAgentImg> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseWxAgentImg> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseWxAgentImg> page = leaseWxAgentImgService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseWxAgentImg> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxAgentImg> leaseWxAgentImgList = leaseWxAgentImgService.findAll(paramsMap);
        return leaseWxAgentImgList;
    }

}
