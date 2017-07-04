package com._21cn.fbmp.common.redis;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.exceptions.JedisException;
import com._21cn.fbmp.common.constants.Constants;
import com._21cn.fbmp.common.entity.MsgBean;
import com._21cn.fbmp.common.redis.jedis.JedisCache;
import com._21cn.fbmp.common.redis.jedis.JedisListCache;

/**
 * @desc redis的List数据结构设值、取值操作,作为队列的基类
 * @since JDK 1.6
 * @version 1.0
 * @author pet
 * @date 2013/10/30
 */
@Component
public class ListCache {

	private Logger log = Logger.getLogger(getClass());

	private String queueName;//队列名

	private JedisListCache jedisListCache;
	@Autowired
	private JedisCache jedisCache ;
	public ListCache() {}
	
	public ListCache(String queueName) {
		this.queueName = queueName;
	}
	
	@PostConstruct
	public void init() {
		jedisListCache = jedisCache.getJedisListCache(jedisCache.getTranscoder(), queueName);
	}
	
	/**
	 * 入队列异常返回-1，队列满返回2，入队列成功返回1
	 * @param msg
	 * @return
	 */
	public int push(MsgBean msgBean) {
		if (getQueueSize() > Constants.QUEUE_MAXSIZE) {
			return 2;
		}
		try {
			return jedisListCache.rightPush(new Object[] { msgBean }) > 0 ? 1 : -1;
		} catch (JedisException e) {
			e.printStackTrace();
			return -1;	
		}
	}
	
	/**
	 * 入队列异常返回-1，队列满返回2，入队列成功返回1
	 * @param msg
	 * @return
	 */
	public int pushObj(Object msgBean) {
		if (getQueueSize() > Constants.QUEUE_MAXSIZE) {
			log.error(",ListCache push queue error,queue is full" + ",size:"+ getQueueSize());
			return 2;
		}
		try {
			return jedisListCache.rightPush(new Object[] { msgBean }) > 0 ? 1 : -1;
		} catch (JedisException e) {
			e.printStackTrace();
			log.error(",ListCache push queue JedisException",e);
			return -1;	
		}
	}
	
	/**
	 * 存在返回对象；不存在返回空对象；异常返回null
	 * @return
	 */
	public MsgBean pop() {
		try {
			Object object = jedisListCache.pop();
			if(object == null)return new MsgBean();
			return (MsgBean) object;
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("ListCache pop queue JedisException",e);
			return null;
		}
	}
	
	/**
	 * 存在返回对象；不存在返回空对象；异常返回null
	 * @return
	 */
	public Object popObj() {
		try {
			return jedisListCache.pop();
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("ListCache pop queue JedisException",e);
			return null;
		}
	}

	/**
	 * 返回队列长度
	 * @return
	 */
	public long getQueueSize() {
		try {
			return jedisListCache.size();
		} catch (JedisException e) {
			e.printStackTrace();
			log.error("ListCache getQueueSize JedisException",e);
			return -1L;
		}
	}
	
	public List<String> lrange(String key, int start, int end) {
		try {
			return jedisListCache.lrange(key, start, end);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ArrayList<String>();
	}
	
	public static void main(String[] args) {
//		JedisCache jedisCache = new  JedisCache();
//		JedisPoolConfig config = new JedisPoolConfig();
//    	config.setMaxActive(100);
//    	config.setMaxIdle(20);
//    	config.setMaxWait(1000l);
//    	JedisPool pool = new JedisPool(config, "127.0.0.1", 6379);
//    	JedisListCache jedisListCache = jedisCache.getJedisListCache(jedisCache.getTranscoder(), "listTest");
//    	
//    	long r =  jedisListCache.push(true, true, "9999");
//    	System.out.println(r);
//    	String s = jedisListCache.pop();
//    	System.out.println(s);
    	
	}

}
