package com.xiaogch.maven.wechat.core.entity;

public class LocationEventMsgEntity extends MsgEntitiy {
    private String event;
    private Double latitude; //地理位置纬度
    private Double longitude; //地理位置经度
    private Double precision; //地理位置精度

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getPrecision() {
        return precision;
    }

    public void setPrecision(Double precision) {
        this.precision = precision;
    }

    @Override
    public String toString() {
        return "LocationEventMsgEntity{" +
                "event='" + event + '\'' +
                ", latitude=" + latitude +
                ", toUserName='" + toUserName + '\'' +
                ", longitude=" + longitude +
                ", fromUserName='" + fromUserName + '\'' +
                ", precision=" + precision +
                ", createTime='" + createTime + '\'' +
                ", msgType='" + msgType + '\'' +
                '}';
    }
}
