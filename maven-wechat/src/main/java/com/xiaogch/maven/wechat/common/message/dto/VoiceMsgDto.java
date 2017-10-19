package com.xiaogch.maven.wechat.common.message.dto;

public class VoiceMsgDto extends MsgDto {
    private Long msgId;
    private String mediaId;
    private String format; //语音格式，如amr，speex等
    private String recognition; //语音识别结果，UTF8编码

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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    @Override
    public String toString() {
        return "VoiceMsgEntity{" +
                "msgId=" + msgId +
                ", mediaId='" + mediaId + '\'' +
                ", toUserName='" + toUserName + '\'' +
                ", format='" + format + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", recognition='" + recognition + '\'' +
                ", createTime='" + createTime + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
