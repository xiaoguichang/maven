package com._21cn.fbmp.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA1加密
 * @author Alex
 */
public class SHA1 {
	/**
	 * SHA1加密 使用消息摘要MessageDigest 处理
	 * 
	 * @throws Exception
	 */
	public static String encodeBySHA(String str) {
		MessageDigest sha1;
		try {
			sha1 = MessageDigest.getInstance("SHA1");
			sha1.update(str.getBytes()); // 先更新摘要
			byte[] digest = sha1.digest(); // 再通过执行诸如填充之类的最终操作完成哈希计算。在调用此方法之后，摘要被重置。

			/*
			 * 使用指定的 byte 数组对摘要进行最后更新，然后完成摘要计算。 也就是说，此方法首先调用 update(input)， 向 update
			 * 方法传递 input 数组，然后调用 digest()。
			 */
			// byte[] digest = sha1.digest(str.getBytes());

			String hex = toHex(digest);
			return hex;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "SHA1 encode failed.";
		}
	}

	/**
	 * sha1 摘要转16进制
	 * 
	 * @param digest
	 * @return
	 */
	private static String toHex(byte[] digest) {
		StringBuilder sb = new StringBuilder();
		int len = digest.length;

		String out = null;
		for (int i = 0; i < len; i++) {
			// out = Integer.toHexString(0xFF & digest[i] + 0xABCDEF); //加任意
			// salt
			out = Integer.toHexString(0xFF & digest[i]);// 原始方法
			if (out.length() == 1) {
				sb.append("0");// 如果为1位 前面补个0
			}
			sb.append(out);
		}
		return sb.toString();
	}
}
