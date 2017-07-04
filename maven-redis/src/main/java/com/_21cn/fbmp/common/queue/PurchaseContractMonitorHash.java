package com._21cn.fbmp.common.queue;

import org.springframework.stereotype.Component;

import com._21cn.fbmp.common.redis.HashCache;

/**
 * 记录采购合同金额消费告警信息
 */
@Component
public class PurchaseContractMonitorHash extends HashCache {
	
	/**集团的统一缓存，指定redis的key**/
	public static final String  QUEUE_NAME = "PURCHASE_CONTRACT_MONITOR_CACHE";
	public PurchaseContractMonitorHash(){
		super(QUEUE_NAME);
	}
}
