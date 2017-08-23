package com.shangde.dailyreport.util;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.List;
import java.util.Properties;

/**
 * ProjectName: dailyreport-parent <BR>
 * File name: com.shangde.dailyreport.util <BR>
 * Author: guich <BR>
 * Project: dailyreport-parent <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/8/16 18:04 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class EmailSender {
    private String title;
    private String content;
    private Properties properties;
    private EmailTpye emailType;
    private String[] addresses;
    private List<String> attachmentFiles;


    /***
     *
     * @param title
     * @param addresses
     * @param content
     * @param properties
     */
    public EmailSender(String title , String[] addresses , String content , Properties properties) {
        this(title , addresses , content , properties , EmailSender.EmailTpye.TEXT);
    }

    public EmailSender(String title , String[] addresses , String content , Properties properties, EmailSender.EmailTpye emailTpye) {
       this.addresses = addresses;
       this.title = title;
       this.emailType = emailTpye;
       this.content = content;
       this.properties = properties;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public EmailTpye getEmailType() {
        return emailType;
    }

    public void setEmailType(EmailTpye emailType) {
        this.emailType = emailType;
    }

    public String[] getAddresses() {
        return addresses;
    }

    public void setAddresses(String[] addresses) {
        this.addresses = addresses;
    }

    public List<String> getAttachmentFiles() {
        return attachmentFiles;
    }

    public void setAttachmentFiles(List<String> attachmentFiles) {
        this.attachmentFiles = attachmentFiles;
    }

    public void sendEmail() throws Exception {
        Assert.isTrue(properties != null && !properties.isEmpty() , "email properties can't be null or empty");
        Assert.isTrue(StringUtils.hasText(title), "emial title can't be null or empty");
        Assert.isTrue(StringUtils.hasText(content), "emial content can't be null or empty");
        Assert.isTrue((addresses != null && addresses.length != 0), "emial address can't be null or empty");
        parameterCheck(properties);
        Session session = getSession(properties);

        MimeMessage message = new MimeMessage(session);
        setEmailContent(message, content, emailType , attachmentFiles);
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
        message.setRecipients(Message.RecipientType.TO, eamilAddress);

        Transport.send(message);
    }

    private Session getSession(final Properties properties) {
        Session session;
        if (!properties.containsKey("mail.smtp.auth")) {
            properties.setProperty("mail.smtp.auth", "true");
        }
        if ("true".equals(properties.get("mail.smtp.auth").toString())) {
            session = Session.getDefaultInstance(properties , new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    String userName = properties.get("mail.smtp.user").toString();
                    String password = properties.get("mail.smtp.password").toString();
                    return new PasswordAuthentication(userName, password);
                }
            });
        } else {
            session = Session.getDefaultInstance(properties);
        }
        return session;
    }


    private void parameterCheck(Properties properties) {
        Assert.notNull(properties.get("mail.smtp.host") , "mail.smtp.host property can't be null");
        Assert.notNull(properties.get("mail.smtp.from") , "mail.smtp.from property can't be null");
        Assert.notNull(properties.get("mail.smtp.user") , "mail.smtp.user property can't be null");
        Assert.notNull(properties.get("mail.smtp.password") , "mail.smtp.password property can't be null");
    }

    private void setEmailContent(MimeMessage message, String content , EmailTpye emailType , List<String> fileNames) throws MessagingException {
        Multipart multipart = new MimeMultipart();
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        switch (emailType) {
            case TEXT:
                mimeBodyPart.setContent(content, "text/txt; charset=utf-8");
                break;
            case HTML:
                mimeBodyPart.setContent(content, "text/html; charset=utf-8");
                break;
            default:
                mimeBodyPart.setContent(content, "text/txt; charset=utf-8");
                break;
        }

        multipart.addBodyPart(mimeBodyPart);
        if (fileNames != null) {
            for (String fileName : fileNames) {
                mimeBodyPart = new MimeBodyPart();
                File file = new File(fileName);
                FileDataSource dataSource = new FileDataSource(file);
                DataHandler dataHandler = new DataHandler(dataSource);
                mimeBodyPart.setDataHandler(dataHandler);
                mimeBodyPart.setFileName(file.getName());
                multipart.addBodyPart(mimeBodyPart);
            }
        }

        message.setContent(multipart);
    }

    /**
     * 邮件类型
     *
     * @author xiaogch
     *
     * @version 1.0
     *
     * @since 2017年7月19日
     */
    public enum EmailTpye {
        /** 简单的文本邮件 */
        TEXT,
        /** HTML邮件 */
        HTML;
    }
}
