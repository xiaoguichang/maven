package com.xiaogch.maven.wechat.core.entity;

public class MsgEntitiy {
    public final static String MSGTYPE_TEXT = "text";
    public final static String MSGTYPE_IMAGE = "image";
    public final static String MSGTYPE_VOICE = "voice";
    public final static String MSGTYPE_VIDEO = "video";
    public final static String MSGTYPE_SHORTVIDEO = "shortvideo";
    public final static String MSGTYPE_LOCATION = "location";
    public final static String MSGTYPE_LINK = "link";
    public final static String MSGTYPE_EVENT = "event";

    public final static String EVENT_SUBSCRIBE = "SUBSCRIBE";
    public final static String EVENT_UNSUBSCRIBE = "UNSUBSCRIBE";
    public final static String EVENT_SCAN = "SCAN";
    public final static String EVENT_LOCATION = "LOCATION";
    public final static String EVENT_CLICK = "CLICK";
    public final static String EVENT_VIEW = "VIEW";

    protected String toUserName; //开发者微信号
    protected String fromUserName; //发送方帐号（一个OpenID）
    protected String createTime; //消息创建时间 （整型）
    protected String msgType; //消息类型： text , image , voice , video , shortvideo , location , link , event

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

}
