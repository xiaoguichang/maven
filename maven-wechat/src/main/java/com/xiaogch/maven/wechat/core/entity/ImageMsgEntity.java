package com.xiaogch.maven.wechat.core.entity;

public class ImageMsgEntity extends MsgEntitiy {

    private Long msgId;
    private String mediaId;
    private String picUrl; //图片链接（由系统生成）

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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        return "ImageMsgEntity{" +
                "msgId=" + msgId +
                ", mediaId='" + mediaId + '\'' +
                ", toUserName='" + toUserName + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
