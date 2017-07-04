package com._21cn.fbmp.common.redis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com._21cn.fbmp.common.constants.Constants;
import com._21cn.fbmp.common.entity.MsgBean;
import com._21cn.fbmp.common.redis.jedis.JedisCache;
import com._21cn.fbmp.common.redis.jedis.JedisHashCache;

import redis.clients.jedis.exceptions.JedisException;

/**
 * @desc redis的Hash数据结构设值、取值、自增、删除操作
 * @since JDK 1.6
 * @version 1.0
 * @author pet
 * @date 2013/10/30
 */
@Component
public class HashCache {
	
	private Logger log = Logger.getLogger(getClass());
	
	private JedisHashCache jedisHashCache ;
	@Autowired
	private JedisCache jedisCache ;
	private String keyName;
	
	public HashCache(){}
	
	public HashCache(String keyName){
		this.keyName  =  keyName;
	}

	@PostConstruct
	public void init() {
		jedisHashCache = jedisCache.getJedisHashCache(jedisCache.getTranscoder(), keyName);
	}
	
	  /**
	  * @param field  
	  * @param object
	  * @return 1:成功;-1:失败
	  */
	public int set(String field, Object object) {
		try {
			jedisHashCache.setValue(keyName, field, object,false);
			return 1;
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("HashCache set JedisException",e);
			return -1;
		}
	}
	
	/**
	  * @param field  
	  * @param object
	  * @return 1:成功;-1:失败
	  */
	public int set_new(String field, Object object) {
		try {
			return  (int) jedisHashCache.setValue(keyName, field, object,true);
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("HashCache set JedisException",e);
			return -1;
		}
	}

	/**
	 * @desc 取值
	 * @param field
	 * @return 存在返回;不存在返回空对象；异常返回null
	 */
	public Object get(String field,Object obj) {
		try {
			Object object = (Object)jedisHashCache.getValue(keyName, field);
			if(object == null){
				return obj;
			}
			return object;
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("HashCache get JedisException",e);
			return null;
		}
	}
	

	/**
	 * @desc 删除对应域
	 * @param field
	 * @return 1-成功;-1-删除失败
	 */
	public long del(String field) {
		try {
			return jedisHashCache.remove(keyName,new String[] { field });
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("HashCache del JedisException",e);
			return -1l;
		}
	}
	
	/**
	 * @desc 删除此keyName下filed的对应域
	 * @param keyName,field
	 * @return 1-成功;-1-删除失败
	 */
	public long del(String keyName,String field) {
		try {
			return jedisHashCache.remove(keyName,new String[] { field });
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("HashCache del JedisException",e);
			return -1l;
		}
	}
	
	/**
	 * 删除hash整个key.
	 * @param keyName  key名称
	 * @return 1-成功;-1-删除失败 ;0-无此key
	 */
	public long hdelByKey(String keyName) {
		try {
			long removeResult = jedisHashCache.remove(keyName);
			log.info("hdelAll removeResult:"+removeResult);
			return removeResult;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("HashCache hdelAll JedisException",e);
			return -1l;
		}
	}
	
	/**
	 * 自增(流量控制用)
	 * @param msgBean
	 * @param count
	 * @return 返回null,自增失败，否则返回自增后的值
	 */
	public String incr(MsgBean msgBean,long count){
		try {
			return ""+jedisHashCache.incrValue(keyName,""+msgBean.getPartnerId() + msgBean.getContractId(),count);
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("HashCache incr JedisException",e);
			return null;
		}
	}

	/**
	 * 自增(生成transationId)
	 * @param filed 
	 * @param count
	 * @return
	 */
	public String incr(String filed,int count){
		try {
			return ""+jedisHashCache.incrValue(keyName,filed,count);
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("HashCache incr JedisException",e);
			return null;
		}
	}
	
	
	/**
	 * 自增(订单数统计用)
	 * @param msgBean
	 * @param count 
	 * @return 返回null,自增失败，否则返回自增后的值
	 */
	public String incrOrderIndex(MsgBean msgBean,int count){
		try {
			return ""+jedisHashCache.incrValue(keyName,msgBean.getOrderId()+Constants.ORDER_ID,count);
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("HashCache incrOrderIndex JedisException",e);
			return null;
		}
	}
	
	/**
	 * 自增(活动进度订购数统计)
	 * @param msgBean
	 * @param count 
	 * @return 返回null,自增失败，否则返回自增后的值
	 */
	public String incrOrder(MsgBean msgBean,int count){
		try {
			return ""+jedisHashCache.incrValue(keyName,""+msgBean.getPartnerId()+msgBean.getActivityId(),count);
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("HashCache incrOrder JedisException",e);
			return null;
		}
	}

	
	/**
	 * 返回HASH表的所有域
	 * @return
	 */
	public Set<String> getFieldSet() {
		try {
			return jedisHashCache.getFieldSet();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("HashCache incrOrderIndex JedisException",e);
		}
		return new HashSet<String>();
	}
	
	/**
	 * @desc 取值
	 * @param field
	 * @return 存在返回;不存在返回空对象；异常返回null
	 */
	@SuppressWarnings("rawtypes")
	public Object hgetAll(String keyName,Object obj) {
		try {
			Object object = (Object)jedisHashCache.hgetAll(keyName);
			if(object == null){
				if(obj instanceof HashMap)return new HashMap();
				if(obj instanceof LinkedHashMap)return new LinkedHashMap();
				return "";
			}
			return object;
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("HashCache get JedisException",e);
			return null;
		}
	}
	
	public boolean exist(String key, String field) {
		return jedisHashCache.hExists(key, field);
	}
	
}