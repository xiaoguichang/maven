package com._21cn.fbmp.common.constants;

/**
 * 常量类
 * @author acer
 */
public class Constants {

	/**系统编码（平台管理系统：0，业务管理系统：1，流量生产系统：2，流量经营门户：3）**/
	public static final int SYSTEM_CODE = 2;
	
	/**TAB键分隔，生成日志用**/
	public static final String LOG_SPLIT = "\t";
	
	/**TAB键分隔，生成日志用**/
	public static final String KEY_SPLIT = ":";
	
	/**保存号段信息缓存的标识**/
	public static final String SYNC_SEGMENT_INFO = "_SEGMENT_INFO";//任务缓存
	
	/**订单标识**/ 
	public static final String ORDER_ID = "ORDER_ID";
	
	/**路径分割符“/”**/
	public static final String SYSTEM_PATH_SEPARATOR = System.getProperty("file.separator");
	
	/**获取当前时间，默认时间格式**/
	public final static String DATE_FORMAT_TYPE = "yyyyMMddHHmmssSSSS";
	
	
	/**综合平台系统编码**/
	public final static int sysCode = 1000000122;// 中国电信综合平台 系统编码
	
	/**队列最大数1千万**/
	public static final long QUEUE_MAXSIZE = 10000000l;
	
	/**日志时间格式**/
	public final static String LOG_DATE_PATTERN = "yyyyMMddHHmmss";
	
	/**重发次数(默认值)**/
	public static final Integer SEND_COUNT = 3;//重发次数
	
	/**SUPPORT模块--检验码失活时间    单位 : 秒(默认值) **/  
	public static final long CHECKCODE_DISABLED_TIME = 300;  // 5min
	
	/**SUPPORT模块--IP地址段广东的地址**/
	public static final String REGION_CODE_GD = "CN44";
	
	/**生成transationId field**/
	public static final String TRANSACTIONOFFER = "transactionidOffer";
	
	/**生成extCustOrderId field**/
	public static final String EXTCUSTORDER = "extCustOrderIdOffer";
	
	/**
	 * 在线销售可使用数量key
	 */
	public static final String FMP_ORDER_KEY = "FMP_ORDER";
	
	/**
	 * 优先级队列key
	 */
	public static final String FPS_QUEUE_PRIORITY_KEY = "PRIORITY_KEY_SORTED_SET";
	
	/**
	 *联通优先级队列key
	 */
	public static final String UNICOM_QUEUE_PRIORITY_KEY = "UNICOM_PRIORITY_SORTED_SET";
	
	/**
	 * 移动优先级队列key
	 */
	public static final String CMCC_QUEUE_PRIORITY_KEY = "CMCC_PRIORITY_SORTED_SET";
	
	/**
	 * 延迟队列
	 */
	public static final String FPS_QUEUE_DELAY_KEY = "DELAY_PRIORITY_QUEUE";
	
	/**
	 * 暂停队列
	 */
	public static final String FPS_QUEUE_PAUSE_KEY = "_PAUSE_PRIORITY_QUEUE";
	
	/**
	 * MSGBEAN队列后缀
	 */
	public static final String FPS_MSGBEAN_QUEUE = "_MSGBEAN_COLLECTIONS";
	
	/**
	 * 订购结果key
	 */
	public static final String FPS_ORDER_RESULT_KEY = "ORDER_RESULT_";
	
	public static final String FPS_REPEAT_ORDER_KEY = "REPEAT_ORDER_FLAG_";
	
	public static final String FPS_FIRSET_MSG_FLAG = "FIRST_MSG_FLAG_";
	
	public static final String FPS_MIN_TIME_INTERVALS_SP = "_4MIN:";
	
	
	public static final String FPS_PROVINCE_ORDER_FREQUENCY = "PROVINCE_FREQUENCY:";
	
	/**
	 * 失败订单延迟处理key
	 */
	public static final String FAILED_ORDER_DELAY_HANDLE = "FAILED_ORDER_DELAY_HANDLE";
	
