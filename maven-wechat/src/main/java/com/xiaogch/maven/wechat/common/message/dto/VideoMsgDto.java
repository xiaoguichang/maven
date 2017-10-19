package com.xiaogch.maven.wechat.common.message.dto;

public class VideoMsgDto extends MsgDto {
    private Long msgId;
    private String mediaId;
    private String thumbMediaId;

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    @Override
    public String toString() {
        return "VideoMsgEntity{" +
                "msgId=" + msgId +
                ", mediaId='" + mediaId + '\'' +
                ", toUserName='" + toUserName + '\'' +
                ", thumbMediaId='" + thumbMediaId + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
