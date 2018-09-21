package com.hc.lease.common.core.redis.util;

import com.hc.lease.common.core.constant.RedisKey;
import com.hc.lease.common.core.exception.GMException;
import com.hc.lease.common.core.exception.GMExceptionConstant;
import com.hc.lease.common.core.redis.entity.DictRedisPo;
import com.ym.common.json.JsonUtils;
import com.ym.common.redis.template.ShardedJedisTemplate;
import hc.lease.common.util.JsonUtil;
import hc.lease.common.util.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Redis 缓存工具类
 * Created by LJ on 2018/3/2
 */
public class RedisDataUtil {

    public static String getRedisStrByKey(String key) throws GMException {
        ShardedJedisTemplate shardedJedisTemplate = SpringContextHolder.getBean(ShardedJedisTemplate.class);
        String jsonString = shardedJedisTemplate.get(key);
        if (StringUtils.isEmpty(jsonString)) {
            throw new GMException(GMExceptionConstant.REDIS_CACHE_NOT_EXIST);
        }
        return jsonString;
    }

    public static <T> T getRedisStrToObjByKey(String key, T t) throws GMException {
        return (T) JsonUtils.json2Object(getRedisStrByKey(key), t.getClass());
    }

    public static <T> List<T> getRedisStrToListByKey(String key, Class t) throws GMException {
        return JsonUtil.constructParametricType(getRedisStrByKey(key), t);
    }

    /**
     * 根据字典Type与字典ID,查询redis缓存中字典Value
     *
     * @param dictType 字典类型
     * @param dictId   字典ID
     * @return 字典Value
     */
    public static String getRedisDictValueByDictTypeAndDictId(String dictType, Object dictId) throws GMException {
        List<DictRedisPo> dictRedisPoList = getRedisStrToListByKey(RedisKey.DICT_REDIS_PREFIX + dictType, DictRedisPo.class);
        for (DictRedisPo dictRedisPo : dictRedisPoList) {
            if (dictRedisPo.getId().equals(dictId)) {
                return dictRedisPo.getValue();
            }
        }
        return null;
    }

    /**
     * 根据字典Type与字典Value,查询redis缓存中字典Id
     *
     * @param dictType  字典类型
     * @param dictValue 字典ID
     * @return 字典ID
     */
    public static String getRedisDictIdByDictTypeAndDictValue(String dictType, String dictValue) throws GMException {
        List<DictRedisPo> dictRedisPoList = getRedisStrToListByKey(RedisKey.DICT_REDIS_PREFIX + dictType, DictRedisPo.class);
        for (DictRedisPo dictRedisPo : dictRedisPoList) {
            if (dictRedisPo.getValue().equals(dictValue)) {
                return dictRedisPo.getId();
            }
        }
        return null;
    }

    public static List<String> getRedisDictValuesByDictType(String dictType) throws GMException {
        List<DictRedisPo> dictRedisPoList = getRedisStrToListByKey(RedisKey.DICT_REDIS_PREFIX + dictType, DictRedisPo.class);
        List<String> values = new ArrayList<>(dictRedisPoList.size());
        for (DictRedisPo dictRedisPo : dictRedisPoList) {
            values.add(dictRedisPo.getValue());
        }
        return values;
    }

}
