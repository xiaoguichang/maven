package com._21cn.fbmp.common.entity;

import java.io.Serializable;

import org.springframework.util.StringUtils;

/**
 * @desc  全局信息
 * @since JDK 1.6
 * @version 1.0
 * @author pet
 * @date 2013/10/30
 */
/**
 * @author connie
 *
 */
public class MsgBean implements Serializable{

	private static final long serialVersionUID = 1112450813425084624L;
	
	/**
	 * 消息体ID
	 */
	private String msgId = "-";
	
	/**
	 * 受理号码
	 */
	private String phoneId = "-";
	
	/**
	 * CRM编码
	 */
	private String crmCode = "-";
	
	/**
	 * 地市编码
	 */
	private String regionCode = "-";
	
	/**
	 * 合作方ID（平台提供）
	 */
	private int  partnerId = 0;
	
	/**
	 * 合同ID
	 */
	private String contractId = "-";
	
	/**
	 * 销售品ID（平台提供）
	 */
	private int platOfferId = 0;
	
	/**
	 * 平台销售品名称
	 */
	private String platOfferName = "-";
	
	/**
	 * 请求流水号(合作方提供，请求唯一标识)
	 */
	private String requestNo = "-";
	
	/**
	 * 来源渠道ID（1-web，2-wap，3-android，4-ios..）
	 */
	private int channelId = 0;
	
	/**
	 * 返回值类型
	 */
	private int resultType = 0;
	
	/**
	 * 订购状态 
	 */
	private String resultCode = "00000";
	
	/**
	 * 应答编码：1 - 成功，0 - 失败。
	 */
	private int reply = 1;
	
	/**
	 * CRM销售品付费模式0为预付费，1为后付费,2为不区分
	 */
	private int crmBillMode = 2;
	
	/**
	 * 流量控制模式0为需要，1为不需要控制
	 */
	private int controlType = 0;
	
	/**
	 * 为了按时间清楚global队列了的msgBean
	 */
	private String orderTime = "-";
	
	/**
	 * 订购类型：1–订购；2–退订
	 */
	private int orderType = 1;
	
	/**********2013.12.4添加**************************/
	/**
	 * 业务编码
	 */
	private String serviceCode = "-";
	/**
	 * ip
	 */
	private String ip = "-";

	/**
	 * 手机imsi码
	 */
	private String imsi = "-";
	
	/**
	 * 手机号验证下发检验码
	 */
	private String checkCode = "-";

	/**
	 * 订单号
	 */
	private String orderId = "0";

	/**
	 * 流量（单位：MB）
	 */
	private int traffic = 0;
	
	/**
	 * 单价（单位：元）
	 */
	private int price = 0;
	
	/**
	 * 密钥
	 */
	private String secretKey = "-";
	
	/**
	 * 向量（AES加解密算法需要初始化一个向量）
	 */
	private String  vector = "-";
	
	private String callBackJson = "-";
	
	/**
	 * 流量包描述
	 */
	private String trafficDesc = "-";
	
	/**
	 * 返回结果集
	 */
	private String resultSet = "-";
	
	/**
	 * 活动Id
	 */
	private int activityId = 0;
	/**
	 * 卡类型
	 */
	private Integer cardType = 0;
	/**
	 * 卡流量
	 */
	private Integer cardTraffic = 0;
	
	/**
	 * 卡价格
	 */
	private Integer cardPrice = 0;
	
	/**
	 * 使用范围
	 */
	private Integer scope = 0;
	
	/**
	 * CRM销售品
	 */
	private String crmOfferId = "-";
	
	/**
	 * 交易流水号
	 */
	private String transactionId = "-";
	
	/**
	 * 原交易流水号
	 */
	private String oldMsgId = "-";
	
	/**
	 * 运营商
	 */
	private Integer operator = 0;
	
	
	/** 组织类型  1-运营中心  2-合作方 3-省公司 4-集团 5-综合平台 6-世纪龙 7-地市分公司 8-集团政企（4和7暂时没有使用，预留）9-不参与结算的合作方（暂时不使用）10-中小企业 **/
	private String orgType = "0";
	
