package com.hc.lease.supplier.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.model.LeaseCarDictAccessory;
import com.hc.lease.supplier.model.LeaseCarInsurance;
import com.hc.lease.supplier.model.LeaseCarInventory;
import hc.lease.common.util.JsonUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.LeaseCarService;
import com.hc.lease.supplier.model.LeaseCar;
import com.hc.lease.supplier.dao.LeaseCarMapper;

import java.util.List;
import java.util.Map;

/**
 * 车辆信息ServiceImpl
 *
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseCarService")
public class LeaseCarServiceImpl implements LeaseCarService {

    @Autowired
    private LeaseCarMapper leaseCarMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseCarMapper.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseCarMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseCar insert(LeaseCar record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseCarMapper.insert(record);
        return record;
    }

    public LeaseCar insertSelective(LeaseCar record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseCarMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseCar> record) throws GMException {
        int row = leaseCarMapper.insertList(record);
        return row;
    }


    public int updateByPrimaryKeySelective(LeaseCar record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseCarMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseCar record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseCarMapper.updateByPrimaryKey(record);
        return row;
    }


    public LeaseCar selectByPrimaryKey(Long id) throws GMException {
        LeaseCar leaseCar = leaseCarMapper.selectByPrimaryKey(id);
        return leaseCar;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseCar> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseCar> leaseCarList = leaseCarMapper.findPage(paramsMap);
        if (leaseCarList != null) {
            if (leaseCarList.size() > 0) {
                for (int i = 0; i < leaseCarList.size(); i++) {
                    LeaseCar leaseCar = leaseCarList.get(i);
                    if (leaseCar != null) {
                        List<LeaseCarDictAccessory> leaseCarDictAccessories = leaseCar.getLeaseCarDictAccessories();
                        if (leaseCarDictAccessories != null) {
                            if (leaseCarDictAccessories.size() > 0) {
                                String leaseCarDictAccessory = JsonUtil.stringify(leaseCarDictAccessories);
                                leaseCar.setLeaseCarDictAccessoriesJson(leaseCarDictAccessory);
                            }
                        }
                        List<LeaseCarInsurance> leaseCarInsuranceList = leaseCar.getLaseCarInsurances();
                        if (leaseCarInsuranceList != null) {
                            if (leaseCarInsuranceList.size() > 0) {
                                String LaseCarinsurances = JsonUtil.stringify(leaseCarInsuranceList);
                                leaseCar.setLaseCarinsurancesJson(LaseCarinsurances);
                            }
                        }
                    }
                }
            }
        }
        PageInfo<LeaseCar> page = new PageInfo<LeaseCar>(leaseCarList);
        return page;
    }

    public List<LeaseCar> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseCar> leaseCarList = leaseCarMapper.findAll(paramsMap);
        return leaseCarList;
    }

    public List<LeaseCar> findByGpsSupplierId(List<Long> ids) {

        List<LeaseCar> leaseCarList = leaseCarMapper.findByGpsSupplierId(ids);

        return leaseCarList;
    }

    public List<LeaseCar> findByStorehouseId(List<Long> ids) {

        List<LeaseCar> leaseCarList = leaseCarMapper.findByStorehouseId(ids);
        return leaseCarList;
    }

    public List<LeaseCar> selectAllCarNoPage(Map<String, Object> paramsMap) {
        List<LeaseCar> leaseCarList = leaseCarMapper.findCarAndPrice(paramsMap);
        return leaseCarList;
    }

    /**
     * 根据车辆车型主键id查找
     *
     * @param ids
     * @return
     * @throws GMException
     */
    public List<LeaseCar> findByModelId(List<Long> ids) throws GMException {
        List<LeaseCar> leaseCarSeriesList = leaseCarMapper.findByModelId(ids);
        return leaseCarSeriesList;
    }

    /**
     * 根据融资方主键id查找
     *
     * @param ids
     * @return
     * @throws GMException
     */
    public List<LeaseCar> findByCarBuyFinancingerId(List<Long> ids) throws GMException {
        List<LeaseCar> leaseCarSeriesList = leaseCarMapper.findByCarBuyFinancingerId(ids);
        return leaseCarSeriesList;
    }

    /**
     * 根据经销商主键id查找
     *
     * @param ids
     * @return
     * @throws GMException
     */
    public List<LeaseCar> findByDealerId(List<Long> ids) throws GMException {
        List<LeaseCar> leaseCarSeriesList = leaseCarMapper.findByDealerId(ids);
        return leaseCarSeriesList;
    }

    /**
     * @param paramsMap
     * @return
     */
    public List<LeaseCar> findByParams(Map<String, Object> paramsMap) {
        List<LeaseCar> leaseCarSeriesList = leaseCarMapper.findByParams(paramsMap);
        return leaseCarSeriesList;
    }
}
