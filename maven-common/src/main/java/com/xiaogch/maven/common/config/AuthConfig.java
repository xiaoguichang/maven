package com.xiaogch.maven.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.Serializable;

@Component
public class AuthConfig implements Serializable {

    @Value("${auth.session.userinfo:userInfo}")
    private String userInfo;
    @Value("${auth.nologin.privileges}")
    private String nologinPrivileges;

    @Value("${auth.common.privileges}")
    private String commonPrivileges;

    @Value("${auth.static.resources.reg}")
    private String regular;

    @Value("${auth.loginpage.path}")
    private String loginPagePath;

    @Value("${auth.websocket.path}")
    private String websocketPath;

    @Value("${auth.session.expiredTime:1800}")
    private int expiredTime;

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getNologinPrivileges() {
        return nologinPrivileges == null ? "" : nologinPrivileges;
    }

    public void setNologinPrivileges(String nologinPrivileges) {
        this.nologinPrivileges = nologinPrivileges;
    }

    public String getRegular() {
        Assert.notNull(regular , "auth.static.resources.reg can't be null !");
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getCommonPrivileges() {
        return commonPrivileges == null ? "" : commonPrivileges;
    }

    public void setCommonPrivileges(String commonPrivileges) {
        this.commonPrivileges = commonPrivileges;
    }

    public String getLoginPagePath() {
        Assert.notNull(loginPagePath , "auth.loginpage.path can't be null !");
        return loginPagePath;
    }

    public void setLoginPagePath(String loginPagePath) {
        this.loginPagePath = loginPagePath;
    }

    public int getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(int expiredTime) {
        this.expiredTime = expiredTime;
    }

    public String getWebsocketPath() {
        return websocketPath == null ? "" : websocketPath;
    }

    public void setWebsocketPath(String websocketPath) {
        this.websocketPath = websocketPath;
    }
}
