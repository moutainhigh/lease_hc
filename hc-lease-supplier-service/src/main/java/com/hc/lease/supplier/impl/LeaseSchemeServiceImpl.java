package com.hc.lease.supplier.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.dao.LeaseSchemeAreaMapper;
import com.hc.lease.supplier.model.LeaseCarSupplier;
import com.hc.lease.supplier.model.LeaseSchemeArea;
import com.hc.lease.supplier.model.LeaseSchemePackage;
import com.hc.lease.supplier.model.LeaseSchemeVehicle;
import hc.lease.common.util.JsonUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.service.LeaseSchemeService;
import com.hc.lease.supplier.model.LeaseScheme;
import com.hc.lease.supplier.dao.LeaseSchemeMapper;

import java.util.List;
import java.util.Map;

/**
 * 融租方案ServiceImpl
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseSchemeService")
public class LeaseSchemeServiceImpl implements LeaseSchemeService {

	@Autowired
	private LeaseSchemeMapper leaseSchemeMapper;
    @Autowired
    private LeaseSchemeAreaMapper leaseSchemeAreaMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemeMapper.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row= leaseSchemeMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseScheme insert(LeaseScheme record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseSchemeMapper.insert(record);
        return record;
    }

    public LeaseScheme insertSelective(LeaseScheme record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseSchemeMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseScheme> record) throws GMException {
        int row = leaseSchemeMapper.insertList(record);
        return row;
    }


    public int updateByPrimaryKeySelective(LeaseScheme record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseScheme record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseScheme selectByPrimaryKey(Long id) throws GMException {
        LeaseScheme leaseScheme = leaseSchemeMapper.selectByPrimaryKey(id);
        return leaseScheme;
    }
    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseScheme> findPage(int pageNum, int pageSize,Map<String,Object> params) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseScheme> leaseSchemeList = leaseSchemeMapper.findPage(params);

        if (leaseSchemeList != null) {
            if (leaseSchemeList.size() > 0) {
                for (int i = 0; i < leaseSchemeList.size(); i++) {
                    LeaseScheme leaseScheme = leaseSchemeList.get(i);
                    if (leaseScheme != null) {
                        List<LeaseSchemeArea> leaseSchemeAreaList = leaseScheme.getLeaseSchemeAreas();
                        if (leaseSchemeAreaList != null) {
                            if (leaseSchemeAreaList.size() > 0) {
                                String leaseSchemeAreaJson = JsonUtil.stringify(leaseSchemeAreaList);
                                leaseScheme.setLeaseSchemeAreaJson(leaseSchemeAreaJson);
                            }
                        }
                        List<LeaseSchemeVehicle> leaseSchemeVehicleList = leaseScheme.getLeaseSchemeVehicles();
                        if (leaseSchemeVehicleList != null) {
                            if (leaseSchemeVehicleList.size() > 0) {
                                String leaseSchemeVehicleJson = JsonUtil.stringify(leaseSchemeVehicleList);
                                leaseScheme.setLeaseSchemeVehicleJson(leaseSchemeVehicleJson);
                            }
                        }
                    }
                }
            }
        }
        PageInfo<LeaseScheme> page = new PageInfo<LeaseScheme>(leaseSchemeList);
        return page;
    }

    public List <LeaseScheme> findAll(Map<String,Object> params) throws GMException {
        List<LeaseScheme> leaseSchemeList = leaseSchemeMapper.findAll(params);
        return leaseSchemeList;
    }

    public List<LeaseScheme> findAllNoPage() {
        List<LeaseScheme> leaseSchemeList=leaseSchemeMapper.findPage(null);
        return leaseSchemeList;
    }

    public List<LeaseScheme> findByName(Map params) {
        List<LeaseScheme> leaseCarSupplierList= leaseSchemeMapper.findByName(params);
        return leaseCarSupplierList;
    }
}
