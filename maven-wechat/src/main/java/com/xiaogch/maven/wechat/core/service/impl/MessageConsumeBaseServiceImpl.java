package com.xiaogch.maven.wechat.core.service.impl;


import com.xiaogch.maven.wechat.core.entity.*;
import com.xiaogch.maven.wechat.core.service.MessageConsumeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MessageConsumeBaseServiceImpl implements MessageConsumeService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String consume(ReceivedMsgEntity receivedMsgEntity) {

        if (receivedMsgEntity == null) {
            return "";
        }

        if (MsgEntitiy.MSGTYPE_IMAGE.equalsIgnoreCase(receivedMsgEntity.getMsgType())) {
            return consumeImageMessage(receivedMsgEntity.toImageMsgEntity());
        } else if (MsgEntitiy.MSGTYPE_LINK.equalsIgnoreCase(receivedMsgEntity.getMsgType())) {
            return consumeLinkMessage(receivedMsgEntity.toLinkMsgEntity());
        } else if (MsgEntitiy.MSGTYPE_LOCATION.equalsIgnoreCase(receivedMsgEntity.getMsgType())) {
            return consumeLocationMessage(receivedMsgEntity.toLocationMsgEntity());
        } else if (MsgEntitiy.MSGTYPE_SHORTVIDEO.equalsIgnoreCase(receivedMsgEntity.getMsgType())
                || MsgEntitiy.MSGTYPE_VIDEO.equalsIgnoreCase(receivedMsgEntity.getMsgType())) {
            return consumeVideoMessage(receivedMsgEntity.toVideoMsgEntity());
        } else if (MsgEntitiy.MSGTYPE_VOICE.equalsIgnoreCase(receivedMsgEntity.getMsgType())) {
            return consumeVoiceMessage(receivedMsgEntity.toVoiceMsgEntity());
        } else if (MsgEntitiy.MSGTYPE_TEXT.equalsIgnoreCase(receivedMsgEntity.getMsgType())) {
            return consumeTextMessage(receivedMsgEntity.toTextMsgEntity());
        } else if (MsgEntitiy.MSGTYPE_EVENT.equalsIgnoreCase(receivedMsgEntity.getMsgType())) {
            return consumEventMessage(receivedMsgEntity);
        }
        logger.info("unknown msgType : {}" , receivedMsgEntity.getMsgType());
        return "";
    }

    protected String consumEventMessage(ReceivedMsgEntity receivedMsgEntity) {
        if (MsgEntitiy.EVENT_CLICK.equalsIgnoreCase(receivedMsgEntity.getEvent())) {
            return consumeClickEventMessage(receivedMsgEntity.toClickEventMsgEntity());
        } else if (MsgEntitiy.EVENT_LOCATION.equalsIgnoreCase(receivedMsgEntity.getEvent())) {
            return consumeLocationEventMessage(receivedMsgEntity.toLocationEventMsgEntity());
        } else if (MsgEntitiy.EVENT_SCAN.equalsIgnoreCase(receivedMsgEntity.getEvent())) {
            return consumeScanEventMessage(receivedMsgEntity.toScanEventMsgEntity());
        } else if (MsgEntitiy.EVENT_SUBSCRIBE.equalsIgnoreCase(receivedMsgEntity.getEvent())) {
            return consumeSubscribeEventMessage(receivedMsgEntity.toSubscribeEventMsgEntity());
        } else if (MsgEntitiy.EVENT_UNSUBSCRIBE.equalsIgnoreCase(receivedMsgEntity.getEvent())) {
            return consumeUnSubscribeEventMessage(receivedMsgEntity.toUnSubscribeEventMsgEntity());
        } else if (MsgEntitiy.EVENT_VIEW.equalsIgnoreCase(receivedMsgEntity.getEvent())) {
            return consumeViewEventMessage(receivedMsgEntity.toViewEventMsgEntity());
        }
        logger.info("unknown vent : {}" , receivedMsgEntity.getEvent());
        return "";
    }

    protected String consumeViewEventMessage(ViewEventMsgEntity viewEventMsgEntity) {
        logger.info("message info : {}" , viewEventMsgEntity);
        return "";
    }

    protected String consumeUnSubscribeEventMessage(UnSubscribeEventMsgEntity unSubscribeEventMsgEntity) {
        logger.info("message info : {}" , unSubscribeEventMsgEntity);
        return "";
    }

    protected String consumeSubscribeEventMessage(SubscribeEventMsgEntity subscribeEventMsgEntity) {
        logger.info("message info : {}" , subscribeEventMsgEntity);
        return "";
    }

    protected String consumeScanEventMessage(ScanEventMsgEntity scanEventMsgEntity) {
        logger.info("message info : {}" , scanEventMsgEntity);
        return "";
    }

    protected String consumeLocationEventMessage(LocationEventMsgEntity locationEventMsgEntity) {
        logger.info("message info : {}" , locationEventMsgEntity);
        return "";
    }

    protected String consumeClickEventMessage(ClickEventMsgEntity clickEventMsgEntity) {
        logger.info("message info : {}" , clickEventMsgEntity);
        return "";
    }


    protected String consumeImageMessage(ImageMsgEntity imageMsgEntity) {
        logger.info("message info : {}" , imageMsgEntity);
        return "";
    }

    protected String consumeLinkMessage(LinkMsgEntity linkMsgEntity) {
        logger.info("message info : {}" , linkMsgEntity);
        return "";
    }

    protected String consumeLocationMessage(LocationMsgEntity locationMsgEntity) {
        logger.info("message info : {}" , locationMsgEntity);
        return null;
    }

    protected String consumeTextMessage(TextMsgEntity textMsgEntity) {
        logger.info("message info : {}" , textMsgEntity);
        return "";
    }

    protected String consumeVideoMessage(VideoMsgEntity videoMsgEntity) {
        logger.info("message info : {}" , videoMsgEntity);
        return "";
    }

    protected String consumeVoiceMessage(VoiceMsgEntity voiceMsgEntity) {
        logger.info("message info : {}" , voiceMsgEntity);
        return "";
    }

}

