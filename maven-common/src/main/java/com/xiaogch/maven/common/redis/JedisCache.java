package com.xiaogch.maven.common.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisCache {

    Logger logger = LoggerFactory.getLogger(getClass());

    private JedisPool pool;

    public String get(String key) throws Exception {

        Jedis jedis = pool.getResource();
        try {
            return jedis.get(key);
        } catch (Exception e) {
            logger.error("get from redis exception" , e);
            throw e;
        } finally {
            pool.returnResource(jedis);
        }
    }

    public boolean set(String key , String value) throws Exception{
        Jedis jedis = pool.getResource();
        try {
            String statusCode = jedis.set(key , value);
            logger.info("set value to redis result is {}" , statusCode);
            return false;
        } catch (Exception e) {
            logger.error("set value to redis exception" , e);
            throw e;
        } finally {
            pool.returnResource(jedis);
        }
    }

    public JedisPool getPool() {
        return pool;
    }


    public void setPool(JedisPool pool) {
        this.pool = pool;
    }
}
