package com.hc.lease.baseInfo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.hc.lease.baseInfo.dao.LeaseDictMapper;
import com.hc.lease.baseInfo.model.LeaseDict;
import com.hc.lease.baseInfo.service.api.LeaseDictService;
import com.hc.lease.common.core.constant.RedisKey;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.redis.entity.DictRedisPo;
import com.ym.common.json.JsonUtils;
import com.ym.common.redis.template.ShardedJedisTemplate;
import org.joda.time.DateTime;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 字典表ServiceImpl
 *
 * @author Tong
 * @version 2017-04-14
 */
@Service("leaseDictService")
public class LeaseDictServiceImpl implements LeaseDictService, InitializingBean {

    @Value("${redis.seconds}")
    private String redisSeconds;//redis缓存时间

    @Autowired
    private LeaseDictMapper leaseDictMapper;

    @Resource
    private ShardedJedisTemplate shardedJedisTemplate;

    /**
     * 根据类型查询字典表数据
     *
     * @param type
     * @return
     */
    public List<LeaseDict> findByType(String type) {
        List<LeaseDict> leaseDictList = null;
        String result = shardedJedisTemplate.getAsList(RedisKey.DICT_REDIS_PREFIX + type);
        //redis缓存没有数据则查数据库
        if (result == null) {
            leaseDictList = leaseDictMapper.findByType(type);
            shardedJedisTemplate.setex(RedisKey.DICT_REDIS_PREFIX + type, JsonUtils.toJsonString(leaseDictList), Integer.parseInt(redisSeconds));
            return leaseDictList;
        }
        return JsonUtils.json2Object(result, List.class);
    }

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseDictMapper.deleteByPrimaryKey(id);
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
        int row = leaseDictMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseDict insert(LeaseDict record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseDictMapper.insert(record);
        return record;
    }

    public LeaseDict insertSelective(LeaseDict record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseDictMapper.insertSelective(record);
        return record;
    }

    public LeaseDict selectByPrimaryKey(Long id) throws GMException {
        LeaseDict leaseDict = leaseDictMapper.selectByPrimaryKey(id);
        return leaseDict;
    }

    public int updateByPrimaryKeySelective(LeaseDict record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseDictMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseDict record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseDictMapper.updateByPrimaryKey(record);
        return row;
    }

    public int insertList(List<LeaseDict> list) throws GMException {
        return 0;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseDict> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseDict> leaseDictList = leaseDictMapper.findPage(paramsMap);
        PageInfo<LeaseDict> page = new PageInfo<LeaseDict>(leaseDictList);
        return page;
    }

    public List<LeaseDict> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseDict> leaseDictList = leaseDictMapper.findAll(paramsMap);
        return leaseDictList;
    }

    /**
     * 导出车辆录入模板需要的数据
     *
     * @param type
     * @return
     * @throws GMException
     */
    @Override
    public List<String> findExportExcelModel(String type) throws GMException {
        List<String> leaseDictList = leaseDictMapper.findExportExcelModel(type);
        return leaseDictList;
    }

    /**
     * @param paramsMap
     * @return
     */
    @Override
    public List<LeaseDict> findByValueAndType(Map<String, Object> paramsMap) {
        List<LeaseDict> leaseDictList = leaseDictMapper.findByValueAndType(paramsMap);
        return leaseDictList;
    }

    @Override
    public List<LeaseDict> findAllValid() {
        return leaseDictMapper.findAllValid();
    }

    @Override
    public List<String> findAllValidType() {
        return leaseDictMapper.findAllValidType();
    }

    public int disableByPrimaryKey(Map<String, Object> paramsMap) {
        int row = leaseDictMapper.disableByPrimaryKey(paramsMap);
        return row;
    }

    public int updateDefaultSelected(Map<String, Object> paramsMap) {
        int row = leaseDictMapper.updateDefaultSelected(paramsMap);
        return row;
    }

    public void updateSort(LeaseDict leaseDict) {
        Map<String, Object> paramsMap = Maps.newHashMap();
        paramsMap.put("id", leaseDict.getId());
        paramsMap.put("mark", leaseDict.getMark());
        leaseDictMapper.updateSort(paramsMap);
    }

    public Integer findMaxNumber(String type) {
        Integer number = leaseDictMapper.findMaxNumber(type);
        return number;
    }

    @Override
    public void afterPropertiesSet() {
        List<LeaseDict> allValidList = this.findAllValid();
        List<String> allValidTypeList = this.findAllValidType();
        List<DictRedisPo> dictRedisPoList;
        String redisKey;
        for (String type : allValidTypeList) {
            dictRedisPoList = new ArrayList<>();
            redisKey = RedisKey.DICT_REDIS_PREFIX + type;
            //先清除以往所有字典数据缓存
            shardedJedisTemplate.del(redisKey);
            for (LeaseDict conciseDict : allValidList) {
                if (type.equals(conciseDict.getType())) {
                    dictRedisPoList.add(new DictRedisPo(conciseDict.getDataVersions() == 2 ? conciseDict.getLabel() : conciseDict.getId().toString(), conciseDict.getValue(), conciseDict.getType()));
                }
            }
            shardedJedisTemplate.set(redisKey, JsonUtils.toJsonString(dictRedisPoList));
        }
        Set<String> redisKeys = shardedJedisTemplate.hkeys("*");
        for (String key : redisKeys) {
            System.out.println("Rrdis Key : " + key);
        }
    }
}
