package com.hc.lease.common.core.redis.entity;

import lombok.Data;

/**
 * Redis 字典对象
 * Created by LJ on 2018/3/1
 */
@Data
public class DictRedisPo {

    private String id;

    private String value;

    private String type;

    public DictRedisPo(String id, String value, String type) {
        this.id = id;
        this.value = value;
        this.type = type;
    }

    public DictRedisPo() {
    }
}
