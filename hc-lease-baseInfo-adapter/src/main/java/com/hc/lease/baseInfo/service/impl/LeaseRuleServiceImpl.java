package com.hc.lease.baseInfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.dao.LeaseRuleMapper;
import com.hc.lease.baseInfo.model.LeaseRule;
import com.hc.lease.baseInfo.service.api.LeaseRuleService;
import com.hc.lease.common.core.constant.RedisKey;
import com.hc.lease.common.core.exception.GMException;
import com.ym.common.json.JsonUtils;
import com.ym.common.redis.template.ShardedJedisTemplate;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 规则表ServiceImpl
 *
 * @author Tong
 * @version 2017-04-19
 */
@Service("leaseRuleService")
public class LeaseRuleServiceImpl implements LeaseRuleService {

    @Value("${redis.seconds}")
    private String redisSeconds;//redis缓存时间

    @Autowired
    private LeaseRuleMapper leaseRuleMapper;

    @Resource
    private ShardedJedisTemplate shardedJedisTemplate;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseRuleMapper.deleteByPrimaryKey(id);
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
        int row = leaseRuleMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseRule insert(LeaseRule record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseRuleMapper.insert(record);
        return record;
    }

    public LeaseRule insertSelective(LeaseRule record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseRuleMapper.insertSelective(record);
        return record;
    }

    public LeaseRule selectByPrimaryKey(Long id) throws GMException {
        LeaseRule leaseRule = leaseRuleMapper.selectByPrimaryKey(id);
        return leaseRule;
    }

    public int updateByPrimaryKeySelective(LeaseRule record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseRuleMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseRule record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseRuleMapper.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseRule> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseRule> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseRule> leaseRuleList = leaseRuleMapper.findPage(paramsMap);
        PageInfo<LeaseRule> page = new PageInfo<LeaseRule>(leaseRuleList);
        return page;
    }

    public List<LeaseRule> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseRule> leaseRuleList = null;
        String result = shardedJedisTemplate.getAsList(RedisKey.RULE_REDIS_PREFIX);
        //redis缓存没有数据则查数据库
        if (result == null) {
            leaseRuleList = leaseRuleMapper.findAll(paramsMap);
            shardedJedisTemplate.setex(RedisKey.RULE_REDIS_PREFIX, JsonUtils.toJsonString(leaseRuleList), Integer.parseInt(redisSeconds));
            return leaseRuleList;
        }
        return JsonUtils.json2Object(result, List.class);
    }

    @Override
    public LeaseRule selectEntityByType(String ruleType) {
        return leaseRuleMapper.selectEntityByType(ruleType);
    }
}
