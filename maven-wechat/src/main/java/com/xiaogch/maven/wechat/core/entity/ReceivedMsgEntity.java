package com.xiaogch.maven.wechat.core.entity;

import java.io.Serializable;

public class ReceivedMsgEntity extends MsgEntitiy implements Serializable {

    private String msgId; //消息id，64位整型 ，事件类型

    private String event; //事件类型 subscribe ， unsubscribe ， scan

    private String mediaId; //媒体id，可以调用多媒体文件下载接口拉取数据

    /** 文本消息 **/
    private String content; //文本消息内容

    /** 图片消息 **/
    private String picUrl; //图片链接（由系统生成）

    /** 语音消息 **/
    private String format; //语音格式，如amr，speex等
    private String recognition; //语音识别结果，UTF8编码

    /** 视频消息 && 小视频消息 **/
    private String thumbMediaId; //

    /** 地理位置消息 **/
    private String location_X; //地理位置维度
    private String location_Y; //地理位置经度
    private String scale; //地图缩放大小
    private String label; //地理位置信息

    /** 链接消息 **/
    private String title; //消息标题
    private String description; //消息描述
    private String url; //消息链接

    /** 扫描二维码事件 **/

    private String eventKey; //事件KEY值
    private String ticket; //二维码的ticket，可用来换取二维码图片

