package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.dao.LeaseCarInsuranceMapper;
import com.hc.lease.supplier.enumeration.CarInsuranceTypeEnum;
import com.hc.lease.supplier.model.LeaseCarInsurance;
import com.hc.lease.supplier.service.api.LeaseCarInsuranceService;
import com.hc.lease.supplier.service.api.LeaseCarService;
import com.hc.lease.supplier.service.api.LeaseInsuranceCompanyService;
import com.hc.lease.supplier.vo.CarInsuranceExportCountResult;
import com.hc.lease.supplier.vo.CarInsuranceExportEntity;
import com.hc.lease.supplier.vo.CarInsuranceExportEntityQuery;
import com.hc.lease.supplier.vo.CarInsuranceImportResultExcel;
import com.hc.lease.supplier.vo.InsuranceCarExportEntity;
import com.hc.lease.supplier.vo.InsuranceCarIdQuery;
import com.hc.lease.supplier.vo.LeaseCarInsuranceExcel;
import hc.lease.common.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 车辆保险信息ServiceImpl
 *
 * @author Qiang
 * @version 2017-05-08
 */
@Slf4j
@Service("leaseCarInsuranceService")
public class LeaseCarInsuranceServiceImpl implements LeaseCarInsuranceService {

    @Autowired
    private LeaseCarInsuranceMapper leaseCarInsuranceMapper;

    @Autowired
    private LeaseCarService leaseCarService;

    @Autowired
    private LeaseInsuranceCompanyService leaseInsuranceCompanyService;

    public int deleteByPrimaryKey(Long id) throws GMException {
        return leaseCarInsuranceMapper.deleteByPrimaryKey(id);
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        return leaseCarInsuranceMapper.deleteBatchById(ids);
    }

    public LeaseCarInsurance insert(LeaseCarInsurance record) throws GMException {
        this.setLeaseCarInsuranceProperty(record);
        leaseCarInsuranceMapper.insert(record);
        return record;
    }

    public LeaseCarInsurance insertSelective(LeaseCarInsurance record) throws GMException {
        this.setLeaseCarInsuranceProperty(record);
        leaseCarInsuranceMapper.insertSelective(record);
        return record;
    }


    public int insertList(List<LeaseCarInsurance> record) throws GMException {
        if (null != record && !record.isEmpty()) {
            for (LeaseCarInsurance leaseCarInsurance : record) {
                this.setLeaseCarInsuranceProperty(leaseCarInsurance);
            }
        }
        return leaseCarInsuranceMapper.insertList(record);
    }


