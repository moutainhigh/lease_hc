package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.model.LeaseDict;
import com.hc.lease.baseInfo.service.api.LeaseDictService;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.excel.easyxls.common.DateUtil;
import com.hc.lease.common.core.excel.poi.vo.WxStoresImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.WxStoresTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.common.core.file.UploadFileUtil;
import com.hc.lease.supplier.adapter.api.LeaseAgentsAdapter;
import com.hc.lease.supplier.model.LeaseAgents;
import com.hc.lease.supplier.model.LeaseAgentsLevel;
import com.hc.lease.supplier.model.LeaseAgentsSecondary;
import com.hc.lease.supplier.service.api.LeaseAgentsLevelService;
import com.hc.lease.supplier.service.api.LeaseAgentsSecondaryService;
import com.hc.lease.supplier.service.api.LeaseAgentsService;
import com.hc.lease.supplier.vo.FindPageVo;
import com.hc.lease.supplier.vo.LeaseAgentsList;
import hc.lease.common.util.FileUtil;
import hc.lease.common.util.ListUtil;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.hc.lease.common.core.constant.DictType.COOPERATION_YEAR_LIMIT;
import static com.hc.lease.common.core.constant.DictType.TYPE_MORTGAGETYPE;

/**
 * 代理商AdapterImpl
 *
 * @author Qiang
 * @version 2017-12-15
 */
@Service("leaseAgentsAdapter")
public class LeaseAgentsAdapterImpl implements LeaseAgentsAdapter {

    @Autowired
    private LeaseAgentsService leaseAgentsService;

    @Autowired
    private LeaseAgentsLevelService leaseAgentsLevelService;

    @Autowired
    private LeaseAgentsSecondaryService leaseAgentsSecondaryService;

