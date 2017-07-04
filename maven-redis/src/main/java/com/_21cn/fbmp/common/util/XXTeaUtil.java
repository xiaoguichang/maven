package com._21cn.fbmp.common.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

/**
 * XXTea加解密实现
 */
public class XXTeaUtil {
	
	/**
	 * XXTea加密
	 * @param params
	 * @param appId
	 * @param appSecret
	 * @return
	 */
	public static String generateSecurityRequestUrl(String params,String appId, String appSecret) {
		String APP_SECRET=appSecret;
		String securityParams = "appId="+appId+"&version=v1.0&clientType=4&format=json";
    	try {
    		String cipherParas = XXTeaUtil.encrypt(params,"UTF-8",StringUtil.toHex(APP_SECRET.getBytes()));
    		String sigPlainText = ""+appId+"4jsonv1.0"+cipherParas.toUpperCase();
        	byte[] data = StringUtil.hex2Bytes(StringUtil.toHex(sigPlainText.getBytes()));
        	byte[] key = StringUtil.hex2Bytes(StringUtil.toHex(APP_SECRET.getBytes()));
			String signature = encodeHmacSHA1(data, key);
			securityParams=securityParams+"&paras="+cipherParas.toUpperCase()+"&sign="+signature.toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return securityParams;
	}
	
	public static String encodeHmacSHA1(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeyException
			 {
		// 还原密钥
		SecretKey secretKey = new SecretKeySpec(key, "HmacSHA1");
		// 实例化Mac
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		// 初始化mac
		mac.init(secretKey);
		// 执行消息摘要
		byte[] digest = mac.doFinal(data);
		return new HexBinaryAdapter().marshal(digest);// 转为十六进制的字符串
	}

	/**
	 * 加密
	 * @param plain 明文
	 * @param charset 明文字符编码
	 * @param hexKey 十六进制字符串形式密钥
	 * @return 十六进制字符串形式密文
	 * @throws UnsupportedEncodingException 
	 * @throws Exception
	 */
	public static
	String encrypt(String plain, String charset, String hexKey) throws UnsupportedEncodingException 
			{
		if (plain == null || charset == null || hexKey == null) {
				return null;
		}
		
		return StringUtil.toHex(
					encrypt(plain.getBytes(charset), StringUtil.hex2Bytes(hexKey)));
	}
	
	/**
	 * 解密
	 * @param hexCipher 十六进制字符串形式密文
	 * @param charset 明文字符编码
	 * @param hexKey 十六进制字符串形式密钥
	 * @return 明文
	 * @throws UnsupportedEncodingException 
	 * @throws Exception
	 */
	public static
	String decrypt(String cipherHex, String charset, String hexKey) throws UnsupportedEncodingException {
		if (cipherHex == null || charset == null || hexKey == null) {
			return null;
		}
		byte[] b = decrypt(StringUtil.hex2Bytes(cipherHex), StringUtil.hex2Bytes(hexKey));
		if(b==null) {
			return null;
		} else {			
			return new String(b,charset);
		}
	}
	
	/**
	 * 加密
	 * @param data 明文
	 * @param key 密钥
	 * @return
	 */
	public static
	byte[] encrypt(byte[] plainData, byte[] key) {
		if (plainData == null || plainData.length == 0 || key == null) {
			return null;
		}
		return toByteArray(
					encrypt(toIntArray(plainData, true), toIntArray(key, false)),
					false);
	}

	/**
	 * 解密
	 * @param data 密文
	 * @param key 密钥
	 * @return 明文
	 */
	public static
	byte[] decrypt(byte[] cipherData, byte[] key) {
		if (cipherData == null || cipherData.length == 0 || key == null) {
			return null;
		}
		return toByteArray(
					decrypt(toIntArray(cipherData, false), toIntArray(key, false)),
					true);
	}

	/**
	 * Encrypt data with key.
	 * 
	 * @param v
	 * @param k
	 * @return
	 */
	private static
	int[] encrypt(int[] v, int[] k) {
		int n = v.length - 1;

		if (n < 1) {
			return v;
		}
		if (k.length < 4) {
			int[] key = new int[4];

			System.arraycopy(k, 0, key, 0, k.length);
			k = key;
		}
		int z = v[n], y = v[0], delta = 0x9E3779B9, sum = 0, e;
		int p, q = 6 + 52 / (n + 1);

		while (q-- > 0) {
			sum = sum + delta;
			e = sum >>> 2 & 3;
			for (p = 0; p < n; p++) {
				y = v[p + 1];
				z = v[p] += (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y)
						+ (k[p & 3 ^ e] ^ z);
			}
			y = v[0];
			z = v[n] += (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y)
					+ (k[p & 3 ^ e] ^ z);
		}
		return v;
	}

	/**
	 * Decrypt data with key.
	 * 
	 * @param v
	 * @param k
	 * @return
	 */
	private static
	int[] decrypt(int[] v, int[] k) {
		int n = v.length - 1;

		if (n < 1) {
			return v;
		}
		if (k.length < 4) {
			int[] key = new int[4];

			System.arraycopy(k, 0, key, 0, k.length);
			k = key;
		}
		int z = v[n], y = v[0], delta = 0x9E3779B9, sum, e;
		int p, q = 6 + 52 / (n + 1);

		sum = q * delta;
		while (sum != 0) {
			e = sum >>> 2 & 3;
			for (p = n; p > 0; p--) {
				z = v[p - 1];
				y = v[p] -= (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y)
						+ (k[p & 3 ^ e] ^ z);
			}
			z = v[n];
			y = v[0] -= (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y)
					+ (k[p & 3 ^ e] ^ z);
			sum = sum - delta;
		}
		return v;
	}

	/**
	 * Convert byte array to int array.
	 * 
	 * @param data
	 * @param includeLength
	 * @return
	 */
	private static
	int[] toIntArray(byte[] data, boolean includeLength) {
		int n = (((data.length & 3) == 0) ? (data.length >>> 2)
				: ((data.length >>> 2) + 1));
		int[] result;

		if (includeLength) {
			result = new int[n + 1];
			result[n] = data.length;
		} else {
			result = new int[n];
		}
		n = data.length;
		for (int i = 0; i < n; i++) {
			result[i >>> 2] |= (0x000000ff & data[i]) << ((i & 3) << 3);
		}
		return result;
	}

	/**
	 * Convert int array to byte array.
	 * 
	 * @param data
	 * @param includeLength
	 * @return
	 */
	private static
	byte[] toByteArray(int[] data, boolean includeLength) {
		int n = data.length << 2;
		if (includeLength) {
			int m = data[data.length - 1];

			if (m > n || m <= 0) {
				return null;
			} else {
				n = m;
			}
		}
		byte[] result = new byte[n];

		for (int i = 0; i < n; i++) {
			result[i] = (byte) ((data[i >>> 2] >>> ((i & 3) << 3)) & 0xff);
		}
		return result;
	}
}