	/**
	 * crm_offer_info表的主键 
	 */
	private int offerId = 0;
	
	/**
	 * 短信类型：1-全国通用流量包订购短信通知；2-省内流量包订购短信通知；3-失败订购短信通知（欠费、套餐互斥）
	 */
	private int smsType = 0;
	
	/**
	 * 折扣
	 */
	private double discount = 0.00;
	
	/**
	 * 签约主体摊分比例（结算模式为地市佣金模式)
	 */
	private double shareRatio = 0.00;
	
	/**
	 * 结算方式（销售方为 综合平台、集团政企、省公司时此字段取值为1或者2，销售方为世纪龙时此字段取值为3)
	   1：阶梯差额流量结算 
	   2：一次性付款结算 
	   3：阶梯单价结算
	 */
	private int quotationMode = 0;
	
	/**
	 * 合同金额，后付费时为授权金额
	 */
	private Double authorizedAmounts = 0d;
	
	/**
	 * 打折之后每个流量包的实际单价，订购失败后授权金额控制用,单位：分
	 */
	private int realPrice = 0;

	/**
	 * 流量指向 1-定向 2-非定向
	 */
	private int orientation = 0;
	
	/**
	 *流量类型 1-流量包 2-流量池
	 */
	private int trafficType = 0;
	
	/**
	 * 是否自动续订 0-否 1-是
	 */
	private int autoOrder = 2;
	
	/**
	 *crm返回码
	 */
	private String rspCode = "-";
	
	/**
	 *crm返回码描述
	 */
	private String rspDesc = "-";
	
	/**
	 * 采购合同ID
	 */
	private String purchaseContractId = "0";
	/**
	 * 采购合同签订的流量包单价
	 */
	private String purchaseContractPrice = "0";
	
	/**
	 * 采购合同签订的折扣
	 */
	private String purchaseContractDiscount = "0";
	
	/**
	 * 采购合同签订的province_code
	 */
	private String purchaseContractProvinceCode = "-";
	
	/**
	 * 采购合同授权金额
	 */
	private long purchaseAuthorizedAmount = 0;
	
	/**
	 * 合作模式 1-通用包 2-定向包 3-定向池  对应采购合同的product_mode 产品模式，获取采购合同信息用
	 */
	private int cooperationMode = 0;
	
	/**
	 * 订购查询接口，开始时间
	 */
	private long startTime = 0;

	/**
	 * 订购查询接口，截至时间
	 */
	private long endTime = 0;
	
	/**
	 * 流量归属地
	 */
	private String trafficAttribution = "0";
	
	/**
	 * 激活码
	 */
	private String activationCode = "-";
	
	/**
	 *  激活码生成方式
	 */
	private int  generateMethod = 0; 
	
	/**
	 * 结算模式: 1-集团佣金模式   2-流量代理模式  3-大收大支模式   4-省内支撑模式  5-省内佣金模式  6-三网组合模式
	 */
	private int settleMode;
	
	/**
	 * 订单项分组ID,全局唯一，中枢队列的key
	 */
	private String orderItemGroupId = "-";
	
	private Integer isAgent = 0;//是否代理商
	
	private Integer isFreeSettlement;//是否免结算
	
	private Integer reSend = 0;
	
	/**
	 * 生效类型：0-当月生效，1-次月生效
	 */
	private int effectType = 2;//默认次月生效
	/**
	 * 新msgId
	 */
	private String newMsgId = "-";
	
	private Integer supplierId;
	
	private Integer durationType = 1;//时长类型（1-月包 2-日包 3-3日包 4-季包 5-半年包）
	
