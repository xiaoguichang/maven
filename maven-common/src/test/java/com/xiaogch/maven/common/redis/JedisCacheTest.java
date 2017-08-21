package com.xiaogch.maven.common.redis;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import static org.junit.Assert.assertNull;

public class JedisCacheTest {

    Logger logger = LoggerFactory.getLogger(getClass());

    private JedisCache jedisCache;

    @Before
    public void init() {

        jedisCache = new JedisCache();
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(100);
        poolConfig.setMinIdle(10);
        poolConfig.setMaxTotal(1000);
        poolConfig.setMaxWaitMillis(10000);
        JedisPool pool = new JedisPool(poolConfig , "127.0.0.1" , 6379);
        jedisCache.setPool(pool);
    }


//    @Test
    public void testGet() {
        try {
            assertNull("hello not set to redis" , jedisCache.get("hello"));
        } catch (Exception e) {
           logger.error("testGet exception" , e);
        }
    }

    @Test
    public void testSet() {

        try {
            jedisCache.set("hello" , "hello");
        } catch (Exception e) {
            logger.error("testGet exception" , e);
        }

    }

}