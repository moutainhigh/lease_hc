package com.hc.lease.baseInfo.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.lease.baseInfo.dao.LeaseAreaMapper;
import com.hc.lease.baseInfo.model.LeaseArea;
import com.hc.lease.baseInfo.service.LeaseAreaService;
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
 * 地区ServiceImpl
 *
 * @author Tong
 * @version 2017-04-26
 */
@Service("leaseAreaService")
public class LeaseAreaServiceImpl implements LeaseAreaService {

    @Value("${redis.seconds}")
    private String redisSeconds;//redis缓存时间

    @Autowired
    private LeaseAreaMapper leaseAreaMapper;

    @Resource
    ShardedJedisTemplate shardedJedisTemplate;

    public int deleteByPrimaryKey(Long id) throws GMException {
        int row = leaseAreaMapper.deleteByPrimaryKey(id);
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
        int row = leaseAreaMapper.deleteBatchById(ids);
        return row;
    }

    public LeaseArea insert(LeaseArea record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseAreaMapper.insert(record);
        return record;
    }

    public LeaseArea insertSelective(LeaseArea record) throws GMException {
        record.setCreateTime(DateTime.now().toDate());
        record.setUpdateTime(DateTime.now().toDate());
        record.setIsEnable(record.getIsEnable() == null ? true : record.getIsEnable());
        int row = leaseAreaMapper.insertSelective(record);
        return record;
    }

    public int insertList(List<LeaseArea> record) throws GMException {
        int row = leaseAreaMapper.insertList(record);
        return row;
    }

    public int updateByPrimaryKeySelective(LeaseArea record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseAreaMapper.updateByPrimaryKeySelective(record);
        return row;
    }

    public int updateByPrimaryKey(LeaseArea record) throws GMException {
        record.setUpdateTime(DateTime.now().toDate());
        int row = leaseAreaMapper.updateByPrimaryKey(record);
        return row;
    }

    public LeaseArea selectByPrimaryKey(Long id) throws GMException {
        LeaseArea leaseArea = leaseAreaMapper.selectByPrimaryKey(id);
        return leaseArea;
    }

    /**
     * 分页
     *
     * @return
     */
    public PageInfo<LeaseArea> findPage(int pageNum, int pageSize, Map<String, Object> paramsMap) throws GMException {
        PageHelper.startPage(pageNum, pageSize);
        List<LeaseArea> leaseAreaList = leaseAreaMapper.findPage(paramsMap);
        PageInfo<LeaseArea> page = new PageInfo<LeaseArea>(leaseAreaList);
        return page;
    }

    public List<LeaseArea> findAll(Map<String, Object> paramsMap) throws GMException {
        List<LeaseArea> leaseAreaList = null;
        String result = shardedJedisTemplate.getAsList(RedisKey.LEASE_AREA_FINDALL);
        //redis缓存没有数据则查数据库
        if (result == null) {
            leaseAreaList = leaseAreaMapper.findAll(paramsMap);
            shardedJedisTemplate.setex(RedisKey.LEASE_AREA_FINDALL, JsonUtils.toJsonString(leaseAreaList), Integer.parseInt(redisSeconds));
            return leaseAreaList;
        }
        return JsonUtils.json2Object(result, List.class);
    }

    public List<LeaseArea> findAreaByEnableAndModel(Map<String, Object> paramsMap) throws GMException {
        List<LeaseArea> leaseAreaList = null;
        String result = shardedJedisTemplate.getAsList(RedisKey.LEASE_AREA_FINDAREABYENABLEANDMODEL);
        //redis缓存没有数据则查数据库
        if (result == null) {
            leaseAreaList = leaseAreaMapper.findAreaByEnableAndModel(paramsMap);
            shardedJedisTemplate.setex(RedisKey.LEASE_AREA_FINDAREABYENABLEANDMODEL, JsonUtils.toJsonString(leaseAreaList), Integer.parseInt(redisSeconds));
            return leaseAreaList;
        }
        return JsonUtils.json2Object(result, List.class);
    }

    /**
     * 添加或者修改 需要的初始化参数
     *
     * @param paramsMap
     * @return
     */
    public List<LeaseArea> insertViewParames(Map<String, Object> paramsMap) throws GMException {
        List<LeaseArea> list = leaseAreaMapper.insertViewParames(paramsMap);
        return list;
    }

}
