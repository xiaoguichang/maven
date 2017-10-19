package com.xiaogch.maven.wechat.common.message.dto;

public class ClickEventMsgDto extends MsgDto {
    private String event;
    private String eventKey; //与自定义菜单接口中KEY值对应

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
        return "ClickEventMsgEntity{" +
                "event='" + event + '\'' +
                ", eventKey='" + eventKey + '\'' +
                ", toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
