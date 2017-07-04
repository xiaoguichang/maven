package com._21cn.fbmp.common.redis.jedis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

/**
 * 创建连接池
 * @since JDK 1.6
 * @version 1.0
 * @author pet
 * @date 2014/1/10
 */
public class JedisCache {
	
	protected Logger log = Logger.getLogger(getClass());

    protected JedisPool pool;
    
    protected Transcoder<Object> transcoder = StringTranscoder.getDefaultinstance();
    
    public JedisCache(){
    }
    
    public JedisCache( JedisPool pool ){
    	this.pool = pool;
    }
    
    public JedisCache( JedisPool pool, Transcoder<Object> transcoder){
    	this.pool = pool;
    	this.transcoder = transcoder;
    }
    
    /**
     * 获取JedisHashCache实例
     * @param transcoder
     * @param key
     * @return
     */
    public JedisHashCache getJedisHashCache( Transcoder<Object> transcoder, String key ){
    	return new JedisHashCache( pool, transcoder, key );
    }
    public JedisHashCache getJedisHashCache( String key ){
    	return new JedisHashCache( pool, key );
    }

    /**
     * 获取JedisListCache实例
     * @param transcoder
     * @param key
     * @return
     */
    public JedisListCache getJedisListCache( Transcoder<Object> transcoder, String key ){
    	return new JedisListCache( pool, transcoder, key );
    }
    
    public JedisListCache getJedisListCache(String key){
    	return new JedisListCache( pool, key );
    }
    
    /**
     * 获取JedisSetCache实例
     * @param transcoder
     * @param key
     * @return
     */
    public JedisSetCache getJedisSetCache( Transcoder<Object> transcoder, String key ){
    	return new JedisSetCache( pool, transcoder, key );
    }
    
    public JedisSetCache getJedisSetCache(String key ){
    	return new JedisSetCache( pool, key );
    }
    
    public JedisStringCache getJedisStringCache(
    		Transcoder<Object> transcoder, String keyName) {
		return new JedisStringCache(pool, transcoder, keyName);
	}
    
    public JedisStringCache getJedisStringCache(String key ){
    	return new JedisStringCache( pool, key );
    }

    
    public void destroy() {
        pool.destroy();
    }

    public JedisPool getPool() {
        return pool;
    }

    public void setPool(JedisPool pool) {
        this.pool = pool;
    }

    public Transcoder<Object> getTranscoder() {
    	return transcoder;
    }

    public void setTranscoder( Transcoder<Object> transcoder ) {
    	this.transcoder = transcoder;
    }
    
    protected List<?> convertBytesList( Collection<byte[]> bytesList ) {
	    List<Object> result;
	    result = new ArrayList<Object>(bytesList.size());
	    for (byte[] bytes : bytesList) {
	        result.add( transcoder.decode(bytes) );
	    }
	    return result;
    }
    
    /**
     * 获取JedisSortedSetCache实例
     * @param transcoder
     * @param key
     * @return
     */
    public JedisSortedSetCache getJedisSortedSetCache( Transcoder<Object> transcoder, String key ){
    	return new JedisSortedSetCache( pool, transcoder, key );
    }
    
    public JedisSortedSetCache getJedisSortedSetCache(String key ){
    	return new JedisSortedSetCache( pool, key );
    }
    
    
    /**
     * 根据key获取value值
     * @param key
     * @return
     */
    public Object get(String key) {
    	
    	Jedis jedis = pool.getResource();
        try {
            return transcoder.decode(jedis.get(transcoder.getKeyBytes( key )));
        } catch (Exception e) {
            e.printStackTrace();
            log.error( "redis get() error " , e );
            pool.returnBrokenResource(jedis);
            return null;
        } finally {
            pool.returnResource(jedis);
        }

    }
    
	 /**
	  * 设置k-v
	 * @param key
	 * @param value
	 * @param forceNewNotExist
	 * @return
	 */
	public long set(String key, Object value, boolean forceNewNotExist) {
		Jedis jedis = pool.getResource();
         try {
        	 
        	 if( forceNewNotExist )
        		 return jedis.setnx(transcoder.getKeyBytes( key ), transcoder.encode(value));//不存在返回1，存在返回0，不覆盖原值
        	 jedis.set(transcoder.getKeyBytes( key ), transcoder.encode(value));//返回ok，存在覆盖
             return 1L;
         } catch (Exception e) {
             e.printStackTrace();
             log.error( "redis set() error " , e );
             pool.returnBrokenResource(jedis);
         } finally {
            pool.returnResource(jedis);
         }
         return 0L;
    }
	 
	
	 /**
	  * 判断是否存在key
	 * @param key
	 * @return
	 */
	public boolean contains(String key) {
		Jedis jedis = pool.getResource();
	        boolean result = false;
	        try {
	            result = jedis.exists( key );
	            return result;
	        } catch (Exception e) {
	            e.printStackTrace();
	            log.error( "redis exists() error " , e );
	            pool.returnBrokenResource(jedis);
	            return result;
	        } finally {
	            pool.returnResource(jedis);
	        }
	    }

	/**
	 * 设置新值，返回旧值
	 * 
	 * @param key
	 * @param newValue
	 * @return
	 */
	public Object getAndSet(String key, Object newValue) {
		Jedis jedis = pool.getResource();
		try {
			return transcoder.decode(jedis.getSet(transcoder.getKeyBytes(key), transcoder.encode(newValue)));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("redis getAndSet error ", e);
			pool.returnBrokenResource(jedis);
		} finally {
			pool.returnResource(jedis);
		}
		return null;
	}

	public long delKey(String key) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			long l = jedis.del(key);// 存在，覆盖值，返回0，不存在set值,返回1
			System.out.println(l);
			return l;
		} catch (Exception e) {
			e.printStackTrace();
			pool.returnBrokenResource(jedis);
			throw new JedisException(e.getMessage());
		} finally {
			pool.returnResource(jedis);
		}
	}
	
	public long getHashQueueSize(String key) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			long l = jedis.hlen(key);// 存在，覆盖值，返回0，不存在set值,返回1
			return l;
		} catch (Exception e) {
			e.printStackTrace();
			pool.returnBrokenResource(jedis);
			throw new JedisException(e.getMessage());
		} finally {
			pool.returnResource(jedis);
		}
	}

}
