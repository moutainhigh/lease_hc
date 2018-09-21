package com.hc.lease.supplier.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.supplier.model.LeaseSchemePrice1x;
import com.hc.lease.supplier.model.LeaseSchemePriceAnnual;
import com.hc.lease.supplier.model.LeaseSchemePriceRent;
import com.hc.lease.supplier.model.LeaseSchemePriceStages;
import com.hc.lease.supplier.service.api.LeaseSchemePrice1xService;
import com.hc.lease.supplier.service.api.LeaseSchemePriceAnnualService;
import com.hc.lease.supplier.service.api.LeaseSchemePriceRentService;
import com.hc.lease.supplier.service.api.LeaseSchemePriceStagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.lease.supplier.adapter.api.LeaseSchemePriceAdapter;
import com.hc.lease.supplier.service.api.LeaseSchemePriceService;
import com.hc.lease.supplier.model.LeaseSchemePrice;

import hc.lease.common.util.ListUtil;
import java.util.List;
import java.util.Map;
import com.hc.lease.common.core.exception.ResultHashMap;

/**
 * 方案报价AdapterImpl
 * @author Qiang
 * @version 2018-07-27
 */
@Service("leaseSchemePriceAdapter")
public class LeaseSchemePriceAdapterImpl implements LeaseSchemePriceAdapter {

	@Autowired
	private LeaseSchemePriceService leaseSchemePriceService;
    @Autowired
    private LeaseSchemePrice1xService leaseSchemePrice1xService;
    @Autowired
    private LeaseSchemePriceAnnualService leaseSchemePriceAnnualService;
    @Autowired
    private LeaseSchemePriceStagesService leaseSchemePriceStagesService;
    @Autowired
    private LeaseSchemePriceRentService leaseSchemePriceRentService;

