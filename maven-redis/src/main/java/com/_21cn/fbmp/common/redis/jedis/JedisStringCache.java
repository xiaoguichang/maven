package com._21cn.fbmp.common.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

/**
 * 微信公众号的redis,Strring 数据结构
 * @author libai
 */

public class JedisStringCache extends JedisCache  {
	
	private String key;
	
	JedisStringCache( JedisPool pool,Transcoder<Object> transcoder, String key ){
		super( pool, transcoder );
		this.key = key;
	}
	
	JedisStringCache( JedisPool pool, String key ){
		super( pool );
		this.key = key;
	}
	
    public long set(Object value) {
    	return set( value, true );
    }

    /**
     * 
     * @param key
     * @param value
     * @param forceNewNotExist
     * @return 1-设置成功 ;0-值已存在
     */
    public long set(Object value, boolean forceNewNotExist) {
        Jedis jedis = null;
        try {
        	jedis = pool.getResource();
        	if( forceNewNotExist )
        		return jedis.setnx(transcoder.getKeyBytes( key ), transcoder.encode(value));
            jedis.set(transcoder.getKeyBytes( key ), transcoder.encode(value));
            return 1L;
        } catch (Exception e) {
        	pool.returnBrokenResource(jedis);
         	throw new JedisException(e.getMessage());
        } finally {
            pool.returnResource(jedis);
        }
    }
    
    public String get(){
    	Jedis jedis = null;
    	try {
        	jedis = pool.getResource();
            return jedis.get(key);
        } catch (Exception e) {
        	pool.returnBrokenResource(jedis);
         	throw new JedisException(e.getMessage());
        } finally {
            pool.returnResource(jedis);
        }
    }
    

    /**
     * 
     * @param key
     * @param value
     * @param forceNewNotExist
     * @return 
     */
    public long incr(String key, long value) {
        Jedis jedis = null;
        try {
        	jedis = pool.getResource();
    		return jedis.incrBy(key, value);
        } catch (Exception e) {
        	pool.returnBrokenResource(jedis);
         	throw new JedisException(e.getMessage());
        } finally {
            pool.returnResource(jedis);
        }
    }
    
    
    public long remove(String key) {
        Jedis jedis = (Jedis)pool.getResource();
        try
        {
            long delResult = jedis.del(new String[] { key });
            return delResult;
        } catch(Exception e) {
            pool.returnResource(jedis);
            throw new JedisException(e.getMessage());
        }finally{
        	pool.returnResource(jedis);
        }
    }
    
    /**
     * 设置过期时间 (秒)
     * @param key
     * @param seconds
     * @return
     */
    public long setTTLSeconds(int seconds ) {
        Jedis jedis = null;
        try {
        	jedis = pool.getResource();
        	if( seconds < 0)
        		return jedis.persist( key );
            return jedis.expire( key, seconds );
        } catch (Exception e) {
        	pool.returnBrokenResource(jedis);
        	throw new JedisException(e.getMessage());
        } finally {
            pool.returnResource(jedis);
        }
    }
    
    /**
     * 获取过期时间
     * @param key
     * @return
     */
    public Long ttl(String key) {
    	Jedis jedis = null;
    	try {
    		jedis = pool.getResource();
    		return jedis.ttl(key);
		} catch (Exception e) {
        	pool.returnBrokenResource(jedis);
		}finally {
            pool.returnResource(jedis);
        }
    	return null;
    }
	
}








