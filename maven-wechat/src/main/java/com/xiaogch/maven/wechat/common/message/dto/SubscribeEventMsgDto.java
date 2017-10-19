package com.xiaogch.maven.wechat.common.message.dto;

public class SubscribeEventMsgDto extends MsgDto {
    private String event;//subscribe
    private String eventKey;//扫码关注才有，qrscene_为前缀，后面为二维码的参数值
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
        return "SubscribeEventMsgEntity{" +
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
