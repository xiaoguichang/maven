package com.xiaogch.maven.wechat.core.entity;

public class ScanEventMsgEntity extends MsgEntitiy {
    private String event;//SCAN
    private String eventKey;//是一个32位无符号整数，即创建二维码时的二维码scene_id
    private String ticket; //二维码的ticket，可用来换取二维码图片

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "ScanEventMsgEntity{" +
                "event='" + event + '\'' +
                ", toUserName='" + toUserName + '\'' +
                ", eventKey='" + eventKey + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", ticket='" + ticket + '\'' +
                ", createTime='" + createTime + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
