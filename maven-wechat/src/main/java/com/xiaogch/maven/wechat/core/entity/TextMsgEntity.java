package com.xiaogch.maven.wechat.core.entity;

public class TextMsgEntity extends MsgEntitiy {

    private Long msgId;
    private String content; //文本消息内容

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    @Override
    public String toString() {
        return "TextMsgEntity{" +
                "msgId=" + msgId +
                ", content='" + content + '\'' +
                ", toUserName='" + toUserName + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
