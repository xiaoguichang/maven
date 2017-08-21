package com.xiaogch.maven.common.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;


public class EmailUtil {
	
	/**
	 * 发送邮件 
	 * @param title 邮件标题
	 * @param content 邮件内容
	 * @param propties 邮件发送配置信息<br>mail.smtp.host, mail.smtp.from , mail.smtp.user , mail.smtp.password
	 * @param addresses 收件人列表
	 * @throws MessagingException
	 */
	public static void sendTextEmail(String title , String content , Properties propties , String...addresses) throws Exception {
		Assert.isTrue(propties != null && !propties.isEmpty() , "email properties can't be null or empty");
		Assert.isTrue(StringUtils.hasText(title), "emial title can't be null or empty");
		Assert.isTrue(StringUtils.hasText(content), "emial content can't be null or empty");
		Assert.isTrue((addresses != null && addresses.length != 0), "emial address can't be null or empty");
		parameterCheck(propties);
		Session session = getSession(propties);
		MimeMessage message = new MimeMessage(session);
		message.setText(content);
		message.setSubject(title, "utf-8");
//		设置抄送人员
//		message.setRecipients(RecipientType.BCC, addresses);
//		设置暗抄送人员
//		message.setRecipient(RecipientType.CC, address);
		Address[] eamilAddress = new InternetAddress[addresses.length];
		int index = 0;
		for (String address : addresses) {
			eamilAddress[index++] = new InternetAddress(address);
		}
//		设置收件人
		message.setRecipients(RecipientType.TO, eamilAddress);
		Transport.send(message);
	}
	
	private static Session getSession(final Properties propties) {
		Session session;
		if (!propties.containsKey("mail.smtp.auth")) {
			propties.setProperty("mail.smtp.auth", "true");
		}
		if ("true".equals(propties.get("mail.smtp.auth").toString())) {
			session = Session.getDefaultInstance(propties , new Authenticator() {
				@Override
				public PasswordAuthentication getPasswordAuthentication() {
					String userName = propties.get("mail.smtp.user").toString();
					String password = propties.get("mail.smtp.password").toString();
					return new PasswordAuthentication(userName, password);
				}
			});
		} else {
			session = Session.getDefaultInstance(propties);
		}
		return session;
	}

	private static void parameterCheck(Properties propties) {
		Assert.notNull(propties.get("mail.smtp.host") , "mail.smtp.host property can't be null");
		Assert.notNull(propties.get("mail.smtp.from") , "mail.smtp.from property can't be null");
		Assert.notNull(propties.get("mail.smtp.user") , "mail.smtp.user property can't be null");
		Assert.notNull(propties.get("mail.smtp.password") , "mail.smtp.password property can't be null");
	}
}