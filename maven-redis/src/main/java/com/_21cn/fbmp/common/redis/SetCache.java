package com._21cn.fbmp.common.redis;


import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.exceptions.JedisException;

import com._21cn.fbmp.common.redis.jedis.JedisCache;
import com._21cn.fbmp.common.redis.jedis.JedisSetCache;

/**
 * @desc redis的set数据结构设值、删除操作
 * @since JDK 1.6
 * @version 1.0
 * @author pet
 * @date 2013/10/30
 */
@Component
public class SetCache {
	
	private Logger log = Logger.getLogger(getClass());
	
	private JedisSetCache jedisSetCache ;
	@Autowired
	private JedisCache jedisCache ;
	private String keyName;
	
	public SetCache(){}
	
	public SetCache(String keyName){
		this.keyName  =  keyName;
	}

	@PostConstruct
	public void init() {
		jedisSetCache = jedisCache.getJedisSetCache(jedisCache.getTranscoder(), keyName);
	}
	
	
	public long add(Object[] members) {
		return add(keyName,members);
	}
	
	/**
	 * @param key
	 * @param members
	 * @return -1 异常;其他-新增元素个数
	 */
	public long add(String key, Object[] members) {
		try {
			return jedisSetCache.add(key,members);
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("SetCache add JedisException",e);
			return -1;
		}
	}
	
	/**
	 * 判定元素是否存在
	 * @param member
	 * @return
	 */
	public boolean isContant(final Object member) {
		return isContant(keyName,member);
	}
	
	public boolean isContant(String key,final Object member) {
		try {
			return jedisSetCache.isContain(key,member);
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("SetCache add JedisException",e);
			return false;
		}
	}
	
	
	public long del(Object[] members) {
		return del(keyName, members);
	}
	
	/**
	 * 删除元素
	 * @param key
	 * @param members
	 * @return 返回删除元素的个数 ； -1-异常
	 */
	public long del(String key, Object[] members) {
		try {
			return jedisSetCache.remove(key, members);
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("SetCache del JedisException",e);
			return -1;
		}
	}
	
	
	public long setExpireTime(int seconds) {
		return setExpireTime(keyName, seconds);
	}
	
	public long setExpireTime(String key, int seconds) {
		try {
			return jedisSetCache.setTTLSeconds(key, seconds);
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("SetCache del JedisException",e);
			return -1;
		}
	}
	
	
	public long size(){
		return size(keyName);
	}
	
	public long size(String key) {
		try {
			return jedisSetCache.size(key);
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("ListCache getQueueSize JedisException",e);
			return -1L;
		}
	}
	
	public long delKey(String key) {
		try {
			return jedisSetCache.delKey(key);
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("SetCache delKey JedisException",e);
			return -1L;
		}
	}
	
	public long delKey() {
		return delKey(keyName);
	}
}