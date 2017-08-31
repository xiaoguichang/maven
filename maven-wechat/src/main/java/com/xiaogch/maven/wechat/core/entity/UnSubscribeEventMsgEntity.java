package com.xiaogch.maven.wechat.core.entity;

public class UnSubscribeEventMsgEntity extends MsgEntitiy {
    private String event;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "UnSubscribeEventMsgEntity{" +
                "event='" + event + '\'' +
                ", toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
