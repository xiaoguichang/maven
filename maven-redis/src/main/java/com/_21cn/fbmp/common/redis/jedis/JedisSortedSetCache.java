package com._21cn.fbmp.common.redis.jedis;

import java.util.LinkedHashSet;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisSortedSetCache extends JedisCache{
	
	public String key;

	
	JedisSortedSetCache( JedisPool pool, String key ){
		super( pool );
		this.key = key;
	}
	
	 public JedisSortedSetCache( JedisPool pool, Transcoder<Object> transcoder, String key){
	    	this.pool = pool;
	    	this.transcoder = transcoder;
	    	this.key = key;
	    }
	
	
	public long add(Object member ) {
		return add(1.0, member );
    }
	
    /**
     * 添加元素
     * @param key
     * @param score
     * @param member
     * @return
     */
    public long add(Double score, Object member) {
    	Jedis jedis = pool.getResource();
        try {
       		return jedis.zadd( transcoder.getKeyBytes( key ), score, transcoder.encode( member) );
        } catch (Exception e) {
            e.printStackTrace();
            log.error( "redis zadd() error " , e );
            pool.returnBrokenResource(jedis);
            return -1L;
        } finally {
            pool.returnResource(jedis);
        }
    }
	
    /**
     * 获取有序集 key中成员 member的排名，
     * desc为true时表示由大到小排序的排名( 排名以 0为底，也就是说， score值最大的成员排名为 0。)
     * 成功返回排名，异常返回-1L 
     * @param key
     * @param member
     * @param desc
     * @return long
     */
    public long getRank(Object member, boolean desc){
    	Jedis jedis = pool.getResource();
    	try{
    		if(desc){
    			return jedis.zrevrank(transcoder.getKeyBytes(key), transcoder.encode(member));
    		}else{
    			return jedis.zrank(transcoder.getKeyBytes(key), transcoder.encode(member));
    		}
    	}catch(Exception e){
    		log.error("redis zrank() error", e);
    		pool.returnBrokenResource(jedis);
    		return -1L;
    	}finally{
    		pool.returnResource(jedis);
    	}
    }
    
    /**
     * 获取有序集 key中，成员 member的 score值。异常返回-1
     * @param key
     * @param member
     * @return Double
     */
    public double getScore(Object member){
    	Jedis jedis = pool.getResource();
    	try{
    		Double score =  jedis.zscore(transcoder.getKeyBytes(key), transcoder.encode(member));
    		return score == null ? -1 : score;
    	}catch(Exception e){
    		log.error("redis zscore() error", e);
    		pool.returnBrokenResource(jedis);
    		return -1;
    	} finally{
    		 pool.returnResource(jedis);
    	}
    }
    
    /**
     * 获取set的元素
     * @param key
     * @return
     */
    public LinkedHashSet<?> getRange() {
    	return getRange( 0, -1, true);
    }
    
    public LinkedHashSet<?> getRange(int start, int end) {
    	return getRange(start, end, false );
    }
    
    public LinkedHashSet<?> getRange(int start, int end, boolean desc ) {
    	Jedis jedis = pool.getResource();
        try {
        	Set<byte[]> bytesList = null;
        	if( desc )
        		bytesList = jedis.zrevrange( transcoder.getKeyBytes( key ), start, end );
        	else
        		bytesList = jedis.zrange( transcoder.getKeyBytes( key ), start, end );
            return new LinkedHashSet<Object>( convertBytesList( bytesList ) );
        } catch (Exception e) {
            log.error( "redis zrange() error " , e );
            pool.returnBrokenResource(jedis);
        } finally {
            pool.returnResource(jedis);
        }
        return new LinkedHashSet<Object>();
    }
    /**
     * 移除指定下标元素
     * @param key
     * @param start
     * @param end
     */
    public void remove(String key, int start, int end){
    	Jedis jedis = pool.getResource();
    	try {
			jedis.zremrangeByScore(key, start, end);
		} catch (Exception e) {
			 log.error( "redis zremrangeByScore() error " , e );
			 pool.returnBrokenResource(jedis);
		} finally{
			 pool.returnResource(jedis);
		}
    }
    /**
     * 移除多个元素
     * @param key
     * @param members
     */
    public long zrem(String key, String... members){
    	Jedis jedis = pool.getResource();
    	try {
			return jedis.zrem(key, members);
		} catch (Exception e) {
			 log.error( "redis zremrangeByScore() error " , e );
			 pool.returnBrokenResource(jedis);
			 return 0L;
		} finally{
			 pool.returnResource(jedis);
		}
    }
    
    public long zcard(String key){
    	Jedis jedis = pool.getResource();
    	try {
			return jedis.zcard(key);
		} catch (Exception e) {
			 log.error( "redis zremrangeByScore() error " , e );
			 pool.returnBrokenResource(jedis);
			 return 0L;
		} finally{
			 pool.returnResource(jedis);
		}
    }

}
