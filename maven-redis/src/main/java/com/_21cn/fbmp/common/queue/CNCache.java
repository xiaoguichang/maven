package com._21cn.fbmp.common.queue;

import org.springframework.stereotype.Component;

import com._21cn.fbmp.common.redis.HashCache;

/**
 * 统一缓存（集团）,存放除接收队列、中枢队列和反馈队列外的信息
 * @author Administrator
 */
@Component
public class CNCache extends HashCache {
	
	/**集团的统一缓存，指定redis的key**/
	public static final String  QUEUE_NAME = "CN_CACHE";
	public CNCache(){
		super(QUEUE_NAME);
	}
}
