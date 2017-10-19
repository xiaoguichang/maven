package com.xiaogch.maven.wechat.common.message.dto;

import java.io.Serializable;

public class ReceivedMsgDto extends MsgDto implements Serializable {

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

    private String menuId;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

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

    private void copyToMsgDto(MsgDto dto) {
        dto.setCreateTime(createTime);
        dto.setFromUserName(fromUserName);
        dto.setMsgType(msgType);
        dto.setToUserName(toUserName);
    }

    public TextMsgDto toTextMsgDto() {
        if (MSGTYPE_TEXT.equalsIgnoreCase(msgType)) {
            TextMsgDto dto = new TextMsgDto();
            copyToMsgDto(dto);

            dto.setMsgId(Long.parseLong(msgId));
            dto.setContent(content);

            return dto;
        } else {
            return null;
        }
    }

    public ImageMsgDto toImageMsgDto() {
        if (MSGTYPE_IMAGE.equalsIgnoreCase(msgType)) {
            ImageMsgDto dto = new ImageMsgDto();
            copyToMsgDto(dto);

            dto.setMsgId(Long.parseLong(msgId));
            dto.setPicUrl(picUrl);
            dto.setMediaId(mediaId);

            return dto;
        } else {
            return null;
        }
    }

    public VoiceMsgDto toVoiceMsgDto() {
        if (MSGTYPE_VOICE.equalsIgnoreCase(msgType)) {
            VoiceMsgDto dto = new VoiceMsgDto();
            copyToMsgDto(dto);

            dto.setMsgId(Long.parseLong(msgId));
            dto.setMediaId(mediaId);
            dto.setFormat(format);
            dto.setRecognition(recognition);
            return dto;
        } else {
            return null;
        }
    }

    public VideoMsgDto toVideoMsgDto() {
        if (MSGTYPE_VIDEO.equalsIgnoreCase(msgType) || MSGTYPE_SHORTVIDEO.equalsIgnoreCase(msgType)) {
            VideoMsgDto dto = new VideoMsgDto();
            copyToMsgDto(dto);

            dto.setMsgId(Long.parseLong(msgId));
            dto.setMediaId(mediaId);
            dto.setThumbMediaId(thumbMediaId);

            return dto;
        } else {
            return null;
        }
    }

    public LocationMsgDto toLocationMsgDto() {
        if (MSGTYPE_LOCATION.equalsIgnoreCase(msgType)) {
            LocationMsgDto dto = new LocationMsgDto();
            copyToMsgDto(dto);

            dto.setMsgId(Long.parseLong(msgId));
            dto.setLabel(label);
            dto.setLocation_X(location_X);
            dto.setLocation_Y(location_Y);
            dto.setScale(scale);
            return dto;
        } else {
            return null;
        }
    }

    public LinkMsgDto toLinkMsgDto() {
        if (MSGTYPE_LINK.equalsIgnoreCase(msgType)) {
            LinkMsgDto dto = new LinkMsgDto();
            copyToMsgDto(dto);

            dto.setMsgId(Long.parseLong(msgId));
            dto.setUrl(url);
            dto.setDescription(description);
            dto.setTitle(title);
            return dto;
        } else {
            return null;
        }
    }


    public SubscribeEventMsgDto toSubscribeEventMsgDto() {
        if (MSGTYPE_EVENT.equalsIgnoreCase(msgType) && EVENT_SUBSCRIBE.equalsIgnoreCase(event)) {
            SubscribeEventMsgDto dto = new SubscribeEventMsgDto();
            copyToMsgDto(dto);
            dto.setEvent(event);
            if (eventKey != null) {
                dto.setEventKey(eventKey);
                dto.setTicket(ticket);
            }
            return dto;
        } else {
            return null;
        }

    }
    public UnSubscribeEventMsgDto toUnSubscribeEventMsgDto() {
        if (MSGTYPE_EVENT.equalsIgnoreCase(msgType) && EVENT_UNSUBSCRIBE.equalsIgnoreCase(event)) {
            UnSubscribeEventMsgDto dto = new UnSubscribeEventMsgDto();
            copyToMsgDto(dto);
            dto.setEvent(event);
            return dto;
        } else {
            return null;
        }

    }
    public ScanEventMsgDto toScanEventMsgDto() {
        if (MSGTYPE_EVENT.equalsIgnoreCase(msgType) && EVENT_SCAN.equalsIgnoreCase(event)) {
            ScanEventMsgDto dto = new ScanEventMsgDto();
            copyToMsgDto(dto);
            dto.setEvent(event);
            dto.setEventKey(eventKey);
            dto.setTicket(ticket);
            return dto;
        } else {
            return null;
        }

    }

    public ClickEventMsgDto toClickEventMsgDto() {
        if (MSGTYPE_EVENT.equalsIgnoreCase(msgType) && EVENT_CLICK.equalsIgnoreCase(event)) {
            ClickEventMsgDto dto = new ClickEventMsgDto();
            copyToMsgDto(dto);
            dto.setEvent(event);
            dto.setEventKey(eventKey);
            return dto;
        } else {
            return null;
        }
    }

    public ViewEventMsgDto toViewEventMsgDto() {
        if (MSGTYPE_EVENT.equalsIgnoreCase(msgType) && EVENT_VIEW.equalsIgnoreCase(event)) {
            ViewEventMsgDto dto = new ViewEventMsgDto();
            copyToMsgDto(dto);
            dto.setEvent(event);
            dto.setEventKey(eventKey);
            dto.setMenuId(menuId);
            return dto;
        } else {
            return null;
        }
    }

    public LocationEventMsgDto toLocationEventMsgDto() {
        if (MSGTYPE_EVENT.equalsIgnoreCase(msgType) && EVENT_LOCATION.equalsIgnoreCase(event)) {
            LocationEventMsgDto dto = new LocationEventMsgDto();
            copyToMsgDto(dto);
            dto.setEvent(event);
            dto.setLatitude(Double.parseDouble(latitude));
            dto.setLongitude(Double.parseDouble(longitude));
            dto.setPrecision(Double.parseDouble(precision));
            return dto;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "ReceivedMsgDto{" +
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