    /**
    * 添加或者修改 需要的初始化参数
    *
    * @param paramsMap
    * @return
    */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    /**
    * 根据ID删除记录
    *
    * @param id .
    * @return
    * @throws GMException
    */
    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemePriceService.deleteByPrimaryKey(id);
        return row;
    }

    /**
    * 根据ID删除记录.批量删除
    * @param ids .
    * @return
    * @throws GMException
    */
    public int deleteBatchById(List<Long> ids) throws GMException {
        int row = leaseSchemePriceService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseSchemePrice record) throws GMException {
        record = leaseSchemePriceService.insert(record);
        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseSchemePrice record) throws GMException {

        record.setType(0);
        record = leaseSchemePriceService.insertSelective(record);

        if(record.getLeaseSchemePrice1xs()!=null && record.getLeaseSchemePrice1xs().size()>0){
            List<LeaseSchemePrice1x> leaseSchemePrice1xs = record.getLeaseSchemePrice1xs();
            for (LeaseSchemePrice1x leaseSchemePrice1x : leaseSchemePrice1xs) {
                leaseSchemePrice1x.setSchemePriceId(record.getId());
                leaseSchemePrice1xService.insertSelective(leaseSchemePrice1x);
            }
        }

        if(record.getLeaseSchemePriceAnnuals()!=null && record.getLeaseSchemePriceAnnuals().size()>0){
            List<LeaseSchemePriceAnnual> leaseSchemePriceAnnuals = record.getLeaseSchemePriceAnnuals();
            for (LeaseSchemePriceAnnual leaseSchemePriceAnnual : leaseSchemePriceAnnuals) {
                leaseSchemePriceAnnual.setSchemePriceId(record.getId());
                leaseSchemePriceAnnualService.insertSelective(leaseSchemePriceAnnual);
            }
        }
        if(record.getLeaseSchemePriceStages()!=null && record.getLeaseSchemePriceStages().size()>0){
            List<LeaseSchemePriceStages> leaseSchemePriceStages = record.getLeaseSchemePriceStages();
            for (LeaseSchemePriceStages leaseSchemePriceStage : leaseSchemePriceStages) {
                leaseSchemePriceStage.setSchemePriceId(record.getId());
                leaseSchemePriceStagesService.insertSelective(leaseSchemePriceStage);
            }
        }

        if(record.getLeaseSchemePriceRents()!=null && record.getLeaseSchemePriceRents().size()>0){
            List<LeaseSchemePriceRent> leaseSchemePriceRents = record.getLeaseSchemePriceRents();
            for (LeaseSchemePriceRent leaseSchemePriceRent : leaseSchemePriceRents) {
                leaseSchemePriceRent.setSchemePriceId(record.getId());
                leaseSchemePriceRentService.insertSelective(leaseSchemePriceRent);
            }
        }

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public int updateByPrimaryKeySelective(LeaseSchemePrice record) throws GMException {
        record = leaseSchemePriceService.insertSelective(record);
        leaseSchemePrice1xService.deleteBySchemePriceId(record.getId());
        leaseSchemePriceAnnualService.deleteBySchemePriceId(record.getId());
        leaseSchemePriceStagesService.deleteBySchemePriceId(record.getId());
        leaseSchemePriceRentService.deleteBySchemePriceId(record.getId());

        if(record.getLeaseSchemePrice1xs()!=null && record.getLeaseSchemePrice1xs().size()>0){
            List<LeaseSchemePrice1x> leaseSchemePrice1xs = record.getLeaseSchemePrice1xs();
            for (LeaseSchemePrice1x leaseSchemePrice1x : leaseSchemePrice1xs) {
                leaseSchemePrice1x.setSchemePriceId(record.getId());
                leaseSchemePrice1xService.insertSelective(leaseSchemePrice1x);
            }
        }

        if(record.getLeaseSchemePriceAnnuals()!=null && record.getLeaseSchemePriceAnnuals().size()>0){
            List<LeaseSchemePriceAnnual> leaseSchemePriceAnnuals = record.getLeaseSchemePriceAnnuals();
            for (LeaseSchemePriceAnnual leaseSchemePriceAnnual : leaseSchemePriceAnnuals) {
                leaseSchemePriceAnnual.setSchemePriceId(record.getId());
                leaseSchemePriceAnnualService.insertSelective(leaseSchemePriceAnnual);
            }
        }
        if(record.getLeaseSchemePriceStages()!=null && record.getLeaseSchemePriceStages().size()>0){
            List<LeaseSchemePriceStages> leaseSchemePriceStages = record.getLeaseSchemePriceStages();
            for (LeaseSchemePriceStages leaseSchemePriceStage : leaseSchemePriceStages) {
                leaseSchemePriceStage.setSchemePriceId(record.getId());
                leaseSchemePriceStagesService.insertSelective(leaseSchemePriceStage);
            }
        }


        if(record.getLeaseSchemePriceRents()!=null && record.getLeaseSchemePriceRents().size()>0){
            List<LeaseSchemePriceRent> leaseSchemePriceRents = record.getLeaseSchemePriceRents();
            for (LeaseSchemePriceRent leaseSchemePriceRent : leaseSchemePriceRents) {
                leaseSchemePriceRent.setSchemePriceId(record.getId());
                leaseSchemePriceRentService.insertSelective(leaseSchemePriceRent);
            }
        }

        return 0;
    }

    public int updateByPrimaryKey(LeaseSchemePrice record) throws GMException {
        int row = leaseSchemePriceService.updateByPrimaryKey(record);
        return row;
    }

    public LeaseSchemePrice selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemePrice leaseSchemePrice = leaseSchemePriceService.selectByPrimaryKey(id);
        return leaseSchemePrice;
    }

    public int insertList(List<LeaseSchemePrice> list) throws GMException {
        return 0;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo<LeaseSchemePrice> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseSchemePrice> page = leaseSchemePriceService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
    * 所有数据列表
    *
    * @return
    */
    public List<LeaseSchemePrice> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemePrice> leaseSchemePriceList = leaseSchemePriceService.findAll(paramsMap);
        return leaseSchemePriceList;
    }

}
