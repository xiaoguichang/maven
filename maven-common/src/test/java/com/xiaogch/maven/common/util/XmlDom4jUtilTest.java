package com.xiaogch.maven.common.util;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class XmlDom4jUtilTest {


    @Test
    public void praseToBean() throws Exception {
        XmlDom4jUtil util = new XmlDom4jUtil();
        String xmlString = "<xml>" +
                " <ToUserName><![CDATA[xiaogch]]></ToUserName>" +
                " <FromUserName><![CDATA[weixin]]></FromUserName>" +
                " <CreateTime>1348831860</CreateTime>" +
                " <MsgType><![CDATA[text]]></MsgType>" +
                " <Content><![CDATA[this is a test]]></Content>" +
                " <MsgId>1234567890123456</MsgId>" +
                " </xml>";
        ByteArrayInputStream is = new ByteArrayInputStream(xmlString.getBytes());
        util.praseToBean(is , Object.class);
    }

}