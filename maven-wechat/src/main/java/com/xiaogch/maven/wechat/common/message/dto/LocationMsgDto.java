package com.xiaogch.maven.wechat.common.message.dto;

public class LocationMsgDto extends MsgDto {

    private Long msgId;
    private String location_X; //地理位置维度
    private String location_Y; //地理位置经度
    private String scale; //地图缩放大小
    private String label; //地理位置信息

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getLocation_X() {
        return location_X;
    }

    public void setLocation_X(String location_X) {
        this.location_X = location_X;
    }

    public String getLocation_Y() {
        return location_Y;
    }

    public void setLocation_Y(String location_Y) {
        this.location_Y = location_Y;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "LocationMsgEntity{" +
                "msgId=" + msgId +
                ", location_X='" + location_X + '\'' +
                ", toUserName='" + toUserName + '\'' +
                ", location_Y='" + location_Y + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", scale='" + scale + '\'' +
                ", createTime='" + createTime + '\'' +
                ", label='" + label + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