	public String getNewMsgId() {
		return newMsgId;
	}
	public void setNewMsgId(String newMsgId) {
		this.newMsgId = newMsgId;
	}
	public int getEffectType() {
		return effectType;
	}
	public void setEffectType(int effectType) {
		this.effectType = effectType;
	}
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public String getOrderItemGroupId() {
		return orderItemGroupId;
	}
	public void setOrderItemGroupId(String orderItemGroupId) {
		this.orderItemGroupId = orderItemGroupId;
	}
	public int getSettleMode() {
		return settleMode;
	}
	public void setSettleMode(int settleMode) {
		this.settleMode = settleMode;
	}
	public int getGenerateMethod() {
		return generateMethod;
	}
	public void setGenerateMethod(int generateMethod) {
		this.generateMethod = generateMethod;
	}
	public String getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	public int getCooperationMode() {
		return cooperationMode;
	}
	public void setCooperationMode(int cooperationMode) {
		this.cooperationMode = cooperationMode;
	}
	public String getPurchaseContractId() {
		return purchaseContractId;
	}
	public void setPurchaseContractId(String purchaseContractId) {
		this.purchaseContractId = purchaseContractId;
	}
	public String getPurchaseContractPrice() {
		return purchaseContractPrice;
	}
	public void setPurchaseContractPrice(String purchaseContractPrice) {
		this.purchaseContractPrice = purchaseContractPrice;
	}
	public String getPurchaseContractDiscount() {
		return purchaseContractDiscount;
	}
	public void setPurchaseContractDiscount(String purchaseContractDiscount) {
		this.purchaseContractDiscount = purchaseContractDiscount;
	}
	public String getPurchaseContractProvinceCode() {
		return purchaseContractProvinceCode;
	}
	public void setPurchaseContractProvinceCode(String purchaseContractProvinceCode) {
		this.purchaseContractProvinceCode = purchaseContractProvinceCode;
	}
	public long getPurchaseAuthorizedAmount() {
		return purchaseAuthorizedAmount;
	}
	public void setPurchaseAuthorizedAmount(long purchaseAuthorizedAmount) {
		this.purchaseAuthorizedAmount = purchaseAuthorizedAmount;
	}
	
	public String getRspCode() {
		return rspCode;
	}
	public void setRspCode(String rspCode) {
		if (StringUtils.hasText(rspCode) && rspCode.length() > 10) {
			rspCode = rspCode.substring(0, 8);
		}
		this.rspCode = rspCode;
	}
	public String getRspDesc() {
		return rspDesc;
	}
	public void setRspDesc(String rspDesc) {
		if (StringUtils.hasText(rspDesc) && rspDesc.length() > 500) {
			rspDesc = rspDesc.substring(0, 500);
		}
		this.rspDesc = rspDesc;
	}
	public int getTrafficType() {
		return trafficType;
	}
	public void setTrafficType(int trafficType) {
		this.trafficType = trafficType;
	}
	public int getOrientation() {
		return orientation;
	}
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
	public String getOldMsgId() {
		return oldMsgId;
	}
	public void setOldMsgId(String oldMsgId) {
		this.oldMsgId = oldMsgId;
	}
	
