package com.hc.lease.order.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.adapter.api.LeaseContractBaseinfoAdapter;
import com.hc.lease.baseInfo.model.LeaseBranchCompany;
import com.hc.lease.baseInfo.model.LeaseContractBaseinfo;
import com.hc.lease.baseInfo.model.LeaseRule;
import com.hc.lease.baseInfo.service.api.LeaseBankService;
import com.hc.lease.baseInfo.service.api.LeaseBranchCompanyService;
import com.hc.lease.baseInfo.service.api.LeaseCommonService;
import com.hc.lease.baseInfo.service.api.LeaseContractBaseinfoService;
import com.hc.lease.baseInfo.service.api.LeaseRuleService;
import com.hc.lease.baseInfo.service.api.LeaseUseUsedService;
import com.hc.lease.common.core.constant.RuleType;
import com.hc.lease.common.core.constant.UseType;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.hc.lease.order.adapter.api.LeaseContractBaseinfoUseAdapter;
import com.hc.lease.order.model.LeaseContractBaseinfoUse;
import com.hc.lease.order.service.api.LeaseContractBaseinfoUseService;
import com.ym.common.redis.template.ShardedJedisTemplate;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 融租合同基础数据AdapterImpl
 *
 * @author Tong
 * @version 2017-04-17
 */
@Service("leaseContractBaseinfoUseAdapter")
public class LeaseContractBaseinfoUseAdapterImpl implements LeaseContractBaseinfoUseAdapter {

    @Value("${redis.seconds}")
    private String redisSeconds;//redis缓存时间

    @Autowired
    private LeaseContractBaseinfoUseService leaseContractBaseinfoUseService;

    @Autowired
    private LeaseRuleService leaseRuleService;

    @Autowired
    private LeaseBranchCompanyService leaseBranchCompanyService;

    @Autowired
    private LeaseCommonService leaseCommonService;
    @Autowired
    private LeaseUseUsedService leaseUseUsedService;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        Map<String, Object> map = Maps.newHashMap();
        List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyService.findAll(paramsMap);
        map.put("leaseBranchCompanyList", leaseBranchCompanyList);
        paramsMap = Maps.newHashMap();
        paramsMap.put("ruleType", RuleType.TYPE_DEFAULTINTEREST);
        List<LeaseRule> leaseRuleList = leaseRuleService.findAll(paramsMap);
        map.put("leaseRuleList", leaseRuleList);

        return map;
    }

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
        List<LeaseContractBaseinfoUse> leaseContractBaseinfoList = leaseContractBaseinfoUseService.findByName(params);
        if (leaseContractBaseinfoList != null) {
            if (leaseContractBaseinfoList.size() > 0) {
                item = true;
            } else {
                item = false;
            }
        } else {
            item = false;
        }
        return item;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseContractBaseinfoUseService.deleteByPrimaryKey(id);
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
        int row = leaseContractBaseinfoUseService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseContractBaseinfoUse record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseContractBaseinfoUseService.insert(record);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), null, record.getBranchCompanyId(), null, UseType.TYPE_LEASE_CONTRACT_BASEINFO, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    /**
     * @param record
     * @return
     * @throws GMException
     */
    public ResultHashMap insertSelective(LeaseContractBaseinfoUse record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record=leaseContractBaseinfoUseService.insertSelective(record);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), null, record.getBranchCompanyId(), null, UseType.TYPE_LEASE_CONTRACT_BASEINFO, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public LeaseContractBaseinfoUse selectByPrimaryKey(Long id) throws GMException {
        LeaseContractBaseinfoUse leaseContractBaseinfo = leaseContractBaseinfoUseService.selectByPrimaryKey(id);
        return leaseContractBaseinfo;
    }

    public int updateByPrimaryKeySelective(LeaseContractBaseinfoUse record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseContractBaseinfoUseService.updateByPrimaryKeySelective(record);
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_CONTRACT_BASEINFO);
        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), null, record.getBranchCompanyId(), null, UseType.TYPE_LEASE_CONTRACT_BASEINFO, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        return row;
    }

    public int updateByPrimaryKey(LeaseContractBaseinfoUse record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseContractBaseinfoUseService.updateByPrimaryKey(record);
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_CONTRACT_BASEINFO);
        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), null, record.getBranchCompanyId(), null, UseType.TYPE_LEASE_CONTRACT_BASEINFO, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        return row;
    }

    public int insertList(List<LeaseContractBaseinfoUse> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseContractBaseinfoUse> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseContractBaseinfoUse> page = leaseContractBaseinfoUseService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseContractBaseinfoUse> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractBaseinfoUse> leaseContractBaseinfoList = leaseContractBaseinfoUseService.findAll(paramsMap);
        return leaseContractBaseinfoList;
    }
}
