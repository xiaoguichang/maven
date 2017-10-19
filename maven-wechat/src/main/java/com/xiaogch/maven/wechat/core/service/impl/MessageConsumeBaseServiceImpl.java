package com.xiaogch.maven.wechat.core.service.impl;


import com.xiaogch.maven.wechat.common.message.dto.*;
import com.xiaogch.maven.wechat.core.service.MessageConsumeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumeBaseServiceImpl implements MessageConsumeService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String consume(ReceivedMsgDto receivedMsgDto) {

        if (receivedMsgDto == null) {
            return "";
        }

        if (MsgDto.MSGTYPE_IMAGE.equalsIgnoreCase(receivedMsgDto.getMsgType())) {
            return consumeImageMessage(receivedMsgDto.toImageMsgDto());
        } else if (MsgDto.MSGTYPE_LINK.equalsIgnoreCase(receivedMsgDto.getMsgType())) {
            return consumeLinkMessage(receivedMsgDto.toLinkMsgDto());
        } else if (MsgDto.MSGTYPE_LOCATION.equalsIgnoreCase(receivedMsgDto.getMsgType())) {
            return consumeLocationMessage(receivedMsgDto.toLocationMsgDto());
        } else if (MsgDto.MSGTYPE_SHORTVIDEO.equalsIgnoreCase(receivedMsgDto.getMsgType())
                || MsgDto.MSGTYPE_VIDEO.equalsIgnoreCase(receivedMsgDto.getMsgType())) {
            return consumeVideoMessage(receivedMsgDto.toVideoMsgDto());
        } else if (MsgDto.MSGTYPE_VOICE.equalsIgnoreCase(receivedMsgDto.getMsgType())) {
            return consumeVoiceMessage(receivedMsgDto.toVoiceMsgDto());
        } else if (MsgDto.MSGTYPE_TEXT.equalsIgnoreCase(receivedMsgDto.getMsgType())) {
            return consumeTextMessage(receivedMsgDto.toTextMsgDto());
        } else if (MsgDto.MSGTYPE_EVENT.equalsIgnoreCase(receivedMsgDto.getMsgType())) {
            return consumEventMessage(receivedMsgDto);
        }
        logger.info("unknown msgType : {}" , receivedMsgDto.getMsgType());
        return "";
    }

    protected String consumEventMessage(ReceivedMsgDto receivedMsgDto) {
        if (MsgDto.EVENT_CLICK.equalsIgnoreCase(receivedMsgDto.getEvent())) {
            return consumeClickEventMessage(receivedMsgDto.toClickEventMsgDto());
        } else if (MsgDto.EVENT_LOCATION.equalsIgnoreCase(receivedMsgDto.getEvent())) {
            return consumeLocationEventMessage(receivedMsgDto.toLocationEventMsgDto());
        } else if (MsgDto.EVENT_SCAN.equalsIgnoreCase(receivedMsgDto.getEvent())) {
            return consumeScanEventMessage(receivedMsgDto.toScanEventMsgDto());
        } else if (MsgDto.EVENT_SUBSCRIBE.equalsIgnoreCase(receivedMsgDto.getEvent())) {
            return consumeSubscribeEventMessage(receivedMsgDto.toSubscribeEventMsgDto());
        } else if (MsgDto.EVENT_UNSUBSCRIBE.equalsIgnoreCase(receivedMsgDto.getEvent())) {
            return consumeUnSubscribeEventMessage(receivedMsgDto.toUnSubscribeEventMsgDto());
        } else if (MsgDto.EVENT_VIEW.equalsIgnoreCase(receivedMsgDto.getEvent())) {
            return consumeViewEventMessage(receivedMsgDto.toViewEventMsgDto());
        }
        logger.info("unknown vent : {}" , receivedMsgDto.getEvent());
        return "";
    }

    protected String consumeViewEventMessage(ViewEventMsgDto viewEventMsgDto) {
        logger.info("message info : {}" , viewEventMsgDto);
        return "";
    }

    protected String consumeUnSubscribeEventMessage(UnSubscribeEventMsgDto unSubscribeEventMsgDto) {
        logger.info("message info : {}" , unSubscribeEventMsgDto);
        return "";
    }

    protected String consumeSubscribeEventMessage(SubscribeEventMsgDto subscribeEventMsgDto) {
        logger.info("message info : {}" , subscribeEventMsgDto);
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>")
                .append("<ToUserName><![CDATA[").append(subscribeEventMsgDto.getFromUserName()).append("]]></ToUserName>")
                .append("<FromUserName><![CDATA[").append(subscribeEventMsgDto.getToUserName()).append("]]></FromUserName>")
                .append("<CreateTime><![CDATA[").append(System.currentTimeMillis()).append("]]></FromUserName>")
                .append("<MsgType><![CDATA[").append("text").append("]]></MsgType>")
                .append("<Content><![CDATA[").append("欢迎关注我，我们一起嗨").append("]]></Content>")
            .append("</xml>");
        return sb.toString();
    }

    protected String consumeScanEventMessage(ScanEventMsgDto scanEventMsgDto) {
        logger.info("message info : {}" , scanEventMsgDto);
        return "";
    }

    protected String consumeLocationEventMessage(LocationEventMsgDto locationEventMsgDto) {
        logger.info("message info : {}" , locationEventMsgDto);
        return "";
    }

    protected String consumeClickEventMessage(ClickEventMsgDto clickEventMsgDto) {
        logger.info("message info : {}" , clickEventMsgDto);
        return "";
    }


    protected String consumeImageMessage(ImageMsgDto imageMsgDto) {
        logger.info("message info : {}" , imageMsgDto);
        return "";
    }

    protected String consumeLinkMessage(LinkMsgDto linkMsgDto) {
        logger.info("message info : {}" , linkMsgDto);
        return "";
    }

    protected String consumeLocationMessage(LocationMsgDto locationMsgDto) {
        logger.info("message info : {}" , locationMsgDto);
        return null;
    }

    protected String consumeTextMessage(TextMsgDto textMsgDto) {
        logger.info("message info : {}" , textMsgDto);
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>")
                .append("<ToUserName><![CDATA[").append(textMsgDto.getFromUserName()).append("]]></ToUserName>")
                .append("<FromUserName><![CDATA[").append(textMsgDto.getToUserName()).append("]]></FromUserName>")
                .append("<CreateTime><![CDATA[").append(System.currentTimeMillis()).append("]]></FromUserName>")
                .append("<MsgType><![CDATA[").append("text").append("]]></MsgType>")
                .append("<Content><![CDATA[").append("对不起，小编不明白您的意思！").append("]]></Content>")
                .append("</xml>");
        return sb.toString();
    }

    protected String consumeVideoMessage(VideoMsgDto videoMsgDto) {
        logger.info("message info : {}" , videoMsgDto);
        return "";
    }

    protected String consumeVoiceMessage(VoiceMsgDto voiceMsgDto) {
        logger.info("message info : {}" , voiceMsgDto);
        return "";
    }

}

