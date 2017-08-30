package com.xiaogch.maven.wechat.core.service;

public interface AccessTokenService {

    /**
     * 获取微信AccessToken
     * @return 成功返回accessToken ， 失败返回 null
     */
    public String getAccessToken();
}
