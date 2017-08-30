package com.xiaogch.maven.wechat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ProjectName: maven <BR>
 * File name: com.xiaogch.maven.wechat.core <BR>
 * Author: guich <BR>
 * Project: maven <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/8/30 14:19 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
@Component
public class WeiXinConfig {
    @Value("${weixin.appId}")
    private String appId;
    @Value("${weixin.token}")
    private String token;
    @Value("${weixin.appSecret}")
    private String appSecret;
    @Value("${weixin.tokenUrl}")
    private String tokenUrl;
    @Value("${weixin.weiXinServerIpUrl}")
    private String weiXinServerIpUrl;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    public String getWeiXinServerIpUrl() {
        return weiXinServerIpUrl;
    }

    public void setWeiXinServerIpUrl(String weiXinServerIpUrl) {
        this.weiXinServerIpUrl = weiXinServerIpUrl;
    }
}
