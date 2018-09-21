package com.hc.lease.wx.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.excel.poi.vo.WxCarImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.WxCarTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.common.core.file.UploadFileUtil;
import com.hc.lease.wx.adapter.api.LeaseWxCarAdapter;
import com.hc.lease.wx.model.LeaseWxCar;
import com.hc.lease.wx.model.LeaseWxCarOtherScheme;
import com.hc.lease.wx.model.LeaseWxCarScheme;
import com.hc.lease.wx.model.LeaseWxCars;
import com.hc.lease.wx.service.api.LeaseWxCarOtherSchemeService;
import com.hc.lease.wx.service.api.LeaseWxCarSchemeService;
import com.hc.lease.wx.service.api.LeaseWxCarService;
import hc.lease.common.util.FileUtil;
import hc.lease.common.util.ListUtil;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 车辆信息AdapterImpl
 *
 * @author Qiang
 * @version 2017-11-29
 */
@Service("leaseWxCarAdapter")
public class LeaseWxCarAdapterImpl implements LeaseWxCarAdapter {

    @Autowired
    private LeaseWxCarService leaseWxCarService;
    @Autowired
    private LeaseWxCarSchemeService leaseWxCarSchemeService;
    @Autowired
    private LeaseWxCarOtherSchemeService leaseWxCarOtherSchemeService;


    @Value("${img.url}")
    String imgUrl;

    @Value("${img.maxSize}")
    private String maxSize;//文件大小限制范围

    @Value("${img.fileImgFolder}")
    private String fileImgFolder;//图片存放文件夹路径根目录

    @Value("${wx.img.fileImgFolder}")
    private String wxFileImgFolder;//图片存放文件夹路径


