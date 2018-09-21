package com.hc.lease.supplier.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.supplier.dao.LeaseSchemePackageMapper;
import com.hc.lease.supplier.model.LeaseSchemePackage;
import com.hc.lease.supplier.service.api.LeaseSchemePackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融租方案-套餐ServiceImpl
 * @author Qiang
 * @version 2017-05-08
 */
@Service("leaseSchemePackageService")
public class LeaseSchemePackageServiceImpl implements LeaseSchemePackageService {

	@Autowired
	private LeaseSchemePackageMapper leaseSchemePackageMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemePackageMapper.deleteByPrimaryKey(id);
        return row;
    }

    public int deleteBatchById(List<Long> ids) throws GMException {
        int row= leaseSchemePackageMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseSchemePackage insert(LeaseSchemePackage record) throws GMException {

        int row = leaseSchemePackageMapper.insert(record);
        return record;
    }

    public LeaseSchemePackage insertSelective(LeaseSchemePackage record) throws GMException {
        int row = leaseSchemePackageMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseSchemePackage> record) throws GMException {
        int row = leaseSchemePackageMapper.insertList(record);
        return row;
    }


    public int updateByPrimaryKeySelective(LeaseSchemePackage record) throws GMException {
        int row = leaseSchemePackageMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemePackage record) throws GMException {
        int row = leaseSchemePackageMapper.updateByPrimaryKey(record);
        return row;
    }



    public LeaseSchemePackage selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemePackage leaseSchemePackage = leaseSchemePackageMapper.selectByPrimaryKey(id);
        return leaseSchemePackage;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseSchemePackage> findPage(int pageNum, int pageSize, Map<String,Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseSchemePackage> leaseSchemePackageList = leaseSchemePackageMapper.findPage(paramsMap);
        PageInfo<LeaseSchemePackage> page = new PageInfo<LeaseSchemePackage>(leaseSchemePackageList);
        return page;
    }

    public List <LeaseSchemePackage> findAll( Map<String,Object> paramsMap) throws GMException {
        List<LeaseSchemePackage> leaseSchemePackageList = leaseSchemePackageMapper.findAll(paramsMap);
        return leaseSchemePackageList;
    }

    public LeaseSchemePackage selectBySchemeId(Long id) {
        LeaseSchemePackage leaseSchemePackage=leaseSchemePackageMapper.selectBySchemeId(id);

        return leaseSchemePackage;
    }
}
