package com.xiaogch.maven.wechat.common.message.dto;

public class LinkMsgDto extends MsgDto {
    private Long msgId;
    private String title; //消息标题
    private String description; //消息描述
    private String url; //消息链接

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "LinkMsgEntity{" +
                "msgId=" + msgId +
                ", title='" + title + '\'' +
                ", toUserName='" + toUserName + '\'' +
                ", description='" + description + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", url='" + url + '\'' +
                ", createTime='" + createTime + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
