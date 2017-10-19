package com.xiaogch.maven.common.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/9/27 10:38 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
@Service("jedisService")
public class JedisService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JedisPool jedisPool;

    public JedisService() {

    }

    public JedisService(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public JedisPool getPool() {
        return jedisPool;
    }

    public void setPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }


    /**
     * 删除key
     * @param keys 要删除的keys
     * @return 返回删除的个数
     * @throws RedisException
     */
    public long del(String...keys) throws RedisException {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
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
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
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
            logger.error("return jedis to jedisjedisPool exception" , e);
        }
    }

}
