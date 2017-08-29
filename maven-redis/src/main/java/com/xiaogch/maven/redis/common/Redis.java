package com.xiaogch.maven.redis.common;


import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;

public class Redis {

    JedisPool pool;

    public RedisSet getRedisSet(String key) {
        return new RedisSet();
    }

    public RedisSet getRedisSet() {
        return new RedisSet();
    }

}


