package com.hc.lease.baseInfo.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.adapter.api.LeaseContractBaseinfoAdapter;
import com.hc.lease.baseInfo.model.LeaseBranchCompany;
import com.hc.lease.baseInfo.model.LeaseContractBaseinfo;
import com.hc.lease.baseInfo.model.LeaseRule;
import com.hc.lease.baseInfo.service.api.*;
import com.hc.lease.common.core.constant.RuleType;
import com.hc.lease.common.core.constant.UseType;
import com.hc.lease.common.core.constant.UsedType;
import com.hc.lease.common.core.constant.UserSession;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
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
@Service("leaseContractBaseinfoAdapter")
public class LeaseContractBaseinfoAdapterImpl implements LeaseContractBaseinfoAdapter {

    @Value("${redis.seconds}")
    private String redisSeconds;//redis缓存时间

    @Autowired
    private LeaseContractBaseinfoService leaseContractBaseinfoService;

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

        /*
        //List<LeaseBank> leaseBankList = leaseBankService.findAll(null);
        List<LeaseBank> leaseBankList = null;
        String result = shardedJedisTemplate.getAsList(RedisKey.LEASE_BANK);
        //redis缓存没有数据则查数据库
        if (result == null) {
            leaseBankList = leaseBankService.findAll(null);
            shardedJedisTemplate.setex(RedisKey.LEASE_BANK, JsonUtils.toJsonString(leaseBankList), Integer.parseInt(redisSeconds));
        } else {
            leaseBankList = JsonUtils.json2Object(result, List.class);
        }
        map.put("leaseBankList", leaseBankList);
        */

        List<LeaseBranchCompany> leaseBranchCompanyList = leaseBranchCompanyService.findAll(paramsMap);
        map.put("leaseBranchCompanyList", leaseBranchCompanyList);
        paramsMap = Maps.newHashMap();
        paramsMap.put("ruleType", RuleType.TYPE_DEFAULTINTEREST);
        List<LeaseRule> leaseRuleList = leaseRuleService.findAll(paramsMap);
        map.put("leaseRuleList", leaseRuleList);

        return map;
    }


    public ResultHashMap insertSelective(LeaseContractBaseinfo record, UserSession userSession) throws GMException {
        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }
        record.setCreateBy(userSession.getUserId());
        record.setUpdateBy(userSession.getUserId());
        record = leaseContractBaseinfoService.insertSelective(record);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), null, record.getBranchCompanyId(), null, UseType.TYPE_LEASE_CONTRACT_BASEINFO, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }


    public int updateByPrimaryKeySelective(LeaseContractBaseinfo record, UserSession userSession) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }
        record.setUpdateBy(userSession.getUserId());
        int row = leaseContractBaseinfoService.updateByPrimaryKeySelective(record);
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_CONTRACT_BASEINFO);
        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), null, record.getBranchCompanyId(), null, UseType.TYPE_LEASE_CONTRACT_BASEINFO, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        return row;
    }

    public int disableByPrimaryKey(Map<String, Object> params) throws GMException {
        int row = leaseContractBaseinfoService.disableByPrimaryKey(params);
        return row;
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
        List<LeaseContractBaseinfo> leaseContractBaseinfoList = leaseContractBaseinfoService.findByName(params);
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
        int row = leaseContractBaseinfoService.deleteByPrimaryKey(id);
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
        int row = leaseContractBaseinfoService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseContractBaseinfo record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseContractBaseinfoService.insert(record);

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
    public ResultHashMap insertSelective(LeaseContractBaseinfo record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        record = leaseContractBaseinfoService.insertSelective(record);

        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), null, record.getBranchCompanyId(), null, UseType.TYPE_LEASE_CONTRACT_BASEINFO, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public LeaseContractBaseinfo selectByPrimaryKey(Long id) throws GMException {
        LeaseContractBaseinfo leaseContractBaseinfo = leaseContractBaseinfoService.selectByPrimaryKey(id);
        return leaseContractBaseinfo;
    }

    public int updateByPrimaryKeySelective(LeaseContractBaseinfo record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseContractBaseinfoService.updateByPrimaryKeySelective(record);
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_CONTRACT_BASEINFO);
        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), null, record.getBranchCompanyId(), null, UseType.TYPE_LEASE_CONTRACT_BASEINFO, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        return row;
    }

    public int updateByPrimaryKey(LeaseContractBaseinfo record) throws GMException {

        boolean isExist = checkByNameIsExist(record.getName(), record.getId());
        if (isExist) {
            Map backMap = Maps.newHashMap();
            backMap.put("key", "name");
            throw new GMException(GMExceptionConstant.NAME_REPEAT, backMap);
        }

        int row = leaseContractBaseinfoService.updateByPrimaryKey(record);
        leaseUseUsedService.deleteByUse(record.getId(), UseType.TYPE_LEASE_CONTRACT_BASEINFO);
        //插入使用和被使用的数据
        leaseCommonService.insertUseUsed(record.getId(), null, record.getBranchCompanyId(), null, UseType.TYPE_LEASE_CONTRACT_BASEINFO, UsedType.TYPE_LEASE_BRANCH_COMPANY);

        return row;
    }

    public int insertList(List<LeaseContractBaseinfo> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseContractBaseinfo> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseContractBaseinfo> page = leaseContractBaseinfoService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    public List<LeaseContractBaseinfo> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseContractBaseinfo> leaseContractBaseinfoList = leaseContractBaseinfoService.findAll(paramsMap);
        return leaseContractBaseinfoList;
    }
}
