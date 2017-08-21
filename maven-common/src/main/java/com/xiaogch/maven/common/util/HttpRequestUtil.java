package com.xiaogch.maven.common.util;

import com.xiaogch.maven.common.exception.HttpRequestException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

public class HttpRequestUtil {
	
	/** http 请求timeout  */
	private final static int timeout = 60000; 
	
	/**
	 * 发送post请求，若请求成功返回响应信息，否则抛出HttpRequestException异常
	 * @param url 请求地址 
	 * @param requestParameter 请求参数
	 * @return
	 * @throws HttpRequestException 请求异常
	 */
	public static String doPostAndReturnString(String url , Map<String , String> requestParameter) throws HttpRequestException {
		HttpPost httpPost = new HttpPost(url);
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(timeout)
				.setConnectTimeout(timeout)
				.setSocketTimeout(timeout)
				.build();
		httpPost.setConfig(config);
		
		HttpClient client = HttpClients.createDefault();
		HttpResponse response;
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		if (requestParameter != null && !requestParameter.isEmpty()) {
			Set<String> keys = requestParameter.keySet();
			for (String key : keys) {
				nameValuePairs.add(new BasicNameValuePair(key, requestParameter.get(key)));
			}
		}
	
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs , "utf-8"));
			response = client.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				return EntityUtils.toString(response.getEntity());
			} else {
				StringBuilder sb = new StringBuilder(response.getStatusLine().toString());
				sb.append("\n");
				sb.append(EntityUtils.toString(response.getEntity()));
				throw new HttpRequestException(sb.toString());
			}
		} catch (ClientProtocolException e) {
			throw new HttpRequestException(e.getMessage() , e);
		} catch (IOException e) {
			throw new HttpRequestException(e.getMessage() , e);
		}
	}
	
	public static void main(String[] argvs) {
		try {
			Map<String , String> requestParameter = new HashMap<String , String>();
			requestParameter.put("employee_263", "xiaoguichang");
			requestParameter.put("app", "dailyReport");
			requestParameter.put("app_token", "imwCAt29zoyB6AYwGxhOfg");
			String result = doPostAndReturnString("http://localhost:8080/dailyreport-war/j_spring_security_check1?j_username1=xiaoguichang&j_password=1235", requestParameter);
			System.err.println(result);
		} catch (HttpRequestException e) {
			System.out.println(e.getMessage());
		}
	}
}
