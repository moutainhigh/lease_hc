package com.hc.lease.wx.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.excel.poi.vo.WxCarSchemeImportExcelBackInfo;
import com.hc.lease.common.core.excel.poi.vo.WxCarSchemeTemplate;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.wx.adapter.api.LeaseWxCarSchemeAdapter;
import com.hc.lease.wx.model.LeaseWxCar;
import com.hc.lease.wx.model.LeaseWxCarScheme;
import com.hc.lease.wx.service.api.LeaseWxCarSchemeService;
import com.hc.lease.wx.service.api.LeaseWxCarService;
import hc.lease.common.util.ListUtil;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 车辆信息-融租方案AdapterImpl
 *
 * @author Qiang
 * @version 2017-11-29
 */
@Service("leaseWxCarSchemeAdapter")
public class LeaseWxCarSchemeAdapterImpl implements LeaseWxCarSchemeAdapter {

    @Autowired
    private LeaseWxCarSchemeService leaseWxCarSchemeService;

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
        int row = leaseWxCarSchemeService.deleteByPrimaryKey(id);
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
        int row = leaseWxCarSchemeService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseWxCarScheme record) throws GMException {
        record = leaseWxCarSchemeService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseWxCarScheme record) throws GMException {
        record = leaseWxCarSchemeService.insertSelective(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseWxCarScheme record) throws GMException {
        int row = leaseWxCarSchemeService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseWxCarScheme record) throws GMException {
        int row = leaseWxCarSchemeService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseWxCarScheme selectByPrimaryKey(Long id) throws GMException {
        LeaseWxCarScheme leaseWxCarScheme = leaseWxCarSchemeService.selectByPrimaryKey(id);
        return leaseWxCarScheme;
    }

    public int insertList(List<LeaseWxCarScheme> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseWxCarScheme> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseWxCarScheme> page = leaseWxCarSchemeService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseWxCarScheme> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseWxCarScheme> leaseWxCarSchemeList = leaseWxCarSchemeService.findAll(paramsMap);
        return leaseWxCarSchemeList;
    }

    /**
     * 处理小程序车辆方案导入
     *
     * @param wxCarSchemeTemplateList 车辆方案数据
     * @param userSession
     * @return
     * @throws GMException
     */
    @Override
    public WxCarSchemeImportExcelBackInfo importExcelWxCarScheme(List<WxCarSchemeTemplate> wxCarSchemeTemplateList, UserSession userSession) throws GMException {

        WxCarSchemeImportExcelBackInfo wxCarSchemeImportExcelBackInfo = null;
        ArrayList<LeaseWxCarScheme> leaseWxSchemeCarListInsert = new ArrayList<LeaseWxCarScheme>();

        if (wxCarSchemeTemplateList != null) {
            if (wxCarSchemeTemplateList.size() > 0) {
                int successNum = 0;
                int failNum = 0;
                for (int i = 0; i < wxCarSchemeTemplateList.size(); i++) {

                    WxCarSchemeTemplate wxCarSchemeTemplate = wxCarSchemeTemplateList.get(i);//导入方案的数据
                    Map<String, Object> paramsMap = Maps.newHashMap();
                    paramsMap.put("carName", wxCarSchemeTemplate.getCarName().trim());//车辆名称
                    List<LeaseWxCar> leaseWxCarList = leaseWxCarService.findByCarName(paramsMap);//车辆数据

                    String downPayment = wxCarSchemeTemplate.getDownPayment();
                    String monthlyRent = wxCarSchemeTemplate.getMonthlyRent();
                    Integer stagingNumber = wxCarSchemeTemplate.getStagingNumber();
                    String balancePayment = wxCarSchemeTemplate.getBalancePayment();
                    if (StringUtils.isBlank(downPayment) || StringUtils.isBlank(monthlyRent)
                            || stagingNumber == null || StringUtils.isBlank(balancePayment)) {
                        wxCarSchemeTemplate.setUpdateState("失败");
                        failNum++;
                        continue;
                    }

                    if (leaseWxCarList != null) {
                        if (leaseWxCarList.size() > 0) {
                            for (int j = 0; j < leaseWxCarList.size(); j++) {

                                LeaseWxCarScheme leaseWxCarScheme = new LeaseWxCarScheme();
                                LeaseWxCar leaseWxCar = leaseWxCarList.get(j);

                                leaseWxCarSchemeService.deleteByCarId(leaseWxCar.getId());//先清除车辆的方案

                                leaseWxCarScheme.setCarId(leaseWxCar.getId());//车辆主键ID

                                leaseWxCarScheme.setDownPayment(wxCarSchemeTemplate.getDownPayment() == null ? new BigDecimal(0) : new BigDecimal(wxCarSchemeTemplate.getDownPayment()));//首付
                                leaseWxCarScheme.setMonthlyRent(wxCarSchemeTemplate.getMonthlyRent() == null ? new BigDecimal(0) : new BigDecimal(wxCarSchemeTemplate.getMonthlyRent()));//月租
                                leaseWxCarScheme.setStagingNumber(wxCarSchemeTemplate.getStagingNumber() == null ? 0 : new BigDecimal(wxCarSchemeTemplate.getStagingNumber()).intValue());//分期数
                                leaseWxCarScheme.setBalancePayment(wxCarSchemeTemplate.getBalancePayment() == null ? new BigDecimal(0) : new BigDecimal(wxCarSchemeTemplate.getBalancePayment()));

                                leaseWxCarScheme.setCreateBy(null);//创建人
                                leaseWxCarScheme.setCreateTime(DateTime.now().toDate());//创建时间
                                leaseWxCarScheme.setUpdateBy(null);//修改人
                                leaseWxCarScheme.setUpdateTime(DateTime.now().toDate());//修改时间
                                leaseWxSchemeCarListInsert.add(leaseWxCarScheme);
                            }
                        }
                    }

                    wxCarSchemeTemplate.setUpdateState("成功");
                    successNum++;

                }

                if (leaseWxSchemeCarListInsert != null) {
                    if (leaseWxSchemeCarListInsert.size() > 0) {
                        leaseWxCarSchemeService.insertList(leaseWxSchemeCarListInsert);
                    }
                }

                wxCarSchemeImportExcelBackInfo = new WxCarSchemeImportExcelBackInfo();
                wxCarSchemeImportExcelBackInfo.setFailNum(failNum);//失败数量
                wxCarSchemeImportExcelBackInfo.setSuccessNum(successNum);//成功数量
                wxCarSchemeImportExcelBackInfo.setBackInfo(null);//反馈信息
                wxCarSchemeImportExcelBackInfo.setWxCarSchemeTemplate(wxCarSchemeTemplateList);
            }
        }

        return wxCarSchemeImportExcelBackInfo;
    }
}
