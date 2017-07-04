package com._21cn.fbmp.common.redis.jedis;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

/**
 * set数据结构的操作
 * @author Administrator
 */
public class JedisSetCache extends JedisCache {
    
	private String key = null;
	
	public JedisSetCache() {
		super();
	}
	JedisSetCache( JedisPool pool, String key ){
		super( pool );
		this.key = key;
	}
	
	JedisSetCache( JedisPool pool, Transcoder<Object> transcoder, String key ){
		super( pool,transcoder);
		this.key = key;
	}
	
    public long add( Object[] members) {
		return add( key, members );
    }
    
    /**
     * 添加元素
     * @param key
     * @param members
     * @return 1-成功添加 0-重复数据
     */
    public long add(String key, Object[] members) {
        Jedis jedis = null;
        try {
        	jedis = pool.getResource();
        	if( members == null || members.length == 0 )
        		return 0L;
        	byte[] keyBytes = transcoder.getKeyBytes( key );
        	byte[][] valuesBytes = convertObject( members );
       		return jedis.sadd( keyBytes, valuesBytes );
        } catch (Exception e) {
            e.printStackTrace();
            pool.returnBrokenResource(jedis);
            throw new JedisException(e.getMessage());
        } finally {
            pool.returnResource(jedis);
        }
    }

    public long remove(Object[] members) {
    	return remove( key, members );
    }
    
    /**
     * 移除数据
     * @param key
     * @param members
     * @return 移除元素的个数，不存在返回0
     */
    public long remove(String key, Object[] members) {
        Jedis jedis = null;
        try {
        	jedis = pool.getResource();
        	if( members == null || members.length == 0 )
        		return 0L;
        	byte[] keyBytes = transcoder.getKeyBytes( key );
        	byte[][] valuesBytes = convertObject( members );
       		return jedis.srem( keyBytes, valuesBytes );
        } catch (Exception e) {
        	e.printStackTrace();
        	pool.returnBrokenResource(jedis);
        	throw new JedisException(e.getMessage());
        } finally {
            pool.returnResource(jedis);
        }
    }

    public long size(){
    	return size( key );
    }
    
    /**
     * 元素的个数
     * @param key
     * @return
     */
    public long size( String key ){
        Jedis jedis = null;
        try {
        	jedis = pool.getResource();
        	return jedis.scard( transcoder.getKeyBytes( key ) );
        } catch (Exception e) {
        	e.printStackTrace();
        	pool.returnBrokenResource(jedis);
        	throw new JedisException(e.getMessage());
        } finally {
            pool.returnResource(jedis);
        }    	
    }
    
    public long delKey(String key) {
    	 Jedis jedis = null;
         try {
         	jedis = pool.getResource();
         	return jedis.del( transcoder.getKeyBytes( key ) );
         } catch (Exception e) {
         	e.printStackTrace();
         	pool.returnBrokenResource(jedis);
         	throw new JedisException(e.getMessage());
         } finally {
             pool.returnResource(jedis);
         }    
    }
    
    public boolean isContain(final Object member) {
    	return isContain(key,member);
    }
    
    
    public boolean isContain(String key,final Object member) {
    	Jedis jedis = null;
        try {
        	jedis = pool.getResource();
        	if( member == null) {
        		return false;
        	}
        	byte[] keyBytes = transcoder.getKeyBytes(key);
        	byte[] valuesBytes = transcoder.encode(member);
       		return jedis.sismember(keyBytes, valuesBytes);
        } catch (Exception e) {
        	e.printStackTrace();
        	pool.returnBrokenResource(jedis);
        	throw new JedisException(e.getMessage());
        } finally {
            pool.returnResource(jedis);
        }
    }
    
    /**
     * 设置过期时间 (秒)
     * @param key
     * @param seconds
     * @return
     */
    public long setTTLSeconds( String key, int seconds ) {
        Jedis jedis = null;
        try {
        	jedis = pool.getResource();
        	if( seconds < 0)
        		return jedis.persist( key );
            return jedis.expire( key, seconds );
        } catch (Exception e) {
        	e.printStackTrace();
        	pool.returnBrokenResource(jedis);
        	throw new JedisException(e.getMessage());
        } finally {
            pool.returnResource(jedis);
        }
    }
    

    protected byte[][] convertObject( Object... values ) {
		byte[][] valuesBytes = new byte[values.length][];
		
	    for (int i=0; i<values.length; i++) {
	    	valuesBytes[i] = transcoder.encode( values[i] );
	    }
	    return valuesBytes;
    }
    
    /**
     * 获取set的元素
     * @param key
     * @return
     */
    public Set<?> members() {
    	return members( key );
    }
    /**
     * 获取set的元素
     * @param key
     * @return
     */
    public Set<?> members(String key) {
    	Jedis jedis = pool.getResource();
        Set<Object> result = new HashSet<Object>();
        try {
            Set<byte[]> bytesList = jedis.smembers( transcoder.getKeyBytes( key ) );
            result.addAll( convertBytesList( bytesList ) );
        } catch (Exception e) {
            e.printStackTrace();
            log.error( "redis smembers error " , e );
            pool.returnBrokenResource(jedis);
        } finally {
            pool.returnResource(jedis);
        }
        return result;
    }
    

}
