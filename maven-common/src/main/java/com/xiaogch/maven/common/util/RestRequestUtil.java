/**
 * ProjectName:dailyreport-util<BR>
 * File name:  RestRequestUtil.java     <BR>
 * Author: libin  <BR>
 * Project:dailyreport-util    <BR>
 * Version: v 1.0      <BR>
 * Date: 2017年6月16日 下午4:48:25 <BR>
 * Description:     <BR>
 * Function List:  <BR>
 */ 

package com.shangde.dailyreport.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Deprecated
public class RestRequestUtil {

	/**
	 * 
	 * 功能描述：REST请求工具类
	 *
	 * @param restUri 请求URL
	 * @param method 请求方法 POST GET
	 * @return
	 * 
	 * @author Libin
	 *
	 * @since 2017年6月16日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	
	private static final Logger logger = LoggerFactory.getLogger(RestRequestUtil.class);
	
	public static String restRequestStr(String restUri, HttpMethod method, MultiValueMap<String, String> paramMap ) {
		ResponseEntity<String> response = null;
		String str = null;
		
		if (logger.isDebugEnabled()) {
			logger.debug("restRequestStr(String restUri, HttpMethod method={}) - start",restUri+","+method);
		}
		
		try {
			MultiValueMap<String, String> paramMapRequest = new LinkedMultiValueMap<String, String>();
			paramMapRequest.putAll(paramMap);
			RestTemplate restTemplate = new RestTemplate();
			MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
			header.set("Accept", "application/json");
			HttpEntity<?> entity = new HttpEntity<Object>(header);
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(restUri).queryParams(paramMapRequest);
			response = restTemplate.exchange(builder.build().encode().toString(), method, entity,String.class);
			if (null != response) {
				if (Constants.RESPONSE_SUCCESS_CODE.equals(response.getStatusCode().toString())) {
					str = response.getBody();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("restRequestStr(String restUri, HttpMethod method={}) - error：",e.getMessage());
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("restRequestStr(String restUri, HttpMethod method={}) - end",restUri+","+method);
		}
		return str;
	}
}
