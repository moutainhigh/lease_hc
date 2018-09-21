package com.hc.lease.baseInfo.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.adapter.api.LeaseDealerAdapter;
import com.hc.lease.baseInfo.model.LeaseArea;
import com.hc.lease.baseInfo.model.LeaseBranchCompany;
import com.hc.lease.baseInfo.model.LeaseDealer;
import com.hc.lease.baseInfo.model.LeaseUseUsed;
import com.hc.lease.baseInfo.service.api.*;
import com.hc.lease.common.core.constant.UseType;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 经销商AdapterImpl
 *
 * @author Tong
 * @version 2017-04-17
 */
@Service("leaseDealerAdapter")
public class LeaseDealerAdapterImpl implements LeaseDealerAdapter {

    @Autowired
    private LeaseDealerService leaseDealerService;

    @Autowired
    private LeaseAreaService leaseAreaService;

    @Autowired
    private LeaseBranchCompanyService leaseBranchCompanyService;

    @Autowired
    private LeaseCommonService leaseCommonService;
    @Autowired
    private LeaseUseUsedService leaseUseUsedService;

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
        List<LeaseDealer> leaseDealerList = leaseDealerService.findByName(params);
        if (leaseDealerList != null) {
            if (leaseDealerList.size() > 0) {
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
     * 检测数据是否被使用
     *
     * @param id
     * @return
     * @throws GMException
     */
    public Map<String, Object> checkByModelIdIsExist(Long id) throws GMException {
        List exceptionMessageList = new ArrayList();
        Map<String, Object> backMap = Maps.newHashMap();
        boolean item = false;
        List<Long> ids = new ArrayList<Long>();
        ids.add(id);

        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("usedId", id);
        paramsMap.put("usedType", UsedType.TYPE_LEASE_DEALER);
        List<LeaseUseUsed> leaseUseUsedList = leaseCommonService.selectByUsed(paramsMap);

        if (leaseUseUsedList != null) {
            if (leaseUseUsedList.size() > 0) {
                item = true;
                LeaseDealer leaseDealer = leaseDealerService.selectByPrimaryKey(id);
                Map<String, Object> exceptionMessageMap = Maps.newHashMap();
                exceptionMessageMap = new HashMap<String, Object>();
                exceptionMessageMap.put("message", leaseDealer.getName());
                exceptionMessageList.add(exceptionMessageMap);
            } else {
                item = false;
            }
        } else {
            item = false;
        }
        backMap.put("isExist", item);
        backMap.put("exceptionMessageList", exceptionMessageList);
        return backMap;
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        Map<String, Object> map = Maps.newHashMap();

        List<LeaseDealer> leaseDealerList = leaseDealerService.insertViewParames(paramsMap);
        map.put("leaseDealerList", leaseDealerList);
        List<LeaseArea> leaseAreaList = leaseAreaService.findAreaByEnableAndModel(null);//地区
        map.put("leaseAreaList", leaseAreaList);
        List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyService.findAll(paramsMap);
        map.put("leaseBranchCompanyList", leaseBranchCompanyList);

        return map;
    }


    public ResultHashMap insertSelective(LeaseDealer record, UserSession userSession) throws GMException {
        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record.setCreateBy(userSession.getUserId());
        record.setUpdateBy(userSession.getUserId());
        record = leaseDealerService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getGrade() == 2 ? record.getId() : record.getParentId(), record.getGrade() == 2 ? record.getName() : record.getParentName(), record.getGrade() == 2 ? record.getParentId() : record.getId(), record.getGrade() == 2 ? record.getParentName() : record.getName(), record.getGrade() == 2 ? UseType.TYPE_LEASE_DEALER_TWO : UsedType.TYPE_LEASE_DEALER, record.getGrade() == 2 ? UseType.TYPE_LEASE_DEALER : UsedType.TYPE_LEASE_DEALER_TWO);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBranchCompanyId(), record.getBranchCompanyName(), UseType.TYPE_LEASE_DEALER, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }


    public int updateByPrimaryKeySelective(LeaseDealer record, UserSession userSession) throws GMException {
        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record.setUpdateBy(userSession.getUserId());

        int row = leaseDealerService.updateByPrimaryKeySelective(record);
        leaseUseUsedService.deleteByUse(record.getGrade() == 2 ? record.getId() : record.getParentId(), record.getGrade() == 2 ? UseType.TYPE_LEASE_DEALER_TWO : UseType.TYPE_LEASE_DEALER);
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_DEALER);
        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getGrade() == 2 ? record.getId() : record.getParentId(), record.getGrade() == 2 ? record.getName() : record.getParentName(), record.getGrade() == 2 ? record.getParentId() : record.getId(), record.getGrade() == 2 ? record.getParentName() : record.getName(), record.getGrade() == 2 ? UseType.TYPE_LEASE_DEALER_TWO : UsedType.TYPE_LEASE_DEALER, record.getGrade() == 2 ? UseType.TYPE_LEASE_DEALER : UsedType.TYPE_LEASE_DEALER_TWO);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBranchCompanyId(), record.getBranchCompanyName(), UseType.TYPE_LEASE_DEALER, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        return row;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {
        int row = leaseDealerService.disableByPrimaryKey(params);
        return row;
    }

