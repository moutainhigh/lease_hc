package com.hc.lease.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.order.dao.LeaseSchemeOrderMapper;
import com.hc.lease.order.model.LeaseSchemeOrder;
import com.hc.lease.order.service.api.LeaseSchemeOrderService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 融租方案申请订单ServiceImpl
 * @author Qiang
 * @version 2017-05-23
 */
@Service("leaseSchemeOrderService")
public class LeaseSchemeOrderServiceImpl implements LeaseSchemeOrderService {

	@Autowired
	private LeaseSchemeOrderMapper leaseSchemeOrderMapper;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseSchemeOrderMapper.deleteByPrimaryKey(id);
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
        int row = leaseSchemeOrderMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseSchemeOrder insert(LeaseSchemeOrder record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeOrderMapper.insert(record);
        return record;
    }

    public LeaseSchemeOrder insertSelective(LeaseSchemeOrder record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeOrderMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseSchemeOrder> list) throws GMException {
        return 0;
    }


    public int updateByPrimaryKeySelective(LeaseSchemeOrder record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeOrderMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseSchemeOrder record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseSchemeOrderMapper.updateByPrimaryKey(record);
        return row;
    }



    public LeaseSchemeOrder selectByPrimaryKey(Long id) throws GMException {
        LeaseSchemeOrder leaseSchemeOrder = leaseSchemeOrderMapper.selectByPrimaryKey(id);
        return leaseSchemeOrder;
    }

    /**
    * 分页
    *
    * @return
    */
    public PageInfo <LeaseSchemeOrder> findPage(int pageNum, int pageSize,Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseSchemeOrder> leaseSchemeOrderList = leaseSchemeOrderMapper.findPage(paramsMap);
        PageInfo<LeaseSchemeOrder> page = new PageInfo<LeaseSchemeOrder>(leaseSchemeOrderList);
        return page;
    }

    public List <LeaseSchemeOrder> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseSchemeOrder> leaseSchemeOrderList = leaseSchemeOrderMapper.findAll(paramsMap);
        return leaseSchemeOrderList;
    }

    public List<LeaseSchemeOrder> findBySchemeId(List<Long> ids) {
        List<LeaseSchemeOrder> leaseSchemeOrderList=leaseSchemeOrderMapper.findBySchemeId(ids);

        return leaseSchemeOrderList;
    }


}
