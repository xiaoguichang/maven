package com.xiaogch.maven.wechat.core.entity;

public class ViewEventMsgEntity extends MsgEntitiy {

    private String event;
    private String eventKey; //设置的跳转URL

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

    @Override
    public String toString() {
        return "ViewEventMsgEntity{" +
                "event='" + event + '\'' +
                ", eventKey='" + eventKey + '\'' +
                ", toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
