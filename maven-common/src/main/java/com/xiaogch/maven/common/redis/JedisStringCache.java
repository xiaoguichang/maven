package com.xiaogch.maven.common.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * ProjectName: maven <BR>
 * File name: com.xiaogch.maven.common.redis <BR>
 * Author: guich <BR>
 * Project: maven <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/8/30 19:15 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class JedisStringCache extends JedisCache {

    private final String STATUS_CODE_OK = "OK";
    private JedisPool jedisPool;
    private String key ;

    public JedisStringCache(JedisPool jedisPool) {
        this(jedisPool , "string.default");
    }

    public JedisStringCache(JedisPool jedisPool, String key) {
        this.jedisPool = jedisPool;
        this.key = key;
    }

    public String get() throws RedisException {
        return this.get(key);
    }

    public String get(String key) throws RedisException {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.get(key);
        } catch (Exception e) {
            throw new RedisException("get string key from redis exception" , e);
        } finally {
            returnResource(jedis);
        }
    }

    public boolean set(String value) throws RedisException {
        return this.set(key , value);
    }

    public boolean set(String key , String value) throws RedisException {
        Jedis jedis = jedisPool.getResource();
        try {
            String setResult = jedis.set(key , value);
            return STATUS_CODE_OK.equalsIgnoreCase(setResult);
        } catch (Exception e) {
            throw new RedisException("get string key from redis exception" , e);
        } finally {
            returnResource(jedis);
        }
    }


    /***
     * 获取redis分布式锁
     * @param lockTime 锁持续时间（毫秒）
     * @param timeOut 超时时间（毫秒）
     * @return true：获得锁，false：未获得锁
     * @throws RedisException
     */
    public boolean getLock(int lockTime , long timeOut) throws RedisException {
        return getLock(key , lockTime , timeOut);
    }


    /***
     * 获取redis分布式锁
     * @param lockName 锁名称
     * @param lockTime 锁持续时间（毫秒）
     * @param timeOut 超时时间（毫秒）
     * @return true：获得锁，false：未获得锁
     * @throws RedisException
     */
    public boolean getLock(String lockName , int lockTime , long timeOut) throws RedisException {
        Jedis jedis = jedisPool.getResource();
        long beginTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - beginTime < timeOut) {
            try {
                String setResult = jedis.set(lockName, "lock ok", "NX", "PX", lockTime);
                if (STATUS_CODE_OK.equalsIgnoreCase(setResult)) {
                    returnResource(jedis);
                    return true;
                }
                Thread.sleep(30);
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Thread.interrupted();
                } else {
                    returnResource(jedis);
                    throw new RedisException("RedisLock getLock lockName=" + lockName + " Exception" , e);
                }
            }
        }
        returnResource(jedis);
        return false;
    }

    /***
     * 获取redis分布式锁
     * @param lockName 锁名称
     * @return true：获得锁，false：释放锁失败
     * @throws RedisException
     */
    public boolean releaseLock(String lockName) throws RedisException {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.del(lockName);
            return true;
        } catch (Exception e) {
            throw new RedisException("RedisLock releaseLock lockName=" + lockName + " Exception" , e);
        } finally {
            returnResource(jedis);
        }
    }

    /***
     * 释放redis分布式锁
     * @return true：释放锁成功，false：释放锁失败
     * @throws RedisException
     */
    public boolean releaseLock() throws RedisException {
        return releaseLock(key);
    }
}
