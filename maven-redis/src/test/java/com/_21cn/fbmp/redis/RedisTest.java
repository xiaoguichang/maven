package com._21cn.fbmp.redis;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com._21cn.fbmp.common.queue.CNCache;
import com._21cn.fbmp.common.queue.PurchaseContractMonitorHash;
import com._21cn.fbmp.common.redis.jedis.JedisCache;
import com._21cn.fbmp.common.redis.jedis.JedisHashCache;
import com._21cn.fbmp.common.redis.jedis.StringTranscoder;
import com._21cn.fbmp.junit.SpringJunitTestBase;

public class RedisTest extends SpringJunitTestBase {
	
	@Autowired
	private CNCache cncache;
	
	@Autowired
	private PurchaseContractMonitorHash purchaseContractMonitorHash;
	
	@Autowired
	private JedisCache jedisCache;
	
	public static final String PUR_CONTRACT_MONITOR = "PUR_CONTRACT_MONITOR:";
	
	public static final String PURCONTRACT_LASTAMOUT = "PURCONTRACT_LASTAMOUT";
	
	public static final String FPS_PURCHASECONTRACT_USE = "FPS_PURCHASECONTRACT_USE_";
	
	@Test
	public void testRedis() {
		
		String purchaseContractId= "223";
		cncache.set(PURCONTRACT_LASTAMOUT + purchaseContractId , 5000);
		/** case 2 采购合同七天内无消耗 */
		for (int i = 0 ; i < 7 ; i++) {
			String keyName = FPS_PURCHASECONTRACT_USE + dateFormat(new Date(),-i);
			JedisHashCache jedisHashCache = jedisCache.getJedisHashCache(StringTranscoder.getDefaultinstance(), keyName);
			jedisHashCache.setValue(purchaseContractId, 0, false);
		}
		
		purchaseContractId= "228";
		cncache.set(PURCONTRACT_LASTAMOUT + purchaseContractId , 5000);
		/** case 2 采购合同七天内有消耗 */
		for (int i = 0 ; i < 7 ; i++) {
			String keyName = FPS_PURCHASECONTRACT_USE + dateFormat(new Date(),-i);
			JedisHashCache jedisHashCache = jedisCache.getJedisHashCache(StringTranscoder.getDefaultinstance(), keyName);
			jedisHashCache.setValue(purchaseContractId, 100000, false);
		}
		
	}
	
	private String dateFormat(Date date , int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, amount);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(calendar.getTime());
	}
}
