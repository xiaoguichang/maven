package com.xiaogch.maven.wechat.core.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * ProjectName: maven <BR>
 * File name: com.xiaogch.maven.wechat.core.entity <BR>
 * Author: guich <BR>
 * Project: maven <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/8/30 12:46 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
public class AccessTokenEntitiy implements Serializable {

    private String appId;
    private String accessToken;
    private Integer expiresIn;
    private Long createTimestamp;
    private Long expireTimeStamp;

    LocalDateTime time;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Long getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Long getExpireTimeStamp() {
        return expireTimeStamp;
    }

    public void setExpireTimeStamp(Long expireTimeStamp) {
        this.expireTimeStamp = expireTimeStamp;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder sb = new StringBuilder("AccessTokenEntitiy{")
                .append("appId='").append(appId).append("' ")
                .append("accessToken='").append(accessToken).append("' ")
                .append("expiresIn='").append(expiresIn).append("' ")
                .append("createTimestamp='").append(createTimestamp).append("' ")
                .append("expireTimeStamp='").append(expireTimeStamp).append("' ")
                .append("createTime='").append(createTimestamp == null ? "" : simpleDateFormat.format(createTimestamp)).append("' ")
                .append("expireTime='").append(expireTimeStamp == null ? "" : simpleDateFormat.format(expireTimeStamp)).append("'}");
        return sb.toString();
    }

}