	public static final String FAILED_ORDER_ITEM_GROUPID = "FAILED_ORDER_ITEM_GROUPID_";
	
	/**
	 * 恒瑞回调延迟处理key
	 */
	public static final String CMCC_SHHR_CALLBACK_DELAY_HANDLE = "CMCC_SHHR_CALLBACK_DELAY_HANDLE";
	
	/**
	 * 采购合同监控key
	 */
	public static final String PUR_CONTRACT_MONITOR = "PUR_CONTRACT_MONITOR:";
	/**采购合同每天消耗key*/
	public static final String FPS_PURCHASECONTRACT_USE_ = "FPS_PURCHASECONTRACT_USE_";
	/**销售合同每天消耗key*/
	public static final String FPS_CONTRACT_USE_ = "FPS_CONTRACT_USE_";
	
	public static final String PMS_PURCHASE_MONITOR_ = "PMS_PURCHASE_MONITOR_";
	
	/**调用微信接口时，获取spRefundId字段序号的key*/
	public static final String FPS_WECHAT_SPREFUNDID_ = "FPS_WECHAT_SPREFUNDID_";
	/**给微信查询接口用的的key*/
	public static final String FPS_WECHAT_ORDERCHECK_ = "FPS_WECHAT_ORDERCHECK_";
	/*****合作方回调总数key*****/
	public static final String CALLBACK_TOTAL_COUNT = "CALLBACK:";
	/*********合作方回调成功总数key**************/
	public static final String CALLBACK_SUCCESS_TOTAL_COUNT = "CBSUCCESS:";
	/*********指定客户回调总数key**************/
	public static final String CALLBACK_PARTNER_COUNT = "CBPARTNER:";
	/*********指定客户回调总数key**************/
	public static final String CALLBACK_PARTNER_SUCCESS_COUNT = "CBPARTNERSUC:";
	/**************活动成本控制key****************/
	public static final String ACTIVITY_COST_KEY = "ACTIVITY_COST";
	
	/**************接口调用频率控制key****************/
	public static final String INTERFACE_CALL_FREQUENCY = "interface.freq";
	
	public static final String CAPTCHA = "CAPTCHA";
	
	/**
	 * 异网bean前缀
	 */
	public static final String UNICOM_OR_MOBILE_ENTITY_PREFIX = "unicomorcmcc.msgBean:";
	/**
	 * 异网客户过滤hash key
	 */
	public static final String CUSTOMER_FILTER_KEY = "unicomorcmcc.customer.filter";
	
	/**
	 * 异网延时sortedset前缀
	 */
	public static final String UNICOM_OR_CMCC_DELAY_PREFIX = "unicomorcmcc.delay.prefix:";
	
	/**
	 * 异网暂停hash前缀
	 */
	public static final String UNICOM_OR_CMCC_PAUSE_PREFIX = "unicomorcmcc.pause.prefix:";
	
	/**
	 * 异网启动暂停订单hash key
	 */
	public static final String UNICOM_OR_CMCC_RESTART_PAUSE_ORDER_KEY = "unicomorcmcc.restart.key";
	
	/**
	 * 异网批量订单暂停或延时处理前缀
	 */
	public static final String UNICOM_OR_CMCC_ORDER_FIELD = "order.field:";
	
	/**
	 * 异网合同暂停或延时处理前缀
	 */
	public static final String UNICOM_OR_CMCC_CONTRACT_FIELD = "contract.field:";
	
	/**
	 * 异网客户暂停或延时处理前缀
	 */
	public static final String UNICOM_OR_CMCC_PARTNER_FIELD = "partner.field:";
	
	/**
	 * 异网通道暂停或延时处理前缀
	 */
	public static final String UNICOM_OR_CMCC_SUPPLIER_FIELD = "supplier.field:";
	
	
	public static final String JT_FAILED_ORDER_KEY = "jt.failed.order";
}
