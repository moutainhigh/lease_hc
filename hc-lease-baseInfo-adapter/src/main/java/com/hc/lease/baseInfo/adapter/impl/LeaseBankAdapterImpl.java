package com.hc.lease.baseInfo.adapter.impl;

import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.adapter.api.LeaseBankAdapter;
import com.hc.lease.baseInfo.model.LeaseBank;
import com.hc.lease.baseInfo.service.api.LeaseBankService;
import com.hc.lease.common.core.constant.RedisKey;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.exception.ResultHashMap;
import com.ym.common.json.JsonUtils;
import com.ym.common.redis.template.ShardedJedisTemplate;
import hc.lease.common.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 银行AdapterImpl
 *
 * @author Tong
 * @version 2017-04-17
 */
@Service("leaseBankAdapter")
public class LeaseBankAdapterImpl implements LeaseBankAdapter {

    @Value("${redis.seconds}")
    private String redisSeconds;//redis缓存时间

    @Autowired
    private LeaseBankService leaseBankService;

    @Resource
    ShardedJedisTemplate shardedJedisTemplate;

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public Map<String, Object> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        return null;
    }

    public List<LeaseBank> findAllNoType(Object o) {
        List<LeaseBank> leaseBankList=leaseBankService.findAllNoType(o);
        return leaseBankList;
    }

    public List<String> findAllBankName() {
        List<String> bankList= leaseBankService.findAllBankName();

        return bankList;
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseBankService.deleteByPrimaryKey(id);
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
        int row = leaseBankService.deleteBatchById(ids);
        return row;
    }

    public ResultHashMap insert(LeaseBank record) throws GMException {
        record = leaseBankService.insert(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public ResultHashMap insertSelective(LeaseBank record) throws GMException {
        record = leaseBankService.insertSelective(record);

        Object object = ListUtil.objectIsNullToMap(null);
        ResultHashMap resultHashMap = new ResultHashMap(false, object, GMExceptionConstant.SUCCESS_INSERT);
        return resultHashMap;
    }

    public LeaseBank selectByPrimaryKey(Long id) throws GMException {
        LeaseBank leaseBank = leaseBankService.selectByPrimaryKey(id);
        return leaseBank;
    }

    public int updateByPrimaryKeySelective(LeaseBank record) throws GMException {
        int row = leaseBankService.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseBank record) throws GMException {
        int row = leaseBankService.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseBank> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseBank> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageInfo<LeaseBank> page = leaseBankService.findPage(pageNum, pageSize, paramsMap);
        return page;
    }

    /**
     * @param paramsMap
     * @return
     * @throws GMException
     */
    public List<LeaseBank> findAll(Map<String, Object> paramsMap) throws GMException {
        //List<LeaseBank> leaseBankList = leaseBankService.findAll(paramsMap);
        List<LeaseBank> leaseBankList = null;
        String result = shardedJedisTemplate.getAsList(RedisKey.LEASE_BANK);
        //redis缓存没有数据则查数据库
        if (result == null) {
            leaseBankList = leaseBankService.findAll(paramsMap);
            shardedJedisTemplate.setex(RedisKey.LEASE_BANK, JsonUtils.toJsonString(leaseBankList), Integer.parseInt(redisSeconds));
            return leaseBankList;
        }
        return JsonUtils.json2Object(result, List.class);
    }

}
