package com.xiaogch.maven.wechat.core.entity;

import com.xiaogch.maven.common.util.XmlDom4jUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

/**
 * ProjectName: maven <BR>
 * File name: com.xiaogch.maven.wechat.core.entity <BR>
 * Author: guich <BR>
 * Project: maven <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/8/31 15:11 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class MsgEntityTest {

        Logger logger = LoggerFactory.getLogger(getClass());
        @Test
        public void toTextMsgEntity() throws Exception {
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
            ReceivedMsgEntity receivedMsgEntity = util.praseToBean(is , ReceivedMsgEntity.class);
            TextMsgEntity entity = receivedMsgEntity.toTextMsgEntity();
            System.out.println(entity.toString());
        }

        @Test
        public void toClickEventMsgEntity() throws Exception {
            XmlDom4jUtil util = new XmlDom4jUtil();
            String xmlString = "<xml>\n" +
                    "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                    "<FromUserName><![CDATA[FromUser]]></FromUserName>\n" +
                    "<CreateTime>123456789</CreateTime>\n" +
                    "<MsgType><![CDATA[event]]></MsgType>\n" +
                    "<Event><![CDATA[CLICK]]></Event>\n" +
                    "<EventKey><![CDATA[EVENTKEY]]></EventKey>\n" +
                    "</xml>";
            ByteArrayInputStream is = new ByteArrayInputStream(xmlString.getBytes());
            ReceivedMsgEntity receivedMsgEntity = util.praseToBean(is , ReceivedMsgEntity.class);
            ClickEventMsgEntity entity = receivedMsgEntity.toClickEventMsgEntity();
            System.out.println(entity.toString());
        }

        @Test
        public void toLocationEventMsgEntity() throws Exception {
            XmlDom4jUtil util = new XmlDom4jUtil();
            String xmlString = "<xml>\n" +
                    "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                    "<FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                    "<CreateTime>123456789</CreateTime>\n" +
                    "<MsgType><![CDATA[event]]></MsgType>\n" +
                    "<Event><![CDATA[LOCATION]]></Event>\n" +
                    "<Latitude>23.137466</Latitude>\n" +
                    "<Longitude>113.352425</Longitude>\n" +
                    "<Precision>119.385040</Precision>\n" +
                    "</xml>";
            ByteArrayInputStream is = new ByteArrayInputStream(xmlString.getBytes());
            ReceivedMsgEntity receivedMsgEntity = util.praseToBean(is , ReceivedMsgEntity.class);
            LocationEventMsgEntity entity = receivedMsgEntity.toLocationEventMsgEntity();
            System.out.println(entity.toString());
        }

        @Test
        public void toSubscribeEventMsgEntity() throws Exception {
            XmlDom4jUtil util = new XmlDom4jUtil();
            String xmlString = "<xml>\n" +
                    "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                    "<FromUserName><![CDATA[FromUser]]></FromUserName>\n" +
                    "<CreateTime>123456789</CreateTime>\n" +
                    "<MsgType><![CDATA[event]]></MsgType>\n" +
                    "<Event><![CDATA[subscribe]]></Event>\n" +
                    "</xml>";
            ByteArrayInputStream is = new ByteArrayInputStream(xmlString.getBytes());
            ReceivedMsgEntity receivedMsgEntity = util.praseToBean(is , ReceivedMsgEntity.class);
            SubscribeEventMsgEntity entity = receivedMsgEntity.toSubscribeEventMsgEntity();
            System.out.println(entity.toString());

            xmlString = "<xml><ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                    "<FromUserName><![CDATA[FromUser]]></FromUserName>\n" +
                    "<CreateTime>123456789</CreateTime>\n" +
                    "<MsgType><![CDATA[event]]></MsgType>\n" +
                    "<Event><![CDATA[subscribe]]></Event>\n" +
                    "<EventKey><![CDATA[qrscene_123123]]></EventKey>\n" +
                    "<Ticket><![CDATA[TICKET]]></Ticket>\n" +
                    "</xml>";
            is = new ByteArrayInputStream(xmlString.getBytes());
            receivedMsgEntity = util.praseToBean(is , ReceivedMsgEntity.class);
            entity = receivedMsgEntity.toSubscribeEventMsgEntity();
            System.out.println(entity.toString());
        }
        @Test
        public void toUnSubscribeEventMsgEntity() throws Exception {
            XmlDom4jUtil util = new XmlDom4jUtil();
            String xmlString = "<xml>\n" +
                    "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                    "<FromUserName><![CDATA[FromUser]]></FromUserName>\n" +
                    "<CreateTime>123456789</CreateTime>\n" +
                    "<MsgType><![CDATA[event]]></MsgType>\n" +
                    "<Event><![CDATA[unsubscribe]]></Event>\n" +
                    "</xml>";
            ByteArrayInputStream is = new ByteArrayInputStream(xmlString.getBytes());
            ReceivedMsgEntity receivedMsgEntity = util.praseToBean(is , ReceivedMsgEntity.class);
            UnSubscribeEventMsgEntity entity = receivedMsgEntity.toUnSubscribeEventMsgEntity();
            System.out.println(entity.toString());
        }
        @Test
        public void toViewEventMsgEntity() throws Exception {
            XmlDom4jUtil util = new XmlDom4jUtil();
            String xmlString = "<xml>\n" +
                    "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                    "<FromUserName><![CDATA[FromUser]]></FromUserName>\n" +
                    "<CreateTime>123456789</CreateTime>\n" +
                    "<MsgType><![CDATA[event]]></MsgType>\n" +
                    "<Event><![CDATA[VIEW]]></Event>\n" +
                    "<EventKey><![CDATA[www.qq.com]]></EventKey>\n" +
                    "</xml>";
            ByteArrayInputStream is = new ByteArrayInputStream(xmlString.getBytes());
            ReceivedMsgEntity receivedMsgEntity = util.praseToBean(is , ReceivedMsgEntity.class);
            ViewEventMsgEntity entity = receivedMsgEntity.toViewEventMsgEntity();
            System.out.println(entity.toString());
        }
        @Test
        public void toScanEventMsgEntity() throws Exception {
            XmlDom4jUtil util = new XmlDom4jUtil();
            String xmlString = "<xml>\n" +
                    "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                    "<FromUserName><![CDATA[FromUser]]></FromUserName>\n" +
                    "<CreateTime>123456789</CreateTime>\n" +
                    "<MsgType><![CDATA[event]]></MsgType>\n" +
                    "<Event><![CDATA[SCAN]]></Event>\n" +
                    "<EventKey><![CDATA[SCENE_VALUE]]></EventKey>\n" +
                    "<Ticket><![CDATA[TICKET]]></Ticket>\n" +
                    "</xml>";
            ByteArrayInputStream is = new ByteArrayInputStream(xmlString.getBytes());
            ReceivedMsgEntity receivedMsgEntity = util.praseToBean(is , ReceivedMsgEntity.class);
            ScanEventMsgEntity entity = receivedMsgEntity.toScanEventMsgEntity();
            System.out.println(entity.toString());
        }

        @Test
        public void toImageMsgEntity() throws Exception {
            XmlDom4jUtil util = new XmlDom4jUtil();
            String xmlString = "<xml>\n" +
                    " <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                    " <FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                    " <CreateTime>1348831860</CreateTime>\n" +
                    " <MsgType><![CDATA[image]]></MsgType>\n" +
                    " <PicUrl><![CDATA[this is a url]]></PicUrl>\n" +
                    " <MediaId><![CDATA[media_id]]></MediaId>\n" +
                    " <MsgId>1234567890123456</MsgId>\n" +
                    " </xml>";
            ByteArrayInputStream is = new ByteArrayInputStream(xmlString.getBytes());
            ReceivedMsgEntity receivedMsgEntity = util.praseToBean(is , ReceivedMsgEntity.class);
            ImageMsgEntity entity = receivedMsgEntity.toImageMsgEntity();
            System.out.println(entity.toString());
        }

        @Test
        public void toLinkMsgEntity() throws Exception {
            XmlDom4jUtil util = new XmlDom4jUtil();
            String xmlString = "    <xml>\n" +
                    "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                    "<FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                    "<CreateTime>1351776360</CreateTime>\n" +
                    "<MsgType><![CDATA[link]]></MsgType>\n" +
                    "<Title><![CDATA[公众平台官网链接]]></Title>\n" +
                    "<Description><![CDATA[公众平台官网链接]]></Description>\n" +
                    "<Url><![CDATA[url]]></Url>\n" +
                    "<MsgId>1234567890123456</MsgId>\n" +
                    "</xml>";
            ByteArrayInputStream is = new ByteArrayInputStream(xmlString.getBytes());
            ReceivedMsgEntity receivedMsgEntity = util.praseToBean(is , ReceivedMsgEntity.class);
            LinkMsgEntity entity = receivedMsgEntity.toLinkMsgEntity();
            System.out.println(entity.toString());
        }

        @Test
        public void toVoiceMsgEntity() throws Exception {
            XmlDom4jUtil util = new XmlDom4jUtil();
            String xmlString = "<xml>\n" +
                    "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                    "<FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                    "<CreateTime>1357290913</CreateTime>\n" +
                    "<MsgType><![CDATA[voice]]></MsgType>\n" +
                    "<MediaId><![CDATA[media_id]]></MediaId>\n" +
                    "<Format><![CDATA[Format]]></Format>\n" +
                    "<MsgId>1234567890123456</MsgId>\n" +
                    "</xml>";
            ByteArrayInputStream is = new ByteArrayInputStream(xmlString.getBytes());
            ReceivedMsgEntity receivedMsgEntity = util.praseToBean(is , ReceivedMsgEntity.class);
            VoiceMsgEntity entity = receivedMsgEntity.toVoiceMsgEntity();
            System.out.println(entity.toString());

            xmlString = "<xml>\n" +
                    "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                    "<FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                    "<CreateTime>1357290913</CreateTime>\n" +
                    "<MsgType><![CDATA[voice]]></MsgType>\n" +
                    "<MediaId><![CDATA[media_id]]></MediaId>\n" +
                    "<Format><![CDATA[Format]]></Format>\n" +
                    "<Recognition><![CDATA[腾讯微信团队]]></Recognition>\n" +
                    "<MsgId>1234567890123456</MsgId>\n" +
                    "</xml>";
            is = new ByteArrayInputStream(xmlString.getBytes());
            receivedMsgEntity = util.praseToBean(is , ReceivedMsgEntity.class);
            entity = receivedMsgEntity.toVoiceMsgEntity();
            System.out.println(entity.toString());
        }

        @Test
        public void toVideoMsgEntity() throws Exception {
            XmlDom4jUtil util = new XmlDom4jUtil();
            String xmlString = "<xml>\n" +
                    "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                    "<FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                    "<CreateTime>1357290913</CreateTime>\n" +
                    "<MsgType><![CDATA[video]]></MsgType>\n" +
                    "<MediaId><![CDATA[media_id]]></MediaId>\n" +
                    "<ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>\n" +
                    "<MsgId>1234567890123456</MsgId>\n" +
                    "</xml>";
            ByteArrayInputStream is = new ByteArrayInputStream(xmlString.getBytes());
            ReceivedMsgEntity receivedMsgEntity = util.praseToBean(is , ReceivedMsgEntity.class);
            VideoMsgEntity entity = receivedMsgEntity.toVideoMsgEntity();
            System.out.println(entity.toString());

            xmlString = "<xml>\n" +
                    "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                    "<FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                    "<CreateTime>1357290913</CreateTime>\n" +
                    "<MsgType><![CDATA[shortvideo]]></MsgType>\n" +
                    "<MediaId><![CDATA[media_id]]></MediaId>\n" +
                    "<ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>\n" +
                    "<MsgId>1234567890123456</MsgId>\n" +
                    "</xml>";
            is = new ByteArrayInputStream(xmlString.getBytes());
            receivedMsgEntity = util.praseToBean(is , ReceivedMsgEntity.class);
            entity = receivedMsgEntity.toVideoMsgEntity();
            System.out.println(entity.toString());
        }


        @Test
        public void toLocationMsgEntity() throws Exception {
            XmlDom4jUtil util = new XmlDom4jUtil();
            String xmlString = "<xml>\n" +
                    "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                    "<FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                    "<CreateTime>1351776360</CreateTime>\n" +
                    "<MsgType><![CDATA[location]]></MsgType>\n" +
                    "<Location_X>23.134521</Location_X>\n" +
                    "<Location_Y>113.358803</Location_Y>\n" +
                    "<Scale>20</Scale>\n" +
                    "<Label><![CDATA[位置信息]]></Label>\n" +
                    "<MsgId>1234567890123456</MsgId>\n" +
                    "</xml>";
            ByteArrayInputStream is = new ByteArrayInputStream(xmlString.getBytes());
            ReceivedMsgEntity receivedMsgEntity = util.praseToBean(is , ReceivedMsgEntity.class);
            LocationMsgEntity entity = receivedMsgEntity.toLocationMsgEntity();
            System.out.println(entity.toString());

        }
}
