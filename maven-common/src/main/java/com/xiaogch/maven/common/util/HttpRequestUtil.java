package com.xiaogch.maven.common.util;

import com.xiaogch.maven.common.exception.HttpRequestException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class HttpRequestUtil {
	
	/** http 请求timeout  */
	private final static int timeout = 60000; 
	
	/**
	 * 发送post请求，若请求成功返回响应信息，否则抛出HttpRequestException异常，键值对的方式
	 * @param url 请求地址 
	 * @param requestParameter 请求参数
	 * @param connectTimeout
	 * @param socketTimeOut
	 * @return http response 返回的数据
	 * @throws HttpRequestException 请求异常
	 */
	public static String doPostAndReturnString(String url , Map<String , String> requestParameter , int connectTimeout , int socketTimeOut) throws HttpRequestException {
		HttpPost httpPost = new HttpPost(url);
		RequestConfig config = getRequestConfig(connectTimeout , socketTimeOut);
		httpPost.setConfig(config);
		List<NameValuePair> nameValuePairs = getNameValuePairs(requestParameter);
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs , "utf-8"));
		} catch (UnsupportedEncodingException e) {
			throw new HttpRequestException(e.getMessage() , e);
		}
		return sendReqeust(httpPost);
	}

	/**
	 * 发送post请求，若请求成功返回响应信息，否则抛出HttpRequestException异常，键值对的方式
	 * @param url 请求地址
	 * @param requestParameter 请求参数
	 * @return http response 返回的数据
	 * @throws HttpRequestException 请求异常
	 */
	public static String doPostAndReturnString(String url , Map<String , String> requestParameter) throws HttpRequestException {
		return doPostAndReturnString(url , requestParameter , timeout , timeout);
	}


	public static String doGetAndReturnString(String url , int timeOut) throws HttpRequestException {
		HttpGet httpGet = new HttpGet(url);
		RequestConfig config = getRequestConfig(timeOut , timeOut);
		httpGet.setConfig(config);
		return sendReqeust(httpGet);
	}

	private static String sendReqeust(HttpUriRequest httpUriRequest) throws HttpRequestException {
		HttpClient client = HttpClients.createDefault();
		HttpResponse response;
		try {
			response = client.execute(httpUriRequest);
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

	private static List<NameValuePair> getNameValuePairs(Map<String , String> requestParameter) {
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		if (requestParameter != null && !requestParameter.isEmpty()) {
			Set<String> keys = requestParameter.keySet();
			for (String key : keys) {
				nameValuePairs.add(new BasicNameValuePair(key, requestParameter.get(key)));
			}
		}
		return nameValuePairs;
	}

	private static RequestConfig getRequestConfig(int connectTimeout , int socketTimeout) {
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(connectTimeout)
				.setSocketTimeout(socketTimeout)
				.build();
		return config;
	}






//	public static void main(String[] argvs) {
//		try {
//			Map<String , String> requestParameter = new HashMap<String , String>();
//			requestParameter.put("employee_263", "xiaoguichang");
//			requestParameter.put("app", "dailyReport");
//			requestParameter.put("app_token", "imwCAt29zoyB6AYwGxhOfg");
//			String result = doPostAndReturnString("http://localhost:8080/dailyreport-war/j_spring_security_check1?j_username1=xiaoguichang&j_password=1235", requestParameter);
//			System.err.println(result);
//		} catch (HttpRequestException e) {
//			System.out.println(e.getMessage());
//		}
//	}


}