    @Autowired
    private LeaseDictService leaseDictService;

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
        List<LeaseDict> leaseDictList = leaseDictService.findByType(COOPERATION_YEAR_LIMIT);
        Map<String, Object> map = Maps.newHashMap();
        map.put("leaseDictList", leaseDictList);
        return map;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAgentsService.deleteByPrimaryKey(id);
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
        int row = leaseAgentsService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseAgents record) throws GMException {
        record = leaseAgentsService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseAgents record) throws GMException {
        if (record.getImgs() != null && record.getImgs().size() > 0) {
            String filePath = UploadFileUtil.dualImgs(record.getImgs(), maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setImg(filePath);
        }

        if (record.getBusinessLicenseImg() != null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getBusinessLicenseImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setBusinessLicenseImg(filePath);
        }

        //处理编号
        Integer maxNumber = leaseAgentsService.findMaxNumber();
        if (maxNumber == null) {
            record.setNumber(200001);
        } else {
            record.setNumber(maxNumber + 1);
        }
        //处理编号

        record = leaseAgentsService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseAgents record) throws GMException {
        if (record.getImgs() != null && record.getImgs().size() > 0) {
            String filePath = UploadFileUtil.dualImgs(record.getImgs(), maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setImg(filePath);
        }

        if (record.getBusinessLicenseImg() != null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getBusinessLicenseImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setBusinessLicenseImg(filePath);
        }

        int row = leaseAgentsService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseAgents record) throws GMException {
        if (record.getImgs() != null && record.getImgs().size() > 0) {
            String filePath = UploadFileUtil.dualImgs(record.getImgs(), maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setImg(filePath);
        }

        if (record.getBusinessLicenseImg() != null) {
            String filePath = UploadFileUtil.base64UploadFile(record.getBusinessLicenseImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
            record.setBusinessLicenseImg(filePath);
        }

        int row = leaseAgentsService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseAgents selectByPrimaryKey(Long id) throws GMException {
        LeaseAgents leaseAgents = leaseAgentsService.selectByPrimaryKey(id);
        return leaseAgents;
    }

    public int insertList(List<LeaseAgents> list) throws GMException {
        return 0;
    }

    /**
     * @param paramsMap
     * @return
     */
    @Override
    public List<LeaseAgents> findByName(Map<String, Object> paramsMap) {
        List<LeaseAgents> leaseAgentsList = leaseAgentsService.findByName(paramsMap);
        return leaseAgentsList;
    }

    public int disableByPrimaryKey(Map<String, Object> paramsMap) {
        int row = leaseAgentsService.disableByPrimaryKey(paramsMap);
        return row;
    }

    public int updateSort(LeaseAgentsList leaseAgentsList) {

        if (leaseAgentsList.getLeaseAgentses() != null && leaseAgentsList.getLeaseAgentses().size() > 0) {
            List<LeaseAgents> leaseAgentses = leaseAgentsList.getLeaseAgentses();
            for (LeaseAgents leaseAgents : leaseAgentses) {
                leaseAgentsService.updateSort(leaseAgents);
            }
        }

        return 1;
    }

    public List<FindPageVo> findAllNoPage(Object o) {
        List<FindPageVo> leaseAgentses = leaseAgentsService.findAllNoPage(o);
        return leaseAgentses;
    }

    public List<String> findExportExcelModel(Map param) {
        List<String> leaseAgentsList =   leaseAgentsService.findExportExcelModel(param);
        return leaseAgentsList;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseAgents> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseAgents> page = leaseAgentsService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseAgents> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseAgents> leaseAgentsList = leaseAgentsService.findAll(paramsMap);
        return leaseAgentsList;
    }

    /**
     * 代理商数据导入
     *
     * @param wxStoresTemplateList 代理商数据
     * @param userSession
     * @return
     * @throws GMException
     */
    @Override
    public WxStoresImportExcelBackInfo importExcelWxStores(List<WxStoresTemplate> wxStoresTemplateList, UserSession userSession) throws GMException {
        WxStoresImportExcelBackInfo wxStoresImportExcelBackInfo = null;
        if (wxStoresTemplateList != null) {
            if (wxStoresTemplateList.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                for (int i = 0; i < wxStoresTemplateList.size(); i++) {
                    WxStoresTemplate wxStoresTemplate = wxStoresTemplateList.get(i);
                    String level = wxStoresTemplate.getLevel();//一级区域
                    String secondary = wxStoresTemplate.getSecondary();//二级区域
                    String name = wxStoresTemplate.getName();//代理商名称
                    Integer storesLevel = wxStoresTemplate.getStoresLevel();
                    if (StringUtils.isBlank(level) || StringUtils.isBlank(secondary)
                            || StringUtils.isBlank(name)
                            ) {
                        wxStoresTemplate.setUpdateState("失败");
                        failNum++;
                        continue;
                    }
                    if (storesLevel != null) {
                        if (storesLevel != 1 && storesLevel != 2) {
                            wxStoresTemplate.setUpdateState("网点级别输入有误");
                            failNum++;
                            continue;
                        }
                    }
                    //处理代理商数据导入
                    dualWxStoresImportExcel(wxStoresTemplate, userSession);
                    //处理代理商数据导入
                    successNum++;
                    wxStoresTemplate.setUpdateState("成功");
                }
                wxStoresImportExcelBackInfo = new WxStoresImportExcelBackInfo();
                wxStoresImportExcelBackInfo.setFailNum(failNum);//失败数量
                wxStoresImportExcelBackInfo.setSuccessNum(successNum);//成功数量
                wxStoresImportExcelBackInfo.setBackInfo(null);//反馈信息
                wxStoresImportExcelBackInfo.setWxStoresTemplate(wxStoresTemplateList);
            }
        }
        return wxStoresImportExcelBackInfo;
    }

    /**
     * 处理代理商数据导入
     *
     * @param wxStoresTemplate
     * @param userSession
     * @return
     * @throws GMException
     */
    public boolean dualWxStoresImportExcel(WxStoresTemplate wxStoresTemplate, UserSession userSession) throws GMException {

        Long levelId = null;
        Long secondaryId = null;
        Long cooperationYearLimitId = null;
        String cooperationYearLimit = null;
        if (wxStoresTemplate.getCooperationYearLimit() != null) {
            cooperationYearLimit = wxStoresTemplate.getCooperationYearLimit();
        }
        Map paramsMap = Maps.newHashMap();

        //检测一级区域是否存在
        paramsMap.put("name", wxStoresTemplate.getLevel().trim());
        List<LeaseAgentsLevel> leaseAgentsLevelList = leaseAgentsLevelService.findByName(paramsMap);
        if (leaseAgentsLevelList == null || leaseAgentsLevelList.size() <= 0) {
            LeaseAgentsLevel leaseAgentsLevel = new LeaseAgentsLevel();
            leaseAgentsLevel.setName(wxStoresTemplate.getLevel());
            leaseAgentsLevel = leaseAgentsLevelService.insertSelective(leaseAgentsLevel);
            levelId = leaseAgentsLevel.getId();
        } else {
            levelId = leaseAgentsLevelList.get(0).getId();
        }
        //检测一级区域是否存在
        //检测二级区域是否存在
        paramsMap.put("levelId", levelId);
        paramsMap.put("name", wxStoresTemplate.getSecondary().trim());
        List<LeaseAgentsSecondary> leaseAgentsSecondaryList = leaseAgentsSecondaryService.findByName(paramsMap);
        if (leaseAgentsSecondaryList == null || leaseAgentsSecondaryList.size() <= 0) {
            LeaseAgentsSecondary leaseAgentsSecondary = new LeaseAgentsSecondary();
            leaseAgentsSecondary.setLevelId(levelId);
            leaseAgentsSecondary.setName(wxStoresTemplate.getSecondary());
            leaseAgentsSecondary = leaseAgentsSecondaryService.insertSelective(leaseAgentsSecondary);
            secondaryId = leaseAgentsSecondary.getId();
        } else {
            secondaryId = leaseAgentsSecondaryList.get(0).getId();
        }
        //检测二级区域是否存在

        if (cooperationYearLimit != null) {
            //处理合作年限是否需要创建/暂不处理创建/字典表不好处理创建
            paramsMap.put("name", cooperationYearLimit);
            paramsMap.put("type", COOPERATION_YEAR_LIMIT);
            List<LeaseDict> leaseDictList = leaseDictService.findByValueAndType(paramsMap);
            if (leaseDictList == null || leaseDictList.size() <= 0) {
                LeaseDict leaseDict = new LeaseDict();
                leaseDict.setValue(cooperationYearLimit);//合作年限名称
                leaseDict.setType(TYPE_MORTGAGETYPE);//字典类型/合作年限
                //leaseDict.setCreateBy(userSession.getUserId());
                //leaseDict.setUpdateBy(userSession.getUserId());
                //leaseDict = leaseDictService.insertSelective(leaseDict);
                cooperationYearLimitId = null;//所属分公司主键ID
            } else {
                cooperationYearLimitId = leaseDictList.get(0).getId();//所属分公司主键ID
            }
        }
        //处理合作年限是否需要创建/暂不处理创建/字典表不好处理创建

        //检测二级区域的代理商名称是否存在
        paramsMap.put("name", wxStoresTemplate.getName().trim());
        paramsMap.put("secondaryId", secondaryId);
        List<LeaseAgents> leaseAgentsListFind = leaseAgentsService.findByName(paramsMap);
        if (leaseAgentsListFind == null || leaseAgentsListFind.size() <= 0) {

            //处理编号
            Integer maxNumber = leaseAgentsService.findMaxNumber();
            if (maxNumber == null) {
                maxNumber = 200001;
            } else {
                maxNumber = maxNumber + 1;
            }
            //处理编号

            LeaseAgents leaseAgents = new LeaseAgents();
            leaseAgents.setSecondaryId(secondaryId);
            leaseAgents.setAddress(wxStoresTemplate.getAddress());
            leaseAgents.setName(wxStoresTemplate.getName());
            leaseAgents.setSalesName(wxStoresTemplate.getSalesName());
            leaseAgents.setPhone(wxStoresTemplate.getPhone());

            leaseAgents.setStoresLevel(wxStoresTemplate.getStoresLevel());//网点级别
            leaseAgents.setBusinessLicenseAdress(wxStoresTemplate.getBusinessLicenseAdress());//营业执照地址
            leaseAgents.setBusinessLicenseNumber(wxStoresTemplate.getBusinessLicenseNumber());//营业执照编号
            leaseAgents.setChargePersonIdCard(wxStoresTemplate.getChargePersonIdCard());//负责人身份证
            leaseAgents.setChargePersonName(wxStoresTemplate.getChargePersonName());//负责人

            leaseAgents.setCooperationEndTime(wxStoresTemplate.getCooperationEndTime());//合作结束日
            leaseAgents.setCooperationStartTime(wxStoresTemplate.getCooperationStartTime());//合作开始日
            leaseAgents.setCooperationYearLimit(cooperationYearLimitId);//合作年限(字典表主键ID)
            leaseAgents.setIsContractAward(StringUtils.isEmpty(wxStoresTemplate.getIsContractAward()) ? null : Integer.valueOf(wxStoresTemplate.getIsContractAward()));//合同签约
            leaseAgents.setGuaranteeAmount(wxStoresTemplate.getGuaranteeAmount());//保证金额
            leaseAgents.setCarNumber(wxStoresTemplate.getCarNumber());//可提车数量
            leaseAgents.setCommission(wxStoresTemplate.getCommission());//每单佣金
            leaseAgents.setNumber(maxNumber);
            leaseAgents.setCreateBy(null);
            leaseAgents.setCreateTime(DateTime.now().toDate());
            leaseAgents.setUpdateBy(null);
            leaseAgents.setUpdateTime(DateTime.now().toDate());
            leaseAgents = leaseAgentsService.insertSelective(leaseAgents);
        } else {
            for (int i = 0; i < leaseAgentsListFind.size(); i++) {
                LeaseAgents leaseAgents = leaseAgentsListFind.get(i);
                leaseAgents.setSecondaryId(secondaryId);
                leaseAgents.setAddress(wxStoresTemplate.getAddress());
                leaseAgents.setName(wxStoresTemplate.getName());
                leaseAgents.setSalesName(wxStoresTemplate.getSalesName());
                leaseAgents.setPhone(wxStoresTemplate.getPhone());

                leaseAgents.setStoresLevel(wxStoresTemplate.getStoresLevel());//网点级别
                leaseAgents.setBusinessLicenseAdress(wxStoresTemplate.getBusinessLicenseAdress());//营业执照地址
                leaseAgents.setBusinessLicenseNumber(wxStoresTemplate.getBusinessLicenseNumber());//营业执照编号
                leaseAgents.setChargePersonIdCard(wxStoresTemplate.getChargePersonIdCard());//负责人身份证
                leaseAgents.setChargePersonName(wxStoresTemplate.getChargePersonName());//负责人
                leaseAgents.setCooperationEndTime(wxStoresTemplate.getCooperationEndTime());//合作结束日
                leaseAgents.setCooperationStartTime(wxStoresTemplate.getCooperationStartTime());//合作开始日
                leaseAgents.setCooperationYearLimit(cooperationYearLimitId);//合作年限(字典表主键ID)
                leaseAgents.setIsContractAward(StringUtils.isEmpty(wxStoresTemplate.getIsContractAward()) ? null : Integer.valueOf(wxStoresTemplate.getIsContractAward()));//合同签约

                leaseAgents.setGuaranteeAmount(wxStoresTemplate.getGuaranteeAmount());//保证金额
                leaseAgents.setCarNumber(wxStoresTemplate.getCarNumber());//可提车数量
                leaseAgents.setCommission(wxStoresTemplate.getCommission());//每单佣金

                leaseAgents.setCreateBy(null);
                leaseAgents.setCreateTime(DateTime.now().toDate());
                leaseAgents.setUpdateBy(null);
                leaseAgents.setUpdateTime(DateTime.now().toDate());
                leaseAgentsService.updateByPrimaryKeySelective(leaseAgents);
            }
        }
        //检测二级区域的代理商名称是否存在

        return true;
    }

}
