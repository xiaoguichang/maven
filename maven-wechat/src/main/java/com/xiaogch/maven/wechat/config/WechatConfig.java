package com.xiaogch.maven.wechat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Author: guich <BR>
 * Version: v 1.0 <BR>
 * Date: 2017/8/30 14:19 <BR>
 * Description: <BR>
 * Function List: <BR>
 */
@Service
public class WechatConfig {
    @Value("${wechat.appid}")
    private String appId;
    @Value("${wechat.token}")
    private String token;
    @Value("${wechat.secret}")
    private String secret;
    @Value("${wechat.domain}")
    private String domain;

    @Value("${wechat.tokenUrl}")
    private String tokenUrl;
    @Value("${wechat.ticketUrl}")
    private String ticketUrl;
    @Value("${wechat.authorizetokenUrl}")
    private String authorizetokenUrl;
    @Value("${wechat.userInfoUrl}")
    private String userInfoUrl;
    @Value("${wechat.authorizeUrl}")
    private String authorizeUrl;

    public String getAppId() {
        Assert.hasText(appId , "properties wechat.appid no set !");
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getToken() {
        Assert.hasText(token , "properties wechat.token no set !");
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSecret() {
        Assert.hasText(secret , "properties wechat.secret no set !");
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getTokenUrl() {
        Assert.hasText(tokenUrl , "properties wechat.tokenUrl no set !");
        return tokenUrl;
    }

    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    public String getDomain() {
        Assert.hasText(domain , "properties wechat.domain no set !");
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getTicketUrl() {
        Assert.hasText(ticketUrl , "properties wechat.ticketUrl no set !");
        return ticketUrl;
    }

    public void setTicketUrl(String ticketUrl) {
        this.ticketUrl = ticketUrl;
    }

    public String getAuthorizetokenUrl() {
        Assert.hasText(authorizetokenUrl , "properties wechat.authorizetokenUrl no set !");
        return authorizetokenUrl;
    }

    public void setAuthorizetokenUrl(String authorizetokenUrl) {
        this.authorizetokenUrl = authorizetokenUrl;
    }

    public String getUserInfoUrl() {
        Assert.hasText(userInfoUrl , "properties wechat.userInfoUrl no set !");
        return userInfoUrl;
    }

    public void setUserInfoUrl(String userInfoUrl) {
        this.userInfoUrl = userInfoUrl;
    }

    public String getAuthorizeUrl() {
        Assert.hasText(authorizeUrl , "properties wechat.authorizeUrl no set !");
        return authorizeUrl;
    }

    public void setAuthorizeUrl(String authorizeUrl) {
        this.authorizeUrl = authorizeUrl;
    }
}