    /** 上报地理位置事件 */
    private String latitude; //地理位置纬度
    private String longitude; //地理位置经度
    private String precision; //地理位置精度


    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }

    private void copyToMsgEntity(MsgEntitiy entity) {
        entity.setCreateTime(createTime);
        entity.setFromUserName(fromUserName);
        entity.setMsgType(msgType);
        entity.setToUserName(toUserName);
    }

    public TextMsgEntity toTextMsgEntity() {
        if (MsgConstant.MSGTYPE_TEXT.equalsIgnoreCase(msgType)) {
            TextMsgEntity entity = new TextMsgEntity();
            copyToMsgEntity(entity);

            entity.setMsgId(Long.parseLong(msgId));
            entity.setContent(content);

            return entity;
        } else {
            return null;
        }
    }

    public ImageMsgEntity toImageMsgEntity() {
        if (MsgConstant.MSGTYPE_IMAGE.equalsIgnoreCase(msgType)) {
            ImageMsgEntity entity = new ImageMsgEntity();
            copyToMsgEntity(entity);

            entity.setMsgId(Long.parseLong(msgId));
            entity.setPicUrl(picUrl);
            entity.setMediaId(mediaId);

            return entity;
        } else {
            return null;
        }
    }

    public VoiceMsgEntity toVoiceMsgEntity() {
        if (MsgConstant.MSGTYPE_VOICE.equalsIgnoreCase(msgType)) {
            VoiceMsgEntity entity = new VoiceMsgEntity();
            copyToMsgEntity(entity);

            entity.setMsgId(Long.parseLong(msgId));
            entity.setMediaId(mediaId);
            entity.setFormat(format);
            entity.setRecognition(recognition);
            return entity;
        } else {
            return null;
        }
    }

    public VideoMsgEntity toVideoMsgEntity() {
        if (MsgConstant.MSGTYPE_VIDEO.equalsIgnoreCase(msgType) || MsgConstant.MSGTYPE_SHORTVIDEO.equalsIgnoreCase(msgType)) {
            VideoMsgEntity entity = new VideoMsgEntity();
            copyToMsgEntity(entity);

            entity.setMsgId(Long.parseLong(msgId));
            entity.setMediaId(mediaId);
            entity.setThumbMediaId(thumbMediaId);

            return entity;
        } else {
            return null;
        }
    }

    public LocationMsgEntity toLocationMsgEntity() {
        if (MsgConstant.MSGTYPE_LOCATION.equalsIgnoreCase(msgType)) {
            LocationMsgEntity entity = new LocationMsgEntity();
            copyToMsgEntity(entity);

            entity.setMsgId(Long.parseLong(msgId));
            entity.setLabel(label);
            entity.setLocation_X(location_X);
            entity.setLocation_Y(location_Y);
            entity.setScale(scale);
            return entity;
        } else {
            return null;
        }
    }

    public LinkMsgEntity toLinkMsgEntity() {
        if (MsgConstant.MSGTYPE_LINK.equalsIgnoreCase(msgType)) {
            LinkMsgEntity entity = new LinkMsgEntity();
            copyToMsgEntity(entity);

            entity.setMsgId(Long.parseLong(msgId));
            entity.setUrl(url);
            entity.setDescription(description);
            entity.setTitle(title);
            return entity;
        } else {
            return null;
        }
    }


    public SubscribeEventMsgEntity toSubscribeEventMsgEntity() {
        if (MsgConstant.MSGTYPE_EVENT.equalsIgnoreCase(msgType) && MsgConstant.EVENT_SUBSCRIBE.equalsIgnoreCase(event)) {
            SubscribeEventMsgEntity entity = new SubscribeEventMsgEntity();
            copyToMsgEntity(entity);
            entity.setEvent(event);
            if (eventKey != null) {
                entity.setEventKey(eventKey);
                entity.setTicket(ticket);
            }
            return entity;
        } else {
            return null;
        }

    }
    public UnSubscribeEventMsgEntity toUnSubscribeEventMsgEntity() {
        if (MsgConstant.MSGTYPE_EVENT.equalsIgnoreCase(msgType) && MsgConstant.EVENT_UNSUBSCRIBE.equalsIgnoreCase(event)) {
            UnSubscribeEventMsgEntity entity = new UnSubscribeEventMsgEntity();
            copyToMsgEntity(entity);
            entity.setEvent(event);
            return entity;
        } else {
            return null;
        }

    }
    public ScanEventMsgEntity toScanEventMsgEntity() {
        if (MsgConstant.MSGTYPE_EVENT.equalsIgnoreCase(msgType) && MsgConstant.EVENT_SCAN.equalsIgnoreCase(event)) {
            ScanEventMsgEntity entity = new ScanEventMsgEntity();
            copyToMsgEntity(entity);
            entity.setEvent(event);
            entity.setEventKey(eventKey);
            entity.setTicket(ticket);
            return entity;
        } else {
            return null;
        }

    }

    public ClickEventMsgEntity toClickEventMsgEntity() {
        if (MsgConstant.MSGTYPE_EVENT.equalsIgnoreCase(msgType) && MsgConstant.EVENT_CLICK.equalsIgnoreCase(event)) {
            ClickEventMsgEntity entity = new ClickEventMsgEntity();
            copyToMsgEntity(entity);
            entity.setEvent(event);
            entity.setEventKey(eventKey);
            return entity;
        } else {
            return null;
        }
    }

    public ViewEventMsgEntity toViewEventMsgEntity() {
        if (MsgConstant.MSGTYPE_EVENT.equalsIgnoreCase(msgType) && MsgConstant.EVENT_VIEW.equalsIgnoreCase(event)) {
            ViewEventMsgEntity entity = new ViewEventMsgEntity();
            copyToMsgEntity(entity);
            entity.setEvent(event);
            entity.setEventKey(eventKey);
            return entity;
        } else {
            return null;
        }
    }

    public LocationEventMsgEntity toLocationEventMsgEntity() {
        if (MsgConstant.MSGTYPE_EVENT.equalsIgnoreCase(msgType) && MsgConstant.EVENT_LOCATION.equalsIgnoreCase(event)) {
            LocationEventMsgEntity entity = new LocationEventMsgEntity();
            copyToMsgEntity(entity);
            entity.setEvent(event);
            entity.setLatitude(Double.parseDouble(latitude));
            entity.setLongitude(Double.parseDouble(longitude));
            entity.setPrecision(Double.parseDouble(precision));
            return entity;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "ReceivedMsgEntity{" +
                "toUserName='" + toUserName + '\'' +
                ", msgId='" + msgId + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", event='" + event + '\'' +
                ", createTime='" + createTime + '\'' +
                ", mediaId='" + mediaId + '\'' +
                ", msgType='" + msgType + '\'' +
                ", content='" + content + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", format='" + format + '\'' +
                ", recognition='" + recognition + '\'' +
                ", thumbMediaId='" + thumbMediaId + '\'' +
                ", location_X='" + location_X + '\'' +
                ", location_Y='" + location_Y + '\'' +
                ", scale='" + scale + '\'' +
                ", label='" + label + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", eventKey='" + eventKey + '\'' +
                ", ticket='" + ticket + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", precision='" + precision + '\'' +
                '}';
    }
}
