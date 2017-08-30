package com.xiaogch.maven.common.redis;

import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisCache {

    Logger logger = LoggerFactory.getLogger(getClass());

    private JedisPool pool;

    public JedisCache() {

    }

    public JedisCache(JedisPool pool) {
        this.pool = pool;
    }

    public JedisPool getPool() {
        return pool;
    }

    public void setPool(JedisPool pool) {
        this.pool = pool;
    }


    /**
     * 删除key
     * @param keys 要删除的keys
     * @return 返回删除的个数
     * @throws RedisException
     */
    public long del(String...keys) throws RedisException {
        Jedis jedis = pool.getResource();
        try {
            return jedis.del(keys);
        } catch (Exception e) {
            throw new RedisException("redis del key excpetion" , e);
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 为某个key设置过期时间
     * @param key
     * @param seconds 过期时间，单位秒
     * @return 设置成功返回true ，失败返回false
     * @throws RedisException
     */
    public boolean expire(String key , int seconds) throws RedisException {
        Jedis jedis = pool.getResource();
        try {
            long result = jedis.expire(key , seconds);
            return result == 1;
        } catch (Exception e) {
            throw new RedisException("redis del key excpetion" , e);
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 将Jedis实例返还JedisPool
     * @param jedis
     */
    public void returnResource(Jedis jedis) {
        try {
            if (jedis != null) {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error("return jedis to jedispool exception" , e);
        }
    }
}
