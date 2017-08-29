package com.xiaogch.maven.redis.common;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

/**
 * ProjectName: maven <BR>
 * File name: com.xiaogch.maven.redis.common <BR>
 * Author: guich <BR>
 * Project: maven <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/8/24 11:34 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class RedisHash {
    private JedisPool pool;
    private String key;

    public RedisHash(JedisPool jedisPool) {
        this(jedisPool , "default:hashkey");
    }

    public RedisHash(JedisPool pool , String key) {
        this.pool = pool;
        this.key = key;
    }

    /***
     *
     * @param key
     * @param field
     * @param value
     * @return 0:set ok but field is old , 1:set ok and new field , -1 redis exception
     */
    public long hset(String key , String field , String value) {
       Jedis jedis = pool.getResource();
       try {
           Long hetResult = jedis.hset(key , field , value);
           return hetResult == null ? -1 : hetResult;
       } catch (JedisException e) {

           return -1;
       } finally {
           pool.returnResource(jedis);
       }

    }



}