    /**
     * 根据ID删除记录
     *
     * @param id .
     * @return
     * @throws GMException
     */
    public int deleteByPrimaryKey(Long id) throws GMException {
        Map<String, Object> isExist = checkByModelIdIsExist(id);
        if (isExist.get("isExist").equals(true) || isExist.get("isExist").equals("true")) {
            throw new GMException(GMExceptionConstant.GUOCE_DELETE_ERROR, isExist.get("exceptionMessageList"));
        }
        int row = leaseDealerService.deleteByPrimaryKey(id);
        leaseCommonService.delUseUsed(id, null, UsedType.TYPE_LEASE_DEALER_TWO, null);//删除使用者数据
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
        int row = leaseDealerService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseDealer record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseDealerService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getGrade() == 2 ? record.getId() : record.getParentId(), record.getGrade() == 2 ? record.getName() : record.getParentName(), record.getGrade() == 2 ? record.getParentId() : record.getId(), record.getGrade() == 2 ? record.getParentName() : record.getName(), record.getGrade() == 2 ? UseType.TYPE_LEASE_DEALER_TWO : UsedType.TYPE_LEASE_DEALER, record.getGrade() == 2 ? UseType.TYPE_LEASE_DEALER : UsedType.TYPE_LEASE_DEALER_TWO);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBranchCompanyId(), record.getBranchCompanyName(), UseType.TYPE_LEASE_DEALER, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseDealer record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseDealerService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getGrade() == 2 ? record.getId() : record.getParentId(), record.getGrade() == 2 ? record.getName() : record.getParentName(), record.getGrade() == 2 ? record.getParentId() : record.getId(), record.getGrade() == 2 ? record.getParentName() : record.getName(), record.getGrade() == 2 ? UseType.TYPE_LEASE_DEALER_TWO : UsedType.TYPE_LEASE_DEALER, record.getGrade() == 2 ? UseType.TYPE_LEASE_DEALER : UsedType.TYPE_LEASE_DEALER_TWO);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBranchCompanyId(), record.getBranchCompanyName(), UseType.TYPE_LEASE_DEALER, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public LeaseDealer selectByPrimaryKey(Long id) throws GMException {
        LeaseDealer leaseDealer = leaseDealerService.selectByPrimaryKey(id);
        return leaseDealer;
    }

    public int updateByPrimaryKeySelective(LeaseDealer record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseDealerService.updateByPrimaryKeySelective(record);
        leaseUseUsedService.deleteByUse(record.getGrade() == 2 ? record.getId() : record.getParentId(), record.getGrade() == 2 ? UseType.TYPE_LEASE_DEALER_TWO : UseType.TYPE_LEASE_DEALER);
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_DEALER);
        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getGrade() == 2 ? record.getId() : record.getParentId(), record.getGrade() == 2 ? record.getName() : record.getParentName(), record.getGrade() == 2 ? record.getParentId() : record.getId(), record.getGrade() == 2 ? record.getParentName() : record.getName(), record.getGrade() == 2 ? UseType.TYPE_LEASE_DEALER_TWO : UsedType.TYPE_LEASE_DEALER, record.getGrade() == 2 ? UseType.TYPE_LEASE_DEALER : UsedType.TYPE_LEASE_DEALER_TWO);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBranchCompanyId(), record.getBranchCompanyName(), UseType.TYPE_LEASE_DEALER, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        return row;
    }

    public int updateByPrimaryKey(LeaseDealer record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseDealerService.updateByPrimaryKey(record);
        leaseUseUsedService.deleteByUse(record.getGrade() == 2 ? record.getId() : record.getParentId(), record.getGrade() == 2 ? UseType.TYPE_LEASE_DEALER_TWO : UseType.TYPE_LEASE_DEALER);
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_DEALER);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getGrade() == 2 ? record.getId() : record.getParentId(), record.getGrade() == 2 ? record.getName() : record.getParentName(), record.getGrade() == 2 ? record.getParentId() : record.getId(), record.getGrade() == 2 ? record.getParentName() : record.getName(), record.getGrade() == 2 ? UseType.TYPE_LEASE_DEALER_TWO : UsedType.TYPE_LEASE_DEALER, record.getGrade() == 2 ? UseType.TYPE_LEASE_DEALER : UsedType.TYPE_LEASE_DEALER_TWO);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), record.getName(), record.getBranchCompanyId(), record.getBranchCompanyName(), UseType.TYPE_LEASE_DEALER, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        return row;
    }

    public int insertList(List<LeaseDealer> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseDealer> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseDealer> page = leaseDealerService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseDealer> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseDealer> leaseDealerList = leaseDealerService.findAll(paramsMap);
        return leaseDealerList;
    }

}