    /**
     * 根据名称检测数据是否存在
     *
     * @param name
     * @return
     * @throws GMException
     */
    public boolean checkByNameIsExist(String name, Long id) throws GMException {
        boolean item = false;
        Map params = Maps.newHashMap();
        params.put("name", name);
        params.put("id", id);
        List<LeaseWxCar> leaseWxCarList = leaseWxCarService.findByName(params);
        if (leaseWxCarList != null) {
            if (leaseWxCarList.size() > 0) {
                item = true;
            } else {
                item = false;
            }
        } else {
            item = false;
        }
        return item;
    }


    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public int updateSort(LeaseWxCars leaseWxCars) {
        if (leaseWxCars.getLeaseWxCars() != null && leaseWxCars.getLeaseWxCars().size() > 0) {
            List<LeaseWxCar> leaseWxCarList = leaseWxCars.getLeaseWxCars();
            for (LeaseWxCar leaseWxCar : leaseWxCarList) {
                leaseWxCarService.updateSort(leaseWxCar);
            }

        }

        return 0;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        leaseWxCarSchemeService.deleteByCarId(id);
        leaseWxCarOtherSchemeService.deleteByCarId(id);
        int row = leaseWxCarService.deleteByPrimaryKey(id);
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
        int row = leaseWxCarService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseWxCar record) throws GMException {
        record = leaseWxCarService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    /**
     * 新增
     *
     * @param record
     * @return
     * @throws GMException
     */
    public ResultHashMap insertSelective(LeaseWxCar record) throws GMException {
        boolean bool = checkByNameIsExist(record.getCarName(), record.getId());
        if (bool) {
            throw new GMException(GMExceptionConstant.NAME_REPEAT);
        }

        if (record.getMainImgs().size() > 0) {

            if (record.getMainImgs() != null && record.getMainImgs().size() > 0) {
                String filePath = UploadFileUtil.dualImgs(record.getMainImgs(), maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
                record.setMainImg(filePath);
            }
            if (record.getDetailImgs() != null && record.getDetailImgs().size() > 0) {
                String filePath = UploadFileUtil.dualImgs(record.getDetailImgs(), maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
                record.setDetailImg(filePath);
            }
            if (record.getThumbnailImg()!= null) {
                String filePath = UploadFileUtil.base64UploadFile(record.getThumbnailImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
                record.setThumbnailImg(filePath);
            }

            //检测车辆名称是否存在
            Map paramsMap = Maps.newHashMap();
            paramsMap.put("carName", record.getCarName());
            List<LeaseWxCar> leaseWxCarListFind = leaseWxCarService.findByCarName(paramsMap);
            //检测车辆名称是否存在

            //如果录入的车辆名称存在则直接更新
            if (leaseWxCarListFind != null) {
                if (leaseWxCarListFind.size() > 0) {
                    for (int i = 0; i < leaseWxCarListFind.size(); i++) {
                        LeaseWxCar leaseWxCar = leaseWxCarListFind.get(i);
                        record.setId(leaseWxCar.getId());
                        int row = leaseWxCarService.updateByPrimaryKeySelective(record);

                        //1+X方案

                        LeaseWxCarOtherScheme  leaseWxCarOtherScheme=new LeaseWxCarOtherScheme();
                        leaseWxCarOtherScheme.setCarId(leaseWxCar.getId());
                        leaseWxCarOtherScheme.setBalancePayment(record.getBalancePayment());
                        leaseWxCarOtherScheme.setDownPayment(record.getDownPayment());
                        leaseWxCarOtherScheme.setFirstYearStagingNumber(record.getFirstYearStagingNumber());
                        leaseWxCarOtherScheme.setBalancePaymentStagingNumber(record.getBalancePaymentStagingNumberList());
                        leaseWxCarOtherScheme.setMonthlyRent(record.getMonthlyRent());
                        leaseWxCarOtherSchemeService.updateByCarId(leaseWxCarOtherScheme);
                        leaseWxCarSchemeService.deleteByCarId(record.getId());
                        //融租方案
                        if (record.getLeaseWxCarSchemes() != null && record.getLeaseWxCarSchemes().size() > 0) {
                            List<LeaseWxCarScheme> leaseWxCarSchemes = record.getLeaseWxCarSchemes();
                            for (LeaseWxCarScheme leaseWxCarScheme : leaseWxCarSchemes) {
                                leaseWxCarScheme.setCarId(record.getId());
                                leaseWxCarSchemeService.insertSelective(leaseWxCarScheme);
                            }
                        }
                    }
                } else {
                    record = leaseWxCarService.insertSelective(record);

                    LeaseWxCarOtherScheme  leaseWxCarOtherScheme=new LeaseWxCarOtherScheme();
                    leaseWxCarOtherScheme.setCarId(record.getId());
                    leaseWxCarOtherScheme.setBalancePayment(record.getBalancePayment());
                    leaseWxCarOtherScheme.setDownPayment(record.getDownPayment());
                    leaseWxCarOtherScheme.setFirstYearStagingNumber(record.getFirstYearStagingNumber());
                    leaseWxCarOtherScheme.setBalancePaymentStagingNumber(record.getBalancePaymentStagingNumberList());
                    leaseWxCarOtherScheme.setMonthlyRent(record.getMonthlyRent());
                    leaseWxCarOtherSchemeService.insertSelective(leaseWxCarOtherScheme);
                    //融租方案
                    if (record.getLeaseWxCarSchemes() != null && record.getLeaseWxCarSchemes().size() > 0) {
                        List<LeaseWxCarScheme> leaseWxCarSchemes = record.getLeaseWxCarSchemes();
                        for (LeaseWxCarScheme leaseWxCarScheme : leaseWxCarSchemes) {
                            leaseWxCarScheme.setCarId(record.getId());
                            leaseWxCarSchemeService.insertSelective(leaseWxCarScheme);
                        }
                    }
                }
            } else {
                record = leaseWxCarService.insertSelective(record);
                //融租方案
                if (record.getLeaseWxCarSchemes() != null && record.getLeaseWxCarSchemes().size() > 0) {
                    List<LeaseWxCarScheme> leaseWxCarSchemes = record.getLeaseWxCarSchemes();
                    for (LeaseWxCarScheme leaseWxCarScheme : leaseWxCarSchemes) {
                        leaseWxCarScheme.setCarId(record.getId());
                        leaseWxCarSchemeService.insertSelective(leaseWxCarScheme);
                    }
                }

                LeaseWxCarOtherScheme  leaseWxCarOtherScheme=new LeaseWxCarOtherScheme();
                leaseWxCarOtherScheme.setCarId(record.getId());
                leaseWxCarOtherScheme.setBalancePayment(record.getBalancePayment());
                leaseWxCarOtherScheme.setDownPayment(record.getDownPayment());
                leaseWxCarOtherScheme.setFirstYearStagingNumber(record.getFirstYearStagingNumber());
                leaseWxCarOtherScheme.setBalancePaymentStagingNumber(record.getBalancePaymentStagingNumberList());
                leaseWxCarOtherScheme.setMonthlyRent(record.getMonthlyRent());
                leaseWxCarOtherSchemeService.insertSelective(leaseWxCarOtherScheme);

            }
            //如果录入的车辆名称存在则直接更新
        }
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    /**
     * 修改
     *
     * @param record
     * @return
     * @throws GMException
     */

    public int updateByPrimaryKeySelective(LeaseWxCar record) throws GMException {
        int row = 0;
        boolean bool = checkByNameIsExist(record.getCarName(), record.getId());
        if (bool) {
            throw new GMException(GMExceptionConstant.NAME_REPEAT);
        }

        if (record.getMainImgs() != null && record.getMainImgs().size() > 0) {
            if (record.getMainImgs() != null && record.getMainImgs().size() > 0) {
                String filePath = UploadFileUtil.dualImgs(record.getMainImgs(), maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
                record.setMainImg(filePath);
            }
            if (record.getDetailImgs() != null && record.getDetailImgs().size() > 0) {
                String filePath = UploadFileUtil.dualImgs(record.getDetailImgs(), maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
                record.setDetailImg(filePath);
            }
            if (record.getThumbnailImg()!= null) {
                String filePath = UploadFileUtil.base64UploadFile(record.getThumbnailImg(), FileUtil.IMAGE_EXTENSION, maxSize, fileImgFolder, wxFileImgFolder, imgUrl);
                record.setThumbnailImg(filePath);
            }
            row = leaseWxCarService.updateByPrimaryKey(record);
           LeaseWxCarOtherScheme leaseWxCarOtherScheme= leaseWxCarOtherSchemeService.selectByCarId(record.getId());
            LeaseWxCarOtherScheme  _leaseWxCarOtherScheme=new LeaseWxCarOtherScheme();
            _leaseWxCarOtherScheme.setCarId(record.getId());
            _leaseWxCarOtherScheme.setBalancePayment(record.getBalancePayment());
            _leaseWxCarOtherScheme.setDownPayment(record.getDownPayment());
            _leaseWxCarOtherScheme.setFirstYearStagingNumber(record.getFirstYearStagingNumber());
            _leaseWxCarOtherScheme.setBalancePaymentStagingNumber(record.getBalancePaymentStagingNumberList());
            _leaseWxCarOtherScheme.setMonthlyRent(record.getMonthlyRent());
            if(leaseWxCarOtherScheme!=null){
                leaseWxCarOtherSchemeService.updateByCarIdNoSelective(_leaseWxCarOtherScheme);
            }else{
                leaseWxCarOtherSchemeService.insertSelective(_leaseWxCarOtherScheme);
            }

            leaseWxCarSchemeService.deleteByCarId(record.getId());
            //融租方案
            if (record.getLeaseWxCarSchemes() != null && record.getLeaseWxCarSchemes().size() > 0) {
                List<LeaseWxCarScheme> leaseWxCarSchemes = record.getLeaseWxCarSchemes();
                for (LeaseWxCarScheme leaseWxCarScheme : leaseWxCarSchemes) {
                    leaseWxCarScheme.setCarId(record.getId());
                    leaseWxCarSchemeService.insertSelective(leaseWxCarScheme);
                }

            }
        }
        return row;
    }


    public int updateByPrimaryKey(LeaseWxCar record) throws GMException {
        int row = leaseWxCarService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseWxCar selectByPrimaryKey(Long id) throws GMException {
        LeaseWxCar leaseWxCar = leaseWxCarService.selectByPrimaryKey(id);
        return leaseWxCar;
    }

    public int insertList(List<LeaseWxCar> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseWxCar> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseWxCar> page = leaseWxCarService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseWxCar> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxCar> leaseWxCarList = leaseWxCarService.findAll(paramsMap);
        return leaseWxCarList;
    }

    @Override
    public List<LeaseWxCar> findByCarName(Map<String, Object> paramsMap) {
        List<LeaseWxCar> leaseWxCarList = leaseWxCarService.findByCarName(paramsMap);
        return leaseWxCarList;
    }

    public List<LeaseWxCar> findAllNoPage(Map<String, Object> paramsMap) {

        List<LeaseWxCar> leaseWxCarList=  leaseWxCarService.findAllNoPage(paramsMap);
        return leaseWxCarList;
    }

    /**
     * 处理小程序车辆导入
     *
     * @param wxCarTemplateList 车辆数据
     * @param userSession
     * @return
     * @throws GMException
     */
    @Override
    public WxCarImportExcelBackInfo importExcelWxCar(List<WxCarTemplate> wxCarTemplateList, UserSession userSession) throws GMException {
        WxCarImportExcelBackInfo wxCarImportExcelBackInfo = null;
        ArrayList<LeaseWxCar> leaseWxCarListInsert = new ArrayList<LeaseWxCar>();
        ArrayList<LeaseWxCar> leaseWxCarListUpdate = new ArrayList<LeaseWxCar>();
        if (wxCarTemplateList != null) {
            if (wxCarTemplateList.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                for (int i = 0; i < wxCarTemplateList.size(); i++) {

                    WxCarTemplate wxCarTemplate = wxCarTemplateList.get(i);

                    String carName = wxCarTemplate.getCarName();//车辆名称
                    String typeName = wxCarTemplate.getTypeName();//燃料类型
                    String carStructure = wxCarTemplate.getCarStructure();//车身结构
                    String driveMode = wxCarTemplate.getDriveMode();//驱动方式
                    String engine = wxCarTemplate.getEngine();//发动机
                    String fuel = wxCarTemplate.getFuel();//综合油耗
                    String fuelMode = wxCarTemplate.getFuelMode();//燃料方式
                    String longWidthHeight = wxCarTemplate.getLongWidthHeight();//长/宽/高
                    String marketPrice = wxCarTemplate.getMarketPrice();//市场指导价
                    String transmission = wxCarTemplate.getTransmission();//变速箱
                    if (StringUtils.isBlank(carName) || StringUtils.isBlank(marketPrice)||StringUtils.isBlank(typeName)) {
                        wxCarTemplate.setUpdateState("失败");
                        failNum++;
                        continue;
                    }

                    if(!typeName.equals("汽油") && !typeName.equals("混合动力")&& !typeName.equals("新能源")){
                        wxCarTemplate.setUpdateState("失败! 不存在的燃料类型");
                        failNum++;
                        continue;
                    }



                    LeaseWxCar leaseWxCar = new LeaseWxCar();
                    leaseWxCar.setCarName(wxCarTemplate.getCarName());

                    if(typeName.equals("汽油")){
                        leaseWxCar.setType(1);
                    }else if (typeName.equals("混合动力")){
                        leaseWxCar.setType(2);
                    }else if (typeName.equals("新能源")){
                        leaseWxCar.setType(3);
                    }
                    leaseWxCar.setCarStructure(wxCarTemplate.getCarStructure());
                    leaseWxCar.setDriveMode(wxCarTemplate.getDriveMode());
                    leaseWxCar.setEngine(wxCarTemplate.getEngine());
                    leaseWxCar.setFuel(wxCarTemplate.getFuel());
                    leaseWxCar.setFuelMode(wxCarTemplate.getFuelMode());
                    leaseWxCar.setLongWidthHeight(wxCarTemplate.getLongWidthHeight());
                    String marketPrice_1 = wxCarTemplate.getMarketPrice() == null ? "0" : wxCarTemplate.getMarketPrice();
                    leaseWxCar.setMarketPrice(new BigDecimal(marketPrice_1));
                    leaseWxCar.setTransmission(wxCarTemplate.getTransmission());
                    leaseWxCar.setCreateBy(null);
                    leaseWxCar.setCreateTime(DateTime.now().toDate());
                    leaseWxCar.setUpdateBy(null);
                    leaseWxCar.setUpdateTime(DateTime.now().toDate());
                    leaseWxCar.setIsEnable(true);
                    leaseWxCar.setFastTime(wxCarTemplate.getFastTime());
                    leaseWxCar.setSlowTime(wxCarTemplate.getSlowTime());
                    leaseWxCar.setFastChargeQuantity(wxCarTemplate.getFastChargeQuantity());
                    leaseWxCar.setTotalPower(wxCarTemplate.getTotalPower());
                    leaseWxCar.setBatteryCapacity(wxCarTemplate.getBatteryCapacity());
                    leaseWxCar.setEnduranceMileage(wxCarTemplate.getEnduranceMileage());
                    //检测车辆名称是否存在
                    Map paramsMap = Maps.newHashMap();
                    paramsMap.put("carName", wxCarTemplate.getCarName().trim());
                    List<LeaseWxCar> leaseWxCarListFind = leaseWxCarService.findByCarName(paramsMap);
                    //检测车辆名称是否存在

                    if (leaseWxCarListFind == null || leaseWxCarListFind.size() <= 0) {
                        leaseWxCarListInsert.add(leaseWxCar);
                    } else {
                        for (int j = 0; j < leaseWxCarListFind.size(); j++) {
                            LeaseWxCar leaseWxCarFind = leaseWxCarListFind.get(j);
                            leaseWxCar.setId(leaseWxCarFind.getId());
                            leaseWxCarListUpdate.add(leaseWxCar);
                            //leaseWxCarService.updateByPrimaryKey(leaseWxCar);

                        }
                    }

                    wxCarTemplate.setUpdateState("成功");
                    successNum++;
                }

                if (leaseWxCarListInsert != null) {
                    if (leaseWxCarListInsert.size() > 0) {
                        for (LeaseWxCar leaseWxCar : leaseWxCarListInsert) {
                            leaseWxCarService.insertSelective(leaseWxCar);
                        }

                        //leaseWxCarService.insertList(leaseWxCarListInsert);
                    }
                }
                if (leaseWxCarListUpdate != null) {
                    if (leaseWxCarListUpdate.size() > 0) {
                        leaseWxCarService.updateByPrimaryKeyList(leaseWxCarListUpdate);
                    }
                }

                wxCarImportExcelBackInfo = new WxCarImportExcelBackInfo();
                wxCarImportExcelBackInfo.setFailNum(failNum);//失败数量
                wxCarImportExcelBackInfo.setSuccessNum(successNum);//成功数量
                wxCarImportExcelBackInfo.setBackInfo(null);//反馈信息
                wxCarImportExcelBackInfo.setWxCarTemplate(wxCarTemplateList);
            }
        }
        return wxCarImportExcelBackInfo;
    }
}