	public String getCrmOfferId() {
		return crmOfferId;
	}
	public void setCrmOfferId(String crmOfferId) {
		this.crmOfferId = crmOfferId;
	}
	public void setResultSet(String resultSet) {
		this.resultSet = resultSet;
	}
	public String getResultSet() {
		return resultSet;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	public String getCheckCode() {
		return checkCode;
	}
	
	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getCrmCode() {
		return crmCode;
	}
 
	public void setCrmCode(String crmCode) {
		this.crmCode = crmCode;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public int getReply() {
		return reply;
	}

	public void setReply(int reply) {
		this.reply = reply;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getPhoneId() {
		return phoneId;
	}

	public String getCallBackJson() {
		return callBackJson;
	}
	public void setCallBackJson(String callBackJson) {
		this.callBackJson = callBackJson;
	}
	public void setPhoneId(String phoneId) {
		this.phoneId = phoneId;
	}

	public int getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}
	
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public int getPlatOfferId() {
		return platOfferId;
	}

	public void setPlatOfferId(int platOfferId) {
		this.platOfferId = platOfferId;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public int getResultType() {
		return resultType;
	}
	public void setResultType(int resultType) {
		this.resultType = resultType;
	}
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public int getCrmBillMode() {
		return crmBillMode;
	}
	public void setCrmBillMode(int crmBillMode) {
		this.crmBillMode = crmBillMode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	public int getTraffic() {
		return traffic;
	}
	public void setTraffic(int traffic) {
		this.traffic = traffic;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public String getVector() {
		return vector;
	}
	public void setVector(String vector) {
		this.vector = vector;
	}
	public int getControlType() {
		return controlType;
	}
	public void setControlType(int controlType) {
		this.controlType = controlType;
	}
	
	public String getTrafficDesc() {
		return trafficDesc;
	}
	public void setTrafficDesc(String trafficDesc) {
		this.trafficDesc = trafficDesc;
	}
	
	public Integer getCardType() {
		return cardType;
	}
	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}
	public Integer getCardTraffic() {
		return cardTraffic;
	}
	public void setCardTraffic(Integer cardTraffic) {
		this.cardTraffic = cardTraffic;
	}
	public Integer getCardPrice() {
		return cardPrice;
	}
	public void setCardPrice(Integer cardPrice) {
		this.cardPrice = cardPrice;
	}
	public Integer getScope() {
		return scope;
	}
	public void setScope(Integer scope) {
		this.scope = scope;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public Integer getOperator() {
		return operator;
	}
	public void setOperator(Integer operator) {
		this.operator = operator;
	}
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	
	public int getSmsType() {
		return smsType;
	}
	public void setSmsType(int smsType) {
		this.smsType = smsType;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getShareRatio() {
		return shareRatio;
	}
	public void setShareRatio(double shareRatio) {
		this.shareRatio = shareRatio;
	}
	public int getQuotationMode() {
		return quotationMode;
	}
	public void setQuotationMode(int quotationMode) {
		this.quotationMode = quotationMode;
	}
	public Double getAuthorizedAmounts() {
		return authorizedAmounts;
	}
	public void setAuthorizedAmounts(Double authorizedAmounts) {
		this.authorizedAmounts = authorizedAmounts;
	}
	public int getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(int realPrice) {
		this.realPrice = realPrice;
	}
	
	public String getPlatOfferName() {
		return platOfferName;
	}
	public void setPlatOfferName(String platOfferName) {
		this.platOfferName = platOfferName;
	}
	
	public int getAutoOrder() {
		return autoOrder;
	}
	public void setAutoOrder(int autoOrder) {
		this.autoOrder = autoOrder;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public String getTrafficAttribution() {
		return trafficAttribution;
	}
	public void setTrafficAttribution(String trafficAttribution) {
		this.trafficAttribution = trafficAttribution;
	}
	
	public Integer getIsAgent() {
		return isAgent;
	}
	public void setIsAgent(Integer isAgent) {
		this.isAgent = isAgent;
	}
	public Integer getIsFreeSettlement() {
		return isFreeSettlement;
	}
	public void setIsFreeSettlement(Integer isFreeSettlement) {
		this.isFreeSettlement = isFreeSettlement;
	}
	
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	public Integer getDurationType() {
		return durationType;
	}
	public void setDurationType(Integer durationType) {
		this.durationType = durationType;
	}
	public Integer getReSend() {
		return reSend;
	}
	public void setReSend(Integer reSend) {
		this.reSend = reSend;
	}
	/**
	 * 根据IMSI查询手机号码
	 * @return
	 */
	public String responseGetPhoneIDByIMSI(){
		return "{\"phone_id\":\"" + phoneId +"\",\"result_code\":\"" + resultCode + "\"}";
	}
	
	/**
	 * 获取短信验证码接口
	 * @return
	 */
	public String responseGetVerificationCode(){
		return "{\"request_no\":\"" + requestNo + "\",\"verification_code\":\"" + checkCode + "\",\"result_code\":\"" + resultCode + "\"}";
	}
	
	/**
	 * 订购结果查询接口
	 * @return
	 */
	public String responseQueryOrderResult(){
		return "{\"result_code\":\"" + resultCode +  "\",\"count\":0}";
	}
	
	/**
	 * 订购接口的响应
	 * @return
	 */
	public String toCallBackJsonString(){
		StringBuilder result = new StringBuilder();
		result.append("{").append("\"request_no\":"+"\"" +requestNo+ "\"").append(",\"result_code\":"+"\""+resultCode+ "\"").append("}");
		return result.toString();
	}
	
	/**
	 * 根据上网IP查询所属省份线上业务接口的响应
	 * @return
	 */
	public String toCallBackSupportJson(){
		StringBuilder result = new StringBuilder();
		result.append("{")
		      .append("\"result_set\":").append("\"").append(""+resultSet+"").append("\",")
		      .append("\"request_no\":"+"\"" +requestNo+ "\"").append(",\"result_code\":"+"\""+resultCode+ "\"").append("}");
		return result.toString();
	}
	
	/**
	 * 异步通知合作方参数
	 * @return
	 */
	public String toAsnycNotifyJsonString(){
		StringBuilder result = new StringBuilder();
		String tmp = "-".equals(oldMsgId) ? msgId : oldMsgId;
		result.append("{").append("\"request_no\":"+"\"" + requestNo + "\"").append(",\"result_code\":"+"\"" +resultCode+ "\"").append(",\"msg_id\":"+"\"" + tmp + "\"").append("}");
		return result.toString();
	}
	
	/**
	 * 异步通知合作方参数
	 * @return
	 */
	public String toActivationCodeNotifyJsonString(){
		StringBuilder result = new StringBuilder();
		String tmp = "-".equals(oldMsgId) ? msgId : oldMsgId;
		int realPrice = (int) Math.ceil(discount*price);
		result.append("{").append("\"request_no\":"+"\"" + requestNo + "\"").append(",\"result_code\":"+"\"" +resultCode+ "\"").append(",\"msg_id\":"+"\"" + tmp + "\"")
		.append(",\"ticket_no\":"+"\"" + activationCode + "\"").append(",\"phone_id\":"+"\"" + phoneId + "\"");
		if("00000".equals(resultCode)){
			result.append(",\"real_price\":"+"\"" +realPrice+ "\"");
		}
		result.append("}");
		return result.toString();
	}
	
	@Override
	public String toString() {
		return "MsgBean [msgId=" + msgId + ", phoneId=" + phoneId
				+ ", crmCode=" + crmCode + ", regionCode=" + regionCode
				+ ", partnerId=" + partnerId + ", contractId=" + contractId
				+ ", platOfferId=" + platOfferId + ", platOfferName="
				+ platOfferName + ", requestNo=" + requestNo + ", channelId="
				+ channelId + ", resultType=" + resultType + ", resultCode="
				+ resultCode + ", reply=" + reply + ", orderTime=" + orderTime
				+ ", orderType=" + orderType + ", orderId=" + orderId
				+ ", traffic=" + traffic + ", price=" + price + ", activityId="
				+ activityId + ", crmOfferId=" + crmOfferId
				+ ", transactionId=" + transactionId + ", oldMsgId=" + oldMsgId
				+ ", operator=" + operator + ", orgType=" + orgType
				+ ", offerId=" + offerId + ", discount=" + discount
				+ ", orientation=" + orientation + ", trafficType="
				+ trafficType + ", autoOrder=" + autoOrder + ", rspCode="
				+ rspCode + ", rspDesc=" + rspDesc + ", purchaseContractId="
				+ purchaseContractId + ", purchaseContractPrice="
				+ purchaseContractPrice + ", purchaseContractDiscount="
				+ purchaseContractDiscount + ", trafficAttribution="
				+ trafficAttribution + ", generateMethod=" + generateMethod
				+ ", orderItemGroupId=" + orderItemGroupId + ", effectType="
				+ effectType + "]";
	}

	
}




