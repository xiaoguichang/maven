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
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.*;

public class HttpRequestUtil {
	
	/** http 请求 connectTimeout  */
	private final static int CONNECT_TIMEOU = 60000;

	/** http 请求 soketTimeout  */
	private final static int SOCKET_TIMEOU = 60000;

	/**
	 * 发送post请求，若请求成功返回响应信息，否则抛出HttpRequestException异常，键值对的方式
	 * @param url 请求地址
	 * @param requestParameter 请求参数
	 * @param connectTimeout 连接超时
	 * @param socketTimeOut 读取超时
	 * @return http response 返回的数据
	 * @throws HttpRequestException 请求异常
	 */
	public static String doPostAndReturnString(String url , String requestParameter , int connectTimeout , int socketTimeOut) throws HttpRequestException {
		HttpPost httpPost = new HttpPost(url);
		RequestConfig config = getRequestConfig(connectTimeout , socketTimeOut);
		httpPost.setConfig(config);
		try {
			httpPost.setEntity(new StringEntity(requestParameter , "utf-8"));
		} catch (UnsupportedCharsetException e) {
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
	public static String doPostAndReturnString(String url , String requestParameter) throws HttpRequestException {
		return doPostAndReturnString(url , requestParameter , CONNECT_TIMEOU , SOCKET_TIMEOU);
	}
	
	/**
	 * 发送post请求，若请求成功返回响应信息，否则抛出HttpRequestException异常，键值对的方式
	 * @param url 请求地址 
	 * @param requestParameter 请求参数
	 * @param connectTimeout 连接超时
	 * @param socketTimeOut 读取超时
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
		return doPostAndReturnString(url , requestParameter , CONNECT_TIMEOU , SOCKET_TIMEOU);
	}


	/**
	 * 发送get请求，若请求成功返回响应信息，否则抛出HttpRequestException异常
	 * @param url 请求地址
	 * @return http response 返回的数据
	 * @throws HttpRequestException 请求异常
	 */
	public static String doGetAndReturnString(String url) throws HttpRequestException {
		return doGetAndReturnString(url , CONNECT_TIMEOU , SOCKET_TIMEOU);
	}
	/**
	 * 发送get请求，若请求成功返回响应信息，否则抛出HttpRequestException异常
	 * @param url 请求地址
	 * @param connectTimeout 连接超时
	 * @param socketTimeOut 读取超时
	 * @return http response 返回的数据
	 * @throws HttpRequestException 请求异常
	 */
	public static String doGetAndReturnString(String url , int connectTimeout , int socketTimeOut) throws HttpRequestException {
		HttpGet httpGet = new HttpGet(url);
		RequestConfig config = getRequestConfig(connectTimeout , socketTimeOut);
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


}
