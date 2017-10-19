package com.xiaogch.maven.wechat.common.message.dto;

public class ViewEventMsgDto extends MsgDto {

    private String event;
    private String eventKey; //设置的跳转URL
    private String menuId;

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

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "ViewEventMsgDto{" +
                "event='" + event + '\'' +
                ", eventKey='" + eventKey + '\'' +
                ", menuId='" + menuId + '\'' +
                ", toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
