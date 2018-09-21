package com.hc.lease.wx.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.excel.poi.vo.WxCarOtherSchemeImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.WxCarOtherSchemeTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.wx.model.BalancePaymentStagingNumberVo;
import com.hc.lease.wx.model.LeaseWxCar;
import com.hc.lease.wx.service.api.LeaseWxCarService;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.wx.adapter.api.LeaseWxCarOtherSchemeAdapter;
import com.hc.lease.wx.service.api.LeaseWxCarOtherSchemeService;
import com.hc.lease.wx.model.LeaseWxCarOtherScheme;

import hc.lease.common.util.ListUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 车辆1+X方案AdapterImpl
 * @author Qiang
 * @version 2018-04-10
 */
@Service("leaseWxCarOtherSchemeAdapter")
public class LeaseWxCarOtherSchemeAdapterImpl implements LeaseWxCarOtherSchemeAdapter {

	@Autowired
	private LeaseWxCarOtherSchemeService leaseWxCarOtherSchemeService;
    @Autowired
    private LeaseWxCarService leaseWxCarService;

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
        int row = leaseWxCarOtherSchemeService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseWxCarOtherSchemeService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseWxCarOtherScheme record) throws GMException {
        record = leaseWxCarOtherSchemeService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseWxCarOtherScheme record) throws GMException {
        record = leaseWxCarOtherSchemeService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseWxCarOtherScheme record) throws GMException {
        int row = leaseWxCarOtherSchemeService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxCarOtherScheme record) throws GMException {
        int row = leaseWxCarOtherSchemeService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseWxCarOtherScheme selectByPrimaryKey(Long id) throws GMException {
        LeaseWxCarOtherScheme leaseWxCarOtherScheme = leaseWxCarOtherSchemeService.selectByPrimaryKey(id);
        return leaseWxCarOtherScheme;
    }

    public int insertList(List<LeaseWxCarOtherScheme> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseWxCarOtherScheme> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseWxCarOtherScheme> page = leaseWxCarOtherSchemeService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseWxCarOtherScheme> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxCarOtherScheme> leaseWxCarOtherSchemeList = leaseWxCarOtherSchemeService.findAll(paramsMap);
        return leaseWxCarOtherSchemeList;
    }


    public WxCarOtherSchemeImportExcelBackInfo importExcelWxCarOtherScheme(List<WxCarOtherSchemeTemplate> wxCarOtherSchemeTemplates) throws GMException {

        WxCarOtherSchemeImportExcelBackInfo wxCarOtherSchemeImportExcelBackInfo = null;
        ArrayList<LeaseWxCarOtherScheme> leaseWxOtherSchemeCarListInsert = new ArrayList<LeaseWxCarOtherScheme>();

        if (wxCarOtherSchemeTemplates != null) {
            if (wxCarOtherSchemeTemplates.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                for (int i = 0; i < wxCarOtherSchemeTemplates.size(); i++) {
                    WxCarOtherSchemeTemplate wxCarOtherSchemeTemplate = wxCarOtherSchemeTemplates.get(i);//导入方案的数据
                    Map<String, Object> paramsMap = Maps.newHashMap();
                    paramsMap.put("carName", wxCarOtherSchemeTemplate.getCarName().trim());//车辆名称
                    List<LeaseWxCar> leaseWxCarList = leaseWxCarService.findByCarName(paramsMap);//车辆数据

                     String carName=wxCarOtherSchemeTemplate.getCarName();
                 /*   String downPayment = wxCarOtherSchemeTemplate.getDownPayment();
                    String monthlyRent = wxCarOtherSchemeTemplate.getMonthlyRent();
                    Integer stagingNumber = wxCarOtherSchemeTemplate.getStagingNumber();
                    String balancePayment = wxCarOtherSchemeTemplate.getBalancePayment();*/
                    if (StringUtils.isBlank(carName)) {
                        wxCarOtherSchemeTemplate.setUpdateState("失败");
                        failNum++;
                        continue;
                    }

                    if (leaseWxCarList != null) {
                        if (leaseWxCarList.size() > 0) {
                            for (int j = 0; j < leaseWxCarList.size(); j++) {

                                LeaseWxCarOtherScheme leaseWxCarOtherScheme = new LeaseWxCarOtherScheme();
                                LeaseWxCar leaseWxCar = leaseWxCarList.get(j);

                                //leaseWxCarSchemeService.deleteByCarId(leaseWxCar.getId());//先清除车辆的方案

                                leaseWxCarOtherScheme.setCarId(leaseWxCar.getId());//车辆主键ID

                                leaseWxCarOtherScheme.setDownPayment(StringUtils.isBlank(wxCarOtherSchemeTemplate.getDownPayment())  ? new BigDecimal(0) : new BigDecimal(wxCarOtherSchemeTemplate.getDownPayment()));//首付
                                leaseWxCarOtherScheme.setMonthlyRent(StringUtils.isBlank(wxCarOtherSchemeTemplate.getMonthlyRent()) ? new BigDecimal(0) : new BigDecimal(wxCarOtherSchemeTemplate.getMonthlyRent()));//月租
                                leaseWxCarOtherScheme.setFirstYearStagingNumber(wxCarOtherSchemeTemplate.getFirstYearStagingNumber() == null ? null : new BigDecimal(wxCarOtherSchemeTemplate.getFirstYearStagingNumber()).intValue());//分期数
                                leaseWxCarOtherScheme.setBalancePayment(StringUtils.isBlank(wxCarOtherSchemeTemplate.getBalancePayment())  ? new BigDecimal(0) : new BigDecimal(wxCarOtherSchemeTemplate.getBalancePayment()));

                                List<BalancePaymentStagingNumberVo> balancePaymentStagingNumberVos=new ArrayList<BalancePaymentStagingNumberVo>();
                                if(!StringUtils.isBlank(wxCarOtherSchemeTemplate.getStagingNumber24MonthlyRent())){
                                    BalancePaymentStagingNumberVo balancePaymentStagingNumberVo1=createBalancePaymentStagingNumberVo(new BigDecimal(wxCarOtherSchemeTemplate.getStagingNumber24MonthlyRent()),24);
                                    balancePaymentStagingNumberVos.add(balancePaymentStagingNumberVo1);
                                }
                                if (!StringUtils.isBlank(wxCarOtherSchemeTemplate.getStagingNumber36MonthlyRent())){
                                    BalancePaymentStagingNumberVo balancePaymentStagingNumberVo2=createBalancePaymentStagingNumberVo(new BigDecimal(wxCarOtherSchemeTemplate.getStagingNumber36MonthlyRent()),36);
                                    balancePaymentStagingNumberVos.add(balancePaymentStagingNumberVo2);
                                }

                                leaseWxCarOtherScheme.setBalancePaymentStagingNumber(balancePaymentStagingNumberVos);

                                leaseWxCarOtherScheme.setCreateBy(null);//创建人
                                leaseWxCarOtherScheme.setCreateTime(DateTime.now().toDate());//创建时间
                                leaseWxCarOtherScheme.setUpdateBy(null);//修改人
                                leaseWxCarOtherScheme.setUpdateTime(DateTime.now().toDate());//修改时间


                                LeaseWxCarOtherScheme leaseWxCarOtherScheme1 = leaseWxCarOtherSchemeService.selectByCarId(leaseWxCar.getId());
                                if(leaseWxCarOtherScheme1!=null){
                                    leaseWxCarOtherSchemeService.updateByCarId(leaseWxCarOtherScheme);
                                }else{
                                    leaseWxCarOtherSchemeService.insertSelective(leaseWxCarOtherScheme);
                                }

                            }
                        }
                    }
                    wxCarOtherSchemeTemplate.setUpdateState("成功");
                    successNum++;

                }

                wxCarOtherSchemeImportExcelBackInfo = new WxCarOtherSchemeImportExcelBackInfo();
                wxCarOtherSchemeImportExcelBackInfo.setFailNum(failNum);//失败数量
                wxCarOtherSchemeImportExcelBackInfo.setSuccessNum(successNum);//成功数量
                wxCarOtherSchemeImportExcelBackInfo.setBackInfo(null);//反馈信息
                wxCarOtherSchemeImportExcelBackInfo.setWxCarOtherSchemeTemplate(wxCarOtherSchemeTemplates);
            }
        }

        return wxCarOtherSchemeImportExcelBackInfo;

    }

    public static BalancePaymentStagingNumberVo  createBalancePaymentStagingNumberVo(BigDecimal monthlyRent,Integer stagingNumber){
        BalancePaymentStagingNumberVo balancePaymentStagingNumberVo=new BalancePaymentStagingNumberVo();
        balancePaymentStagingNumberVo.setMonthlyRent(monthlyRent);
        balancePaymentStagingNumberVo.setStagingNumber(stagingNumber);
        return balancePaymentStagingNumberVo;
    }


}