    public int updateByPrimaryKeySelective(LeaseCarInsurance record) throws GMException {
        //设置保险到期日期
        this.setInsuranceExpireTime(record);
        return leaseCarInsuranceMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(LeaseCarInsurance record) throws GMException {
        //设置保险到期日期
        this.setInsuranceExpireTime(record);
        return leaseCarInsuranceMapper.updateByPrimaryKey(record);
    }


    public LeaseCarInsurance selectByPrimaryKey(Long id) throws GMException {
        return leaseCarInsuranceMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页
     */
    public PageInfo<LeaseCarInsurance> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseCarInsurance> leaseCarInsuranceList = leaseCarInsuranceMapper.findPage(paramsMap);
        return new PageInfo<>(null == leaseCarInsuranceList ? new ArrayList<LeaseCarInsurance>() : leaseCarInsuranceList);
    }

    public List<LeaseCarInsurance> findAll(Map<String, Object> paramsMap) throws GMException {
        return leaseCarInsuranceMapper.findAll(paramsMap);
    }

    public void updateByCarId(LeaseCarInsurance leaseCarInsurance) {
        //设置保险到期日期
        this.setInsuranceExpireTime(leaseCarInsurance);
        leaseCarInsuranceMapper.updateByCarId(leaseCarInsurance);

    }

    public void deleteByCarId(Long id) {
        leaseCarInsuranceMapper.deleteByCarId(id);
    }

    @Override
    public void updateEntity(LeaseCarInsurance leaseCarInsurance) throws Exception {
        //设置保险到期日期
        this.setInsuranceExpireTime(leaseCarInsurance);
        boolean updateState = leaseCarInsuranceMapper.updateEntity(leaseCarInsurance);
        if (!updateState) {
            throw new Exception("修改车辆保险信息失败，参数：" + leaseCarInsurance.toString());
        }
    }

    @Override
    public List<LeaseCarInsurance> selectEntity(LeaseCarInsurance leaseCarInsurance) {
        return leaseCarInsuranceMapper.selectEntity(leaseCarInsurance);
    }

    @Override
    public PageInfo<LeaseCarInsuranceExcel> exportPageQuery(InsuranceCarIdQuery queryParameter) {
        PageHelper.startPage(queryParameter.getPageNum(), queryParameter.getPageSize());
        List<Long> carIds;
        if (null != queryParameter.getExpireBeginDate() && null != queryParameter.getExpireEndDate()) {
            carIds = leaseCarInsuranceMapper.insuranceCarIdQuery(queryParameter);
        } else {
            carIds = leaseCarService.getAllAscCarIds();
        }
        List<LeaseCarInsuranceExcel> leaseCarInsuranceExcels = this.exportQuery(carIds);
        PageInfo<Long> carIdsPage = new PageInfo<>(carIds);
        PageInfo<LeaseCarInsuranceExcel> page = new PageInfo<>(leaseCarInsuranceExcels);
        page.setPageNum(carIdsPage.getPageNum());
        page.setPageSize(carIdsPage.getPageSize());
        page.setSize(carIdsPage.getSize());
        page.setStartRow(carIdsPage.getStartRow());
        page.setEndRow(carIdsPage.getEndRow());
        page.setTotal(carIdsPage.getTotal());
        page.setPages(carIdsPage.getPages());
        page.setFirstPage(carIdsPage.getFirstPage());
        page.setPrePage(carIdsPage.getPrePage());
        page.setNextPage(carIdsPage.getNextPage());
        page.setLastPage(carIdsPage.getLastPage());
        page.setIsFirstPage(carIdsPage.isIsFirstPage());
        page.setIsLastPage(carIdsPage.isIsLastPage());
        page.setHasPreviousPage(carIdsPage.isHasPreviousPage());
        page.setHasNextPage(carIdsPage.isHasNextPage());
        page.setNavigatePages(carIdsPage.getNavigatePages());
        return page;
    }

    @Override
    public List<LeaseCarInsuranceExcel> exportAllQuery(InsuranceCarIdQuery queryParameter) {
        List<Long> carIds;
        if (null != queryParameter.getExpireBeginDate() && null != queryParameter.getExpireEndDate()) {
            carIds = leaseCarInsuranceMapper.insuranceCarIdQuery(queryParameter);
        } else {
            carIds = leaseCarService.getAllAscCarIds();
        }
        return this.exportQuery(carIds);
    }

    private List<LeaseCarInsuranceExcel> exportQuery(List<Long> carIds) {
        if (null != carIds && !carIds.isEmpty()) {
            List<LeaseCarInsuranceExcel> leaseCarInsuranceExcelList = new ArrayList<>(carIds.size());
            InsuranceCarExportEntity carObj;
            CarInsuranceExportEntityQuery insuranceQuery = new CarInsuranceExportEntityQuery();
            insuranceQuery.setInsuranceYear(1);
            LeaseCarInsuranceExcel leaseCarInsuranceExcel;
            List<CarInsuranceExportEntity> carInsuranceExportEntities;
            CarInsuranceExportEntity insuranceObj;
            for (Long carId : carIds) {
                leaseCarInsuranceExcel = new LeaseCarInsuranceExcel();
                carObj = leaseCarService.insuranceCarExportEntityQuery(carId);
                if (null != carObj) {
                    leaseCarInsuranceExcel.carInfoSet(carObj.getCarId(), carObj.getCarBrandName(), carObj.getCarSeriesName(), carObj.getCarModelName(), carObj.getCarEngineNum(), carObj.getCarFrameNum(), carObj.getCarPlateNumber());
                }
                //查询交强险
                insuranceQuery.setCatId(carId);
                insuranceQuery.setInsuranceType(CarInsuranceTypeEnum.trafficCompelInsurance.getValue());
                insuranceQuery.setPortionNum(1);
                carInsuranceExportEntities = leaseCarInsuranceMapper.insuranceExportEntityQuery(insuranceQuery);
                if (null != carInsuranceExportEntities && !carInsuranceExportEntities.isEmpty()) {
                    insuranceObj = carInsuranceExportEntities.get(0);
                    leaseCarInsuranceExcel.jqInsuranceInfoSet(insuranceObj.getId(), insuranceObj.getInsuranceWarrantyNum(), insuranceObj.getInsuranceCompanyId(), insuranceObj.getInsuranceCompanyName(), insuranceObj.getInsuranceCost(), insuranceObj.getInsuranceEffectiveDate(), insuranceObj.getInsuranceExpireDate());
                }
                //查询商业险#1
                insuranceQuery.setInsuranceType(CarInsuranceTypeEnum.businessInsurance.getValue());
                carInsuranceExportEntities = leaseCarInsuranceMapper.insuranceExportEntityQuery(insuranceQuery);
                if (null != carInsuranceExportEntities && !carInsuranceExportEntities.isEmpty()) {
                    insuranceObj = carInsuranceExportEntities.get(0);
                    leaseCarInsuranceExcel.commercialInsuranceInfoSet(insuranceObj.getId(), insuranceObj.getInsuranceWarrantyNum(), insuranceObj.getInsuranceCompanyId(), insuranceObj.getInsuranceCompanyName(), insuranceObj.getInsuranceCost(), insuranceObj.getInsuranceEffectiveDate(), insuranceObj.getInsuranceExpireDate());
                }
                //查询商业险#2
                insuranceQuery.setPortionNum(2);
                carInsuranceExportEntities = leaseCarInsuranceMapper.insuranceExportEntityQuery(insuranceQuery);
                if (null != carInsuranceExportEntities && !carInsuranceExportEntities.isEmpty()) {
                    insuranceObj = carInsuranceExportEntities.get(0);
                    leaseCarInsuranceExcel.secondCommercialInsuranceInfoSet(insuranceObj.getId(), insuranceObj.getInsuranceWarrantyNum(), insuranceObj.getInsuranceCompanyId(), insuranceObj.getInsuranceCompanyName(), insuranceObj.getInsuranceCost(), insuranceObj.getInsuranceEffectiveDate(), insuranceObj.getInsuranceExpireDate());
                }
                leaseCarInsuranceExcelList.add(leaseCarInsuranceExcel);

            }
            return leaseCarInsuranceExcelList;
        }
        return null;
    }

    @Override
    public CarInsuranceExportCountResult saveCarInsuranceExcelImport(List<LeaseCarInsuranceExcel> list) throws Exception {
        if (null != list && !list.isEmpty()) {
            List<CarInsuranceImportResultExcel> resultList = new ArrayList<>(list.size());
            CarInsuranceImportResultExcel carInsuranceImportResultExcel;
            CarInsuranceExportEntityQuery insuranceQuery = new CarInsuranceExportEntityQuery();
            insuranceQuery.setInsuranceYear(1);
            List<CarInsuranceExportEntity> carInsuranceExportEntities;
            Long companyId;
            //导入成功数量
            int succeedNum = 0;
            //导入失败数量
            int failureNum = 0;
            for (LeaseCarInsuranceExcel insurance : list) {
                carInsuranceImportResultExcel = new CarInsuranceImportResultExcel();
                carInsuranceImportResultExcel.setLeaseCarInsuranceExcelProperty(insurance);
                resultList.add(carInsuranceImportResultExcel);
                //导入参数“车架号”校验，校验成功返回车辆ID
                Long carId = this.excelImportParamCarFrameNumCheck(carInsuranceImportResultExcel);
                if (null == carId) {
                    failureNum += 3;
                    continue;
                }
                insuranceQuery.setCatId(carId);
                //校验交强险导入参数,并返回保险公司ID
                companyId = this.excelImportJqInsuranceParamCheck(carInsuranceImportResultExcel);
                if (null != companyId) {
                    //查询第一年交强险，存在则进行更新操作，否则进行插入操作
                    insuranceQuery.setInsuranceType(CarInsuranceTypeEnum.trafficCompelInsurance.getValue());
                    insuranceQuery.setPortionNum(1);
                    carInsuranceExportEntities = leaseCarInsuranceMapper.insuranceExportEntityQuery(insuranceQuery);
                    this.excelImportDBHandle(carInsuranceExportEntities, carId, companyId, insuranceQuery.getInsuranceType(), insurance.getJqInsuranceWarrantyNum(), insurance.getJqInsuranceCost(), insurance.getJqInsuranceEffectiveDate());
                    //设置保险到期日期
                    carInsuranceImportResultExcel.setJqInsuranceExpireDate(this.getInsuranceExpireTime(insurance.getJqInsuranceEffectiveDate()));
                    succeedNum++;
                } else {
                    failureNum++;
                }
                //校验商业险#1导入参数,并返回保险公司ID
                companyId = this.excelImportCommercialInsuranceParamCheck(carInsuranceImportResultExcel);
                if (null != companyId) {
                    //查询第一年商业险#1，存在则进行更新操作，否则进行插入操作
                    insuranceQuery.setInsuranceType(CarInsuranceTypeEnum.businessInsurance.getValue());
                    insuranceQuery.setPortionNum(1);
                    carInsuranceExportEntities = leaseCarInsuranceMapper.insuranceExportEntityQuery(insuranceQuery);
                    this.excelImportDBHandle(carInsuranceExportEntities, carId, companyId, insuranceQuery.getInsuranceType(), insurance.getCommercialInsuranceWarrantyNum(), insurance.getCommercialInsuranceCost(), insurance.getCommercialInsuranceEffectiveDate());
                    //设置保险到期日期
                    carInsuranceImportResultExcel.setCommercialInsuranceExpireDate(this.getInsuranceExpireTime(insurance.getCommercialInsuranceEffectiveDate()));
                    succeedNum++;
                } else {
                    failureNum++;
                }
                //校验商业险#2导入参数,并返回保险公司ID
                companyId = this.excelImportSecondCommercialInsuranceParamCheck(carInsuranceImportResultExcel);
                if (null != companyId) {
                    //查询第一年商业险#2，存在则进行更新操作，否则进行插入操作
                    insuranceQuery.setInsuranceType(CarInsuranceTypeEnum.businessInsurance.getValue());
                    insuranceQuery.setPortionNum(2);
                    carInsuranceExportEntities = leaseCarInsuranceMapper.insuranceExportEntityQuery(insuranceQuery);
                    this.excelImportDBHandle(carInsuranceExportEntities, carId, companyId, insuranceQuery.getInsuranceType(), insurance.getSecondCommercialInsuranceWarrantyNum(), insurance.getSecondCommercialInsuranceCost(), insurance.getSecondCommercialInsuranceEffectiveDate());
                    //设置保险到期日期
                    carInsuranceImportResultExcel.setSecondCommercialInsuranceExpireDate(this.getInsuranceExpireTime(insurance.getSecondCommercialInsuranceEffectiveDate()));
                    succeedNum++;
                } else {
                    failureNum++;
                }
            }
            return new CarInsuranceExportCountResult(succeedNum, failureNum, resultList);
        }
        return null;
    }

    private void excelImportDBHandle(List<CarInsuranceExportEntity> list, Long carId, Long companyId, Integer insuranceType, String warrantyNum, BigDecimal insuranceCost, Date effectiveDate) throws Exception {
        LeaseCarInsurance leaseCarInsurance = new LeaseCarInsurance();
        if (null != list && !list.isEmpty()) {
            CarInsuranceExportEntity insuranceObj = list.get(0);
            leaseCarInsurance.carInsuranceImportUpdateSet(insuranceObj.getId(), companyId, insuranceType, warrantyNum, insuranceCost, effectiveDate);
            this.updateEntity(leaseCarInsurance);
        } else {
            leaseCarInsurance.carInsuranceImportAddSet(carId, companyId, insuranceType, 1, warrantyNum, insuranceCost, effectiveDate);
            this.insertSelective(leaseCarInsurance);
        }
    }

    private Long excelImportParamCarFrameNumCheck(CarInsuranceImportResultExcel insurance) {
        if (StringUtils.isEmpty(insurance.getCarFrameNum())) {
            insurance.setUnifyFailure("失败", "车架号必填");
            return null;
        }

        Long carId = leaseCarService.getCarIdByCardFrameNumber(insurance.getCarFrameNum());

        if (null == carId) {
            insurance.setUnifyFailure("失败", "车架号不存在");
            return null;
        }
        return carId;
    }

    //excel导入 交强险参数校验
    private Long excelImportJqInsuranceParamCheck(CarInsuranceImportResultExcel insurance) {
        if (StringUtils.isEmpty(insurance.getJqInsuranceCompanyName())) {
            insurance.setJqInsuranceImportFailure("失败", "交强险保险公司必填");
            return null;
        }

        if (null == insurance.getJqInsuranceEffectiveDate()) {
            insurance.setJqInsuranceImportFailure("失败", "交强险生效日期必填");
            return null;
        }

        Long companyId = leaseInsuranceCompanyService.getIdByInsuranceCompanyName(insurance.getJqInsuranceCompanyName());
        if (null == companyId) {
            insurance.setJqInsuranceImportFailure("失败", "交强险保险公司不存在");
            return null;
        }

        return companyId;
    }

    //excel导入 商业险#1参数校验
    private Long excelImportCommercialInsuranceParamCheck(CarInsuranceImportResultExcel insurance) {
        if (StringUtils.isEmpty(insurance.getCommercialInsuranceCompanyName())) {
            insurance.setCommercialInsuranceImportFailure("失败", "商业险#1保险公司必填");
            return null;
        }

        if (null == insurance.getCommercialInsuranceEffectiveDate()) {
            insurance.setCommercialInsuranceImportFailure("失败", "商业险#1生效日期必填");
            return null;
        }

        Long companyId = leaseInsuranceCompanyService.getIdByInsuranceCompanyName(insurance.getCommercialInsuranceCompanyName());
        if (null == companyId) {
            insurance.setCommercialInsuranceImportFailure("失败", "商业险#1保险公司不存在");
            return null;
        }

        return companyId;
    }

    //excel导入 商业险#2参数校验
    private Long excelImportSecondCommercialInsuranceParamCheck(CarInsuranceImportResultExcel insurance) {
        if (StringUtils.isEmpty(insurance.getSecondCommercialInsuranceCompanyName())) {
            insurance.setSecondCommercialInsuranceImportFailure("失败", "商业险#2保险公司必填");
            return null;
        }

        if (null == insurance.getSecondCommercialInsuranceEffectiveDate()) {
            insurance.setSecondCommercialInsuranceImportFailure("失败", "商业险#2生效日期必填");
            return null;
        }

        Long companyId = leaseInsuranceCompanyService.getIdByInsuranceCompanyName(insurance.getSecondCommercialInsuranceCompanyName());
        if (null == companyId) {
            insurance.setSecondCommercialInsuranceImportFailure("失败", "商业险#2保险公司不存在");
            return null;
        }

        return companyId;
    }

    private void setLeaseCarInsuranceProperty(LeaseCarInsurance record) {
        //设置保险份额
        record.setPortionNum(leaseCarInsuranceMapper.selectPortionNum(record) + 1);
        //设置保险到期日期
        this.setInsuranceExpireTime(record);
    }

    /**
     * 设置保险到期日期
     */
    private void setInsuranceExpireTime(LeaseCarInsurance record) {
        //设置保险到期日期
        if (null != record.getEffectiveTime()) {
            record.setExpireTime(this.getInsuranceExpireTime(record.getEffectiveTime()));
        }
    }

    private Date getInsuranceExpireTime(Date effectiveTime) {
        return DateUtils.dateCalculate(DateUtils.dateCalculate(effectiveTime, Calendar.YEAR, 1), Calendar.DATE, -1);
    }
}
