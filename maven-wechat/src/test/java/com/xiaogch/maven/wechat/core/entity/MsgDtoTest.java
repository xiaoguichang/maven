package com.xiaogch.maven.wechat.core.entity;

import com.xiaogch.maven.common.util.XmlDom4jUtil;
import com.xiaogch.maven.wechat.common.message.dto.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/8/31 15:11 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class MsgDtoTest {

        Logger logger = LoggerFactory.getLogger(getClass());
        @Test
        public void toTextMsgDto() throws Exception {
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
            ReceivedMsgDto receivedMsgDto = util.praseToBean(is , ReceivedMsgDto.class);
            TextMsgDto entity = receivedMsgDto.toTextMsgDto();
            System.out.println(entity.toString());
        }

        @Test
        public void toClickEventMsgDto() throws Exception {
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
            ReceivedMsgDto receivedMsgDto = util.praseToBean(is , ReceivedMsgDto.class);
            ClickEventMsgDto entity = receivedMsgDto.toClickEventMsgDto();
            System.out.println(entity.toString());
        }

        @Test
        public void toLocationEventMsgDto() throws Exception {
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
            ReceivedMsgDto receivedMsgDto = util.praseToBean(is , ReceivedMsgDto.class);
            LocationEventMsgDto entity = receivedMsgDto.toLocationEventMsgDto();
            System.out.println(entity.toString());
        }

        @Test
        public void toSubscribeEventMsgDto() throws Exception {
            XmlDom4jUtil util = new XmlDom4jUtil();
            String xmlString = "<xml>\n" +
                    "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                    "<FromUserName><![CDATA[FromUser]]></FromUserName>\n" +
                    "<CreateTime>123456789</CreateTime>\n" +
                    "<MsgType><![CDATA[event]]></MsgType>\n" +
                    "<Event><![CDATA[subscribe]]></Event>\n" +
                    "</xml>";
            ByteArrayInputStream is = new ByteArrayInputStream(xmlString.getBytes());
            ReceivedMsgDto receivedMsgDto = util.praseToBean(is , ReceivedMsgDto.class);
            SubscribeEventMsgDto entity = receivedMsgDto.toSubscribeEventMsgDto();
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
            receivedMsgDto = util.praseToBean(is , ReceivedMsgDto.class);
            entity = receivedMsgDto.toSubscribeEventMsgDto();
            System.out.println(entity.toString());
        }
        @Test
        public void toUnSubscribeEventMsgDto() throws Exception {
            XmlDom4jUtil util = new XmlDom4jUtil();
            String xmlString = "<xml>\n" +
                    "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                    "<FromUserName><![CDATA[FromUser]]></FromUserName>\n" +
                    "<CreateTime>123456789</CreateTime>\n" +
                    "<MsgType><![CDATA[event]]></MsgType>\n" +
                    "<Event><![CDATA[unsubscribe]]></Event>\n" +
                    "</xml>";
            ByteArrayInputStream is = new ByteArrayInputStream(xmlString.getBytes());
            ReceivedMsgDto receivedMsgDto = util.praseToBean(is , ReceivedMsgDto.class);
            UnSubscribeEventMsgDto entity = receivedMsgDto.toUnSubscribeEventMsgDto();
            System.out.println(entity.toString());
        }
        @Test
        public void toViewEventMsgDto() throws Exception {
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
            ReceivedMsgDto receivedMsgDto = util.praseToBean(is , ReceivedMsgDto.class);
            ViewEventMsgDto entity = receivedMsgDto.toViewEventMsgDto();
            System.out.println(entity.toString());
        }
        @Test
        public void toScanEventMsgDto() throws Exception {
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
            ReceivedMsgDto receivedMsgDto = util.praseToBean(is , ReceivedMsgDto.class);
            ScanEventMsgDto entity = receivedMsgDto.toScanEventMsgDto();
            System.out.println(entity.toString());
        }

        @Test
        public void toImageMsgDto() throws Exception {
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
            ReceivedMsgDto receivedMsgDto = util.praseToBean(is , ReceivedMsgDto.class);
            ImageMsgDto entity = receivedMsgDto.toImageMsgDto();
            System.out.println(entity.toString());
        }

        @Test
        public void toLinkMsgDto() throws Exception {
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
            ReceivedMsgDto receivedMsgDto = util.praseToBean(is , ReceivedMsgDto.class);
            LinkMsgDto entity = receivedMsgDto.toLinkMsgDto();
            System.out.println(entity.toString());
        }

        @Test
        public void toVoiceMsgDto() throws Exception {
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
            ReceivedMsgDto receivedMsgDto = util.praseToBean(is , ReceivedMsgDto.class);
            VoiceMsgDto entity = receivedMsgDto.toVoiceMsgDto();
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
            receivedMsgDto = util.praseToBean(is , ReceivedMsgDto.class);
            entity = receivedMsgDto.toVoiceMsgDto();
            System.out.println(entity.toString());
        }

        @Test
        public void toVideoMsgDto() throws Exception {
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
            ReceivedMsgDto receivedMsgDto = util.praseToBean(is , ReceivedMsgDto.class);
            VideoMsgDto entity = receivedMsgDto.toVideoMsgDto();
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
            receivedMsgDto = util.praseToBean(is , ReceivedMsgDto.class);
            entity = receivedMsgDto.toVideoMsgDto();
            System.out.println(entity.toString());
        }


        @Test
        public void toLocationMsgDto() throws Exception {
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
            ReceivedMsgDto receivedMsgDto = util.praseToBean(is , ReceivedMsgDto.class);
            LocationMsgDto entity = receivedMsgDto.toLocationMsgDto();
            System.out.println(entity.toString());

        }
}
